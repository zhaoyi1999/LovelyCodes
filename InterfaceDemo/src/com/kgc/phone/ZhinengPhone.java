package com.kgc.phone;

/***
 * 智能手机类
 * 
 * @author 继承：HandSet（抽象类_手机）
 * @author 接口：TakePhoto,NetWorking,Playing
 */
public class ZhinengPhone extends HandSet implements TakePhoto, NetWorking,
		Playing {

	public ZhinengPhone() {

	}

	public ZhinengPhone(String brand, String type) {
		super(brand, type);
	}

	public void sendMsg() {
		System.out.println("发送文字+图片+视频信息");
	}

	public void call() {
		System.out.println("视频通话");
	}

	public void playAudio(String name) {
		System.out.println("播放音频：《" + name + "》");
	}

	public void playVideo(String name) {
		System.out.println("播放视频：《" + name + "》");
	}

	public void netWork() {
		System.out.println("上网");
	}

	public void tackPhotos() {
		System.out.println("拍照");
	}

}
