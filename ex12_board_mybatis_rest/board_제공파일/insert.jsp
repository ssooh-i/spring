<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<!--학생이 작성하시오 -->
	<title>글작성</title>
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
<!--학생이 작성하시오 -->
<h1>글쓰기</h1>
<a href="">리스트</a>
<a href="">처음화면</a>
<form action="" method="post">
	<table width="500" border="0">
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" size="12" maxlength="12"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pwd" size="12" maxlength="12"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" size="50" maxlength="50"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" rows="5" cols="50"></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="저장">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>