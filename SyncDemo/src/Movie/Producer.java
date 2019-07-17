package Movie;

public class Producer implements Runnable {
	private Movies movies = null;
	private boolean flag = false;

	public Producer(Movies movies) {
		super();
		this.movies = movies;
	}

	public void run() {
		// 循环录入50遍电影数据，两部电影交替录入
		for (int i = 0; i < 50; i++) {
			if (flag) {
				this.movies.set("变形金刚", "科幻电影");
				flag = false;
			} else {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.movies.set("神偷奶爸", "3D动画电影");
				flag = true;
			}
		}
	}

}
