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
		// 대상.mouseover(2.jpg변경).mouseout();
		$('img').mouseover(function(){
			$(this).attr('src','../js1/2.jpg');
		}).mouseout(function(){
			$(this).attr('src','../js1/1.jpg');
		});

	});
</script>
<body>
	<!-- js2/test2.jsp -->
	<img src="../js1/1.jpg" alt="" width="200" height="100" />
</body>
</html>
