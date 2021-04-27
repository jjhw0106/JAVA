package file_practice;

/*
 * # 끝말잇기 게임
 * 제시어 : 자전거
 * 입력 : 거미
 * 제시어 : 거미
 * 입력 : 미술
 * ...
 */
import java.util.Scanner;

// Data Type
// int
// char
// double
// String // 자료형X, char 배열을 마치 자료형 처럼 취급

public class Word_Chain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String start = "자전거";
		System.out.println("제시어 : " + start);

//		제시어
		String temp = start;

		while (true) {
//		str.length로 제시어의 막값 인덱스 get
			int idx = temp.length() - 1;

//		입력받기
			System.out.println("단어 입력");
			String answer = sc.next();
			if (answer.equals("gg") || answer.equals("내가 졌다")) {
				System.out.println("게임 끝");
				break;
			}

// 		입력받은값의 charAt(0)과 제시어의 charAt(idx)비교
//		같으면 제시어에 입력값 넣기
//		다르면 "끝말과 다릅니다" continue
//		반복
			if (answer.charAt(0) == temp.charAt(idx))
				temp = answer;
			else
				System.out.println("끝말과 다릅니다.");
		}
	}
}
