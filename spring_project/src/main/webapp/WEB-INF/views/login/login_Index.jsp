<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 페이지</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login/style.css">
	</head>
	<body>
	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<div id="login-container-wrapper">
			<div id="login-container">
				<h2>로그인</h2>
				<!-- localhost:8080/login 로 username, password 전송 -->
				<form action="${pageContext.request.contextPath}/login" method="post">
					<!-- csrf 토큰 -->
					<input type="hidden" name="_csrf" value="${_csrf.token}">
				
					<div class="input-group">
						<label for="username">아이디</label>
						<input type="text" id="username" name="username">
					</div>
					<div class="input-group">
						<label for="password">비밀번호</label>
						<input type="password" id="password" name="password">
					</div>
					<button type="submit" id="login-button">로그인</button>
				</form>
				<div id="register-link">
				<!-- 최상위 경로 ==> localhost:8080 -->
					<a href="${pageContext.request.contextPath}/registerPage">회원가입</a>
				</div>
			</div>
		</div>
		
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	</body>
</html>