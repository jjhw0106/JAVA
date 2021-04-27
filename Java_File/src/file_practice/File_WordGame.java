package file_practice;

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Random;

public class File_WordGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		int score = 100;
		String word = "performandlfjjffce";
		int check[] = new int[word.length()]; // 1,0으로 저장 ************************* GoodGood!!!
		String meaning = "공연";
		// 문제) 영어단어 맞추기
		// 영어단어가 전부 * 로 표시된다.
		// 영어단어를 입력받고 틀릴때마다 랜덤으로 한글자씩 벗겨진다. (점수는 5점씩 감점)
		// (조건) 만약에 같은 철자가 여러개면 한번에 벗겨진다.
		// 전부 벗겨지거나 맞추면 종료

		// 중복안되게 업데이트
		// 정답 여부 업데이트
		int num = 0;
		String answer = "";
		boolean resolve = false;
		while (resolve == false) {
			for (int i = 0; i < word.length(); i++)
				if (check[i] == 0) {
					System.out.print("*");
				} else if (check[i] == 1)
					System.out.print(word.charAt(i));
			System.out.println(" : " + meaning + "(" + score + ")");

			System.out.print("정답: ");
			answer = sc.next();
			if (answer.equals(word)) {
				resolve = true;
				System.out.println("정답입니다.");
				break;
			}

			int idx = 0;
			while (true) {
				idx = ran.nextInt(word.length());
				if (check[idx] == 1) {
					continue;
				} else
					break;
			}

			for (int i = 0; i < word.length(); i++)
				if (String.valueOf(word.charAt(idx)).equals(String.valueOf(word.charAt(i))))
					check[i] = 1;
			score -= 5;

			int checkCnt = 0;
			for (int i = 0; i < word.length(); i++)
				if (check[i] == 1)
					checkCnt++;
			if (checkCnt == word.length()) {
				break;
			}

		}

		System.out.println(score + "점 입니다!");

	}
}
