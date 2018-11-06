package net.admin.goods.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.admin.goods.db.GoodsBean;
import net.admin.goods.db.GoodsDAO;

public class GoodsModifyAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GoodsModifyAction execute()");

		// 한글 처리
		request.setCharacterEncoding("utf-8");

		// 파라미터 가져오기
		GoodsBean goods = new GoodsBean();
		goods.setNum(Integer.parseInt(request.getParameter("num")));
		goods.setCategory(request.getParameter("category"));
		goods.setName(request.getParameter("name"));
		goods.setContent(request.getParameter("content"));
		goods.setSize(request.getParameter("size"));
		goods.setColor(request.getParameter("color"));
		goods.setAmount(Integer.parseInt(request.getParameter("amount")));
		goods.setPrice(Integer.parseInt(request.getParameter("price")));
		goods.setBest(Integer.parseInt(request.getParameter("best")));

		// DB에 데이터 저장
		GoodsDAO agdao = new GoodsDAO();
		int check = agdao.modifyGoods(goods);

		// 이동
		if (check == 1) { // check == 1 "수정성공" 이동
			// javaScript 출력 부분
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('수정성공');");
			out.println("location.href='./GoodsList.ag';");
			out.println("</script>");
			out.close();

		} else { // check == 0 수정실패
			// javaScript 출력 부분
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('수정 실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();

		} // close if-else

		return null;
	} // close method

} // close class
