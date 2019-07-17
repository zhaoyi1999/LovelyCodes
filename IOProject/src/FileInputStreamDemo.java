import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//读取文件G:\WorkSpace\IOProject\src\files\1.txt中的内容
/*
 * read()
 * read(byte[] b)
 * read(byte[] b,int off,int len)
 */

public class FileInputStreamDemo {
	public static void main(String[] args) {
		String file = "G:\\WorkSpace\\IOProject\\src\\files\\1.txt";
		FileInputStream fis = null;
		try {
			// 输入流FileInputStream
			fis = new FileInputStream(file);
			System.out.println("可读字节数为：" + fis.available());
			// 借助输入流的方法read()读文件
			/*int data;
			while ((data = fis.read()) != -1) {
				System.out.print((char) data);
			}*/
			
			//借助输入流的方法read(byte[] b)读文件
			byte[] b = new byte[1024];
			while (fis.read(b) != -1) {
				/*for (int i = 0; i < data; i++) {
					System.out.print((char)b[i]);
				}*/
				for (byte c : b) {
					System.out.print((char)c);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
