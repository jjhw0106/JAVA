
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

//id, 비밀번호, 정렬, 출력, 저장,로드
class Student {
	String id;
	String pw;

}

class Manage {
	File file = new File("학생 ID관리.txt");
	Scanner sc = new Scanner(System.in);
	Student st[] = null;
	int studentNum = 0;

	// 회원가입
	void join() {
		Student temp[] = null;
		if (studentNum == 0) {
			st = new Student[1];
			st[0] = new Student();
			this.studentNum++;
		} else {
			temp = st;// 이동
			st = new Student[studentNum + 1];
			st[studentNum] = new Student();
			studentNum++;
			for (int i = 0; i < studentNum - 1; i++) {
				st[i] = new Student();
				st[i] = temp[i];
			}
		}
		boolean duplicate = false;
		System.out.println("가입할 id: ");
		String getId = sc.next();
		for (int i = 0; i < studentNum; i++) {
			if (getId.equals(st[i].id)) {
				duplicate = true;
				break;
			}
		}
		if (duplicate == true) {
			studentNum--;
			System.out.println("중복된 아이디입니다.");
		} else {
			System.out.print("비밀번호: ");
			String getPw = sc.next();

			st[studentNum - 1].id = getId;
			st[studentNum - 1].pw = getPw;
		}
	}

	// 회원탈퇴
	void withdrawal() {
		if (studentNum == 0) {
			System.out.println("더 이상 회원이 없습니다.");
		} else {
			System.out.print("탈퇴할 id: ");
			String delId = sc.next();
			Student temp[] = st;
			int check = -1;
			for (int i = 0; i < studentNum; i++) {
				if (delId.equals(temp[i].id)) {
					for (int j = i; j < studentNum; j++) {
						if (j == studentNum - 1) {
							check = 1;
						} else {
							temp[j] = temp[j + 1];
							check = 1;
						}
					}

				} else if (delId.equals(temp[i].id) && i == studentNum - 1) {
					temp[i] = null;
					break;
				}
			}

			if (check == -1) {
				System.out.println("없는 id입니다");
			} else {

				System.out.println("성공적으로 탈퇴되었습니다.");
				temp[studentNum - 1] = null;
				studentNum--;
			}
			st = new Student[studentNum];
			for (int i = 0; i < st.length; i++) {
				st[i] = temp[i];
			}
		}
	}

	// 오름차순
	void ascending() {
		for (int i = 0; i < st.length; i++)
			for (int j = i; j < st.length; j++)
				if (st[i].id.compareTo(st[j].id) > 0) {
					Student temp = st[i];
					st[i] = st[j];
					st[j] = temp;
				}
	}

	// 내림차순
	void descending() {
		for (int i = 0; i < st.length; i++)
			for (int j = i; j < st.length; j++)
				if (st[i].id.compareTo(st[j].id) < 0) {
					Student temp = st[i];
					st[i] = st[j];
					st[j] = temp;
				}
	}

	// 메모장 데이터 저장
	void save() {
		FileWriter fw = null;
		String data[] = new String[st.length];
		try {
			fw = new FileWriter(file);
			for (int i = 0; i < studentNum; i++) {
				data[i] = st[i].id;
				data[i] += "/";
				data[i] += st[i].pw;
				fw.write(data[i]);
				if (i < st.length - 1)
					fw.write("\n");
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 데이터 불러오기
	void load() {
		FileReader fr = null;
		BufferedReader br = null;
		int getLength = 0;
		if (file.exists()) {
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				while (true) {
					if (br.readLine() == null) {
						break;
					}
					getLength++;
				}
				fr.close();
				br.close();
			} catch (Exception e) {

			}
			try {
				this.st = new Student[getLength];
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				for (int i = 0; i < getLength; i++) {
					String arr[] = br.readLine().split("/");
					st[i] = new Student();
					st[i].id = arr[0];
					st[i].pw = arr[1];
					studentNum = getLength;
				}
				fr.close();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("파일이 없습니다.");
		}
	}

	void show() {
		System.out.println("========================");
		System.out.println("학생수: " + studentNum);
		for (int i = 0; i < studentNum; i++) {
			System.out.print((i + 1) + ". 회원 id: " + st[i].id + "  ");
			System.out.print("pw: " + st[i].pw);
			System.out.println();
		}
		System.out.println("========================");
	}

	// 프로그램 실행 메서드
	void run() {
		if (file.exists()) {
			load();
		}
		while (true) {

			int sel = 0;
			System.out.println("1. 회원가입");
			System.out.println("2. 회원탈퇴");
			System.out.println("3. 오름차순 정렬");
			System.out.println("4. 내림차순 정렬");
			System.out.println("5. 출력");
			System.out.println("6. 저장");
			System.out.println("7. 불러오기");
			System.out.println("8. 종료");
			sel = sc.nextInt();

			if (sel == 1) {
				this.join();
			} else if (sel == 2) {
				this.withdrawal();
			} else if (sel == 3) {
				ascending();
			} else if (sel == 4) {
				descending();
			} else if (sel == 5) {
				show();
			} else if (sel == 6) {
				save();
			} else if (sel == 7) {
				load();
			} else if (sel == 8) {
				break;
			}

		}
	}

}

public class Student_Management {
	public static void main(String[] args) {
		Manage mg = new Manage();
		mg.run();
	}
}
