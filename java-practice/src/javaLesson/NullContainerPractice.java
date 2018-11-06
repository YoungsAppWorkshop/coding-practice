package javaLesson;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class NullContainerPractice extends JFrame {
	NullContainerPractice() {
		setTitle("Null Container Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(null); // 컨텐트팬의 배치관리자 제거 

		for (int i = 0; i < 20; i++) {
			int x = (int) (Math.random() * 201) + 50;
			int y = (int) (Math.random() * 201) + 50;						

			JLabel label = new JLabel();			
			label.setBackground(Color.BLUE);
			label.setOpaque(true);
			
			label.setLocation(x, y); 
			label.setSize(10, 10);
			container.add(label); 
		}
		
		setSize(300, 300);
        setVisible(true);
	}
	
	public static void main(String[] args) {
		new NullContainerPractice();
	}

}
