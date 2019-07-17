package com.kgc.printer;

/***
 * 测试类
 */
public class Test {
	public static void main(String[] args) {
		InkBox inkBox=new GrayInkBox();
		Paper paper=new A4Paper();
		Printer printer=new Printer();
		printer.setInkBox(inkBox);
		printer.setPaper(paper);
		printer.print();
		
		inkBox=new ColorInkBox();
		paper=new B5Paper();
		printer.setInkBox(inkBox);
		printer.setPaper(paper);
		printer.print();
	}
}
