package com.abhinag.numbertoword.dictionary.british;

import com.abhinag.numbertoword.breaker.Part;
import com.abhinag.numbertoword.dictionary.NumberDictionary;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class BritishEnglishNumberDictionary implements NumberDictionary {

    public static final String HUNDRED = "hundred";

    private final Map<Integer, String> singleDigits = new LinkedHashMap<Integer, String>() {{
        put(9, "nine");
        put(8, "eight");
        put(7, "seven");
        put(6, "six");
        put(5, "five");
        put(4, "four");
        put(3, "three");
        put(2, "two");
        put(1, "one");
    }};

    private final Map<Integer, String> fullDictionary = new LinkedHashMap<Integer, String>() {{
        for (int integer : singleDigits.keySet()) {
            put(integer * 100, singleDigits.get(integer) + " " + HUNDRED);
        }

        put(90, "ninety");
        put(80, "eighty");
        put(70, "seventy");
        put(60, "sixty");
        put(50, "fifty");
        put(40, "forty");
        put(30, "thirty");
        put(20, "twenty");
        put(19, "nineteen");
        put(18, "eighteen");
        put(17, "seventeen");
        put(16, "sixteen");
        put(15, "fifteen");
        put(14, "fourteen");
        put(13, "thirteen");
        put(12, "twelve");
        put(11, "eleven");
        put(10, "ten");

        putAll(singleDigits);
    }};

    public List<Integer> getListOfDescendingNumbers() {
        return new ArrayList<Integer>(fullDictionary.keySet());
    }

    public String wordFor(int number) {
        return fullDictionary.get(number);
    }

    public List<Part> parts() {
        return asList(new Part("million", 9, 6), new Part("thousand", 6, 3), new Part(HUNDRED, 3, 0));
    }

    public boolean valueIsWithinRange(int number) {
        return number > 0 && number < 1000000000;
    }
}
