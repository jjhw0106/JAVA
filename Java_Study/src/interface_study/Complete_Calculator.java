package interface_study;

public class Complete_Calculator extends Calculator {

	@Override
	public int times(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 * num2;
	} 

	@Override
	public int divide(int num1, int num2) {
		if (num2 == 0)
			return ERROR;
		return num1 / num2;
	}

	public void showInfo() {
		System.out.println("모두 구현하였습니다.");
	}

//	@Override
//	public void description() {
//		System.out.println("재정의한 Description");
//	}

}
