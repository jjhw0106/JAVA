package file_practice;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;

public class File_Controller {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] datas = null;

		File file = new File("File Controller.txt");



		int line = 0;
		String[] str = null;

		while (true) {

			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기");
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[5]종료하기");
			for (int i = 0; i < line; i++)
				System.out.println(str[i]);
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt(); // 입력받은 숫자 뒤에 자동으로 \n 붙음
			sc.nextLine(); // nextLine() 함수가 이전에 입력받은 숫자 뒤에 있던, \n을 읽음

			// 추가하기
			if (sel == 1) {
				if (line == 0) {
					line++;
					str = new String[line];
					System.out.print("추가할 문장: ");
					str[line - 1] = sc.nextLine();
				} else if (line > 0) {
					line++;
					String[] temp = str;
					str = new String[line];
					System.out.print("추가할 문장: ");
					str[line - 1] = sc.nextLine();
					for (int i = 0; i < line - 1; i++)
						str[i] = temp[i];
				}

			}
			// 삭제하기
			else if (sel == 2) {
				if (line == 0) {
					System.out.println("입력된 값이 존재하지 않습니다.");
					continue;
				}

				System.out.print("삭제할 줄 입력");
				int delLine = sc.nextInt() - 1;
				if (delLine >= line) {
					System.out.println("범위를 벗어났습니다");
					continue;
				}

				line--;
				int cnt = 0;
				String[] temp = new String[line];
				for (int i = 0; i < line + 1; i++)
					if (i != delLine) {
						temp[cnt] = str[i];
						cnt++;
					}
				str = temp;

			}
			// 저장하기
			else if (sel == 3) {
				FileWriter fw = null;

				try {
					fw = new FileWriter(file);
					for (int i = 0; i < line; i++) {
						fw.write(str[i]);
						if (i < line - 1)
							fw.write("\n");
					}

					fw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// 로드하기
//				파일에서 라인 세기
//				str[i]에 문자열 집어넣기
			else if (sel == 4) {
				System.out.println("정말 불러오시겠습니까? " + "\n" + "Y/N");
				String agree = sc.next();
				sc.nextLine();
				if (agree.equals("n") || agree.equals("N"))
					continue;
				else if (agree.equals("y") || agree.equals("Y")) {
					line = 0;
					FileReader fr = null;
					BufferedReader br = null;

					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);

						while (br.readLine() != null)
							line++;
						System.out.println("라인은 : " + line);
						str = new String[line];
						fr.close();
						br.close();

					} catch (Exception e) {
						e.printStackTrace();
					}

					try {
						fr = new FileReader(file);
						br = new BufferedReader(fr);

						for (int i = 0; i < line; i++)
							str[i] = br.readLine();

						fr.close();
						br.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
			// 종료
			else if (sel == 5) {
				System.out.println("프로그램 종료");
				break;
			}

		}
	}

}





//	메가스터디 답안
//Scanner scan = new Scanner(System.in);
//
//int[] vector = null;
//int count = 0;
//
//String fileName = "vector.txt";
//
//while (true) {
//
//	for (int i = 0; i < count; i++) {
//		System.out.print(vector[i] + " ");
//	}
//	System.out.println();
//
//	System.out.println("[벡터 컨트롤러]");
//	System.out.println("[1]추가하기");
//	System.out.println("[2]삭제하기");
//	System.out.println("[3]저장하기");
//	System.out.println("[4]로드하기");
//	System.out.println("[5]종료하기");
//
//	System.out.print("메뉴 선택 : ");
//	int sel = scan.nextInt();
//
//	if (sel == 1) {
//		if (count == 0) {
//			vector = new int[count + 1];
//		} else if (count > 0) {
//			int[] temp = vector;
//			vector = new int[count + 1];
//
//			for (int i = 0; i < count; i++) {
//				vector[i] = temp[i];
//			}
//			temp = null;
//		}
//		System.out.print("[추가]데이터 입력 : ");
//		int data = scan.nextInt();
//
//		vector[count] = data;
//		count += 1;
//	} else if (sel == 2) {
//		System.out.print("[삭제]인덱스 입력 : ");
//		int delIdx = scan.nextInt();
//
//		if (count - 1 < delIdx || delIdx < 0) {
//			System.out.println("[메세지]해당 위치는 삭제할 수 없습니다.");
//			continue;
//		}
//
//		if (count == 1) {
//			vector = null;
//		} else if (count > 1) {
//			int[] temp = vector;
//			vector = new int[count - 1];
//
//			int j = 0;
//			for (int i = 0; i < count; i++) {
//				if (i != delIdx) {
//					vector[j] = temp[i];
//					j += 1;
//				}
//			}
//			temp = null;
//		}
//		count -= 1;
//	} else if (sel == 3) {
//
//		String data = "";
//		if (count > 0) {
//			for (int i = 0; i < count; i++) {
//				data += vector[i];
//				data += "\n";
//			}
//			data = data.substring(0, data.length() - 1); //****
//
//			FileWriter fw = null;
//			try {
//				fw = new FileWriter(fileName);
//				fw.write(data);
//				fw.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else {
//			System.out.println("[메세지]저장할 데이터가 없습니다.");
//		}
//
//	} else if (sel == 4) {
//		String data = "";
//
//		FileReader fr = null;
//		BufferedReader br = null;
//		try {
//			fr = new FileReader(fileName);
//			br = new BufferedReader(fr);
//
//			while (true) {
//				String line = br.readLine();
//				if (line == null) {
//					break;
//				}
//				data += line;
//				data += "\n";
//			}
//			data = data.substring(0, data.length() - 1);
//
//			String[] temp = data.split("\n");
//			count = temp.length;
//
//			vector = new int[count];
//
//			for (int i = 0; i < count; i++) {
//				vector[i] = Integer.parseInt(temp[i]);
//			}
//			fr.close();
//			br.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	} else if (sel == 5) {
//		System.out.println("프로그램 종료");
//		break;
//	}
//
//}
//
//}
//}
