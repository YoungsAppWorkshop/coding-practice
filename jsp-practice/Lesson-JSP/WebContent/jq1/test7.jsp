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
		// 대상.attr()
		var s = $('img').attr('src');
		// alert("src속성값 : " + s)
		// $('img').attr('border', 3);
		// 		$('img').attr({
		// 			border : 5,
		// 			width : 200,
		// 			height : 100
		// 		});
		// 		$('img').attr('border', function(index) {
		// 			return (index + 1) * 5;
		// 		});
		$('img').attr({
			border : function(index) {
				return (index + 1) * 5;
			},
			width : function(index) {
				return (index + 1) * 50;
			},
			height : function(index) {
				return (index + 1) * 30;
			}
		});
	});
</script>
</head>
<body>
	<!-- js1/test7.jsp -->
	<img src="1.jpg" alt="" />
	<img src="2.jpg" alt="" />
	<img src="3.jpg" alt="" />
</body>
</html>




