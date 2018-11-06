package headFirstJavaExercises;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGUIPractice1 extends JFrame{
	
	SimpleGUIPractice1(){
		setTitle("Simple GUI Practice 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container c = getContentPane();
		JButton button = new JButton("click me");
		
		c.add(button);	
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SimpleGUIPractice1();		

	}

}
