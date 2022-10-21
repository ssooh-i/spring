<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${root}/list">전체보기</a>
	<a href="${root}/searchEmp">검색(사번 5이하,'발'이포함)</a>
	<form action="${root }/insert" method="post">
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
	</form>
	<br>
	<br> 번호로 찾기:
	<input type="text" id="eno">
	<input type="button" id="sbtn" value="찾기">
	<br>
	<br>
	<div id="display"></div>

	<script type="text/javascript">
const displayDiv = document.getElementById('display');
document.querySelector('#sbtn').addEventListener('click', function(e) {
    console.log('버튼 눌림');
    let eno = document.querySelector('#eno').value;
    fetch('${root}/searchOneEmp?eno=' + eno)
    .then(res => res.json())
    .then(emp => {
        displayDiv.innerHTML = '';
        let div1Elem = document.createElement('div');
        let div2Elem = document.createElement('div');
        let div3Elem = document.createElement('div');
        div1Elem.innerText = '이름 : ' + emp.ename;
        div2Elem.innerText = '연락처 : ' + emp.phone;
        div3Elem.innerText = '부서 : ' + emp.dept;
        displayDiv.append(div1Elem, div2Elem, div3Elem);
        
    })
})
</script>
</body>
</html>

















