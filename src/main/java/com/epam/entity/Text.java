package com.epam.entity;

import java.util.ArrayList;
import java.util.List;

public class Text implements Component{
    private String content;
    private List<Paragraph> paragraphs = new ArrayList<>();

    public Text(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void addParagraph(Paragraph paragraph) {
        getParagraphs().add(paragraph);
    }

    public Paragraph getParagraph(int i) {
        return paragraphs.get(i);
    }

    @Override
    public String getValue() {
        String text = "";
        for (Paragraph paragraph : paragraphs) {
            text += paragraph.getValue();
        }
        return text;
    }
}
