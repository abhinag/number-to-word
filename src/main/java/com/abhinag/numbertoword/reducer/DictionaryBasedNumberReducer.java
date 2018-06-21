package com.abhinag.numbertoword.reducer;

import com.abhinag.numbertoword.dictionary.NumberDictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryBasedNumberReducer implements NumberReducer {

    private NumberDictionary dictionary;

    public DictionaryBasedNumberReducer(NumberDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public List<String> toWords(int number) {
        List<String> tokens = new ArrayList<String>();

        int remainder = number;

        for (int integer : dictionary.getListOfDescendingNumbers()) {
            if (remainder >= integer) {
                tokens.add(dictionary.wordFor(integer));
                remainder -= integer;
            }
        }

        return tokens;
    }
}
