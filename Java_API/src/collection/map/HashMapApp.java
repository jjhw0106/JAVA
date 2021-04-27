package collection.map;

import java.util.HashMap;
import java.util.Map;

import collection.list.Product;
import collection.list.ProductRepository;

public class HashMapApp {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();

		System.out.println("map에 key, value 저장하기");
		// key는 아이디 value는 사용자 명으로 저장함
		map.put("hong", "홍길동");		//**
		map.put("kimys", "김유신");
		map.put("lee", "이순신");
		map.put("kang", "강감찬");
		map.put("rks", "유관순");

		System.out.println(map.get("hong")); //**
		System.out.println(map.keySet());
		System.out.println(map.entrySet());

	}
}
