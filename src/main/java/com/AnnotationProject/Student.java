package com.AnnotationProject;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	int id;
	private String firstname , lastname;
	private String phone;
	private String address;
	private String email;
	private String branch;

	
	public Student() {
		// TODO Auto-generated constructor stub
		super();
		
	}
	public Student(int id,String firstname,String lastname,String phone,String address,String email,String branch) {
		super();
		this.id=id;
		this.firstname=firstname;
		this.lastname=lastname;
		this.phone=phone;
		this.address=address;
		this.email=email;
		this.branch=branch;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
