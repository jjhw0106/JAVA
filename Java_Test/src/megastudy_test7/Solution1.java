package megastudy_test7;

class Student {
	String name;
	int score;

	void print() {
		System.out.println(name + " : " + score);
	}

}

public class Solution1 {
	public static void main(String[] args) {
		String data = "3\n";
		data += "김영희/30\n";
		data += "이만수/40\n";
		data += "이철민/60";

		System.out.println(data);
		String temp[] = data.split("\n");

		int size = Integer.parseInt(temp[0]);

		// 문제1)data에 있는 내용을 잘라서 st에 저장후 출력
		Student[] st = new Student[size];
		for (int i = 0; i < size; i++) {
			st[i] = new Student();
			String info[] = temp[i + 1].split("/");
			st[i].name = info[0];
			st[i].score = Integer.parseInt(info[1]);
		}
		for (int i = 0; i < size; i++) {
			System.out.println(st[i].name + st[i].score);
		}

		// 문제2)꼴등 삭제후 다시 data에 저장
		int min = st[0].score;
		int minIdx = 0;
		for (int i = 0; i < size; i++) {
			if (min > st[i].score) {
				min = st[i].score;
				minIdx = i;
			}
		}

		data = String.valueOf(size);
		data += "\n";
		Student tempSt[] = st;
		st = new Student[size - 1];
		int idx = 0;
		for (int i = 0; i < size; i++) {
			if (i != minIdx) {
				st[idx] = tempSt[i];
				idx++;
			}
		}
		size--;
		for (int i = 0; i < size; i++) {
			data += st[i].name;
			data += String.valueOf(st[i].score);
			data += "\n";
		}
		System.out.println(data);

	}

}
