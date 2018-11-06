package javaLesson;

import javax.swing.JFrame;
import java.awt.Dimension;

import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JLabelEx extends JFrame {
	public JLabelEx() {
		setSize(new Dimension(400, 400));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("클릭!!");
		btnNewButton.setPressedIcon(new ImageIcon("D:\\workspace_java\\javaTutorial\\images\\2.png"));
		btnNewButton.setRolloverIcon(new ImageIcon("D:\\workspace_java\\javaTutorial\\images\\3.png"));
		btnNewButton.setIcon(new ImageIcon("D:\\workspace_java\\javaTutorial\\images\\1.png"));
		getContentPane().add(btnNewButton);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JLabelEx();

	}

}
