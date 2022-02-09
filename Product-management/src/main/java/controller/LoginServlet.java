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
import dto.UserDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		int idDigit = userId.length();
		int passDigit = password.length();
		
		RequestDispatcher rd = null;
		String message = null;
		
		if(userId.equals("") || password.equals("")) {
			
			message = "ユーザーIDとパスワードは必須項目です。";
			
			request.setAttribute("alert", message);
			
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
			
		} else if(idDigit > 5 || passDigit < 5 || passDigit > 20 ) {
			
			message = "正しい桁数を入力してください。";
			
			request.setAttribute("alert", message);
			
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		} else {
			
			DBManager dbm = new DBManager();
			
			UserDTO user = dbm.getUser(userId, password);
			
			if(user != null) {
				
				String send = null;
				
				String division = user.getDivision();
				
				if(division.equals("0")) {
					
					send = "regist.jsp";
					
					
				} else if(division.equals("1")) {
					
					send = "search.jsp";
					
				} else if(division.equals("2")) {
					
					send = "productMg.jsp";
					
				}
				
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
				
				rd = request.getRequestDispatcher(send);
				rd.forward(request, response);
				
				
			} else {
				
				message = "ユーザーIDかパスワードが違います。";
				
				request.setAttribute("alert", message);
				
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				
				
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
