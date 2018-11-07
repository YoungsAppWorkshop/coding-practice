package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.ResultSet;

public class MemberDAO {
	private Connection con = null;
	private String sql = "";
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// DB연결 메소드
	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jspdb");
		con = ds.getConnection();

		return con;
	} // .getConnection() 종료

	// 아이디 사용가능 여부 체크 메소드
	public int checkId(String id) {
		final int USABLE = 0; // 사용가능한 아이디
		final int INVALID = 1; // 사용불가능한 아이디 : 대소문자 영문 또는 숫자만 사용 / 길이 4~10자 이내 /
								// 첫글자는 대소문자 영문자만 허용
		final int DUPLICATE = 2; // 사용불가능한 아이디 : 중복된 아이디
		int status = USABLE;
		char character;

		for (int i = 0; i < id.length(); i++) {
			character = id.charAt(i);
			if ((character < '0') || ('9' < character && character < 'A') || ('Z' < character && character < 'a')
					|| ('z' < character)) {
				status = INVALID; // 사용불가능한 아이디 : 대소문자 영문 또는 숫자만 사용
			}
		}

		if (id.length() < 4 || id.length() > 10) {
			status = INVALID; // 사용불가능한 아이디 : 길이 4~10자 이내
		}

		character = id.charAt(0);
		if ((character < 'A') || ('Z' < character && character < 'a') || ('z' < character)) {
			status = INVALID; // 사용불가능한 아이디 : 첫글자는 대소문자 영문자만 허용
		}

		// 아이디 중복체크
		try {
			con = getConnection();

			sql = "SELECT id, name FROM member WHERE id = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				status = DUPLICATE; // 사용불가능한 아이디 : 아이디 중복됨
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
		return status;

	} // 메소드 .checkId() 종료

	// 회원 가입 메소드
	public boolean insertMember(MemberBean jbean) {
		boolean isSuccess = false; // 회원 가입 완료 여부 확인
		try {
			con = getConnection();

			sql = "INSERT INTO member(id, passwd, name, email, post_code, road_address, number_address, detail_address, phone, mobile, reg_date) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, jbean.getId());
			pstmt.setString(2, jbean.getPasswd());
			pstmt.setString(3, jbean.getName());
			pstmt.setString(4, jbean.getEmail());
			pstmt.setString(5, jbean.getPostCode());
			pstmt.setString(6, jbean.getRoadAddress());
			pstmt.setString(7, jbean.getNumberAddress());
			pstmt.setString(8, jbean.getDetailAddress());
			pstmt.setString(9, jbean.getPhone());
			pstmt.setString(10, jbean.getMobile());
			pstmt.setTimestamp(11, jbean.getReg_date());

			pstmt.executeUpdate();
			isSuccess = true; // 회원 가입 완료
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
		return isSuccess;
	} // .insertMember()

	// 회원확인 메소드(아이디, 비밀번호 일치여부 출력)
	public boolean checkUser(String id, String passwd) {
		boolean isUser = false; // id 또는 비밀번호 불일치 전제
		try {
			con = getConnection();

			sql = "SELECT passwd FROM member WHERE id = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) { // id가 존재하고,
				if (passwd.equals(rs.getString("passwd"))) { // 비밀번호가 일치하면,
					isUser = true; // 회원인증 성공
				}
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
			if (con != null)

			{
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

	} // .checkUser() 종료

	// 회원정보 가져오기 메소드
	public MemberBean getMember(String id) {
		MemberBean member = null;
		try {
			con = getConnection();
			sql = "SELECT * FROM member WHERE id = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new MemberBean();
				// 필수정보 가져오기
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				// 선택정보 가져오기
				member.setPostCode(rs.getString("post_code"));
				member.setRoadAddress(rs.getString("road_address"));
				member.setNumberAddress(rs.getString("number_address"));
				member.setDetailAddress(rs.getString("detail_address"));
				member.setPhone(rs.getString("phone"));
				member.setMobile(rs.getString("mobile"));
				member.setReg_date(rs.getTimestamp("reg_date"));
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
	public boolean updateMember(MemberBean memberInfo) {
		boolean isSuccess = false; // 회원 정보 수정 완료 여부 확인
		try {
			con = getConnection();

			sql = "UPDATE member SET name=?, email=?, post_code=?, road_address=?, number_address=?, detail_address=?, phone=?, mobile=? WHERE id=?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getName());
			pstmt.setString(2, memberInfo.getEmail());
			pstmt.setString(3, memberInfo.getPostCode());
			pstmt.setString(4, memberInfo.getRoadAddress());
			pstmt.setString(5, memberInfo.getNumberAddress());
			pstmt.setString(6, memberInfo.getDetailAddress());			
			pstmt.setString(7, memberInfo.getPhone());
			pstmt.setString(8, memberInfo.getMobile());
			pstmt.setString(9, memberInfo.getId());

			pstmt.executeUpdate();
			isSuccess = true; // 회원 정보 수정 완료
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
		return isSuccess;
	} // .updateMember() 종료

	// 비밀번호 수정 메소드
	public boolean updatePassword(String id, String password) {
		boolean isSuccess = false; // 비밀번호 변경 완료 여부 확인
		try {
			con = getConnection();

			sql = "UPDATE member SET passwd=? WHERE id=?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, id);

			pstmt.executeUpdate();
			isSuccess = true; // 비밀번호 변경 완료
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
		return isSuccess;
	} // .updatePassword() 종료

	// 회원정보 삭제(회원 탈퇴) 메소드
	public boolean deleteMember(String id, String password) {
		boolean isSuccess = false; // 회원정보 삭제 완료 여부 확인
		try {
			con = getConnection();

			sql = "DELETE FROM member WHERE id=? AND passwd=?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.executeUpdate();

			isSuccess = true; // 회원정보 삭제 완료
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
		return isSuccess;
	} // .deleteMember() 종료

	// 회원정보 조회 메소드
//	public List<MemberBean> getMembers() { 
//		List<MemberBean> memberList = new ArrayList<MemberBean>();
//		try {
//			con = getConnection();
//			sql = "SELECT * FROM member;";
//			pstmt = con.prepareStatement(sql); 
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				
//				MemberBean mb = new MemberBean(); 
//				mb.setId(rs.getString("id"));
//				mb.setPasswd(rs.getString("passwd"));
//				mb.setName(rs.getString("name"));
//				mb.setEmail(rs.getString("email"));
//				
//				mb.setAddress(rs.getString("address"));
//				mb.setPhone(rs.getString("phone"));
//				mb.setMobile(rs.getString("mobile"));
//				mb.setReg_date(rs.getTimestamp("reg_date"));
//
//				memberList.add(mb);
//			}
//
//		} catch (Exception e) { 
//			e.printStackTrace();
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException ex) {
//
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException ex) {
//
//				}
//			}
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException ex) {
//
//				}
//			}
//		}
//		return memberList;
//	} // .getMembers() 종료

} // class MemberDAO 종료
