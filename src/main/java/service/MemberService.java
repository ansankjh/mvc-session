package service;

import vo.*;

import java.sql.Connection;

import dao.*;
import util.DBUtil;

public class MemberService {
	private MemberDao memberDao;
	
	// LoginActionController.java
	public Member login(Member member) {
		// memberDao 공간확보
		this.memberDao = new MemberDao();
		// 객체 초기화
		Member resultMember = null;
		// 드라이버 초기화
		Connection conn = null;
		
		try {
			// 드라이버 연결
			conn = DBUtil.getConnection();
			// 오토커밋 끄기
			conn.setAutoCommit(false);
			// dao 호출
			resultMember = memberDao.selectMemberByIdAndPw(conn, member);
			// 커밋하기
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 로그인 성공 자원 반납
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return resultMember;
	}
	
	// InsertActionController.java
	public int insertMember(Member member) {
		// memberDao 초기화하고 공간확보
		this.memberDao = new MemberDao();
		// 객체 초기화
		int row = 0;
		// 드라이버 초기화
		Connection conn = null;
		
		try {
			// 드라이버 연결
			conn = DBUtil.getConnection();
			// 오토커밋 끄기
			conn.setAutoCommit(false);
			// dao 호출
			row = memberDao.insertMember(conn, member);
			// 커밋하기
			conn.commit();
		} catch(Exception e) {
			// 회원가입 실패시 롤백
			try {
				conn.rollback();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// 회원가입 성공시 자원반납
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	// UpdateActionController.java 회원정보 수정
	public int updateMember(Member member) {
		// dao 초기화&공간확보?
		this.memberDao = new MemberDao();
		// 객체 초기화
		int row = 0;
		// 드라이버 초기화
		Connection conn = null;
		
		try {
			// 드라이버 연결
			conn = DBUtil.getConnection();
			// 오토 커밋 끄기
			conn.setAutoCommit(false);
			// dao 호출
			row = memberDao.updateMember(conn, member);
			// 커밋하기
			conn.commit();
		} catch(Exception e) {
			// 정보수정 실패시 롤백
			try {
				conn.rollback();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// 회원정보 수정 성공시 자원반납
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	// UpdatePwActionController.java 비밀번호 수정 모델2 익숙해지기 버전
	public int updateMemberPw(Member member) {
		// dao 초기화&공간확보
		this.memberDao = new MemberDao();
		// 객체 초기화
		int row = 0;
		// 드라이버 초기화
		Connection conn = null;
		
		try {
			// 드라이버 연결
			conn = DBUtil.getConnection();
			// 오토커밋 끄기
			conn.setAutoCommit(false);
			// 메서드 호출
			row = memberDao.updateMemberPw(conn, member);
			// 커밋하기
			conn.commit();
		} catch(Exception e) {
			// 수정 실패시 롤백
			try {
				conn.rollback();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// 수정 성공시 자원 반납
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	// RemoveActionController.java 회원탈퇴
	public int deleteMember(Member member) {
		// dao초기화&공간확보
		this.memberDao = new MemberDao();
		// 객체 초기화
		int row = 0;
		// 드라이버 초기화
		Connection conn = null;
		
		try {
			// 드라이버 연결
			conn = DBUtil.getConnection();
			// 오토커밋 끄기
			conn.setAutoCommit(false);
			// dao호출
			memberDao.deleteMember(conn, member);
			// 커밋하기
			conn.commit();
		} catch(Exception e) {
			// 회원탈퇴 실패 시 롤백
			try {
				conn.rollback();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// 회원탈퇴 성공시 자원반납
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
