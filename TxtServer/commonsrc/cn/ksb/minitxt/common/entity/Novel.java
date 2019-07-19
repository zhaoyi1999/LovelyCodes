package cn.ksb.minitxt.common.entity;

import java.io.Serializable;

/***
 * 小说信息封装类
 */
public class Novel implements Serializable {

	/**
	 * 识别ID
	 */
	private static final long serialVersionUID = 740955768556983797L;
	private String name;// 小说名
	private String author;// 作者
	private String desc;// 描述
	private String filename;// 实际文件名

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
