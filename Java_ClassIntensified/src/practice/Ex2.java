package practice;

class Client {
	String name;
	int score;

	void set_data(String n, int s) {
		this.name = n;
		this.score = s;
	}

	void print_data() {
		System.out.println(this.name + "," + this.score);
	}
}

public class Ex2 {
	public static void main(String[] args) {
		Client[] st = new Client[3];
		for (int i = 0; i < st.length; i++) {
			st[i] = new Client();
		}

		st[0].set_data("김철수", 100);
		st[1].set_data("정상봉", 20);
		st[2].set_data("김현우", 80);

		for (int i = 0; i < st.length; i++)
			st[i].print_data();

	}
}
