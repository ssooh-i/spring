<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>게시판수정</title>
	<link href="/board/css/index.css" rel="stylesheet">
</head>
<body>
  <h1>게시판수정</h1>
  <a href="/board/list">리스트</a>
  <a href="/board/">처음화면</a>
  <form>
  <table>
    <tr>
      <th width="120">글번호</th>
      <td id="num"></td>
    </tr>
    <tr>
      <th>글쓴이</th>
      <td>
        <input type="text" name="writer" size="12" maxlength="12">
      </td>
    </tr>
    <tr>
      <th>비밀번호</th>
      <td>
        <input type="password" name="pwd" size="12" maxlength="12">
      </td>
    </tr>
    <tr>
      <th>조회수</th>
      <td id="hit"></td>
    </tr>
    <tr>
      <th>제목</th>
      <td><input type="text" name="title" size="50" maxlength="50"></td>
    </tr>
    <tr>
      <th>내용</th>
      <td><textarea rows="5" cols="50" name="content"></textarea></td>
    </tr>
    <tr>
      <td colspan="2">
        <input id="submitBtn" type="button" value="수정">
        <input type="reset" value="취소">
        <label id="pwdCheckMsg" class="warning"></label>
      </td>
    </tr>
  </table>
  </form>
  <script src="/board/js/utils.js"></script>
<script src="/board/js/update.js"></script>
</body>
</html>
