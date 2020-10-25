package com.ssafy.model.repository;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.Product;

public interface ProductDAO {
	void insert(Product p)throws SQLException;
	void update(Product p)throws SQLException;
	void delete(String id)throws SQLException;
	Product select(String id)throws SQLException;
	List<Product> selectAll()throws SQLException;
}
