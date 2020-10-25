package com.ssafy.model.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	//DB관련객체 주입
	
	@Override
	public void insert(Product p) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Product p) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Product select(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
