package day0820;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	public void addProduct(Product product) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into product (serial,name,price,stock) vlaues (?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, product.getSerial());
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setInt(4, product.getStock());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}
	
	public List<Product> searchProduct(){
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		try {
			String sql = "select serial,name,price,stock from product";
			pstmt=conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
//				Product p = new Product(rs.getString("serial"),
//										rs.getString("name"),
//										rs.getInt("price"),
//										rs.getInt("stock"));
				list.add(new Product(rs.getString("serial"), rs.getString("name"),
										rs.getInt("price"),	rs.getInt("stock")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {//끊을때는 시작할때의 역순으로!!
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}
	
	
	public List<Product> searchProduct(String name){
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		try {
			String sql = "select serial,name,price,stock from product where name=?";
//			String sql = "select serial,name,price,stock from product where name like ?";
//			like는 contains같이 일부분만 있어도 검색가능
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getString("serial"), rs.getString("name"),
										rs.getInt("price"),	rs.getInt("stock")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {//끊을때는 시작할때의 역순으로!!
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}
	
	public List<Product> searchProduct(int price){
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = new ArrayList<Product>();
		try {
			String sql = "select serial,name,price,stock from product where price=?";
//			String sql = "select serial,name,price,stock from product where name like ?";
//			like는 contains같이 일부분만 있어도 검색가능
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, price);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getString("serial"), rs.getString("name"),
										rs.getInt("price"),	rs.getInt("stock")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {//끊을때는 시작할때의 역순으로!!
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}
	
	public List<Product> searchSerialProduct(String serial) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = null;
		try {
			String sql = "select serial,name,price,stock from product where serial=?";
//			String sql = "select serial,name,price,stock from product where name like ?";
//			like는 contains같이 일부분만 있어도 검색가능
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, serial);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Product(rs.getString("serial"), rs.getString("name"),
						rs.getInt("price"),	rs.getInt("stock")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {//끊을때는 시작할때의 역순으로!!
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}
	
	public boolean deleteProduct(String serial) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "delete product where serial=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, serial);
			
			int t=pstmt.executeUpdate();
			if(t==1) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return false;
	}
	
	public boolean modifyProduct(String serial, int price) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "update product set price=? where serial=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, price);
			pstmt.setString(2, serial);
			
			int t= pstmt.executeUpdate();
			if(t==1) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return false;
	}
}
