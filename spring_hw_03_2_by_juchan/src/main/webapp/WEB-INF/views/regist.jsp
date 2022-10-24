<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 사용자 관리</title>
</head>
<body>
	<h1>SSAFY 사용자 관리</h1>
	<!-- 코드작성 -->
	<div class="container">
		<h1>사용자 등록</h1>
		<form method="post" action="regist">
			<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
			<div class="input-group mb-3">
				<label for="id" class="input-group-text">아이디</label>
				<input type="text" id="id" name="id" class="form-control">
			</div>
			<div class="input-group mb-3">
				<label for="password" class="input-group-text">비밀번호</label>
				<input type="password" id="password" name="password" class="form-control">
			</div>
			<div class="input-group mb-3">
				<label for="name" class="input-group-text">이름</label>
				<input type="text" id="name" name="name" class="form-control">
			</div>
			<div class="input-group mb-3">
				<label for="email" class="input-group-text">이메일</label>
				<input type="email" id="email" name="email" class="form-control">
			</div>
			<div class="mb-3">
				<label for="age" class="form-label">나이</label>
				<input type="number" id="age" name="age" class="form-control" >
			</div>
			<div>
				<input type="submit" value="등록">
				<input type="reset" value="초기화">
			</div>
		</form>
		<br> <a href="./list">도서 목록</a>
	</div>
</body>
</html>