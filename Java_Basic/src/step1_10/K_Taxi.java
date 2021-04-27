package step1_10;

import java.util.Random;
import java.util.Scanner;

public class K_Taxi {

	public static void main(String[] args) {
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);

		// 목적지
		int dest_x = ran.nextInt(20) - 10;
		int dest_y = ran.nextInt(20) - 10;

		int pos_x = 0;
		int pos_y = 0;

		int velocity = 0;
		int way = 0;
		int fare =0;
		int distance=0;

		System.out.printf("목적지는 (%d, %d)\n", dest_x, dest_y);

		while (pos_x != dest_x || pos_y != dest_y)
		{
			// 속력//////////////////////////////////////////////////////////
			System.out.println("속력를 입력하세요(1~3): ");
			boolean exit = false;
			while (exit == false)
			{
				velocity = scan.nextInt();
				if (velocity >= 1 && velocity <= 3)
				{
					System.out.println("속력은 " + velocity);
					exit = true;
				}

				else
				{
					System.out.println("최대속력은 3입니다. 다시입력하세요: ");
					exit = false;
				}

			}
			///////////////////////////////////////////////////////////////


			// 방향/////////////////////////////////////////////////////////
			System.out.println("방향을 입력하세요 : 1. 동, 2. 서, 3. 남, 4. 북 ");
			exit = false;
			while (exit == false)
			{
				way = scan.nextInt();

				if (way == 1)
					{
					pos_x += velocity;
					exit = true;
					}
				else if (way == 2)
					{
					pos_x -= velocity;
					exit = true;
					}
				else if (way == 3)
					{
					pos_y -= velocity;
					exit = true;
					}
				else
					{
					pos_y += velocity;
					exit = true;
					}

				System.out.print("현재 위치는 ");
				System.out.println(pos_x+"," + pos_y);
				
			}
			////////////////////////////////////////////////////////////////
			//요금
			if(velocity<0)
				distance += (velocity*-1);
			else 
				distance += velocity;
			fare = (distance/2)*50;
			
		}
		System.out.printf("거리는 %d, 요금은 %d ",distance, fare);

	}
}
