const ROOT_PATH = "/board/bc";

const $ = (query)=> document.querySelector(query);

const option = (data, restApi)=>{
	if(restApi==="get" || restApi==="GET")
		return {
	}
	return {
		body : JSON.stringify(data),
		method : restApi,
		headers : {
			'Content-Type' : 'application/json;'
		}
	}
}

const setEventListener = (el, eventName, func)=>{
	el.addEventListener(eventName, func);
}

const fetchText = (url, data, restApi, successFunc, errorFunc)=>{
	fetch(`${ROOT_PATH}/${url}`, option(data, restApi))
	.then(res => res.text())
	.then(result => successFunc(result))
	.catch((error)=> errorFunc(error))
}

const fetchJson = (url, data, restApi, successFunc, errorFunc) =>{
	fetch(`${ROOT_PATH}/${url}`, option(data, restApi))
	.then(res => res.json())
	.then(data => successFunc(data))
	.catch((error) => errorFunc(error))
}