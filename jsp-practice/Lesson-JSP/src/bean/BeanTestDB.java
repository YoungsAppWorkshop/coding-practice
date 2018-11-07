package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
// import java.sql.ResultSet;


public class BeanTestDB {

	public void insertMember(BeanTest3 jbean) {
		String dbUrl = "jdbc:mysql://localhost:3306/jspdb"; // DB주소
		String dbUser = "jspid"; // DB유저명
		String dbPass = "jsppass"; // DB비밀번호
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
//		ResultSet rs = null;
		try { // 예외가 발생할 것 같은 명령문
			// 1단계 드라이버 로더
			Class.forName("com.mysql.jdbc.Driver");
			// 2단계 디비 연결
			con = DriverManager.getConnection(dbUrl, dbUser, dbPass); // 연결정보
			// 3단계 SQL 준비 객체 생성
			sql = "INSERT INTO member(id, passwd, name, reg_date) VALUES (?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, jbean.getId());
			pstmt.setString(2, jbean.getPasswd());
			pstmt.setString(3, jbean.getName());
			pstmt.setTimestamp(4, jbean.getReg_date());
			// 4단계 실행
			pstmt.executeUpdate();
		} catch (Exception e) { // 처리담당자 Exception 예외처리 담당
			e.printStackTrace();
		} finally { //마무리 작업
			// Connection PreparedStatement
			// ResultSet 객체 기억공간 정리
			// 기억공간 닫기  : 객체이름.close();
			
		}

	} // .insertMember()

}
