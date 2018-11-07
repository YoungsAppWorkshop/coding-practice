<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery Test</title>
<script src="../js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		alert("처음 준비");
	});

	jQuery(document).ready(function() {
		alert("두번째");
	});

	$(function() {
		alert("세번째");
	});
</script>
</head>
<body>

</body>
</html>