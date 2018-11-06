package javaLesson;

import java.sql.*;

public class JDBC_Ex3 {

	public static void main(String[] args) {
		Connection conn;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.2.19:3306/javadb", "root", "1234");
			System.out.println("DB 연결 완료");

			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM student;");
			printData(rs, "name", "id", "dept");
			
//			int a = stmt.executeUpdate("INSERT INTO student(id, name, dept) VALUES ('0720130', '이순신', '화학과');");
//			System.out.println(a+"행의 데이터 삽입");
			int a = stmt.executeUpdate("UPDATE student SET id='0000001' WHERE name='홍길동';");
			System.out.println(a+"개의 행의 데이터 수정");
			
			rs = stmt.executeQuery("SELECT * FROM student;");
			printData(rs, "name", "id", "dept");
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
			
		} catch (SQLException e) {
			System.out.println("SQL 실행 에러");
		} // close try-catch

	} // close main

	private static void printData(ResultSet rs, String col1, String col2, String col3) throws SQLException {
		while (rs.next()) {
			if (!col1.equals("")) {
				System.out.print(rs.getString("name"));
			} // close if
			
			if (!col2.equals("")) {
				System.out.print("\t|\t" + rs.getString("id"));
			} // close if
			
			if (!col3.equals("")) {
				System.out.println("\t|\t" + rs.getString("dept"));
			} else {
				System.out.println();
			} // close if-else
			
		} // close while loop

	} // close method

} // close class
