import java.io.File;

public class Test {
	public static void main(String[] args) {
		FileDemo filedemo = new FileDemo();
		File file = new File("src\\files\\1.txt");
		filedemo.create(file);
		filedemo.showFileInfo(file);
		// filedemo.delete(file);
	}
}
