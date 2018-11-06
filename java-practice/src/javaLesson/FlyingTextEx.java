package javaLesson;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FlyingTextEx extends JFrame {
	JPanel contentPane = new JPanel();
	JLabel label = new JLabel("HELLO");
	final int FLYING_UNIT = 10;

	FlyingTextEx() {
		setTitle("상,하,좌,우 키를 이용하여 텍스트를 움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.addKeyListener(new MyKeyListener2());

		label.setLocation(50, 50);
		label.setSize(100, 20);
		contentPane.add(label);

		setSize(300, 300);
		setVisible(true);
		contentPane.requestFocus();
	}

	class MyKeyListener2 extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			switch (keyCode) {
			case KeyEvent.VK_UP:
				label.setLocation(label.getX(), label.getY() - FLYING_UNIT);
				break;
			case KeyEvent.VK_DOWN:
				label.setLocation(label.getX(), label.getY() + FLYING_UNIT);
				break;
			case KeyEvent.VK_LEFT:
				label.setLocation(label.getX() - FLYING_UNIT, label.getY());
				break;
			case KeyEvent.VK_RIGHT:
				label.setLocation(label.getX() + FLYING_UNIT, label.getY());
				break;
			}
		}
	}

	public static void main(String[] args) {
		new FlyingTextEx();

	}

}
