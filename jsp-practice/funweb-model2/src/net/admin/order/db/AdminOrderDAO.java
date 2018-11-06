package net.admin.order.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.order.db.OrderBean;

public class AdminOrderDAO {
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

	public List<OrderBean> getAdminOrderList() {
		List<OrderBean> adminOrderList = new ArrayList<OrderBean>();

		try {
			con = getConnection();

			sql = "SELECT o_trade_num, o_g_name, o_g_amount, o_g_size, o_g_color, SUM(o_sum_money), o_trans_num, o_date, o_status, o_trade_type, o_m_id FROM g_order GROUP BY o_trade_num ORDER BY o_trade_num DESC;";

			pstmt = con.prepareStatement(sql);

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
				anOrder.setO_m_id(rs.getString("o_m_id"));
				// anOrder.setO_receive_name(rs.getString("o_receive_name"));
				// anOrder.setO_receive_addr1(rs.getString("o_receive_addr1"));
				// anOrder.setO_receive_addr2(rs.getString("o_receive_addr2"));
				// anOrder.setO_receive_mobile(rs.getString("o_receive_mobile"));
				// anOrder.setO_memo(rs.getString("o_memo"));
				anOrder.setO_sum_money(rs.getInt("SUM(o_sum_money)"));
				anOrder.setO_trade_type(rs.getString("o_trade_type"));
				// anOrder.setO_trade_payer(rs.getString("o_trade_payer"));
				// anOrder.setO_trade_date(rs.getDate("o_trade_date"));
				anOrder.setO_trans_num(rs.getString("o_trans_num"));
				anOrder.setO_date(rs.getDate("o_date"));
				anOrder.setO_status(rs.getInt("o_status"));

				adminOrderList.add(anOrder);

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
		
		return adminOrderList;

	} // close method .getOrderList()

	public List<OrderBean> getAdminOrderDetail(String trade_num) {
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
	}

	public void updateOrder(OrderBean updatedInfo) {
		try {
			con = getConnection();

			sql = "UPDATE g_order SET o_status=?, o_trans_num =? WHERE o_trade_num=?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, updatedInfo.getO_status());
			pstmt.setString(2, updatedInfo.getO_trans_num());
			pstmt.setString(3, updatedInfo.getO_trade_num());

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

		return;
	}

} // close class
