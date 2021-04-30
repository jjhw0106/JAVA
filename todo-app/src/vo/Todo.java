package vo;

import java.util.Date;

import utils.StringUtils;

public class Todo {

	// 일정 상태값
	public static final String TODO_STATUS_ADDED = "등록";
	public static final String TODO_STATUS_DELETED = "삭제";
	public static final String TODO_STATUS_COMPLETED = "완료";

	private int no;
	private String title;
	private User writer;
	private Date day;
	private String status;
	private String text;
	private Date createdDate;
	private Date completedDate;
	private Date deletedDate;

	public Todo() {
		this.no = StringUtils.getSequence();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getWriter() {
		return writer;
	}

	public void setWriter(User writer) {
		this.writer = writer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Todo [no=" + no + ", title=" + title + ", writer=" + writer + ", status=" + status + ", text=" + text
				+ ", createdDate=" + createdDate + ", completedDate=" + completedDate + ", deletedDate=" + deletedDate
				+ "]";
	}

}
