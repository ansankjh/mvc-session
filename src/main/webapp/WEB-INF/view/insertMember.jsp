<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>insertMember</title>
	</head>
	<body>
		<h1>회원가입</h1>
		<form action="${pageContext.request.contextPath}/InsertActionController" method="post">
			<table border="1">
				<tr>
					<td>ID</td>
					<td>
						<input type="text" name="memberId">
					</td>
				</tr>
				<tr>
					<td>PW</td>
					<td>
						<input type="password" name="memberPw">
					</td>
				</tr>
				<tr>
					<td>NAME</td>
					<td>
						<input type="text" name="memberName">
					</td>
				</tr>
			</table>
			<div>
				<button type="submit">회원가입</button>
			</div>
		</form>
	</body>
</html>