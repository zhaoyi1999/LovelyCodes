package com.kgc.Thread;
/***
 * 实现休眠
 * @author Administrator
 *
 */
public class Wait {
	public static void bySec(int second){
		for (int i = 0; i < second; i++) {
			System.out.println(i+1+"秒");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
