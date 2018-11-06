package javaLesson;

import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class NetworkEx17_4 {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.google.co.kr/ig/images/weather/sunny.gif");
			URLConnection con = url.openConnection();
			con.connect();
			System.out.println("문서의 타입 : " + con.getContentType());
			System.out.println("수정일자 : " + new Date(con.getLastModified()));
			int len = con.getContentLength();
			System.out.println("문서의 길이 : " + len + " 바이트");

		} catch (Exception e) {
			e.printStackTrace();

		} // close try-catch

	} // close main

} // close class