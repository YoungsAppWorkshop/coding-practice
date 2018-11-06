package net.admin.goods.db;

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
	private String sql = "";
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// DB연결 메소드
	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jspdb");
		con = ds.getConnection();

		return con;
	} // close method .getConnection()

	// 관리자 상품 추가 메소드
	public void insertGoods(GoodsBean goods) {
		int num; // DB 상품번호
		try {
			// DB 연결
			con = getConnection();

			// 글 번호(num) 구하기
			sql = "SELECT MAX(num) AS maxNum FROM goods;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			num = rs.getInt("maxNum") + 1;

			// DB에 입력
			sql = "INSERT INTO goods(num, category, name, content, size, color, amount, price, image, best, date) VALUES (?,?,?,?,?,?,?,?,?,?,now());";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, goods.getCategory());
			pstmt.setString(3, goods.getName());
			pstmt.setString(4, goods.getContent());
			pstmt.setString(5, goods.getSize());
			pstmt.setString(6, goods.getColor());
			pstmt.setInt(7, goods.getAmount());
			pstmt.setInt(8, goods.getPrice());
			pstmt.setString(9, goods.getImage());
			pstmt.setInt(10, goods.getBest());

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

	} // close method .insertGoods()

	public List<GoodsBean> getGoodsList() {

		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();

		try {

			con = getConnection();

			sql = "SELECT * FROM goods;";
			pstmt = con.prepareStatement(sql);

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
			}

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
		}
		return goodsList;

	} // close method .getGoodsList()

	// 상품 정보 가져오기 메소드
	public GoodsBean getGoods(int num) {
		GoodsBean goods = null;
		try {

			con = getConnection();

			sql = "SELECT * FROM goods WHERE num = ?;";
			pstmt = con.prepareStatement(sql);
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

	// 상품 수정 메소드
	public int modifyGoods(GoodsBean goods) {
		int check = 0; // 수정 실패 가정
		try {
			con = getConnection();

			sql = "UPDATE goods SET category=?, name=?, content=?, size=?, color=?, amount=?, price=?, best=? WHERE num = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goods.getCategory());
			pstmt.setString(2, goods.getName());
			pstmt.setString(3, goods.getContent());
			pstmt.setString(4, goods.getSize());
			pstmt.setString(5, goods.getColor());
			pstmt.setInt(6, goods.getAmount());
			pstmt.setInt(7, goods.getPrice());
			pstmt.setInt(8, goods.getBest());
			pstmt.setInt(9, goods.getNum());

			pstmt.executeUpdate();

			check = 1; // 수정 성공

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
	} // close method .modifyGoods()

	// 상품 삭제 메소드
	public int deleteGoods(int num) {
		int check = 0; // 삭제 실패 가정
		try {

			con = getConnection();

			sql = "DELETE FROM goods WHERE num = ?;";
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
	} // close method .deleteGoods()


} // close class
