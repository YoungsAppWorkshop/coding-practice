package net.order.action;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.goods.db.GoodsDAO;
import net.basket.db.BasketBean;
import net.basket.db.BasketDAO;
import net.goods.db.GoodsBean;
import net.order.db.OrderBean;
import net.order.db.OrderDAO;

public class OrderAddAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		System.out.println("OrderAddAction execute()");

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

			// BasketDAO bdao 객체 생성
			// Vector v= 메서드호출 getBasketList(String id)
			// List basketList = vector 첫번째데이터
			// List goodsList = vector 두번째데이터

			BasketDAO bdao = new BasketDAO();
			Vector<Object> basketVector = bdao.getBasketList(sessionId);

			List<BasketBean> basketList = (List<BasketBean>) basketVector.get(0);
			List<GoodsBean> goodsList = (List<GoodsBean>) basketVector.get(1);
			// net.order.db.OrderBean
			// 객체 생성 ob
			// 폼 파라미터 -> ob 멤버변수 저장
			// o_m_id, o_receive_name o_receive_addr1
			// o_receive_addr2 o_receive_phone
			// o_receive_mobile o_memo o_trade_payer

			OrderBean anOrder = new OrderBean();
			anOrder.setO_m_id(sessionId);
			anOrder.setO_receive_name(request.getParameter("o_receive_name"));
			anOrder.setO_receive_addr1(request.getParameter("o_receive_addr1"));
			anOrder.setO_receive_addr2(request.getParameter("o_receive_addr2"));
			anOrder.setO_receive_phone(request.getParameter("o_receive_phone"));
			anOrder.setO_receive_mobile(request.getParameter("o_receive_mobile"));
			anOrder.setO_receive_name(request.getParameter("o_receive_name"));
			anOrder.setO_trade_payer(request.getParameter("o_trade_payer"));

			// 결제 연결 U+전자결제 유플러스결제 http://ecredit.uplus.co.kr/

			// net.order.db.OrderDAO
			// 객체 생성 odao
			// 메서드호출 addOrder(ob,basketList,goodsList)
			
			// 주문 생성
			OrderDAO odao = new OrderDAO();
			odao.addOrder(anOrder, basketList, goodsList);
			
			// 재고수량 수정
			GoodsDAO gdao = new GoodsDAO();
			gdao.updateAmount(basketList);
			
			// 메일,문자 전송
			// 상품전체개수 수정goodsdao updateAmount(basketList)
			// 장바구니 정보 삭제 basketdao// deleteBasket(id)
			bdao.deleteBasket(sessionId);

			// 이동 ./OrderList.or
			forward.setRedirect(true);
			forward.setPath("./OrderList.or");
			
		} // close if-else

		return forward;
	} // close method

} // close class