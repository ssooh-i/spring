<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty emp }">
	{
        "eno" : "",
        "ename" : "",
        "phone" : "",
        "dept" : "찾는데이터가 없습니다"
    }
</c:if>
<c:if test="${!empty emp}">
    {
        "eno" : "${emp.eno }",
        "ename" : "${emp.ename }",
        "phone" : "${emp.phone }",
        "dept" : "${emp.dept }"
    }
</c:if>



