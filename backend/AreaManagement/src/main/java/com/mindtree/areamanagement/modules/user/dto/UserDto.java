package com.mindtree.areamanagement.modules.user.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.areamanagement.modules.address.entity.Address;
import com.mindtree.areamanagement.modules.genie.entity.Genie;
import com.mindtree.areamanagement.modules.location.entity.Location;

public class UserDto {
	
	private int id;
	private long aadhar;
	private String userName;
	private String email;
	private String password;
	private long phone;
	private String role;
	@JsonIgnoreProperties("users")
	private Location location;
	@JsonIgnoreProperties("users")
	private List<Genie> genie;
	@JsonIgnoreProperties("users")
	private Address address;
	
	public UserDto() {
		super();
	}
	
	public UserDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	

	public UserDto(String userName, long phone) {
		super();
		this.userName = userName;
		this.phone = phone;
	}

	public UserDto(long aadhar, String userName, String email, String password, long phone) {
		super();
		this.aadhar = aadhar;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}
	

	public UserDto(int id, long aadhar, String userName, String email, String password, long phone, String role) {
		super();
		this.id = id;
		this.aadhar = aadhar;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
	}

	public UserDto(int id, long aadhar, String userName, String email, String password, long phone, String role,
			Location location, List<Genie> genie, Address address) {
		super();
		this.id = id;
		this.aadhar = aadhar;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
		this.location = location;
		this.genie = genie;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getAadhar() {
		return aadhar;
	}

	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Genie> getGenie() {
		return genie;
	}

	public void setGenie(List<Genie> genie) {
		this.genie = genie;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


}
