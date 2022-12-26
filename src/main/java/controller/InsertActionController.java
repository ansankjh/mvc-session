package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

/**
 * Servlet implementation class InsertActionController
 */
@WebServlet("/InsertActionController")
public class InsertActionController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인이 되어있다면 회원가입 페이지 진입x
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember != null) { // 로그인이 되어있다면 회원가입 페이지가 아닌 로그인되어있는 페이지로 이동
			response.sendRedirect(request.getContextPath()+"/HomeController");
			return;
		}
		
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		// System.out.println(memberId);
		// System.out.println(memberPw);
		// System.out.println(memberName);
		
		// 메서드 호출할때 쓸 매개값
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setMemberName(memberName);
		
		// 메서드 호출
		MemberService memberService = new MemberService();
		int row = memberService.insertMember(member);
		
		response.sendRedirect(request.getContextPath()+"/LoginFormController");
	}

}
