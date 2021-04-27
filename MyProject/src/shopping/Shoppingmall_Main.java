package shopping;

public class Shoppingmall_Main {
	public static void main(String[] args) {
		System.out.println("1. Customer");
		System.out.println("2. Admin");
		System.out.println("3. 종료");
		int sel = Function.getInt();
		if (sel == 1) {
			ShoppingMall_User su = new ShoppingMall_User();
			su.run();
		} else if (sel == 2) {
			Shoppingmall_Admin sa = new Shoppingmall_Admin();
			sa.run();
		} else if (sel == 3) {
			System.out.println("프로그램 종료");
		}
	}
}
