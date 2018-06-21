package com.abhinag.numbertoword.dictionary;

import com.abhinag.numbertoword.breaker.Part;

import java.util.List;

public interface NumberDictionary {
	
    List<Integer> getListOfDescendingNumbers();

    String wordFor(int number);

    List<Part> parts();

    boolean valueIsWithinRange(int number);
}
