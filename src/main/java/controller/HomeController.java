package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Member;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 전에만
		HttpSession session  = request.getSession();
		// 로그인 전 : loginMember -> null
		// 로그인 후 : loginMember -> not null
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) { // loginMember가 null이 아니면 이미 로그인상태
			response.sendRedirect(request.getContextPath()+"/LoginFormController");
			return;
		} else if(loginMember != null) {
			request.getRequestDispatcher("WEB-INF/view/home.jsp").forward(request, response);
			loginMember = (Member)session.getAttribute("loginMember");
		}
	}
}
