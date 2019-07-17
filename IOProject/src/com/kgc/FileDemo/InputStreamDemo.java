package com.kgc.FileDemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class InputStreamDemo {
	private final static String KEY = "file.encoding";

	/***
	 * 读取指定文件路径的指定文件内容
	 * 
	 * @param inFile
	 *            >>要读取的文件路径
	 * @return 返回已读取的字符串
	 */
	public String read(File inFile) {
		Reader isr = null;
		try {
			InputStream fis = new FileInputStream(inFile);
			isr = new InputStreamReader(fis, System.getProperty(KEY));
			
			BufferedReader br = new BufferedReader(isr);
			
			String line = null;
			
			while(!(line = br.readLine()).isEmpty()){
				System.out.println(line);
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}

		}
		return null;

	}

	public int write(String text, File outFile, boolean isAdd) {
		Writer fw = null;
		try {
			fw = new FileWriter(outFile, isAdd);
			fw.write(text);
			fw.flush();
			return 1;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
