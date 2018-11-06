package net.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.action.BoardWriteAction;

public class MemberFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("MemberFrontController doProcess()");

		// 가상의 주소 전체주소 URL
		// http://localhost:8080/Model2/MemberJoin.me
		// 가상주소 /MemberJoin.me 주소 뽑아오기

		// 가상의 주소 URI : /Model2/MemberJoin.me
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);

		// 경로주소(contextPath) : /Model2
		String contextPath = request.getContextPath();
		System.out.println(contextPath);

		String command = requestURI.substring(contextPath.length());
		System.out.println(command);

		// 주소값 비교
		ActionForward forward = null;
		Action action = null;

		if (command.equals("/MemberJoin.me")) {

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/insertForm.jsp");

		} else if (command.equals("/MemberJoinAction.me")) {
			
			action = new MemberJoinAction();

			try {
				forward = action.excute(request, response);
			} catch (Exception e) {

			} // close try-catch
			
		} else if (command.equals("/MemberLogin.me")) {
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/logInForm.jsp");

		} else if (command.equals("/MemberLogInAction.me")) {
			
			action = new MemberLogInAction();

			try {
				forward = action.excute(request, response);
			} catch (Exception e) {

			} // close try-catch
			
		} else if (command.equals("/MemberMain.me")) {		
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/main.jsp");
			
		} else if (command.equals("/MemberLogout.me")) {		
			
			action = new MemberLogOutAction();

			try {
				forward = action.excute(request, response);
			} catch (Exception e) {

			} // close try-catch
			
		} else if (command.equals("/MemberUpdate.me")) {		
			
			action = new MemberUpdate();

			try {
				forward = action.excute(request, response);
			} catch (Exception e) {

			} // close try-catch
			
		} else if (command.equals("/MemberUpdateAction.me")) {		
			
			action = new MemberUpdateAction();

			try {
				forward = action.excute(request, response);
			} catch (Exception e) {

			} // close try-catch
			
		} // close if-else

		// 이동
		if (forward != null) {
			if (forward.isRedirect()) { // true sendRedirect()
				response.sendRedirect(forward.getPath());

			} else { // false forward(), .jsp
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);

			} // close if-else

		} // close if

	} // close method .doProcess

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	} // close method .doGet

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	} // close method .doPost

}
