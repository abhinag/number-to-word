package com.abhinag.numbertoword.utils;

import static org.junit.Assert.assertEquals;

import com.abhinag.numbertoword.NumberToTextMain;

public class Assertions {

    public static void assertConversion(String expected, int input) {
        assertEquals(expected, new NumberToTextMain().translateToBritishEnglish(input));
    }
}
