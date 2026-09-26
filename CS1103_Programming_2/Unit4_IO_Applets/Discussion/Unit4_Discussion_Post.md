# Streams and Applets for a Multimedia Storefront

**Course:** CS 1103 Programming 2
**Student:** Nicanor Maswili
**Due:** September 30, 2026

An online store lives or dies by its media: product photos, short videos, and reviews all
move between a disk, a server, and a browser. In Java, that movement is handled by I/O
streams, and the interactive layer on top was historically the job of applets.

## Managing Multimedia Data With Java I/O Streams

Java has two families of streams: byte streams (InputStream and OutputStream subclasses) for
machine-formatted binary data, and character streams (Reader and Writer subclasses) for
human-readable text (Eck, 2022; SimpliCode, 2021).

**Images, video, and audio use byte streams.** A JPEG or MP4 file is raw binary, so passing
it through a Reader would try to decode the bytes as characters and corrupt the file. When a
seller uploads a product photo, the server reads the incoming request as an InputStream and
writes it to disk with a FileOutputStream. Buffered wrappers move data in large blocks instead of
one byte at a time, cutting slow disk and network operations. Try-with-resources guarantees the files are closed even if the upload fails
halfway:

```java
try (InputStream in = new BufferedInputStream(upload.getInputStream());
     OutputStream out = new BufferedOutputStream(
             new FileOutputStream("images/" + productId + ".jpg"))) {
    byte[] buffer = new byte[8192];
    int count;
    while ((count = in.read(buffer)) != -1) {
        out.write(buffer, 0, count);   // copy one 8 KB block at a time
    }
}
```

The same loop runs in reverse when a shopper opens a product page, reading the file with a
FileInputStream into the response's OutputStream. For videos,
streaming means the file never has to fit in memory: it is sent in chunks, so playback starts
while the rest is still arriving. Thumbnails
fit the same pattern: ImageIO.read(InputStream) turns the uploaded bytes into an image, the
program scales it down, and ImageIO.write sends the small version to another OutputStream.

**Text data uses character streams.** Product descriptions, reviews, and CSV catalog imports are
human-readable, so they belong in a BufferedReader and PrintWriter (Keep On Coding, 2020). I
would always set the encoding to UTF-8, since Eck (2022) notes that Readers and Writers
handle the translation between Java's Unicode characters and the bytes in a file, including
non-English text. That way a review mentioning "crème brûlée" or a product name in Swahili
survives the trip to disk and back. Every stream operation can throw an IOException, so each
is wrapped in handling that shows the user a clear message instead of a broken page.

## Where Applets Could Make Shopping More Interactive

An applet is a Java program that runs inside a web page instead of through a main method,
controlled by the life cycle methods init(), start(), stop(), destroy(), and paint()
(Udemy Editor, n.d.-a, n.d.-b). That life cycle maps neatly onto interactive shopping features:

- **360-degree product viewer.** init() loads a set of photos taken around the product, and
  mouse-drag events call repaint() so paint() shows the next angle, letting shoppers "turn" a
  shoe or a laptop in their hands.
- **Zoom magnifier.** Hovering over a photo draws an enlarged region in a lens, so fabric
  texture or stitching is visible without leaving the page.
- **Live product customizer.** Choosing a color, size, or engraving redraws the preview and
  updates the price instantly, with no page reload.
- **Animated promotions.** A banner slideshow runs on a thread started in start() and paused
  in stop() when the shopper scrolls away or switches tabs, so the animation never wastes CPU
  in the background (Udemy Editor, n.d.-b).

Applets also run in a security sandbox, and an unsigned applet cannot read the user's files
(Udemy Editor, n.d.-a), which reassures shoppers that a product viewer cannot snoop on their
computer.

One honest caveat matters for a real team. The Applet API was deprecated in Java 9 and marked
for removal in Java 17, because every major browser has dropped the Java plug-in (OpenJDK,
2021). In production we would build these same features with JavaFX or HTML5 and JavaScript.
Still, the ideas applets teach, such as an event-driven life cycle, repainting on input, and
pausing hidden work, carry straight over.

**Question for the class:** An unsigned applet can only open network connections back to the
server it came from. If you were streaming a set of 36 high-resolution images for a 360-degree
viewer, would you send them as one large byte stream or as separate requests, and how would
you keep the viewer usable while the images are still loading?

Word count: 729

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Hobart
and William Smith Colleges. https://math.hws.edu/javanotes/c11/s1.html

Keep On Coding. (2020, July 21). *Java file I/O (reading & writing)* [Video]. YouTube.
https://www.youtube.com/watch?v=hgF21imQ_Is

OpenJDK. (2021). *JEP 398: Deprecate the Applet API for removal*.
https://openjdk.org/jeps/398

SimpliCode. (2021, February 8). *Java tutorial for beginners | Input & output streams in Java |
IO streams in Java | SimpliCode* [Video]. YouTube. https://www.youtube.com/watch?v=e3dFoA4-tqs

Udemy Editor. (n.d.-a). *Java applet tutorial: Learning the basics*. Udemy Blog.
https://blog.udemy.com/java-applet-tutorial/

Udemy Editor. (n.d.-b). *Java applet life cycle: An overview*. Udemy Blog.
https://blog.udemy.com/applet-life-cycle/
