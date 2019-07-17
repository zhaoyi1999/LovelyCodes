package com.kgc.FileDemo;

import java.io.File;

public class PicCopy {
	public static void main(String[] args) {
		FilePic fp = new FilePic();
		File inFile = new File("C:\\Users\\Administrator.GJA51XPC9K6G0MW\\Pictures\\Camera Roll\\香蕉君.jpg");
		File outFile = new File("G:\\香蕉君.jpg");
		int result = fp.copy(inFile, outFile);
		if (result == 1) {
			System.out.println("复制成功！");
		}
	}
}
