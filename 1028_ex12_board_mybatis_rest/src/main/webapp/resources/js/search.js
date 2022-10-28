const idInput = document.querySelector("#userid");
const searchBtn = document.querySelector("#searchBtn")
const userList = document.querySelector("#userlist");

searchBtn.addEventListener("click", function(){
	const searchId = idInput.value;
	
	if(searchId.length==0){
		userList.innerText = "아이디를 입력해주세요";
	}
	else if(searchId.length > 10){
		userList.innerText = "10자 이내로 입력해주세요";
	}
	else{
		const url = `./user/customer/${searchId}`;
		fetch(url)
		.then(res => res.json())
		.then((data)=>{
			const html = `
				<table>
					<thead>
						<tr>
							<td>아이디</td>
							<td>비밀번호</td>
							<td>이름</td>
						</tr>
					</thead>
				<tbody>
					<tr>
						<td>${data.id}</td>
						<td>${data.password}</td>
						<td>${data.name}</td>
					</tr>
				</tbody>
				</table>
				`
				userList.innerHTML = html;
		})
		.catch(()=> {
			userList.innerHTML = "";
			userList.innerText = "찾는 데이터가 없습니다";
		});
	}
})
