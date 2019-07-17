package com.kgc.collectionsDemo;

public class Student implements Comparable<Student> {
	// 学号 姓名 性别
	private int id;

	private String name;
	private String sex;

	public Student() {
	}

	public Student(int id, String name, String sex) {
		this.id = id;
		this.name = name;
		this.sex = sex;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	// 编写比较规则，让当前学员对象（this）和传过来的学员对象比较（o）
	// 以学员的学号为比较规则
	public int compareTo(Student student) {
		if (this.id == student.id) {
			return 0;
		} else if (this.id > student.id) {
			return 1;
		} else {
			return -1;
		}
	}
}
