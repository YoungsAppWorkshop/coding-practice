<%@page import="net.admin.goods.db.GoodsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Model2 - Shopping Mall</title>
</head>
<body>
	<%
		List<GoodsBean> goodsList = (List<GoodsBean>) request.getAttribute("goodsList");
	%>
	<h1>adminGoods/admin_goods_list.jsp</h1>
	<h1>상품목록</h1>
	<h3>
		<a href="./GoodsAdd.ag">상품등록</a>
	</h3>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>카테고리</td>
			<td>사진</td>
			<td>상품명</td>
			<td>단가</td>
			<td>수량</td>
			<td>등록일자</td>
			<td>수정/삭제</td>
		</tr>
	<%
		for (GoodsBean goods : goodsList) {
			String image = goods.getImage().split(",")[0];
	%>
		<tr>
			<td><%=goods.getNum()%></td>
			<td><%=goods.getCategory() %></td>
			<td><img src="upload/<%=image %>" alt="제품사진" width="300"/></td>
			<td><%=goods.getName() %></td>
			<td><%=goods.getPrice() %></td>
			<td><%=goods.getAmount() %></td>
			<td><%=goods.getDate() %></td>
			<td><a href="./GoodsModify.ag?num=<%=goods.getNum()%>">수정</a>
			<a href="./GoodsDelete.ag?num=<%=goods.getNum()%>">삭제</a></td>
		</tr>
	<%
		} // close for-each
	%>
	</table>
</body>
</html>