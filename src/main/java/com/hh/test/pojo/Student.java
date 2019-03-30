package com.hh.test.pojo;

public class Student {
	
	private String id;
	private String Name;
	private String Sex;
	private String Age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + Name + ", Sex=" + Sex + ", Age=" + Age + "]";
	}
	
	

}
