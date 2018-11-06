package net.goods.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.goods.db.GoodsBean;
import net.goods.db.GoodsDAO;

public class GoodsListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		System.out.println("GoodsList execute()");

		String item = request.getParameter("item");
		item = (item == null) ? "all" : item;
		
		// DB 작업 GoodsDAO
		GoodsDAO gdao = new GoodsDAO();

		// List goodsList = 메서드 getGoodsList()
		List<GoodsBean> goodsList = gdao.getGoodsList(item);

		// request 저장 "goodsList", goodsList
		request.setAttribute("goodsList", goodsList);

		// 이동 ./goods/goods_list.jsp
		forward.setRedirect(false);
		forward.setPath("./goods/goods_list.jsp");

		return forward;

	} // close method

} // close class
