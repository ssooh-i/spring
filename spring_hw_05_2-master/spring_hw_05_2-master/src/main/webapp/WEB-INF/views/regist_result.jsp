<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- DTO를 참조하기 위해서 import 처리가 필요하다. -->
<%@ page import="com.ssafy.hw.model.dto.*"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.servletContext.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록 결과</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
}

th:nth-child(1) {
	width: 100px;
}

td:nth-child(3) {
	width: 150px;
}

#profile {
	width: 150px;
	margin: 0 auto;
}

</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div class="container">
		<h1>도서 등록 결과</h1>
		<%-- c:if 태그를 이용해 request 영역에 book이 있다면 내용을 출력한다. --%>
		<c:if test="${!empty user }">
			<table class="table">
				<thead>
					<tr>
						<th>항목</th>
						<th>내용</th>
						<c:if test="${not empty user.img}">
							<th>이미지</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>아이디</td>
						<td>${user.id }</td>
						<!-- 실제 저장된 파일의 이미지를 경로로 사용한다. -->
						<c:if test="${not empty user.img}">
							<td rowspan="5"><img id="profile"
								src="${pageContext.servletContext.contextPath}/resources/upload/${user.img }">
							</td>
						</c:if>
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
		</c:if>
		<%-- c:if 태그를 이용해 request 영역에 book이 없다면 정보가 없음을 출력한다. --%>
		<c:if test="${empty user }">
			<p>등록된 사용자가 없습니다.</p>
		</c:if>
		<!-- 다시 도서를 등록할 수 있는 링크를 제공한다. -->
		<a href="${root }/regist">[추가등록]</a> 
		<a href="${root }/list">[목록보기]</a>
	</div>
</body>
</html>