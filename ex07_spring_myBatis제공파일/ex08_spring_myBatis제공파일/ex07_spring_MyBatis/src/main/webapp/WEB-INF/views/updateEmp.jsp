<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:requestEncoding value="UTF-8"/>
	<form action="${root}/update" method="post">  <!-- request.getParameter("eno"); => ${param.eno} -->
		<table>
			<tr>
				<td>번호</td>
				<td><input type="text" name="eno" value="${param.eno}" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="ename" value="${param.ename}" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="text" name="phone" value="${param.phone}"></td>
			<tr>
				<td>부서</td>
				<td><input type="text" name="dept" value="${param.dept}"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="수정" />
				</td>
			</tr>
		</table>
	</form>
<br>
<br>
</body>
</html>