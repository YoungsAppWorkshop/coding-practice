package download;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DownloadDAO {
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

	// 자료실 자료 업로드 메소드 
	public boolean insertFile(DownloadBean jbean) {
		boolean isSuccess = false;
		int num;
		try {
			// DB 연결
			con = getConnection();
			
			// 자료 번호(num) 구하기
			sql = "SELECT MAX(num) AS maxNum FROM download;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			num = rs.getInt("maxNum") + 1;
			
			// DB에 자료 입력 
			sql = "INSERT INTO download(num, name, subject, content, readcount, ip, date, file, id) VALUES (?,?,?,?,?,?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, jbean.getName());
			pstmt.setString(3, jbean.getSubject());
			pstmt.setString(4, jbean.getContent());
			pstmt.setInt(5, jbean.getReadcount());
			pstmt.setString(6, jbean.getIp());
			pstmt.setTimestamp(7, jbean.getDate());
			pstmt.setString(8, jbean.getFile());
			pstmt.setString(9, jbean.getId());
			pstmt.executeUpdate();
			
			isSuccess = true; // 자료업로드 완료 
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
	} // .insertFile()

	// 자료실 내의 총 자료 수 구하기 메소드
	public int getFileCount() {
		int fileCount = 0;
		try {
			con = getConnection();

			sql = "SELECT COUNT(*) AS rowCount FROM download;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				fileCount = rs.getInt("rowCount");
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
		return fileCount;
	} // .getFileCount()
	
	// 검색된 자료 수 구하기 메소드
	public int getFileCount(String keyword) {
		int count = 0;
		try {

			con = getConnection();

			sql = "SELECT COUNT(*) AS rowCount FROM download WHERE subject LIKE ?;";
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
	} // .getFileCount(String)

	
	// 자료 목록 가져오기 메소드 
	public List<DownloadBean> getFileList(int startRow, int pageSize) {
		List<DownloadBean> fileList = new ArrayList<DownloadBean>();
		
		try {

			con = getConnection();

			sql = "SELECT * FROM download ORDER BY num DESC LIMIT ?,?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow - 1);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				DownloadBean db = new DownloadBean();

				db.setNum(rs.getInt("num"));
				db.setName(rs.getString("name"));
				db.setSubject(rs.getString("subject"));
				db.setContent(rs.getString("content"));
				db.setReadcount(rs.getInt("readcount"));
				db.setIp(rs.getString("ip"));
				db.setDate(rs.getTimestamp("date"));
				db.setFile(rs.getString("file"));
				db.setId(rs.getString("id"));
				
				fileList.add(db);
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
		return fileList;
	} // .getBoardList() 종료
	
	// 검색한 자료 가져오기
	public List<DownloadBean> getFileList(String keyword, int startRow, int pageSize) {

		List<DownloadBean> fileList = new ArrayList<DownloadBean>();
		try {
			con = getConnection();
			
			// keyword로 DB 검색하여 자료 정보 가져오기
			sql = "SELECT * FROM download WHERE subject LIKE ? ORDER BY num DESC LIMIT ?,?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow - 1);
			pstmt.setInt(3, pageSize);

			rs = pstmt.executeQuery();

			// 검색된 자료 정보를 List에 담기 
			while (rs.next()) {
				DownloadBean db = new DownloadBean();

				db.setNum(rs.getInt("num"));
				db.setName(rs.getString("name"));
				db.setSubject(rs.getString("subject"));
				db.setContent(rs.getString("content"));
				db.setReadcount(rs.getInt("readcount"));
				db.setIp(rs.getString("ip"));
				db.setDate(rs.getTimestamp("date"));
				db.setFile(rs.getString("file"));
				db.setId(rs.getString("id"));

				fileList.add(db);
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
		return fileList;
	} // .getFileList(String, int, int) 종료
	
	// 자료 조회수 1증가 메소드
	public void updateReadCount(int num) {
		try {
			con = getConnection();

			sql = "UPDATE download SET readcount = readcount + 1 WHERE num = ?;";
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
	public DownloadBean getFile(int num) {
		DownloadBean db = null;
		try {
			con = getConnection();

			sql = "SELECT * FROM download WHERE num = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				db = new DownloadBean();
				db.setNum(rs.getInt("num"));
				db.setName(rs.getString("name"));
				db.setSubject(rs.getString("subject"));
				db.setContent(rs.getString("content"));
				db.setReadcount(rs.getInt("readcount"));
				db.setIp(rs.getString("ip"));
				db.setDate(rs.getTimestamp("date"));
				db.setFile(rs.getString("file"));
				db.setId(rs.getString("id"));
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
		return db;
	} // 메소드 .getFile() 종료


	// 자료실 자료 수정 메소드
	public boolean updateFile(DownloadBean jbean) {
		boolean isSuccess = false;
		try {

			con = getConnection();

			sql = "UPDATE download SET name=?, subject=?, content=?, ip=?, file=? WHERE num = ? AND id = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, jbean.getName());
			pstmt.setString(2, jbean.getSubject());
			pstmt.setString(3, jbean.getContent());
			pstmt.setString(4, jbean.getIp());
			pstmt.setString(5, jbean.getFile());
			pstmt.setInt(6, jbean.getNum());
			pstmt.setString(7, jbean.getId());
			
			pstmt.executeUpdate();
			isSuccess = true; // 자료 수정 완료 

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
	} // .updateFile()

	// 자료실 자료 삭제 메소드
	public boolean deleteFile(String id, int num) {
		boolean isSuccess = false; 
		try {
			con = getConnection();
			
			sql = "DELETE FROM download WHERE id = ? AND num = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();

			isSuccess = true; // 자료 삭제 완료 
			
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
	} // .deleteFile()

} // class : BoardDAO
