package com.mindtree.areamanagement.modules.address.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindtree.areamanagement.modules.user.entity.User;


@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int flatNo;
	private String address1;
	private String address2;

	@JsonIgnore
	@OneToOne(mappedBy="address")
	private User user;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int flatNo, String address1, String address2, User user) {
		super();
		this.flatNo = flatNo;
		this.address1 = address1;
		this.address2 = address2;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
