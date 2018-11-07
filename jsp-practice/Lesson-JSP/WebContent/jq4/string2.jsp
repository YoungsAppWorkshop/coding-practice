<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- js4/string2.jsp -->
<%
	// 파라미터 name	age 가져오기
	// 출력 name : age
	String name = request.getParameter("name");
	String age = request.getParameter("age");

%>
<h1><%=name %> : <%=age %></h1>
