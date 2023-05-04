<%@page import="com.multi.instagram.member.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Instagram Clone Coding Side bar</title>
		<link rel="stylesheet" type="text/css" href="/instagram/common/css/instagram_sidebar.css">
	</head>
	<body>
	<%
		MemberDTO user = (MemberDTO)session.getAttribute("loginUser");
	%>
		<div class="navbar">
			<div class="nav-wrapper">
				<a href="/instagram/main.do">
					<img src="/instagram/images/logo.png" class="brand-img" alt="logo">
				</a>
				<div class="nav-items">
					<div class="nav-items-box">
						<a href="#">
							<div class="nav-items-detail">
								<div class="nav-items-img" id="home">
									<img src="/instagram/images/home.png" class="icon" alt="">
								</div>
								<div class="nav-items-text" id="home">홈</div>
							</div>
						</a>
					</div>
					<div class="nav-items-box">
						<a href="#">
							<div class="nav-items-detail" onclick="location.href='/instagram/main/exploration'">
								<div class="nav-items-img">
									<img src="/instagram/images/explore.png" id="search" class="icon" alt="">
								</div>
								<div class="nav-items-text">탐색 탭</div>
							</div>
						</a>
					</div>
					<div class="nav-items-box">
						<a href="#">
							<div class="nav-items-detail" onclick="location.href='/instagram/main/DM'">
								<div class="nav-items-img">
									<img src="/instagram/images/messenger.png" class="icon" alt="">
								</div>
								<div class="nav-items-text">메시지</div>
							</div>
						</a>
					</div>
					<div class="nav-items-box">
						<a href="#">
							<div class="nav-items-detail">
								<div class="nav-items-img">
									<img src="/instagram/images/like.png" class="icon" alt="">
								</div>
								<div class="nav-items-text">알림</div>
							</div>
						</a>
					</div>
					<div class="nav-items-box">
						<a href="#">
							<div class="nav-items-detail" id="createBoard">
								<div class="nav-items-img">
									<img src="/instagram/images/add.png" class="icon" alt="">
								</div>
								<div class="nav-items-text">만들기</div>
							</div>
						</a>
					</div>
					<% if(user==null){ %>
						<div class="nav-items-box">
							<a href="#">
								<div class="nav-items-detail" onclick="location.href='/instagram/view/login'">
									<div class="nav-items-img" id="user_profile" >
										<div class="user_profile_img">
											<img src="/instagram/images/login.png" class="icon" alt="">
										</div>
									</div>
									<div class="nav-items-text">로그인</div>
								</div>
							</a>
						</div>
					<%}else{ %>
						<div class="nav-items-box">
							<a href="#">
								<div class="nav-items-detail" onclick="location.href='/instagram/logout.do'">
									<div class="nav-items-img" id="user_profile">
										<div class="user_profile_img">
											<img src="/instagram/images/logout.png" class="icon"
												alt="">
										</div>
									</div>
									<div class="nav-items-text">로그아웃</div>
								</div>
							</a>
						</div>
						<div class="nav-items-box">
							<a href="#">
								<div class="nav-items-detail" onclick="location.href='/instagram/myprofile'">
									<div class="nav-items-img" id="user_profile" >
										<div class="user_profile_img">
											<img src="/instagram/images/profile-pic.png" class="icon" alt="">
										</div>
									</div>
									<div class="nav-items-text">프로필</div>
								</div>
							</a>
						</div>
						<div class="nav-items-box">
							<a href="#">
								<div class="nav-items-detail" onclick="location.href='/instagram/member/update'">
									<div class="nav-items-img" id="user_profile" >
										<div class="user_profile_img">
											<img src="/instagram/images/profile-pic.png" class="icon" alt="">
										</div>
									</div>
									<div class="nav-items-text">회원수정</div>
								</div>
							</a>
						</div>
						<div class="nav-items-box">
							<a href="#">
								<div class="nav-items-detail" onclick="location.href='/instagram/member/delete.do'">
									<div class="nav-items-img" id="user_profile" >
										<div class="user_profile_img">
											<img src="/instagram/images/profile-pic.png" class="icon" alt="">
										</div>
									</div>
									<div class="nav-items-text">회원탈퇴</div>
								</div>
							</a>
						</div>
					<%} %>
				</div>
			</div>
		</div>
	</body>
</html>