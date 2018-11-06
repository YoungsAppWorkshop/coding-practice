package headFirstJavaExercises;

public class RyanAndMonicaJob implements Runnable {

	private BankAccount account = new BankAccount();

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			makeWithdrawal(10);
			if (account.getBalance() < 0) {
				System.out.println("Overdrawn!");
			} // close if

		} // close for loop

	} // close method

	private synchronized void makeWithdrawal(int amount) {
		if (account.getBalance() >= amount) {
			System.out.println(Thread.currentThread().getName() + " is about to withdraw... " + "(Balance : " + account.getBalance()+" )");
			try {
				System.out.println(Thread.currentThread().getName() + " is going to sleep... " + "(Balance : " + account.getBalance()+" )");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();

			} // close try-catch

			System.out.println(Thread.currentThread().getName() + " woke up... " + "(Balance : " + account.getBalance()+" )");
			account.withdraw(amount);
			System.out.println(Thread.currentThread().getName() + " completes the withdrawal... " + "(Balance : " + account.getBalance()+" )");

		} else {
			System.out.println("Sorry, not enough for " + Thread.currentThread().getName() + " ... " + "(Balance : " + account.getBalance()+" )");
			
		} // close if-else

	} // close method

	public static void main(String[] args) {
		RyanAndMonicaJob theJob = new RyanAndMonicaJob();
		Thread one = new Thread(theJob);
		Thread two = new Thread(theJob);

		one.setName("Ryan");
		two.setName("Monica");

		one.start();
		two.start();

	} // close main

} // close class

class BankAccount {
	private int balance = 100;

	public int getBalance() {
		return balance;

	} // close method

	public void withdraw(int amount) {
		balance -= amount;

	} // close method

} // close class