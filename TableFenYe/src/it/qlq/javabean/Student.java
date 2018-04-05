package it.qlq.javabean;

import java.io.Serializable;

public class Student implements Serializable {


 
	/**
	 * 
	 */
	private int id;//学生的id
	private String stuName;//学生的姓名
	private int age;//学生的年龄
	private int gender;//学生的性别
	private String address;//学生的地址
	
	
	public Student() {
		
	}
	protected Student(int id, String stuName, int age, int gender, String address) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", stuName=" + stuName + ", age=" + age + ", gender=" + gender + ", address="
				+ address + "]";
	}
	
	
}
