<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ include
file="/WEB-INF/views/include/header.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
      window.onload = function () {
        fetch("/user/customer")
          .then((res) => res.json())
          .then((data) => makeList(data))
          .catch((e) => errorList());
      };

      function makeList(users) {
        const list = document.querySelector("#userlist");

        let str = "";
        str += `
        <table border='1'>
        <tr>
            <td>아이디</td><td>비밀번호</td><td>이름</td><td>수정</td><td>삭제</td>
        </tr>`;
        users.forEach((user) => {
          str += `
        <tr data-id=${"${user.id}"} data-name=${"${user.name}"}>
            <td>${"${user.id}"}</td>
            <td>${"${user.password}"}</td>
            <td>${"${user.name}"}</td>
            <td><input type='button' id="modBtn" value="수정"></td>
            <td><input type='button' id="delBtn" value="삭제"></td>
        </tr>
        `;
          const delBtn = document.querySelector("#delBtn");
          const modBtn = document.querySelector("#modBtn");

          delBtn.addEventListener("click", (e) => {
            if (confirm("정말 삭제?")) {
              let uid = e.target.parentElement.parentElement.dataset.id;
              let url = "/user/customer/" + uid;
              fetch(url, {
                method: "delete",
              })
                .then((res) => res.json())
                .then((data) => makeList(data))
                .catch((e) => console.log(e));
            }
          });

          modBtn.addEventListener("click", (e) => {
            let pass = prompt("변경할 비밀번호를 입력하세요.");
            let upid = e.target.parentElement.parentElement.dataset.id;
            let upname = e.target.parentElement.parentElement.dataset.name;

            let modifyinfo = JSON.stringify({
              id: upid,
              password: pass,
              name: upname,
            });

            fetch("/user/customer", {
              method: "PUT",
              body: modifyinfo,
              headers: { "Content-Type": "application/json" },
            })
              .then((res) => res.json())
              .then((data) => makeList(data))
              .catch((e) => console.log(e));
          });
        });
        str += `</table>`;
        list.innerHTML = str;
      }

      function errorList() {
        const userlist = document.querySelector("#userlist");
        userlist.innerText = "고객 정보가 없습니다.";
      }
    </script>
  </head>
  <body>
    <div id="userlist"></div>
  </body>
</html>
