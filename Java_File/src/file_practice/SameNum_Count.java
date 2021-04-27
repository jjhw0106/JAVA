package file_practice;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
/*
int [] a = {1,1,3,3,3,100,2,2,3,1,3};
위 배열에서 똑같은 숫자의 개수가 가장 적은 숫자와 가장 많은 숫자 의  개수를  출력 
예) 개수가 가장적은숫자 ==> 100
예) 개수가 가장많은숫자 ==> 3
	
가장 많은 갯수 출력 : 3 ===> 5개 
가장 적은 갯수 출력 : 100 ===> 1개
*/

public class SameNum_Count {
	public static void main(String[] args) {

//		중복안되는 숫자의 개수 구함 **
//		숫자의 개수로 배열 선언 **
//		중복되는 값 저장
//		중복되는 값의 개수 카운트 후 저장

		int[] a = { 1, 3, 3, 1, 1, 1000, 100, 2, 2, 3, 1, 3 };

		int num[] = null;
		int idx = 0;
		int count = 0;
		int target = 0;
		int check = 1;

		for (int i = 0; i < a.length; i++) {
			check = 1;
			for (int j = 0; j < i; j++) {
				if (i != j && a[i] == a[j]) {
					check = -1;
					break;
				}
			}
			if (check == 1)
				count++;
		}
		num = new int[count];
		num[0] = a[0];
		for (int i = 0; i < a.length; i++) {
			check = 1;
			for (int j = 0; j < num.length; j++)
				if (a[i] == num[j]) {
					check = -1;
					break;
				}
			if (check == 1) {
				num[idx] = a[i];
				idx++;
			}
		}
		int[] numCnt = new int[count];

		for (int i = 0; i < num.length; i++) {
			target = num[i];
			for (int j = 0; j < a.length; j++)
				if (target == a[j])
					numCnt[i]++;
		}

		int max = numCnt[0];
		int maxIdx = 0;

		int min = numCnt[0];
		int minIdx = 0;

		for (int i = 0; i < count; i++)
			if (max < numCnt[i]) {
				max = numCnt[i];
				maxIdx = i;
			}
		for (int i = 0; i < count; i++)
			if (min > numCnt[i]) {
				min = numCnt[i];
				minIdx = i;
			}

		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i] + " " + numCnt[i]);

		}
		System.out.println("max는: " + num[maxIdx] + " " + numCnt[maxIdx] + "개");
		System.out.println("min는: " + num[minIdx] + " " + numCnt[minIdx] + "개");

		System.out.println();

	}
}
