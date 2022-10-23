<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<script type="text/javascript">
$(document).ready(function () {
	var isId = false;
	// 아이디 중복검사
	$("#userid").keyup(function () {
		var ckid = $("#userid").val();
		if(ckid.length < 5 || ckid.length > 7) {
			$("#idresult").text("아이디는 5자이상 7자이하입니다.").css("color","blue");
			isId = false;
		} else {
            $.ajax({
            	url: '/customer/idCheck',
            	data: {'ckid': ckid},
              	type: 'GET',
              	dataType: 'json',
              	success: function (response) {
              		console.log(response);
                	var cnt = response.idcount;
                	if(cnt == 0) {
                		$("#idresult").text(ckid + "는 사용가능합니다.").css("color","green");
                		isId = true;
                	} else {
                		$("#idresult").text(ckid + "는 사용할 수 없습니다.").css("color","red");
                		isId = false;
                	}
              	}, 
              	error: function(request, status, error) {
              		console.log("status : " + request.status + "\tmsg : " + error);
              	}
			});
		}
	}); 
}); 
</script>

<h3>** 고객 정보를 입력하시오 **</h3>
<form action="/customer/customerInsert" method="post">
	<table border="0">
	<tr>
		<td>아이디:</td>
		<td><input type="text" name="id" id="userid"></td>
		<td id="idresult">5~7자 사이로 입력해주세요</td>
	</tr>
	<tr>
		<td>패스워드:</td>
		<td><input type="password" name="password"></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>고객명:</td>
		<td><input type="text" name="name"></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="등록">
			<input type="reset" value="재작성">
		</td>
	</tr>
	</table>
</form>
</body>
</html>