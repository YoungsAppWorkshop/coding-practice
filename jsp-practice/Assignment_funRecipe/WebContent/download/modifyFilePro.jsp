<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="download.DownloadBean"%>
<%@page import="download.DownloadDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 세션값 가져오기 : 세션값 없으면 login페이지로 이동
		String sId = (String) session.getAttribute("id");
		if (sId == null) {
			response.sendRedirect("../member/login.jsp");
		}
		
		final int MAX_SIZE = 5 * 1024 * 1024 ; // 파일 최대 크기 : 5 Mbyte		
		String realPath = request.getRealPath("/upload"); // 저장 경로
		
		// 자료 내용 가져오기 및 파일업로드 
		MultipartRequest multi = new MultipartRequest(request, realPath, MAX_SIZE, "utf-8", new DefaultFileRenamePolicy());
		
		// 자료 내용 DownloadBean에 담기
		DownloadBean db = new DownloadBean();		
		db.setNum(Integer.parseInt(multi.getParameter("num")));
		db.setName(multi.getParameter("name"));
		db.setSubject(multi.getParameter("subject"));
		db.setContent(multi.getParameter("content"));
		db.setIp(request.getRemoteAddr());
		db.setId(sId);
		
		// 첨부파일이 있으면 file, 첨부파일이 없으면 기존의 파일이름 file2
		if (multi.getFilesystemName("file") != null) {
			db.setFile(multi.getFilesystemName("file"));
		} else {
			db.setFile(multi.getParameter("file2"));
		}
		
		// DB에 저장 
		DownloadDAO ddao = new DownloadDAO();	
		boolean isSuccess = ddao.updateFile(db);
		
		if(isSuccess) { // DB 저장 성공한 경우, 메시지 출력 후 fileList.jsp로 이동
	%> 
	<script type="text/javascript">
		alert("자료를 성공적으로 수정하였습니다.");
		location.href = "fileList.jsp";
	</script>
	<% 
		} else { // DB 저장 실패한 경우, 에러메시지 출력 후 뒤로 이동
	%> 
	<script type="text/javascript">
		alert("서버가 응답하지 않습니다. 잠시 후에 다시 시도바랍니다.");
		history.back();
	</script>
	<% 	
		}
	%>
</body>
</html>