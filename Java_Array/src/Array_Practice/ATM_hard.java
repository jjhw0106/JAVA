package Array_Practice;

import java.util.Scanner;
import java.util.Random;

public class ATM_hard {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final int MAX = 6;

		boolean run = true;

		int id = 0;
		int pw = 0;
		int log = -1;
		int sel = 0;
		int count = 0;

		String menu = "======Physique Loper's ATM======\n";
		menu += "1.회원가입 \n2.회원탈퇴\n3.로그인\n4.로그아웃\n5.입금\n6.이체\n7.잔액조회\n8.종료";

		int[] idAry = new int[MAX];
		int[] pwAry = new int[MAX];
		int[] moneyAry = new int[MAX];
		for (int i = 0; i < MAX; i++) // 초기화 항상?
			moneyAry[i] = 0;
		int[] account = new int[MAX];

		while (run == true)
			{
				System.out.println("카운트는" +count);
				System.out.println(menu);
				System.out.println("회원테이블");

				for (int i = 0; i < MAX; i++)
					System.out.print(idAry[i] + " ");
				System.out.println();

				for (int i = 0; i < MAX; i++)
					System.out.print(pwAry[i] + " ");
				System.out.println();

				System.out.print("메뉴를 선택하세요: ");
				sel = scan.nextInt();

				// 회원 가입
				if (sel == 1 && count < MAX-1)
					{

						int check = 1;
						if (log == 1)
							{
								System.out.println("로그인된 id: " + idAry[count]);
								System.out.println("로그인이 되어있을 때는 회원가입이 불가합니다.");

							} else
							{
								System.out.println("가입할 ID를 입력해주세요: ");
								id = scan.nextInt();

								for (int i = 0; i < MAX; i++)
									{
										if (idAry[i] == id)
											{
												check = -1;

											}
									}
								if (check == -1)
									System.out.println("중복된 아이디입니다.");

								else if (check == 1)
									{
										System.out.println("패스워드를 입력하세요: ");
										pw = scan.nextInt();
										for (count = 0; count < MAX; count++)
											if (idAry[count] == 0)
												{
													idAry[count] = id;
													pwAry[count] = pw;
													moneyAry[count] += 1000;
												//	System.out.println(count);
													break;
												}

									}

							}
					} else if (count >= MAX-1)
					System.out.println("회원 수는 6명까지입니다.\n\n");

				// 회원탈퇴 (로그인시에만 회원탈퇴 가능, 탈퇴 시 로그아웃 -> 한 번에 하나만 탈퇴가능)
				if (sel == 2 && log == 1)
					{
						System.out.print("탈퇴할 회원의 아이디를 입력하세요: ");
						id = scan.nextInt();
						int check = -1;

						for (int i = 0; i < MAX; i++)
							if (idAry[i] == id)
								{
									check = 1;
									count = i;
								}

						while (check == 1)
							{
								System.out.print("비밀번호를 입력하세요: ");
								pw = scan.nextInt();
								if (pw == pwAry[count])
									{
										idAry[count] = 0;
										pwAry[count] = 0;
										log = -1;
										break;
									}

								else
									{
										System.out.println("비밀번호가 틀렸습니다.");
										break;
									}
							}

					} else if (sel == 2 && log == -1)
					System.out.println("회원탈퇴를 하기 위해선 로그인이 되어있어야합니다.");

				// 로그인
				if (sel == 3 && log == -1)
					{
						System.out.print("ID:");

						int idCheck = -1;
						id = scan.nextInt();
						for (int i = 0; i < MAX; i++)
							if (id == idAry[i])
								{
									idCheck = 1;
									count = i;
									break;
								}

						if (idCheck == 1)
							{
								int pwError = 0;
								while (pwError < 5)
									{
										System.out.print("PW:");
										pw = scan.nextInt();
										if (pw == pwAry[count])
											{
												System.out.println("로그인되었습니다.");
												System.out.printf("회원정보 id %d, 통장잔고 %d\n", idAry[count],
														moneyAry[count]);
												log = 1;
												break;
											} else if (pw != pwAry[count])
											{ // 비밀번호 오류 시, 5회 다시 입력 받고 -> 5회를 초과하면 처음 화면으로 돌아감
												pwError++;
												System.out.println("비밀번호가 틀렸습니다." + pwError + "회 오류");
											}
									}
							}

						else if (idCheck == -1)
							{
								System.out.println("없는 아이디입니다.");
								log = -1;
								// break;
							}
					} else if (sel == 3 && log == 1)
					System.out.println("이미 로그인 되어있습니다.");

				// 로그아웃
				if (sel == 4 && log == 1)
					{
						System.out.println("로그아웃 하시겠습니까?");
						System.out.println("Y(1) / N(2): ");
						int yesno;
						yesno = scan.nextInt();
						if (yesno == 1)
							log = -1;
						else if (yesno == 2)
							log = 1;
					} else if (sel == 4 && log == -1)
					System.out.println("로그아웃 상태입니다.");

				// 입금
				if (sel == 5 && log == 1)
					{
						int deposit = 0;
						System.out.println("입금: ");
						deposit = scan.nextInt();
						moneyAry[count] += deposit;

					}

				// 이체
				if (sel == 6 && log == 1)
					{
						int check = -1;
						int transfer = 0;
						System.out.println("이체할 ID: ");
						id = scan.nextInt();
						for (int i = 0; i < MAX; i++)
							if (id == idAry[i])
								check = 1;

						if (check == 1)
							{
								System.out.println("이체할 금액: ");
								transfer = scan.nextInt();
							} else
							System.out.println("존재하지 않는 ID입니다.");
					}

				// 조회
				if (sel == 7 && log == 1)
					{
						System.out.printf("[회원 %d]의 잔액은 %d입니다", idAry[count], moneyAry[count]);
						System.out.println();
					} else if (sel == 7 && log == -1)
					System.out.println("로그인을 하세요");

				// 종료
				if (sel == 8)
					{
						System.out.println("이용해주셔서 감사합니다.");
						break;
					}
			}
	}
}