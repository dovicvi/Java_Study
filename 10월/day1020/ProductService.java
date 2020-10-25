package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.Product;

public interface ProductService {
	
	void regist(Product p)throws SQLException;
	void modify(Product p)throws SQLException;
	void modify(String id)throws SQLException;
	
	Product find(String id)throws SQLException;
	List<Product> findAll()throws SQLException;
}
