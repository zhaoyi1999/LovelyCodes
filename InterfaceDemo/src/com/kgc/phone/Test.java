package com.kgc.phone;

/***
 * 测试类
 */
public class Test {
	public static void main(String[] args) {
		CommonPhone common = new CommonPhone("OPPO", "R20");
		common.showInfo();
		common.call();
		common.sendMsg();
		common.playAudio("秋天不回来");

		System.out.println("===============================");

		ZhinengPhone zhineng = new ZhinengPhone("iPhone", "XS MAX");
		zhineng.showInfo();
		zhineng.call();
		zhineng.sendMsg();
		zhineng.tackPhotos();
		zhineng.netWork();
		zhineng.playVideo("哔哩哔哩");
	}
}
