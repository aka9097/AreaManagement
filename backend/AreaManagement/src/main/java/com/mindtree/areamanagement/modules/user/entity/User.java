package com.mindtree.areamanagement.modules.user.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.mindtree.areamanagement.modules.address.entity.Address;
import com.mindtree.areamanagement.modules.genie.entity.Genie;
import com.mindtree.areamanagement.modules.location.entity.Location;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private long aadhar;
	private String userName;
	@Column(unique = true)
	private String email;
	private String password;
	private long phone;
	private String role;
	@ManyToOne
	private Location location;
	@ManyToMany(mappedBy = "users")
	private List<Genie> genie;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	public User() {
		super();
	}

	
	
//public User(String userName, String password) {
//		super();
//		this.userName = userName;
//		this.password = password;
//	}



	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}



	public User(long aadhar, String userName, String email, String password, long phone, String role) {
		super();
		this.aadhar = aadhar;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
	}


	

	public User(long aadhar, String userName, String email, String password, long phone, String role, Location location,
			Address address) {
		super();
		this.aadhar = aadhar;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
		this.location = location;
		this.address = address;
	}



	public User(byte id, long aadhar, String userName, String email, String password, long phone, String role,
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

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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
