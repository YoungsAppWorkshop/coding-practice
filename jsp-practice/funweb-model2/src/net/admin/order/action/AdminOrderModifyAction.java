package net.admin.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.order.db.AdminOrderDAO;
import net.order.db.OrderBean;

public class AdminOrderModifyAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		System.out.println("AdminOrderModifyAction execute()");

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
			OrderBean updatedInfo = new OrderBean();
			updatedInfo.setO_trade_num(request.getParameter("trade_num"));
			updatedInfo.setO_status(Integer.parseInt(request.getParameter("status")));
			updatedInfo.setO_trans_num(request.getParameter("trans_num"));
			
			// 주문 정보 업데이트
			AdminOrderDAO aodao = new AdminOrderDAO();
			aodao.updateOrder(updatedInfo);

			// 이동 ./adminOrder/AdminOrderList.ao
			forward.setRedirect(true);
			forward.setPath("./AdminOrderList.ao");
			
		} // close if-else

		return forward;
	} // close method

} // close class
