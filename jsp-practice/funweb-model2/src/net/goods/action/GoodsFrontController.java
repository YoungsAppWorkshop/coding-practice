package net.goods.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodsFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AdminGoodsFrontController doProcess()");
		// 가상의 주소 전체주소 URL
		// http://localhost:8080/Model2/GoodsList.go
		// 가상의 주소 URI /Model2/GoodsList.go
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
		if (command.equals("/GoodsList.go")) {
			action = new GoodsListAction();

			try {
				forward = action.excute(request, response);
			} catch (Exception e) {

			} // close try-catch

		} else if (command.equals("/GoodsDetail.go")) {
			action = new GoodsDetailAction();

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

	} // close method

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	} // close method

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	} // close method

} // close class
