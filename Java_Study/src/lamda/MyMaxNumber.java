package lamda;

@FunctionalInterface // 람다식을 위한 annotation, 메서드를 두 개 이상 선언할 수 없다.
public interface MyMaxNumber {
	int getMaxNumber(int x, int y);
//	void add(int x, int y); //FunctionalInterface때문에 에러남
	
}
