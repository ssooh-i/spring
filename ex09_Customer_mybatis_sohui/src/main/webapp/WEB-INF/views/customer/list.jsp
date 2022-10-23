<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty list}">
	<h3>고객 정보가 없습니다</h3>
</c:if>
<c:if test="${!empty list}">
	<h3>** 고객 정보 리스트 **</h3>
	<table border="1" width="300px">
		<tr>
			<td>아이디</td><td>비밀번호</td><td>이름</td>
		</tr>
		<c:forEach items="${list}" var="ob">
		<tr>
			<td>${ob.id}</td>
			<td>${ob.password}</td>
			<td>${ob.name}</td>
		</tr>
		</c:forEach>
	</table>
</c:if><br>
<a href="/customer">홈 화면으로 이동</a>
</body>
</html>