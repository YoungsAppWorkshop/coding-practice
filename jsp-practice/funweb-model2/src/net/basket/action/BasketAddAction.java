package net.basket.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.basket.db.BasketBean;
import net.basket.db.BasketDAO;

public class BasketAddAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		System.out.println("BasketAddAction execute()");

		// 한글처리
		request.setCharacterEncoding("utf-8");

		// 세션값 가져오기
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("id");

		if (sessionId == null) { // 세션값 없으면 로그인페이지 이동
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");

		} else { // 세션값 있으면 장바구니 생성

			// 파라미터 가져오기 및 정보 저장
			BasketBean aBasket = new BasketBean();
			aBasket.setB_m_id(sessionId);
			aBasket.setB_g_num(Integer.parseInt(request.getParameter("num")));
			aBasket.setB_g_amount(Integer.parseInt(request.getParameter("amount")));
			aBasket.setB_g_size(request.getParameter("size"));
			aBasket.setB_g_color(request.getParameter("color"));

			// DB에 정보 저장
			BasketDAO bdao = new BasketDAO();
			bdao.addBasket(aBasket);

			// 이동
			forward.setRedirect(true);
			forward.setPath("./BasketList.ba");
		} // close if-else
		
		return forward;

	} // close method

} // close class
