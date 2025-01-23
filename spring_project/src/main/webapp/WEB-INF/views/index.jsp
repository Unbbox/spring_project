<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="_csrf" content="${_csrf.token}">
		<meta name="_csrf_header" content="${_csrf.headerName}">
		<title>언빡스 카페</title>
	</head>
	<body>
	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<div id="container">
			<div id="menuAdmin">
				<h2 id="menuAdminH2">공지사항</h2>
				
				<!-- 특별한 기능(jstl이라는 라이브러리를 이용한 세션에 있는 변수 설정) -->
				<!-- 세션 공간에 저장되어있는 "MANAGER"의 값이 true일 때 작성이라는 버튼이 보이게끔 할 것 -->
				<c:if test="${MANAGER == true}">
					<Button type="button" onclick="location.href=`${pageContext.request.contextPath}/noticeAddPage`">작성</Button>
				</c:if>
			
				<div id="menuList">
				</div>
				
			</div>
		</div>
		
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script>
	</body>
</html>