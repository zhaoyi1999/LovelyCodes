package ThreadDemo1;
/***
 * 获取和设置主线程的名称
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println(t.getName());
		t.setName("Main");
		System.out.println(t.getName());
	}
}
