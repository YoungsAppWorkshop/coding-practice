package net.basket.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.goods.db.GoodsBean;

public class BasketDAO {
	private Connection con = null;
	private String sql = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// DB연결 메소드
	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jspdb");
		con = ds.getConnection();

		return con;
	} // close method .getConnection()

	public void addBasket(BasketBean aBasket) {
		int b_num; // 장바구니 번호
		try {
			// DB 연결
			con = getConnection();

			// 장바구니 번호(b_num) 구하기
			sql = "SELECT MAX(b_num) AS maxNum FROM basket;";
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			rs.next();
			b_num = rs.getInt("maxNum") + 1;

			// DB에 입력
			sql = "INSERT INTO basket(b_num, b_m_id, b_g_num, b_g_amount, b_g_size, b_g_color, b_date) VALUES (?,?,?,?,?,?,now());";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_num);
			pstmt.setString(2, aBasket.getB_m_id());
			pstmt.setInt(3, aBasket.getB_g_num());
			pstmt.setInt(4, aBasket.getB_g_amount());
			pstmt.setString(5, aBasket.getB_g_size());
			pstmt.setString(6, aBasket.getB_g_color());

			pstmt.executeUpdate();

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

	} // close method .addBasket()

	/******************
	 * 직접 구현한 부분 ***************************** public Vector<Object>
	 * getBasketList(String id) {
	 * 
	 * Vector<Object> basketVector = new Vector<Object>();
	 * 
	 * try {
	 * 
	 * con = getConnection();
	 * 
	 * sql = " SELECT * FROM basket, goods WHERE b_m_id = ? AND b_g_num = num
	 * ;"; pstmt = con.prepareStatement(sql); pstmt.setString(1, id);
	 * 
	 * rs = pstmt.executeQuery();
	 * 
	 * while (rs.next()) {
	 * 
	 * BasketBean aBasket = new BasketBean();
	 * 
	 * 
	 * aBasket.setB_num(rs.getInt("b_num"));
	 * aBasket.setB_m_id(rs.getString("b_m_id"));
	 * aBasket.setB_g_num(rs.getInt("b_g_num"));
	 * aBasket.setB_g_amount(rs.getInt("b_g_amount"));
	 * aBasket.setB_g_size(rs.getString("b_g_size"));
	 * aBasket.setB_g_color(rs.getString("b_g_color"));
	 * 
	 * basketVector.add(aBasket);
	 * 
	 * GoodsBean aGoods = new GoodsBean();
	 * 
	 * aGoods.setNum(rs.getInt("num"));
	 * aGoods.setCategory(rs.getString("category"));
	 * aGoods.setName(rs.getString("name"));
	 * aGoods.setContent(rs.getString("content"));
	 * aGoods.setSize(rs.getString("size"));
	 * aGoods.setColor(rs.getString("color"));
	 * aGoods.setAmount(rs.getInt("amount"));
	 * aGoods.setPrice(rs.getInt("price"));
	 * aGoods.setImage(rs.getString("image"));
	 * aGoods.setBest(rs.getInt("best"));
	 * aGoods.setDate(rs.getDate("date").toString());
	 * 
	 * basketVector.add(aGoods);
	 * 
	 * } // close while
	 * 
	 * } catch (Exception e) { e.printStackTrace();
	 * 
	 * } finally { if (pstmt != null) { try { pstmt.close(); } catch
	 * (SQLException ex) {
	 * 
	 * } } if (con != null) { try { con.close(); } catch (SQLException ex) {
	 * 
	 * } } if (rs != null) { try { rs.close(); } catch (SQLException ex) {
	 * 
	 * } } } // close try-catch-finally return basketVector;
	 * 
	 * } // close method .getBasketList()
	 ****************************************************************/

	// 수업시간에 구현한 내용
	public Vector<Object> getBasketList(String id) {

		Vector<Object> basketVector = new Vector<Object>();
		List<BasketBean> basketList = new ArrayList<BasketBean>();
		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();

		try {

			con = getConnection();

			sql = " SELECT * FROM basket, goods WHERE b_m_id = ? AND b_g_num = num ;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				BasketBean aBasket = new BasketBean();

				aBasket.setB_num(rs.getInt("b_num"));
				aBasket.setB_m_id(rs.getString("b_m_id"));
				aBasket.setB_g_num(rs.getInt("b_g_num"));
				aBasket.setB_g_amount(rs.getInt("b_g_amount"));
				aBasket.setB_g_size(rs.getString("b_g_size"));
				aBasket.setB_g_color(rs.getString("b_g_color"));

				basketList.add(aBasket);

				GoodsBean aGoods = new GoodsBean();

				aGoods.setNum(rs.getInt("num"));
				aGoods.setCategory(rs.getString("category"));
				aGoods.setName(rs.getString("name"));
				aGoods.setContent(rs.getString("content"));
				aGoods.setSize(rs.getString("size"));
				aGoods.setColor(rs.getString("color"));
				aGoods.setAmount(rs.getInt("amount"));
				aGoods.setPrice(rs.getInt("price"));
				aGoods.setImage(rs.getString("image"));
				aGoods.setBest(rs.getInt("best"));
				aGoods.setDate(rs.getDate("date").toString());

				goodsList.add(aGoods);

			} // close while

			basketVector.add(basketList);
			basketVector.add(goodsList);

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
		return basketVector;

	} // close method .getBasketList()

	// 상품 삭제 메소드
	public int deleteBasket(int num) {
		int check = 0; // 삭제 실패 가정
		try {

			con = getConnection();

			sql = "DELETE FROM basket WHERE b_num = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			pstmt.executeUpdate();
			check = 1; // 삭제 성공

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
		return check;
	} // close method .deleteBasket(int num)

	// 상품 삭제 메소드
	public int deleteBasket(String id) {
		int check = 0; // 삭제 실패 가정
		try {

			con = getConnection();

			sql = "DELETE FROM basket WHERE b_m_id = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			pstmt.executeUpdate();
			check = 1; // 삭제 성공

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
		return check;
		
	} // close method .deleteBasket(String id)

} // close class
