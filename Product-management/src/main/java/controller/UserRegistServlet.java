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

/**
 * Servlet implementation class UserRegistServlet
 */
@WebServlet("/UserRegistServlet")
public class UserRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistServlet() {
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
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String division = request.getParameter("division");
		
		int idDigit = userId.length();
		int passDigit = password.length();
		int nameDigit = userName.length();
		
		RequestDispatcher rd = null;
		String message = null;
		
		
		if(userId.equals("") || userName.equals("") || password.equals("")) {
			
			message = "全ての項目を入力してください。";
			
			request.setAttribute("alert", message);
			
			rd = request.getRequestDispatcher("regist.jsp");
			rd.forward(request, response);
		
		} else if(idDigit > 5 || passDigit < 5 || passDigit > 20 || nameDigit > 20) {
			
			message = "正しい桁数を入力してください。";
			
			request.setAttribute("alert", message);
			
			rd = request.getRequestDispatcher("regist.jsp");
			rd.forward(request, response);
			
		} else {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("userId", userId);
			session.setAttribute("userName", userName);
			session.setAttribute("password", password);
			session.setAttribute("division", division);
			
			
			rd = request.getRequestDispatcher("registCheck.jsp");
			rd.forward(request, response);
			
			
		}
		
		
	}

}
