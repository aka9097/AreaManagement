
package com.mindtree.areamanagement.modules.genie.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mindtree.areamanagement.modules.user.entity.User;

@Entity
public class Genie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String severity;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date date;
	private boolean status;

	@JsonIgnore
	@ManyToMany
	private List<User> users = new ArrayList<User>();

	public Genie() {
		super();
	}

	public Genie(String name, String severity, String description, Date date, boolean status, List<User> users) {
		super();
		this.name = name;
		this.severity = severity;
		this.description = description;
		this.date = date;
		this.status = status;
		this.users = users;
	}
	
	public Genie(String severity, String description) {
		super();
		this.severity = severity;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}