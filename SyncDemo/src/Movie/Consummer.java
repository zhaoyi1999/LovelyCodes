package Movie;

public class Consummer implements Runnable {
	private Movies movies = null;

	public void run() {
		// 循环显示50次电影信息
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.movies.get();
		}
	}

	public Consummer(Movies movies) {
		super();
		this.movies = movies;
	}

}
