package com.kgc.voter;

public class Test {
	public static void main(String[] args) {
		Voter zhang = new Voter("张三");
		zhang.touPiao();
		Voter li = new Voter("李四");
		li.touPiao();
		Voter wang = new Voter("王五");
		wang.touPiao();

		for (int i = 1; i <= 97; i++) {
			Voter v = new Voter("v" + i);
			v.touPiao();
		}

		Voter v101=new Voter("v101");
		v101.touPiao();
		
		Voter.printResult();
	}
}
