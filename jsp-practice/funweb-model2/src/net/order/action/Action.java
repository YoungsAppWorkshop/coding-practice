package net.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	// static final 멤버변수
	// 추상메소드
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
