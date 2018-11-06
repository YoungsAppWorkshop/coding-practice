package net.admin.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.admin.goods.db.GoodsBean;
import net.admin.goods.db.GoodsDAO;

public class GoodsModify implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		System.out.println("GoodsModify execute()");
		
		// 파라미터 가져오기
		int num = Integer.parseInt(request.getParameter("num"));
		
		// 데이터 가져오기
		GoodsDAO agdao = new GoodsDAO();
		GoodsBean goods = agdao.getGoods(num);
		
		// request에 데이터 저장
		request.setAttribute("num", num);
		request.setAttribute("goodsBean", goods);
		
		// 이동
		forward.setRedirect(false);
		forward.setPath("./adminGoods/admin_goods_modify.jsp");
		
		return forward;
	} // close method

} // close class
