package javaLesson;

import java.net.URL;

public class NetworkEx17_3 {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.google.co.kr/index.html");
			System.out.println(url.getProtocol());
			System.out.println(url.getDefaultPort());
			System.out.println(url.getHost());
			System.out.println(url.getFile());
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} // close try-catch		

	} // close main

} // close class
