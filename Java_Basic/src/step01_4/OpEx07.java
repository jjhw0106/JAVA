package step01_4;

public class OpEx07 {

	public static void main(String[] args) {
	
		
		
		
		//���� 1)
		
		int kor = 100;
		int eng = 87;
		int math = 41;
		int avg = (kor + eng + math)/3;

		System.out.println(	"���� 1) ���� 3������ ����� 60�� �̻��̸�, true" +
							"��, ��� �� �����̶� 50�� �̸��̸�, false");
		
		System.out.println(avg>=60 && kor>=50 && eng>=50 && math >=50);
		
		
		
		
		//���� 2)
		
		int height = 150;
		int weight = 190;
		
		System.out.println(	"\n���� 2) Ű�� 200cm�̻��̰ų� �����԰� 200kg �̻��̸�, ����(true)");
		System.out.println(height >=200 || weight >=200);
		
	}
}
