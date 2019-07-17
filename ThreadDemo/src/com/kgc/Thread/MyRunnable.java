package com.kgc.Thread;

/***
 * 实现Runnable接口方式创建线程
 * 
 * @author Administrator
 * 
 */
public class MyRunnable implements Runnable {

	public void run() {

		for (int i = 0; i < 100; i++) {
			// try {
			// Thread.sleep(10);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
			System.out.println(Thread.currentThread().getName() + ":" + i);
			
			
			
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//线程礼让
			if (i==30) {
				Thread.yield();
				System.out.print("线程礼让：");
			}
		
		}

		// System.out.println("线程正在运行");
		//
		// try {
		// Thread.sleep(1000);
		// System.out.println("线程休眠1000毫秒，处于阻塞状态");
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// System.out.println("线程被中断");
		// }

	}

}
