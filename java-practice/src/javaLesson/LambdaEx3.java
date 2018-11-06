package javaLesson;

public class LambdaEx3 {

	public static void main(String[] args) {

		System.out.println("Anonymous 표현");
		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
						System.out.println("Anonymous..." + System.currentTimeMillis());
					} catch (InterruptedException e) {
						e.printStackTrace();
					} // close try-catch
				} // close while
			} // close method

		}.start();

		System.out.println("Lambda 표현식");
		new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(1000);
					System.out.println("Lambda..." + System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} // close try-catch
			} // close while
		}).start();

	} // close main

} // close class
