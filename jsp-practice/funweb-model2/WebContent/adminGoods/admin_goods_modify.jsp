<%@page import="net.admin.goods.db.GoodsBean"%>
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
		GoodsBean goods = (GoodsBean) request.getAttribute("goodsBean");
	%>
	<h1>adminGoods/admin_goods_Modify.jsp</h1>
	<h1>상품수정</h1>
	<form action="./GoodsModifyAction.ag" method="post">
		<input type="hidden" name="num" value="<%=goods.getNum()%>" />
		<table border="1">
			<tr>
				<td>카테고리</td>
				<td><select name="category" id="">
						<option value="outwear"
							<%if (goods.getCategory().equals("outwear")) {%> selected <%}%>>아웃웨어</option>
						<option value="fulldress"
							<%if (goods.getCategory().equals("fulldress")) {%> selected <%}%>>정장/신사복</option>
						<option value="tshirt"
							<%if (goods.getCategory().equals("tshirt")) {%> selected <%}%>>티셔츠</option>
						<option value="shirts"
							<%if (goods.getCategory().equals("shirts")) {%> selected <%}%>>와이셔츠</option>
						<option value="pants"
							<%if (goods.getCategory().equals("pants")) {%> selected <%}%>>하의</option>
						<option value="shoes"
							<%if (goods.getCategory().equals("shoes")) {%> selected <%}%>>신발</option>
				</select></td>
			</tr>
			<tr>
				<td>상품이름</td>
				<td><input type="text" name="name"
					value="<%=goods.getName()%>" /></td>
			</tr>
			<tr>
				<td>판매가</td>
				<td><input type="text" name="price"
					value="<%=goods.getPrice()%>" /></td>
			</tr>
			<tr>
				<td>색깔</td>
				<td><input type="text" name="color"
					value="<%=goods.getColor()%>" /></td>
			</tr>
			<tr>
				<td>수량</td>
				<td><input type="text" name="amount"
					value="<%=goods.getAmount()%>" /></td>
			</tr>
			<tr>
				<td>사이즈</td>
				<td><input type="text" name="size"
					value="<%=goods.getSize()%>" /></td>
			</tr>
			<tr>
				<td>제품정보</td>
				<td><input type="text" name="content"
					value="<%=goods.getContent()%>" /></td>
			</tr>
			<tr>
				<td>Best</td>
				<td>
					<input type="radio" name="best" value="1" <%if (goods.getBest() == 1) {%> checked <%}%> />베스트 상품
					<input type="radio" name="best" value="0" <%if (goods.getBest() == 0) {%> checked <%}%> />일반 상품
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정" /><input
					type="reset" value="취소" /></td>
			</tr>
		</table>
	</form>
</body>
</html>