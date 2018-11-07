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
		// 효과
		// .show()		.hide()		.toggle()
		// .slideDown()	.slideUp()	.slideToggle()
		// .fadeIn()	.fadeOut()	.fadeToggle()
		
		// 대상 h1태그 클릭이벤트
		// 그 대상의 다음 태그 .next() 효과 .toggle('slow', function(){})
		// function 안에 경고메시지 "효과 끝"
		$('h1').click(function(){
			$(this).next().toggle('slow', function(){
				alert("효과 끝");
			});
		});
	});
</script>
<body>
	<!-- js3/test1.jsp -->
	<h1>열고/닫기</h1>
	<div>
		<h1>제목1</h1>
		<p>내용1</p>
	</div>
	<div>
		<h1>제목2</h1>
		<p>내용2</p>
	</div>
</body>
</html>