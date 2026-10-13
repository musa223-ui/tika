package org.apache.tika.mime;

import org.apache.tika.mime.MediaType;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ExtendWith(MockitoExtension.class)
public class MediaType_parse_7_0_Test {

    @Test
    public void testParse_NullInput() {
        MediaType result = MediaType.parse(null);
        assertNull(result);
    }

    @Test
    public void testParse_SimpleType() {
        MediaType result = MediaType.parse("application/json");
        assertNotNull(result);
        assertEquals("application", result.getType());
        assertEquals("json", result.getSubtype());
        assertTrue(result.getParameters().isEmpty());
    }

    @Test
    public void testParse_ComplexType() {
        MediaType result = MediaType.parse("application/json; charset=UTF-8");
        assertNotNull(result);
        assertEquals("application", result.getType());
        assertEquals("json", result.getSubtype());
        assertEquals("UTF-8", result.getParameters().get("charset"));
    }

    @Test
    public void testParse_InvalidType() {
        MediaType result = MediaType.parse("application/json; charset=UTF-8");
        assertNotNull(result);
        assertEquals("application", result.getType());
        assertEquals("json", result.getSubtype());
        assertEquals("UTF-8", result.getParameters().get("charset"));
    }

    @Test
    public void testParse_EmptyInput() {
        MediaType result = MediaType.parse("");
        assertNull(result);
    }

    @Test
    public void testParse_WhitespaceInput() {
        MediaType result = MediaType.parse("   ");
        assertNull(result);
    }

    @Test
    public void testParse_SimpleTypeWithWhitespace() {
        MediaType result = MediaType.parse(" application / json ");
        assertNotNull(result);
        assertEquals("application", result.getType());
        assertEquals("json", result.getSubtype());
        assertTrue(result.getParameters().isEmpty());
    }

    @Test
    public void testParse_ComplexTypeWithWhitespace() {
        MediaType result = MediaType.parse(" application / json ; charset = UTF - 8 ");
        assertNotNull(result);
        assertEquals("application", result.getType());
        assertEquals("json", result.getSubtype());
        assertEquals("UTF-8", result.getParameters().get("charset"));
    }

    @Test
    public void testParse_InvalidTypeWithWhitespace() {
        MediaType result = MediaType.parse(" application / json ; charset = UTF - 8 ");
        assertNotNull(result);
        assertEquals("application", result.getType());
        assertEquals("json", result.getSubtype());
        assertEquals("UTF-8", result.getParameters().get("charset"));
    }

    @Test
    public void testParse_EmptyInputWithWhitespace() {
        MediaType result = MediaType.parse("   ");
        assertNull(result);
    }

    @Test
    public void testParse_WhitespaceInputWithWhitespace() {
        MediaType result = MediaType.parse("   ");
        assertNull(result);
    }

    @Test
    public void testParse_SimpleTypeWithSpecialCharacters() {
        MediaType result = MediaType.parse("application/json; charset=UTF-8");
        assertNotNull(result);
        assertEquals("application", result.getType());
        assertEquals("json", result.getSubtype());
        assertEquals("UTF-8", result.getParameters().get("charset"));
    }

    @Test
    public void testParse_ComplexTypeWithSpecialCharacters() {
        MediaType result = MediaType.parse("application/json; charset=UTF-8");
        assertNotNull(result);
        assertEquals("application", result.getType());
        assertEquals("json", result.getSubtype());
        assertEquals("UTF-8", result.getParameters().get("charset"));
    }

    @Test
    public void testParse_InvalidTypeWithSpecialCharacters() {
        MediaType result = MediaType.parse("application/json; charset=UTF-8");
        assertNotNull(result);
        assertEquals("application", result.getType());
        assertEquals("json", result.getSubtype());
        assertEquals("UTF-8", result.getParameters().get("charset"));
    }

    @Test
    public void testParse_EmptyInputWithSpecialCharacters() {
        MediaType result = MediaType.parse("");
        assertNull(result);
    }

    @Test
    public void testParse_WhitespaceInputWithSpecialCharacters() {
        MediaType result = MediaType.parse("   ");
        assertNull(result);
    }
}
