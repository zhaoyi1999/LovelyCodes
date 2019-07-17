package com.kgc.FileDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/***
 * 带缓冲区的文件操作
 * 
 * @author Administrator
 * 
 */
public class BufferedDemo {
	private final static String KEY = "file.encoding";

	/***
	 * 读取指定文件路径的指定文件内容
	 * 
	 * @param inFile
	 *            File>>要读取的文件路径
	 * @return 返回已读取的字符串
	 */
	public String read(File inFile) {
		InputStream fis = null;
		Reader isr = null;
		BufferedReader br = null;
		StringBuffer result = null;
		try {
			fis = new FileInputStream(inFile);
			isr = new InputStreamReader(fis, System.getProperty(KEY));
			br = new BufferedReader(isr);
			if (fis.available() == 0) {
				return "-1";
			}
			result = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				result.append(line);
				result.append("\r\n");
			}
			result.deleteCharAt(result.length() - 1);
			return result.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				fis.close();
				br.close();
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}

		}

	}

	/***
	 * 带缓冲区的文件写入
	 * 
	 * @param text
	 *            String >>要写入的文本内容
	 * @param outFile
	 *            File >>要写入内容的文件路径
	 * @param isAdd
	 *            Boolean >>追加_true;覆盖_false;
	 * @return 写入成功返回1；否则返回-1
	 */
	public int write(String text, File outFile, boolean isAdd) {
		Writer fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(outFile, isAdd);
			bw = new BufferedWriter(fw);
			if (!read(outFile).equals("-1")) {
				bw.newLine();
			}
			bw.write(text);
			bw.flush();
			return 1;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	}

	/***
	 * 带缓冲的文件内容复制
	 * 
	 * @param inFile
	 *            File>>要读取的文件路径
	 * @param outFile
	 *            File >>要写入内容的文件路径
	 * @param isAdd
	 *            Boolean >>追加_true;覆盖_false;
	 * @return 复制成功返回1;否则返回-1
	 */
	public int copy(File inFile, File outFile, boolean isAdd) {
		return write(read(inFile), outFile, isAdd);
	}
}
