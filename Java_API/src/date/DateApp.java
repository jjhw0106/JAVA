package date;

import java.util.Date;

public class DateApp {

	public static void main(String[] args) {
		// java.util.Date
		// - 날짜와 시간정보를 표현하는 객체다.
		Date now = new Date(); // 현재 날짜, 시간 정보가 있는 데이트 객체 get
		System.out.println(now);

//		now.setTime(1000); // 1970 01.01 09 + 1/1000 초 // 한국은 9시간 빠르기때문에 09시
//		System.out.println(now);

		// 유닉스타임값 조회
		long time = now.getTime();
		System.out.println(time);

		long time2 = System.currentTimeMillis(); // 유닉스타임만 바로 갖다 쓸 수 있음
		System.out.println(time2);

	}
}
