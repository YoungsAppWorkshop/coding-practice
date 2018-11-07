<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery Test</title>
<script src="../js/jquery-3.1.0.js"></script>
<script type="text/javascript">
	// 대상.함수()
	// 대상 선택 : 전체 선택자, 태그선택자, 아이디선택자, 클래스선택자
	$(document).ready(function() {
		// body 모든 글자 색 red
		$('*').css('color', 'red');
		// h1태그 글자색 blue
		$('h1').css('color', 'blue');
		// 아이디 선택자 글자색 green
		$('#ta').css('color', 'green');
		// ta2 클래스 선택자 글자색 orange
		$('.ta2').css('color', 'orange');
	});
</script>
</head>
<body>
	<!-- js1/test3.jsp -->
	<h1>제목1</h1>
	<h1 id="ta">제목2</h1>
	<h1 class="ta2">제목3</h1>
	내용
</body>
</html>