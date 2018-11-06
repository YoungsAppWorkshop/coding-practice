package net.basket.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.basket.db.BasketDAO;

public class BasketDeleteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		System.out.println("BasketDeleteAction execute()");

		// 세션값 가져오기
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("id");

		if (sessionId == null) { // 세션값 없으면 로그인페이지 이동
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");

		} else { // 세션값 있으면 삭제 진행
			
			// 파라미터 가져오기
			int basketNumber = Integer.parseInt(request.getParameter("num"));
			System.out.println("Echo : " + basketNumber);
			
			// DB에서 장바구니 정보 삭제
			BasketDAO bdao = new BasketDAO();
			int check = bdao.deleteBasket(basketNumber);
			
			// 이동
			if (check == 1) { // check == 1 "삭제 성공" 이동
				// javaScript 출력 부분
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript'>");
				out.println("alert('삭제 성공');");
				out.println("location.href='./BasketList.ba';");
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
			
		}
		return forward;
	} // close method

} // close class
