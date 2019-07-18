package cn.ksb.minitxt.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/***
 * 读取配置文件中的键值对的工具类
 */
public class Init {
	private static Properties props = new Properties();

	// 加载读取配置文件
	static {
		InputStream is = null;
		try {
			is = new FileInputStream("config\\client.properties");
			props.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/***
	 * 读取键值对
	 * @param key
	 * @return 返回value
	 */
	public static String getProperty(String key) {
		return props.getProperty(key);
	}

}
