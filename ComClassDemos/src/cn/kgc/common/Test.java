package cn.kgc.common;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
	public static void main(String[] args) {
		Random rand = new Random();
		Random rand2 = new Random();
		
		
		int i = rand.nextInt(10);
		int i2 = rand2.nextInt(10);
		System.out.println(i+"\t"+i2);
		String pi = "3.141592653589793238462643383279541";
		String pipi = pi.substring(0,9);
		System.out.println(pipi);
		
		Date date = new Date();
		SimpleDateFormat fomarter =new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
		String sdate = fomarter.format(date);
		System.out.println(sdate);
	}
}
