<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>**고객 정보 리스트**</h3>
<table border="1" width="600px">
	<tr>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
	</tr>  
	<tr>
	<c:forEach items = "${list }" var="ob">
	<tr>
		<td>${ob.id }</td>
		<td>${ob.password}</td>
		<td>${ob.name }</td>
	</tr> 
	</c:forEach>
</table><br>
<a href="${root}/">홈 화면으로 이동</a>
</body>
</html>






