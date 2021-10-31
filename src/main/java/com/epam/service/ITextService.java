package com.epam.service;

import com.epam.entity.Sentence;
import com.epam.entity.Word;

import java.util.List;


public interface ITextService {
    void replaceWordsByLength(Sentence sentence, int length, String str);
    Sentence chooseSentence(int paragraphNum, int sentenceNum);
    String getText();
}
