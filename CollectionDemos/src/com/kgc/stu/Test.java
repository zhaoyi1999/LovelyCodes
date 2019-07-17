package com.kgc.stu;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		Map<String, Student> students = new HashMap<String, Student>();
		// 键-值对：学员的英文名-学员
		students.put("jack", new Student("张三", "男"));
		students.put("tom", new Student("李四", "男"));
		students.put("kitty", new Student("王五", "女"));

		// 根据特定的key获取相应的value
		Scanner input = new Scanner(System.in);
		System.out.print("请输入要寻找的学员的英文名：");
		String key = input.next();
		if (students.containsKey(key)) {
			Student stu = (Student)students.get(key);
			System.out.println("您要找的学员是："+stu.getName()+";性别："+stu.getSex());
		} else {
			System.out.println("对不起，没有您要寻找的学员！");
		}
	}
}
