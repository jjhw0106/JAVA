package step01_3;

public class VarEx02 {
	public static void main(String[] args) {
		
		//����1
		System.out.println("����1) ������ 100���̴�. ������? (���� : ���� 10% ����)");
 		int mSalary = 100;
 		int tax = mSalary/10;
 		int ySalary = (mSalary - tax)*12;
		System.out.println(ySalary);
 		
		System.out.println("\n\n");

		//����2
		System.out.println("����2) ���������� 30, 50, 4�� �� �޾Ҵ�. �����?");
		int score1 = 30;
		int score2= 50;
		int score3 = 4;
		int average = score1+score2+score3 / 3;
		System.out.println("���: " + average);
		
		System.out.println("\n\n");
		
		//����3
		System.out.println("����3) ���ΰ� 3�̰� ���ΰ� 6�� �ﰢ�� ���� ���");
		int width = 3;
		int height = 6;
		int area = width * height /2;
		System.out.println("���� : "+ area);

		System.out.println("\n\n");
		
		//���� 4
		System.out.println("����4) 100�ʸ� 1�� 40�ʷ� ���");
		
		int minute = 100 / 60;
		int second = 100 % 60;
		System.out.println("100�ʴ� " + minute + "��" + second + "��" ); 
		
		System.out.println("\n\n");
		
		//���� 5
		System.out.println("����5) 800������ 500��¥�� ���� , 100��¥�� ���� ���");
		int coin = 800;
		int coin500 = coin/500;
		int coin100 = coin%500/100;
		
		System.out.println("800���� 500��¥�� : " + coin500 + "��, " + "100��¥�� : " +coin100 +"��");
		
	
	}

}
