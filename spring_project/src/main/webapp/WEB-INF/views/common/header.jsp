<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/common/header.css">
</head>
<body>
	<div id="header">
		<div id="header_link" style="color:white; text-align:left; float:left; cursor:pointer;" onclick="location.href=`${pageContext.request.contextPath}/`">
			Unbox Cafe
		</div>
		
		<c:choose>
			<c:when test="${isAuthenticated != null && isAuthenticated == true}">
				<div style="float:right;">
					<a href="${pageContext.request.contextPath}/logout" class="isLogined">로그아웃</a>
				</div>
			</c:when>
			
			<c:otherwise>
				<div style="float:right;">
					<a href="${pageContext.request.contextPath}/loginPage" class="isLogined">로그인</a>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>