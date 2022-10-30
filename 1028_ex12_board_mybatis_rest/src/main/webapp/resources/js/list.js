const userListEl = document.querySelector("#userlist");

const makeList = (list)=>{
	console.log(list);
	let html = `<table>
				<thead>
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>날짜</td>
						<td>조회</td>
					</tr>
				</thead>
				<tbody></tbody>
			<table>`;
	userListEl.innerHTML = html;
	
	const tbody = userListEl.querySelector("tbody");
	
	list.forEach((index)=>{
		const tr = document.createElement("tr");
		tr.setAttribute("data-id", index.id)
		tr.setAttribute("data-name", index.name);
		const inner = `
				<td>${index.id}</td>
				<td>${index.password}</td>
				<td>${index.name}</td>
				<td><button class="modBtn">수정</button></td>
				<td><button class="delBtn">삭제</button></td>
		`
		tr.innerHTML = inner;
		tbody.appendChild(tr);
		
		const delBtn = tr.querySelector(".delBtn");
		const modBtn = tr.querySelector(".modBtn");
		delBtn.addEventListener("click", del);
		modBtn.addEventListener("click", mod);
	})
	
}

function del(event){
	if(confirm("정말 삭제하시겠습니까?")) {
		const parent = event.target.parentElement.parentElement;
		const writer = parent.getAttribute("writer");
		console.log(writer);
		
		const url = `./rest/board/${writer}`;
		fetch(url, {
			method : "delete",
		})
		.then(res => res.json())
		.then(data => makeList(data))
		.catch(()=> console.log("error"))
	}
}

function mod(event){
	const parent = event.target.parentElement.parentElement;
	const writer = parent.getAttribute("writer");	
	const title = prompt("변경할 제목을 입력하세요.");
	const content = prompt("변경할 내용을 입력하세요.");
	
	const modInfo = {
	         "writer" : writer, 
	         "title" : title,
	         "content" : content
	}
	
	const url = `./rest/board/${writer}`;
	
	fetch(url,{
		body: JSON.stringify(modInfo),
		headers: {
		      'Content-Type': 'application/json;charset=utf-8'
		    },
		method : "put"
	})
	.then(res => res.json())
	.then(data => makeList(data))
	.catch(()=> console.log("error"));
}

const url = '/rest/board';
fetch(url)
.then(res => res.json())
.then(data => makeList(data))
.catch(()=> console.log("error"));


