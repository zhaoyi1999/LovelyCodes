package cn.ksb.minitxt.common.entity;

import java.io.Serializable;

/***
 * 小说分类信息类
 * 
 * @author Administrator
 * 
 */
public class Classification implements Serializable {

	/**
	 * 识别ID
	 */
	private static final long serialVersionUID = -3775314292722399520L;
	private String classname;// 小说分类名
	transient private String catalog;// 小说文件存储目录
	transient private String config;// 配置文件存储路径

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

}
