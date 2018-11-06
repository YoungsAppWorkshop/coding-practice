package javaLesson;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JCheckBoxEx extends JFrame {
	JCheckBox[] fruits = new JCheckBox[3];
	String[] names = { "사과", "배", "체리" };
	JLabel sumLabel;
	int sum = 0;

	public JCheckBoxEx() {
		setSize(new Dimension(400, 400));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		for (int i = 0; i < fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);
			fruits[i].addItemListener(new CheckBoxListener());
			getContentPane().add(fruits[i]);
		}
		sumLabel = new JLabel();
		sumLabel.setText("합계");
		getContentPane().add(sumLabel);
		setVisible(true);
	}

	class CheckBoxListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			int selected = 1;
			if (e.getStateChange() == ItemEvent.SELECTED) {
				selected = 1;
			} else {
				selected = -1;
			}
			if (e.getItem() == fruits[0]) {
				sum += selected * 100;
			} else if (e.getItem() == fruits[1]) {
				sum += selected * 500;
			} else {
				sum += selected * 20000;
			}
			sumLabel.setText("현재 " + sum + "원입니다.");
		}
	}

	public static void main(String[] args) {
		new JCheckBoxEx();

	}

}
