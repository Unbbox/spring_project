// DOM(Document Object Model) 연결
// 즉 객체들을 자바스크립트와 연결시키는 과정
const contatiner = document.getElementById("container");
const menuAdmin = document.getElementById("menuAdmin");
const menuList = document.getElementById("menuList");

// CSRF 토큰과 헤더 이름 가져오기
const csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
const csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

