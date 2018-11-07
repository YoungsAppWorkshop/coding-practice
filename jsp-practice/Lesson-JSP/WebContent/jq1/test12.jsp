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
		// 이미지 크기 width 250 css() attr()
		$('img').attr('width', 100);
		// javaScript함수 : setInterval(기능, 시간 milliseconds)
		// jQuery함수 : append()
		setInterval(function(){
			// body태그 뒤에 추가 : img 태그의 첫번째 .first()
			$('body').prepend($('img').last());
		}, 1000);
	});
</script>
<body>
	<!-- js1/test12.jsp -->
	<img src="1.jpg" alt="" />
	<img src="2.jpg" alt="" />
	<img src="3.jpg" alt="" />
	<img src="4.jpg" alt="" />
	<img src="5.jpg" alt="" />
</body>
</html>