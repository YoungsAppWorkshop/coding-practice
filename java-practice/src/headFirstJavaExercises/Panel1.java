package headFirstJavaExercises;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel1 {

	public static void main(String[] args) {
		Panel1 gui = new Panel1();
		gui.go();
	}

	public void go() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton button = new JButton("shock me");
		JButton button2 = new JButton("bliss");
		JButton button3 = new JButton("huh?");
		
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		frame.getContentPane().add(BorderLayout.EAST, panel);
		
		frame.setSize(250, 200);
		frame.setVisible(true);
	}
}
