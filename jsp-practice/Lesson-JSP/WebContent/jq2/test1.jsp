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
		$('h1').bind('click', function() {
			// this 	.html()		글자 + "+"
			$(this).html(function(index, oldHtml) {
				return oldHtml + "+";
			});
		});
		// 		$('h1').click(function() {
		// 			$(this).html(function(index, oldHtml) {
		// 				return oldHtml + "+";
		// 			});
		// 		});
	});
</script>
<body>
	<!-- js2/test1.jsp -->
	<h1>head_0</h1>
	<h1>head_1</h1>
	<h1>head_2</h1>
</body>
</html>