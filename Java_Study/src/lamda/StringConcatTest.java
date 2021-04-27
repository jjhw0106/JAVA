package lamda;

public class StringConcatTest implements StringConcat {
	public static void main(String[] args) {

		// 람다식
//		StringConcat SC = (x, y) -> x.concat(y);
//		System.out.println(SC.concat("가나다", "라마바"));
		///////
		
		StringConcatTest SCT = new StringConcatTest();
		System.out.println(SCT.concat("가나다","라마바"));
		
		
	}

	// 기존 방식
	@Override
	public String concat(String s1, String s2) {
		return s1.concat(s2);
	}
	
	
	
	
	///////
}
