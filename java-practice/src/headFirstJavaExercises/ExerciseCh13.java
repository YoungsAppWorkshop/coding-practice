package headFirstJavaExercises;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExerciseCh13 {
	
	public static void main(String[] args) {
		ExerciseCh13 gui = new ExerciseCh13();
		gui.goE();
	}
	
	public void goA() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		
		JButton button = new JButton("tesuji");
		JButton buttonTwo = new JButton("watari");

		panel.add(button);
		frame.getContentPane().add(BorderLayout.NORTH, buttonTwo);
		frame.getContentPane().add(BorderLayout.EAST, panel);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	public void goB() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		
		JButton button = new JButton("tesuji");
		JButton buttonTwo = new JButton("watari");

		panel.add(buttonTwo);
		frame.getContentPane().add(BorderLayout.CENTER, button);
		frame.getContentPane().add(BorderLayout.EAST, panel);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	public void goC() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		
		JButton button = new JButton("tesuji");
		JButton buttonTwo = new JButton("watari");

		panel.add(buttonTwo);
		frame.getContentPane().add(BorderLayout.CENTER, button);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	public void goD() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		
		JButton button = new JButton("tesuji");
		JButton buttonTwo = new JButton("watari");

		frame.getContentPane().add(BorderLayout.NORTH, panel);
		panel.add(buttonTwo);
		frame.getContentPane().add(BorderLayout.CENTER, button);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	public void goE() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		
		JButton button = new JButton("tesuji");
		JButton buttonTwo = new JButton("watari");

		frame.getContentPane().add(BorderLayout.SOUTH, panel);
		panel.add(buttonTwo);
		frame.getContentPane().add(BorderLayout.NORTH, button);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
