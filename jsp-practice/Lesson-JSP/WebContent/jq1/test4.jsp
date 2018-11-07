<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery Test</title>
<script src="../js/jquery-3.1.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		// 속성선택자 	태그[속성 = 값]			태그[속성~=값] 값 포함
		// 			태그[속성 ^= 값] 시작값	태그[속성$=값] 끝 값
		// input 태그에 type 속성 text 값 .val('value 값 넣기')
		$('input[type=text]').val('test');
		$('input[type=password]').css('color', 'red');
	});
</script>
</head>
<body>
	<!-- js1/test4.jsp -->
	<input type="text" />
	<input type="password" />
</body>
</html>