package com.kgc.stu;

public class Student {
	private int age;
	String name;
	public String address;
	
	
	public static String email;
	
	public void method1(){
		System.out.println(age);
		System.out.println(email);
		method2();
	}
	
	public static void method2(){
		System.out.println();
	}
	
	
}
