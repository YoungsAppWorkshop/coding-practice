package javaLesson;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadTimerEx extends JFrame {
	
	public ThreadTimerEx() {
		setTitle("Thread 활용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		
		TimerThread th = new TimerThread(timerLabel);
		contentPane.add(timerLabel);
		
		setSize(400, 150);
		setVisible(true);
		
		th.start();
	} // close constructor

	public static void main(String[] args) {
		new ThreadTimerEx();

	} // close main

} // close class

class TimerThread extends Thread {
	JLabel timerLabel;

	public TimerThread(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}

	public void run() {
		int n = 0;

		while (true) {
			timerLabel.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				return;
			}
		} // close while
	} // close method
} // close class