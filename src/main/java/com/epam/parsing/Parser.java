package com.epam.parsing;

import com.epam.entity.Paragraph;
import com.epam.entity.Sentence;
import com.epam.entity.Text;
import com.epam.entity.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Parser {

    private static final String PARAGRAPH_SPLIT_REGEX = "(?m)(?=^\\s{0})";
    private  static final String SENTENCE_SPLIT_REGEX = "(?<!\\w\\.\\w.)(?<![A-Z][a-z]\\.)(?<=\\.|\\?|\\!)\\s";

    private static final Logger LOGGER = LoggerFactory.getLogger(Parser.class);

    public static Text parse(Text text) {
        List<Paragraph> paragraphs = parseIntoParagraphs(text);
        for (Paragraph paragraph : paragraphs) {
            List<Sentence> sentences = parseIntoSentences(paragraph);
            for (Sentence sentence : sentences) {
                parseIntoWords(sentence);
            }
        }
        LOGGER.debug("Source text has parsed");
        LOGGER.info("Source text: \n{}", text.getValue());
        return text;
    }

    public static List<Paragraph> parseIntoParagraphs(Text text) {
        String[] paragraphs = text.getContent().split(PARAGRAPH_SPLIT_REGEX);
        for (String paragraph : paragraphs) {
            Paragraph p = new Paragraph(paragraph.trim());
            text.addParagraph(p);
        }
        return text.getParagraphs();
    }

    public static List<Sentence> parseIntoSentences(Paragraph paragraph) {
        String[] sentences = paragraph.getContent().split(SENTENCE_SPLIT_REGEX);
        for (String sentence : sentences) {
            Sentence s = new Sentence(sentence.trim());
            paragraph.addSentence(s);
        }
        return paragraph.getSentences();
    }

    public static List<Word> parseIntoWords(Sentence sentence) {
        String[] words = sentence.getContent().split(" ");
        for (String word : words) {
            Word w = new Word(word);
            sentence.addWord(w);
        }
        return sentence.getWords();
    }

}
