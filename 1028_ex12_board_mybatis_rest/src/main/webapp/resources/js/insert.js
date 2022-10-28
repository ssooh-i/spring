const form = document.querySelector('#form-register');
document.querySelector("#submitBtn").addEventListener("click", function () {
        if (!document.querySelector("#title").value) {
          alert("제목 입력하세요");
          return;
        } else if (!document.querySelector("#content").value) {
          alert("내용 입력하세요");
          return;
        } else {
          let form = document.querySelector("#form-register");
          form.submit();
        }
      });
      
      document.querySelector("#resetBtn").addEventListener("click", function () {
    	if(confirm("취소를 하시면 작성한 글은 삭제됩니다.\n취소하시겠습니까?")) {
  		  let form = document.querySelector("#form-register");
       	  location.href = '/';
   	    }
      });