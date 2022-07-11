const usernameInput = document.querySelector(".username-input");
const usernameCheckMsg = document.querySelector(".username-check-msg");
const inputItems = document.querySelectorAll("table input");
const submitButton = document.querySelector(".submit-button");

let signupFlag = [false, false, false, false, false];

submitButton.onclick = () => {
		for(let i = 0; i<inputItems.length; i++) {
			if(isEmpty(inputItems[i].value)){
				alert((i == 0? + "이름을" 
				: i == 1 ? "이메일을"
				: i == 2 ? "사용자이름을"
				: "패스워드를")
				+ " 입력해주세요");
				
			signupFlag[i] = false;
			
			return;
		}
		signupFlag[i] = true;
	}	
	
	if(signupFlag[4] == false){
		alert("사용자이름 중복확인이 필요합니다.");
		return;
	}		
	
	if(!signupFlag.includes(false)){
		submit();
	}
}

usernameInput.onblur = () => {
	let username = usernameInput.value;
	
	$.ajax({
		type: "get",
		url:`/check/username?username=${username}`,
		dataType: "text", //응답받을 때의 데이터 형태
		success: (response) => {
			if(response == "true"){
				signupFlag[4] = false;
				usernameCheckMsg.innerHTML = `<td colspan="2">이미 존재하는 사용자이름 입니다.</td>`;
			}else{
				signupFlag[4] = true;
				usernameCheckMsg.innerHTML = `<td colspan="2">가입할 수 있는 사용자이름 입니다.</td>`;
			a}		
		},
		error: errorMessage	
	});
}

function submit() {
	$.ajax({
		type: "post",
		url: "/signup",
		data: {
			name: inputItems[0].value,
			email: inputItems[1].value,
			username: inputItems[2].value,
			password: inputItems[3].value			
		},
		dataTtype: "text",
		success: (response) => {
			if(response == "true"){
				alert("축하합니다! \n 회원가입에 성공하였습니다.");
				location.replace("/signin");
			}else{
				alert("회원가입에 실패하였습니다. \n 다시 시도해주세요.")
				usernameCheckMsg.innerHTML = ``;
				document.querySelector("form").reset();
			}
		},
		error: errorMessage
	});
}


function errorMessage(request, status, error){
	alert("요청 실패");
	console.log(request.status);
	console.log(request.responseText);
	console.log(error);		
}

function isEmpty(str) {
	return str == "" || str == null || typeof str  == undefined;
}