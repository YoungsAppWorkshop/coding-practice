package board;

import java.sql.Connection;
// import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private PreparedStatement pstmt = null;
	private String sql = "";
	private ResultSet rs = null;
	private Connection con = null;

	// DB연결 메소드
	private Connection getConnection() throws Exception {
		// String dbUrl = "jdbc:mysql://localhost:3306/jspdb"; // DB주소
		// String dbUser = "jspid"; // DB유저명
		// String dbPass = "jsppass"; // DB비밀번호
		// 1단계 드라이버 로더
		// Class.forName("com.mysql.jdbc.Driver");
		// 2단계 디비 연결
		// con = DriverManager.getConnection(dbUrl, dbUser, dbPass); // 연결정보
		
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

	// 게시판 글 추가 메소드 : 일반글
	public void insertBoard(BoardBean jbean) {
		int num;
		try {
			// 1,2단계 드라이버 로드/디비 연결
			con = getConnection();
			// 글 번호(num) 구하기
			sql = "SELECT MAX(num) AS maxNum FROM board;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			num = rs.getInt("maxNum") + 1;
			// 3단계 SQL 준비 객체 생성
			sql = "INSERT INTO board(num, name, pass, subject, content, readcount, ip, date, re_ref, re_lev, re_seq, file) VALUES (?,?,?,?,?,?,?,now(),?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, jbean.getName());
			pstmt.setString(3, jbean.getPass());
			pstmt.setString(4, jbean.getSubject());
			pstmt.setString(5, jbean.getContent());
			pstmt.setInt(6, 0);
			pstmt.setString(7, jbean.getIp());
			pstmt.setInt(8, num); // re_ref = 기준 num 같게
			pstmt.setInt(9, 0); // re_lev = 0
			pstmt.setInt(10, 0); // re_seq = 0
			pstmt.setString(11, jbean.getFile());
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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {

				}
			}
		}
	} // .insertBoard()

	// 게시판 내의 총 글 수 구하기 메소드
	public int getBoardCount() {
		int count = 0;
		try {
			// 1,2단계 드라이버 로드/디비 연결
			con = getConnection();
			// 게시판의 글 개수 구하기
			sql = "SELECT COUNT(*) AS rowCount FROM board;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("rowCount");
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
		return count;
	} // .getBoardCount()

	public List<BoardBean> getBoardList(int startRow, int pageSize) {
		// 배열 생성 // 컬렉션 // 크기 10개 생성 + 추가 10개 + 추가 10개 + ...
		// 배열 한 칸 데이터 저장 add(값)
		// 배열 한 칸 데이터 가져오기 get(0)
		// 배열 크기 size()
		List<BoardBean> boardList = new ArrayList<BoardBean>();
		try {
			// 1,2단계 드라이버 로드/디비 연결
			con = getConnection();
			// 3단계 SQL 준비 객체 생성
			sql = "SELECT * FROM board ORDER BY re_ref DESC, re_seq ASC LIMIT ?,?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow - 1);
			pstmt.setInt(2, pageSize);
			// 4단계 실행 및 데이터 rs에 저장
			rs = pstmt.executeQuery();
			// 5단계 while rs 첫행 이동 데이터 있는 경우
			while (rs.next()) {
				// 자바빈 객체 생성 boardBean mb
				BoardBean bb = new BoardBean();
				// rs열 rs.getString("id")
				// -> 자바빈 멤버변수 setId()
				// ....
				bb.setNum(rs.getInt("num"));
				bb.setName(rs.getString("name"));
				bb.setSubject(rs.getString("subject"));
				bb.setDate(rs.getDate("date"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setRe_ref(rs.getInt("re_ref"));
				bb.setRe_lev(rs.getInt("re_lev"));
				bb.setRe_seq(rs.getInt("re_seq"));
				// bb => 배열 한 칸 저장 boardList.add()
				boardList.add(bb);
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
		return boardList;
	} // .getBoards() 종료

	// 컨텐츠 정보 가져오기 메소드
	public BoardBean getBoard(int num) {
		BoardBean board = null;
		try {
			// 1,2단계 드라이버 로드/디비 연결
			con = getConnection();
			// 3단계 SQL
			sql = "SELECT * FROM board WHERE num = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			// 4단계 실행 => ResultSet 저장
			rs = pstmt.executeQuery();
			if (rs.next()) {
				board = new BoardBean();
				board.setNum(rs.getInt("num"));
				board.setName(rs.getString("name"));
				board.setPass(rs.getString("pass"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setReadcount(rs.getInt("readcount"));
				board.setIp(rs.getString("ip"));
				board.setDate(rs.getDate("date"));
				board.setRe_ref(rs.getInt("re_ref"));
				board.setRe_lev(rs.getInt("re_lev"));
				board.setRe_seq(rs.getInt("re_seq"));
				board.setFile(rs.getString("file"));
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
		return board;
	} // 메소드 .getBoard() 종료

	// 글 조회수 추가 메소드
	public void updateReadCount(int num) {

		try {
			// 1,2단계 드라이버 로드/디비 연결
			con = getConnection();
			// 3단계 SQL 준비 객체 생성
			// DB에서 readCount 가져와서 1 증가시키기
			sql = "UPDATE board SET readcount = readcount + 1 WHERE num = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
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
	} // .updateReadCount()

	// 게시판 글 추가 메소드 : 일반글
	public int updateBoard(BoardBean jbean) {
		int check = -1; // num 없음
		try {
			// 1,2단계 드라이버 로드/디비 연결
			con = getConnection();
			// 비밀번호 가져오기
			sql = "SELECT pass FROM board WHERE num=?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, jbean.getNum());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (jbean.getPass().equals(rs.getString("pass"))) {
					check = 1; // 비밀번호 일치
					// 3단계 SQL 준비 객체 생성
					sql = "UPDATE board SET name=?, subject=?, content=? WHERE num = ?;";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, jbean.getName());
					pstmt.setString(2, jbean.getSubject());
					pstmt.setString(3, jbean.getContent());
					pstmt.setInt(4, jbean.getNum());
					// 4단계 실행
					pstmt.executeUpdate();
				} else {
					check = 0; // 비밀번호 불일치
				}
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
		return check;
	} // .updateBoard()

	// 게시판 글 추가 메소드 : 일반글
	public int deleteBoard(int num, String pass) {
		int check = -1; // num 없음
		try {
			// 1,2단계 드라이버 로드/디비 연결
			con = getConnection();
			// 비밀번호 가져오기
			sql = "SELECT pass FROM board WHERE num = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (pass.equals(rs.getString("pass"))) {
					check = 1; // 비밀번호 일치
					// 3단계 SQL 준비 객체 생성
					sql = "DELETE FROM board WHERE num = ? AND PASS = ?;";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					pstmt.setString(2, pass);
					// 4단계 실행
					pstmt.executeUpdate();
				} else {
					check = 0; // 비밀번호 불일치
				}
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
		return check;
	} // .deleteBoard()

	// 게시판 글 추가 메소드 : 일반글
	public void reInsertBoard(BoardBean jbean) {
		int reNum; // 댓글의 글 번호
		try {
			// 1,2단계 드라이버 로드/디비 연결
			con = getConnection();
			// 이전 댓글의 순서 아래로 설정 (re_seq + 1, re_lev + 1)
			sql = "UPDATE board SET re_seq = re_seq + 1 WHERE re_ref = ? AND re_seq > ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, jbean.getRe_ref());
			pstmt.setInt(2, jbean.getRe_seq());
			pstmt.executeUpdate();
			// 댓글의 글 번호(num) 구하기
			sql = "SELECT MAX(num) AS maxNum FROM board;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			reNum = rs.getInt("maxNum") + 1;
			// 댓글 DB에 삽입
			sql = "INSERT INTO board(num, name, pass, subject, content, readcount, ip, date, re_ref, re_lev, re_seq, file) VALUES (?,?,?,?,?,?,?,now(),?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reNum); // 글번호
			pstmt.setString(2, jbean.getName()); // 글쓴이
			pstmt.setString(3, jbean.getPass()); // 비밀번호
			pstmt.setString(4, jbean.getSubject()); // 제목
			pstmt.setString(5, jbean.getContent()); // 내용
			pstmt.setInt(6, 0); // 조회수 readcount
			pstmt.setString(7, jbean.getIp()); // IP
			pstmt.setInt(8, jbean.getRe_ref()); // re_ref = 기준 num 같게
			pstmt.setInt(9, jbean.getRe_lev() + 1); // re_lev = 0
			pstmt.setInt(10, jbean.getRe_seq() + 1); // re_seq = 0
			pstmt.setString(11, jbean.getFile()); // 파일첨부
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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {

				}
			}
		}
	} // .reInsertBoard()

} // class : BoardDAO
