package org.apache.tika.mime;

import org.junit.jupiter.api.function.Executable;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MediaType_compareTo_20_0_Test {

    private MediaType mediaType1;

    private MediaType mediaType2;

    @BeforeEach
    public void setUp() {
        Map<String, String> parameters1 = new HashMap<>();
        parameters1.put("charset", "UTF-8");
        mediaType1 = new MediaType("text", "plain", parameters1);
        Map<String, String> parameters2 = new HashMap<>();
        parameters2.put("charset", "UTF-8");
        mediaType2 = new MediaType("text", "plain", parameters2);
    }

    @Test
    public void testCompareToEqual() {
        assertEquals(0, mediaType1.compareTo(mediaType2));
    }

    @Test
    public void testCompareToDifferentCharset() {
        Map<String, String> parameters3 = new HashMap<>();
        parameters3.put("charset", "ISO-8859-1");
        MediaType mediaType3 = new MediaType("text", "plain", parameters3);
        assertNotEquals(0, mediaType1.compareTo(mediaType3));
    }

    @Test
    public void testCompareToDifferentSubtype() {
        MediaType mediaType4 = new MediaType("text", "html");
        assertNotEquals(0, mediaType1.compareTo(mediaType4));
    }

    @Test
    public void testCompareToDifferentType() {
        MediaType mediaType5 = new MediaType("application", "xml");
        assertNotEquals(0, mediaType1.compareTo(mediaType5));
    }
}
