package com.kgc.voter;

public class Voter {
	private String name;

	private static int count;
	
	private static final int MAX_COUNT=100;
	
	public Voter(){
		
	}
	
	public Voter(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public void touPiao(){
		if (count==MAX_COUNT) {
			System.out.println("活动结束！");
		}else {
			count++;
			System.out.println(this.name+"感谢您投票");
		}
	}
	
	public static void printResult(){
		System.out.println("投票总数"+count);
	}
}
