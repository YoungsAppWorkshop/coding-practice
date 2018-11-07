<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery Test</title>
<script src="../js/jquery-3.1.0.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// 태그 : odd		태그 : even		태그 : first		태그 : last
		// 번호는 0번부터 시작됨.
		$('tr:odd').css('background','yellow');
		$('tr:even').css('background','green');
		$('tr:first').css('background','blue');
		// $('tr:even').css('background','green');
	});
</script>
</head>
<body>
	<!-- js1/test5.jsp -->
	<table border="1">
		<tr>
			<td>이름</td>
			<td>혈액형</td>
			<td>지역</td>
		</tr>
		<tr>
			<td>홍길동</td>
			<td>A</td>
			<td>충주</td>
		</tr>
		<tr>
			<td>이순신</td>
			<td>B</td>
			<td>서울</td>
		</tr>
		<tr>
			<td>이몽룡</td>
			<td>O</td>
			<td>부산</td>
		</tr>
		<tr>
			<td>성춘향</td>
			<td>AB</td>
			<td>광주</td>
		</tr>
	</table>
</body>
</html>