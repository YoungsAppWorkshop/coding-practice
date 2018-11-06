package net.member.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberJoinAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		System.out.println("MemberJoinAction execute()");

		// 한글처리
		request.setCharacterEncoding("utf-8");

		// 자바빈 객체 생성 및 정보 저장
		MemberBean mb = new MemberBean();
		mb.setId(request.getParameter("id"));
		mb.setPasswd(request.getParameter("passwd"));
		mb.setName(request.getParameter("name"));
		mb.setReg_date(new Timestamp(System.currentTimeMillis()));
		mb.setAge(Integer.parseInt(request.getParameter("age")));
		mb.setEmail(request.getParameter("email"));

		// DB작업 객체 생성 및 정보 DB에 저장
		MemberDAO mdao = new MemberDAO();
		mdao.insertMember(mb);

		// 이동
		forward.setRedirect(true); 
		forward.setPath("./MemberLogin.me");
		
		return forward;
	}

}
