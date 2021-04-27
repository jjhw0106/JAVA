//package Array_Practice;

//import java.util.Scanner;
//import java.util.Random;

/*
 * # ATM[4단계] : 전체 기능구현
 * 1. 회원가입
 * . id와 pw를 입력받아 가입
 * . 가입 시 돈 1000원 부여
 * . id 중복체크
 * 2. 회원탈퇴
 * . 로그인시에만 이용가능
 * 3. 로그인
 * . id와 pw를 입력받아 로그인
 * . 로그아웃 상태에서만 이용가능
 * 4. 로그아웃
 * . 로그인시에만 이용가능 
 * 5. 입금
 * . 로그인시에만 이용가능
 * 6. 이체
 * . 로그인시에만 이용가능
 * 7. 잔액조회
 * . 로그인시에만 이용가능
 
public class ATM_LV2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		final int MAX = 10;
		int id = 0;
		int pw = 0;
		int[] idAry = new int[10];
		int[] pwAry = new int[10];
		int[] moneyAry = new int[10];
		for (int i = 0; i < MAX; i++)
			moneyAry[i] = 0;
		int menu = 0;
		int log =-1;
		int i = 0;
		int j = 0;

		// 1. 회원가입

		boolean run = true;
		while (run == true)
		{
			System.out.println("======PhysiqueLoper's ATM======");
			System.out.println("1. 회원가입");
			System.out.println("2. 회원탈퇴");
			System.out.println("3. 로그인");
			System.out.println("4. 로그아웃");
			System.out.println("5. 종료");
			System.out.println(
					idAry[0] + " " + idAry[1] + " " + idAry[2] + " " + idAry[3] + " " + idAry[4] + " " + idAry[5]);
			System.out.println(
					pwAry[0] + " " + pwAry[1] + " " + pwAry[2] + " " + pwAry[3] + " " + pwAry[4] + " " + pwAry[5]);
			System.out.println("무엇을 하시겠습니까? ");
			menu = scan.nextInt();

			// 회원가입 ID (중복 금지)
			if (menu == 1)
			{
				boolean runID = true;
				while (runID == true)
				{
					int check = 1;
					System.out.print("가입할 id를 입력하세요: ");
					id = scan.nextInt();

					j = 0;
					while (j < i)
					{
						if (idAry[j] == id)
						{
							System.out.println("이미 존재하는 ID입니다. ");
							check = -1;
						}
						j++;
					}
					if (check == 1)
					{
						if (id / 100000 == 0)
						{
							idAry[i] = id;
							runID = false;

						} else

							System.out.println("id는 최대 다섯자리까지 됩니다.");

					}
				}

				// 회원가입 PW (중복가능)
				boolean runPW = true;
				while (runPW == true)
				{
					System.out.print("PW를 입력하세요: ");
					pw = scan.nextInt();

					if (pw / 10000000 == 0)
					{
						pwAry[i] = pw;
						runPW = false;
					} else
						System.out.println("PW는 최대 7자리 입니다.");
				}
				System.out.println("회원가입을 축하드립니다.");
				System.out.println("아이디: \t " + id + "\n" + "비밀번호: \t " + pw);
				moneyAry[i] += 1000;
				System.out.println("회원가입 보너스 + 1,000원!!");
				System.out.println();
				System.out.println();
				i++;
			}

			// 2. 회원탈퇴
			if (menu == 2)
			{
				int check = -1;
				boolean runDelete = true;
				while (runDelete == true)
				{
					System.out.println("삭제할 ID를 입력하세요: ");
					id = scan.nextInt();

					for (i = 0; i < MAX; i++)
						if (idAry[i] == id)
						{
							check = 1;
							break;
						}

					int yesno = 0;
					if (check == 1)
					{
						System.out.print("정말로 삭제하시겠습니까? (1.네  2.아니요)");
						yesno = scan.nextInt();

						if (yesno == 1)
						{
							System.out.print("비밀번호를 입력하세요 : ");
							pw = scan.nextInt();
							for (i = 0; i < MAX; i++)
								if (pwAry[i] == pw)
								{
									check = 2;

									break;
								}
							if (check != 2)
							{
								System.out.println("비밀번호가 틀렸습니다.");
								runDelete = false;
								break;
							}

							if (check == 2)
							{

								idAry[i] = 0;
								pwAry[i] = 0;
								runDelete = false;

							}

						}

					} else
					{
						System.out.println("id가 일치하지 않습니다.");
						runDelete = false;
					}

				}
			}
			// 3. 로그인
			if (menu == 3)
			{
				int log = -1;
				boolean runLog = true;
				while (runLog == true)
				{
					System.out.println("ID와 PW를 입력하세요 ");
					System.out.print("ID: ");
					id = scan.nextInt();
					for(i=0;i<MAX;i++)
					{
						if(id == idAry[i])
						{
							 log = 1;
							 break;
						}
					}
					while (log == 1)
					{
						System.out.print("PW: ");
						pw = scan.nextInt();
						if(pw == pwAry[i])
						{
							
						}
					}
					if(log == -1)
						{
						System.out.println("ID가 틀렸습니다.");
						break;
						}
					
					
				}
			}

// 5. 종료
			if (menu == 5)
				run = false;
		}

// 배열에 제대로 저장됐는지 체크-> 나중에 조회로 업데이트

	}
}*/
