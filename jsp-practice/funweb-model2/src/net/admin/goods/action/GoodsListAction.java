package net.admin.goods.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.admin.goods.db.GoodsBean;
import net.admin.goods.db.GoodsDAO;

public class GoodsListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		System.out.println("GoodsListAction execute()");
		
		// DB 작업 AdminGoodsDAO
		GoodsDAO agdao = new GoodsDAO();
		
		// List goodsList = 메서드 getGoodsList()
		List<GoodsBean> goodsList = agdao.getGoodsList(); 
		
		// request 저장 "goodsList", goodsList
		request.setAttribute("goodsList", goodsList);
		
		// 이동 ./admingoods/admin_goods_list.jsp
		forward.setRedirect(false); 
		forward.setPath("./adminGoods/admin_goods_list.jsp");
		
		return forward;
		
	} // close method

} // close class
