package vo;

import java.util.Date;

public class User {

	private String id;
	private String password;
	private String username;
	private boolean isDisabled;
	private Date createdDate;
	private Date deletedDate;

	public User() {
	}

	public User(String id, String password, String username, boolean isdisabled, Date createdDate, Date deletedDate) {
		this.id = id;
		this.password = password;
		this.username = username;
		this.isDisabled = isdisabled;
		this.createdDate=createdDate;
		this.deletedDate = deletedDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isDisabled() {
		return isDisabled;
	}

	public void setDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", username=" + username + ", isDisabled=" + isDisabled
				+ ", createdDate=" + createdDate + "]";
	}

}
