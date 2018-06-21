package com.abhinag.numbertoword.breaker;

import org.junit.Test;

import java.util.List;

import static com.abhinag.numbertoword.breaker.PartsForTestingWith.*;
import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

public class NumberBreakerTest {

    NumberBreaker breaker = new NumberBreaker(asList(MILLION, THOUSAND, HUNDRED));

    @Test
    public void number_in_the_hundreds_returns_just_itself() {
        List<NumberComponent> components = breaker.breakDown(100);

        assertEquals(1, components.size());
        assertPart(components.get(0), 100, HUNDRED);
    }

    @Test
    public void number_in_the_thousands_returns_two_parts() {
        List<NumberComponent> components = breaker.breakDown(1100);

        assertEquals(2, components.size());
        assertPart(components.get(0), 1, THOUSAND);
        assertPart(components.get(1), 100, HUNDRED);
    }

    @Test
    public void number_in_the_millions_returns_three_parts() {
        List<NumberComponent> components = breaker.breakDown(100100100);

        assertEquals(3, components.size());
        assertPart(components.get(0), 100, MILLION);
        assertPart(components.get(1), 100, THOUSAND);
        assertPart(components.get(2), 100, HUNDRED);
    }

    @Test
    public void number_without_thousands_misses_them_out() {
        List<NumberComponent> components = breaker.breakDown(10000020);

        assertEquals(2, components.size());
        assertPart(components.get(0), 10, MILLION);
        assertPart(components.get(1), 20, HUNDRED);
    }

    private void assertPart(NumberComponent component, int expectedNumber, Part expectedPart) {
        assertEquals(expectedNumber, component.number);
        assertEquals(expectedPart, component.part);
    }
}
