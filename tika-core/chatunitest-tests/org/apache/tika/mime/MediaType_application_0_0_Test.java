package org.apache.tika.mime;

import org.apache.tika.mime.MediaType;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MediaType_application_0_0_Test {

    @Test
    public void testApplicationMethod() {
        String type = "testType";
        MediaType result = MediaType.application(type);
        assertNotNull(result);
        assertEquals("application/testType", result.toString());
        assertEquals("application", result.getType());
        assertEquals("testType", result.getSubtype());
        assertTrue(result.getParameters().isEmpty());
    }

    @Test
    public void testApplicationMethodWithParameters() {
        String type = "testType";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("param1", "value1");
        parameters.put("param2", "value2");
        MediaType result = MediaType.parse("application/" + type + "; param1=value1; param2=value2");
        assertNotNull(result);
        assertEquals("application/testType; param1=value1; param2=value2", result.toString());
        assertEquals("application", result.getType());
        assertEquals("testType", result.getSubtype());
        assertEquals("value1", result.getParameters().get("param1"));
        assertEquals("value2", result.getParameters().get("param2"));
    }

    @Test
    public void testApplicationMethodWithEmptyParameters() {
        String type = "testType";
        Map<String, String> parameters = Collections.emptyMap();
        MediaType result = MediaType.parse("application/" + type);
        assertNotNull(result);
        assertEquals("application/testType", result.toString());
        assertEquals("application", result.getType());
        assertEquals("testType", result.getSubtype());
        assertTrue(result.getParameters().isEmpty());
    }

    @Test
    public void testApplicationMethodWithNullType() {
        String type = null;
        MediaType result = MediaType.application(type);
        assertNull(result);
    }

    @Test
    public void testApplicationMethodWithEmptyType() {
        String type = "";
        MediaType result = MediaType.application(type);
        assertNull(result);
    }

    @Test
    public void testApplicationMethodWithWhitespaceType() {
        String type = "   ";
        MediaType result = MediaType.application(type);
        assertNull(result);
    }

    @Test
    public void testApplicationMethodWithInvalidType() {
        String type = "invalidType";
        MediaType result = MediaType.application(type);
        assertNotNull(result);
        assertEquals("application/invalidType", result.toString());
        assertEquals("application", result.getType());
        assertEquals("invalidType", result.getSubtype());
        assertTrue(result.getParameters().isEmpty());
    }
}
