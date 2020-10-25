package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repository.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO dao;
	
	@Override
	public void regist(Product p) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(Product p) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(String id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Product find(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
