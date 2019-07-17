package ErrSale;
/***
 * 模拟多人抢票 、线程同步
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		Site site = new Site();
		//当多个线程共享同一资源时
		//一个线程未完成全部操作时
		//其他线程修改了数据
		//造成数据不安全问题
		Thread person1 = new Thread(site,"黄牛1");
		Thread person2 = new Thread(site,"黄牛2");
		Thread person3 = new Thread(site,"黄牛3");
		person1.start();
		person2.start();
		person3.start();
		
		
	}
}
