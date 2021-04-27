package file_practice;

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class String_Drill {
	public static void main(String[] args) {

//// 		4번 1차 풀이	/////////////////////////////
		String data = "10001/김철수/600\n";
		data += "10002/이영희/800\n";
		data += "10001/김철수/1400\n";
		data += "10003/유재석/780\n";
		data += "10002/이영희/950\n";
		data += "10004/박명수/330\n";
		data += "10001/김철수/670\n";
		data += "10003/유재석/3300\n";
		data += "10002/이영희/200\n";
		data += "10004/박명수/6800\n";
		data = data.substring(0, data.length() - 1); // 마지막 글삭제
		System.out.println(data);
		System.out.println("=====================");
		String[] tokens = data.split("\n");
		int totalSize = tokens.length;

		int numList[] = new int[totalSize];
		String nameList[] = new String[totalSize];
		int priceList[] = new int[totalSize];

		for (int i = 0; i < totalSize; i++) {
			String values[] = tokens[i].split("/");
			numList[i] = Integer.parseInt(values[0]);
			nameList[i] = values[1];
			priceList[i] = Integer.parseInt(values[2]);
		}

		for (int i = 0; i < totalSize; i++) {
			System.out.println(numList[i] + " " + nameList[i] + " " + priceList[i]);
		}
		System.out.println("=====================");

//		번호->중복안되게 배열 생성
		int[] numArr = new int[1]; // q. null로 해놓으면 걸리는데 방법?->조건문 사용해서 null이 아닐때만 돌아가라
		int count = 0;
		int arrIdx = 0;
		while (count < numList.length) {
//			numArr = new int[numList.length];
			int check = 1;
			for (int i = 0; i < numArr.length; i++) {
				if (numList[count] == numArr[i]) {
					check = -1;
					break;
				}
			}

			if (check == 1) {
				if (arrIdx == 0) {
					numArr = new int[arrIdx + 1];
					numArr[arrIdx] = numList[count];
					arrIdx++;
				} else {
					int[] temp = numArr;
					numArr = new int[arrIdx + 1];
					numArr[arrIdx] = numList[count];
					for (int i = 0; i < temp.length; i++)
						numArr[i] = temp[i];
					arrIdx++;
				}
			}
			count++;
		}

//		번호에 맞춰서 price 합치기
		int[] sum = new int[numArr.length];
		for (int i = 0; i < numArr.length; i++)
			for (int j = 0; j < priceList.length; j++) {
				if (numList[j] == numArr[i])
					sum[i] += priceList[j];
			}

		String[] name = new String[numArr.length];
		int nameIdx = 0;
		for (int i = 0; i < numArr.length; i++)
			for (int j = 0; j < nameList.length; j++) {
				if (numList[j] == numArr[i]) {
					name[nameIdx] = nameList[j];
					nameIdx++;
					break;
				}
			}
		for (int i = 0; i < numArr.length; i++)
			System.out.println(numArr[i] + " : " + name[i] + "[" + sum[i] + "]");

	}
}
//		번호-이름-price 출력

// 문제1) 위 데이터 는 각각의 회원이 물건을 구입했을때마다 기록한 내용이다.
// 데이터를 아래와 같이 출력 하시요 (각 회원별 구입 총합 )
/*
  =====================
	10001 김철수 2670
	10002 이영희 1950
	10003 유재석 4080
	10004 박명수 7130
   =====================		  
 */

////	문제4 메가 정답////////////////////////////////////////////////
//String data = "10001/김철수/600\n";
//data += "10002/이영희/800\n";
//data += "10001/김철수/1400\n";
//data += "10003/유재석/780\n";
//data += "10002/이영희/950\n";
//data += "10004/박명수/330\n";
//data += "10001/김철수/670\n";
//data += "10003/유재석/3300\n";
//data += "10002/이영희/200\n";
//data += "10004/박명수/6800\n";
//data = data.substring(0 , data.length()-1); // 마지막 글삭제 
//System.out.println(data);
//System.out.println("=====================");
//String [] tokens = data.split("\n");
//int totalSize = tokens.length;
//
//int numList [] = new int[totalSize];
//String nameList [] = new String[totalSize];
//int priceList[] = new int[totalSize];
//
//for(int i = 0; i < totalSize; i++) {
//	String values[] = tokens[i].split("/");
//	numList[i] = Integer.parseInt(values[0]);
//	nameList[i] = values[1];
//	priceList[i] = Integer.parseInt(values[2]);
//}
//
//for(int i = 0; i < totalSize; i++) {
//	System.out.println(numList[i] + " " + nameList[i] + " " + priceList[i]);
//}
//System.out.println("=====================");
//
//int showNum[] = new int[totalSize];
//String showName[] = new String[totalSize];
//
//int showCount = 0;
//for(int h = 0; h < totalSize; h++) {
//	int check = 0;
//	for(int w = 0; w < h; w++) {
//		if(showNum[w] == numList[h]) {
//			check = 1;
//		}
//	}
//	if(check == 0) {
//		showNum[showCount] = numList[h];
//		showName[showCount] = nameList[h];				
//		showCount += 1;
//	}
//}
//for(int i = 0; i < showCount; i++) {
//	System.out.println(showNum[i] + " " + showName[i]);
//}
//System.out.println("=====================");
//int showTotalprice[] = new int[totalSize];
//
//for(int h = 0; h < totalSize; h++) {
//	for(int w = 0; w < showCount; w++) {
//		if(showNum[w] == numList[h]) {
//			showTotalprice[w] += priceList[h];
//		}
//	}		
//}
//for(int i = 0; i < showCount; i++) {
//	System.out.println(showNum[i] + " " + showName[i] + " " +  showTotalprice[i]);
//}
//System.out.println("=====================");
//
//
//
//	
//
//
//
//}
//}
///////////////////////////////////////////////////////////////////////////
//		// 문제 3
//		String nameData = "";
//		nameData += "100001/이만수";
//		nameData += "\n";
//		nameData += "100002/이영희";
//		nameData += "\n";
//		nameData += "100003/유재석";
//		nameData += "\n";
//		nameData += "100004/박명수";
//		nameData += "\n";
//		nameData += "100005/최여정";
//		nameData += "\n";
//		nameData += "100006/박병욱";
//
//		String moneyData = "";
//		moneyData += "100001/600";
//		moneyData += "\n";
//		moneyData += "100003/7000";
//		moneyData += "\n";
//		moneyData += "100001/100";
//		moneyData += "\n";
//		moneyData += "100002/400";
//		moneyData += "\n";
//		moneyData += "100001/600";
//		moneyData += "\n";
//		moneyData += "100004/900";
//		moneyData += "\n";
//		moneyData += "100001/130";
//		moneyData += "\n";
//		moneyData += "100003/200";
//		moneyData += "\n";
//		moneyData += "100002/700";
//		moneyData += "\n";
//		moneyData += "100002/900";
//		moneyData += "\n";
//		moneyData += "100004/800";
//
////		1.
////		moneydata길이
////		길이까지 돌면서 charAt(idx)=="\n"이면
////		charAt(idx)="/"
//
////		2.
////		\n으로 split arr[]
////		substring으로 i%2==0이면 /입력
////		i+1부터 합치기
//
////		3.
////		\n으로 split
////		name.substring(0,6)==money.substring(0,6)
////		userData+=money.substring+/+name.substring(7)+/+money.substring(7)
////		usrdata+="\n"
//
//		String[] name = nameData.split("\n");
//		String[] money = moneyData.split("\n");
//		String userData = "";
//
//		int cnt = 0;
//		while (cnt < money.length) {
//			for (int i = 0; i < name.length; i++) {
////				System.out.println(1);
//				if (money[cnt].substring(0, 6).equals(name[i].substring(0, 6))) {
//					userData += money[cnt].substring(0, 6);
//					userData += "/";
//					userData += name[i].substring(7);
//					userData += "/";
//					userData += money[i].substring(7);
//					if (i < name.length - 1)
//						userData += "\n";
//					cnt++;
//					break;
//				}
//			}
//		}
//
//		System.out.println(userData);
//
//		// 문제3) moneyData 와 nameData 를 조합해서 아래와같이 만들어보세요
//
//		/*
//		 * 100001/이만수/600
//		 * 100003/유재석/7000
//		 * 100001/이만수/100
//		 * 100002/이영희/400
//		 * 100001/이만수/600
//		 * 100004/박명수/900
//		 * 100001/이만수/130
//		 * 100003/유재석/200
//		 * 100002/이영희/700
//		 * 100002/이영희/900
//		 * 100004/박명수/800
//		 */
//
//	}
//}/////////////////////////////////////////////////////////////////////