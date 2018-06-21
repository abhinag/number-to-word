package com.abhinag.numbertoword;

import static com.abhinag.numbertoword.utils.Assertions.assertConversion;

import org.junit.Test;

public class ProgrammerAcceptanceTest {

    @Test
    public void translate_1_to_one() {
        assertConversion("one", 1);
    }

    @Test
    public void translate_2_to_two() {
        assertConversion("two", 2);
    }

    @Test
    public void translate_3_to_numbers_below_10() {
        assertConversion("three", 3);
        assertConversion("four", 4);
        assertConversion("five", 5);
        assertConversion("six", 6);
        assertConversion("seven", 7);
        assertConversion("eight", 8);
        assertConversion("nine", 9);
    }

    @Test
    public void translate_10_to_20() {
        assertConversion("ten", 10);
        assertConversion("eleven", 11);
        assertConversion("twelve", 12);
        assertConversion("thirteen", 13);
        assertConversion("fourteen", 14);
        assertConversion("fifteen", 15);
        assertConversion("sixteen", 16);
        assertConversion("seventeen", 17);
        assertConversion("eighteen", 18);
        assertConversion("nineteen", 19);
        assertConversion("twenty", 20);
    }

    @Test
    public void translate_21() {
        assertConversion("twenty one", 21);
    }

    @Test
    public void translate_selection_of_other_numbers_below_a_hundred() {
        assertConversion("thirty two", 32);
        assertConversion("forty three", 43);
        assertConversion("fifty four", 54);
        assertConversion("sixty five", 65);
        assertConversion("seventy six", 76);
        assertConversion("eighty seven", 87);
        assertConversion("ninety eight", 98);
    }

    @Test
    public void translate_selection_of_other_numbers_below_a_thousand() {
        assertConversion("three hundred and twenty", 320);
        assertConversion("four hundred and thirty", 430);
        assertConversion("five hundred and forty", 540);
        assertConversion("six hundred and fifty", 650);
        assertConversion("seven hundred and sixty", 760);
        assertConversion("eight hundred and seventy", 870);
        assertConversion("nine hundred and eighty", 980);
    }

    @Test
    public void translate_selection_of_other_numbers_below_a_million() {
        assertConversion("one thousand", 1000);
        assertConversion("two thousand five hundred", 2500);
        assertConversion("twenty thousand five hundred", 20500);
        assertConversion("two hundred thousand five hundred", 200500);
    }

    @Test
    public void translate_selection_of_other_numbers_below_a_billion() {
        assertConversion("one million", 1000000);
        assertConversion("two million five hundred", 2000500);
        assertConversion("twenty million five hundred", 20000500);
        assertConversion("two hundred million five hundred", 200000500);
        assertConversion("two hundred million twenty thousand five hundred", 200020500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void number_too_low() {
        new NumberToTextMain().translateToBritishEnglish(-1);
    }
}
