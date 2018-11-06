<%@page import="net.goods.db.GoodsBean"%>
<%@page import="net.basket.db.BasketBean"%>
<%@page import="net.member.db.MemberBean"%>
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
		MemberBean aMember = (MemberBean) request.getAttribute("memberInfo");
	%>
	<h1>goods_order/goods_buy.jsp</h1>
	<h1>주문상세내역</h1>
	<table border="1">
		<tr>
			<td>사진</td>
			<td>상품명</td>
			<td>수량</td>
			<td>색깔</td>
			<td>사이즈</td>
			<td>가격</td>
		</tr>
		<%
			for (int i = 0; i < basketList.size(); i++) {
				BasketBean aBasket = basketList.get(i);
				GoodsBean aGoods = goodsList.get(i);
				String image = aGoods.getImage().split(",")[0];
		%>
		<tr>
			<td><img src="./upload/<%=image%>" width="300"></td>
			<td><%=aGoods.getName()%></td>
			<td><%=aBasket.getB_g_amount()%></td>
			<td><%=aBasket.getB_g_color()%></td>
			<td><%=aBasket.getB_g_size()%></td>
			<td><%=aGoods.getPrice()%></td>
		</tr>
		<%
			} // close for loop
		%>
	</table>
	<form action="./OrderAdd.or" method="post">
		<h1>주문자정보</h1>
		이름:
		<%=aMember.getName()%><br> 휴대폰: <br> 이메일주소:
		<%=aMember.getEmail()%><br>
		<h1>배송지정보</h1>
		받는사람:<input type="text" name="o_receive_name" value="<%=aMember.getName()%>"><br> 
		집전화:<input	type="text" name="o_receive_phone" value=""><br> 
		휴대폰:<input	type="text" name="o_receive_mobile" value=""><br> 
		배송지
		주소:<input type="text" name="o_receive_addr1" value=""><br>
		배송지 나머지주소:<input type="text" name="o_receive_addr2" value=""><br>
		기타요구사항:<input type="text" name="o_memo" value=""><br>
		<h1>결제정보</h1>
		입금자명(온라인입금일경우):<input type="text" name="o_trade_payer" value="<%=aMember.getName()%>"><br> 
		<input type="submit" value="주문"> <input type="reset" value="취소">
	</form>
</body>
</html>







