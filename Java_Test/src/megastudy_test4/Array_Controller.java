package megastudy_test4;

/* 추가: start 5:52 end 6:15
 * 삭제: start 12:12 end 12:40
 * 삭제2: start 12:40 end 1:00
 * 삽입: start 1:00 end 1:28
 * # 배열 컨트롤러[2단계] : 벡터(Vector)
 * 1. 추가
 * . 값을 입력받아 순차적으로 추가
 * 2. 삭제(인덱스)
 * . 인덱스를 입력받아 해당 위치의 값 삭제
 * 3. 삭제(값)
 * . 값을 입력받아 삭제
 * . 없는 값 입력 시 예외처리
 * 4. 삽입
 * . 인덱스와 값을 입력받아 삽입
 */
import java.util.Scanner;

public class Array_Controller {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = null;
		int cnt = 0;

		while (true) {

			if (arr != null) {
				System.out.print("배열: ");
				for (int i = 0; i < arr.length; i++)
					System.out.print("[" + arr[i] + "] ");
			}
			System.out.println();

			System.out.println("1. 추가 ");
			System.out.println("2. 삭제(인덱스) ");
			System.out.println("3. 삭제(값) ");
			System.out.println("4. 삽입 ");
			System.out.print("메뉴 선택: ");
			int menu = sc.nextInt();

			// 추가
			if (menu == 1) {
				System.out.print("추가할 숫자: ");
				int input = sc.nextInt();
				System.out.println();

				if (cnt == 0) {
					arr = new int[cnt + 1];
					arr[0] = input;
					cnt++;
				} else if (cnt > 0) {
					int[] temp = arr;
					arr = new int[cnt + 1];
					arr[cnt] = input;
					cnt++;
					for (int i = 0; i < cnt - 1; i++)
						arr[i] = temp[i];
					System.out.println("배열 크기는: " + arr.length);
				}

			}

			// 인덱스로 삭제
			else if (menu == 2) {
				System.out.println("삭제할 인덱스: ");
				int delIdx = sc.nextInt();
				if (delIdx > arr.length - 1) {
					System.out.println("삭제 범위가 아닙니다.");
					continue;
				}

				int[] temp = new int[arr.length - 1];
				int count = 0;
				for (int i = 0; i < arr.length; i++)
					if (i != delIdx) {
						temp[count] = arr[i];
						count++;
					}
				arr = temp;
				cnt = arr.length;

			}

			// 값으로 삭제
			else if (menu == 3) {
				System.out.println("삭제할 값: ");
				int delVal = sc.nextInt();
				int check = -1;

				for (int i = 0; i < arr.length; i++)
					if (arr[i] == delVal)
						check++; // 중복되는 숫자 카운트기능까지 포함

				if (check == -1) {
					System.out.println("없는 값입니다.");
					continue;
				}

				else if (check != -1) {
					int[] temp = new int[arr.length - (check + 1)];
					int count = 0;
					for (int i = 0; i < arr.length; i++)
						if (arr[i] != delVal) {
							temp[count] = arr[i];
							count++;
						}
					arr = temp;
					cnt = arr.length;
				}

			}

			// 삽입
			else if (menu == 4) {

				System.out.println("삽입할 값: ");
				int value = sc.nextInt();
				System.out.println("삽입할 위치: ");
				int idx = sc.nextInt();
				if (idx > arr.length) {
					System.out.println("범위밖입니다");
					continue;
				}

				int[] temp = new int[arr.length + 1];
				for (int i = 0; i < arr.length + 1; i++) {
					if (i < idx)
						temp[i] = arr[i];
					else if (i == idx)
						temp[i] = value;
					else if (i > idx)
						temp[i] = arr[i - 1];
				}
				arr = temp;
				cnt = arr.length;
			}

			else if (menu == 5) {
				break;
			}

		}
	}
}
