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
<h2>전체보기</h2>
<table border="1" width="600px">
	<tr>
		<td>부서번호</td>
		<td>이름</td>
		<td>연락처</td>
		<td>부서명</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>  
	<tr>
	<c:forEach items="${list}" var="ob">
	<tr>
		<td>${ob.eno}</td>
		<td>${ob.ename}</td>
		<td>${ob.phone}</td>
		<td>${ob.dept}</td>
		<td>
			<form action="${root}/updateEmp" method="post">
			    <input type="hidden" name="eno" value="${ob.eno}"/>
			    <input type="hidden" name="ename" value="${ob.ename}"/>
			    <input type="hidden" name="phone" value="${ob.phone}"/>
			    <input type="hidden" name="dept" value="${ob.dept}"/>
			   	<a href="javascript:;" onclick="parentNode.submit();">수정</a>
			    <!-- <input type="submit" value="수정"/> -->
			</form>
		</td>
		<td>
			<a href="${root}/deleteEmp?eno=${ob.eno}">삭제</a>
		</td>
	</tr> 
	</c:forEach>
</table><br>
<a href="${root}/">처음화면</a>	
</body>
</html>










