package com.abhinag.numbertoword.utils;

import java.util.List;

public class Strings {

    public static String padLeft(String base, String with, int size) {
        StringBuilder sb = new StringBuilder(base);

        int toAdd = size - sb.length();
        for (int i = 0; i < toAdd; i++)
            sb.insert(0, with);

        return sb.toString();
    }

    public static String join(List<String> words) {
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            addSpaceIfWordAlreadyPresent(sb);
            sb.append(word);
        }

        return sb.toString();
    }


    private static void addSpaceIfWordAlreadyPresent(StringBuilder sb) {
        if (sb.length() > 0)
            sb.append(" ");
    }
}
