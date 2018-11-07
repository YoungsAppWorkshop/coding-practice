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
				var con = [ {
					name : '홍길동',
					region : '서울'
				}, {
					name : '이순신',
					region : '부산'
				}, {
					name : '성춘향',
					region : '대전'
				} ];
				// table append function(index)
				// var item=con[index]
				// item.name, item.region
				$('div').append(function(index) {
					var item = con[index];
					return item.name + ' : ' + item.region;
				});
				var obj = {
					'홍길동' : '서울',
					'이순신' : '부산',
					'성춘향' : '광주'
				};
				$('table').attr('border', 2);
				$.each(obj, function(key, value) {
					$('table').append(
							'<tr><td>' + key + '</td><td>' + value
									+ '</td></tr>');
				});
			});
</script>
<body>
	<!-- js1/test11.jsp -->
	<table>
		<tr>
			<td>이름</td>
			<td>지역</td>
		</tr>
	</table>
	<div></div>
	<div></div>
	<div></div>
</body>
</html>