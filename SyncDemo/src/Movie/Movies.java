package Movie;

public class Movies {

	private String name;
	private String info;
	private boolean flag = false;//控制生产者生产，消费者消费

	public Movies() {
	}

	public Movies(String name, String info) {
		super();
		this.name = name;
		this.info = info;
	}

	public String getName() {
		return name;
	}

	public String getInfo() {
		return info;
	}

	public synchronized void set(String name, String info) {
		if (flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.info = info;
		flag = true;
		super.notify();
	}

	public synchronized void get() {
		if (!flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.getName() + ":" + this.getInfo());
		flag = false;
		super.notify();
	}
}
