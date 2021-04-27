package collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapApp2 {
	public static void main(String[] args) {
		HashMap<String, User> users = new HashMap<>();

		users.put("kang", new User("kang1", "zxcv1234", "강감1"));
		users.put("kang", new User("kang2", "zxcv1234", "강감2"));
		users.put("kang", new User("kang3", "zxcv1234", "강감3"));
		users.put("kang", new User("kang4", "zxcv1234", "강감4"));
		
	}

	private static class User {
		String id;
		String pw;
		String name;

		public User(String id, String pw, String name) {
			super();
			this.id = id;
			this.pw = pw;
			this.name = name;
		}

	}
}
