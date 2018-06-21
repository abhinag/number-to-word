package com.abhinag.numbertoword;

import com.abhinag.numbertoword.breaker.NumberBreaker;
import com.abhinag.numbertoword.breaker.NumberComponent;
import com.abhinag.numbertoword.dictionary.NumberDictionary;
import com.abhinag.numbertoword.dictionary.SentenceCreator;
import com.abhinag.numbertoword.reducer.DictionaryBasedNumberReducer;
import com.abhinag.numbertoword.utils.Strings;

import java.util.ArrayList;
import java.util.List;

public class DictionaryNumberConverter {

    private NumberDictionary dictionary;
    private SentenceCreator creator;
    private DictionaryBasedNumberReducer reducer;

    public DictionaryNumberConverter(NumberDictionary dictionary, SentenceCreator creator) {
        this.dictionary = dictionary;
        this.creator = creator;
        this.reducer = new DictionaryBasedNumberReducer(dictionary);
    }

    public String toWords(int number) {
        checkTheNumberIsSupportByThisDictionary(number);

        List<String> sentenceParts = new ArrayList<String>();
        for (NumberComponent component : breakTheNumberIntoParts(number)) {
            List<String> basicWordsWithoutGrammar = reducer.toWords(component.number);
            sentenceParts.add(creator.applyGrammarTo(basicWordsWithoutGrammar, component.part));
        }

        return Strings.join(sentenceParts);
    }

    private List<NumberComponent> breakTheNumberIntoParts(int number) {
        return new NumberBreaker(dictionary.parts()).breakDown(number);
    }

    private void checkTheNumberIsSupportByThisDictionary(int number) {
        if (!dictionary.valueIsWithinRange(number))
            throw new IllegalArgumentException("I cannot convert this number to words: " + number);
    }
}
