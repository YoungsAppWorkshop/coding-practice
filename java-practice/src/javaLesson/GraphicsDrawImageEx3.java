package javaLesson;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawImageEx3 extends JFrame {
	Container contentPane;

	GraphicsDrawImageEx3() {
		setTitle("drawImage 사용 예제 3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();

		MyPanel panel = new MyPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		setSize(900, 600);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		ImageIcon imageIcon = new ImageIcon("images/image0.jpg");
		Image image = imageIcon.getImage();

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), 100, 100, 1000, 700, this);
		}
	}

	public static void main(String[] args) {
		new GraphicsDrawImageEx3();

	}

}
