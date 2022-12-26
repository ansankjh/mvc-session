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
@WebServlet("/UpdatePwActionController")
public class UpdatePwActionController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// loginMember가 null이 아니면 이미 로그인중 로그인이 되어있다면 Home으로 이동
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember == null) { // 비로그인시 로그인화면으로 강제이동
			response.sendRedirect(request.getContextPath()+"/LoginFormController");
			return;
		}
		
		// 요청한 값 받아오기 & 디버깅
		request.setCharacterEncoding("utf-8");
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
		int row = memberService.updateMemberPw(member);
		
		// 비밀번호 수정 완료시 수정완료 세션삭제하고 로그인페이지로 메시지와 함께 이동
		String msg = URLEncoder.encode("비밀번호수정완료", "utf-8");
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath()+"/LoginFormController?msg="+msg);
		
	}
}
