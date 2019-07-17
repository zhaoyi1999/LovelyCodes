package Movie;

public class Test {
	public static void main(String[] args) {
		Movies movies = new Movies();
		Thread prod = new Thread(new Producer(movies));
		Thread cons = new Thread(new Consummer(movies));
		prod.start();
		cons.start();
	}
}
