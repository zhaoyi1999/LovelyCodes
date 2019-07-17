package com.kgc.collectionsDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//测试Collections常用方法
public class CollectionsDemo2 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		Student s1 = new Student (1,"张三","男");
		Student s2 = new Student (4,"jack","男");
		Student s3 = new Student (2,"kitty","女");
		Student s4 = new Student (9,"小兰","女");
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		
		//排序	Collections.sort(T)
		Collections.sort(list);
		for (Student student : list) {
			System.out.println(student.getId()+"-"+student.getName());
		}
		
		//二分查找		Collections.binarySearch(T,K)
		//System.out.println(Collections.binarySearch(list, "zoo"));
		
		//反转集合元素/降序	Collections.reverse(T)
		Collections.reverse(list);
		
	}
}
