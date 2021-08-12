package com.mindtree.areamanagement.modules.admin.dto;

public class AdminDto {
	private int id;
	private String userName;
	private String email;
	private String password;
	private long phone;

	public AdminDto() {
		super();
	}

	public AdminDto(String userName, String email, String password, long phone) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public AdminDto(int  id, String userName, String email, String password, long phone) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public AdminDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

}