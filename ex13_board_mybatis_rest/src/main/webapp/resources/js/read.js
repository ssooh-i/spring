const number = $("#num");
const writer = $("#writer");
const title = $("#title");
const content = $("#content");
const hit = $("#hit");

const updateBtn = $("#editBtn");
const deleteBtn = $("#deleteBtn");

const updateOrDelete = $("#updateOrDelete")
const tdForPwdInput = $("#pwdForDel");

const requestDelBtn = $("#requestDelBtn");
const cancelBtn = $("#cancelBtn");
const pwdInput = $("#pwd");
const pwdCheckMsg = $("#pwdCheckMsg");
let isRightPwd = false;

//-----------------------------------------------------------------
//글 정보 불러오기
function setTable(board){
	number.innerText = board.num;
	title.innerText = board.title;
	writer.innerText = board.writer;
	content.innerText = board.content;
	hit.innerText = board.hit;
}

function fail(error){
	console.log(error);
}
const nowUrlArr = document.location.href.split('/');
const nowNum = parseInt(nowUrlArr[nowUrlArr.length-1]);

const selectOneUrl = `list/${nowNum}`;

fetchJson(selectOneUrl, {}, "post", setTable, fail);		

//-----------------------------------------------------------------
//수정 버튼 누르기
function onClickUpdate(){
	location.href=`/board/list/${nowNum}/update-form`;
}
setEventListener(updateBtn, "click", onClickUpdate);	

//-----------------------------------------------------------------
//삭제 버튼 누르기
function onClickDelete(){
	updateOrDelete.classList.add("hidden");
	tdForPwdInput.classList.remove("hidden");
}
setEventListener(deleteBtn, "click", onClickDelete);	

//-----------------------------------------------------------------
//삭제 요청 버튼
function successDelete(result){
	if(result==1){
		pwdCheckMsg.innerText = "";
		location.href="/board/list";
	}
}

function successCheckPwd(result){
	if(result==1){	//비밀번호가 일치하면 삭제 요청
		pwdCheckMsg.innerText = "";
		const data = {
				"num" : nowNum,
		};
			const url = `list/${nowNum}`;
			fetchText(url, data, "delete", successDelete, fail);
	}
	else{
		pwdCheckMsg.innerText = "비밀번호가 일치하지 않습니다";
	}
}
//삭제하기 전 비밀번호부터 체크해본다
function onClickRequestDelete(){
	if(pwdInput.value.length===0){
		pwdCheckMsg.innerText = "비밀번호를 입력해주세요";
		return;
	}
	const url = "pwdCheck";
	const data = {
			"num" : nowNum,
			"pwd" : pwdInput.value
	};
	fetchText(url, data, "post", successCheckPwd, fail);
}
setEventListener(requestDelBtn, "click", onClickRequestDelete);

//-----------------------------------------------------------------
//삭제 취소시 화면 원상복구

function onCancel(){
	updateOrDelete.classList.remove("hidden");
	tdForPwdInput.classList.add("hidden");
	pwdCheckMsg.innerText = "";
	pwdInput.value = "";
	
}
setEventListener(cancelBtn, "click", onCancel);		