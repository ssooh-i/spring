<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
 <title>게시판수정</title>
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
  <h1>게시판수정</h1>
  <a href="">리스트</a>
  <a href="">처음화면</a>
  <form action="" method="post">
  <table>
    <tr>
      <th width="120">글번호</th>
      <td>
        <input type="hidden" name="num" value="100">
        100
      </td>
    </tr>
    <tr>
      <th>글쓴이</th>
      <td>
        <input type="text" name="writer" value="갑순이" size="12" maxlength="12">
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
      <td>0</td>
    </tr>
    <tr>
      <th>제목</th>
      <td><input type="text" name="title" value="안녕" size="50" maxlength="50"></td>
    </tr>
    <tr>
      <th>내용</th>
      <td><textarea rows="5" cols="50" name="content">여기에 내용이 출력됩니다.</textarea></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="수정">
        <input type="reset" value="취소">
      </td>
    </tr>
  </table>
  </form>
</body>
</html>
