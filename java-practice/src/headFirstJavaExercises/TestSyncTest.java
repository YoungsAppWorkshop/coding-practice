package headFirstJavaExercises;

class TestSync implements Runnable {

	private int balance;

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			increment();
			System.out.println(Thread.currentThread().getName() + " thread is running... balance is " + balance);
		}

	}

	public synchronized void increment() {
		int i = balance;
		balance = i + 1;
	}
}

public class TestSyncTest {
	public static void main(String[] args) {
		TestSync job = new TestSync();
		Thread a = new Thread(job);
		Thread b = new Thread(job);
		a.setName("a");
		b.setName("b");
		a.start();
		b.start();
	}

}
