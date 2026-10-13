package org.apache.tika.mime;

import org.apache.tika.mime.MediaType;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MediaType_hashCode_19_0_Test {

    @Test
    public void testHashCode() {
        MediaType mediaType1 = new MediaType("text", "plain");
        MediaType mediaType2 = new MediaType("text", "plain");
        assertEquals(mediaType1.hashCode(), mediaType2.hashCode());
    }

    @Test
    public void testHashCodeWithParameters() {
        MediaType mediaType1 = new MediaType("text", "plain", Collections.singletonMap("charset", "UTF-8"));
        MediaType mediaType2 = new MediaType("text", "plain", Collections.singletonMap("charset", "UTF-8"));
        assertEquals(mediaType1.hashCode(), mediaType2.hashCode());
    }

    @Test
    public void testHashCodeWithDifferentParameters() {
        MediaType mediaType1 = new MediaType("text", "plain", Collections.singletonMap("charset", "UTF-8"));
        MediaType mediaType2 = new MediaType("text", "plain", Collections.singletonMap("charset", "ISO-8859-1"));
        assertNotEquals(mediaType1.hashCode(), mediaType2.hashCode());
    }

    @Test
    public void testHashCodeWithDifferentSubtype() {
        MediaType mediaType1 = new MediaType("text", "plain");
        MediaType mediaType2 = new MediaType("text", "html");
        assertNotEquals(mediaType1.hashCode(), mediaType2.hashCode());
    }

    @Test
    public void testHashCodeWithDifferentType() {
        MediaType mediaType1 = new MediaType("text", "plain");
        MediaType mediaType2 = new MediaType("application", "zip");
        assertNotEquals(mediaType1.hashCode(), mediaType2.hashCode());
    }

    @Test
    public void testHashCodeWithEmptyParameters() {
        MediaType mediaType1 = new MediaType("text", "plain");
        MediaType mediaType2 = new MediaType("text", "plain", Collections.emptyMap());
        assertEquals(mediaType1.hashCode(), mediaType2.hashCode());
    }
}
