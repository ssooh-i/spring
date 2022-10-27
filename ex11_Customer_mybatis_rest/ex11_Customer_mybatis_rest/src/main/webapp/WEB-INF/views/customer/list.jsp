<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function () {
	$.ajax({
		url:'/user/customer',  
		type:'GET',
		contentType:'application/json;charset=utf-8',
		dataType:'json',
		success:function(users) {
			makeList(users);
		},
		error:function(xhr, status, error){
			console.log("상태값 : " + xhr.status + "\tHttp 에러메시지 : " + xhr.responseText);
			errorList();
		}
	});	
	
	$(document).on("click", "#delBtn", function() {
		if(confirm("정말 삭제?")) {
			let uid = $(this).parents("tr").attr("data-id");
			console.log(uid);
			
			$.ajax({
				url:'/user/customer/' + uid,  
				type:'DELETE',
				contentType:'application/json;charset=utf-8',
				dataType:'json',
				success:function(users) {
					makeList(users);
				},
				error:function(xhr,status,msg){
					console.log("상태값 : " + status + " Http에러메시지 : "+msg);
				}
			});
		}
	});

	$(document).on("click",'#modBtn',function() {
	      let pass = prompt("변경할 비밀번호를 입력하세요.");
	      
	      let upid = $(this).parents("tr").attr("data-id");
	      let upname = $(this).parents("tr").attr("data-name");
	      
	      let modifyinfo = JSON.stringify({
	         "id" : upid, 
	         "password" : pass, 
	         "name" : upname
	         });
	      
	      $.ajax({
	         url:'/user/customer',  
	         type:'PUT',
	         contentType:'application/json;charset=utf-8',
	         dataType:'json',
	         data: modifyinfo,
	         success:function(users) {
	            makeList(users);
	         },
	         error:function(xhr,status,msg){
	            console.log("상태값 : " + status + " Http에러메시지 : "+msg);
	         }
	      });
	   });
	
	function makeList(users){
		$("#userlist").empty();
		let str="";
		
		str +=`
			<table border='1'>
			<tr>
				<td>아이디</td><td>비밀번호</td><td>이름</td><td>수정</td><td>삭제</td>
			</tr>
		`;
		$(users).each(function(index, user) {
			str += `
					<tr data-id="${'${user.id}'}" data-name="${'${user.name}'}">
						<td>${'${user.id}'}</td>
						<td>${'${user.password}'}</td>
						<td>${'${user.name}'}</td>
						<td><input type='button' id="modBtn" value="수정"></td>
						<td><input type='button' id="delBtn" value="삭제"></td>
					</tr>
			`;
		});//each
		
		str += `</table>`;
		$("#userlist").html(str);
	}
	
	function errorList(){
		$("#userlist").text("고객 정보가 없습니다");
	}
});
</script> -->

</head>
<body>
<div id="userlist"></div>
<script src="resources/js/list.js"></script>
</body>
</html>




