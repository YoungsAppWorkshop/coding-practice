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

	public class ImageDatabaseEx extends JFrame {

		JLabel imageLabel = new JLabel();

		public ImageDatabaseEx() {
			setTitle("이미지 데이터 베이스");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			setSize(new Dimension(500, 500));

			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);

			JMenu mnMenu = new JMenu("메뉴");
			menuBar.add(mnMenu);

			JMenuItem mntmOpen = new JMenuItem("사진 열기");
			mntmOpen.addActionListener(new OpenListener());
			mnMenu.add(mntmOpen);

			JMenuItem mntmSave = new JMenuItem("사진 저장하기");
			mntmSave.addActionListener(new SaveListener());
			mnMenu.add(mntmSave);
			
			JMenuItem mntmView = new JMenuItem("모든 사진 보기");
//			mntmView.addActionListener(new ViewListener());
			mnMenu.add(mntmView);

			JMenu mnExit = new JMenu("종료");			
			menuBar.add(mnExit);
			
			JMenuItem mntmExit = new JMenuItem("나가기");
			mntmExit.addActionListener(new ExitListener());
			mnExit.add(mntmExit);

			JMenu mnEdit = new JMenu("설정");
			menuBar.add(mnEdit);

			JMenuItem mntmSettingDB = new JMenuItem("Server 설정");
			mntmSettingDB.addActionListener(new SettingListener());
			mnEdit.add(mntmSettingDB);

			getContentPane().add(imageLabel, BorderLayout.CENTER);

			setVisible(true);
		} // close constructor MenuBarEx()

		public static void main(String[] args) {
			new ImageDatabaseEx();

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

		class SettingListener implements ActionListener {
			JColorChooser chooser = new JColorChooser();

			@Override
			public void actionPerformed(ActionEvent e) {
				Color selectedColor = chooser.showDialog(null, "Color", Color.BLUE);
			} // close method .actionPerformed()

		} // close inner class SettingListener{}

	} // close outer class MenuBarEx{}
