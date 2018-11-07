<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키 실습 - 7/28</title>
</head>
<body>
	<h1>jsp3/cookieForm.jsp</h1>
	<%
		String language = "korean";
		// 쿠키값 가져오기
		// 모든 쿠키값 가져오기
		Cookie cookies[] = request.getCookies();
		// 쿠키값 중 "language" 찾기
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("language")) {
				language = cookies[i].getValue(); // language 변수에 저장
			}
		}
		// 쿠키값에 따라 출력
		if (language.equals("korean")) {
	%><h3>안녕하세요. 이것은 쿠키 예제입니다.</h3>
	<%
		} else if (language.equals("english")) {
	%><h3>Hello, This is Cookie example.</h3>
	<%
		}
	%>
	<form action="cookiePro.jsp" method="post">
		<input type="radio" name="lang" value="korean"
			<%if (language.equals("korean")) {%> checked <%}%>> 한국어 페이지
		보기 <input type="radio" name="lang" value="english"
			<%if (language.equals("english")) {%> checked <%}%>> 영어 페이지
		보기<br> <br> <input type="submit" value="언어바꾸기">
	</form>
</body>
</html>