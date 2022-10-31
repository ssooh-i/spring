<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<link href="./css/index.css" rel="stylesheet">
	<title>글작성</title>
</head>
<body>
<h1>글쓰기</h1>
<a href="/board/list">리스트</a>
<a href="/board/index">처음화면</a>
<form>
	<table width="500" border="0">
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" size="12" maxlength="12" required></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pwd" size="12" maxlength="12" required></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" size="50" maxlength="50" required></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" rows="5" cols="50" required></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" id="submitBtn" value="저장">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
<script src="./js/utils.js"></script>
<script src="./js/insert.js"></script>
</body>
</html>