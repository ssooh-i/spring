const form = document.querySelector("#form");
const idInput = document.querySelector("#userid");
const pwInput = document.querySelector("#password");
const nameInput = document.querySelector("#name");

const submitBtn = document.querySelector("#customerBtn");
const idMessage = document.querySelector("#idresult");
const userList = document.querySelector("#userlist");

let canUseId = false;

function setIdCheckResult(msg){
	if(msg===0){   // 해당 id 사용 가능
		idMessage.innerText = `${idInput.value}는 사용가능합니다.`;
		idMessage.style.color="green"
		canUseId = true;
		return;
	}
	else if(msg===1){
		idMessage.innerText = `${idInput.value}는 사용할 수 없습니다.`;
		idMessage.style.color="red"
		canUseId = false;
		return;
	}
	else{
		idMessage.innerText = msg;
		idMessage.style.color="blue"
		canUseId = false;
		return;
	} 
}

idInput.addEventListener("keyup", function(event){
	const param = event.target.value;
	const url = `./idCheck?ckid=` + param;
	
	if(param.length===0){
		setIdCheckResult("");
	}
	else if((0<param.length && param.length < 5) || param.length>10){
		setIdCheckResult("5~7자 사이로 입력해주세요");
	}
	else{
		fetch(url)
		.then(res => res.json())
		.then(data => setIdCheckResult(data.idcount));			
	}
})

submitBtn.addEventListener("click", function(){
	if(!canUseId){
		alert("아이디를 확인해주세요");
	}
	else{
		const info = {
			"id" : idInput.value, 
			"password" : pwInput.value, 
			"name" : nameInput.value
		}
		
		fetch("./user/customer", {
			body: JSON.stringify(info),
			headers: {
			      'Content-Type': 'application/json;charset=utf-8'
			    },
			method : "post"
		})
		.then((res)=> res.text())
		.then(data=> userList.innerText = `${idInput.value}님이 추가 되었습니다`	)
		.catch(() => userList.innerText = "추가 실패하였습니다");
	}
})