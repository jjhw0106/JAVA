package megastudy_test4;

import java.util.Random;
import java.util.Scanner;

//start 1:52 end =>fail
public class RemainDuplication {
	public static void main(String[] args) {
		int test[] = { 1, 2, 3, 2, 1 };
		int test2[] = { 1, 3, 4, 4, 2 };
		int test3[] = { 1, 1, 1, 2, 1 };

		// 위 배열에서 중복안된숫자를 제거하시요
		// 1) {1,2,1,2}
		// 2) {4,4}
		// 3) {1,1,1,1}

		int[] remain = new int[test.length];
		int rmIdx = 0;

		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test.length; j++) {
				if (i != j && test[i] == test[j]) {
					remain[rmIdx] = test[i];
					rmIdx++;
					break;
				}
			}
		}

		test = new int[rmIdx];
		for (int i = 0; i < rmIdx; i++)
			test[i] = remain[i];

		for (int i = 0; i < test.length; i++)
			System.out.println(test[i]);
	}
}