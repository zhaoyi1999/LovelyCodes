package cn.ksb.minitxt.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.ksb.minitxt.common.entity.User;
import cn.ksb.minitxt.server.Init;

/***
 * 用户工具类
 * 
 * @author Administrator
 * 
 */
public class UserUtils {
	private static Document document;
	private static final String PATH = Init.getProperty("server.config.user");// 配置文件的位置
	private static Map<String, User> users = new HashMap<>();
	// 加载用户配置文件的信息

	/***
	 * 读取配置文件的方法
	 */
	static {
		// 获得document对象
		// 解析器
		SAXReader saxReader = new SAXReader();
		try {
			document = saxReader.read(new File(PATH));
			// 获取XML根节点<users>
			Element rootEle = document.getRootElement();
			// 获取所有<user>迭代器
			User user = null;
			for (Iterator<Element> userIt = rootEle.elementIterator("user"); userIt
					.hasNext();) {
				user = new User();
				// 迭代出所有的<user>
				Element usersEle = userIt.next();

				user.setUsername(usersEle.element("username").getText().trim());
				user.setPassword(usersEle.element("password").getText().trim());
				// 将username和user对象 写入到HashMap中
				users.put(user.getUsername(), user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static int doLogin(User user) {
		
		return 0;

	}
}
