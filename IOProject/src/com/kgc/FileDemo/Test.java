package com.kgc.FileDemo;

import java.io.File;

public class Test {
	public static void main(String[] args) {
		File inFile = new File("src\\files\\1.txt");
		File outFile = new File("src\\files\\2.txt");
		BufferedDemo bd = new BufferedDemo();
//		System.out.println(bd.read(inFile));
//		String readResult = bd.read(inFile);
//		int writeResult = bd.write(readResult, outFile, true);
//		System.out.println(readResult);
//		if (writeResult == 1) {
//			System.out.println("写入成功！");
//		}

		int result = bd.copy(inFile, outFile, true);
		if (result != -1) {
			System.out.println("复制成功！");
		} else {
			System.out.println("复制失败！");
		}
//
//		FileStream fs = new FileStream();
//		int flag = fs.copy(inFile, outFile);
//		if (flag != -1 && flag != -2 && flag != 0) {
//			System.out.print("已复制" + flag + "字节，");
//			System.out.println("目标文件已更新");
//		} else if (flag == -1) {
//			System.out.println("Err:FileNotFoundException");
//		} else if (flag == -2) {
//			System.out.println("Err:IOException");
//		} else if (flag == 0) {
//			System.out.println("Err:IOException");
//		}

	}
}
