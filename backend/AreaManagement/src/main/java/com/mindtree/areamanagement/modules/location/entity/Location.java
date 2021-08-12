package com.mindtree.areamanagement.modules.location.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindtree.areamanagement.modules.user.entity.User;


@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String locationName;
	private String city;
	private String state;
	private String country;
	private int pincode;

	@JsonIgnore
	@OneToMany(mappedBy="location")
	private List<User> users=new ArrayList<>();
	public Location() {
		super();
	}

	public Location(String locationName, String city, String state, String country, int pincode) {
		super();
		this.locationName = locationName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	
	}

	public Location(int locationId) {
		this.id=locationId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


}
