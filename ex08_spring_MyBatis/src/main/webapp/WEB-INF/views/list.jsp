<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "root" value="${pageContext.request.contextPath }" />
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
		<c:forEach items = "${list}" var="emp">
	<tr>
		<td>${emp.eno}</td>
		<td>${emp.ename}</td>
		<td>${emp.phone}</td>
		<td>${emp.dept}</td>
		<td>
			<form action="${root}/update" method="post">
			    <input type="hidden" name="eno" value="${emp.eno}"/>
			    <input type="hidden" name="ename" value="${emp.ename}"/>
			    <input type="hidden" name="phone" value="${emp.phone}"/>
			    <input type="hidden" name="dept" value="${emp.dept}"/>
			   	<a href="javascript:;" onclick="parentNode.submit();">수정</a><!-- 버튼으로 안만들고 링크로 값 주기 -->
			    <!-- <input type="submit" value="수정"/> -->
			</form>
		</td>
		<td>
			<a href="${root}/delete?eno=${emp.eno}">삭제</a>
		</td>
	</tr> 
	</c:forEach>

</table>	
</body>
</html>






