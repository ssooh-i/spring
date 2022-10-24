<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 등록 결과</title>
</head>
<body>
	<div class="container">
		<h1>사용자 등록 결과</h1>
		<h2>등록 사용자 정보</h2>
	<!-- 코드작성 -->
		<%-- c:if 태그를 이용해 request 영역에 book이 있다면 내용을 출력한다. --%>
			<table class="table">
				<thead>
					<tr>
						<th>항목</th>
						<th colspan="2">내용</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>아이디</td>
						<td>${user.id }</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td>${user.password }</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>${user.name }</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>${user.email }</td>
					</tr>
					<tr>
						<td>나이</td>
						<td>${user.age }</td>
					</tr>
				</tbody>
			</table>
		<!-- 다시 도서를 등록할 수 있는 링크를 제공한다. -->
		<a href="./regist">추가등록</a>
		<a href="./list">사용자 목록</a>
	</div>
</body>
</html>