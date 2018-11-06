package javaLesson;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimpleClientEx17_7 extends Thread implements ActionListener {

	JFrame frame;
	JTextArea textarea;
	JTextField textfieldA, textfieldB;
	JDialog dialog;
	JLabel label;

	Socket socket;
	DataOutputStream dos;
	DataInputStream dis;
	boolean isRunning;
	String host;

	public SimpleClientEx17_7() {
		launchFrame();
	} // close constructor

	private void launchFrame() {
		frame = new JFrame("일대일 채팅실습 : 클라이언트");
		textarea = new JTextArea();
		textfieldA = new JTextField();
		frame.setBackground(Color.lightGray);
		textarea.setEditable(false);
		frame.add(textarea, BorderLayout.CENTER);
		frame.add(textfieldA, BorderLayout.SOUTH);
		textfieldA.addActionListener(this);

		frame.setSize(500, 300);
		frame.setVisible(true);
		textfieldA.requestFocus();

		dialog = new JDialog(frame, "서버 IP", true);
		label = new JLabel("접속할 서버 IP를 입력하세요.");
		textfieldB = new JTextField(15);

		dialog.add(label, BorderLayout.NORTH);
		dialog.add(textfieldB, BorderLayout.CENTER);
		textfieldB.addActionListener(this);
		dialog.pack();
		dialog.setVisible(true);
		service();
		textfieldB.requestFocus();
	} // close method

	private void service() {
		try {
			socket = new Socket(host, 5432);
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			textarea.append("접속 완료...\n");
			this.start();
			isRunning = true;
		} catch (IOException e) {
			e.printStackTrace();
		} // close try-catch

	} // close method

	@Override
	public void actionPerformed(ActionEvent event) {
		if (textfieldA == event.getSource()) {
			try {
				String msg = textfieldA.getText();
				textarea.append(msg + "\n");

				if (msg.equals("exit")) {
					textarea.append("bye");
					isRunning = false;
					dos.close();
					socket.close();
					System.exit(0);
				} else {
					dos.writeUTF("클라이언트 : " + msg);
					textfieldA.setText(" ");
				} // close if-else

			} catch (IOException e) {
				textarea.append(e.toString() + "\n");
			} // close try-catch

		} else {
			host = textfieldB.getText().trim();
			if (host.equals("")) {
				host = "localhost";
			} // close if

			dialog.dispose();
		} // close if-else

	} // close method

	@Override
	public void run() {
		System.out.println("Thread started...");
		try {
			while (isRunning) {
				textarea.append(dis.readUTF() + "\n");
			} // close while
			
			dis.close();
			socket.close();

		} catch (EOFException e) {
			textarea.append("서버로부터 연결이 끊어졌습니다.\n");

		} catch (IOException e1) {
			e1.printStackTrace();
		} // close try-catch

	} // close method

	public static void main(String[] args) {
		new SimpleClientEx17_7();

	} // close main

} // close class
