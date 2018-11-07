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
		// 대상.html()	대상.text();
		// 		var h = $('h1').html();
		// 		alert(h);
		// 		var t = $('h1').text();
		// 		alert(t);
		$('div').html('<h2>html 메소드</h2>');
		$('div').text('<h2>html 메소드</h2>');
	});
</script>
<body>
	<!-- js1/test8.jsp -->
	<h1>head-0</h1>
	<h1>head-1</h1>
	<h1>head-2</h1>

	<div></div>
	<div></div>
	<div></div>
</body>
</html>