package map_practice2;

public class NotificationApp {
	public static void main(String[] args) {

		Notification notification = new Notification();

		Customer customer[] = new Customer[5];
		customer[0] = new Customer("김태촌", new String[] { "kakao", "mail", "sms" });
		customer[1] = new Customer("강남길", new String[] { "kakao" });
		customer[2] = new Customer("김석봉", new String[] { "kakao", "sms" });
		customer[3] = new Customer("박남정", new String[] { "sms" });
		customer[4] = new Customer("태연", new String[] { "kakao", "mail", "sms" });
		
		
	}
}
