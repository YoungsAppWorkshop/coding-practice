package net.admin.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.admin.goods.db.GoodsBean;
import net.admin.goods.db.GoodsDAO;

public class GoodsAddAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		System.out.println("GoodsAddAction execute()");

		// MultipartReauest multi 객체 생성
		String realPath = request.getSession().getServletContext().getRealPath("/upload");
		// Echo :: System.out.println(realPath);
		
		int maxSize = 5 * 1024 * 1024; // 5M
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "utf-8",
				new DefaultFileRenamePolicy());
		
		// 이미지 파일 경로 저장
		String image = multi.getFilesystemName("file1") + "," + multi.getFilesystemName("file2") + ","
				+ multi.getFilesystemName("file3") + "," + multi.getFilesystemName("file4");

		// 자바빈 객체 생성 및 정보 저장 : net.admin.goods.db.GoodsBean
		GoodsBean gb = new GoodsBean();
		gb.setCategory(multi.getParameter("category"));
		gb.setName(multi.getParameter("name"));
		gb.setContent(multi.getParameter("content"));
		gb.setSize(multi.getParameter("size"));
		gb.setColor(multi.getParameter("color"));
		gb.setAmount(Integer.parseInt(multi.getParameter("amount")));
		gb.setPrice(Integer.parseInt(multi.getParameter("price")));
		gb.setBest(0);
		gb.setImage(image);

		// DB작업 객체 생성 및 정보 DB에 저장 : net.admin.goods.db.GoodsDAO
		GoodsDAO gdao = new GoodsDAO();
		gdao.insertGoods(gb);

		// 이동 ./GoodsList.ag
		forward.setRedirect(true);
		forward.setPath("./GoodsList.ag");

		return forward;
	} // close method

} // close class
