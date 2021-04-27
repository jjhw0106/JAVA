package step1_10;

public class Game_369 {
	public static void main(String[] args) {
		int num = 0;

		while (num <= 50)
		{

			int clap = 0;
			num++;

			// 3,6,9 판단 (10의자리가 3일때)
			if (num / 10 == 3)
			{
				clap = 1;
				if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9)
					clap = 2;
			}

			// 3,6,9 판단(10의자리가 3이 아닐때)
			if (num / 10 != 3)
			{
				if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9)
					clap = 1;
			}
			
			// 박수 출력
			if (clap == 0)
				System.out.println(num);
			else if (clap == 1)
				System.out.println("짝");
			else if (clap == 2)
				System.out.println("짝짝");

		}
	}
}
