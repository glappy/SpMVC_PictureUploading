package com.biz.bbs.model;

public class BBsVO {

	private long id;
	private String b_userid;
	private String b_date;
	private String b_time;
	private String b_subject;
	private String b_content;
	private long b_hit;
	
	private String b_image;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getB_userid() {
		return b_userid;
	}

	public void setB_userid(String b_userid) {
		this.b_userid = b_userid;
	}

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

	public String getB_time() {
		return b_time;
	}

	public void setB_time(String b_time) {
		this.b_time = b_time;
	}

	public String getB_subject() {
		return b_subject;
	}

	public void setB_subject(String b_subject) {
		this.b_subject = b_subject;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public long getB_hit() {
		return b_hit;
	}

	public void setB_hit(long b_hit) {
		this.b_hit = b_hit;
	}

	public String getB_image() {
		return b_image;
	}

	public void setB_image(String b_image) {
		this.b_image = b_image;
	}

	public BBsVO(long id, String b_userid, String b_date, String b_time, String b_subject, String b_content, long b_hit,
			String b_image) {
		super();
		this.id = id;
		this.b_userid = b_userid;
		this.b_date = b_date;
		this.b_time = b_time;
		this.b_subject = b_subject;
		this.b_content = b_content;
		this.b_hit = b_hit;
		this.b_image = b_image;
	}

	public BBsVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BBsVO [id=" + id + ", b_userid=" + b_userid + ", b_date=" + b_date + ", b_time=" + b_time
				+ ", b_subject=" + b_subject + ", b_content=" + b_content + ", b_hit=" + b_hit + ", b_image=" + b_image
				+ "]";
	}

	
	
	
	
}
