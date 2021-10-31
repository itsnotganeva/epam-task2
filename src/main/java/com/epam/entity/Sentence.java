package com.epam.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements Component{
    private String content;
    private List<Word> words = new ArrayList<>();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Word> getWords() {
        return words;
    }

    public void addWord(Word word) {
        getWords().add(word);
    }

    public Sentence(String content) {
        this.content = content;
    }

    @Override
    public String getValue() {
        String sentence = "";
        for (Word word : words) {
            sentence += word.getValue();
        }
        return sentence;
    }
}
