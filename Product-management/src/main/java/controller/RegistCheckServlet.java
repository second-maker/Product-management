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
 * Servlet implementation class RegistCheckServlet
 */
@WebServlet("/RegistCheckServlet")
public class RegistCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistCheckServlet() {
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
			
			
			rd = request.getRequestDispatcher("regist.jsp");
			rd.forward(request, response);
			
			
			
		} else if(send.equals("regist")) {
			
			HttpSession session = request.getSession();
			
			String userId = (String)session.getAttribute("userId");
			String userName = (String)session.getAttribute("userName");
			String password = (String)session.getAttribute("password");
			String division = (String)session.getAttribute("division");
			
			
			DBManager dbm = new DBManager();
			
			dbm.setRegist(userId, password, userName, division);
			
			session.removeAttribute("userId");
			session.removeAttribute("userName");
			session.removeAttribute("password");
			session.removeAttribute("division");
			
			
			rd = request.getRequestDispatcher("registDone.jsp");
			rd.forward(request, response);
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
