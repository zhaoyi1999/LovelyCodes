package com.kgc.collectionsDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//测试Collections常用方法
public class CollectionsDemo1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("zoo");
		list.add("aminal");
		list.add("fruit");
		list.add("banana");
		list.add("study");
		list.add("teacher");
		list.add("love");
		
		//打印输出集合中的最大值和最小值	Collections.max/min(T)
		System.out.println(Collections.max(list)+"-"+Collections.min(list));
		
		//排序	Collections.sort(T)
		Collections.sort(list);
		for (String string : list) {
			System.out.println(string);
		}
		
		//二分查找		Collections.binarySearch(T,K)
		System.out.println(Collections.binarySearch(list, "zoo"));
		
		//反转集合元素/降序	Collections.reverse(T)
		Collections.reverse(list);
		
	}
}
