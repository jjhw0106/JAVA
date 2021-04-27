package sample6;

public class Course {
	private int courseNo;
	private String courseName;
	private int quota;
	private int registeredCount;

	public Course() {
	}

	public Course(int courseNo, String courseName, int quota) {
		super();
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.quota = quota;
	}

	public int getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public int getRegisteredCount() {
		return registeredCount;
	}

	public void setRegisteredCount(int registeredCount) {
		this.registeredCount = registeredCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseNo != other.courseNo)
			return false;
		return true;
	}

}
