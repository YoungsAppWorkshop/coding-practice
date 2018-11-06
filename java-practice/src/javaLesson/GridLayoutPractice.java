package javaLesson;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GridLayoutPractice extends JFrame {
	GridLayoutPractice() {
		setTitle("GridLayout Sample"); // 프레임의 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		GridLayout grid = new GridLayout(4, 4); // 4x4 격자의 GridLayout 배치관리자
		c.setLayout(grid); // grid를 컨텐트팬의 배치관리자로 지정

		for (int i = 0; i < 16; i++) {
			int red = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			
			Color color = new Color(red, green, blue);
			JLabel label = new JLabel();
			
			label.setBackground(color);
			label.setOpaque(true);
			c.add(label);
		}

		setSize(400, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GridLayoutPractice();

	}

}
