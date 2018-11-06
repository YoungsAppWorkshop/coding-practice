package javaLesson;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TabAndThreadEx extends JFrame {
	MyLabel bar = new MyLabel(100);

	TabAndThreadEx() {
		setTitle("Bar Filling game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		bar.setOpaque(true);
		bar.setBackground(Color.ORANGE);
		bar.setLocation(20, 50);
		bar.setSize(300, 20);

		contentPane.add(bar);
		contentPane.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				bar.fill();
			} // close method
		}); // close anonymous class

		setSize(350, 200);
		setVisible(true);
		contentPane.requestFocus();

		ConsumerThread th = new ConsumerThread(bar);
		th.start();
	} // close constructor

	public static void main(String[] args) {
		new TabAndThreadEx();

	} // close main

} // close class

class MyLabel extends JLabel {
	int barSize = 0;
	int maxBarSize;

	MyLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	} // close constructor

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		int width = this.getWidth() / maxBarSize * barSize;
		if (width != 0) {
			g.fillRect(0, 0, width, this.getHeight());
		} // close if

	} // close method

	synchronized void fill() {
		if (barSize == maxBarSize) {
			try {
				wait();
			} catch (Exception e) {
				return;
			}
		} // close if
		barSize += 5;
		repaint();
		notify();
	} // close method

	synchronized void consume() {
		if (barSize == 0) {
			try {
				wait();
			} catch (Exception e) {
				return;
			} // close try-catch
		} // close if
		barSize--;
		repaint();
		notify();
	} // close method

} // close class

class ConsumerThread extends Thread {
	MyLabel bar;

	public ConsumerThread(MyLabel bar) {
		this.bar = bar;
	} // close constructor

	public void run() {
		while (true) {
			try {
				sleep(200);
				bar.consume();
			} catch (Exception e) {
				return;
			} // close try-catch

		} // close while

	} // close method

} // close class
