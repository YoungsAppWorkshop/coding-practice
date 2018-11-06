package net.member.action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberUpdateAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		System.out.println("MemberUpdateAction execute()");

		// 한글처리
		request.setCharacterEncoding("utf-8");

		// 세션값 가져오기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		// 세션값 없으면 ./MemberLogin.me 이동
		if (id == null) {
			response.sendRedirect("./MemberLogin.me");

		} else { // 세션값 있으면

			// 자바빈 객체 생성 및 정보 저장
			MemberBean mb = new MemberBean();

			mb.setId(request.getParameter("id"));
			mb.setPasswd(request.getParameter("passwd"));
			mb.setName(request.getParameter("name"));
			mb.setReg_date(new Timestamp(System.currentTimeMillis()));
			mb.setAge(Integer.parseInt(request.getParameter("age")));
			mb.setEmail(request.getParameter("email"));

			// ID, Password 체크
			MemberDAO mdao = new MemberDAO();
			int check = mdao.checkUser(mb.getId(), mb.getPasswd());
			
			if (check == 1) { // ID, Password 일치하면,
				// 회원 정보 수정
				mdao.updateMember(mb);
				
				// 수정 성공 메시지 출력 후, main.jsp로 이동
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript'>");
				out.println("alert('수정성공');");
				out.println("location.href='./MemberMain.me';");
				out.println("</script>");			
				out.close();
				
			} else if (check == 0) { // 비밀번호 틀린 경우,
				// 경고 메시지 출력 후 뒤로 가기
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript'>");
				out.println("alert('비밀번호 틀림');");
				out.println("history.back();");
				out.println("</script>");			
				out.close();
				
			} else { // 아이디 없는 경우,
				// 경고 메시지 출력 후 뒤로 가기
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript'>");
				out.println("alert('아이디 없음');");
				out.println("history.back();");
				out.println("</script>");			
				out.close();
				
			} // close inner if-else

		} // close outer if-else

		return forward;
		
	} // close method

} // close class
