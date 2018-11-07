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
		var col = $('h1').css('color');
		// alert(col);
		// h1태그 글자색 'green'
		$('h1').css('color','green');
		$('h1').css({
			color:'blue',
			background:'yellow'
		});
		
		var color = ['red', 'blue', 'purple'];
		$('h1').css('color', function(index){
			// index 매개변수 순서값 0 1 2
			return color[index];
		});
		
		$('h1').css({
			color: function(index){
				// index 매개변수 순서값 0 1 2
				return color[index];
			},
			background:'black'
		});
	});
</script>
</head>
<body>
	<!-- js1/test6.jsp -->
	<h1>head-0</h1>
	<h1>head-1</h1>
	<h1>head-2</h1>
</body>
</html>