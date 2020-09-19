package com.ssafy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/Calc.do")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("get계산기");
//		//브라우저 출력객체
//		//계산기폼을 출력
////		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.setContentType("text/html; charset=UTF-8");
//		
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head>");
////		out.println("<meta http-equiv=\"Content-type\" content=\"text/html; charset=UTF-8\">");
//		out.println("<title>계산기</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h3>서블릿 계산기</h3>");
//		out.println("<hr>");
//		out.println("<form method=\"post\">");
//		out.println("<input type=\"text\" name=\"su1\">");
//		out.println("<select name=\"oper\">");
//		out.println("<option>+</option>");
//		out.println("<option>-</option>");
//		out.println("<option>*</option>");
//		out.println("<option>/</option>");
//		out.println("</select>");
//		out.println("<input type=\"text\" name=\"su2\">");
//		out.println("<button type=\"submit\">계산</button>");
//		out.println("</form>");
//		out.println("</body>");
//		out.println("</html>");
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("post계산기");
//		//계산기폼을 통해 전달된 데이터 분석
//		int su1 = Integer.parseInt( request.getParameter("su1"));
//		int su2 = Integer.parseInt( request.getParameter("su2"));
//		String oper = request.getParameter("oper");
//		
//		//계산기 객체 생성
//		Calculator calc = new Calculator(su1, su2, oper);
//		//계산결과 얻기
//		String result = calc.getResultStr();
//		
//		response.setCharacterEncoding("UTF-8");
//		//브라우저 출력개체
//		PrintWriter out = response.getWriter();
//		
//		//계산기폼을 출력
//		out.write("<!DOCTYPE html>\r\n" + 
//				"<html>\r\n" + 
//				"<head>\r\n" + 
//				"<meta charset=\"UTF-8\">\r\n" + 
//				"<title>서블릿계산기</title>\r\n" + 
//				"</head>\r\n" + 
//				"<body>\r\n" + 
//				"  <h3>서블릿계산기</h3>\r\n" + 
//				"  <hr>\r\n" + 
//				"  <form method=\"post\">\r\n" + 
//				"    <input type=\"text\" size=\"4\" name=\"su1\">\r\n" + 
//				"    <select name=\"oper\">\r\n" + 
//				"      <option>+</option>\r\n" + 
//				"      <option>-</option>\r\n" + 
//				"      <option>*</option>\r\n" + 
//				"      <option>/</option>\r\n" + 
//				"    </select>\r\n" + 
//				"    <input type=\"text\" size=\"4\" name=\"su2\">\r\n" + 
//				"    <button type=\"submit\">계산</button>\r\n" + 
//				"  </form>\r\n" + 
//		//계산결과 출력
//				"<hr>"+result+
//				
//				"</body>\r\n" + 
//				"</html>");
////		doGet(request, response);
//	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service계산기");
		
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		//계산기폼을 출력
				out.write("<!DOCTYPE html>\r\n" + 
						"<html>\r\n" + 
						"<head>\r\n" + 
						"<meta charset=\"UTF-8\">\r\n" + 
						"<title>서블릿계산기</title>\r\n" + 
						"</head>\r\n" + 
						"<body>\r\n" + 
						"  <h3>서블릿계산기</h3>\r\n" + 
						"  <hr>\r\n" + 
						"  <form method=\"post\">\r\n" + 
						"    <input type=\"text\" size=\"4\" name=\"su1\">\r\n" + 
						"    <select name=\"oper\">\r\n" + 
						"      <option>+</option>\r\n" + 
						"      <option>-</option>\r\n" + 
						"      <option>*</option>\r\n" + 
						"      <option>/</option>\r\n" + 
						"    </select>\r\n" + 
						"    <input type=\"text\" size=\"4\" name=\"su2\">\r\n" + 
						"    <button type=\"submit\">계산</button>\r\n" + 
						"  </form>\r\n"); 
				//계산결과 출력
				if(req.getMethod().equals("POST")) {
					int su1 = Integer.parseInt( req.getParameter("su1"));
					int su2 = Integer.parseInt( req.getParameter("su2"));
					String oper = req.getParameter("oper");
					
					//계산기 객체 생성
					Calculator calc = new Calculator(su1, su2, oper);
					//계산결과 얻기
					String result = calc.getResultStr();
					
					out.write("<hr>"+result+
						"</body>\r\n" + 
						"</html>");
				}else {
					out.write("</body>\r\n" + 
						"</html>");
				}
	}

}
