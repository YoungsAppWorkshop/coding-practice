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
		// 대상.html(function(index){ /* code */})
		$('div').html(function(index) {
			return '<h1>head-' + index + '</h1>';
		});

		// 대상.html(function(인덱스, html태그의 내용값){});
		$('h2').html(function(index, oldHtml) {
			// *헤더-0*
			return '*' + oldHtml + '-' + index + '*';
		});
	});
</script>
<body>
	<!-- js1/test9.jsp -->
	<h2>Head</h2>
	<h2>First</h2>
	<h2>Java</h2>
	<div></div>
	<div></div>
	<div></div>
</body>
</html>