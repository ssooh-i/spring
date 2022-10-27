const userListEl = document.querySelector("#userlist");

const makeList = (list)=>{
	console.log(list);
	let html = `<table>
				<thead>
					<tr>
						<td>아이디</td>
						<td>비밀번호</td>
						<td>이름</td>
						<td>수정</td>
						<td>삭제</td>
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
		delBtn.addEventListener("click", delCustomer);
		modBtn.addEventListener("click", modCustomer);
	})
	
}

function delCustomer(event){
	if(confirm("정말 삭제?")) {
		const parent = event.target.parentElement.parentElement;
		const uid = parent.getAttribute("data-id");
		const name = parent.getAttribute("data-name");
		console.log(uid);
		
		const url = `./user/customer/${uid}`;
		fetch(url, {
			method : "delete",
		})
		.then(res => res.json())
		.then(data => makeList(data))
		.catch(()=> console.log("error"))
	}
}

function modCustomer(event){
	const parent = event.target.parentElement.parentElement;
	const uid = parent.getAttribute("data-id");
	const pass = prompt("변경할 비밀번호를 입력하세요.");
	
	const modInfo = {
	         "id" : uid, 
	         "password" : pass
	}
	
	const url = `./user/customer`;
	
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

const url = '/user/customer';
fetch(url)
.then(res => res.json())
.then(data => makeList(data))
.catch(()=> console.log("error"));


