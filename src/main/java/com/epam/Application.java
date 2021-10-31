package com.epam;

import com.epam.entity.*;
import com.epam.service.TextService;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {

        TextService text = new TextService();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of paragraph in which you want to replace the words: ");
        int paragraphNum = in.nextInt();
        System.out.println("Enter the number of sentence in paragraph " + paragraphNum + " in which you want to replace the words: ");
        int sentenceNum = in.nextInt();
        System.out.println("Enter the length of words which you want to replace: ");
        int length = in.nextInt();
        System.out.println("Enter the word with which you want to replace words of length " + length + ": ");
        in.nextLine();
        String str = in.nextLine();

        Sentence s = text.chooseSentence(paragraphNum, sentenceNum);
        text.replaceWordsByLength(s, length, str);
        text.getText();




    }
}
