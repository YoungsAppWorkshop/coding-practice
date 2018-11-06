<%@page import="net.goods.db.GoodsBean"%>
<%@page import="net.basket.db.BasketBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Model2 Practice</title>
</head>
<body>
	<%
		List<BasketBean> basketList = (List<BasketBean>) request.getAttribute("basketList");
		List<GoodsBean> goodsList = (List<GoodsBean>) request.getAttribute("goodsList");
	%>
	<h1>goods_order/goods_basket.jsp</h1>
	<h1>장바구니</h1>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>사진</td>
			<td>제품명</td>
			<td>사이즈</td>
			<td>색상</td>
			<td>수량</td>
			<td>가격</td>
			<td>취소</td>
		</tr>
	<%
		for(int i = 0 ; i < basketList.size(); i++) {
			BasketBean aBasket = (BasketBean) basketList.get(i);
			GoodsBean aGoods = (GoodsBean) goodsList.get(i);
			String image = aGoods.getImage().split(",")[0];
	%>
		<tr>
			<td><%=aBasket.getB_num() %></td>
			<td><img src="upload/<%=image%>" alt="제품사진" width="300" /></td>
			<td><%=aGoods.getName() %></td>
			<td><%=aBasket.getB_g_size() %></td>
			<td><%=aBasket.getB_g_color() %></td>
			<td><%=aBasket.getB_g_amount() %></td>
			<td><%=aGoods.getPrice() %></td>
			<td><a href="./BasketDelete.ba?num=<%=aBasket.getB_num()%>">취소</a></td>
		</tr>	
	<%	
		} // close for loop
	%>
		
	</table>
	<a href="./OrderStar.or">[구매하기]</a>
	<a href="./GoodsList.go">[계속쇼핑하기]</a>
</body>
</html>





