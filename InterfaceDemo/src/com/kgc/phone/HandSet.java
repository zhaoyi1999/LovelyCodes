package com.kgc.phone;

/***
 * 手机类
 */
public abstract class HandSet {

	private String brand;
	private String type;

	public HandSet() {

	}

	public HandSet(String brand, String type) {
		this.brand = brand;
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/***
	 * 手机_收发短信
	 */
	public abstract void sendMsg();

	/***
	 * 手机_打电话
	 */
	public abstract void call();

	/***
	 * 手机_显示信息
	 */
	public void showInfo() {
		System.out.println("这是一台" + brand + type);
	}
}
