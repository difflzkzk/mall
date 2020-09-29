package dao;
import commons.DBUtil;
import vo.Orders;
import java.sql.*;
import java.util.*;

public class OrdersDao {
	public ArrayList<Orders> selectOrdersListByListEmail(String memberEmail) throws Exception{
		return null;
	}
	public void insertOrders(Orders orders) throws Exception{
		DBUtil dbUtil =new DBUtil();
		Connection conn = dbUtil.getConnection();
		String sql = "insert into orders(product_id,orders_amount,orders_price,member_email,orders_addr,orders_state,orders_date) values(?,?,?,?,?,'결제완료',now())";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, orders.getProductId());
		stmt.setInt(2, orders.getOrdersAmount());
		stmt.setInt(3, orders.getOrdersPrice());
		stmt.setString(4, orders.getMemberEmail());
		stmt.setNString(5, orders.getOrdersAddr());
		
	
		stmt.executeLargeUpdate();
		conn.close();
	}
}
