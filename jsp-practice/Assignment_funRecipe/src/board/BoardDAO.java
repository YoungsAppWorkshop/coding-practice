package board;

import java.sql.Connection;
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

		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jspdb");
		con = ds.getConnection();

		return con;
	}

	// 게시판 글쓰기 메소드
	public boolean insertBoard(BoardBean jbean) {
		boolean isSuccess = false;
		int num;
		try {
			// DB 연결
			con = getConnection();

			// 글 번호(num) 구하기
			sql = "SELECT MAX(num) AS maxNum FROM board;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			num = rs.getInt("maxNum") + 1;

			// DB에 글 입력
			sql = "INSERT INTO board(num, name, subject, content, readcount, ip, date, re_ref, re_lev, re_seq, id) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, jbean.getName());
			pstmt.setString(3, jbean.getSubject());
			pstmt.setString(4, jbean.getContent());
			pstmt.setInt(5, 0);
			pstmt.setString(6, jbean.getIp());
			pstmt.setTimestamp(7, jbean.getDate());
			pstmt.setInt(8, num); // re_ref = 기준 num 같게
			pstmt.setInt(9, 0); // re_lev = 0
			pstmt.setInt(10, 0); // re_seq = 0			
			pstmt.setString(11, jbean.getId());
			pstmt.executeUpdate();

			isSuccess = true; // 글쓰기 완료
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
		return isSuccess;
	} // .insertBoard()

	// 게시판 내의 총 글 수 구하기 메소드
	public int getBoardCount() {
		int boardCount = 0;
		try {
			con = getConnection();

			sql = "SELECT COUNT(*) AS rowCount FROM board;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				boardCount = rs.getInt("rowCount");
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
		return boardCount;
	} // .getBoardCount()

	// 검색된 글 수 구하기 메소드
	public int getBoardCount(String keyword) {
		int count = 0;
		try {

			con = getConnection();

			sql = "SELECT COUNT(*) AS rowCount FROM board WHERE subject LIKE ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("rowCount");
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
		return count;
	} // .getBoardCount(String)

	// 게시판 글 목록 가져오기 메소드
	public List<BoardBean> getBoardList(int startRow, int pageSize) {
		List<BoardBean> boardList = new ArrayList<BoardBean>();

		try {

			con = getConnection();

			sql = "SELECT * FROM board ORDER BY re_ref DESC, re_seq ASC LIMIT ?,?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow - 1);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardBean bb = new BoardBean();

				bb.setNum(rs.getInt("num"));
				bb.setName(rs.getString("name"));
				bb.setSubject(rs.getString("subject"));
				bb.setContent(rs.getString("content"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setIp(rs.getString("ip"));
				bb.setDate(rs.getTimestamp("date"));
				bb.setRe_ref(rs.getInt("re_ref"));
				bb.setRe_lev(rs.getInt("re_lev"));
				bb.setRe_seq(rs.getInt("re_seq"));
				bb.setId(rs.getString("id"));

				boardList.add(bb);
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
		return boardList;
	} // .getBoardList() 종료

	// 검색한 글 가져오기
	public List<BoardBean> getBoardList(String keyword, int startRow, int pageSize) {

		List<BoardBean> boardList = new ArrayList<BoardBean>();
		try {
			con = getConnection();

			// keyword로 DB 검색하여 글 정보 가져오기
			sql = "SELECT * FROM board WHERE subject LIKE ? ORDER BY re_ref DESC, re_seq ASC LIMIT ?,?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow - 1);
			pstmt.setInt(3, pageSize);

			rs = pstmt.executeQuery();

			// 검색된 글 정보를 List에 담기
			while (rs.next()) {
				BoardBean bb = new BoardBean();

				bb.setNum(rs.getInt("num"));
				bb.setName(rs.getString("name"));
				bb.setSubject(rs.getString("subject"));
				bb.setContent(rs.getString("content"));
				bb.setReadcount(rs.getInt("readcount"));
				bb.setIp(rs.getString("ip"));
				bb.setDate(rs.getTimestamp("date"));
				bb.setRe_ref(rs.getInt("re_ref"));
				bb.setRe_lev(rs.getInt("re_lev"));
				bb.setRe_seq(rs.getInt("re_seq"));
				bb.setId(rs.getString("id"));

				boardList.add(bb);
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
		return boardList;
	} // .getBoardList(String, int, int) 종료

	// 글 조회수 1증가 메소드
	public void updateReadCount(int num) {
		try {
			con = getConnection();

			sql = "UPDATE board SET readcount = readcount + 1 WHERE num = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			pstmt.executeUpdate();

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
		}
	} // .updateReadCount()

	// 컨텐츠 정보 가져오기 메소드
	public BoardBean getBoard(int num) {
		BoardBean board = null;
		try {
			con = getConnection();

			sql = "SELECT * FROM board WHERE num = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				board = new BoardBean();
				board.setNum(rs.getInt("num"));
				board.setName(rs.getString("name"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setReadcount(rs.getInt("readcount"));
				board.setIp(rs.getString("ip"));
				board.setDate(rs.getTimestamp("date"));
				board.setRe_ref(rs.getInt("re_ref"));
				board.setRe_lev(rs.getInt("re_lev"));
				board.setRe_seq(rs.getInt("re_seq"));
				board.setId(rs.getString("id"));
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

	// 게시판 글 수정 메소드
	public boolean updateBoard(BoardBean jbean) {
		boolean isSuccess = false;
		try {

			con = getConnection();

			sql = "UPDATE board SET name=?, subject=?, content=? WHERE num = ? AND id = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, jbean.getName());
			pstmt.setString(2, jbean.getSubject());
			pstmt.setString(3, jbean.getContent());
			pstmt.setInt(4, jbean.getNum());
			pstmt.setString(5, jbean.getId());

			pstmt.executeUpdate();
			isSuccess = true; // 글 수정 완료

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
		return isSuccess;
	} // .updateBoard()

	// 게시판 글 삭제 메소드
	public boolean deleteBoard(String id, int num) {
		boolean isSuccess = false;
		try {
			con = getConnection();

			sql = "DELETE FROM board WHERE id = ? AND num = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();

			isSuccess = true; // 글 삭제 완료

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
		return isSuccess;
	} // .deleteBoard()
	
	// 답글쓰기 메소드
	public boolean reInsertBoard(BoardBean jbean) {
		boolean isSuccess = false;
		int reNum; // 답글의 글 번호
		try {

			con = getConnection();
			
			// 이전 답글의 순서 아래로 설정 (re_seq + 1, re_lev + 1)
			sql = "UPDATE board SET re_seq = re_seq + 1 WHERE re_ref = ? AND re_seq > ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, jbean.getRe_ref());
			pstmt.setInt(2, jbean.getRe_seq());
			pstmt.executeUpdate();
			
			// 답글의 글 번호 구하기
			sql = "SELECT MAX(num) AS maxNum FROM board;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			reNum = rs.getInt("maxNum") + 1;
			
			// DB에 삽입
			sql = "INSERT INTO board(num, name, subject, content, readcount, ip, date, re_ref, re_lev, re_seq, id) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reNum); 
			pstmt.setString(2, jbean.getName()); 
			pstmt.setString(3, jbean.getSubject()); 
			pstmt.setString(4, jbean.getContent()); 
			pstmt.setInt(5, 0); 
			pstmt.setString(6, jbean.getIp()); 
			pstmt.setTimestamp(7, jbean.getDate());
			pstmt.setInt(8, jbean.getRe_ref()); 
			pstmt.setInt(9, jbean.getRe_lev() + 1); 
			pstmt.setInt(10, jbean.getRe_seq() + 1); 
			pstmt.setString(11, jbean.getId());

			pstmt.executeUpdate();
			
			isSuccess = true;
			
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
		} // close try-catch-finally
		
		return isSuccess;
	} // .reInsertBoard()


} // class : BoardDAO
