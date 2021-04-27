package file_practice;



public class Check_ID {
	public static void main(String[] args) {
		String jumin = "890101-2012932";
		// 문제 1) 나이 출력
//		substring(1,2)로 년도 빼내기
		String idAge = jumin.substring(0, 2);

//		형변환으로 인트형으로 바꾸기
		int num = Integer.parseInt(idAge);// Q. 인티저가 어디서 나온건지 (include? library?) / (string)으로는?

//		1900에 더하기
		num += 1900;

//		age=2020-19xx
		int age = 2020 - num;

		// 정답 1) 30세
		System.out.println(age);

		
		
		// 문제 2) 성별 출력
//		split -로 나눠서 arr[i]에 넣기
		String[] arr = jumin.split("-");
		System.out.println(arr[1]);

//		num=arr[1]의 substring(1,2)
		String sNum = arr[1].substring(0, 1);

// 		num==1>남자, 2>여자
		if (sNum.equals("1"))
			System.out.println("남자");

		else if (sNum.equals("2"))
			System.out.println("여자");

		
		
//		int sNum = Integer.parseInt(arr[1].substring(0, 1));
//		if (sNum == 1)
//			System.out.println("남자");
//		else if (sNum == 2)
//			System.out.println("여자");

		// 정답 2) 여성
	}
}
