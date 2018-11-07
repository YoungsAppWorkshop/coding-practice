<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery Test</title>
</head>
<script src="../js/jquery-3.1.0.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// 대상.append() 대상 뒷 부분 추가
		// 대상.prepend() 대상 앞 부분 추가
		$('body').append('<h1>Append</h1>');
		$('body').prepend('<h1>Prepend</h1>');
		
		$('table').append('<tr><td>1</td><td>홍길동</td></tr>');
		$('table').attr('border', 2);
		
	});
</script>
<body>
	<!-- js1/test10.jsp -->
	<p>js1/test10.jsp</p>
	<table>
		<tr>
			<td>번호</td>
			<td>이름</td>
		</tr>
	</table>
</body>
</html>