package javaLesson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkEx17_2 {

	public static void main(String[] args) {
		BufferedReader buffer = null;
		
		try {
			URL url = new URL("http://www.naver.com");
			InputStream in = url.openStream();
			InputStreamReader reader = new InputStreamReader(in);
			buffer = new BufferedReader(reader);
			
			String s = buffer.readLine();
			while (s != null) {
				System.out.println(s);
				s = buffer.readLine();
			} // close while			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				buffer.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		} // close try-catch-finally

	} // close main

} // close class
