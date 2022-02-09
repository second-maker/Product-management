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
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBManager;
import dto.ProductDTO;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		RequestDispatcher rd = null;
		
		String message = null;
		
		String productName = request.getParameter("productName");
		String category = request.getParameter("category");
		String strLowPrice = request.getParameter("lowPrice");
		String strHighPrice = request.getParameter("highPrice");
		
		if(!strLowPrice.equals("") && !strHighPrice.equals("")) {
			
			int lowPrice2 = Integer.parseInt(strLowPrice);
			int highPrice2 = Integer.parseInt(strHighPrice);
			
			if(lowPrice2 > highPrice2) {
				
				message = "価格の入力が正しくありません。";
				
				request.setAttribute("alert", message);
				
				rd = request.getRequestDispatcher("search.jsp");
				rd.forward(request, response);
				
			}
			
		}
		
		
		String sql = "SELECT * FROM product p INNER JOIN category c ON p.category_id = c.id HAVING del_flg = 1 ";
		
		if(!productName.equals("")) {
			
			sql += " AND p.name LIKE " + "'%" + productName + "%'" ;
			
		}
		
		if(!category.equals("")) {
			
			sql += " AND p.category_id = '" + category + "'";
			
		}
		
		if(!strLowPrice.equals("")) {
			
			int lowPrice = Integer.parseInt(strLowPrice);
			
			sql += " AND p.price >" + lowPrice;
			
		}
		
		if(!strHighPrice.equals("")) {
			
			int highPrice = Integer.parseInt(strHighPrice);
			
			sql += " AND p.price <" + highPrice;
			
		}
		
		
		DBManager dbm = new DBManager();
		
		ArrayList<ProductDTO> list = dbm.getProductList(sql);
		
		if(list == null) {
			
			message = "商品が見つかりません。";
			
			request.setAttribute("alert", message);
			
			rd = request.getRequestDispatcher("search.jsp");
			rd.forward(request, response);
			
		}
		
		request.setAttribute("list", list);
		
		rd = request.getRequestDispatcher("searchDone.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
