<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery Test</title>
<style type="text/css">
* {
	margin: 5px;
	padding: 5px;
	border: 3px solid black;
}
</style>
</head>
<script src="../js/jquery-3.1.0.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// a태그 클릭 click()	.css()	배경색 background blue
		$('a').click(function(event) {
			$(this).css('background', 'blue');
			// 기존태그 기능 중지
			event.preventDefault();
			// 겹쳐 있을 경우 이벤트 전달 막기
			event.stopPropagation();
			// return false;
		});
		// h1태그 클릭 배경색 red
		$('h1').click(function() {
			$(this).css('background', 'red');
		});
	});
</script>
<body>
	<!-- js2/test3.jsp -->
	<h1>
		<a href="http://www.naver.com" target="_blank">네이버</a>
	</h1>
</body>
</html>