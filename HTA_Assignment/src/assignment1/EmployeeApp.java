package assignment1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EmployeeApp {
//	public Employee(int empNo, String empName, String dept, String position, int salary, int commision)

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Employee[] emp = new Employee[5];
//		emp[0] = new Employee(1, "김씨", "기획", "부장", 6500000, false);
//		emp[1] = new Employee(2, "이씨", "영업", "과장", 3500000, true);
//		emp[2] = new Employee(3, "박씨", "영업", "상무", 7500000, false);
//		emp[3] = new Employee(4, "홍씨", "관리", "차장", 5500000, true);
//		emp[4] = new Employee(5, "기씨", "홍보", "사원", 3500000, true);

		for (Employee e : emp) {
			e.printEmployeeInfo();
		}
	}

}
