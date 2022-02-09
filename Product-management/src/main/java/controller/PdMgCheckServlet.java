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

/**
 * Servlet implementation class PdMgCheckServlet
 */
@WebServlet("/PdMgCheckServlet")
public class PdMgCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdMgCheckServlet() {
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
		
		RequestDispatcher rd = null;
		
		String send = request.getParameter("send");
		
		if(send.equals("change")) {
			
			HttpSession session = request.getSession();
			String word = (String)session.getAttribute("word");
			
			if(word.equals("削除")) {
				session.removeAttribute("price");
			}
			
			rd = request.getRequestDispatcher("productMg.jsp");
			rd.forward(request, response);
			
		} else if(send.equals("regist")) {
			
			String jsp = null;
			
			HttpSession session = request.getSession();
			
			String productName = (String)session.getAttribute("productName");
			String category = (String)session.getAttribute("category");
			int price = (int)session.getAttribute("price");
			
			String word = (String)session.getAttribute("word");
			
			DBManager dbm = new DBManager();
			
			if(word.equals("登録")) {
				
//				int price = Integer.parseInt(strPrice);
				if(category.equals("フード")) {
					
					category = "1";
				} else if(category.equals("ドリンク")) {
					
					category = "2";
				} else if(category.equals("デザート")) {
					
					category = "3";
				}
				
				
				dbm.setProduct(productName, category, price);
				
				jsp = "productRegist.jsp";
				
				
			} else if(word.equals("削除")) {
				
				
				dbm.deleteProduct(productName);
				
				jsp = "deleteDone.jsp";
				
			}
			
			session.removeAttribute("productName");
			session.removeAttribute("category");
			session.removeAttribute("price");
			session.removeAttribute("word");
			
			
			rd = request.getRequestDispatcher(jsp);
			rd.forward(request, response);
			
			
			
		}
		
		
		
	}

}
