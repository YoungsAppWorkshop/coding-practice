package javaLesson;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PieChart extends JFrame {
	Container contentPane;
	JPanel textPanel;
	MyDrawPanel drawPanel;

	String[] names = { "Apple", "Cherry", "Strawberry", "Prune" };
	int[] count = { 0, 0, 0, 0 };
	float[] ratio = { 0, 0, 0, 0 };
	JLabel[] labels = new JLabel[4];
	JTextField[] textfields = new JTextField[4];
	Color[] colors = { Color.RED, Color.ORANGE, Color.MAGENTA, Color.BLUE };
	int sum;

	PieChart() {
		setTitle("Pie Chart Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		
		textPanel = new JPanel();
		for (int i = 0; i < names.length; i++) {
			labels[i] = new JLabel(names[i]);
			textfields[i] = new JTextField(5);
			textfields[i].addKeyListener(new MyKeyListener());
			textPanel.add(labels[i]);
			textPanel.add(textfields[i]);
		}

		drawPanel = new MyDrawPanel();
		contentPane.add(textPanel, BorderLayout.NORTH);
		contentPane.add(drawPanel, BorderLayout.CENTER);

		setSize(500, 500);
		setVisible(true);
	}

	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_ENTER) {
				for (int i = 0; i < names.length; i++) {
					try {
						count[i] = Integer.parseInt(textfields[i].getText());
					} catch (Exception e2) {
						count[i] = 0;
					}
					
				}
				repaint();
			}
		}
	}

	class MyDrawPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			sum = count[0] + count[1] + count[2] + count[3];

			if (sum != 0) {
				int startAngle = 85;
				int arcAngle;
				for (int i = 0; i < count.length; i++) {
					ratio[i] = (float) count[i] / sum;
					arcAngle = Math.round(ratio[i] * 360);
					String str = names[i] + String.format(" : %.1f", ratio[i] * 100) + "%";
					g.setColor(colors[i]);
					g.drawString(str, (i * 125 + 10), 30);
					g.fillArc(150, 150, 200, 200, startAngle, -arcAngle);
					startAngle -= arcAngle;
				}
			}

		}
	}

	public static void main(String[] args) {
		new PieChart();

	}

}
