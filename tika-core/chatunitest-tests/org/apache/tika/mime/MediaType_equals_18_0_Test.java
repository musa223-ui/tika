package org.apache.tika.mime;

import org.junit.jupiter.api.function.Executable;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.SortedMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MediaType_equals_18_0_Test {

    @Test
    public void testEquals() {
        MediaType mediaType1 = MediaType.parse("text/plain");
        MediaType mediaType2 = MediaType.parse("text/plain");
        MediaType mediaType3 = MediaType.parse("text/html");
        assertTrue(mediaType1.equals(mediaType2));
        assertFalse(mediaType1.equals(mediaType3));
        assertFalse(mediaType1.equals(null));
        assertFalse(mediaType1.equals(new Object()));
    }

    @Test
    public void testEqualsWithParameters() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("charset", "UTF-8");
        MediaType mediaType1 = new MediaType("text/plain", parameters.get("charset"), parameters);
        MediaType mediaType2 = new MediaType("text/plain", parameters.get("charset"), parameters);
        assertTrue(mediaType1.equals(mediaType2));
    }

    @Test
    public void testEqualsWithDifferentParameters() {
        Map<String, String> parameters1 = new HashMap<>();
        parameters1.put("charset", "UTF-8");
        Map<String, String> parameters2 = new HashMap<>();
        parameters2.put("charset", "ISO-8859-1");
        MediaType mediaType1 = new MediaType("text/plain", parameters1.get("charset"), parameters1);
        MediaType mediaType2 = new MediaType("text/plain", parameters2.get("charset"), parameters2);
        assertFalse(mediaType1.equals(mediaType2));
    }

    @Test
    public void testEqualsWithDifferentSubtype() {
        MediaType mediaType1 = MediaType.parse("text/plain");
        MediaType mediaType2 = MediaType.parse("text/html");
        assertFalse(mediaType1.equals(mediaType2));
    }

    @Test
    public void testEqualsWithDifferentType() {
        MediaType mediaType1 = MediaType.parse("text/plain");
        MediaType mediaType2 = MediaType.parse("application/xml");
        assertFalse(mediaType1.equals(mediaType2));
    }

    @Test
    public void testEqualsWithNull() {
        MediaType mediaType1 = MediaType.parse("text/plain");
        Executable executable = () -> mediaType1.equals(null);
        assertThrows(NullPointerException.class, executable);
    }

    @Test
    public void testEqualsWithDifferentObject() {
        MediaType mediaType1 = MediaType.parse("text/plain");
        Executable executable = () -> mediaType1.equals(new Object());
        assertThrows(ClassCastException.class, executable);
    }
}
