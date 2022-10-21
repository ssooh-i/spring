<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 찾는번호 : <%=request.getParameter("eno") %>  --%>

<c:if test="${empty emp}">
	찾는 사원이 없습니다
</c:if>
<c:if test="${!empty emp}">
	<h2>찾는 사원</h2>
	${emp.eno}<br>
	${emp.ename}<br>
	${emp.phone}<br>
	${emp.dept}<br>
</c:if>
</body>
</html>



