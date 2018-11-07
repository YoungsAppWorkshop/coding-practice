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
		// 대상 form태그 #my_form	.submit()
		$('form#my_form').submit(function(){
			var name = $('input#name').val();
			var passwd = $('input#passwd').val();
			if(name.length == 0){
				alert("이름 입력하세요");
				$('input#name').focus();
				event.preventDefault();
			} else if(passwd == 0){
				alert("패스워드 입력하세요");
				$('input#passwd').focus();
				event.preventDefault();
			}
			
		});

	});
</script>
<body>
	<!-- js2/test5.jsp -->
	<form action="http://www.naver.com" id="my_form">
		이름 : <input type="text" name="name" id="name"></input> <br />
		패스워드 : <input type="password" name="passwd" id="passwd"></input> <br />
		<input type="submit" value="submit" />
	</form>
</body>
</html>