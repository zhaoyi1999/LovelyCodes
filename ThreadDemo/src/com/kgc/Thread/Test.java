package com.kgc.Thread;

/***
 * 查看线程的状态、设置线程的优先级
 * 
 * @author Administrator
 * 
 */
public class Test {
	public static void main(String[] args) {
		// MyThread mt = new MyThread();
		// MyThread mt2 = new MyThread();
		// MyThread mt3 = new MyThread();

		// mt.run(); 直接调用run()会导致只有主线程一条执行路径
		// mt2.run(); 一次调用两次run()方法

		// mt.start(); //启动线程
		// mt2.start(); //开启多个线程时多个线程交替执行
		// mt3.start(); //不是并行执行

		// Runnable myRannable = new MyRunnable();
		// Thread t = new Thread(myRannable,"MyThread");
		// t.start();

		// 设置线程的优先级：最高为10，最低为1，默认为5
		// Thread thread = new Thread(new MyRunnable(), "线程A");
		// Thread thread2 = new Thread(new MyRunnable(), "线程B");
		// thread.setPriority(Thread.MAX_PRIORITY);
		// thread2.setPriority(Thread.MIN_PRIORITY);
		// thread.start();
		// thread2.start();

		// System.out.println("线程处于新建状态");
		// thread.start();
		// System.out.println("线程处于就绪状态");

		// System.out.println("---------------主线程开始休眠--------------");
		// Wait.bySec(5);// 让主线程休眠5秒
		// System.out.println("---------------主线程开始休眠--------------");

		// 测试join()
		// Thread thread = new Thread(new MyRunnable(),"线程A");
		// thread.start();
		// for (int i = 0; i < 200; i++) {
		// //当主线程执行到i==20时，让子线程thread强制执行
		// if (i==20) {
		// try {
		// thread.join();
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
		// try {
		// Thread.sleep(10);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// System.out.println(Thread.currentThread().getName()+":"+i);
		// }

		// 暂停当前线程，允许其他具有相同优先级的线程获得运行机会
		// 该线程处于就绪状态，不转为阻塞状态
		// Thread thread1 = new Thread(new MyRunnable(), "线程A");
		// Thread thread2 = new Thread(new MyRunnable(), "线程B");
		// thread1.start();
		// thread2.start();

		
	}
}
