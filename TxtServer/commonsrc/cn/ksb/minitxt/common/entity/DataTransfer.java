package cn.ksb.minitxt.common.entity;

import java.io.Serializable;

/***
 * 数据传输类
 */
public class DataTransfer<T extends Serializable> implements
		java.io.Serializable {

	/***
	 * 识别ID
	 */
	private static final long serialVersionUID = -2084661773114897622L;

	private String key; // 关键字
	private T data; // 对象
	private int result; // 结果

	// 封装

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
