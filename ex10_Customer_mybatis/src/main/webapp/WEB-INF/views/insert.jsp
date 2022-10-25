<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="root" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title></head>
<body>
<h3>** 고객 정보를 입력하시오 **</h3>
<form action="${root}/insertCustomer"  method="post">
아이디 : <input type="text" id="customerId" name="id"><span id="idCheck"></span><br>
패스워드 : <input type="password" name="password"><br>
고객명 : <input type="text" name="name"><br>
<input type="submit" value="등록">
<input type="reset" value="재작성">
<script>
document.querySelector("#customerId").addEventListener("keyup", function () {
	let userid = this.value;
	let resultDiv = document.querySelector("#idCheck");
	if(userid.length < 5 || userid.length > 7) {
		 resultDiv.setAttribute("style", "color:black");
		 resultDiv.textContent = "5~7자 사이로 입력해주세요";
	 } else {
		 fetch("${root}/idcheck?id=" + userid)
		 .then(response => response.json())
		 .then(data =>{
			 if(data.msg == userid + "는 사용할 수 없습니다.") {
			   resultDiv.setAttribute("style", "color:red");
		       resultDiv.textContent = data.msg;
			 } else {
				 resultDiv.setAttribute("style", "color:green");
				 resultDiv.textContent = userid + data.msg;
			 }
		});
	 }
});
</script>
</form>
</body>
</html>