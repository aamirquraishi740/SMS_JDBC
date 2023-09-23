package com.example.entity;

public class Student {

	Integer id;

	String name;

	String phone;

	String city;

	public Student(int id2, String name2, String phone2, String city2) {
		// TODO Auto-generated constructor stub
		id = id2;
		name = name2;
		phone = phone2;
		city = city2;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phone=" + phone + ", city=" + city + "]";
	}



}
