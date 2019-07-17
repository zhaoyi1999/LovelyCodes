package com.kgc.printer;

/***
 * 打印机类
 */
public class Printer {
	InkBox inkBox;
	Paper paper;

	public InkBox getInkBox() {
		return inkBox;
	}

	public void setInkBox(InkBox inkBox) {
		this.inkBox = inkBox;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	/***
	 * 打印机_打印
	 */
	public void print(){
		System.out.println("使用"+inkBox.getColor()+"的墨盒在"+paper.getSize()+"纸上打印");
	}
	
}
