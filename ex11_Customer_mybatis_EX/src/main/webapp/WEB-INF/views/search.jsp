<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 id="title">검색하려는 고객의 ID 를 입력해 주세요...</h3>
	<hr>
	ID
	<input type="text" id="userid" name="id">
	<input type="submit" id="searchBtn" value="검색">
	<p id="userlist" />
	<script>
	const searchBtn = document.querySelector("#searchBtn");
	const userIdElem = document.querySelector("#userid");
	const userListElem = document.querySelector("#userlist");
	
	searchBtn.addEventListener('click', (e)=>{
		 let id = userIdElem.value;
		// console.log(id);
		 fetch('/user/customer/'+id)
		 .then((response) => response.json())
		 .then((user)=> {console.log(user); makeList(user)})
		 .catch((e) => errorList())
		});
	
	function makeList(user) {
		//$("#userlist").empty(); //초기화 해주기
		userListElem.innerHTML = '';
		let str = `
			<table border='0'>
				<tr>
				<td>${'${user.id}'}</td>
				<td>${'${user.password}'}</td>
				<td>${'${user.name}'}</td>
				</tr>
			</table>
		`;
		//$("#userlist").html(str);
		userListElem.innerHTML = str;
		
	}
	
	function errorList(){
		let str = `찾는 데이터가 없습니다`;
		userListElem.innerText = str;
	}
	
	 

</script>
</body>
</html>