package net.admin.goods.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.admin.goods.db.GoodsDAO;

public class GoodsDeleteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GoodsDeleteAction execute()");

		// 파라미터 가져오기
		int num = Integer.parseInt(request.getParameter("num"));

		// DB에서 데이터 삭제
		GoodsDAO agdao = new GoodsDAO();
		int check = agdao.deleteGoods(num);

		// 이동
		if (check == 1) { // check == 1 "삭제 성공" 이동
			// javaScript 출력 부분
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('삭제 성공');");
			out.println("location.href='./GoodsList.ag';");
			out.println("</script>");
			out.close();

		} else { // check == 0 삭제 실패
			// javaScript 출력 부분
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('삭제 실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();

		} // close if-else
		return null;
	}

}
