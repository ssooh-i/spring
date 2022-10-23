<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>** 검색된 고객정보 **</h3><hr>
	<c:if test="${empty customer}">
		찾는 고객이 존재하지 않습니다
	</c:if>
	<c:if test="${!empty customer}">
		아이디 : ${customer.id}<br>
		패스워드 : ${customer.password}<br>
		이름 : ${customer.name}<br>
	</c:if><br>
	<a href="/customer">홈 화면으로 이동</a>
</body>
</html>