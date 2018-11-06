package headFirstJavaExercises;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleAnimation {
	JFrame frame;
	int x = 250;
	int y = 250;

	public static void main(String[] args) {
		SimpleAnimation gui = new SimpleAnimation();
		gui.start();

	}

	public void start() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DrawPanel drawPanel = new DrawPanel();
		
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		for (int i = 0; i < 200; i++) {
			x--;
			y--;
			frame.repaint();
			
			try {
				Thread.sleep(40);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		
	}

	class DrawPanel extends JPanel {

		public void paintComponent(Graphics g) {
			g.fillRect(0, 0, this.getWidth(), this.getHeight());

			g.setColor(Color.ORANGE);
			g.fillOval(x, y, 100, 100);
		}
	}
}
