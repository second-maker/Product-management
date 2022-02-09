/*
 * 課題No.5
 * 課題主題：「後期評定」
 * 日付：2022/01/23
 * 出席番号：16番
 * 氏名：田中天音
 * 
 * 
 * */

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBManager;
import dto.ProductDTO;

/**
 * Servlet implementation class ProductMgServlet
 */
@WebServlet("/ProductMgServlet")
public class ProductMgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductMgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String send = request.getParameter("send");
		
		String word = null;
		
		String productName = request.getParameter("productName");
		String category = request.getParameter("category");
		String strPrice = request.getParameter("price");
//		int price = Integer.parseInt(strPrice);
		
		int nameDigit = productName.length();
		
		RequestDispatcher rd = null;
		String message = null;
		
		if(send.equals("regist")) {
			
			if(productName.equals("") || category.equals("") || strPrice.equals("")) {
				
				message = "全ての項目を入力してください。";
				
				request.setAttribute("alert", message);
				
				rd = request.getRequestDispatcher("productMg.jsp");
				rd.forward(request, response);
				
				
				
			} else if(nameDigit > 20) {
				
				message = "正しい桁数を入力してください。";
				
				request.setAttribute("alert", message);
				
				rd = request.getRequestDispatcher("productMg.jsp");
				rd.forward(request, response);
				
				
			} else {
				
				int price = Integer.parseInt(strPrice);
				
				word = "登録";
				
				if(category.equals("1")) {
					
					category = "フード";
					
				} else if(category.equals("2")) {
					
					category = "ドリンク";
					
				} else if(category.equals("3")) {
					
					category = "デザート";
					
				}
				
				
				
				
				
				HttpSession session = request.getSession();
				
				session.setAttribute("productName", productName);
				session.setAttribute("category", category);
				session.setAttribute("price", price);
				session.setAttribute("word", word);
				
				rd = request.getRequestDispatcher("productMgCheck.jsp");
				rd.forward(request, response);
				
				
			}
			
			
			
		} else if(send.equals("delete")) {
			
			
			if(productName.equals("") || !category.equals("") || !strPrice.equals("")) {
				
				message = "正しい項目を入力してください。";
				
				request.setAttribute("alert", message);
				
				rd = request.getRequestDispatcher("productMg.jsp");
				rd.forward(request, response);
				
				
				
			} else if(nameDigit > 20) {
				
				message = "正しい桁数を入力してください。";
				
				request.setAttribute("alert", message);
				
				rd = request.getRequestDispatcher("productMg.jsp");
				rd.forward(request, response);
				
				
			} else {
				
				word = "削除";
				
				DBManager dbm = new DBManager();
				ProductDTO product = dbm.getProduct(productName);
				
				if(product != null) {
					
					
					int price = product.getPrice();
					category = product.getCategoryName();
					
					HttpSession session = request.getSession();
					
					session.setAttribute("productName", productName);
					session.setAttribute("category", category);
					session.setAttribute("price", price);
					session.setAttribute("word", word);
					
					rd = request.getRequestDispatcher("productMgCheck.jsp");
					rd.forward(request, response);
					
					
					
					
					
					
				} else {
					
					message = "商品が存在しません。";
					
					request.setAttribute("alert", message);
					
					rd = request.getRequestDispatcher("productMg.jsp");
					rd.forward(request, response);
					
					
				}
				
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
