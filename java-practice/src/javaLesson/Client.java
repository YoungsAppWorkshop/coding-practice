package javaLesson;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 5432);
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			System.out.println(ois.readObject());
			ois.close();
			is.close();
			socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} // close try-catch

	} // close main

} // close class
