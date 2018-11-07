<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery Test</title>
<style>
.high_0 {
	background: yellow;
}

.high_1 {
	background: orange;
}

.high_2 {
	background: blue;
}

.high_3 {
	background: green;
}

.high_4 {
	background: red;
}
</style>
</head>
<script src="../js/jquery-3.1.0.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// 대상.each()
		// 		$('h1').each(function(index){
		// 			$(this).addClass('high_'+index);
		// 		});		
		$('h1').addClass(function(index) {
			return 'high_' + index;
		});
	});
</script>
<body>
	<!-- js1/test13.jsp -->
	<h1>item-0</h1>
	<h1>item-1</h1>
	<h1>item-2</h1>
	<h1>item-3</h1>
	<h1>item-4</h1>
</body>
</html>