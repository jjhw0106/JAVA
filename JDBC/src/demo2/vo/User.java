package demo2.vo;

import java.util.Date;

/**
 * @author jjhw0
 *
 */
public class User {

	private String id;
	private String name;
	private String password;
	private String email;
	private String status;
	private String phone;
	private Date createdDate;

	public User() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	// toString 재정의 하는 이유
	// 디버깅할 때 값이 제대로 들어갔는지 확인할 수가 없다.(해시코드로 나온다)
	// 값을 담는 vo인 경우에 toString 재정의하자
	@Override
	public String toString() {
		return "User [id=" + id
				+ ", name=" + name
				+ ", password=" + password
				+ ", email=" + email
				+ ", status=" + status
				+ ", createdDate=" + createdDate
				+ "]";
	}

}
