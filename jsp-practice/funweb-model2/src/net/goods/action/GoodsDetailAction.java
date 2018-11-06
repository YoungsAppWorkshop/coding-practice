package net.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.goods.db.GoodsBean;
import net.goods.db.GoodsDAO;

public class GoodsDetailAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		System.out.println("GoodsDetailAction execute()");
		
		// 파라미터 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
				
		// DB 작업 : 상품 정보 가져오기
		GoodsDAO gdao = new GoodsDAO();
		GoodsBean goods = gdao.getGoods(num);

		// request에 정보 저장
		request.setAttribute("goods", goods);
		
		// 이동 ./goods/goods_detail.jsp
		forward.setRedirect(false);
		forward.setPath("./goods/goods_detail.jsp");		
		
		return forward;
		
	} // close method

} // close class
