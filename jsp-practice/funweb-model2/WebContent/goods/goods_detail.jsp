<%@page import="net.goods.db.GoodsBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Model2 - Shopping Mall</title>
</head>
<%
	GoodsBean goods = (GoodsBean) request.getAttribute("goods");
	String image = goods.getImage().split(",")[0];
%>
<script type="text/javascript">
	function isBasket() {
		if(document.gfr.size.value==""){
			// size 선택
			alert("사이즈를 선택하세요");
			document.gfr.size.focus();
			
		} else if(document.gfr.color.value==""){
			// color 선택
			alert("색깔을 선택하세요");
			document.gfr.color.focus();
			
		} else {
			var is = confirm("장바구니에 저장하시겠습니까?");			
			if(is) { // is true 이면 
				// action "./BasketAdd.ba"
				document.gfr.action="./BasketAdd.ba";
				// submit
				document.gfr.submit();
			} // close if			
			
		} // close if-else		
		return;
	} // close isBasket()
</script>
<body>
	<h1>goods/goods_detail.jsp</h1>
	<h1>상품상세보기</h1>
	<form action="" method="post" name="gfr">
		<input type="hidden" name="num" value="<%=goods.getNum()%>">
		<table border="1">
			<tr>
				<td><img src="./upload/<%=image%>" alt="제품사진" width="300" /></td>
				<td>
					상품이름: <%=goods.getName() %> <br> 
					판매가격: <%=goods.getPrice() %>원<br> 
					수량: <input type="text" name="amount" value="1"> <br> 
					남은수량(<%=goods.getAmount()%>)개 <br> 
					크기: 
					<select name="size" id="">
						<option value="">크기를 선택하세요</option>
						<c:forTokens var="s" items="${goods.getSize() }" delims=",">
							<option value="${s}">${s}</option>
						</c:forTokens>
					</select><br>
					색깔:
					<select name="color" id="">
						<option value="">색깔을 선택하세요</option>
						<c:forTokens var="s" items="${goods.getColor() }" delims=",">
							<option value="${s}">${s}</option>
						</c:forTokens>
					</select><br>
					<a href="javascript:isBasket()">[장바구니담기]</a> 
					<a href="javascript:isBuy()">[구매하기]</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>