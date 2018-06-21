package com.abhinag.numbertoword;

import java.util.Scanner;

import com.abhinag.numbertoword.dictionary.NumberDictionary;
import com.abhinag.numbertoword.dictionary.SentenceCreator;
import com.abhinag.numbertoword.dictionary.british.BritishEnglishNumberDictionary;
import com.abhinag.numbertoword.dictionary.british.BritishEnglishSentenceCreator;

public class NumberToTextMain {

    public String translateToBritishEnglish(int input) {
        return translate(input,
                new BritishEnglishNumberDictionary(),
                new BritishEnglishSentenceCreator());
    }

    private String translate(int input, NumberDictionary dictionary, SentenceCreator sentenceCreator) {
        return new DictionaryNumberConverter(dictionary, sentenceCreator).toWords(input);
    }

    public static void main(String[] args) {
        NumberToTextMain main = new NumberToTextMain();
        Scanner scanner = new Scanner(System.in);
		try{
			while (true) {
				System.out.println();
				System.out.println("Enter number less than 100 billion:");

				Integer number = scanner.nextInt();
				System.out.println();
				System.out.println(number + " = " + main.translateToBritishEnglish(number));
			}
		} catch (Exception e) {
			System.out.println();
			System.out.println("Your Input Is Wrong. Please Enter A Valid Input Again.");
			main(args);
		} finally {
			scanner.close();
		}
    }
}
