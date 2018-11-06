package javaLesson;

import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ImageDB extends JFrame implements ActionListener {
	private JMenuItem save, view, exit, setting;
	JFileChooser fc;
	private Statement stmt = null;
	private Connection conn = null;
	private JMenuBar menuBar;
	private JMenu menu;
	private int numberOfRecord;
	private JLabel imageLabel;
	private JLabel textLabel;
	private JButton nextButton;
	private ResultSet viewRS = null;
	private ImageIcon img = null;
	private JLabel status;

	String addr = "localhost";

	public ImageDB() {

		setTitle("이미지 데이터 베이스"); // 프레임 타이틀
		// 프레임 종료 버튼(X)을 클릭하면 프로그램 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// BorderLayout 배치관리자의 사용
		getContentPane().setLayout(new BorderLayout());

		fc = new JFileChooser(); // JFileChooser 객체 생성
		menuBar = new JMenuBar(); // JMenuBar 컴포넌트를 생성

		menu = new JMenu("메뉴");
		menuBar.add(menu); // 메뉴를 메뉴바에 붙인다

		// 서브 메뉴
		save = new JMenuItem("사진 저장 하기");
		save.addActionListener(this); // save 메뉴에 대한 이벤트 리스너를 등록
		menu.add(save); // 메뉴 아이템을 메뉴에 붙인다
		view = new JMenuItem("모든 사진 보기");
		menu.add(view); // 메뉴 아이템을 메뉴에 붙인다
		view.addActionListener(this); // view 메뉴에 대한 이벤트 리스너를 등록

		menu = new JMenu("종료");
		exit = new JMenuItem("나가기");
		exit.addActionListener(this); // exit 메뉴에 대한 이벤트 리스너를 등록
		menu.add(exit); // 메뉴 아이템을 메뉴에 붙인다
		menuBar.add(menu); // 메뉴를 메뉴바에 붙인다

		menu = new JMenu("설정");
		setting = new JMenuItem("Server 셋팅");
		setting.addActionListener(this);
		menu.add(setting);
		menuBar.add(menu);

		setJMenuBar(menuBar); // 메뉴바를 프레임에 붙인다
		imageLabel = new JLabel(); // 이미지를 표시할 레이블 컴포넌트
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER); // 중앙정렬
		textLabel = new JLabel(); // 파일 이름을 표시할 레이블 컴포넌트
		textLabel.setHorizontalAlignment(SwingConstants.CENTER); // 중앙정렬
		nextButton = new JButton("다음 사진"); // 다음 사진 보기를 위한 버튼
		nextButton.addActionListener(this); // 버튼에 대한 이벤트 리스너를 등록

		// 큰 사이즈의 이미지를 위해 ScrollPane에서 표시
		JScrollPane spane = new JScrollPane(imageLabel);
		getContentPane().add(textLabel, BorderLayout.NORTH);
		getContentPane().add(spane, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		panel.setSize(50, 50); // 버튼 크기
		panel.add(nextButton);
		getContentPane().add(panel, BorderLayout.SOUTH);

		status = new JLabel("");
		panel.add(status);

		setSize(400, 400); // 폭 400 픽셀, 높이 400 픽셀의 크기로 프레임 크기 설정
		setVisible(true); // 프레임이 화면에 나타나도록 설정

		try {
			Class.forName("com.mysql.jdbc.Driver");
			status.setText("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.getMessage();
		}
		serverSetting();
	} // close constructor

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) { // 종료 - 나가기 버튼 클릭 시
			System.exit(0);

		} else if (e.getSource() == save) { // 메뉴 - 사진 저장하기 버튼 클릭 시

			int returnVal = fc.showOpenDialog(this); // 파일 열기 다이얼로그 출력
			if (returnVal == JFileChooser.APPROVE_OPTION) { // 열기 버튼을 누른 경우
				insertImage(fc.getSelectedFile()); // 선택한 파일을 저장
			} // close inner if

		} else if (e.getSource() == view) { // 메뉴 - 모든 사진 보기 버튼 클릭 시
			showPhotos();

		} else if (e.getSource() == setting) { // 설정 - Server 셋팅 버튼 클릭 시
			addr = JOptionPane.showInputDialog("호스트 주소를 입력하세요", "192.168.219.104");
			status.setText(addr);
			if (addr.equals("") || addr == null) {
				addr = "localhost";
				status.setText(addr + "!!");
			} // close inner if
			serverSetting();

		} else if (e.getSource() == nextButton) { // 다음 사진 버튼 클릭 시
			try {
				if (viewRS == null || !viewRS.next()) { // 볼 사진이 없는 경우
					imageLabel.setIcon(null);
					imageLabel.setText("사진 없음");
					textLabel.setText(null);
				} else {
					Blob b = viewRS.getBlob("FILE"); // DB에서 바이너리 데이터 얻어옴
					// 바이너리 데이터를 이미지 포맷으로 변환
					img = new ImageIcon(b.getBytes(1, (int) b.length()));
					imageLabel.setIcon(img);
					imageLabel.setText(null);
					// 파일 이름을 textLabel에 출력
					textLabel.setText(viewRS.getString("FILENAME"));
				}
			} catch (SQLException e1) {
				e1.getMessage();
			}
		}

	}

	private void showPhotos() {
		try {
			// DB에서 모든 사진을 얻어옴
			viewRS = stmt.executeQuery("select * from images");
			if (viewRS.next()) { // 첫번째 사진 표시
				Blob b = viewRS.getBlob("FILE"); // DB에서 바이너리 데이터 얻어옴
				// 바이너리 데이터를 이미지 포맷으로 변환
				img = new ImageIcon(b.getBytes(1, (int) b.length()));
				imageLabel.setIcon(img);
				imageLabel.setText(null);
				// 파일 이름을 textLabel에 출력
				textLabel.setText(viewRS.getString("FILENAME"));
			} else { // DB에 사진이 없는 경우
				imageLabel.setIcon(null);
				imageLabel.setText("사진 없음");
				textLabel.setText(null);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	private void serverSetting() {
		try {
			// JDBC 연결
			conn = DriverManager.getConnection("jdbc:mysql://" + addr + ":3306/javadb", "root", "1234");

			status.setText("jdbc:mysql://" + addr + ":3306/javadb");
			stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성

			// 레코드 개수를 얻어오는 쿼리
			ResultSet srs = stmt.executeQuery("select count(*) from images");
			srs.next();
			numberOfRecord = srs.getInt(1);

		} catch (SQLException e) {
			e.getMessage();
		}
	}

	private void insertImage(File file) {
		try {
			FileInputStream fin = new FileInputStream(file); // 파입 입력 스트림 생성
			PreparedStatement pre = conn.prepareStatement("insert into images (ID, FILENAME, FILE) VALUES (?, ?, ?)");
			pre.setInt(1, ++numberOfRecord);
			pre.setString(2, file.getName());
			pre.setBinaryStream(3, fin, (int) file.length());
			pre.executeUpdate(); // DB에 사진 저장
			pre.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ImageDB();
	}
}
