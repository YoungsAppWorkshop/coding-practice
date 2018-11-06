package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberUpdate implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		System.out.println("MemberUpdate execute()");

		// 세션값 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		// 세션값 없으면 ./MemberLogin.me 이동
		if (id == null) {
			response.sendRedirect("./MemberLogin.me");
			
		} else { // 세션값 있으면
			// DB 정보 가져오기
			MemberDAO mdao = new MemberDAO();
			MemberBean mb = mdao.getMember(id);

			// request에 데이터 저장
			request.setAttribute("mb", mb);

			// 이동
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/updateForm.jsp");
		} // close if-else
		
		return forward;
	} // close method

} // close class
