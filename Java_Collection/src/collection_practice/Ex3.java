package collection_practice;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
	String id;
	String pw;

	void show_inf() {
		System.out.println("id: " + id + " pw: " + pw);
	}
}

class Management {
	File file = new File("회원가입.txt");
	ArrayList<Student> list = new ArrayList<>();

	void add_student(Student st) {
		list.add(st);
	}

	Student remove_student(int idx) {
		Student del_st = new Student();
		del_st = list.get(idx);
		list.remove(idx);
		return del_st;
	}

	int id_check(String id) {
		int check = -1;
		for (int i = 0; i < list.size(); i++) {
			if (id.equals(list.get(i).id)) {
				check = i;
				break;
			}
		}
		return check;
	}

	void save() {
		FileWriter fw = null;
		String data;
		try {
			fw = new FileWriter(file);
			for (int i = 0; i < list.size(); i++) {
				data = list.get(i).id;
				data += "/";
				data += list.get(i).pw;
				if (i != list.size() - 1) {
					data += "\n";
				}
				fw.write(data);
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void load() {
		FileReader fr = null;
		BufferedReader br = null;
		int cnt = 0;
		if (file.exists()) {
			
			//q. 답지에서 사이즈 받아오는거 질문
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				while (true) {
					if (br.readLine() != null)
						cnt++;
					else if (br.readLine() == null)
						break;
				}
				fr.close();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				for (int i = 0; i < cnt; i++) {
					String data[] = br.readLine().split("\n");
					String arr[] = data[0].split("/");
					Student temp = new Student();
					temp.id = arr[0];
					temp.pw = arr[1];
					list.add(temp);
				}
				fr.close();
				br.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	void order() {
		int idx = 0;
		while (idx < list.size()) {
			for (int i = idx; i < list.size(); i++) {
				if (list.get(idx).id.compareTo(list.get(i).id) > 0) {
					Student temp = list.get(idx);
					list.set(idx, list.get(i));
					list.set(i, temp);
				}
			}
			idx++;
		}
	}

	void show() {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).show_inf();

		}
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("학생 관리");
		while (true) {
			if (file.exists()) {
				load();
			}
			System.out.println("==========================");
			System.out.println("1.회원 가입");
			System.out.println("2.회원 탈퇴");
			System.out.println("3.정렬");
			System.out.println("4.조회");
			System.out.println("5.저장");
			System.out.println("6.불러오기");
			System.out.println("7.종료");
			System.out.println("==========================");
			System.out.print("메뉴 선택: ");
			int sel = sc.nextInt();
			if (sel == 1) {
				Student temp = new Student();
				System.out.print("id입력: ");
				temp.id = sc.next();
				int check = id_check(temp.id);
				if (check != -1) {
					System.out.println("중복된 ID입니다.");
					continue;
				}

				System.out.print("pw입력: ");
				temp.pw = sc.next();
				add_student(temp);
				System.out.println(temp.id + "님 가입을 축하드립니다.");
			} else if (sel == 2) {
				Student temp = new Student();
				System.out.println("탈퇴할 id를 입력하세요");
				temp.id = sc.next();
				int check = id_check(temp.id);
				if (check == -1) {
					System.out.println("존재하지 않는 ID입니다.");
					continue;
				}
				Student del_st = remove_student(check);
				System.out.println(del_st.id + "님 회원탈퇴 되셨습니다.");

			} else if (sel == 3) {
				order();
			} else if (sel == 4) {
				show();
			} else if (sel == 5) {
				save();
			} else if (sel == 6) {
				load();
			} else if (sel == 7) {
				break;
			}
		}
	}

}

public class Ex3 {
	public static void main(String[] args) {
		Management mg = new Management();
		mg.run();

	}
}
