package dao;
import java.util.*;

import commons.DBUtil;
import vo.*;
import java.sql.*;

public class CategoryDao {
	
	//추천 카테고리 목록
		public ArrayList<Category> selectCategoryCkList() throws Exception {
			ArrayList<Category> list = new ArrayList<Category>();
			
			DBUtil dbUtil = new DBUtil();
			Connection conn = dbUtil.getConnection();
			
			String sql = "select category_id, category_pic from category where category_ck ='Y' limit 0 ,4 ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Category c = new Category();
				c.setCategoryId(rs.getInt("category_id"));
				c.setCategoryPic(rs.getString("category_pic"));
				list.add(c);
			}
			conn.close();
			return list;
		}
		
	// 카테고리 목록 출력
	public ArrayList<Category> selectCategoryList() throws Exception {
		ArrayList<Category> list = new ArrayList<Category>();
		
		DBUtil dbUtil = new DBUtil();
		Connection conn = dbUtil.getConnection();
		
		String sql = "select category_id, category_name from category";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Category c = new Category();
			c.setCategoryId(rs.getInt("category_id"));
			c.setCategoryName(rs.getString("category_name"));
			list.add(c);
		}
		conn.close();
		return list;
	}
	
}
