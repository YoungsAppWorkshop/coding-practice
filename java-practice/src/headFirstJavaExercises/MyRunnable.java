package headFirstJavaExercises;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		go();
		
	} // close method

	private void go() {
		doMore();
		
	} // close method

	private void doMore() {
		System.out.println("top o' the stack");
		
	} // close method

} // close class

class ThreadTestDrive {

	public static void main(String[] args) {
		Runnable threadJob = new MyRunnable();
		Thread myThread = new Thread(threadJob);
		
		myThread.start();
		
		System.out.println("back in main");

	} // close main

} // close class
