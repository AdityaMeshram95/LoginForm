package com.entity;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP")
public class Employee {

	// Instance variable
	@Id
	private int EmpId;

	private String name;
	private String BDate;
	private String gender;
	private String address;
	private String city;
	private String state;
	private String username;
	private String password;

	// Default Constructor
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	// constructor
	public Employee(String name, String BDate, String gender, String address, String city, String state,
			String username, String password) {
		super();
		this.EmpId = new Random().nextInt(1000);
		this.name = name;
		this.BDate = BDate;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.state = state;
		this.username = username;
		this.password = password;
	}

	// getter method
	public int getSrNo() {
		return EmpId;
	}

	public String getName() {
		return name;
	}

	public String getEmpDate() {
		return BDate;
	}

	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
