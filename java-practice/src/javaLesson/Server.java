package javaLesson;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5432);
		} catch (Exception e) {
			e.printStackTrace();
		} // close try-catch
		
		try {
			while (true) {
				Socket socket = serverSocket.accept();
				
				OutputStream os = socket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject("Hello World");
				oos.close();
				socket.close();
			} // close while
			
		} catch (Exception e) {
			e.printStackTrace();
		} // close try-catch

	} // close main

} // close class
