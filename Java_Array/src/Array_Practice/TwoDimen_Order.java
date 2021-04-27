package Array_Practice;

import java.util.Scanner;

public class TwoDimen_Order {

	public static void main(String[] args) {

		int jangCount = 5;
		String[][] jang = {

				{ "김철수", "김치" },

				{ "안영희", "짜장면" },

				{ "박철수", "호떡" },

				{ "안철수", "김치" },

				{ "김영희", "돈까스" } };

		for (int i = 0; i < jang.length; i++)
		{
			System.out.println(jang[i][0] + " : " + jang[i][1]);
		}

		int count = 0;

		String order = jang[0][0];

		while (count < jang.length)
		{	
			for (int i = count; i < jang.length; i++)  
			{	//1차(이름) 정렬
				if (jang[count][0].compareTo(jang[i][0]) > 0)
				{
					String[] ntemp = jang[count]; // q. 2차원 배열->1차원배열로 저장 ntemp 크기 2?
					jang[count] = jang[i];
					jang[i] = ntemp;

					
				}
				//2차(상품) 정렬
				if (jang[count][0].compareTo(jang[i][0]) == 0 && jang[count][1].compareTo(jang[i][1]) > 0)
				{
					String[] ptemp = jang[count];
					jang[count] = jang[i];
					jang[i] = ptemp;
				}
			}
			count++;
		}

		System.out.println("1");
		for (int i = 0; i < jang.length; i++)
			System.out.println(jang[i][0] + ":" + jang[i][1]);
	}
}

//		count = 0;
//		while(count < jang.length) {
//			for(int i=count; i<jang.length; i++)
//			{
//			
//			}
//		}

//		2. 템별 정렬
//		while (count < jang.length)
//		{
//			//System.out.println(1);
//			for (int i = count; i < jang.length; i++)
//			{
//				//System.out.println(2);
//				if (jang[count][1].compareTo(jang[i][1]) > 0)
//				{
//					String temp = jang[count][1];
//					jang[count][1] = jang[i][1];
//					jang[i][1] = temp;
//				}
//				
//			}
//			count++;