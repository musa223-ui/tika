package org.apache.tika.mime;

import org.apache.tika.mime.MediaType;
import org.junit.jupiter.api.function.Executable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MediaType_image_2_0_Test {

    private MediaType mediaType;

    @BeforeEach
    public void setUp() {
        mediaType = new MediaType("image/png", "png", Collections.emptyMap());
    }

    @Test
    public void testImageMethod() {
        // Test with a valid image type
        MediaType result = mediaType.image("png");
        assertNotNull(result);
        assertEquals("image/png", result.toString());
        // Test with an empty image type
        Executable executable = () -> mediaType.image("");
        assertThrows(IllegalArgumentException.class, executable, "Expected IllegalArgumentException for empty image type");
        // Test with a null image type
        executable = () -> mediaType.image(null);
        assertThrows(NullPointerException.class, executable, "Expected NullPointerException for null image type");
        // Test with a type containing special characters
        executable = () -> mediaType.image("image/jpeg; charset=UTF-8");
        assertThrows(IllegalArgumentException.class, executable, "Expected IllegalArgumentException for type with special characters");
        // Test with a type containing whitespace
        executable = () -> mediaType.image("image/jpeg ");
        assertThrows(IllegalArgumentException.class, executable, "Expected IllegalArgumentException for type with whitespace");
    }
}
