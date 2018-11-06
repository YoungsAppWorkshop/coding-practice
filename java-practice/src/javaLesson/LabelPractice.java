package javaLesson;


import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LabelPractice extends JFrame {
	int second;
	Calendar startTime;
	Calendar endTime;
	JLabel [] label = new JLabel[10];	
	JLabel textLabel; 
	int nextNumber = 9;
	
	LabelPractice() {
		startTime = Calendar.getInstance();
		setTitle("Clicking Number Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(null); // 컨텐트팬의 배치관리자 제거 
		
		textLabel = new JLabel();
		textLabel.setText("큰 수부터 작은 수까지 클릭해서 숫자를 제거하세요");
		textLabel.setOpaque(true);
		textLabel.setLocation(10,10);	
		textLabel.setSize(300, 15);

		container.add(textLabel);

		for (int i = 0; i < 10; i++) {
			int x = (int) (Math.random() * 401) + 50;
			int y = (int) (Math.random() * 401) + 50;						

			label[i] = new JLabel();	
			label[i].setText(Integer.toString(i));
			label[i].setOpaque(true);
			label[i].addMouseListener(new LabelActionListener());
			label[i].setLocation(x, y); 
			label[i].setSize(10, 10);
			container.add(label[i]); 
		}
		
		setSize(500, 500);
        setVisible(true);
	}
	
	public static void main(String[] args) {
		new LabelPractice();

	}
	
	class LabelActionListener implements MouseListener {
		public void mouseClicked(MouseEvent arg0){
			JLabel l = (JLabel)arg0.getSource();
			if(l == label[nextNumber]) {
				l.setText("");
				nextNumber--;
			}
			
			if(nextNumber == -1) {
				endTime = Calendar.getInstance();
				second = endTime.get(Calendar.SECOND) - startTime.get(Calendar.SECOND);
				
				textLabel.setText(second + "초 만에 숫자를 모두 제거했습니다.");
			}
		}

		public void mousePressed(MouseEvent arg0){}

		public void mouseReleased(MouseEvent arg0){}

		public void mouseEntered(MouseEvent arg0){}

		public void mouseExited(MouseEvent arg0){}
	}
}
