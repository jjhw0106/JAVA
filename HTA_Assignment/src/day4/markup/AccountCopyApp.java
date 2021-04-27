package day4.markup;

public class AccountCopyApp {
	public static void main(String[] args) {
		Account[] arr = new Account[3];
		arr[0] = new Account("홍길동", 1000000, 1111);
		arr[1] = new SecretAccount("홍길동", 1000000, 1111, 1234);
		arr[2] = new Account("강감찬", 3000000, 1111);

		for (Account item : arr) {
			if (!(item instanceof UnCopiable)) {
				System.out.println(item.getName());
			} else {
				System.out.println("비밀계좌입니다");
			}
		}

	}

}
