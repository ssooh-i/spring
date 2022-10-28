<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<link href="css/style.css" rel = "stylesheet" type="text/css">
	<script defer src="js/insert.js"></script>
</head>
<body>
<h1>글쓰기</h1>
<a href="/list">리스트</a>
<a href="/">처음화면</a>
<form action="/board" method="post" id="form-register">
	<table width="500" border="0">
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" id = "writer" size="12" maxlength="12"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" id="pwd" name="pwd" size="12" maxlength="12"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" id = "title" name="title" size="50" maxlength="50"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea id = "content" name="content" rows="5" cols="50"></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" id="submitBtn" value="저장">
				<input type="reset" id="resetBtn" value="취소">
			</td>
		</tr>
	</table>
</form>

</body>
</html>