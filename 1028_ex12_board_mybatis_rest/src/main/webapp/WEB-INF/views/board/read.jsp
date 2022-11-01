<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script defer src="js/resd.js"></script>
<title>게시판 읽기</title>


<script type="text/javascript">
   <%--  function modify() { // 글 수정
      location.href="/update/<%=data.num%>";
    } --%>

    function delview() {
      document.getElementById('frm1').style.display='inline';
      document.getElementById('span1').style.visibility='hidden';
    }

    function del() { // 글 삭제
      if(document.getElementById('pwd').value == '') {
        alert('비밀번호를 꼭 입력하세요!');
        document.getElementById('pwd').focus();
        return;
      }
      document.frm1.submit();
    }

    function cancel() {
      document.getElementById('frm1').style.display='none';
      document.getElementById('span1').style.visibility='';
    }
  </script>
</head>
<body>
	<h1>제목을 입력하시오</h1>
	<a href="/list">리스트</a>
	<a href="/">처음화면</a>
	<table>
		<tr>
			<th width="120">글번호</th>
			<td>100</td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td>갑돌이</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>0</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>연습중</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>내용 좀 넣어봐</td>
		</tr>
		<tr>
			<td colspan="2"><span id="span1"> <input type="button"
					value="글수정" onclick=""> <input type="button" value="글삭제"
					onclick="">
			</span>
				<form id="frm1" name="frm1" action="" method="post"
					style="display: inline; display: none">
					<input type="hidden" name="num" value=""> 비밀번호 : <input
						type="password" id="pwd" name="pwd" size="12" maxlength="12">
					<input type="button" value="Del" onclick=""> <input
						type="button" value="Cancel" onclick="">
				</form></td>
		</tr>
	</table>
</body>
</html>
