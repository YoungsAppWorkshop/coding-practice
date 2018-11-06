package javaLesson;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class BulletGameFrame extends JFrame {

	public BulletGameFrame() {
		setTitle("사격 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GamePanel p = new GamePanel();
		setContentPane(p);
		setSize(500, 500);
		setResizable(false);
		setVisible(true);
		p.startGame();
	} // close constructor

	public static void main(String[] args) {
		new BulletGameFrame();
	} // close method

} // close class

class GamePanel extends JPanel {
	TargetThread targetThread = null;
	JLabel baseLabel = new JLabel();
	JLabel bulletLabel = new JLabel();
	JLabel targetLabel;

	public GamePanel() {
		setLayout(null);
		this.setBackground(Color.WHITE);

		baseLabel.setSize(40, 40);
		baseLabel.setOpaque(true);
		baseLabel.setBackground(Color.BLACK);

		ImageIcon img = new ImageIcon("images/target.jpg");
		targetLabel = new JLabel(img);
		targetLabel.setSize(img.getIconWidth(), img.getIconWidth());

		bulletLabel.setSize(8, 8);
		bulletLabel.setOpaque(true);
		bulletLabel.setBackground(Color.RED);
		add(baseLabel);
		add(targetLabel);
		add(bulletLabel);

	} // close constructor

	public void startGame() {
		baseLabel.setLocation(this.getWidth() / 2 - 20, this.getHeight() - 40);
		bulletLabel.setLocation(this.getWidth() / 2 - 5, this.getHeight() - 50);
		targetLabel.setLocation(0, 0);

		targetThread = new TargetThread(targetLabel);
		targetThread.start();

		baseLabel.requestFocus();
		baseLabel.addKeyListener(new KeyAdapter() {
			BulletThread bulletThread = null;

			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (bulletThread == null || !bulletThread.isAlive()) {
						bulletThread = new BulletThread(bulletLabel, targetLabel, targetThread);
						bulletThread.start();
					} // close if
				} // close if

			}// close method

		}); // close anonymous class

	} // close method

	class TargetThread extends Thread {
		JComponent target;

		public TargetThread(JComponent target) {
			this.target = target;
			target.setLocation(0, 0);
			target.getParent().repaint();
		} // close constructor

		public void run() {
			while (true) {
				int x = target.getX() + 5;
				int y = target.getY();
				if (x > target.getParent().getWidth()) { // GamePanel.this.getWidth())
					target.setLocation(0, 0);
				} else {
					target.setLocation(x, y);
				} // close if-else

				target.getParent().repaint();
				try {
					sleep(35);
				} catch (InterruptedException e) {
					// the case of hit by a bullet
					target.setLocation(0, 0);
					target.getParent().repaint();
					try {
						sleep(500); // 0.5초 기다린 후에 계속한다.
					} catch (InterruptedException e2) {
					} // close try-catch
				} // close try-catch
			} // close while
		} // close method
	} // close inner class

	class BulletThread extends Thread {
		JComponent bullet, target;
		Thread targetThread;

		public BulletThread(JComponent bullet, JComponent target, Thread targetThread) {
			this.bullet = bullet;
			this.target = target;
			this.targetThread = targetThread;
		} // close constructor

		public void run() {

			while (true) {
				// 명중하였는지 확인
				if (hit()) {
					targetThread.interrupt();
					bullet.setLocation(bullet.getParent().getWidth() / 2 - 5, bullet.getParent().getHeight() - 50);
					return;

				} else {
					int x = bullet.getX();
					int y = bullet.getY() - 5;
					if (y < 0) {
						bullet.setLocation(bullet.getParent().getWidth() / 2 - 5, bullet.getParent().getHeight() - 50);
						bullet.getParent().repaint();
						return; // thread ends
					} // close if

					bullet.setLocation(x, y);
					bullet.getParent().repaint();

				} // close if-else

				try {
					sleep(20);
				} catch (InterruptedException e) {
				} // close try-catch

			} // close while

		} // close method

		private boolean hit() {
			if (targetContains(bullet.getX(), bullet.getY())
					|| targetContains(bullet.getX() + bullet.getWidth() - 1, bullet.getY())
					|| targetContains(bullet.getX() + bullet.getWidth() - 1, bullet.getY() + bullet.getHeight() - 1)
					|| targetContains(bullet.getX(), bullet.getY() + bullet.getHeight() - 1)) {
				return true;
			} else {
				return false;
			} // close if-else
		} // close method

		private boolean targetContains(int x, int y) {
			if (((target.getX() <= x) && (target.getX() + target.getWidth() - 1 >= x))
					&& ((target.getY() <= y) && (target.getY() + target.getHeight() - 1 >= y))) {
				return true;
			} else {
				return false;
			} // close if-else

		} // close method

	} // close inner class

} // close outer class
