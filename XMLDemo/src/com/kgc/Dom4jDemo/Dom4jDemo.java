package com.kgc.Dom4jDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/***
 * Dom4j
 * 
 * @author Administrator
 * 
 */
public class Dom4jDemo {

	private Document document;

	/***
	 * 获得document对象
	 */
	public void loadDocument() {
		// 解析器
		SAXReader saxReader = new SAXReader();
		try {
			document = saxReader.read(new File("XMLDemo.xml"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

	/***
	 * 显示手机品牌和信息
	 */
	public void showInfo() {
		// 获取XML根节点
		Element rootEle = document.getRootElement();
		// 获取所有<Brand>
		Iterator brandsEle = rootEle.elementIterator();
		while (brandsEle.hasNext()) {
			Element brand = (Element) brandsEle.next();
			System.out.println(brand.attributeValue("name"));
			Iterator typesEle = brand.elementIterator();
			while (typesEle.hasNext()) {
				Element type = (Element) typesEle.next();
				System.out.println("\t" + type.attributeValue("name"));
			}
		}

	}

	/***
	 * 增加节点
	 */
	public void add() {
		// 获取XML的根元素
		Element rootEle = document.getRootElement();
		// 创建<Brand name = "小米">
		Element brandsEle = rootEle.addElement("Brand");
		brandsEle.addAttribute("name", "小米");
		// 创建<Type name = "小米10">
		Element typeEle = brandsEle.addElement("Type");
		typeEle.addAttribute("name", "小米10");
		saveXML("newXMLDemo.xml");
	}

	/***
	 * 修改节点
	 */
	public void update() {
		Element rootEle = document.getRootElement();
		Iterator brand = rootEle.elementIterator();
		int id = 0;
		while (brand.hasNext()) {
			Element brandEle = (Element) brand.next();
			id++;
			brandEle.addAttribute("id", id + "");
		}
		saveXML("newXMLDemo.xml");
	}

	/***
	 * 删除节点
	 */
	private void delete() {
		Element rootEle = document.getRootElement();
		Iterator brand = rootEle.elementIterator();
		while (brand.hasNext()) {
			Element brandEle = (Element) brand.next();
			if (brandEle.attributeValue("name").equals("华为")) {
				brandEle.getParent().remove(brandEle);
			}
		}
		saveXML("newXMLDemo.xml");
	}

	/***
	 * 保存修改到XML文件
	 */
	public void saveXML(String xmlPath) {
		// 转换器
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
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

	public static void main(String[] args) {
		Dom4jDemo dom4j = new Dom4jDemo();
		dom4j.loadDocument();
		dom4j.add();
		dom4j.update();
		dom4j.delete();
		dom4j.showInfo();
	}

}
