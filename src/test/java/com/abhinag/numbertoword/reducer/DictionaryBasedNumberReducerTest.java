package com.abhinag.numbertoword.reducer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.abhinag.numbertoword.dictionary.NumberDictionary;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DictionaryBasedNumberReducerTest {

    @Mock
    NumberDictionary dictionary;

    @Test
    public void single_word_available_then_return_single_element() {
        when(dictionary.getListOfDescendingNumbers()).thenReturn(Arrays.asList(1));
        when(dictionary.wordFor(1)).thenReturn("1");
        Assert.assertEquals(Arrays.asList("1"), new DictionaryBasedNumberReducer(dictionary).toWords(1));
    }

    @Test
    public void higher_number_not_used_if_too_large_for_remainder() {
        when(dictionary.getListOfDescendingNumbers()).thenReturn(Arrays.asList(2, 1));
        when(dictionary.wordFor(1)).thenReturn("1");
        assertEquals(Arrays.asList("1"), new DictionaryBasedNumberReducer(dictionary).toWords(1));
    }

    @Test
    public void smaller_number_not_used_if_too_small_for_remainder() {
        when(dictionary.getListOfDescendingNumbers()).thenReturn(Arrays.asList(20, 1));
        when(dictionary.wordFor(20)).thenReturn("20");
        assertEquals(Arrays.asList("20"), new DictionaryBasedNumberReducer(dictionary).toWords(20));
    }

    @Test
    public void two_words_available_then_both_used() {
        when(dictionary.getListOfDescendingNumbers()).thenReturn(Arrays.asList(20, 1));
        when(dictionary.wordFor(20)).thenReturn("2");
        when(dictionary.wordFor(1)).thenReturn("1");
        assertEquals(Arrays.asList("2", "1"), new DictionaryBasedNumberReducer(dictionary).toWords(21));
    }


}
