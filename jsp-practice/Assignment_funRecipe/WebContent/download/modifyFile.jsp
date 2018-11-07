<%@page import="download.DownloadBean"%>
<%@page import="download.DownloadDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Download</title>
<link href="../css/default.css" rel="stylesheet" type="text/css">
<link href="../css/subpage.css" rel="stylesheet" type="text/css">
<!--[if lt IE 9]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js" type="text/javascript"></script>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/ie7-squish.js" type="text/javascript"></script>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
<![endif]-->
<!--[if IE 6]>
 <script src="../script/DD_belatedPNG_0.0.8a.js"></script>
 <script>
   /* EXAMPLE */
   DD_belatedPNG.fix('#wrap');
   DD_belatedPNG.fix('#main_img');   

 </script>
 <![endif]-->
</head>
<body onload="document.form.subject.focus()">
	<%
		// 한글처리
		request.setCharacterEncoding("utf-8");	
	
		// 세션값 가져오기 : 세션값 없으면 login페이지로 이동
		String sId = (String) session.getAttribute("id");
		String sName = (String) session.getAttribute("name");
		if (sId == null) {
			response.sendRedirect("../member/login");
		}
		// 파라미터 가져오기 : 글번호(num), 페이지번호(pageNum) 
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		// 글 내용(수정 전) 가져오기 
		DownloadDAO ddao = new DownloadDAO();
		DownloadBean db = ddao.getFile(num);	
		
		if(sId != null){ // 글쓴이와 현재 접속자가 다른 경우 fileList.jsp로 돌아가기 
			if(!sId.equals(db.getId())){
				response.sendRedirect("fileList.jsp?pageNum=" + pageNum);
			}
		}
	%>
	<div id="wrap">
		<!-- 헤더들어가는 곳 -->
		<!-- 상대경로 (현재폴더 : . 상위 폴더 : ..) -->
		<jsp:include page="../inc/top.jsp"></jsp:include>
		<!-- 헤더들어가는 곳 -->

		<!-- 본문들어가는 곳 -->
		<!-- 메인이미지 -->
		<div id="sub_img_center">
			<img src="../images/sub_img2.jpg" width="971" height="282">
		</div>
		<!-- 메인이미지 -->

		<!-- 왼쪽메뉴 -->
		<jsp:include page="../inc/subMenu.jsp"></jsp:include>
		<!-- 왼쪽메뉴 -->

		<!-- 게시판 -->
		<%

		%>
		<article>
			<h1>Modify File</h1>
			<form action="modifyFilePro.jsp" method="post" name="form" enctype="multipart/form-data" onsubmit="return submitFun()">
				<input type="hidden" name="num" value="<%=db.getNum()%>"/>
				<input type="hidden" name="id" value="<%=sId%>"/>
				<input type="hidden" name="name" value="<%=sName%>"/>
				<table id="notice">
					<tr>
						<td class="form">제목</td>
						<td><input type="text" name="subject" value="<%=db.getSubject() %>" class="subject"/></td>
					</tr>
					<tr>
						<td class="form">첨부파일</td>
						<td>
							<input type="file" name="file" value="<%=db.getFile()%>"/>
							<input type="hidden" name="file2" value="<%=db.getFile()%>" />
						</td>
					</tr>
					<tr>
						<td class="form">내용</td>
						<td><textarea name="content" id="" cols="60" rows="40"><%=db.getContent()%></textarea></td>
					</tr>
				</table>
				<div id="table_search">
					<input type="submit" value="수정하기" class="btn">
					<input type="button" value="취소" class="btn" onclick="history.back()">
				</div>
			</form>
			<div class="clear"></div>

			<div id="page_control"></div>
		</article>
		<!-- 게시판 -->
		<!-- 본문들어가는 곳 -->
		<div class="clear"></div>
		<!-- 푸터들어가는 곳 -->
		<jsp:include page="../inc/bottom.jsp"></jsp:include>
		<!-- 푸터들어가는 곳 -->
	</div>
</body>
<script type="text/javascript">
	function submitFun() { // submit제어 함수 - 필수입력사항 제어
		if (document.form.subject.value.length < 1) {
			alert("제목을 입력하세요");
			document.form.subject.focus();
			return false;
		}
		if (document.form.content.value.length < 1) {
			alert("내용을 입력하세요");
			document.form.content.focus();
			return false;
		}
		
	}
</script>
</html>