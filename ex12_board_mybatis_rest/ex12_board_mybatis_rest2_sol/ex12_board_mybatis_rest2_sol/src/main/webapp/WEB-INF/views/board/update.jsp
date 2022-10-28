<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
 <title>게시판수정</title>
<link rel="stylesheet" href="/board/css/style.css">
</head>
<body>
  <h1>게시판수정</h1>
  <a href="/board/list">리스트</a>
  <a href="/board">처음화면</a>
  <table>
    <tr>
      <th width="120">글번호</th>
      <td>
        <div id="board-number"></div>
      </td>
    </tr>
    <tr>
      <th>글쓴이</th>
      <td>
        <input type="text" id="board-writer" value="" size="12" maxlength="12">
      </td>
    </tr>
    <tr>
      <th>비밀번호</th>
      <td>
        <input type="password" id="input-password" size="12" maxlength="12">
      </td>
    </tr>
    <tr>
      <th>조회수</th>
      <td id="board-hit"></td>
    </tr>
    <tr>
      <th>제목</th>
      <td><input type="text" id="board-title" value="" size="50" maxlength="50"></td>
    </tr>
    <tr>
      <th>내용</th>
      <td><textarea rows="5" cols="50" id="board-content"></textarea></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="button" value="수정" id="update-button">
        <input type="reset" value="취소">
        <span id="alert-message"></span>
      </td>
    </tr>
  </table>
</body>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
const splitedURL = location.href.split('/');
// URL에서 파싱한 현재 게시글의 ID
const boardId = splitedURL[splitedURL.length - 2];

let realPassword;

$(document).ready(function(){
	// ajax를 이용해서 글 불러오기
	getArticle(boardId);
	
	$('#update-button').on("click", function(){
		update();
	})
})

function getArticle(boardId) {
	$.ajax({
		url:"/board/bbs/articles/" + boardId,
		type:"GET",
		success:function(data) {
			$("#board-number").text(data.num);
			$("#board-writer").val(data.writer);
			$("#board-hit").text(data.hit);
			$("#board-title").val(data.title);
			$("#board-content").val(data.content);
			
			realPassword = data.pwd;
		}
	})
}

function update() {
	if ($("#input-password").val() == "") {
		$("#alert-message").empty();
		$("#alert-message").css("color","red").text("비밀번호를 입력해주세요!");
		return;
	} else if ($("#input-password").val() != realPassword) {
		$("#alert-message").empty();
		$("#alert-message").css("color","red").text("비밀번호가 일치하지 않습니다!");
		return;
	}
	
	const data = JSON.stringify({
		"num":boardId,
		"title":$("#board-title").val(),
		"content":$("#board-content").val(),
		"writer":$("#board-writer").val()
	});
	
	console.log(data);
	$.ajax({
		url:"/board/bbs/articles",
		type:"PUT",
		data:data,
		dataType:"json",
		contentType:"application/json",
		success:function(data) {
			$("#alert-message").empty();
			if (data) {
				location.href = "/board/list"
				return;
			} else {
				alert("수정 실패 ㅠ");
				return;
			}
		}
	})
}
</script>
</html>
