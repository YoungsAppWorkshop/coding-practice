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
	$(document).ready(
			function() {
				// 배열변수
				var array = [ {
					name : 'naver',
					link : 'http://www.naver.com'
				}, {
					name : 'daum',
					link : 'http://www.daum.net'
				}, {
					name : 'google',
					link : 'http://www.google.com'
				}, {
					name : 'jQuery',
					link : 'http://www.jquery.com'
				} ];
				// .each()
				$.each(array, function(key, value) {
					$('body').append(
							"<h1><a href='"+this.link+"'>" + this.name
									+ "</a></h1>");
				});
			});
</script>
<body>
	<!-- js1/test14.jsp -->

</body>
</html>