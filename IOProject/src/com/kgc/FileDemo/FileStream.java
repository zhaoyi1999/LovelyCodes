package com.kgc.FileDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream {
	public int copy(File inFile, File outFile) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(inFile);
			fos = new FileOutputStream(outFile);
			if (inFile.exists() && outFile.exists()) {
				byte[] b = new byte[(int) inFile.length()];
				int len = -1;
				while ((len = fis.read(b)) != -1) {
					fos.write(b, 0, len);
					return len;
				}
			} else {
				return 0;
			}
		} catch (FileNotFoundException e) {
			return -1;
		} catch (IOException e) {
			return -2;
		} finally {
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				return -3;
			}
		}
		return 0;
	}
}
