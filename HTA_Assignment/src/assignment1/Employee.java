package assignment1;

public class Employee {
	private int empNo;
	private String empName;
	private String dept;
	private String position;
	private int salary;
	private boolean commision;

	public Employee(int empNo, String empName, String dept, String position, int salary, boolean commision) {
		this.empNo = empNo;
		this.empName = empName;
		this.dept = dept;
		this.position = position;
		this.salary = salary;
		this.commision = commision;
	}

	public void printEmployeeInfo() {
		System.out.println(
				this.getEmpNo() + "," + 
		this.getEmpName() + "," + 
						this.getDept() + "," + 
		this.getPosition()
				+ "," + 
		this.getSalary() + "," + 
				((this.getCommision() == true) ? "지급" : "미지급"));
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean getCommision() {
		return commision;
	}

	public void setCommision(boolean commision) {
		this.commision = commision;
	}

}
