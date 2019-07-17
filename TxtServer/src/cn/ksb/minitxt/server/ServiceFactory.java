package cn.ksb.minitxt.server;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/***
 * Service工厂类： 读取配置文件，根据客户端传递的关键字调用具体的实现类
 * 
 * @author Administrator
 * 
 */
public class ServiceFactory {
	private static final String PATH = Init
			.getProperty("server.config.service");// 配置文件的位置
	private static Document document;
	private static Map<String, String> services = new HashMap<>();
	// 初始化，在类加载的时候之执行一次
	static {
		// 获得document对象
		// 解析器
		SAXReader saxReader = new SAXReader();
		try {
			document = saxReader.read(new File(PATH));
			// 获取XML根节点
			Element rootEle = document.getRootElement();
			// 获取所有<service>迭代器
			Iterator serviceEle = rootEle.elementIterator();
			while (serviceEle.hasNext()) {
				// 迭代出所有的<service>
				Element service = (Element) serviceEle.next();
				// 将key的值和文本写入到HashMap中
				services.put(service.attributeValue("key").trim(), service
						.getText().trim());
			}

		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

	/***
	 * 通过关键字key获得类名并返回类的实例
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> Service<T> getService(String key) {
		// 根据key，获取HashMap里的类名
		String classname = services.get(key);
		if (classname == null)
			throw new RuntimeException("无效的关键字传递");
		try {
			// 创建类的实例并返回
			return (Service<T>) Class.forName(classname).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
