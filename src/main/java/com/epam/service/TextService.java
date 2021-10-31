package com.epam.service;

import com.epam.entity.Paragraph;
import com.epam.entity.Sentence;
import com.epam.entity.Text;
import com.epam.entity.Word;
import com.epam.io.Reader;
import com.epam.parsing.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TextService implements ITextService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextService.class);
    private Text text;

    public TextService() throws IOException {
        this.text = Parser.parse(Reader.readFile("src/main/resources/text.txt"));
    }

    public TextService(String fileName) throws IOException {
        this.text = Parser.parse(Reader.readFile("src/main/resources/" + fileName));
    }

    @Override
    public Sentence chooseSentence(int paragraphNum, int sentenceNum) {
        Paragraph paragraph = text.getParagraph(paragraphNum);
        Sentence sentence = paragraph.getSentence(sentenceNum);
        LOGGER.debug("chooseSentence is called.");
        LOGGER.debug("chooseSentence returns selected sentence: \n{}", sentence.getContent());
        return sentence;
    }

    @Override
    public void replaceWordsByLength(Sentence sentence, int length, String str) {
        for (Word word : sentence.getWords()) {
            if (word.getLength() == length)
            {
                if (word.getContent().startsWith("(") || word.getContent().startsWith("'")) {
                    word.setContent(word.getContent().replace(word.getContent().substring(1, word.getLength()+1), str));
                }
                else {
                    word.setContent(word.getContent().replace(word.getContent().substring(0, word.getLength()), str));
                }
            }
        }
    }

    @Override
    public String getText() {
        LOGGER.debug("getText is called.");
        LOGGER.info("getText returns: \n{}", text.getValue());
        return text.getValue();
    }

}
