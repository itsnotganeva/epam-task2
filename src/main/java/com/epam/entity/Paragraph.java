package com.epam.entity;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements Component{

    private String content;
    private List<Sentence> sentences = new ArrayList<>();

    public Paragraph(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void addSentence(Sentence sentence) {
        getSentences().add(sentence);
    }

    public Sentence getSentence(int i) {
        return sentences.get(i);
    }

    @Override
    public String getValue() {
        String paragraph = "";
        for (Sentence sentence : sentences) {
            paragraph += sentence.getValue();
        }
        return paragraph + "\n";
    }
}
