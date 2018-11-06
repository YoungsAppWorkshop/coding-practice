package net.order.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.order.db.OrderBean;
import net.order.db.OrderDAO;

public class OrderListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		System.out.println("OrderListAction execute()");

		// 한글처리
		request.setCharacterEncoding("utf-8");
		
		// 세션값 가져오기
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("id");

		if (sessionId == null) { // 세션값 없으면 로그인페이지 이동
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");

		} else { // 세션값 있으면,
			// 주문 목록 가져오기
			OrderDAO odao = new OrderDAO();
			List<OrderBean> orderList = odao.getOrderList(sessionId);
			
			// request에 주문 목록 저장하기
			request.setAttribute("orderList", orderList);
			
			// 이동 ./goods_order/order_list.jsp
			forward.setRedirect(false);
			forward.setPath("./goods_order/order_list.jsp");

		} // close if-else

		return forward;
	} // close method

} // close class