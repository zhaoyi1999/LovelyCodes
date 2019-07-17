package DeadLock;

/***
 * 模拟死锁
 * 
 * @author Administrator
 * 
 */
public class Test {
	public static void main(String[] args) {
		Object bobby = new Object();
		Object duck = new Object();
		Thread tangtang = new Thread(new Tangtang(bobby, duck), "糖糖");
		Thread doudou = new Thread(new Doudou(bobby, duck), "豆豆");
		tangtang.start();
		doudou.start();
	}
}

class Tangtang implements Runnable {
	Object bobby;
	Object duck;

	public Tangtang(Object bobby, Object duck) {
		super();
		this.bobby = bobby;
		this.duck = duck;
	}

	public void run() {
		synchronized (bobby) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (duck) {

			}
			System.out.println("糖糖愿意把芭比给豆豆");
		}
	}

}

class Doudou implements Runnable {
	Object bobby;
	Object duck;

	public Doudou(Object bobby, Object duck) {
		super();
		this.bobby = bobby;
		this.duck = duck;
	}

	public void run() {
		synchronized (duck) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (bobby) {

			}
			System.out.println("豆豆愿意把玩具鸭给糖糖");
		}
	}
}
