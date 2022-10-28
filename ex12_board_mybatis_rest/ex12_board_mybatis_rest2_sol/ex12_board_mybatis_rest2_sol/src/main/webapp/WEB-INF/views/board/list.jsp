<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>게시판</title>
	<link rel="stylesheet" href="/board/css/style.css">
	<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		$(document).ready(function(){
			articleList();
		});
		
		let articleList = function() {
			let str = "";
			
			$.ajax({
				url:"bbs/articles",
				type:"GET",
				success:function(data){
					$(data).each(function(index, board) {
						str += 
							`
							<tr>
								<td>${'${board.num}'}</td>
								<td><a href="list/${'${board.num}'}">${'${board.title}'}</a></td>
								<td>${'${board.writer}'}</td>
								<td>${'${board.regdate}'}</td>
								<td>${'${board.hit}'}</td>
							</tr>
							`;
					})
					
					$("#articleList").html(str);
				},
				error:function(){
					alert("에러발생");
				}
			})
		}
	</script>
</head>
<body>
	<h1>게시판</h1>
	<a href="/board/insert">글 쓰기</a>
	<a href="/board">처음화면</a>
	<table width="560" border="0">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회</th>
		</tr>
		<tbody id="articleList">
		
		</tbody>
	</table>
</body>
</html>