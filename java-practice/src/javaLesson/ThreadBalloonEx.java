package javaLesson;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThreadBalloonEx extends JFrame {
	Container contentPane;
	JPanel panel;

	ThreadBalloonEx() {
		setTitle("Thread Balloon Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.addMouseListener(new MyMouseAdapter());
		contentPane.add(panel);

		setSize(500, 500);
		setVisible(true);
	} // close constructor

	public static void main(String[] args) {
		new ThreadBalloonEx();

	} // close main

	class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			BalloonThread balloon = new BalloonThread(e.getX(), e.getY());
			balloon.start();
		} // close method

	} // close inner class

	class BalloonThread extends Thread {
		int x;
		int y;

		public BalloonThread(int x, int y) {
			this.x = x;
			this.y = y;
		} // close constructor

		public void run() {
			ImageIcon balloonImage = new ImageIcon("images/balloon.jpg");
			JLabel balloon = new JLabel(balloonImage);
			balloon.setLocation(x, y);
			balloon.setSize(60, 60);
			panel.add(balloon);
			repaint();

			while (y > 0) {
				try {
					Thread.sleep(50);
				} catch (Exception e) {
					e.printStackTrace();
				}
				y -= 5;
				balloon.setLocation(x, y);
				repaint();
			} // close while
			panel.remove(balloon);
		} // close method
		
	} // close inner class

} // close outer class
