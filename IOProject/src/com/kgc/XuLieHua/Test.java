package com.kgc.XuLieHua;

import java.io.File;

public class Test {
	public static void main(String[] args) {
		File inFile = new File("src\\files\\student.txt");
		//File outFile = new File("src\\files\\student.txt");
		SeriaDemo sd = new SeriaDemo();
		Student stu = new Student(1,"小红","女","123456");
		sd.seria(stu, inFile);
		Student stu1 = (Student)sd.unSeria(inFile);
		System.out.println("反序列化的内容为：");
		System.out.println(stu1.getId());
		System.out.println(stu1.getName());
		System.out.println(stu1.getSex());
		System.out.println(stu1.getPass());
	}
}
