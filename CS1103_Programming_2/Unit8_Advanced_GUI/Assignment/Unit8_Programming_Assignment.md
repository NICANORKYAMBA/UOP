# Programming Assignment Unit 8: Weather Information App

**Course:** CS 1103 Programming 2
**Student:** Nicanor Maswili
**Instructor:** Dr. Abeena Azad
**Due:** October 28, 2026

## Overview

The Weather Information App is a Java Swing desktop program that shows real-time weather for any
city or pair of coordinates. It fetches live data from the Open-Meteo weather API and displays the
temperature, humidity, wind speed, and conditions with a drawn weather icon, a five-day forecast,
and the local time at the searched place. The user can switch between Celsius and Fahrenheit and
between three wind speed units, see a timestamped history of recent searches, and watch the
background change with the time of day at that place. Every kind of error, from an empty search
box to a lost internet connection, produces a clear message instead of a crash.

Like every GUI program, the app is event-driven: it waits for the user to click, type, or choose,
and responds to each event as it happens (Eck, 2022, Chapter 6).

## Requirements Checklist

**Table 1**

*Assignment Requirements and Where They Are Met*

| Requirement | How the app meets it | Shown in |
|---|---|---|
| API integration | Open-Meteo Geocoding and Forecast APIs over HTTPS with java.net.http.HttpClient | Figures 2 to 5; live tests |
| GUI design | Swing window with a search bar, unit lists, weather area, forecast row, history list, and status bar | Figure 2 |
| Location input | Text field for a city name or "latitude, longitude"; Enter or Search starts the search | Figures 2 and 5 |
| Weather information | Temperature, humidity, wind speed, conditions, and local time | Figure 2 |
| Icons | Sun, moon, clouds, rain, snow, fog, and lightning drawn with Java 2D for each WMO weather code | Figures 2 to 4 |
| Forecast | Five-day forecast with an icon, high and low temperatures, and conditions per day | Figures 2 to 5 |
| Unit conversion | °C or °F; km/h, m/s, or mph; switches instantly, including the history | Figure 4 |
| Error handling | Empty input, invalid coordinates, unknown places, network failures, timeouts, API errors | Figure 6 |
| History tracking | Ten most recent searches, newest first, each with a timestamp; double-click to repeat | Figure 4 |
| Dynamic backgrounds | Morning, daytime, evening (sunset), and night gradients based on the place's local time | Figure 3 |
| Well-commented code and README | Javadoc on every class, method, and field; README.md and README.txt | Source Code; README section |

## Design

The program is split into three layers, following the Model-View-Controller idea that Eck (2022,
Section 13.3) describes: the model holds the data, the view presents it, and the controller
responds to the user's actions. Figure 1 shows the classes in each layer.

**Figure 1**

*Classes and How They Work Together*

[FIGURE figures/fig1_classes.png]

**Table 2**

*Classes in the Program*

| Layer | Class | Role |
|---|---|---|
| View and controller | WeatherApp | The window, its components, and the event handlers |
| View | WeatherIcon, TimeOfDay | Weather pictures and background colours |
| Model | Location, CurrentWeather, DailyForecast, WeatherReport | Records holding the weather data |
| Model | TemperatureUnit, WindSpeedUnit, WeatherCodes, SearchHistory | Conversions, code descriptions, and the history |
| Data access | WeatherService, Json, WeatherException | API calls, JSON parsing, and user-facing errors |
| Testing | WeatherAppTest | 26 offline checks and 3 live checks |

### API Integration

A search makes two HTTPS requests to Open-Meteo, using Java's built-in HttpClient, which sends
requests and receives responses with configurable timeouts (Oracle, n.d.-a):

1. **Geocoding.** The Geocoding API turns a place name into coordinates (Open-Meteo, n.d.-a). For
   "Nairobi" it returns Nairobi, Nairobi County, Kenya at latitude -1.28333 and longitude
   36.81667. If the user typed coordinates instead, this step is skipped.
2. **Forecast.** The Forecast API returns the current temperature, relative humidity, wind speed,
   WMO weather code, and day or night flag, plus the daily weather code and high and low
   temperatures for five days. The request uses timezone=auto, so the times come back in the
   place's local time, which the dynamic background needs (Open-Meteo, n.d.-d).

```
https://api.open-meteo.com/v1/forecast?latitude=-1.2833&longitude=36.8167
    &current=temperature_2m,relative_humidity_2m,wind_speed_10m,weather_code,is_day
    &daily=weather_code,temperature_2m_max,temperature_2m_min
    &timezone=auto&forecast_days=5
```

The API returns JSON. Java has no built-in JSON parser, so the app includes a small one (Json.java)
and reads each field into records, checking that every required field is present.

**API key and usage guidelines.** The rubric asks for appropriate use of an API key and
adherence to the API's guidelines. Open-Meteo's free API needs no key for non-commercial use, but
it limits each user to fewer than 10,000 calls per day, 5,000 per hour, and 600 per minute, and
licenses its data under CC BY 4.0 (Open-Meteo, n.d.-c). Paying customers get a key and use a
separate customer endpoint, where the only differences are the domain and the apikey parameter
(Open-Meteo, n.d.-b). The app handles both correctly:

- It credits "Weather data by Open-Meteo.com (CC BY 4.0)" in the status bar.
- It caches each place's report for 10 minutes, so repeated searches and history clicks do not
  spend extra calls.
- Every request has a connection timeout and a 15-second response timeout, and identifies the
  app with a User-Agent header.
- If the environment variable OPEN_METEO_API_KEY is set, it switches to the customer endpoint
  and sends the key. The key is read from the environment and never written into the source code,
  so it cannot leak through the submitted files.

### GUI Design

The window uses a BorderLayout: the search bar at the top, the weather area in the centre, the
history list on the right, and the status bar at the bottom. Layout managers arrange components
the same way on every operating system (Chua, n.d.), and BorderLayout's north, south, east, west,
and centre regions match this design directly (Morelli & Walde, n.d.). Inside the regions, a
FlowLayout holds the search controls, a GridLayout lays out the five forecast cards evenly, and a
BoxLayout stacks the current weather details.

Several choices make the interface easy to use:

- **One obvious action.** The Search button is the default button, so pressing Enter in the text
  field searches, and Alt+S also works.
- **Readable on any background.** The search bar, cards, and status bar are light, rounded panels,
  and the large labels switch to white text on the dark evening and night backgrounds.
- **Clear feedback.** While a search runs, the button is disabled and the status bar says
  "Searching for ...". Errors appear in red in the same place, and the last good result stays on
  screen.
- **Tooltips and hints.** The text field explains the accepted formats, and each forecast icon
  has a tooltip with its conditions.

**A responsive window.** Swing event handling runs on a single event dispatch thread, and most
Swing methods are not thread-safe (Oracle, n.d.-b). A network request on that thread would
freeze the window, so each search runs in a SwingWorker, a background worker thread whose done()
method is called back on the event dispatch thread to update the screen safely (Oracle, n.d.-c).
The Search button follows Java's event model: the button generates an ActionEvent, and the
listener registered with it responds (Morelli & Walde, n.d.).

### Logic: How One Search Works

1. The user types "Tokyo" and presses Enter. The Search button's action listener calls
   startSearch().
2. The button is disabled and a SwingWorker starts. On the background thread,
   WeatherService.findLocation() checks the input, then asks the Geocoding API for coordinates.
3. WeatherService.fetchReport() checks the cache. If there is no recent copy, it requests the
   forecast and parses it into a WeatherReport.
4. Back on the event dispatch thread, done() shows the report: the icon, temperature, conditions,
   details, local time, and forecast cards, all in the selected units.
5. The search is added to the history with a timestamp, and the background is set from the local
   hour (17:45 in Tokyo, so the evening sunset colours appear).
6. If any step fails, the WeatherException's message appears in red in the status bar.

### Unit Conversion

The API always sends Celsius and kilometres per hour. The app keeps the original values and
converts only for display, so switching units is instant and needs no new request.

**Table 3**

*Unit Conversions*

| Conversion | Formula | Check (from the tests) |
|---|---|---|
| Celsius to Fahrenheit | °F = °C × 9/5 + 32 | 0 °C = 32 °F, 100 °C = 212 °F, -40 °C = -40 °F |
| km/h to m/s | m/s = km/h × 1000 / 3600 | 36 km/h = 10.0 m/s |
| km/h to mph | mph = km/h ÷ 1.609344 | 36 km/h = 22.4 mph |

### Error Handling

**Table 4**

*Error Cases and the Messages Shown*

| Situation | Message in the status bar |
|---|---|
| Empty search box | Please type a city name or coordinates (latitude, longitude). |
| Coordinates off the Earth, such as "200, 10" | Coordinates must be latitude -90 to 90 and longitude -180 to 180. |
| Unknown or misspelled place | No place called "Nairobbbii" was found. Check the spelling, or add the country, e.g. "Paris, France". |
| No internet connection | Could not reach the weather service. Please check your internet connection. |
| The server is too slow | The weather service took too long to answer. Please try again. |
| HTTP 429 (too many requests) | Too many requests to the weather service. Please wait a minute and try again. |
| Other API error | The weather service rejected the request: (the API's own reason) |
| Missing or malformed data | The weather service sent data that could not be read. |

All of these are thrown as a checked WeatherException, so the compiler makes sure every caller
handles them, and none of them ever reaches the user as a stack trace.

### History and Dynamic Backgrounds

**History.** SearchHistory keeps the ten most recent searches, newest first. Searching for the
same place again moves it to the top instead of listing it twice. Each entry stores the
temperature in Celsius, so the history also switches when the user changes units.

**Dynamic backgrounds.** The background is a vertical gradient chosen from the local hour at the
searched place, not the user's own clock, so searching Los Angeles from Nairobi shows night.

**Table 5**

*Background for Each Time of Day*

| Local time | Part of day | Background |
|---|---|---|
| 05:00 to 10:59 | Morning | Peach sunrise to light blue |
| 11:00 to 16:59 | Daytime | Bright blue sky |
| 17:00 to 19:59 | Evening | Orange sunset to purple |
| 20:00 to 04:59 | Night | Dark navy, with light text and a moon icon for clear skies |

## Testing

WeatherAppTest runs 26 checks offline, using a real Open-Meteo response saved in the test, so the
results never depend on today's weather. With --live, it adds three checks against the real API.
All 29 pass, and the program compiles with javac -Xlint:all -Xdoclint:all with no warnings.

```
PASS  JSON parser reads objects, arrays, numbers, escapes, true, and null
PASS  JSON parser rejects invalid text
PASS  geocoding response gives name, region, country, and coordinates
PASS  current weather: temperature, humidity, wind, and conditions are read
PASS  local time at the place is read for the dynamic background
PASS  forecast has five days with dates, codes, highs, and lows
PASS  typed coordinates are recognized without a geocoding request
PASS  a normal city name is not mistaken for coordinates
PASS  empty input is rejected with a helpful message
PASS  coordinates off the Earth are rejected
PASS  an unknown place gives a 'not found' message with a tip
PASS  an API error shows the API's own reason
PASS  too many requests (HTTP 429) asks the user to wait
PASS  a response with missing fields is reported, not crashed on
PASS  a response that is not JSON is reported clearly
PASS  Celsius to Fahrenheit: 0 -> 32, 100 -> 212, -40 -> -40
PASS  temperatures are formatted with the unit symbol
PASS  wind: 36 km/h = 10.0 m/s = 22.4 mph
PASS  WMO codes give the documented descriptions
PASS  each kind of weather gets a matching icon
PASS  hours map to morning, day, evening (sunset), and night
PASS  evening and night use light text for contrast
PASS  history keeps only the 10 most recent searches, newest first
PASS  searching a place again moves it to the top instead of duplicating it
PASS  history entries show a timestamp
PASS  history temperatures can be shown in the unit chosen later
PASS  LIVE: London is found and real weather is returned
PASS  LIVE: a second request within 10 minutes is served from the cache
PASS  LIVE: an unknown place gives the 'not found' message

Tests passed: 29, failed: 0
```

## Screenshots of the GUI

All screenshots are from the running program with live data on October 23, 2026, between 11:55
and 11:57 East Africa Time.

**Figure 2**

*Main Window: Current Weather, Icon, Details, and 5-Day Forecast for Nairobi*

[FIGURE figures/fig2_main_window.png]

**Figure 3**

*Dynamic Backgrounds for the Local Time of Day at Four Cities*

[FIGURE figures/fig3_dynamic_backgrounds.png]

**Figure 4**

*Units Switched to °F and mph, With the Full Search History (Including a Coordinates Search)*

[FIGURE figures/fig4_units_history.png]

**Figure 5**

*Searching by Coordinates (-33.87, 151.21) at Evening Local Time*

[FIGURE figures/fig5_coordinates.png]

**Figure 6**

*Error Messages: Unknown Place, Empty Input, and No Connection to the Weather Service*

[FIGURE figures/fig6_error_messages.png]

## README: How to Use and Run the App

The README file submitted with the code contains these instructions and the implementation
details above.

```
Run (Java 17 or newer, from the Assignment folder):
    javac -d out src/*.java
    java -cp out WeatherApp
Tests:
    java -cp out WeatherAppTest          (offline)
    java -cp out WeatherAppTest --live   (also calls the real API)

Use:
 1. Type a city (Nairobi, Paris, France) or coordinates (-1.29, 36.82).
 2. Press Enter or click Search.
 3. Change Temperature (°C/°F) or Wind (km/h, m/s, mph) at any time.
 4. Double-click a recent search on the right to repeat it.
 5. Red messages in the status bar explain any problem.
Optional: set OPEN_METEO_API_KEY to use a paid Open-Meteo key.
```

## Source Code

[CODE src/WeatherApp.java]

[CODE src/WeatherService.java]

[CODE src/Json.java]

[CODE src/Location.java]

[CODE src/CurrentWeather.java]

[CODE src/DailyForecast.java]

[CODE src/WeatherReport.java]

[CODE src/WeatherCodes.java]

[CODE src/WeatherIcon.java]

[CODE src/TemperatureUnit.java]

[CODE src/WindSpeedUnit.java]

[CODE src/TimeOfDay.java]

[CODE src/SearchHistory.java]

[CODE src/WeatherException.java]

[CODE src/WeatherAppTest.java]

## References

Chua, E. H. (n.d.). *Java programming tutorial: Programming graphical user interface (GUI)*.
Nanyang Technological University. https://www3.ntu.edu.sg/home/ehchua/programming/java/J4a_GUI.html

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Hobart and
William Smith Colleges. https://math.hws.edu/javanotes/

Morelli, R., & Walde, R. (n.d.). Chapter 13: Graphical user interfaces. In *Java, Java, Java:
Object-oriented programming*. LibreTexts Engineering.
https://eng.libretexts.org/Bookshelves/Computer_Science/Programming_Languages/Java_Java_Java_-_Object-Oriented_Programming_(Morelli_and_Walde)/13%3A_Graphical_User_Interfaces

Open-Meteo. (n.d.-a). *Geocoding API*. https://open-meteo.com/en/docs/geocoding-api

Open-Meteo. (n.d.-b). *Pricing*. https://open-meteo.com/en/pricing

Open-Meteo. (n.d.-c). *Terms of use*. https://open-meteo.com/en/terms

Open-Meteo. (n.d.-d). *Weather forecast API*. https://open-meteo.com/en/docs

Oracle. (n.d.-a). *Class HttpClient*. Java SE 21 & JDK 21 API documentation.
https://docs.oracle.com/en/java/javase/21/docs/api/java.net.http/java/net/http/HttpClient.html

Oracle. (n.d.-b). *The event dispatch thread*. The Java Tutorials.
https://docs.oracle.com/javase/tutorial/uiswing/concurrency/dispatch.html

Oracle. (n.d.-c). *Worker threads and SwingWorker*. The Java Tutorials.
https://docs.oracle.com/javase/tutorial/uiswing/concurrency/worker.html
