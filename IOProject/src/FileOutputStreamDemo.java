import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
	/*
	 * write() write(byte[] b) write(byte[] b,int off,int len) close() flush()
	 * -清空缓冲区
	 */
	public static void main(String[] args) {

		String file = "G:\\WorkSpace\\IOProject\\src\\files\\1.txt";
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file, true);
			String str=">>好好学习Java";
			byte[] byteStr = str.getBytes(); //将字符串转换为字节数组
			fos.write(byteStr,0,byteStr.length);
			System.out.println("文件已更新");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
