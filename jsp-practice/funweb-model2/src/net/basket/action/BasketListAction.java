package net.basket.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.basket.db.BasketBean;
import net.basket.db.BasketDAO;
import net.goods.db.GoodsBean;
import net.goods.db.GoodsDAO;

public class BasketListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		System.out.println("BasketListAction execute()");

		// 한글처리
		request.setCharacterEncoding("utf-8");

		// 세션값 가져오기
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("id");

		if (sessionId == null) { // 세션값 없으면 로그인페이지 이동
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");

		} else { // 세션값 있으면 장바구니 리스트 생성

			// Vector vector=메소드 호츨 getBasketList(String id)
			// => Vector vector = new Vector();
			// List basketList = vector 첫번째 데이터
			// List goodsList = vector 두번째 데이터
			// 저장 basketList goodsList			
			
			// DB에서 데이터 가져오기
			BasketDAO bdao = new BasketDAO();
			Vector<Object> basketVector = bdao.getBasketList(sessionId);
			
			List<BasketBean> basketList = (List<BasketBean>) basketVector.get(0);
			List<GoodsBean> goodsList = (List<GoodsBean>) basketVector.get(1);
			
			/****************** 직접 구현한 부분 **********************
			Iterator<Object> iterator = basketVector.iterator();

			// DB에서 가져온 데이터를 List로 변환
			while (iterator.hasNext()) {
				BasketBean aBasket = (BasketBean) iterator.next();
				GoodsBean aGoods = (GoodsBean) iterator.next();
				basketList.add(aBasket);
				goodsList.add(aGoods);
			} // close while loop
			****************************************************/
			
			// request에 List 데이터 저장
			request.setAttribute("basketList", basketList);
			request.setAttribute("goodsList", goodsList);

			// 이동 ./goods_order/goods_basket.jsp
			forward.setRedirect(false);
			forward.setPath("./goods_order/goods_basket.jsp");

		} // close if-else

		return forward;

	} // close method

} // close class
