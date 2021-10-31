package com.epam;

import com.epam.entity.Sentence;
import com.epam.service.TextService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TextServiceTest {

    @Test
    void testParserAndReader() throws IOException {
        //GIVEN
        String expectedText = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which do not look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text.";
        TextService text = new TextService("test.txt");
        //WHEN
        System.out.println("Text that is expected after parse: \n" + expectedText + "\n");
        String parsedText = text.getText().trim();
        System.out.println("Parsed text: \n" + parsedText);
        //THEN
        Assertions.assertTrue(expectedText.contentEquals(parsedText));
    }

    @Test
    void replaceWordsByLength() throws IOException {
        //GIVEN
        String textBeforeReplace = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which do not look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text.";
        String textAfterReplace = "There are HELLO variations of passages of Lorem Ipsum available, but the majority HELLO suffered alteration in HELLO HELLO, by injected humour, or randomised words which do not HELLO HELLO slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text.";
        TextService text = new TextService("test.txt");
        //WHEN
        System.out.println("Text before replace: \n" + textBeforeReplace + "\n");
        System.out.println("Expected text after replace words with length 4 in the first sentence: \n" + textAfterReplace + "\n");

        Sentence s = text.chooseSentence(0,0);
        text.replaceWordsByLength(s, 4, "HELLO");
        String finalText = text.getText().trim();
        System.out.println("Final text with replaced words: \n" + finalText);
        //THEN
        Assertions.assertTrue(textAfterReplace.contentEquals(finalText));
    }
}
