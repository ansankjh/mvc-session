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
 * Servlet implementation class RemoveActionController
 */
@WebServlet("/RemoveActionController")
public class RemoveActionController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비로그인시 접근불가
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/LoginFormController");
			return;
		}
		
		request.setCharacterEncoding("utf-8");
		// 값 요청 & 디버깅
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		// System.out.println(memberId);
		// System.out.println(memberPw);
		
		// 메서드 호출시 사용할 매개값
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		// 메서드 호출
		MemberService memberService = new MemberService();
		int row = memberService.deleteMember(member);
		
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/LoginFormController");
	}
}
