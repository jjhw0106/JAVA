package practice;

import java.util.Scanner;
import java.util.Random;

class Word {
	Random ran = new Random();
	String word;
	int ranPos;

	void setRandomWordPos(String sample) {
		word = sample;
		int r = ran.nextInt(word.length());
		ranPos = r;

	}

	void printWord() {
		for (int i = 0; i < word.length(); i++) {
			if (i == ranPos) {
				System.out.print("*");
			} else {
				System.out.print(word.charAt(i));
			}
		}
		System.out.println();
	}
}

class WordSample {
	Random ran = new Random();
	String[] wordSampleList = { "java", "jsp", "python", "android", "spring" };
	boolean[] checkList = new boolean[wordSampleList.length];
	int count = wordSampleList.length;

	String getRandomWord() {
		int r = 0;
		while (true) {
			r = ran.nextInt(wordSampleList.length);
			if (checkList[r] == false) {
				checkList[r] = true;
				count--;
				break;
			}
		}
		return wordSampleList[r];
	}
}

public class Ex10_WordGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		WordSample wSample = new WordSample();
		Word[] wordList = new Word[wSample.wordSampleList.length];

		for (int i = 0; i < wordList.length; i++) {
			wordList[i] = new Word();

		}
		boolean run = true;
		int index = 0;

		while (run) {
			wordList[index].setRandomWordPos(wSample.getRandomWord());
			while (true) {
				wordList[index].printWord();
				System.out.println(("단어 입력: "));
				String inputWord = sc.next();
				if (inputWord.equals(wordList[index].word)) {
					System.out.println("정답입니다");
					break;
				}
			}

		}
	}
}
