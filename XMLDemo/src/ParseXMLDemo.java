import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/***
 * 使用DOM解析XML文件
 */
public class ParseXMLDemo {
	// XMLDemo.xml对应的Document对象
	private Document document;

	/***
	 * 获得DOM树，获得Document对象
	 */
	public void getDOM() {
		// 获得解析器工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			// 根据解析器工厂获得解析器
			DocumentBuilder builder = factory.newDocumentBuilder();
			// 解析器来解析XML文件获得Document对象
			document = builder.parse("XMLDemo.xml");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/***
	 * 获取手机品牌及相关信息
	 */
	public void showInfo() {
		// 以Document作为起点，先拿到所有的Brand节点
		NodeList brands = document.getElementsByTagName("Brand");
		// 遍历
		for (int i = 0; i < brands.getLength(); i++) {
			Node brandNode = brands.item(i);
			Element eleBrand = (Element) brandNode;
			String brandName = eleBrand.getAttribute("name");
			System.out.println(brandName);

			// 继续查找，找每个Brand的子节点出来
			NodeList types = eleBrand.getChildNodes();
			for (int j = 0; j < types.getLength(); j++) {
				Node typeNode = types.item(j);
				if (typeNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eleType = (Element) typeNode;
					System.out.println(eleType.getAttribute("name"));
				}
			}
		}
	}

	/***
	 * 为XML文件添加元素
	 */
	public void addEle() {
		// <Brand name = "三星" />
		Element brand = document.createElement("Brand");
		brand.setAttribute("name", "三星");
		// <Type name = "Note7"/>
		Element type = document.createElement("Type");
		type.setAttribute("name", "Note7");
		// 将Type作为Brand的子元素
		brand.appendChild(type);
		// 将Brand放到Phone中去
		document.getElementsByTagName("Phone").item(0).appendChild(brand);
	}

	/***
	 * 保存有变化的XML文件 需要借助转换器（源（最新的DOM树）>>目的地（XMLDemo.xml文件）） 借助输出流
	 */
	public void saveXML(String path) {
		// 转换器工厂
		TransformerFactory factory = TransformerFactory.newInstance();
		try {
			// 转换器
			Transformer transformer = factory.newTransformer();
			// 指定转换格式
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "YES");

			// 源 DOMSource
			DOMSource source = new DOMSource(document);
			OutputStream out = new FileOutputStream(path);
			StreamResult result = new StreamResult(new OutputStreamWriter(out,
					"UTF-8"));
			// 源（最新的DOM树）>>目的地（XMLDemo.xml文件）
			transformer.transform(source, result);

		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	/***
	 * 修改元素
	 */
	public void updateEle() {
		// 获取所有的Brand
		NodeList brands = document.getElementsByTagName("Brand");
		for (int i = 0; i < brands.getLength(); i++) {
			Node brandNode = brands.item(i);
			Element brandEle = (Element) brandNode;
			brandEle.setAttribute("id", i + "");
		}
		saveXML("XMLDemo.xml");
	}

	public void deleteEle() {
		// 获取所有的Brand
		NodeList brands = document.getElementsByTagName("Brand");
		for (int i = 0; i < brands.getLength(); i++) {
			Node brandNode = brands.item(i);
			Element brandEle = (Element) brandNode;
			if (brandEle.getAttribute("name").equals("华为")) {
				brandEle.getParentNode().removeChild(brandEle);
			}
		}
		saveXML("XMLDemo.xml");
	}

}
