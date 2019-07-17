package ErrSale;

/***
 * 模拟网站抢票，多线程共享数据
 * 
 * @author Administrator
 * 
 */
public class Site implements Runnable {

	private int ticktCount = 10; // 记录剩余票数
	private int peopleNum = 0; // 记录当前抢到多少张票

	public void run() {
		// 循环 当剩余票数为0时，结束

		while (true) {
			if (ticktCount <= 0) {
				break;
			}
			// 1.修改数据（剩余票数、抢到第几张票）
			ticktCount--;
			peopleNum++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 2.显示信息，反馈用户抢到第几张票
			System.out.println(Thread.currentThread().getName() + "抢到第"
					+ peopleNum + "张票，剩余" + ticktCount + "张票");
		}
	}

}
