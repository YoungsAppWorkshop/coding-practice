package javaLesson;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;


public class GamblingGameGUI extends JFrame {
	private static final int MAX = 2;
	JPanel contentPane = new JPanel();
	JLabel label1 = new JLabel("0");
	JLabel label2 = new JLabel("0");
	JLabel label3 = new JLabel("0");
	JLabel resultLabel = new JLabel("시작합니다.");
	
	public GamblingGameGUI() {
		setTitle("Gambling Game GUI");
		setContentPane(contentPane);
		contentPane.setBackground(Color.LIGHT_GRAY);
		setBackground(Color.LIGHT_GRAY);
		contentPane.setLayout(null);
		contentPane.addKeyListener(new keyListenerGamblingGame());
		

		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		label1.setBackground(Color.RED);
		label1.setOpaque(true);
		label1.setBounds(64, 93, 62, 67);
		contentPane.add(label1);
		

		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		label2.setBackground(Color.YELLOW);
		label2.setOpaque(true);
		label2.setBounds(188, 93, 62, 67);
		contentPane.add(label2);
		

		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		label3.setBackground(Color.GREEN);
		label3.setOpaque(true);
		label3.setBounds(312, 93, 62, 67);
		contentPane.add(label3);
		
		
		resultLabel.setBounds(64, 191, 310, 18);
		contentPane.add(resultLabel);
		
		setSize(500, 300);
		setVisible(true);
		contentPane.requestFocus();
	}

	class keyListenerGamblingGame extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int num1 = (int) (Math.random() * MAX);
			int num2 = (int) (Math.random() * MAX);
			int num3 = (int) (Math.random() * MAX);
			
			label1.setText(Integer.toString(num1));
			label2.setText(Integer.toString(num2));
			label3.setText(Integer.toString(num3));
			if ((num1 == num2) && (num2 == num3)) {
				resultLabel.setText("빙고!!");
			} else {
				resultLabel.setText("꽝!! 다음 기회에...");
			}
			
		}
	}
	
	public static void main(String[] args) {
		new GamblingGameGUI();

	}
}
