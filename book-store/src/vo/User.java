package vo;

public class User {

	private String id;
	private String name;
	private String password;
	private int point;
	private String grade;
	
	public User() {}

	public User(String id, String name, String password, int point, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.point = point;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
