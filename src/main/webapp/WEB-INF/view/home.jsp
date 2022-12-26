<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>home</title>
	</head>
	<body>
		${msg}
		<h1>${loginMember.memberName}님 어서오세요</h1>
		<a href="${pageContext.request.contextPath}/UpdateFormController">회원정보수정</a>
		<a href="${pageContext.request.contextPath}/UpdatePwFormController">비밀번호수정</a>
		<a href="${pageContext.request.contextPath}/RemoveFormController">회원탈퇴</a>
		<a href="${pageContext.request.contextPath}/LogoutController">로그아웃</a>
	</body>
</html>