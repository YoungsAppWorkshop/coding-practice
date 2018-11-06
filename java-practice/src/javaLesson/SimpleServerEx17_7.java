package javaLesson;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimpleServerEx17_7 extends Thread implements ActionListener {

	JFrame frame;
	JTextArea textarea;
	JTextField textfield;
	ServerSocket serverSocket;
	Socket socket;
	DataOutputStream dos;
	DataInputStream dis;
	boolean isRunning;

	public SimpleServerEx17_7() {
		launchFrame();
		service();
	} // close constructor

	private void launchFrame() {
		frame = new JFrame("일대일 채팅실습 : 서버");
		textarea = new JTextArea();
		textfield = new JTextField();
		frame.setBackground(Color.lightGray);
		textarea.setEditable(false);
		frame.add(textarea, BorderLayout.CENTER);
		frame.add(textfield, BorderLayout.SOUTH);
		textfield.addActionListener(this);

		frame.setSize(500, 300);
		frame.setVisible(true);
		textfield.requestFocus();

	} // close method

	private void service() {
		try {
			isRunning = true;
			textarea.append("서비스 하기 위해 준비중... \n");
			serverSocket = new ServerSocket(5432);

			textarea.append("클라이언트 접속 대기 중...");
			socket = serverSocket.accept();

			textarea.append("클라이언트가 접속하였습니다. : " + socket.getInetAddress() + "\n");
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			this.start();

			dos.writeUTF("채팅 서버에 접속하신 것을 환영합니다.");

		} catch (IOException e) {
			e.printStackTrace();

		} // close try-catch

	} // close method

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			String msg = textfield.getText();
			textarea.append(msg + "\n");

			if (msg.equals("exit")) {
				textarea.append("bye");
				isRunning = false;
				dos.close();
				socket.close();
				System.exit(0);
			} else {
				dos.writeUTF("서버 : " + msg);
				textfield.setText(" ");
			} // close if-else

		} catch (IOException e) {
			textarea.append(e.toString() + "\n");
		} // close try-catch

	} // close method

	@Override
	public void run() {
		try {
			while (isRunning) {
				textarea.append(dis.readUTF() + "\n");
			} // close while
			dis.close();
			serverSocket.close();
		} catch (EOFException e) {
			textarea.append("클라이언트로부터 연결이 끊어졌습니다.\n");
		} catch (IOException e1) {
			e1.printStackTrace();
		} // close try-catch
	} // close method

	public static void main(String[] args) {
		new SimpleServerEx17_7();

	} // close main

} // close class
