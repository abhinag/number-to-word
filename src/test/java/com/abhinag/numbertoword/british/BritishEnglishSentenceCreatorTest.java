package com.abhinag.numbertoword.british;

import org.junit.Test;

import com.abhinag.numbertoword.dictionary.SentenceCreator;
import com.abhinag.numbertoword.dictionary.british.BritishEnglishSentenceCreator;

import static com.abhinag.numbertoword.breaker.PartsForTestingWith.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class BritishEnglishSentenceCreatorTest {

    private SentenceCreator sentenceCreator = new BritishEnglishSentenceCreator();

    @Test
    public void single_element_is_returned_alone() {
        assertEquals("one", sentenceCreator.applyGrammarTo(asList("one"), HUNDRED));
    }

    @Test
    public void two_elements_are_joined_with_a_space() {
        assertEquals("twenty two", sentenceCreator.applyGrammarTo(asList("twenty", "two"), HUNDRED));
    }

    @Test
    public void hundreds_are_given_an_and_if_more_words_to_come() {
        assertEquals("one hundred and twenty two", sentenceCreator.applyGrammarTo(asList("one hundred", "twenty", "two"), HUNDRED));
    }

    @Test
    public void hundreds_arent_given_an_and_if_no_more_words_to_come() {
        assertEquals("one hundred", sentenceCreator.applyGrammarTo(asList("one hundred"), HUNDRED));
    }

    @Test
    public void when_in_thousands_a_word_is_appended() {
        assertEquals("one hundred thousand", sentenceCreator.applyGrammarTo(asList("one hundred"), THOUSAND));
    }

    @Test
    public void when_in_millions_a_word_is_appended() {
        assertEquals("one hundred million", sentenceCreator.applyGrammarTo(asList("one hundred"), MILLION));
    }

    @Test
    public void when_in_thousands_a_word_is_appended_at_the_end() {
        assertEquals("one hundred and five thousand", sentenceCreator.applyGrammarTo(asList("one hundred", "five"), THOUSAND));
    }
}
