package net.member.db;

import java.sql.Connection;
// import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.ResultSet;

public class MemberDAO {
	private PreparedStatement pstmt = null;
	private String sql = "";
	private ResultSet rs = null;
	private Connection con = null;

	// DB연결 메소드
	private Connection getConnection() throws Exception {
		// String dbUrl = "jdbc:mysql://localhost:3306/jspdb"; // DB주소
		// String dbUser = "jspid"; // DB유저명
		// String dbPass = "jsppass"; // DB비밀번호
		// Connection connection = null;
		// // 1단계 드라이버 로더
		// Class.forName("com.mysql.jdbc.Driver");
		// // 2단계 디비 연결
		// connection = DriverManager.getConnection(dbUrl, dbUser, dbPass); //
		// 연결정보

		// 커넥션 풀(Connection Pool)
		// 데이터베이스와 연결된 Connection 객체를 미리 생성하여 풀(Pool) 속에
		// 저장해 두고 필요할 때마다 이 풀에 접근하여 Connection 객체를 사용하고,
		// 작업이 끝나면 다시 반환하는 것.
		// 자카르타 DBCP API 이용
		// http://commons.apache.org
		// collections, DBCP, pool 다운로드 binary/zip버전

		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jspdb");
		con = ds.getConnection();

		return con;
	}

	// 회원 추가 메소드
	public void insertMember(MemberBean jbean) {
		try {
			// 1,2단계 드라이버 로드/디비 연결
			con = getConnection();
			// 3단계 SQL 준비 객체 생성
			sql = "INSERT INTO member(id, passwd, name, reg_date, age, gender, email) VALUES (?,?,?,?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, jbean.getId());
			pstmt.setString(2, jbean.getPasswd());
			pstmt.setString(3, jbean.getName());
			pstmt.setTimestamp(4, jbean.getReg_date());
			pstmt.setInt(5, jbean.getAge());
			pstmt.setString(6, jbean.getGender());
			pstmt.setString(7, jbean.getEmail());
			// 4단계 실행
			pstmt.executeUpdate();
		} catch (Exception e) { // 처리담당자 Exception 예외처리 담당
			e.printStackTrace();
		} finally { // 마무리 작업
			// Connection PreparedStatement
			// ResultSet 객체 기억공간 정리
			// 기억공간 닫기 : 객체이름.close();
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException ex) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {

				}
			}
		}
	} // .insertMember()

	// 회원확인 메소드(아이디, 비밀번호 일치여부 출력)
	public int checkUser(String id, String passwd) {
		int isUser = -1; // 1 : id/passwd 일치, 0 : passwd 불일치, -1 : id 불일치
		try {
			// 1,2단계 드라이버 로드/디비 연결
			con = getConnection();
			// 3단계 SQL 객체 생성 조건 id가 "kim"인 회원 passwd 조회
			sql = "SELECT passwd FROM member WHERE id = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			// 4단계 실행 => ResultSet 저장
			rs = pstmt.executeQuery();
			// 5단계 첫번째 행에서 데이터 있는 경우
			if (rs.next()) {
				if (passwd.equals(rs.getString("passwd"))) {
					// 폼비밀번호 디비 비밀번호 비교 맞으면 로그인 인증 후 "main.jsp"로 이동
					isUser = 1;
				} else {
					// 폼비밀번호 디비 비밀번호 틀리면 비밀번호 틀림
					isUser = 0;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally { // 마무리 작업
			// Connection PreparedStatement
			// ResultSet 객체 기억공간 정리
			// 기억공간 닫기 : 객체이름.close();
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException ex) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {

				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {

				}
			}
		}
		return isUser;

	} // 메소드 .checkUser() 종료

	// 회원정보 가져오기 메소드
	public MemberBean getMember(String id) {
		MemberBean member = null;
		try {
			// 1,2단계 드라이버 로드/디비 연결
			con = getConnection();
			// 3단계 SQL 객체 생성 조건 id가 "kim"인 회원 passwd 조회
			sql = "SELECT * FROM member WHERE id = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			// 4단계 실행 => ResultSet 저장
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new MemberBean();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setReg_date(rs.getTimestamp("reg_date"));
				member.setAge(rs.getInt("age"));
				member.setGender(rs.getString("gender"));
				member.setEmail(rs.getString("email"));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException ex) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {

				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {

				}
			}
		}
		return member;
	} // 메소드 .getMember() 종료

	// 회원정보 수정 메소드
	public void updateMember(MemberBean memberInfo) {

		try {
			// 1,2단계 드라이버 로드/디비 연결
			con = getConnection();
			// 3단계 SQL 준비 객체 생성
			sql = "UPDATE member SET name=?, age=?, gender=?, email=? WHERE id=?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getName());
			pstmt.setInt(2, memberInfo.getAge());
			pstmt.setString(3, memberInfo.getGender());
			pstmt.setString(4, memberInfo.getEmail());
			pstmt.setString(5, memberInfo.getId());
			// 4단계 실행
			pstmt.executeUpdate();
		} catch (Exception e) { // 처리담당자 Exception 예외처리 담당
			e.printStackTrace();
		} finally { // 마무리 작업
			// Connection PreparedStatement
			// ResultSet 객체 기억공간 정리
			// 기억공간 닫기 : 객체이름.close();
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException ex) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {

				}
			}
		}
	} // .insertMember()

	// 회원정보 삭제 메소드
	public void deleteMember(MemberBean memberInfo) {

		try {
			// 1,2단계 드라이버 로드/디비 연결
			con = getConnection();
			// 3단계 SQL 준비 객체 생성
			sql = "DELETE FROM member WHERE id=? AND passwd=?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getId());
			pstmt.setString(2, memberInfo.getPasswd());
			// 4단계 실행
			pstmt.executeUpdate();
		} catch (Exception e) { // 처리담당자 Exception 예외처리 담당
			e.printStackTrace();
		} finally { // 마무리 작업
			// Connection PreparedStatement
			// ResultSet 객체 기억공간 정리
			// 기억공간 닫기 : 객체이름.close();
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException ex) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {

				}
			}
		}
	} // .deleteMember()

	// 회원정보 조회 메소드
	public List<MemberBean> getMembers() {
		// 배열 생성 // 컬렉션 // 크기 10개 생성 + 추가 10개 + 추가 10개 + ...
		// 배열 한 칸 데이터 저장 add(값)
		// 배열 한 칸 데이터 가져오기 get(0)
		// 배열 크기 size()
		List<MemberBean> memberList = new ArrayList<MemberBean>();
		try {
			// 1,2단계 드라이버 로드/디비 연결
			con = getConnection();
			// 3단계 SQL 준비 객체 생성
			sql = "SELECT * FROM member;";
			pstmt = con.prepareStatement(sql);
			// 4단계 실행 및 데이터 rs에 저장
			rs = pstmt.executeQuery();
			// 5단계 while rs 첫행 이동 데이터 있는 경우
			while (rs.next()) {
				// 자바빈 객체 생성 MemberBean mb
				MemberBean mb = new MemberBean();
				// rs열 rs.getString("id")
				// -> 자바빈 멤버변수 setId()
				// ....
				mb.setId(rs.getString("id"));
				mb.setPasswd(rs.getString("passwd"));
				mb.setName(rs.getString("name"));
				mb.setReg_date(rs.getTimestamp("reg_date"));
				mb.setAge(rs.getInt("age"));
				mb.setGender(rs.getString("gender"));
				mb.setEmail(rs.getString("email"));
				// mb => 배열 한 칸 저장 memberList.add()
				memberList.add(mb);

			}

		} catch (Exception e) { // 처리담당자 Exception 예외처리 담당
			e.printStackTrace();
		} finally { // 마무리 작업
			// Connection PreparedStatement
			// ResultSet 객체 기억공간 정리
			// 기억공간 닫기 : 객체이름.close();
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException ex) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {

				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {

				}
			}
		}
		return memberList;
	} // .getMembers() 종료

} // class MemberDAO 종료
