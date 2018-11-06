<%@page import="net.order.db.OrderBean"%>
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
	<h1>주문목록</h1>
	<%
		//request.setAttribute("adminOrderList", adminOrderList);
		//orderbean.getO_status()  0 이면 "대기중"
		//1이면 발송준비 2 발송완료 3 배송중 4 배송완료 5 주문취소
		List<OrderBean> adminOrderList = (List<OrderBean>) request.getAttribute("adminOrderList");
	%>
	<table border="1">
		<tr>
			<td>주문번호</td>
			<td>주문자</td>
			<td>결재방법</td>
			<td>주문금액</td>
			<td>주문상태</td>
			<td>주문일시</td>
			<td>수정/삭제</td>
		</tr>
	<%
		for (OrderBean anOrder : adminOrderList) {
			String status = "대기중";
			// orderbean.getO_status() 0 이면 "대기중" 
			// 1이면 발송준비 2 발송완료 3 배송중 4 배송완료 5 주문취소
			switch (anOrder.getO_status()) {
			case 0:
				status = "대기중";
				break;
			case 1:
				status = "발송준비";
				break;
			case 2:
				status = "발송완료";
				break;
			case 3:
				status = "배송중";
				break;
			case 4:
				status = "배송완료";
				break;
			case 5:
				status = "주문취소";
				break;
			} // close switch-case
	%>
		<tr>
			<td><%=anOrder.getO_trade_num()%></td>
			<td><%=anOrder.getO_m_id()%></td>
			<td><%=anOrder.getO_trade_type()%></td>
			<td><%=anOrder.getO_sum_money()%></td>
			<td><%=status%></td>
			<td><%=anOrder.getO_date()%></td>
			<td><a href="./AdminOrderDetail.ao?trade_num=<%=anOrder.getO_trade_num()%>">수정</a> / 삭제</td>
		</tr>
	<%
		} // close for-each
	%>
	</table>
</body>
</html>


