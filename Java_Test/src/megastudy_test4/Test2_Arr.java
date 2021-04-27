package megastudy_test4;

//start 6:00 end 6:03
// 문제) arr 안에 b의 값이 있으면 0으로 변경
// 예) arr = {0,0,30,40,50};
public class Test2_Arr {

	public static void main(String[] args) {

		int arr[] = { 10, 20, 30, 40, 50 };
		int b[] = { 10, 20, 3, 5 };

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < b.length; j++)
				if (arr[i] == b[j]) {
					arr[i] = 0;
				}
		}
		for(int i =0 ; i < arr.length; i++)
			System.out.println(arr[i]);
	}
}
