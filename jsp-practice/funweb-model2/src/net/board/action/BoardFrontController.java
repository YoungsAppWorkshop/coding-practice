package net.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardFrontController extends HttpServlet {
	// 서버 실행
	// 브라우저 가상의 주소
	// http://localhost:8080/Model2/BoardWrite.bo

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("BoardFrontController doProcess()");

		// 가상의 주소 전체주소 URL
		// http://localhost:8080/Model2/BoardWrite.bo
		// 가상의 주소 URI /Model2/BoardWrite.bo
		// 경로주소(contextPath) /Model2

		String requestURI = request.getRequestURI();
		System.out.println(requestURI);

		String contextPath = request.getContextPath();
		System.out.println(contextPath);

		String command = requestURI.substring(contextPath.length());
		System.out.println(command);

		ActionForward forward = null;
		Action action = null;
		
		// 주소값 비교
		if (command.equals("/BoardWrite.bo")) {
			// 현위치 . 가상주소위치 WebContents 위치
			// 이동 board/write.jsp
			// jsp 이동 
			// 1. response.sendRedirect() : 주소 노출됨/보안상 문제
			// response.sendRedirect("./board/write.jsp");

			// 2. forward() A(request) 정보 가지고 이동 -> B
			// 주소줄 A주소 -> 실행화면 B 화면
			// RequestDispatcher dispatcher =
			// request.getRequestDispatcher("./board/write.jsp");
			// dispatcher.forward(request, response);
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./board/write.jsp");

		} else if (command.equals("/BoardWriteAction.bo")) {
			// http://localhost:8080/Model2/BoardWriteAction.bo
			// 인터페이스 - 자바파일의 틀을 제시
			// writePro.jsp 해당내용 자바파일에 메소드 정의
			// 자바객체 생성 메소드 호출

			action = new BoardWriteAction();

			try {
				// 부모에서 오버라이딩한 메소드 호출
				forward = action.excute(request, response);
			} catch (Exception e) {

			} // close try-catch

		} else if (command.equals("/BoardList.bo")) {
			// http://localhost:8080/Model2/BoardList.bo

			action = new BoardListAction();

			try {
				forward = action.excute(request, response);
			} catch (Exception e) {

			} // close try-catch

		} else if (command.equals("/BoardContent.bo")) {
			// http://localhost:8080/Model2/BoardContent.bo

			action = new BoardContentAction();

			try {
				forward = action.excute(request, response);
			} catch (Exception e) {

			} // close try-catch

		} else if (command.equals("/BoardUpdate.bo")) {

			action = new BoardUpdate();

			try {
				forward = action.excute(request, response);
			} catch (Exception e) {

			} // close try-catch

		} else if (command.equals("/BoardUpdateAction.bo")) {

			action = new BoardUpdateAction();

			try {
				forward = action.excute(request, response);
			} catch (Exception e) {

			} // close try-catch

		} else if (command.equals("/BoardDelete.bo")) {

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./board/delete.jsp");
			
		} else if (command.equals("/BoardDeleteAction.bo")) {

			action = new BoardDeleteAction();

			try {
				forward = action.excute(request, response);
			} catch (Exception e) {

			} // close try-catch
			
		} else if (command.equals("/BoardReWrite.bo")) {

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./board/reWrite.jsp");
			
		} else if (command.equals("/BoardReWriteAction.bo")) {
			
			action = new BoardReWriteAction();

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
