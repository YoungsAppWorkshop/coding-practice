<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int product;

	for (int i = 2; i <= 3; i++) {
		for (int j = 1; j <= 9; j++) {
			product = i * j;
%>
<p><%=i %> x <%=j %> = <%=product %></p>
<%
		}
	}
%>