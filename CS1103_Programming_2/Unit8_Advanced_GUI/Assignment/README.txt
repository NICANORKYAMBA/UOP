# Weather Information App (CS 1103 Unit 8)

Author: Nicanor Maswili

A Java Swing desktop app that shows real-time weather for any city or coordinates, with a
five-day forecast, weather icons, unit conversion, error messages, a timestamped search
history, and a background that changes with the local time of day at the searched place.

## Requirements

- Java 17 or newer (the code uses records, switch expressions, and pattern matching).
- An internet connection. No external libraries are needed.
- No API key is needed: the app uses the free Open-Meteo API (see "API key" below).

## How to Run

From the Assignment folder:

    javac -d out src/*.java
    java -cp out WeatherApp

In IntelliJ IDEA: open the Assignment folder as a project, right-click WeatherApp, and choose Run.

To run the automated tests (26 offline checks, plus 3 that call the real API with --live):

    java -cp out WeatherAppTest
    java -cp out WeatherAppTest --live

## How to Use the App

1. Type a city name in the box at the top, for example `Nairobi` or `Paris, France`. You can
   also type coordinates as `latitude, longitude`, for example `-1.29, 36.82`.
2. Press Enter or click Search (Alt+S). The window stays responsive while it searches.
3. Read the current weather: an icon, the temperature, the conditions, humidity, wind speed,
   and the local time at that place.
4. Read the 5-day forecast along the bottom: each day has an icon, high and low temperatures,
   and the conditions.
5. Change the units at any time with the Temperature (°C or °F) and Wind (km/h, m/s, mph)
   lists. Everything on screen, including the history, switches at once without a new request.
6. See your recent searches on the right, newest first, each with the time you searched.
   Double-click an entry (or select it and press Enter) to search again.
7. Watch the background: it shows morning, daytime, evening (sunset), or night colours for the
   local time at the place you searched. At night the clear-sky icon becomes a moon.
8. If something goes wrong (empty box, misspelled city, no internet, or an API error), a red
   message in the status bar explains what happened. The last good result stays on screen.

## Implementation Details

| File | Purpose |
|---|---|
| WeatherApp.java | The Swing window: search bar, unit lists, current weather, forecast row, history list, status bar, dynamic gradient background |
| WeatherService.java | Calls the Open-Meteo Geocoding and Forecast APIs with java.net.http.HttpClient; validates input; caches results; turns every failure into a WeatherException with a clear message |
| Json.java | A small JSON parser, so no external library is needed |
| Location, CurrentWeather, DailyForecast, WeatherReport | Records that hold the weather data |
| WeatherCodes.java | Turns WMO weather codes into descriptions and icon types |
| WeatherIcon.java | Draws sun, moon, clouds, rain, snow, fog, and lightning with Java 2D |
| TemperatureUnit.java, WindSpeedUnit.java | Unit choices and conversions |
| TimeOfDay.java | Morning, day, evening, and night background colours |
| SearchHistory.java | The 10 most recent searches with timestamps |
| WeatherException.java | A checked exception whose message is shown to the user |
| WeatherAppTest.java | Automated checks |

- **API integration.** A search first calls the Geocoding API
  (`geocoding-api.open-meteo.com/v1/search`) to turn the place name into coordinates, then the
  Forecast API (`api.open-meteo.com/v1/forecast`) for current temperature, humidity, wind speed,
  weather code, day or night, and a 5-day daily forecast, in the place's own time zone.
- **Responsive GUI.** Network calls run in a `SwingWorker` background thread; the results are
  shown on the Swing event dispatch thread in `done()`.
- **Units.** The API always returns °C and km/h. The app converts locally (°F = °C × 9/5 + 32;
  m/s = km/h ÷ 3.6; mph = km/h ÷ 1.609344), so switching units never needs another request.
- **Error handling.** Empty input, coordinates out of range, unknown places, timeouts, no
  connection, HTTP errors (using the API's own `reason` text), rate limiting (HTTP 429), and
  malformed data each produce a specific message. The app never crashes on bad input.

## API Key and Usage Guidelines

Open-Meteo's free API needs no key for non-commercial use, within 10,000 calls per day, 5,000
per hour, and 600 per minute, and its data is licensed CC BY 4.0. The app follows these terms:

- It credits "Weather data by Open-Meteo.com (CC BY 4.0)" in the status bar.
- It caches each place's report for 10 minutes, so repeated searches do not call the API again.
- Every request has a timeout and identifies the app with a User-Agent header.
- **API key support:** if you have a paid Open-Meteo plan, set the environment variable
  `OPEN_METEO_API_KEY` before starting the app. The app then uses the customer endpoint
  (`customer-api.open-meteo.com`) and sends the key. The key is read from the environment, never
  written into the source code, and the status bar shows "customer API" so you can confirm it.
