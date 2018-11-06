package javaLesson;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuBarEx extends JFrame {

	JLabel imageLabel = new JLabel();

	public MenuBarEx() {
		setTitle("Menu Bar Practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(new Dimension(500, 500));

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new OpenListener());
		mnFile.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new SaveListener());
		mnFile.add(mntmSave);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ExitListener());
		mnFile.add(mntmExit);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenuItem mntmSettingcolor = new JMenuItem("SettingColor");
		mntmSettingcolor.addActionListener(new ColorListener());
		mnEdit.add(mntmSettingcolor);

		getContentPane().add(imageLabel, BorderLayout.CENTER);

		setVisible(true);
	} // close constructor MenuBarEx()

	public static void main(String[] args) {
		new MenuBarEx();

	} // close main()

	class OpenListener implements ActionListener {
		JFileChooser chooser = new JFileChooser();

		@Override
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
			chooser.setFileFilter(filter);

			int ret = chooser.showOpenDialog(null);

			if (ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);

			} else {
				String filePath = chooser.getSelectedFile().getPath();
				imageLabel.setIcon(new ImageIcon(filePath));
				pack();
			} // close if-else

		} // close method .actionPerformed()

	} // close inner class OpenListener{}

	class SaveListener implements ActionListener {
		JFileChooser chooser = new JFileChooser();

		@Override
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG", "jpg");
			chooser.setFileFilter(filter);

			int ret = chooser.showOpenDialog(null);

			if (ret == JFileChooser.APPROVE_OPTION) {
				String filePath = chooser.getSelectedFile().getPath();
				File saveFile = new File(filePath);

				BufferedImage newImage = new BufferedImage(imageLabel.getIcon().getIconWidth(),
						imageLabel.getIcon().getIconHeight(), BufferedImage.TYPE_INT_RGB);
				Graphics g = newImage.getGraphics();
				imageLabel.getIcon().paintIcon(null, g, 0, 0);
				g.dispose();

				try {
					ImageIO.write(newImage, "jpg", saveFile);
				} catch (IOException e2) {

				} // close try-catch

			} // close if

		} // close method .actionPerformed()

	} // close inner class SaveListener{}

	class ExitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		} // close method .actionPerformed()

	} // close inner class ExitListener{}

	class ColorListener implements ActionListener {
		JColorChooser chooser = new JColorChooser();

		@Override
		public void actionPerformed(ActionEvent e) {
			Color selectedColor = chooser.showDialog(null, "Color", Color.BLUE);
		} // close method .actionPerformed()

	} // close inner class ColorListener{}

} // close outer class MenuBarEx{}
