<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>데이터베이스 연동 연습 - 8/4</title>
</head>
<body>
	<%
		// 한글처리
		request.setCharacterEncoding("utf-8");
		// 세션값 가져오기
		String id = (String) session.getAttribute("id");
		// 세션값이 없으면(null이면) logInForm.jsp로 이동
		if (id == null) {
			response.sendRedirect("logInForm.jsp");
		}
		// 파라미터 가져오기
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		// 1단계 드라이버 로더
		Class.forName("com.mysql.jdbc.Driver");
		// 2단계 디비연결
		String dbUrl = "jdbc:mysql://localhost:3306/jspdb"; // DB주소
		String dbUser = "jspid"; // DB유저명
		String dbPass = "jsppass"; // DB비밀번호
		Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass); // 연결정보 저장
		// 3단계 sql 객체 생성
		//		조건 id가 "kim"인 회원 passwd 조회
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM member WHERE id = ?;";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		// 4단계 실행 => ResultSet 저장
		ResultSet rs = null;
		rs = pstmt.executeQuery();
		// 5단계 첫번째 행에서 데이터 있는 경우
		if (rs.next()) {
			if (passwd.equals(rs.getString("passwd"))) {
				// 폼비밀번호 디비 비밀번호 비교 맞으면 로그인 인증 후 "main.jsp"로 이동
				sql = "UPDATE member SET name = ? WHERE id = ?;";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, id);
				pstmt.executeUpdate();
	%><script>
		alert("회원정보 수정완료");
		location.href="main.jsp"
	</script>
	<%
		} else {
				// 폼비밀번호 디비 비밀번호 틀리면 비밀번호 틀림
	%><script>
		alert("비밀번호 틀림");
		history.back();
	</script>
	<%
		}
		} else {
			// 첫번째 행에서 데이터 없는 경우 "아이디 없음"
	%><script>
		alert("아이디 없음");
		history.back();
	</script>
	<%
		}
	%>
	<h1>jsp5/updatePro.jsp</h1>
</body>
</html>