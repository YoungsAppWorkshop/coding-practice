<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jstl/jstl.jsp</h1>
	<!-- 	JSTL(JSP Standard Tag Library) -->
	<!-- 	: 자바코드를 최대한 줄이고 태그처럼 사용할 수 있는 기능 -->
	<!-- 	프로그램 설치 http://jakarta.apache.org -->
	<!-- 	jstl.jar	standard.jar -->
	<!-- 	core	fmt		xml		sql -->
	<c:set var="test" value="Hello JSTL" />
	<h3>변수값 설정 : <c:out value="${test }" /></h3>
	<c:remove var="test"/>
	<h3>변수값 삭제 : <c:out value="${test }" /></h3>
	<c:catch var="err">
	<%=10/0 %>
	</c:catch>
	<h3>오류 : <c:out value="${err }" /></h3>
	<c:if test="${5<10 }">
		<h3>5는 10보다 작다.</h3>
	</c:if>
	<c:choose>
		<c:when test="${5+10 == 50 }">
			<h3>5+10은 50이다</h3>
		</c:when>
		<c:otherwise>
			<h3>5+10은 50이 아니다</h3>
		</c:otherwise>
	</c:choose>
	
	<c:forEach var="i" begin="1" end="10" step="2">
		<b>${i}</b>&nbsp;
	</c:forEach>
	<br />
	<c:forTokens var="alpha" items="a,b,c,d,e,f,g" delims=",">
		<b>${alpha}</b>&nbsp;
	</c:forTokens>
		<br />
	<c:set var="data" value="홍길동, 이길동, 김길동"></c:set>
	<c:forTokens var="name" items="${data }" delims=",">
		<b>${name}</b>&nbsp;
	</c:forTokens>
</body>
</html>