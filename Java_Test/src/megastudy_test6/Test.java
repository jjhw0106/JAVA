package megastudy_test6;

import java.util.Scanner;

//좌표 y , x 를 입력받고 block 에 잇는 내용을 data 에 복사 
// 예) 1, 1
/*
    "0,0,0,0,0,1,0,0,0,0\n";
	"0,2,2,2,2,1,0,0,0,0\n";
	"0,0,0,0,0,1,0,0,0,0\n";
	"0,0,1,1,1,1,1,1,0,0\n";
	"0,0,0,0,0,1,0,0,0,0\n";
	"0,0,0,0,0,1,0,0,0,0\n";
	"0,0,0,0,0,1,0,0,0,0\n";
	"0,0,0,0,0,1,0,0,0,0\n";
	"0,0,0,0,0,1,0,0,0,0\n";
	"0,0,0,0,0,0,0,0,0,0\n";
 */
// 조건) 단 ! 만약에 2222가 1에 닿으면 "복사할수없는자리입니다" 출력 
// 예) 2, 3 ==> 이자리는2222 의  3번째 자리가 1이기때문에 복사할수 없다.
/*
"0,0,0,0,0,1,0,0,0,0\n";
"0,0,0,0,0,1,0,0,0,0\n";
"0,0,0,2,2,2,2,0,0,0\n";  // 1을 지우므로 안되다. 
"0,0,1,1,1,1,1,1,0,0\n";
"0,0,0,0,0,1,0,0,0,0\n";
"0,0,0,0,0,1,0,0,0,0\n";
"0,0,0,0,0,1,0,0,0,0\n";
"0,0,0,0,0,1,0,0,0,0\n";
"0,0,0,0,0,1,0,0,0,0\n";
"0,0,0,0,0,0,0,0,0,0\n";
*/

class TestFunc {
	Scanner sc = new Scanner(System.in);

	String map[][] = new String[10][10];
	String splitArr[] = new String[100];

	void dataSplit(String data) {
		String newData = "";
		String arr[] = data.split("\n");
		for (int i = 0; i < arr.length; i++) {
			newData += arr[i];
			newData += ",";
		}
		splitArr = newData.split(",");

	}

	void getData() {
		int k = 0;
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {
				map[i][j] = splitArr[k];
				k++;
			}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	void posChoice(String block) {

		System.out.println("y: ");
		int yIdx = sc.nextInt();
		int check = 1;
		System.out.println("x: ");
		String arr[] = block.split(",");

		int xIdx = sc.nextInt();
		if (xIdx > 10 - arr.length) {
			System.out.println(1);
			System.out.println("놓을 수 없는 자리입니다");
		}

		else {
			for (int j = xIdx; j < xIdx + arr.length; j++) {
				if (map[yIdx][j].equals("1")) {
					System.out.println(2);
					System.out.println("놓을 수 없는 자리입니다");
					check = -1;
					break;
				}
			}

			if (check == 1) {
				for (int j = xIdx; j < xIdx + arr.length; j++) {
					map[yIdx][j] = arr[0]; //
				}
			}
		}
	}

	void show() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	void run() {
		String data = "";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,1,1,1,1,1,1,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,1,0,0,0,0\n";
		data += "0,0,0,0,0,0,0,0,0,0\n";

		String block = "";
		block += "2,2,2,2";
		dataSplit(data);
		getData();
		while (true) {
			posChoice(block);
			show();

		}
	}

}

public class Test {
	public static void main(String[] args) {
		TestFunc t = new TestFunc();
		t.run();
	}
}
