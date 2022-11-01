const tbody = $("tbody");
const loading = $("#loading");
const url = "list";
	
function moveToRead(event){
	const number = event.target.parentElement.getAttribute("data-num");
	location.href=`/board/list/${number}`;
}

function setTable(boards){
	loading.classList.add("hidden");
	$("table").classList.remove("hidden");
	
	boards.forEach((board)=>{
		const tr = document.createElement("tr");
		tr.setAttribute("data-num", board.num);
		tr.classList.add("listHover");
		const html = `
			<td>${board.num}</td>
			<td>${board.writer}</td>
			<td>${board.title}</td>
			<td>${board.title}</td>
			<td>${board.hit}</td>
		`;
		tr.innerHTML = html;
		setEventListener(tr, "click", moveToRead);
		tbody.appendChild(tr);
	})
}

function fail(error){
	console.log(error);
}

fetchJson(url, {}, "get", setTable, fail);
