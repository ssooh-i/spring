<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${board.title}</title>
<link rel="stylesheet" href="/board/css/style.css">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	const splitedURL = location.href.split('/');
	// URL에서 파싱한 현재 게시글의 ID
	const boardId = splitedURL[splitedURL.length - 1];
	
	let realPassword;

	$(document).ready(function(){
		getArticle(boardId);
	})
	
	// ajax를 이용해서 글 불러오기
	function getArticle(boardId) {
		$.ajax({
			url:"/board/bbs/articles/" + boardId,
			type:"GET",
			success:function(data) {
				$("#board-number").text(data.num);
				$("#board-writer").text(data.writer);
				$("#board-hit").text(data.hit);
				$("#board-title").text(data.title);
				$("#board-content").text(data.content);
				
				realPassword = data.pwd;
			}
			
		})
	}

	// 글 수정 페이지로 넘어가기
	function modify() {
		location.href = "/board/list/"+ boardId + "/update-form";
	}

	// 삭제 뷰 띄우기
	function delview() {
		$("#manipulation-button").css("display", "none");
		$("#delete-view").css("display", "inline-block");
	}
	
	// 띄운 삭제 뷰 없애고 원상복귀
	function cancel() {
		$("#manipulation-button").css("display", "inline-block");
		$("#delete-view").css("display", "none");
	}

	// 글 삭제하기
	function del() {
		if ($("#input-password").val() == "") {
			$("#alert-message").empty();
			$("#alert-message").css("color","red").text("비밀번호를 입력해주세요!");
			return;
		} else if ($("#input-password").val() != realPassword) {
			$("#alert-message").empty();
			$("#alert-message").css("color","red").text("비밀번호가 일치하지 않습니다!");
			return;
		}
		
		$.ajax({
			url:"/board/bbs/articles/" + boardId,
			type:"DELETE",
			success:function(data){
				$("#alert-message").empty();
				if(data) {
					location.href = "/board/list";
					return;
				} else {
					alert("삭제에 실패했습니다!");
				}
			}
		})
	}
</script>
</head>
<body>
	<h1>게시판 읽기</h1>
	<a href="/board/list">리스트</a>
	<a href="/board">처음화면</a>
	<table>
		<tr>
			<th width="120">글번호</th>
			<td id="board-number"></td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td id="board-writer"></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td id="board-hit"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td id="board-title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td id="board-content"></td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="manipulation-button"> 
					<input type="button" value="글수정" onclick="modify()"> 
					<input type="button" value="글삭제" onclick="delview()">
				</div> 
				<div id="delete-view" style="display:none">
					<span>비밀번호 :</span>
					<input type="password" id="input-password" size="12" maxlength="12">
					<input type="button" value="삭제" onclick="del()"> 
					<input type="button" value="취소" onclick="cancel()">
					<span id="alert-message"></span>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
