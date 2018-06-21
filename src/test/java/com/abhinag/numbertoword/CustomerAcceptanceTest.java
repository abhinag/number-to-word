package com.abhinag.numbertoword;

import static com.abhinag.numbertoword.utils.Assertions.assertConversion;

import org.junit.Test;

public class CustomerAcceptanceTest {

    @Test
    public void customer_provided_example_1() {
        assertConversion("one", 1);
    }

    @Test
    public void customer_provided_example_21() {
        assertConversion("twenty one", 21);
    }

    @Test
    public void customer_provided_example_56_945_781() {
        assertConversion("fifty six million nine hundred and forty five thousand seven hundred and eighty one", 56945781);
    }

    @Test(expected = IllegalArgumentException.class)
    public void customer_provided_example_number_too_high() {
        new NumberToTextMain().translateToBritishEnglish(1000000000);
    }

}
