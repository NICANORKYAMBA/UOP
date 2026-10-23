import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A small JSON parser, so the app needs no external libraries.
 *
 * <p>It turns JSON text into plain Java objects: objects become {@code Map<String, Object>},
 * arrays become {@code List<Object>}, numbers become {@code Double}, and true, false, and null
 * become {@code Boolean} and {@code null}. It supports everything the Open-Meteo API returns.
 */
public final class Json {

    /** The text being parsed. */
    private final String text;

    /** Position of the next character to read. */
    private int pos;

    /**
     * Creates a parser for one JSON document.
     *
     * @param text the JSON text
     */
    private Json(String text) {
        this.text = text;
    }

    /**
     * Parses a complete JSON document.
     *
     * @param text the JSON text
     * @return the parsed value (Map, List, String, Double, Boolean, or null)
     * @throws IllegalArgumentException if the text is not valid JSON
     */
    public static Object parse(String text) {
        Json parser = new Json(text);
        Object value = parser.readValue();
        parser.skipSpaces();
        if (parser.pos != text.length()) {
            throw parser.error("unexpected text after the end of the document");
        }
        return value;
    }

    /**
     * Reads one value of any type at the current position.
     *
     * @return the value read
     */
    private Object readValue() {
        skipSpaces();
        if (pos >= text.length()) {
            throw error("unexpected end of text");
        }
        char c = text.charAt(pos);
        return switch (c) {
            case '{' -> readObject();
            case '[' -> readArray();
            case '"' -> readString();
            case 't' -> readWord("true", Boolean.TRUE);
            case 'f' -> readWord("false", Boolean.FALSE);
            case 'n' -> readWord("null", null);
            default -> readNumber();
        };
    }

    /**
     * Reads an object such as {"a": 1}.
     *
     * @return the object as an ordered map
     */
    private Map<String, Object> readObject() {
        Map<String, Object> map = new LinkedHashMap<>();
        pos++; // skip {
        skipSpaces();
        if (peek() == '}') {
            pos++;
            return map;
        }
        while (true) {
            skipSpaces();
            String key = readString();
            skipSpaces();
            expect(':');
            map.put(key, readValue());
            skipSpaces();
            if (peek() == ',') {
                pos++;
            } else {
                expect('}');
                return map;
            }
        }
    }

    /**
     * Reads an array such as [1, 2, 3].
     *
     * @return the array as a list
     */
    private List<Object> readArray() {
        List<Object> list = new ArrayList<>();
        pos++; // skip [
        skipSpaces();
        if (peek() == ']') {
            pos++;
            return list;
        }
        while (true) {
            list.add(readValue());
            skipSpaces();
            if (peek() == ',') {
                pos++;
            } else {
                expect(']');
                return list;
            }
        }
    }

    /**
     * Reads a string, including escape sequences such as \" and °.
     *
     * @return the string without its quotes
     */
    private String readString() {
        expect('"');
        StringBuilder sb = new StringBuilder();
        while (pos < text.length()) {
            char c = text.charAt(pos++);
            if (c == '"') {
                return sb.toString();
            }
            if (c != '\\') {
                sb.append(c);
                continue;
            }
            if (pos >= text.length()) {
                break;
            }
            char esc = text.charAt(pos++);
            switch (esc) {
                case 'n' -> sb.append('\n');
                case 't' -> sb.append('\t');
                case 'r' -> sb.append('\r');
                case 'b' -> sb.append('\b');
                case 'f' -> sb.append('\f');
                case 'u' -> {
                    if (pos + 4 > text.length()) {
                        throw error("incomplete \\u escape");
                    }
                    sb.append((char) Integer.parseInt(text.substring(pos, pos + 4), 16));
                    pos += 4;
                }
                default -> sb.append(esc); // covers \" \\ and \/
            }
        }
        throw error("string is not closed");
    }

    /**
     * Reads a number such as -12.5 or 3e2.
     *
     * @return the number as a Double
     */
    private Double readNumber() {
        int start = pos;
        while (pos < text.length() && "+-0123456789.eE".indexOf(text.charAt(pos)) >= 0) {
            pos++;
        }
        if (start == pos) {
            throw error("unexpected character '" + text.charAt(pos) + "'");
        }
        try {
            return Double.valueOf(text.substring(start, pos));
        } catch (NumberFormatException e) {
            throw error("invalid number");
        }
    }

    /**
     * Reads one of the fixed words true, false, or null.
     *
     * @param word  the expected word
     * @param value the value it stands for
     * @return the value
     */
    private Object readWord(String word, Object value) {
        if (!text.startsWith(word, pos)) {
            throw error("expected " + word);
        }
        pos += word.length();
        return value;
    }

    /** Moves past spaces, tabs, and line breaks. */
    private void skipSpaces() {
        while (pos < text.length() && Character.isWhitespace(text.charAt(pos))) {
            pos++;
        }
    }

    /**
     * Returns the next character without consuming it.
     *
     * @return the next character, or 0 at the end of the text
     */
    private char peek() {
        return pos < text.length() ? text.charAt(pos) : 0;
    }

    /**
     * Consumes the given character or fails.
     *
     * @param c the character that must come next
     */
    private void expect(char c) {
        if (peek() != c) {
            throw error("expected '" + c + "'");
        }
        pos++;
    }

    /**
     * Builds an error that says where the problem is.
     *
     * @param message what went wrong
     * @return the exception to throw
     */
    private IllegalArgumentException error(String message) {
        return new IllegalArgumentException("Invalid JSON at position " + pos + ": " + message);
    }
}
