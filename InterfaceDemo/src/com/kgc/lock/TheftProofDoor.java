package com.kgc.lock;

//防盗门
public class TheftProofDoor extends Door implements Lock, TakePhoto {

	public void lockUp() {
		System.out.println("插钥匙，开锁");
	}

	public void lockOpen() {
		System.out.println("插钥匙，反锁");
	}

	public void open() {
		System.out.println("开门");
	}

	public void close() {
		System.out.println("关门");
	}

	public void takePhoto() {
		System.out.println("有人来过");
	}

}
