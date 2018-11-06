package net.admin.order.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.order.db.AdminOrderDAO;
import net.order.db.OrderBean;

public class AdminOrderListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		System.out.println("AdminOrderListAction execute()");
		// 관리자 세션 제어
		// 디비파일 만들기 net.admin.order.db.AdminOrderDAO
		// 객체 생성 AdminOrderDAO aodao
		// List adminOrderList = 메소드 호출 .getAdminOrderList()
		// 저장 adminOrderList
		// 이동 ./adminOrder/admin_order_list.jsp

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
			// 주문 목록 가져오기
			AdminOrderDAO aodao = new AdminOrderDAO();
			List<OrderBean> adminOrderList = aodao.getAdminOrderList();

			// request에 주문 목록 저장하기
			request.setAttribute("adminOrderList", adminOrderList);

			// 이동 ./adminOrder/admin_order_list.jsp
			forward.setRedirect(false);
			forward.setPath("./adminOrder/admin_order_list.jsp");
			
		} // close if-else

		return forward;
	} // close method

} // close class
