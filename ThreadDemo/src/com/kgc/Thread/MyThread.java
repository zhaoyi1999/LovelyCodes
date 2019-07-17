package com.kgc.Thread;
/***
 * 继承Thread类的方式创建线程、线程礼让
 * @author Administrator
 *
 */
public class MyThread extends Thread{
	public void run(){
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		
		}
	}
}
