package step01_4;

public class OpEx07 {

	public static void main(String[] args) {
	
		
		
		
		//문제 1)
		
		int kor = 100;
		int eng = 87;
		int math = 41;
		int avg = (kor + eng + math)/3;

		System.out.println(	"문제 1) 과락 3과목의 평균이 60점 이상이면, true" +
							"단, 어느 한 과목이라도 50점 미만이면, false");
		
		System.out.println(avg>=60 && kor>=50 && eng>=50 && math >=50);
		
		
		
		
		//문제 2)
		
		int height = 150;
		int weight = 190;
		
		System.out.println(	"\n문제 2) 키가 200cm이상이거나 몸무게가 200kg 이상이면, 입장(true)");
		System.out.println(height >=200 || weight >=200);
		
	}
}
