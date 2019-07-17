package com.kgc.XuLieHua;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/***
 * 实现序列化和反序列化
 */

public class SeriaDemo {

	/***
	 * 序列化学生对象
	 * 
	 * @param stu
	 */
	public void seria(Student stu,File outFile) {
		ObjectOutputStream oos = null;
		OutputStream fos = null;
		
		try {
			fos = new FileOutputStream(outFile);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(stu);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/***
	 * 反序列化目标文件
	 * 
	 * @param file
	 *            File>>要反序列化的文件路径
	 * @return 返回Object对象
	 */
	public Object unSeria(File inFile) {

		ObjectInputStream ois = null;
		InputStream fis = null;
		
		try {
			fis = new FileInputStream(inFile);
			ois = new ObjectInputStream(fis);
			return ois.readObject();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
	}

}
