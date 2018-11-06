package javaLesson;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GraphicsFillEx2 extends JFrame {
	Container contentPane;

	GraphicsFillEx2() {
		setTitle("Fill 관련 메소드 예제");
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
			g.setColor(Color.RED);
			g.fillArc(20, 20, 200, 200, 90, 120);
			g.setColor(Color.BLUE);
			g.fillArc(20, 20, 200, 200, 210, 120);
			g.setColor(Color.GREEN);
			g.fillArc(20, 20, 200, 200, -30, 120);

		}

	}

	public static void main(String[] args) {
		new GraphicsFillEx2();

	}
}
