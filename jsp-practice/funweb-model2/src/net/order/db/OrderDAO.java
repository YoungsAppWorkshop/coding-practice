package net.order.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.basket.db.BasketBean;
import net.goods.db.GoodsBean;

public class OrderDAO {
	private Connection con = null;
	private String sql;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// DB연결 메소드
	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jspdb");
		con = ds.getConnection();

		return con;
	} // close method .getConnection()

	// 주문 추가 메소드
	public void addOrder(OrderBean anOrder, List<BasketBean> basketList, List<GoodsBean> goodsList) {
		int o_num = 0; // 주문 인덱스 번호
		int trade_num = 0; // 주문번호
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		try {

			// DB 연결
			con = getConnection();

			// 주문 번호 인덱스 번호(o_num) 구하기
			sql = "SELECT MAX(o_num) AS maxOrderNum FROM g_order;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			o_num = rs.getInt("maxOrderNum") + 1;

			// 주문번호(trade_num) 구하기
			trade_num = o_num; // 주문번호 : 년월일-번호 20161020-1

			// DB에 입력
			for (int i = 0; i < basketList.size(); i++) {

				BasketBean aBasket = basketList.get(i);
				GoodsBean aGoods = goodsList.get(i);

				// DB에 입력
				sql = "INSERT INTO g_order(o_num,o_trade_num,o_g_num,o_g_name,o_g_amount,o_g_size,o_g_color,o_m_id,o_receive_name,o_receive_addr1,o_receive_addr2,o_receive_phone,o_receive_mobile,o_memo,o_sum_money,o_trade_type,o_trade_payer,o_trade_date,o_trans_num,o_date,o_status) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?,now(),?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, o_num);
				pstmt.setString(2, sdf.format(cal.getTime()) + "-" + trade_num);
				pstmt.setInt(3, aBasket.getB_g_num());
				pstmt.setString(4, aGoods.getName());
				pstmt.setInt(5, aBasket.getB_g_amount());
				pstmt.setString(6, aBasket.getB_g_size());
				pstmt.setString(7, aBasket.getB_g_color());
				pstmt.setString(8, anOrder.getO_m_id());
				pstmt.setString(9, anOrder.getO_receive_name());
				pstmt.setString(10, anOrder.getO_receive_addr1());
				pstmt.setString(11, anOrder.getO_receive_addr2());
				pstmt.setString(12, anOrder.getO_receive_phone());
				pstmt.setString(13, anOrder.getO_receive_mobile());
				pstmt.setString(14, anOrder.getO_memo());
				pstmt.setInt(15, aBasket.getB_g_amount() * aGoods.getPrice());
				pstmt.setString(16, "카드결재");
				pstmt.setString(17, anOrder.getO_trade_payer());
				pstmt.setString(18, anOrder.getO_trans_num()); // 운송장번호
				pstmt.setInt(19, 0); // 0 : 상품 준비 중
				pstmt.executeUpdate();

				o_num++; // 주문 인덱스 번호 증가

			} // close for loop

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

	} // close method .addOrder()

	public List<OrderBean> getOrderList(String sessionId) {
		List<OrderBean> orderList = new ArrayList<OrderBean>();

		try {
			con = getConnection();

			// sql = "SELECT * FROM g_order WHERE o_m_id = ?;";
			sql = "SELECT o_trade_num,o_g_name,o_trade_type,o_g_amount,o_g_size,o_g_color,SUM(o_sum_money),o_status,o_date,o_trans_num FROM g_order WHERE o_m_id=? GROUP BY o_trade_num ORDER BY o_trade_num desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sessionId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				OrderBean anOrder = new OrderBean();

				// anOrder.setO_num(rs.getInt("o_num"));
				anOrder.setO_trade_num(rs.getString("o_trade_num"));
				// anOrder.setO_g_num(rs.getInt("o_g_num"));
				anOrder.setO_g_name(rs.getString("o_g_name"));
				anOrder.setO_g_amount(rs.getInt("o_g_amount"));
				anOrder.setO_g_size(rs.getString("o_g_size"));
				anOrder.setO_g_color(rs.getString("o_g_color"));
				// anOrder.setO_m_id(rs.getString("o_m_id"));
				// anOrder.setO_receive_name(rs.getString("o_receive_name"));
				// anOrder.setO_receive_addr1(rs.getString("o_receive_addr1"));
				// anOrder.setO_receive_addr2(rs.getString("o_receive_addr2"));
				// anOrder.setO_receive_mobile(rs.getString("o_receive_mobile"));
				// anOrder.setO_memo(rs.getString("o_memo"));
				// anOrder.setO_sum_money(rs.getInt("o_sum_money"));
				anOrder.setO_sum_money(rs.getInt("SUM(o_sum_money)"));
				anOrder.setO_trade_type(rs.getString("o_trade_type"));
				// anOrder.setO_trade_payer(rs.getString("o_trade_payer"));
				// anOrder.setO_trade_date(rs.getDate("o_trade_date"));
				anOrder.setO_trans_num(rs.getString("o_trans_num"));
				anOrder.setO_date(rs.getDate("o_date"));
				anOrder.setO_status(rs.getInt("o_status"));

				orderList.add(anOrder);

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
		return orderList;

	} // close method .getOrderList()

	public List<OrderBean> getOrderDetail(String trade_num) {
		List<OrderBean> orderDetailList = new ArrayList<OrderBean>();

		try {
			con = getConnection();

			sql = "SELECT * FROM g_order WHERE o_trade_num = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, trade_num);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				OrderBean anOrder = new OrderBean();

				anOrder.setO_num(rs.getInt("o_num"));
				anOrder.setO_trade_num(rs.getString("o_trade_num"));
				anOrder.setO_g_num(rs.getInt("o_g_num"));
				anOrder.setO_g_name(rs.getString("o_g_name"));
				anOrder.setO_g_amount(rs.getInt("o_g_amount"));
				anOrder.setO_g_size(rs.getString("o_g_size"));
				anOrder.setO_g_color(rs.getString("o_g_color"));
				anOrder.setO_m_id(rs.getString("o_m_id"));
				anOrder.setO_receive_name(rs.getString("o_receive_name"));
				anOrder.setO_receive_addr1(rs.getString("o_receive_addr1"));
				anOrder.setO_receive_addr2(rs.getString("o_receive_addr2"));
				anOrder.setO_receive_mobile(rs.getString("o_receive_mobile"));
				anOrder.setO_memo(rs.getString("o_memo"));
				anOrder.setO_sum_money(rs.getInt("o_sum_money"));
				anOrder.setO_trade_type(rs.getString("o_trade_type"));
				anOrder.setO_trade_payer(rs.getString("o_trade_payer"));
				anOrder.setO_trade_date(rs.getDate("o_trade_date"));
				anOrder.setO_trans_num(rs.getString("o_trans_num"));
				anOrder.setO_date(rs.getDate("o_date"));
				anOrder.setO_status(rs.getInt("o_status"));

				orderDetailList.add(anOrder);

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

		return orderDetailList;
	} // close method .getOrderDetail()

} // close class
