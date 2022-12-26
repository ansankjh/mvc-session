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
import java.net.*;

@WebServlet("/UpdateActionController")
public class UpdateActionController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비로그인시 접근 불가
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath()+"/LoginFormController");
			return;
		}
		
		request.setCharacterEncoding("utf-8");
		// 회원가입폼으로부터 값 요청 & 잘넘어오는지 디버깅
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		// System.out.println(memberId);
		// System.out.println(memberPw);
		// System.out.println(memberName);
		
		// 메서드 호출시 사용할 매개값
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setMemberName(memberName);
		
		// 메서드 호출
		MemberService memberService = new MemberService();
		int row = memberService.updateMember(member);
		
		String msg = URLEncoder.encode("닉네임변경완료", "utf-8");
		response.sendRedirect(request.getContextPath()+"/HomeController?msg="+msg);
	}
}
