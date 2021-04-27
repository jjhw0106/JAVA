package megastudy_test4;

//start 8:25 end 8:40
import java.util.Scanner;
// b 에 arr 의 값이 있으면 0으로 변경 

//예) b ==> {0,2,54,0,0};

public class Test4_Arr {
	public static void main(String[] args) {

		int darr[][] = { { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 }, };
		int b[] = { 10, 2, 54, 90, 50 };
		int target = 0;

		for (int i = 0; i < darr.length; i++) {
			for (int j = 0; j < darr.length; j++) {
				target = darr[i][j];

				for (int k = 0; k < b.length; k++)
					if (target == b[k])
						b[k] = 0;
			}
		}

		for (int i = 0; i < b.length; i++)
			System.out.print(b[i] + " ");

	}
}
