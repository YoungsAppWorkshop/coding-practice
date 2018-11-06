package net.admin.order.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminOrderFrontController extends HttpServlet {

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AdminOrderFrontController doProcess()");

		String requestURI = request.getRequestURI();
		System.out.println(requestURI);

		String contextPath = request.getContextPath();
		System.out.println(contextPath);

		String command = requestURI.substring(contextPath.length());
		System.out.println(command);

		ActionForward forward = null;
		Action action = null;

		// 주소값 비교
		if (command.equals("/AdminOrderList.ao")) {
			action = new AdminOrderListAction();

			try {
				forward = action.excute(request, response);
			} catch (Exception e) {

			} // close try-catch

		} else if (command.equals("/AdminOrderDetail.ao")) {

			action = new AdminOrderDetailAction();

			try {
				forward = action.excute(request, response);
			} catch (Exception e) {

			} // close try-catch

		} else if (command.equals("/AdminOrderModify.ao")) {
			action = new AdminOrderModifyAction();

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
