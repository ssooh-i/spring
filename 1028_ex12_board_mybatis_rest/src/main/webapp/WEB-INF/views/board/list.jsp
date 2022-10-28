<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>게시판</title>
	<style>
		body {
		  padding: 50px;
		  font: 14px "Lucida Grande", Helvetica, Arial, sans-serif;
		}
		
		table { width: 46em; padding-top: 0.3em; }
		th { background: #D6D6D6; }
		td { border: 1px dotted; }
	</style>
</head>
<body>
	<h1>게시판 리스트</h1>
	<a href="">글 쓰기</a>
	<a href="">처음화면</a>
	<table width="560" border="0">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회</th>
		</tr>
		<!-- 여기에 코드를 작성하시오 -->
		<tr>
			<td>100</td>
			<td><a href="/read/100">제목출력</a></td>
			<td>갑돌이</td>
			<td>2018-6-10</td>
			<td>0</td>
		</tr>
	       
	</table>
</body>
</html>