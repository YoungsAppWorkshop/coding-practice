package javaLesson;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawEx extends JFrame {
	Container contentPane;

	GraphicsDrawEx() {
		setTitle("Draw 관련 메소드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		setSize(500, 500);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawRect(20, 20, 80, 80);
			g.setColor(Color.red);
			g.drawOval(200, 20, 80, 80);
			g.setColor(Color.green);
			g.drawRoundRect(300, 20, 80, 80, 20, 20);
			g.setColor(Color.gray);
			g.drawLine(20, 200, 100, 280);
		}

	}

	public static void main(String[] args) {
		new GraphicsDrawEx();

	}

}
