<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<link href="./css/index.css" rel="stylesheet">
	<title>게시판</title>
</head>
<body>
	<h1>게시판 리스트</h1>
	<a href="/board/insert">글 쓰기</a>
	<a href="/board/index">처음화면</a><br>
	<label id="loading">로딩중...</label>
	<table width="560" border="0" class="hidden">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
<script src="/board/js/utils.js"></script>
<script src="/board/js/list.js"></script>
</body>
</html>