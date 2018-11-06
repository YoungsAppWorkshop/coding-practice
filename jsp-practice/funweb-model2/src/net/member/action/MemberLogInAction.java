package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberDAO;

public class MemberLogInAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		System.out.println("MemberLogInAction execute()");

		// 한글처리
		request.setCharacterEncoding("utf-8");

		// 파라미터 가져오기
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");

		// DB에서 id/passwd 체크
		MemberDAO mdao = new MemberDAO();
		int check = mdao.checkUser(id, passwd);

		// 이동
		if (check == 1) { // check == 1 : 세션값 생성
			
			// 세션값 생성
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			
			// 이동 ./MemberMain.me
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./MemberMain.me");

		} else if (check == 0) { // check == 0 비밀번호 틀림
			// javaScript 출력 부분
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('비밀번호 틀림');");
			out.println("history.back();");
			out.println("</script>");
			out.close();

		} else { // check == -1 아이디 없음
			// javaScript 출력 부분
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('아이디 없음');");
			out.println("history.back();");
			out.println("</script>");
			out.close();

		}

		return forward;
	}

}
