package com.kgc.FileDemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/***
 * 二进制文件的操作
 */
public class FilePic {
	public int copy(File inFile, File outFile) {
		InputStream fis = null;
		OutputStream fos = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			fis = new FileInputStream(inFile);
			fos = new FileOutputStream(outFile);
			dis = new DataInputStream(fis);
			dos = new DataOutputStream(fos);
			int temp = -1;
			while ((temp = dis.read()) != -1) {
				dos.write(temp);
			}
			return 1;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				dos.close();
				dis.close();
				fos.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
				return -1;
			}
		}

	}
}
