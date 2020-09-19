package com.ssafy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product.do")
public class ProductServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet Product");
		
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.write("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<title>상품입력</title>\r\n" + 
				"  <style type=\"text/css\">\r\n" + 
				"     span{\r\n" + 
				"       display:inline-block;\r\n" + 
				"       width: 80px\r\n" + 
				"     }\r\n" + 
				"  </style>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"  <h1>상품을 등록 해 주세요.</h1>\r\n" + 
				"  <form method=\"post\" action=\"product.do\">\r\n" + 
				"    <input type=\"hidden\" name=\"action\" value=\"insert\">\r\n" + 
				"    <span>상 품 명:</span><input type=\"text\" name=\"name\"><br> \r\n" + 
				"	<span>상품 가격:</span><input type=\"text\" name=\"price\"><br> \r\n" + 
				"	<span>상품 설명:</span><input type=\"text\" name=\"description\"><br> \r\n" + 
				"    <button type=\"submit\">저장</button>\r\n" + 
				"    <button type=\"reset\">취소</button>\r\n" + 
				"  </form>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post Product");
		
		
	}
}
