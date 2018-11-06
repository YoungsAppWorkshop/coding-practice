package javaLesson;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadFinishFlagEx extends JFrame {
	RandomThread th;

	public ThreadFinishFlagEx() {
		setTitle("Thread Finish Flag Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		contentPane.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				th.finish();
			} // close method
		}); // close anonymous class

		setSize(500, 500);
		setVisible(true);

		th = new RandomThread(contentPane);

		th.start();
	} // close constructor

	public static void main(String[] args) {
		new ThreadFinishFlagEx();

	} // close main

} // close class

class RandomThread extends Thread {
	Container contentPane;
	boolean flag = false;

	public RandomThread(Container contentPane) {
		this.contentPane = contentPane;
	} // close constructor

	void finish() {
		flag = true;
	} // close method

	public void run() {
		while (true) {
			int x = (int) (Math.random() * contentPane.getWidth());
			int y = (int) (Math.random() * contentPane.getHeight());
			JLabel label = new JLabel("Java");
			label.setSize(80, 30);
			label.setLocation(x, y);
			contentPane.add(label);
			contentPane.repaint();

			try {
				Thread.sleep(300);
				if (flag == true) {
					contentPane.removeAll();
					label = new JLabel("Finish");
					label.setSize(80, 30);
					label.setLocation(100, 100);
					label.setForeground(Color.RED);
					contentPane.add(label);
					contentPane.repaint();
					return;
				} // close if
				
			} catch (Exception e) {
				return;
			} // close try-catch
			
		} // close while
		
	} // close method

} // close class