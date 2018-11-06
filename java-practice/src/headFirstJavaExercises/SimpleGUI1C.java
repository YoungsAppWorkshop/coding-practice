package headFirstJavaExercises;


import javax.swing.JFrame;

public class SimpleGUI1C {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		//MyDrawPanel panel = new MyDrawPanel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new MyDrawPanel());
		
		frame.setSize(300, 300);
		
		frame.setVisible(true);

	}

}
