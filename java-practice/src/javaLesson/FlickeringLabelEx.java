package javaLesson;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlickeringLabelEx extends JFrame {

	public FlickeringLabelEx() {
		setTitle("Runnable 활용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		FlickeringLabel fLabel1 = new FlickeringLabel("깜빡");
		
		JLabel label = new JLabel("안깜빡");
		
		FlickeringLabel fLabel2 = new FlickeringLabel("여기도 깜빡");
		
		contentPane.add(fLabel1);
		contentPane.add(label);
		contentPane.add(fLabel2);
		
		setSize(400, 150);
		setVisible(true);
	} // close constructor
	
	public static void main(String[] args) {
		new FlickeringLabelEx();

	} // close main

} // close class

class FlickeringLabel extends JLabel implements Runnable {	

	public FlickeringLabel(String text) {
		super(text);
		setOpaque(true); // 배경색 변경이 가능하도록 설정
		
		Thread th = new Thread(this);
		th.start();
	} // close constructor

	@Override
	public void run() {
		int n = 0;
		while(true) {
			if(n == 0) {
				setBackground(Color.YELLOW);
				n = 1;
			} else {
				setBackground(Color.GREEN);
				n = 0;
			} // close if-else
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				return;
			} // close try-catch
		} // close while
		
	} // close method
	
} // close class