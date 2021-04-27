package class_practice;

class Ex02 {
	String name;
	int score;
}

public class Class_Ex2 {
	public static void main(String[] args) {
		Ex02 hgd = new Ex02();
		hgd.name = "홍길동";
		hgd.score = 100;
		System.out.println(hgd.score); 

		Ex01 e = new Ex01();
		e.x = 10;
		e.y = 20;
		
		hgd.score += e.x;
	}
}
