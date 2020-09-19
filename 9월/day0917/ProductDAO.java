package com.ssafy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public boolean insert(Product product) {
		conn = DBUtil.getConnection();
		String sql = "insert into product (name,price,description) "
				+ "values (?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getDescription());
			
			int resultRowCnt = pstmt.executeUpdate();
			if(resultRowCnt==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return false;
	}
	
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<Product>();
		conn = DBUtil.getConnection();
		String sql = "select name,price,description from product";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getString("name"), 
										rs.getInt("price"), 
										rs.getString("description")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}
}
