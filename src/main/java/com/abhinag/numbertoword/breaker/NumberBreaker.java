package com.abhinag.numbertoword.breaker;

import java.util.ArrayList;
import java.util.List;

import com.abhinag.numbertoword.utils.Strings;

public class NumberBreaker {

    private List<NumberComponent> components = new ArrayList<NumberComponent>();
    private List<Part> parts;

    public NumberBreaker(List<Part> parts) {
        this.parts = parts;
    }

    public List<NumberComponent> breakDown(int baseNumberAsInt) {
        String baseNumber = createAPaddedRepresentationOfTheBaseNumber(baseNumberAsInt);

        for (Part part : parts)
            addPartIfHasValue(baseNumber, part);

        return components;
    }

    private void addPartIfHasValue(String parts, Part part) {
        int partialNumber = grabPartOfNumber(parts, part.startIndexInNumber, part.endIndexInNumber);
        if (partialNumber != 0)
            components.add(new NumberComponent(part, partialNumber));
    }

    private Integer grabPartOfNumber(String parts, int negativeStart, int negativeFinish) {
        return Integer.valueOf(parts.substring(parts.length() - negativeStart, parts.length() - negativeFinish));
    }

    private String createAPaddedRepresentationOfTheBaseNumber(int baseNumber) {
        return Strings.padLeft(String.valueOf(baseNumber), "0", parts.get(0).startIndexInNumber);
    }
}
