package javaLesson;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ListenerMouseEx extends JFrame {

	ListenerMouseEx() {
		setTitle("버튼에 Mouse 이벤트 리스너 작성");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btn = new JButton("Mouse Event 테스트 버튼");
		btn.setBackground(Color.yellow);
		MyMouseListener listener = new MyMouseListener();
		btn.addMouseListener(listener);

		add(btn);
		setSize(300, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ListenerMouseEx();
	}
}

class MyMouseListener implements MouseListener {
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		btn.setBackground(Color.red);
	}
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		btn.setBackground(Color.YELLOW);
	}
}