# CS 1103 Unit 4: Peer Responses

Author: Nicanor Maswili
Course: CS 1103 Programming 2

You need to post **2** replies by Wednesday (minimum 75 words each). Three drafts are provided
so you can pick the two that fit best. Each one engages the classmate's specific points, adds a
technical idea, answers their question, and ends with a question.

---

## Peer Response 1: to Muhammad Sabon-Kudi

Hi Muhammad,

Your post is well organized, and I liked the furniture room-planner idea because it shows
exactly the kind of interaction a static web page cannot give. Two small technical notes. First,
BufferedReader is a character stream, so for high-resolution images the buffered class to use
is BufferedInputStream; reading a JPEG through a Reader would try to decode it as text and damage
the file (Eck, 2022). Second, I would be careful calling the applet sandbox a security layer for
payments. The sandbox protected the shopper's computer from the applet, but it did nothing to
protect card details in transit, which depends on encrypted HTTPS connections. To answer your
question, I think Java keeps its place on the server: byte streams read product images and videos
in chunks and send them to the browser, while the interactive layer is rebuilt with JavaScript
or WebAssembly on the client. Do you think it is worth keeping any Java code on the client side
at all today?

Best,
Nicanor

Reference:
Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Hobart and
William Smith Colleges. https://math.hws.edu/javanotes/c11/s1.html

---

## Peer Response 2: to Jelina Lesaffre

Hi Jelina,

Your point about object streams stood out to me. Most posts just list ObjectOutputStream as an
option, but you noticed from the reading that its binary format is specific to Java, which makes
it a poor choice for data other systems need to read (Eck, 2022). To answer your question, I think
streams and interactive components work best as a pipeline. The server uses a byte stream to send
the image, and the interactive component reads it through a URL input stream and displays it. In
modern JavaFX, the Image class can even load a picture in the background, so a product viewer
stays responsive while a large photo is still arriving (OpenJFX, n.d.). The customer can start
rotating or zooming the first images while the rest stream in. For a store with many product
photos, would you load every angle up front, or only fetch each image when the customer asks for
it?

Best,
Nicanor

Reference:
OpenJFX. (n.d.). *Class Image* (JavaFX 21 API documentation).
https://openjfx.io/javadoc/21/javafx.graphics/javafx/scene/image/Image.html

---

## Peer Response 3: to Jagot Chakma

Hi Jagot,

This is a very thorough post. I especially liked that you cited the specific subsections of Eck
and caught the ObjectOutputStream detail that a modified object is not saved again unless the
stream is reset, which is easy to miss and would cause a real bug in a saved-cart feature. To
answer your question, I think the init, start, stop, destroy life cycle is still worth learning,
because the same pattern shows up in tools we would actually use today. A JavaFX application is
run by calling init(), then start(), and finally stop() when it closes (OpenJFX, n.d.), and
Android activities follow a similar create, start, stop, and destroy sequence. Once you
understand why an applet paused its animation in stop(), you understand why a phone app should
release the camera when it goes into the background. Do you think the course should teach these
life cycle ideas through JavaFX instead of applets, since JavaFX can still run today?

Best,
Nicanor

Reference:
OpenJFX. (n.d.). *Class Application* (JavaFX 21 API documentation).
https://openjfx.io/javadoc/21/javafx.graphics/javafx/application/Application.html
