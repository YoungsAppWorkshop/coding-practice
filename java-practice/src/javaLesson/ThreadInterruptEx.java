package javaLesson;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadInterruptEx extends JFrame {
	Thread th;

	public ThreadInterruptEx() {
		setTitle("Thread Interrupt Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();

		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));

		TimerRunnable runnable = new TimerRunnable(timerLabel);
		th = new Thread(runnable);
		contentPane.add(BorderLayout.CENTER, timerLabel);

		JButton button = new JButton("Kill Timer");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				th.interrupt();
				JButton button = (JButton) e.getSource();
				button.setEnabled(false);
			} // close method
		}); // close anonymous class
		contentPane.add(BorderLayout.EAST, button);
		setSize(400, 150);
		setVisible(true);

		th.start();

	} // close constructor

	public static void main(String[] args) {
		new ThreadInterruptEx();

	} // close main

} // close class

class TimerRunnable implements Runnable {
	JLabel timerLabel;

	public TimerRunnable(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	} // close constructor

	@Override
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
