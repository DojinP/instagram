<%@page import="com.multi.instagram.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		MemberDTO user = (MemberDTO)session.getAttribute("loginUser");
	%>

	<h1>메인페이지 입니다.</h1>
	<% if(user==null){ %>
		<input type="button" value="로그인" onclick="location.href='/instagram/view/login'"/>
	<%}else{ %>
		<input type="button" value="로그아웃" onclick="location.href='/instagram/logout.do'"/>
	<%} %>
	<input type="button" value="회원가입" onclick="location.href='/instagram/view/signup'"/>	
</body>
</html>