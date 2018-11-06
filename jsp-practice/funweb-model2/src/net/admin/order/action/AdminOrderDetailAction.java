package net.admin.order.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.order.db.AdminOrderDAO;
import net.order.db.OrderBean;

public class AdminOrderDetailAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		System.out.println("AdminOrderDetailAction execute()");

		// 관리자 세션 제어

		// 한글처리
		request.setCharacterEncoding("utf-8");

		// 세션값 가져오기
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("id");

		if (sessionId == null) {
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");

		} else if (!sessionId.equals("admin")) { // 관리자가 아니면 로그인 페이지 이동
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");

		} else { // 세션값 있으면,
			// 파라미터 가져오기
			String trade_num = request.getParameter("trade_num");
			
			// 주문 세부정보리스트 가져오기
			AdminOrderDAO aodao = new AdminOrderDAO();
			List<OrderBean> adminOrderDetail = aodao.getAdminOrderDetail(trade_num);

			// request에 주문 목록 저장하기
			request.setAttribute("adminOrderDetail", adminOrderDetail);

			// 이동 ./adminOrder/admin_order_modify.jsp
			forward.setRedirect(false);
			forward.setPath("./adminOrder/admin_order_modify.jsp");
		} // close if-else

		return forward;

	} // close method

} // close class
