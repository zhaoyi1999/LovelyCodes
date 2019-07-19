package cn.ksb.minitxt.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.ksb.minitxt.common.constants.UserConstants;
import cn.ksb.minitxt.common.entity.User;
import cn.ksb.minitxt.server.Init;

/***
 * 用户工具类
 * 
 * @author Administrator
 * 
 */
public class UserUtils {
	private static Document document = null;
	private static final String PATH = Init.getProperty("server.config.user");// 配置文件的位置
	private static Map<String, User> users = new HashMap<>();
	// 加载用户配置文件的信息

	/***
	 * 读取配置文件代码块
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
			for (@SuppressWarnings("unchecked")
			Iterator<Element> userIt = rootEle.elementIterator("user"); userIt
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

	/***
	 * 登录
	 * 
	 * @param user
	 * @return
	 */
	public static int doLogin(User user) {
		User check = null;
		// 从Map-users中通过key(username) 查找value-user
		// 判断用户是否为空，为空则返回UserConstants.USERNAME_NOT_EXSITS
		if ((check = users.get(user.getUsername())) != null) {
			// 判断密码是否一致，一致则返回UserConstants.SUCCESS
			// 不一致则返回UserConstants.PASSWORD_INVALID
			if (check.getPassword().equals(user.getPassword())) {
				return UserConstants.SUCCESS;
			} else {
				return UserConstants.PASSWORD_INVALID;
			}
		}
		return UserConstants.USERNAME_NOT_EXSITS;
	}

	/***
	 * 查询用户是否已存在
	 * 
	 * @param username
	 * @return 返回是否为空 否则为true;是则为false
	 */
	protected static boolean exists(String username) {
		return (users.get(username) != null);
	}

	/***
	 * 注册
	 * 
	 * @param user
	 * @return
	 */
	public static synchronized int doRegister(User user) {
		if (exists(user.getUsername())) {
			return UserConstants.USERNAME_IS_EXSITS;
		}
		Element rootEle = document.getRootElement();
		Element newUser = rootEle.addElement("user");
		Element username = newUser.addElement("username");
		username.setText(user.getUsername());
		Element password = newUser.addElement("password");
		password.setText(user.getPassword());
		try {
			users.put(user.getUsername(), user);
			saveXML(PATH);
			return UserConstants.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		rootEle.remove(newUser);
		return UserConstants.ERROR;
	}

	/***
	 * 保存修改到XML文件
	 */
	public static void saveXML(String xmlPath) {
		// 转换器
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(
					xmlPath)), format);
			writer.write(document);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
