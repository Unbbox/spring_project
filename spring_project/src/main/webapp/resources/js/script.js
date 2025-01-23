// DOM(Document Object Model) 연결
// 즉 객체들을 자바스크립트와 연결시키는 과정
const contatiner = document.getElementById("container");
const menuAdmin = document.getElementById("menuAdmin");
const menuList = document.getElementById("menuList");

// CSRF 토큰과 헤더 이름 가져오기
const csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
const csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

// 데이터 조회할 떄 사용할 기능을 정의
function fetchMenus() {
	fetch("/menu/all")
	.then((response) => response.json())
	.then((data) => {
		console.log("게시판 전체 조회", data);
		
		menuList.innerHTML = ""; // 기존 메뉴 목록 초기화
		
		// 객체 값들 한 개씩 담기
		data.forEach(menu => {
			// 각 메뉴 아이템 생성 후 리스트에 추가
			const menuItem = document.createElement("div");
			menuItem.className = "menu-item";
			menuItem.innerHTML = `
				<a href="#" class="menu-link" style="color:black;">
					<h3>${menu.title}</h3>
					<p>${menu.content}</p>
					<small>작성자:${menu.writer}, 작성일:${menu.indate}, 조회수:${menu.count}</small>
				</a>
				<br>
				<br>`;
			// 게시글을 메인페이지에서 하나씩 클릭할 때
			menuItem.querySelector(".menu-link").addEventListener("click", (e) => {
				e.preventDefault();
				console.log(`Event: ${e}`);
				
				incrementCount(menu.idx).then(() => window.location.href=`/noticeCheckPage?idx=${menu.idx}`);
			});
			
			menuList.appendChild(menuItem);
		})
	})
}

function incrementCount(idx) {
	return fetch(`/menu/count/${idx}`, {
		method: "PUT",
		headers: {
			[csrfHeader]: csrfToken
		}
	}).then(response => {
		if(!response.ok) {
			console.log("데이터가 프론트서버에서 백엔드서버로 잘 안넘어 감")
		}
	}).catch(error => {
		console.error(`Error: ${error}`);
	})
}

// 메인페이지가 열리면 자동 실행됨
window.addEventListener("load", fetchMenus);
// fetchMenus();