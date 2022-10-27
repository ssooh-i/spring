<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function () {
	$("#searchBtn").click(function(){
		var userid = $("#userid").val();
		$.ajax({
			url:'/user/customer/' + userid,  
			type:'GET',
			contentType:'application/json;charset=utf-8',
			dataType:'json',
			success:function(user) {
				makeList(user);
			},
			error:function(xhr,status,msg){
				console.log("상태값 : " + status + " Http에러메시지 : "+msg);
				errorList();
			}
		});
	});

	function makeList(user) {
		$("#userlist").empty();
		let str = `
			<table border='0'>
				<tr>
				<td>${'${user.id}'}</td>
				<td>${'${user.password}'}</td>
				<td>${'${user.name}'}</td>
				</tr>
			</table>
		`;
		$("#userlist").html(str);
	}
	function errorList(){
		let str = `찾는 데이터가 없습니다`;
		$("#userlist").text(str);
	}
});
</script>
</head>
<body>
	<h3>검색하려는 고객의 ID 를 입력해 주세요</h3>
	<input type="text" name="id" id="userid">
	<input type="button" id="searchBtn" value="검색"><br><br>
	
	<div id="userlist"></div>
</body>
</html>








