package file_practice;

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class File_Jangbasket {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 정답을 실행해보고 결과를 보고 다시 풀때 사용

		String[] ids = { "qwer", "javaking", "abcd" };
		String[] pws = { "1111", "2222", "3333" };
		String[] items = { "사과", "바나나", "딸기" };

		int size = ids.length;
		int[][] status = new int[items.length][1];

		final int MAX_SIZE = 100;
		int[][] jang = new int[MAX_SIZE][2];
//		int itemCount[] = new int[items.length];

		File file = new File("jang.txt");
		File list = new File("shoppingList.txt");//
		int count = 0;
		int log = -1;

//		회원정보
//		상태(아이디/비번/구매목록)
//		장바구니->현재 로그인 되어있는 id의 구매목록(아이템-몇개 \n 아이템-몇개)

		while (true) {

			for (int i = 0; i < ids.length; i++) {
				System.out.print(ids[i] + " : " + pws[i] + "(");
				for (int j = 0; j < count; j++)
					if (jang[j][0] == i)
						System.out.print(items[jang[j][1]] + "/");
				System.out.println(")");
			}

			System.out.println("=====================");
			if (log != -1)
				System.out.println("<<" + ids[log] + ">> 님 환영합니다.");
			System.out.println("[MEGA SHOP]");
			System.out.println("[1]로그인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]쇼핑");
			System.out.println("[4]장바구니");
			System.out.println("[5]저장");
			System.out.println("[6]로드");
			System.out.println("[0]종료");

			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();

			// 로그인
			if (sel == 1) {

				System.out.print("id: ");
				String inputId = sc.next();
				System.out.print("비밀번호: ");
				String inputPw = sc.next();

				for (int i = 0; i < size; i++)
					if (inputId.equals(ids[i]) && inputPw.equals(pws[i])) {
						System.out.println("로그인 되었습니다.");
						log = i;
						break;
					}
				if (log == -1)
					System.out.println("id또는 pw를 확인하세요");

			}

			// 로그아웃
			else if (sel == 2) {
				if (log == -1) {
					System.out.println("이미 로그아웃상태입니다");
					continue;
				}
				System.out.println("로그아웃 되셨습니다");
				log = -1;
			}

			// 쇼핑
			else if (sel == 3) {
				if (log == -1) {
					System.out.println("먼저 로그인을 하세요");
					continue;
				}

				System.out.println("뭘 사시겠습니까");
				for (int i = 0; i < items.length; i++)
					System.out.println(i + 1 + ". " + items[i]);

				int buy = sc.nextInt() - 1;
				jang[count][0] = log;
				jang[count][1] = buy;
				count++;
			}

			// 장바구니
			else if (sel == 4) {
				if (log == -1) {
					System.out.println("먼저 로그인을 하세요");
					continue;
				}
				int itemCount[] = new int[items.length];
				for (int i = 0; i < count; i++)
					for (int j = 0; j < items.length; j++)
						if (jang[i][0] == log && jang[i][1] == j)
							itemCount[j]++;

				System.out.println("장바구니 목록은: ");
				for (int j = 0; j < items.length; j++)
					System.out.println(items[j] + ": " + itemCount[j]);
			}

			else if (sel == 5) {
				FileWriter fw = null;
				String[] data = new String[ids.length];
				String[] sList = new String[jang.length];
				try {
					fw = new FileWriter(file);
					for (int i = 0; i < ids.length; i++) {
						data[i] = ids[i];
						data[i] += "/";
						data[i] += pws[i];
						fw.write(data[i]);
						if (i < ids.length - 1)
							fw.write("\n");
					}
					fw.close();

					fw = new FileWriter(list);
					for (int i = 0; i < count; i++) {
						sList[i] = "";
						sList[i] += jang[i][0];
						sList[i] += "/";
						sList[i] += jang[i][1];
						fw.write(sList[i]);
						if (i < count - 1)
							fw.write("\n");
					}
					fw.close();// 이게 for문에 들어가 있으면 위에서 선언해준 new file이 닫힌다
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			else if (sel == 6) {
				FileReader fr = null;
				BufferedReader br = null;
				int listCnt = 0;
				try {
					fr = new FileReader(list);
					br = new BufferedReader(fr);

					while (br.readLine() != null)
						listCnt++;
					fr.close();
					br.close();

				} catch (Exception e) {
					e.printStackTrace();
				}

				// 아이디, 비밀번호 불러오기
				try {
					fr = new FileReader(file);
					br = new BufferedReader(fr);
					String data[] = new String[ids.length];
					for (int i = 0; i < ids.length; i++)
						data[i] = br.readLine();
					for (int i = 0; i < ids.length; i++) {
						String arr[] = data[i].split("/");
						ids[i] = arr[0];
						pws[i] = arr[1];
					}
					fr.close();
					br.close();

				} catch (Exception e) {
					e.printStackTrace();
				}

				// 쇼핑 목록 불러오기
				try {
					fr = new FileReader(list);
					br = new BufferedReader(fr);
					String data[] = new String[listCnt];
					for (int i = 0; i < listCnt; i++)
						data[i] = br.readLine();
					count = listCnt;
//					System.out.println("체크" + listCnt + " " + count);

					for (int i = 0; i < listCnt; i++) {
						String[] arr = data[i].split("/");
						jang[i][0] = Integer.parseInt(arr[0]);
						jang[i][1] = Integer.parseInt(arr[1]);
					}
					fr.close();
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			else if (sel == 0) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
}


		//메가스터디 답안
//		Scanner scan = new Scanner(System.in);
//
//		String[] ids = { "qwer", "javaking", "abcd" };
//		String[] pws = { "1111", "2222", "3333" };
//		String[] items = { "사과", "바나나", "딸기" };
//
//		final int MAX_SIZE = 100;
//		int[][] jang = new int[MAX_SIZE][2];
//
//		String fileName = "jang.txt";
//
//		int count = 0;
//		int log = -1;
//
//		while (true) {
//
//			System.out.println("-----------");
//			for (int i = 0; i < 3; i++) {
//				System.out.print(ids[i] + " : " + pws[i] + "(");
//				for (int j = 0; j < count; j++) {
//					if (jang[j][0] == i) {
//						if (jang[j][1] == 1) {
//							System.out.print("사과");
//						} else if (jang[j][1] == 2) {
//							System.out.print("바나나");
//						} else if (jang[j][1] == 3) {
//							System.out.print("딸기");
//						}
//						System.out.print("/");
//					}
//				}
//				System.out.println(")");
//			}
//			System.out.println("-----------");
//			System.out.print("상태 : ");
//			if (log == -1) {
//				System.out.println("로그아웃");
//			} else {
//				System.out.println(ids[log] + "님, 로그인");
//			}
//			System.out.println("-----------");
//
//			System.out.println("[MEGA SHOP]");
//			System.out.println("[1]로그인");
//			System.out.println("[2]로그아웃");
//			System.out.println("[3]쇼핑");
//			System.out.println("[4]장바구니");
//			System.out.println("[5]저장");
//			System.out.println("[6]로드");
//			System.out.println("[0]종료");
//
//			System.out.print("메뉴 선택 : ");
//			int sel = scan.nextInt();
//
//			if (sel == 1) {
//				if (log == -1) {
//					System.out.print("[로그인]ID 입력 : ");
//					String id = scan.next();
//					System.out.print("[로그인]PW 입력 : ");
//					String pw = scan.next();
//
//					for (int i = 0; i < 3; i++) {
//						if (ids[i].equals(id) && pws[i].equals(pw)) {
//							log = i;
//						}
//					}
//
//					if (log == -1) {
//						System.out.println("[메세지]ID와 Pw를 확인해주세요.");
//					} else {
//						System.out.println("[메세지]" + ids[log] + "님, 환영합니다.");
//					}
//				} else {
//					System.out.println("[메세지]현재" + ids[log] + "님, 로그인 중...");
//				}
//			} else if (sel == 2) {
//				if (log != -1) {
//					log = -1;
//					System.out.println("[메세지]로그아웃 되었습니다.");
//				} else {
//					System.out.println("[메세지]로그인 후 이용가능합니다.");
//				}
//			} else if (sel == 3) {
//				if (log != -1) {
//					for (int i = 0; i < items.length; i++) {
//						System.out.println((i + 1) + "." + items[i]);
//					}
//					System.out.print("[쇼핑]상품번호를 선택하세요 : ");
//					int idx = scan.nextInt();
//
//					jang[count][0] = log;
//					jang[count][1] = idx;
//					count += 1;
//					System.out.println("[메세지]장바구니에 담겼습니다.");
//				} else {
//					System.out.println("[메세지]로그인 후 이용가능합니다.");
//				}
//			} else if (sel == 4) {
//				if (log != -1) {
//					System.out.println("[" + ids[log] + "님의 장바구니]");
//
//					int j = 0;
//					for (int i = 0; i < count; i++) {
//						if (log == jang[i][0]) {
//							System.out.print((j + 1) + ".");
//							if (jang[i][1] == 1) {
//								System.out.println("사과");
//							} else if (jang[i][1] == 2) {
//								System.out.println("바나나");
//							} else if (jang[i][1] == 3) {
//								System.out.println("딸기");
//							}
//							j += 1;
//						}
//					}
//				} else {
//					System.out.println("[메세지]로그인 후 이용가능합니다.");
//				}
//			} else if (sel == 5) {
//				String data = "";
//
//				// # 장바구니 정보 저장하기
//				for (int i = 0; i < count; i++) {
//					data += jang[i][0];
//					data += "/";
//					data += jang[i][1];
//					data += "\n";
//				}
//				data = data.substring(0, data.length() - 1);
//				System.out.println(data);
//
//				FileWriter fw = null;
//				try {
//					fw = new FileWriter(fileName);
//					fw.write(data);
//					fw.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				System.out.println("[메세지]저장을 완료하였습니다.");
//			} else if (sel == 6) {
//				File file = new File(fileName);
//				if (file.exists()) {
//					FileReader fr = null;
//					BufferedReader br = null;
//					try {
//						fr = new FileReader(file);
//						br = new BufferedReader(fr);
//
//						count = 0;
//						String line = br.readLine();
//						while (line != null) {
//							String[] temp = line.split("/");
//							jang[count][0] = Integer.parseInt(temp[0]);
//							jang[count][1] = Integer.parseInt(temp[1]);
//
//							count += 1;
//
//							line = br.readLine();
//						}
//						fr.close();
//						br.close();
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					System.out.println("[메세지]파일을 불러왔습니다.");
//				}
//			} else if (sel == 0) {
//				System.out.println("프로그램 종료");
//				break;
//			}
//		}
//
//	}
//}