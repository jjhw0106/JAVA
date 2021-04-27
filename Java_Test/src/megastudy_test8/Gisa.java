package megastudy_test8;

import java.util.ArrayList;

class Member {
	private int custno; // 회원번호
	private String custname; // 회원성명

	private String phone; // 회원전화
	private String address; // 통신사
	private String joindate; // 가입일자
	private String grade; // 고객등급
	private String city; // 거주도시

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public Member() {
	}

	public Member(int custno, String custname, String phone, String address, String joindate, String grade,
			String city) {
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}
}

class Money {
	int custno; // 회원번호
	int saleno; // 판매번호
	int pcost; // 단가
	int amount; // 수량
	int price; // 가격(매출)
	String pcode; // 상품코드
	String sdate; // 판매일자

	public Money() {
	}

	public Money(int custno, int saleno, int pcost, int amount, int price, String pcode, String sdate) {
		this.custno = custno;
		this.saleno = saleno;
		this.pcost = pcost;
		this.amount = amount;
		this.price = price;
		this.pcode = pcode;
		this.sdate = sdate;
	}
}

class Manager {
	ArrayList<Member> memberList = new ArrayList<Member>();
	ArrayList<Money> moneyList = new ArrayList<Money>();

	void init() {
		memberList.add(new Member(100001, "김행복", "010-1111-2222", "SK", "20151202", "A", "01"));
		memberList.add(new Member(100002, "이축복", "010-1111-3333", "SK", "20151206", "B", "01"));
		memberList.add(new Member(100003, "장믿음", "010-1111-4444", "SK", "20151001", "B", "30"));
		memberList.add(new Member(100004, "최사랑", "010-1111-5555", "SK", "20151113", "A", "30"));
		memberList.add(new Member(100005, "진평화", "010-1111-6666", "SK", "20151225", "B", "60"));
		memberList.add(new Member(100006, "차공단", "010-1111-7777", "SK", "20151211", "C", "60"));

		moneyList.add(new Money(100001, 20160001, 500, 5, 2500, "A001", "20160101"));
		moneyList.add(new Money(100001, 20160002, 1000, 4, 4000, "A002", "20160101"));
		moneyList.add(new Money(100001, 20160003, 500, 3, 1500, "A008", "20160101"));
		moneyList.add(new Money(100002, 20160004, 2000, 1, 2000, "A004", "20160102"));
		moneyList.add(new Money(100002, 20160005, 500, 1, 500, "A001", "20160103"));
		moneyList.add(new Money(100003, 20160006, 1500, 2, 3000, "A003", "20160103"));
		moneyList.add(new Money(100004, 20160007, 500, 2, 1000, "A001", "20160104"));
		moneyList.add(new Money(100004, 20160008, 300, 1, 300, "A005", "20160104"));
		moneyList.add(new Money(100004, 20160009, 600, 1, 600, "A006", "20160104"));
		moneyList.add(new Money(100004, 20160010, 3000, 1, 3000, "A007", "20160106"));
	}
}

//	key: int custno, 색인: custname 더할 부분: int price
public class Gisa {
	/*
		   [문제] 아 래와 같이 출력  매출(price) 의 합계 + 내림차순 
		  
			100001	김행복		8000
			--------------------------------
			100004	최사랑		4900
			--------------------------------
			100003	장믿음		3000
			--------------------------------
			100002	이축복		2500
			--------------------------------
	 */
	public static void main(String[] args) {
		Manager mg = new Manager();
		mg.init();

//		int custno;
//		String name;
//		int sum;
//
//		ArrayList<Gisa> sumAndOrder = new ArrayList<Gisa>();
//		sumAndOrder.add(Gisa);

		int[] custno = new int[mg.memberList.size()];
		String[] name = new String[mg.memberList.size()];
		int[] sum = new int[mg.memberList.size()];
		for (int i = 0; i < mg.memberList.size(); i++) {
			custno[i] = mg.memberList.get(i).getCustno();
			name[i] = mg.memberList.get(i).getCustname();
		}

//		합산
		int idx = 0;
		for (int j = 0; j < mg.memberList.size(); j++) {
			for (int i = 0; i < mg.moneyList.size(); i++) {
				if (mg.moneyList.get(i).custno == custno[j]) {
					sum[j] += mg.moneyList.get(i).price;
				}
			}
		}
		
//		정렬
		for (int i = 0; i < mg.memberList.size(); i++) {
			for (int j = 0; j < mg.memberList.size(); j++) {
				if (sum[i] > sum[j]) {
					String tempName = name[i];
					name[i] = name[j];
					name[j] = tempName;
					int tempCno = custno[i];
					custno[i] = custno[j];
					custno[j] = tempCno;
					int tempSum = sum[i];
					sum[i] = sum[j];
					sum[j] = tempSum;
				}
			}
		}
		for (int i = 0; i < mg.memberList.size(); i++) {
			if (sum[i] != 0) {
				System.out.println(custno[i] + " " + name[i] + " " + sum[i]);
			}
		}
	}
}
