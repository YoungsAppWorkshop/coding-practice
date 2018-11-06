package headFirstJavaExercises;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGUIPractice2 extends JFrame implements ActionListener {
	JButton button;
	
	SimpleGUIPractice2(){
		setTitle("Simple GUI Practice 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button = new JButton("click me");
		button.addActionListener(this);
		
		Container c = getContentPane();
		c.add(button);	
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
		button.setText("I've been clicked");
	}
	
	public static void main(String[] args) {
		new SimpleGUIPractice2();	

	}

}
