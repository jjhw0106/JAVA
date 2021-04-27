package file_practice;
//에러의 종류 (참고사이트) 

// https://butter-shower.tistory.com/87

// 에러의 종류가 너무 많기 때문에 
// 모든에러를 다잡아주는  Exception 을 보통 사용한다.
public class Exception_Conception {
	public static void main(String[] args) {
//		int arr[] = new int[3];
//		try {
//			arr[100] = 100;
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//
//		int a = 10;
//		try {
//			int b = a / 0;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		String str = "aaa";
//		try {
//			int num = Integer.parseInt(str);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		int num1 = 10;
		int num2 = 2;
		
		try {
			System.out.println(num1 / num2);
		}catch(Exception e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}finally {
			System.out.println("예외발생과 상관없이 무조건 실행할 문장을 적는다.");
			
		}
		
	}
}