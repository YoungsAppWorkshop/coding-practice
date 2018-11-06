package net.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.db.BoardBean;
import net.board.db.BoardDAO;

public class BoardUpdateAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardUpdateAction execute()");

		// 한글 처리
		request.setCharacterEncoding("utf-8");

		// 파라미터 가져오기
		String pageNum = request.getParameter("pageNum");
		BoardBean bb = new BoardBean();
		bb.setNum(Integer.parseInt(request.getParameter("num")));
		bb.setName(request.getParameter("name"));
		bb.setPass(request.getParameter("pass"));
		bb.setSubject(request.getParameter("subject"));
		bb.setContent(request.getParameter("content"));
		
		// DB에 데이터 저장
		BoardDAO bdao = new BoardDAO();
		int check = bdao.updateBoard(bb);

		// 이동
		if (check == 1) { // check == 1 "수정성공" 이동
			// javaScript 출력 부분
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('수정성공');");
			out.println("location.href='./BoardList.bo?pageNum="+pageNum+"';");
			out.println("</script>");			
			out.close();
			
		} else if (check == 0) { // check == 0 비밀번호 틀림			
			// javaScript 출력 부분
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('비밀번호 틀림');");
			out.println("history.back();");
			out.println("</script>");			
			out.close();

		} else  { // check == -1 num없음
			// javaScript 출력 부분
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('num 없음');");
			out.println("history.back();");
			out.println("</script>");			
			out.close();

		}

		return null;
	}

}
