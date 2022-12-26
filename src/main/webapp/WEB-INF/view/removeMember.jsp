<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>removeMember</title>
	</head>
	<body>
		<h1>회원탈퇴</h1>
		<form action="${pageContext.request.contextPath}/RemoveActionController" method="post">
			<table border="1">
				<tr>
					<td>ID</td>
					<td>
						<input type="text" name="memberId" value="${loginMember.memberId}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td>PW</td>
					<td>
						<input type="password" name="memberPw">
					</td>
				</tr>
			</table>
			<div>
				<button type="submit">회원탈퇴</button>
			</div>
		</form>
	</body>
</html>