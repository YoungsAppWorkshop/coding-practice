package javaLesson;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsClipEx extends JFrame {
	Container contentPane;

	GraphicsClipEx() {
		setTitle("클리핑 예제");
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
			g.setClip(100, 100, 300, 200);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			g.setColor(Color.ORANGE);
			g.setFont(new Font("SanSerif", Font.ITALIC, 40));
			g.drawString("Go Gator!!", 10, 150);
		}
	}

	public static void main(String[] args) {
		new GraphicsClipEx();

	}

}
