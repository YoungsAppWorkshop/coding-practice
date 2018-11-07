<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내장객체-request(3) 7/21</title>
</head>
<body>
	<h1>JSP1/requestForm03.jsp</h1>
	<form action="requestPro03.jsp" method="post" name="fr">
		아이디 : <input type="text" name="id"><br> 비밀번호 : <input
			type="password" name="passwd"><br> 성별 : <input
			type="radio" name="se" value="남">남 <input type="radio"
			name="se" value="여">여 <br> 학년 : <select name="hak">
			<option value="1">1학년</option>
			<option value="2">2학년</option>
			<option value="3">3학년</option>
		</select> <br> 메모 :
		<textarea rows="10" cols="20" name="memo"></textarea> <br>
		취미 : <input type="checkbox" name="ho" value="여행">여행 <input
			type="checkbox" name="ho" value="게임">게임 <input
			type="checkbox" name="ho" value="독서">독서 <br> <input
			type="submit" value="전송">
	</form>
</body>
</html>