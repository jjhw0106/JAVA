package megastudy_test5;

import java.util.Scanner;
import java.util.Random;

public class Mini_Project2 {
	public static void main(String[] args) {

		// 학생 정보와 성적이 담긴 데이터 이다
		// student ==> 1.id 2.주소 3.번호
		// score ==> 1.번호 2.국어 3.수학 4.영어 점수 이다
		// 문제1) 전체 성적이 1등인 학생 이름 출력

		String[][] student = { { "aaa", "신촌", "1001" },

				{ "bbb", "강남", "1002" },

				{ "ccc", "대치", "1003" },

				{ "ddd", "강동", "1004" }

		};
		String[][] score = { { "번호", "과목", "점수" },

				{ "1001", "국어", "20" },

				{ "1002", "국어", "50" },

				{ "1003", "국어", "60" },

				{ "1004", "국어", "17" },

				{ "1001", "수학", "65" },

				{ "1002", "수학", "15" },

				{ "1003", "수학", "80" },

				{ "1004", "수학", "70" },

				{ "1001", "영어", "43" },

				{ "1002", "영어", "90" },

				{ "1003", "영어", "30" },

				{ "1004", "영어", "70" } };

		int cnt = 0;
		int arrIdx = 0;
		int check = 1;
		int[] arr = null;
		int[] sum = null;
		int idx = 0;
		while (cnt < score.length - 1) {
			if (check == 1) {
				int[] temp = arr;
				arr = new int[cnt + 1];
				if (temp != null) {
					for (int i = 0; i < temp.length; i++)
						arr[i] = temp[i];
				}
				arr[arrIdx] = Integer.parseInt(score[cnt + 1][0]);
				arrIdx++;
			}

			check = 1;
			for (int i = 0; i < arrIdx; i++)
				if (Integer.parseInt(score[cnt + 1][0]) == arr[i]) {
					check = -1;
					cnt++;
					break;
				}

		}

//		for (int i = 0; i < arr.length; i++)
//			System.out.println(arr[i]);

		sum = new int[arr.length];
		for (int i = 1; i < score.length; i++)
			for (int j = 0; j < arr.length; j++)
				if (Integer.parseInt(score[i][0]) == arr[j])
					sum[j] += Integer.parseInt(score[i][2]);

//		for (int i = 0; i < sum.length; i++)
//			System.out.println(sum[i]);

		int max = 0;
		for (int i = 0; i < sum.length; i++)
			if (sum[i] > max) {
				max = sum[i];
				idx = i;
			}
		System.out.println("1등은");
		for (int i = 0; i < student.length; i++)
			if (student[i][2].equals(String.valueOf(arr[idx])))
				System.out.println(student[i][0]);

	}
}