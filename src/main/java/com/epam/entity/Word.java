package com.epam.entity;

import java.util.regex.Pattern;

public class Word implements Component{
    private String content;

    public Word(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLength() {
        Pattern pattern = Pattern.compile("\\p{Punct}");

        if (pattern.matcher(content).find()) {
            if (content.endsWith("',") || content.endsWith("'.") ||
            content.endsWith("),") || content.endsWith(").")) {
                return content.length()-2;
            }
            else
            return content.length()-1;
        }
        else
            return content.length();
    }

    @Override
    public String getValue() {
        return content + " ";
    }
}
