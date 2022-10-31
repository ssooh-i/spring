<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>게시판 읽기</title>
  <link href="/board/css/index.css" rel="stylesheet">
</head>
<body>
  <h1>제목을 입력하시오</h1>
  <a href="/board/list">리스트</a>
  <a href="/board/">처음화면</a>
  <table>
    <tr>
      <th width="120">글번호</th>
      <td id="num">...</td>
    </tr>
    <tr>
      <th>글쓴이</th>
      <td id="writer">...</td>
    </tr>
    <tr>
      <th>조회수</th>
      <td id="hit">...</td>
    </tr>
    <tr>
      <th>제목</th>
      <td id="title">...</td>
    </tr>
    <tr>
      <th>내용</th>
      <td ><textarea id="content" readonly rows="5" cols="50">...</textarea></td>
    </tr>
    <tr>
      <td colspan="2" id="updateOrDelete" class="">
        <span >
          <input type="button" id="editBtn" value="글수정">
          <input type="button" id="deleteBtn" value="글삭제">
        </span>
      </td>
      <td colspan="2" id="pwdForDel" class="hidden">
        <span>
          <label for="pwd">비밀번호 : </label>
          <input type="password" id="pwd" name="pwd" size="12" maxlength="12">
          <input type="button" id="requestDelBtn" value="삭제">
          <input type="button" id="cancelBtn" value="취소">
          <label class="warning" id="pwdCheckMsg"></label>
        </span>
      </td>
    </tr>
  </table>
<script src="/board/js/utils.js"></script>
<script src="/board/js/read.js"></script>
</body>
</html>
