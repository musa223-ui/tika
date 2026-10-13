package org.apache.tika.mime;

import org.apache.tika.mime.MediaType;
import org.junit.jupiter.api.function.Executable;
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

public class MediaType_audio_1_0_Test {

    @Test
    public void testAudioMethod() {
        // Test with valid input
        MediaType result = MediaType.audio("mp3");
        assertNotNull(result);
        assertEquals("audio/mp3", result.toString());
        // Test with empty input
        result = MediaType.audio("");
        assertNotNull(result);
        assertEquals("audio/", result.toString());
        // Test with null input
        Executable executable = () -> MediaType.audio(null);
        assertThrows(NullPointerException.class, executable);
    }
}
