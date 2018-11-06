package javaLesson;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_Ex1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.2.19:3306/javadb", "root", "1234");
			System.out.println("DB 연결 완료");
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
			e.printStackTrace();
			
		} catch (Exception e) {
			System.out.println("DB 연결 오류");
			e.printStackTrace();
		}

	}

}
