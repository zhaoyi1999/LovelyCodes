package cn.ksb.minitxt.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.ksb.minitxt.common.entity.Classification;
import cn.ksb.minitxt.common.entity.Novel;
import cn.ksb.minitxt.server.Init;

/***
 * 小说工具类
 */
public class NovelUtils {
	private static Document document = null;
	private static final String PATH = Init.getProperty("server.config.class");
	private static Map<String, Classification> classes = new HashMap<>();
	private static Map<String, Map<String, Novel>> novels = new HashMap<>();

	// 加载小说类别
	// 加载小说信息
	static {
		// 获得document对象
		// 解析器
		SAXReader saxReader = new SAXReader();
		try {
			document = saxReader.read(new File(PATH));
			// 获取XML根节点<classes>
			Element rootEle = document.getRootElement();
			// 获取所有<class>迭代器
			Classification classifcation = null;
			for (@SuppressWarnings("unchecked")
			Iterator<Element> classIt = rootEle.elementIterator("class"); classIt
					.hasNext();) {
				classifcation = new Classification();
				// 迭代出所有的<class>
				Element classesEle = classIt.next();

				classifcation.setClassname(classesEle.element("classname")
						.getText().trim());
				classifcation.setCatalog(classesEle.element("catalog")
						.getText().trim());
				classifcation.setConfig(classesEle.element("config").getText()
						.trim());
				// 将classname和Classification对象 写入到HashMap中
				classes.put(classifcation.getClassname(), classifcation);
			}

			for (Classification clf : classes.values()) {
				document = saxReader.read(new FileInputStream(clf.getConfig()));
				// 根节点<novellist>
				rootEle = document.getRootElement();
				Novel novel = null;
				Map<String, Novel> nls = null;
				for (@SuppressWarnings("unchecked")
				Iterator<Element> novelIt = rootEle.elementIterator("class"); novelIt
						.hasNext();) {
					novel = new Novel();
					// 迭代出所有的<novel>
					Element novelEle = novelIt.next();
					novel.setName(novelEle.element("name").getText().trim());
					novel.setAuthor(novelEle.element("author").getText().trim());
					novel.setDesc(novelEle.element("description").getText()
							.trim());
					novel.setFilename(novelEle.element("filename").getText()
							.trim());
					nls = new HashMap<>();
					nls.put(novel.getName(), novel);
				}
				novels.put(clf.getClassname(), nls);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("小说配置信息加载失败");
		}
	}

	/***
	 * 将Map小说类别 转换成数组发送出去
	 * 
	 * @return
	 */
	public static Classification[] getClasses() {
		return classes.values().toArray(new Classification[0]);
	}

	/***
	 * 用来返回小说指定分类的信息
	 * 
	 * @param classification
	 * @return
	 */
	public static Novel[] getNovels(Classification classification) {
		return novels.get(classification.getClassname()).values().toArray(new Novel[0]);
	}
}
