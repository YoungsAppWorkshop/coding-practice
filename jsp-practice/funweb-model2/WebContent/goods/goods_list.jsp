<%@page import="net.goods.db.GoodsBean"%>
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
	<h1>goods/goods_list.jsp</h1>
	<h3><a href="./BasketList.ba">장바구니 목록</a></h3>
	<h3><a href="./OrderList.or">주문 목록</a></h3>
	<h1>상품목록</h1>
	<!-- 카테고리 -->
	<table border="1">
		<tr>
			<td><a href="./GoodsList.go">전체</a></td>
			<td><a href="./GoodsList.go?item=best">베스트상품</a></td>
			<td><a href="./GoodsList.go?item=outwear">아웃웨어</a></td>
			<td><a href="./GoodsList.go?item=fulldress">정장/신사복</a></td>
			<td><a href="./GoodsList.go?item=tshirt">티셔츠</a></td>
			<td><a href="./GoodsList.go?item=shirts">와이셔츠</a></td>
			<td><a href="./GoodsList.go?item=pants">팬츠</a></td>
			<td><a href="./GoodsList.go?item=shoes">슈즈</a></td>
		</tr>
	</table>
	<!-- 카테고리 -->
	<table border="1">
	<%
		for (GoodsBean goods : goodsList) {
			String image = goods.getImage().split(",")[0];
	%>
		<tr>
			<td><img src="upload/<%=image%>" alt="제품사진" width="300" /><br /><a href="./GoodsDetail.go?num=<%=goods.getNum()%>"><%=goods.getName()%></a><br /><%=goods.getPrice()%>원
			</td>
		</tr>
	<%
		} // close for-each
	%>
	</table>
</body>
</html>