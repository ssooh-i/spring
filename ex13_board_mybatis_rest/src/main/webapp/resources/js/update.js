const form = $("form");
const number = $("#num");
const hit = $("#hit");
const submitBtn =$("#submitBtn");
const pwdCheckMsg = $("#pwdCheckMsg");

let isRightPwd = false;
//-----------------------------------------------------------------
//글 정보 불러오기
function setTable(board){
	number.innerText = board.num;
	form.elements["writer"].value = board.writer;
	form.elements["title"].value = board.title;
	form.elements["content"].value = board.content;
	hit.innerText = board.hit;
}

function fail(error){
	console.log(error);
}
const nowUrlArr = document.location.href.split('/');
const nowNum = parseInt(nowUrlArr[nowUrlArr.length-2]);

const selectOneUrl = `list/${nowNum}`;

fetchJson(selectOneUrl, {}, "post", setTable, fail);

//-----------------------------------------------------------------
//글 수정
function successUpdate(result){
	if(result==1)
		location.href=`/board/list/${nowNum}`;
}
function onClickRequestUpdate(event){
	event.preventDefault();	//form default submit 막기
	console.log(isRightPwd);
	if(!isRightPwd) return;
	
	const formData = new FormData(form);
	const obj = Object.fromEntries(formData.entries());
	obj.num = nowNum;
	
	const url = `update`;
	fetchText(url, obj, "put", successUpdate, fail);
}
setEventListener(submitBtn, "click", onClickRequestUpdate);

//-----------------------------------------------------------------
//비밀번호 확인

function successCheckPwd(result){
	console.log(result);
	if(result==1){
		pwdCheckMsg.innerText = "";
		isRightPwd = true;
		return;
	} 
	isRightPwd = false;
	pwdCheckMsg.innerText = "비밀번호가 일치하지 않습니다";
}

function onKeyUpPwd(event){
	if(event.target.value.length===0){
		pwdCheckMsg.innerText = "비밀번호를 입력해 주세요";
		isRightPwd = false;
	}
	else{
		const data = {
			"num" : nowNum,
			"pwd" : event.target.value	
		}
		fetchText('pwdCheck', data, "post", successCheckPwd, fail);
	}
}
setEventListener(form.elements["pwd"], "keyup", onKeyUpPwd);