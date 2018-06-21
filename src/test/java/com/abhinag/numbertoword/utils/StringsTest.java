package com.abhinag.numbertoword.utils;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class StringsTest {

    @Test
    public void already_correct_length_string_is_not_padded() {
        String paddedVersion = Strings.padLeft("abc", "-", 0);
        assertEquals("abc", paddedVersion);
    }

    @Test
    public void string_is_left_padded() {
        String paddedVersion = Strings.padLeft("abc", "-", 6);
        assertEquals("---abc", paddedVersion);
    }

    @Test
    public void join_words() {
        assertEquals("a b c", Strings.join(asList("a", "b", "c")));
    }


}
