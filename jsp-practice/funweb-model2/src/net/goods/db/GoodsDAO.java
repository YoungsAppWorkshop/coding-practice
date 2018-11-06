package net.goods.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.basket.db.BasketBean;

public class GoodsDAO {
	private Connection con = null;
	private StringBuffer sql = new StringBuffer();
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// DB연결 메소드
	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jspdb");
		con = ds.getConnection();

		return con;
	} // close method .getConnection()

	public List<GoodsBean> getGoodsList(String item) {

		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();

		try {

			con = getConnection();

			sql.append(" SELECT * FROM goods ");

			if (item.equals("all")) { // 모든 상품 검색
				sql.append(";");
			} else if (item.equals("best")) { // 베스트 상품 검색
				sql.append(" where best = 1;");
			} else { // 카테고리별 검색 
				sql.append(" where category = '" + item + "';");
			} // close if-else
			
			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			while (rs.next()) {

				GoodsBean gb = new GoodsBean();

				gb.setNum(rs.getInt("num"));
				gb.setCategory(rs.getString("category"));
				gb.setName(rs.getString("name"));
				gb.setContent(rs.getString("content"));
				gb.setSize(rs.getString("size"));
				gb.setColor(rs.getString("color"));
				gb.setAmount(rs.getInt("amount"));
				gb.setPrice(rs.getInt("price"));
				gb.setImage(rs.getString("image"));
				gb.setBest(rs.getInt("best"));
				gb.setDate(rs.getDate("date").toString());

				goodsList.add(gb);
			} // close while

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException ex) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {

				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {

				}
			}
		} // close try-catch-finally
		return goodsList;

	} // close method .getGoodsList()

	// 상품 정보 가져오기 메소드
	public GoodsBean getGoods(int num) {
		GoodsBean goods = null;
		try {

			con = getConnection();

			sql.append("SELECT * FROM goods WHERE num = ?;");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				goods = new GoodsBean();
				goods.setNum(rs.getInt("num"));
				goods.setCategory(rs.getString("category"));
				goods.setName(rs.getString("name"));
				goods.setContent(rs.getString("content"));
				goods.setSize(rs.getString("size"));
				goods.setColor(rs.getString("color"));
				goods.setAmount(rs.getInt("amount"));
				goods.setPrice(rs.getInt("price"));
				goods.setImage(rs.getString("image"));
				goods.setBest(rs.getInt("best"));
				goods.setDate(rs.getDate("date").toString());
			} // close if

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException ex) {

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {

				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {

				}
			}
		} // close try-catch-finally

		return goods;
	} // close method .getGoods()
	
	// 상품 수량 수정 메소드
		public void updateAmount(List<BasketBean> basketList) {
			try {
				con = getConnection();
				
				for (BasketBean aBasket : basketList) {
					String sql = "UPDATE goods SET amount = amount - ? WHERE num = ?;";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, aBasket.getB_g_amount());
					pstmt.setInt(2, aBasket.getB_g_num());
					
					pstmt.executeUpdate();		
				} // close for-each
				
			} catch (Exception e) {
				e.printStackTrace();
				
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException ex) {

					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException ex) {

					}
				}
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException ex) {

					}
				}
			} // close try-catch-finally
			
		} // close method .updateAmount()

} // close class
