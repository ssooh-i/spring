<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>글쓰기</title>
<link rel="stylesheet" href="/board/css/style.css">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(document).ready(function(){
		console.log("test");
		$("#insert-button").on("click", function() {
			insertArticle();
		})
	})
	
	let insertArticle = function () {
		let writer = $("#writer").val();
		let pwd = $("#pwd").val();
		let title = $("#title").val();
		let content = $("#content").val();
		
		let data = JSON.stringify({
			"writer":writer,
			"pwd":pwd,
			"title":title,
			"content":content
		})
		
		$.ajax({
			url:"/board/bbs/articles",
			type:"POST",
			data:data,
			contentType:"application/json",
			dataType:"json",
			success:function(data){
				if(data>0) {
					location.href = "/board/list";
					return;
				} else {
					alert("글쓰기 실패 ㅠ")
					return;
				}
			},
			error: function(request, status, error) {
	      		console.log("status : " + request.status + "\tmsg : " + error);
	      	}
		})
	}
</script>
</head>
<body>
<h1>글쓰기</h1>
<a href="/board/list">리스트</a>
<a href="/board">처음화면</a>
	<table width="500" border="0">
		<tr>
			<th>작성자</th>
			<td><input type="text" id="writer" name="writer" size="12" maxlength="12"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" id="pwd" name="pwd" size="12" maxlength="12"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" id="title" name="title" size="50" maxlength="50"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea id="content" name="content" rows="5" cols="50"></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" id="insert-button" value="저장">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</body>
</html>