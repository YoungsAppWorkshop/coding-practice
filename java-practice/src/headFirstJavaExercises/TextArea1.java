package headFirstJavaExercises;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TextArea1 implements ActionListener {
	
	JTextArea text;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		text.append("button clicked \n");

	}

	public static void main(String[] args) {
		TextArea1 gui = new TextArea1();
		gui.go();

	}
	
	public void go() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("Just Click It");
		button.addActionListener(this);
		text = new JTextArea(10, 20);
		text.setLineWrap(true);
		
		JScrollPane scroller = new JScrollPane(text);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scroller);
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		
		frame.setSize(350, 300);
		frame.setVisible(true);
	}

}
