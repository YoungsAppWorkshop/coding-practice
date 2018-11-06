package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogOutAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		System.out.println("MemberLogOutAction execute()");

		// 세션값 초기화
		HttpSession session = request.getSession();
		session.invalidate();

		// "로그아웃" 출력
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		out.println("alert('로그아웃');");
		
		// Main 페이지로 이동
		out.println("location.href='./MemberMain.me';");
		out.println("</script>");
		out.close();

		return forward;
	}

}
