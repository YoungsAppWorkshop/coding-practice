package javaLesson;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class NetworkEx17_5 {

	public static void main(String[] args) {
		try {
			String original = "[Java Solution : 홍길동]";
			String encodeStr = URLEncoder.encode(original ,"EUC-KR");
			String decodeStr = URLDecoder.decode(encodeStr ,"EUC-KR");
			
			System.out.println(original);
			System.out.println(encodeStr);
			System.out.println(decodeStr);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} // close try-catch		

	} // close main

} // close class