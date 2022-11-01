const form = $("form");
const submitBtn = $("#submitBtn");

function success(){
	console.log("success");
	location.href="./list";
}

function fail(){
	console.log("error");
}

function onClick(event){
	event.preventDefault();

	const formData = new FormData(form);
	const obj = Object.fromEntries(formData.entries());
	const url = "insert";
	
	fetchText(url, obj, "post", success, fail);
}

setEventListener(submitBtn, "click", onClick);