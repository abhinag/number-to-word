package com.abhinag.numbertoword.dictionary;

import com.abhinag.numbertoword.breaker.Part;

import java.util.List;

public interface SentenceCreator {
    String applyGrammarTo(List<String> words, Part part);
}
