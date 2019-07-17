import java.io.File;
import java.io.IOException;

/***
 * 文件操作类：创建文件、查看文件相关信息、删除文件
 */
public class FileDemo {
	//北京-->南京-->上海-->广州  1.txt
	//C:\User\Administrator\公用\1.txt	绝对路径
	//Administrator\公用\1.txt			相对路径
	
	/***
	 * 创建文件
	 * @param file
	 */
	public void create(File file){
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("文件已创建");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/***
	 * 查看文件相关信息
	 * @param file
	 */
	public void showFileInfo(File file){
		if (file.exists()) {
			if (file.isFile()) {
				System.out.println("文件名："+file.getName());
				System.out.println("相对路径："+file.getPath());
				System.out.println("绝对路径："+file.getAbsolutePath());
				System.out.println("文件大小："+file.length()+"字节");
			}
			if (file.isDirectory()) {
				System.out.println("此文件是目录");
			}
		}else {
			System.out.println("文件不存在");
		}
	}
	
	/***
	 * 删除文件
	 * @param file
	 */
	public void delete(File file){
		if (file.exists()) {
			file.delete();
			System.out.println("文件已删除!");
		}
	}
	
}
