package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.*;

public class MemberDao {
	// 로그인 메서드
	public Member selectMemberByIdAndPw(Connection conn, Member member) throws Exception {
		Member resultMember = null;
		// 쿼리문 작성
		String sql = "SELECT member_id memberId, member_pw memberPw, member_name memberName FROM member WHERE member_id = ? AND member_pw = PASSWORD(?)";
		// 쿼리 객체 생성
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 ?값 지정
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		// 쿼리 실행
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			resultMember = new Member();
			resultMember.setMemberId(rs.getString("memberId"));
			resultMember.setMemberPw(rs.getString("memberPw"));
			resultMember.setMemberName(rs.getString("memberName"));
		}
		
		stmt.close();
		rs.close();
		return resultMember;
	}
	
	// 회원가입
	public int insertMember(Connection conn, Member member) throws Exception  {
		// 초기화
		int row = 0;
		// 쿼리문 작성
		String sql = "INSERT INTO member(member_id, member_pw, member_name) values(?, PASSWORD(?), ?)";
		// 쿼리 객체 생성
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 ?값 지정
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		stmt.setString(3, member.getMemberName());
		// 쿼리 실행
		row = stmt.executeUpdate();
		
		stmt.close();
		return row;
	}
	
	// 회원정보 수정 UpdateActionController.java
	public int updateMember(Connection conn, Member member) throws Exception {
		// 객체 초기화
		int row = 0;
		// UPDATE member SET member_name = ? WHERE member_no = ? AND member_pw = PASSWORD(?)
		// 쿼리문 작성
		String sql = "UPDATE member SET member_name = ? WHERE member_id = ? AND member_pw = PASSWORD(?)";
		// 쿼리 객체 생성
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 ?값 지정
		stmt.setString(1, member.getMemberName());
		stmt.setString(2, member.getMemberId());
		stmt.setString(3, member.getMemberPw());
		// 쿼리 실행
		row = stmt.executeUpdate();
		
		stmt.close();
		return row;
	}
	
	// 비밀번호 수정 UpdatePwActionController.java
	public int updateMemberPw(Connection conn, Member member) throws Exception {
		// 객체 초기화
		int row = 0;
		// 쿼리문 작성
		String sql = "UPDATE member SET member_pw = PASSWORD(?) WHERE member_id = ?";
		// 쿼리 객체 생성
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 ?값 지정
		stmt.setString(1, member.getMemberPw());
		stmt.setString(2, member.getMemberId());
		// 쿼리 실행
		row = stmt.executeUpdate();
		
		// 자원 반납
		stmt.close();
		return row;
	}
	
	// RemoveActionController.java 회원탈퇴
	public int deleteMember(Connection conn, Member member) throws Exception {
		// 객체 초기화
		int row = 0;
		// 쿼리문 작성
		// DELETE FROM member WHERE member_id = ? AND member_pw = PASSWORD(?);
		String sql = "DELETE FROM member WHERE member_id = ? AND member_pw = PASSWORD(?)";
		// 쿼리 객체 생성
		PreparedStatement stmt = conn.prepareStatement(sql);
		// 쿼리문 ?값 지정
		stmt.setString(1, member.getMemberId());
		stmt.setString(2, member.getMemberPw());
		// 쿼리 실행
		row = stmt.executeUpdate();
		
		// 자원 반납
		stmt.close();
		return row;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
