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
		// textarea 태그 keyup()
		// 입력된 글자 개수 .val()		.length		
		// alert() 출력
		$('textarea').keyup(function() {
			var inputLength = $(this).val().length;
			// alert(inputLength);
			var remain = 150 - inputLength;
			// h1 태그 안에 150 대신 remain 넣기 .html()
			$('h1').html(remain);
			// remain 0보다 크거나 같으면 h1 태그 안 글자색 black
			//		  0보다 작으면 h1 태그 안 글자색 red
			if (remain >= 0) {
				$('h1').css('color', 'black');
			} else {
				$('h1').css('color', 'red');
			}
		});
	});
</script>
<body>
	<!-- js2/test4.jsp -->
	<h1>150</h1>
	<textarea cols="70" rows="5"></textarea>
</body>
</html>