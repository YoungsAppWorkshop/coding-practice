<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery Test</title>
<style type="text/css">
div {
	width: 50px;
	height: 50px;
	background-color: orange;
}
</style>
</head>
<script src="../js/jquery-3.1.0.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// .animate()
		// div태그 클릭 시
		// 그 태그 효과 .animate({width: 변수+50, height:변수+50}, 'slow')
		$('div').click(function(){
			$(this).animate({
				width : "+=50",
				height : "+=50"
			},'slow');
		});
	});
</script>
<body>
	<!-- js3/test3.jsp -->
	<div></div>
</body>
</html>