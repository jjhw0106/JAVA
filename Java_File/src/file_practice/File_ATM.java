package file_practice;

import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;

public class File_ATM {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int size = 5;
		int count = 0;

		String[] accs = new String[size];
		String[] pws = new String[size];
		int[] moneys = new int[size];

		File fileClient = new File("Client.txt");
		File fileAccount = new File("Account.txt");

		int lIdx = 0;
		String logId = null;
		String logPw = null;
		int logIdx = 0;
		int log = -1;
		while (true) {

//			회원 데이터파일
//			잔액 데이터파일
//			
//			로그인~로그아웃=>프로그램 상에서
//			
//			입금,출금,이체=>실시간으로
//			잔액조회 -> 회원-잔액
//			
//			로드->시행하면 바로 되게끔
//			
			for (int i = 0; i < lIdx; i++)
				if (accs[i] != null)
					System.out.println(accs[i] + "/" + pws[i] + "/" + moneys[i] + "," + lIdx);

			System.out.println("======================");
			if (log == 1)
				System.out.println(logId + "님이 로그인 중입니다");
			System.out.println("[MEGA ATM]");
			System.out.println("[1]회원가입");
			System.out.println("[2]회원탈퇴");
			System.out.println("[3]로그인");
			System.out.println("[4]로그아웃");
			System.out.println("[5]입금");
			System.out.println("[6]출금");
			System.out.println("[7]이체");
			System.out.println("[8]잔액조회");
			System.out.println("[9]저장");
			System.out.println("[10]로드");
			System.out.println("[0]종료");

			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();

			// 회원가입

			if (sel == 1) {
				if (log == 1) {
					System.out.println("로그인 되어있습니다");
					continue;
				}
				if (lIdx >= size) {
					System.out.println("더이상 가입할 수 없습니다");
					continue;
				}
				int check = 1;
				System.out.print("id: ");
				String id = sc.next();
				for (int i = 0; i < lIdx; i++)
					if (id.equals(accs[i])) {
						check = -1;
						break;
					}
				if (check == -1)
					System.out.println("이미 있는 아이디입니다.");
				else if (check == 1) {
					accs[lIdx] = id;
					System.out.print("비밀번호: ");
					String pw = sc.next();
					pws[lIdx] = pw;
					lIdx++;
				}
			}

			// 회원탈퇴
			else if (sel == 2) {
				if (log != 1) {
					System.out.println("로그인을 먼저 하세요");
					continue;
				}

				System.out.println("정말 탈퇴하시겠습니까? y/n");
				String remove = sc.next();

				if (moneys[logIdx] != 0) {
					System.out.println("돈이 남아있습니다");
					continue;
				}
				if (remove.equals("n"))
					continue;

				else if (remove.equals("y")) {
					String[] tempId = new String[lIdx];
					String[] tempPw = new String[lIdx];
					int[] tempMn = new int[lIdx];
					int cnt = 0;
					for (int i = 0; i < lIdx; i++)
						if (i != logIdx) {
							tempId[cnt] = accs[i];
							tempPw[cnt] = pws[i];
							tempMn[cnt] = moneys[i];
							cnt++;
						}
					for (int i = 0; i < lIdx; i++) {
						accs[i] = tempId[i];
						pws[i] = tempPw[i];
						moneys[i] = tempMn[i];
					}
					lIdx--;
					log = -1;
				}

			}

			// 로그인
			else if (sel == 3) {
				logId = "";
				logPw = "";
				logIdx = 0;
				int check = 0;

				System.out.print("id: ");
				logId = sc.next();

				for (int i = 0; i < lIdx; i++)
					if (logId.equals(accs[i])) {
						logIdx = i;
						check++;
						break;
					}
				if (check == 1) {
					System.out.print("비밀번호: ");
					logPw = sc.next();
					if (logPw.equals(pws[logIdx]))
						check++;
				} else if (check != 1) {
					System.out.println("없는 아이디입니다.");
					continue;
				}

				if (check == 2) {
					System.out.println(logId + "님 환영합니다");
					log = 1;
				} else
					System.out.println("비밀번호가 틀렸습니다");
			}

			// 로그아웃
			else if (sel == 4) {
				if (log != 1) {
					System.out.println("로그인을 먼저 하세요");
					continue;
				}
				System.out.println("로그아웃 되셨습니다");
				log = -1;
			}

			// 입금
			else if (sel == 5) {
				System.out.println(333);
				if (log != 1) {
					System.out.println("로그인을 먼저 하세요");
					continue;
				}
				System.out.println("현재 잔고: " + moneys[logIdx]);
				int deposit = 0;
				System.out.print("입금할 금액: ");
				deposit = sc.nextInt();
				moneys[logIdx] += deposit;

			}

			// 출금
			else if (sel == 6) {
				if (log != 1) {
					System.out.println("로그인을 먼저 하세요");
					continue;
				}

				int withdraw = 0;
				System.out.println("현재 잔고: " + moneys[logIdx]);
				System.out.println("출금할 금액: ");

				withdraw = sc.nextInt();
				if (withdraw > moneys[logIdx])
					System.out.println("잔액이 부족합니다");
				else if (withdraw <= moneys[logIdx])
					moneys[logIdx] -= withdraw;
			}

			// 이체
			else if (sel == 7) {
				if (log != 1) {
					System.out.println("로그인을 먼저 하세요");
					continue;
				}
				System.out.println("얼마 이체하시겠습니까");
				int tranM = sc.nextInt();
				int tranIdx = 0;
				int tranCheck = -1;
				String tranC;

				if (tranM > moneys[logIdx]) {
					System.out.println("잔액이 부족합니다");
					continue;
				}

				else if (tranM <= moneys[logIdx]) {
					System.out.println("누구에게 보내겠습니까?");
					tranC = sc.next();
					for (int i = 0; i < lIdx; i++) {
						System.out.println(lIdx);
						if (accs[i].equals(tranC)) {
							tranIdx = i;
							tranCheck = 1;
							break;
						}
					}
				}

				if (tranCheck == 1) {
					moneys[logIdx] -= tranM;
					moneys[tranIdx] += tranM;
				} else if (tranCheck == -1) {
					System.out.println("없는 id입니다");
				}

			} else if (sel == 8) {
				if (log != 1) {
					System.out.println("로그인을 먼저 하세요");
					continue;
				}
			}

			// 저장하기
			else if (sel == 9) {
//				if (log != 1) {
//					System.out.println("로그인을 먼저 하세요");
//					continue;
//				}
				FileWriter fw = null;
				String[] data = new String[lIdx];
				try {
					fw = new FileWriter(fileClient);
					for (int i = 0; i < lIdx; i++) {
						data[i] = accs[i];
						data[i] += "/";
						data[i] += pws[i];
						data[i] += "/";
						data[i] += moneys[i];
						fw.write(data[i]);
						if (i < lIdx - 1)
							fw.write("\n");
					}
					fw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			// 로드
			else if (sel == 10) {

				System.out.println("데이터 불러오기");
				FileReader fr = null;
				BufferedReader br = null;
				String[] data = null;
				lIdx = 0; // idx or 라인 수 동기화 까먹지 말기**

				try {
					fr = new FileReader(fileClient);
					br = new BufferedReader(fr);

					while (br.readLine() != null) {
						lIdx++;
					}

					fr.close();
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					fr = new FileReader(fileClient);
					br = new BufferedReader(fr);
					data = new String[lIdx];

					for (int i = 0; i < lIdx; i++)
						data[i] = br.readLine();

					fr.close();
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				for (int i = 0; i < lIdx; i++) {
					String arr[] = data[i].split("/");
					accs[i] = arr[0];
					pws[i] = arr[1];
					moneys[i] = Integer.parseInt(arr[2]);

				}

			} else if (sel == 0) {
				break;
			}

		}
	}
}

//
////
//Scanner scan = new Scanner(System.in);
//
//int size = 5;
//
//int count = 0;
//
//int log = -1;
//
//String[] accs = new String[size];
//
//String[] pws = new String[size];
//
//int[] moneys = new int[size];
//
//String fileName = "atm.txt";
//
//while (true) {
//
//	System.out.println("------------");
//
//	for (int i = 0; i < count; i++) {
//
//		System.out.println(accs[i] + ":" + pws[i] + ":" + moneys[i]);
//
//	}
//
//	System.out.println("------------");
//
//	if (log == -1) {
//
//		System.out.println("상태 : 로그아웃");
//
//	} else {
//
//		System.out.println("상태 : " + accs[log] + "님, 로그인");
//
//	}
//
//	System.out.println("------------");
//
//	System.out.println("[MEGA ATM]");
//
//	System.out.println("[1]회원가입");
//
//	System.out.println("[2]회원탈퇴");
//
//	System.out.println("[3]로그인");
//
//	System.out.println("[4]로그아웃");
//
//	System.out.println("[5]입금");
//
//	System.out.println("[6]출금");
//
//	System.out.println("[7]이체");
//
//	System.out.println("[8]잔액조회");
//
//	System.out.println("[9]저장");
//
//	System.out.println("[10]로드");
//
//	System.out.println("[0]종료");
//
//	System.out.print("메뉴 선택 : ");
//
//	int sel = scan.nextInt();
//
//	if (sel == 1) {
//
//		System.out.print("[가입]계좌번호 입력 : ");
//
//		String acc = scan.next();
//
//		int check = 1;
//
//		for (int i = 0; i < count; i++) {
//
//			if (accs[i].equals(acc)) {
//
//				check = -1;
//
//			}
//
//		}
//
//		if (check == 1) {
//
//			if (count == 5) {
//
//				System.out.println("[메세지]더이상 가입할 수 없습니다.");
//
//				continue;
//
//			}
//
//			System.out.print("[가입]비밀번호 입력 : ");
//
//			String pw = scan.next();
//
//			accs[count] = acc;
//
//			pws[count] = pw;
//
//			moneys[count] = 1000;
//
//			count += 1;
//
//			System.out.println("[메세지]회원가입을 축하합니다.");
//
//		} else {
//
//			System.out.println("[메세지]계좌번호가 중복됩니다.");
//
//		}
//
//	}
//
//	else if (sel == 2) {
//
//		if (log != -1) {
//
//			for (int i = log; i < count - 1; i++) {
//
//				accs[i] = accs[i + 1];
//
//				pws[i] = pws[i + 1];
//
//				moneys[i] = moneys[i + 1];
//
//			}
//
//			count -= 1;
//
//			log = -1;
//
//			System.out.println("[메세지]탈퇴되었습니다.");
//
//		} else {
//
//			System.out.println("[메세지]로그인 후 이용가능합니다.");
//
//		}
//
//	}
//
//	else if (sel == 3) {
//
//		if (log == -1) {
//
//			System.out.print("[로그인]계좌번호를 입력 : ");
//
//			String acc = scan.next();
//
//			System.out.print("[로그인]비밀번호 입력 : ");
//
//			String pw = scan.next();
//
//			for (int i = 0; i < count; i++) {
//
//				if (accs[i].equals(acc) && pws[i].equals(pw)) {
//
//					log = i;
//
//				}
//
//			}
//
//			if (log == -1) {
//
//				System.out.println("[메세지]계좌번호와 비밀번호를 확인해주세요.");
//
//			}
//
//		} else {
//
//			System.out.println("[메세지]" + accs[log] + "님, 로그인 중...");
//
//		}
//
//	}
//
//	else if (sel == 4) {
//
//		if (log == -1) {
//
//			System.out.println("[메세지]로그인 후 이용가능합니다.");
//
//		} else {
//
//			log = -1;
//
//			System.out.println("[메세지]로그아웃 되었습니다.");
//
//		}
//
//	}
//
//	else if (sel == 5) {
//
//		if (log != -1) {
//
//			System.out.print("[입금]금액 입력 : ");
//
//			int money = scan.nextInt();
//
//			moneys[log] += money;
//
//			System.out.println("[메세지]입금을 완료하였습니다.");
//
//		} else {
//
//			System.out.println("[메세지]로그인 후 이용가능합니다.");
//
//		}
//
//	}
//
//	else if (sel == 6) {
//
//		if (log != -1) {
//
//			System.out.print("[출금]금액 입력 : ");
//
//			int money = scan.nextInt();
//
//			if (moneys[log] >= money) {
//
//				moneys[log] -= money;
//
//				System.out.println("[메세지]출금을 완료하였습니다.");
//
//			} else {
//
//				System.out.println("[메세지]잔액이 부족합니다.");
//
//			}
//
//		} else {
//
//			System.out.println("[메세지]로그인 후 이용가능합니다.");
//
//		}
//
//	}
//
//	else if (sel == 7) {
//
//		if (log != -1) {
//
//			System.out.print("[이체]계좌번호 입력 : ");
//
//			String acc = scan.next();
//
//			int check = -1;
//
//			for (int i = 0; i < count; i++) {
//
//				if (accs[i].equals(acc)) {
//
//					check = i;
//
//				}
//
//			}
//
//			if (check != -1) {
//
//				System.out.print("[이체]금액 입력 : ");
//
//				int money = scan.nextInt();
//
//				if (moneys[log] >= money) {
//
//					moneys[log] -= money;
//
//					moneys[check] += money;
//
//					System.out.println("[메세지]이체를 완료하였습니다.");
//
//				} else {
//
//					System.out.println("[메세지]잔액이 부족합니다.");
//
//				}
//
//			} else {
//
//				System.out.println("[메세지]계좌번호를 확인해주세요.");
//
//			}
//
//		} else {
//
//			System.out.println("[메세지]로그인 후 이용가능합니다.");
//
//		}
//
//	}
//
//	else if (sel == 8) {
//
//		if (log != -1) {
//
//			System.out.println(accs[log] + "님의 계좌잔액은 " + moneys[log] + "원 입니다.");
//
//		} else {
//
//			System.out.println("[메세지]로그인 후 이용가능합니다.");
//
//		}
//
//	}
//
//
//else if (sel == 9) {
//
//		if (count == 0) {
//
//			System.out.println("[메세지]저장할 데이터가 없습니다.");
//
//			continue;
//
//		}
//
//		String data = "";
//
//		for (int i = 0; i < count; i++) {
//
//			data += accs[i];
//
//			data += "/";
//
//			data += pws[i];
//
//			data += "/";
//
//			data += moneys[i];
//
//			data += "\n";
//
//		}
//
//		data = data.substring(0, data.length() - 1);
//
//		FileWriter fw = null;
//
//		try {
//
//			fw = new FileWriter(fileName);
//
//			fw.write(data);
//			fw.close();
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//		}
//
//	}
//
//	else if (sel == 10) {
//
//		FileReader fr = null;
//
//		BufferedReader br = null;
//
//		try {
//
//			fr = new FileReader(fileName);
//
//			br = new BufferedReader(fr);
//
//			String data = "";
//
//			while (true) {
//
//				String line = br.readLine();
//
//				if (line == null) {
//
//					break;
//
//				}
//
//				data += line;
//
//				data += "\n";
//
//			}
//
//			data = data.substring(0, data.length() - 1);
//
//			String[] temp = data.split("\n");
//
//			count = temp.length;
//
//			for (int i = 0; i < count; i++) {
//
//				String[] info = temp[i].split("/");
//
//				accs[i] = info[0];
//
//				pws[i] = info[1];
//
//				moneys[i] = Integer.parseInt(info[2]);
//
//			}
//			fr.close();
//			br.close();
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//		}
//
//	}
//
//	else if (sel == 0) {
//
//		System.out.println("[메세지]프로그램 종료");
//
//		break;
//
//	}
//
//}
//}
//}