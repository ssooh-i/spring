<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#sbtn").click(function(){
		var d="eno=" + $("#eno").val();
		
		$.ajax({
			type:"post",
			url:"searchNo",   
			data:d,
			dataType:"html",
			success:function(data){
				$("#display").html(data);
			}
		});
	});
});
//http://127.0.0.1:8080/emp/searchNo?eno=1
</script>
</head>
<body>
<a href="${root}/list">전체보기</a>
<a href="${root}/searchEmp">검색(사번 5이하,'업'이포함)</a>
<form action="${root}/insert" method="post">
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="ename" /></td>
		</tr>
		<tr>
			<td>연락처</td>
			<td><input type="text" name="phone" /></td>
		</tr>
		<tr>
			<td>부서</td>
			<td><input type="text" name="dept" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="등록" />
			</td>
		</tr>
	</table>
</form><br><br>

번호로 찾기: <input type="text" id="eno">
<input type="button" id="sbtn" value="찾기">
<br><br>
<div id="display"></div>
</body>
</html>

















