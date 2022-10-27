<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>** 고객 정보 관리 **</h2>
<a href="${root}/list">고객리스트</a>&nbsp;&nbsp;
<a href="${root}/search">고객검색</a>&nbsp;&nbsp;
<a href="${root}/insert">고객등록</a><br>
<hr>
</body>
</html>