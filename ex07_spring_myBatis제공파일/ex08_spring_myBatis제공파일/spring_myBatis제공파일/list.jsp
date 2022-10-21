<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td>
			<form action="" method="post">
			    <input type="hidden" name="eno" value=""/>
			    <input type="hidden" name="ename" value=""/>
			    <input type="hidden" name="phone" value=""/>
			    <input type="hidden" name="dept" value=""/>
			   	<a href="javascript:;" onclick="parentNode.submit();">수정</a>
			    <!-- <input type="submit" value="수정"/> -->
			</form>
		</td>
		<td>
			<a href="">삭제</a>
		</td>
	</tr> 

</table>	
</body>
</html>






