package com.kgc.phone;

/***
 * 普通手机类
 * 
 * @author 继承：HandSet
 * @author 接口：Playing
 */
public class CommonPhone extends HandSet implements Playing {

	public CommonPhone() {

	}

	public CommonPhone(String brand, String type) {
		super(brand, type);
	}

	public void sendMsg() {
		System.out.println("发送短信");
	}

	public void call() {
		System.out.println("打电话");
	}

	public void playAudio(String name) {
		System.out.println("播放音频：《" + name + "》");
	}

	public void playVideo(String name) {

	}

	public void playAudio() {

	}

}
