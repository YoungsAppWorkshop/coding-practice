package net.order.action;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.basket.db.BasketBean;
import net.basket.db.BasketDAO;
import net.goods.db.GoodsBean;
import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class OrderStarAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		System.out.println("OrderStarAction execute()");

		// 한글처리
		request.setCharacterEncoding("utf-8");

		// 세션값 가져오기
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("id");

		if (sessionId == null) { // 세션값 없으면 로그인페이지 이동
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");

		} else { // 세션값 있으면,
			// 장바구니 정보 가져오기
			BasketDAO bdao = new BasketDAO();
			Vector<Object> basketVector = bdao.getBasketList(sessionId);
			
			List<BasketBean> basketList = (List<BasketBean>) basketVector.get(0);
			List<GoodsBean> goodsList = (List<GoodsBean>) basketVector.get(1);
			
			// 회원 정보 가져오기
			MemberDAO mdao = new MemberDAO();
			MemberBean aMember = mdao.getMember(sessionId);
			
			
			// request에 장바구니 정보, 회원 정보  저장
			request.setAttribute("basketList", basketList);
			request.setAttribute("goodsList", goodsList);
			request.setAttribute("memberInfo", aMember);

			// 이동 ./goods_order/goods_buy.jsp
			forward.setRedirect(false);
			forward.setPath("./goods_order/goods_buy.jsp");
			
		} // close if-else

		return forward;

	} // close method

} // close class