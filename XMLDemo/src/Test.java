public class Test {
	public static void main(String[] args) {

		ParseXMLDemo parse = new ParseXMLDemo();
		parse.getDOM();
		// parse.addEle();
		// parse.deleteEle();
		// parse.updateEle();
		parse.saveXML("XMLDemo.xml");
		parse.showInfo();
	}

}
