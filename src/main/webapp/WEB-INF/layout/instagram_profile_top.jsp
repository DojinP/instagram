<%@page import="com.multi.instagram.follow.FollowDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.multi.instagram.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css"
	href="/instagram/common/css/instagram_profile_top.css">

<%
	MemberDTO session_member = (MemberDTO) session.getAttribute("loginUser");
	MemberDTO member = (MemberDTO) request.getAttribute("member");
	FollowDTO followAsMember = (FollowDTO) request.getAttribute("followAsMember");
%>
<div>
	<div class="wrapper">
		<div class="profile_contents_box">
			<div class="profile_image_box">
				<img class="profile_image" src="/instagram/images/cover 1.png">
			</div>
			<div class="profile_contents_box2">
				<div class="top1">
					<div class="profile_id">
						<!-- 닉네임으로 변경 -->
						<span class="user_id"><%=session_member.getNickname()%></span>

						<%
						/* if (session_member != null & ) { */
						 if (request.getAttribute("pageType").equals("my")) { 
						%>
						<!-- 회원정보수정작성 -->
						<a href="/instagram/member/update.do"> <img
							src="/instagram/images/settings.png"
							style="width: 20px; height: 20px;">
						</a>
						<%
						} else {
						%>
						<button class='my_btn'
							onclick="location.href='/instagram/follow/connectFollow.do?following_id=<%=member.getId()%>'">팔로우</button>
						<%
						}
						%>
					</div>
				</div>
				<div class="top2">
					<ul class="text_box">
						<li class="text_list">게시물 20</li>
						<li class="text_list">
							<button type="button" class="bnt" id="btnOpenModal"
								onclick="javascript:fnOpenPopup('follower');"
								data-toggle="modal" data-target="#target_follower_modal">
								팔로워<%=request.getAttribute("followingCount")%></button>
						</li>
						<li class="text_list">
							<button type="button" class="bnt" id="btnOpenModal"
								onclick="javascript:fnOpenPopup();" data-toggle="modal"
								data-target="#target_follow_modal">
								팔로우<%=request.getAttribute("followerCount")%></button>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="profile_contents_box">
			<div class="story_image_box image_padding">
				<img class="story_image" src="/instagram/images/cover 1.png">
				<p class="story_text">aaa</p>
			</div>
			<div class="story_image_box image_padding">
				<img class="story_image" src="/instagram/images/cover 2.png">
				<p class="story_text">aaa</p>
			</div>
			<div class="story_image_box image_padding">
				<img class="story_image" src="/instagram/images/cover 3.png">
				<p class="story_text">aaa</p>
			</div>
			<div class="story_image_box">
				<img class="story_image"
					src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Cercle_noir_100%25.svg/330px-Cercle_noir_100%25.svg.png">
				<p class="story_text">신규</p>
			</div>
		</div>
	</div>

	<div class="rightbox" id="bbb">

		<img src="/instagram/images/i1.png" class="icon4" alt=""> <span
			class="wb2" id="bbb1">게시물</span> <img src="/instagram/images/i2.png"
			class="icon4" alt=""> <span class="wb2">릴스</span> <img
			src="/instagram/images/i3.png" class="icon4" alt=""> <span
			class="wb2"><a href="/instagram/save.do">저장됨</a></span> <img
			src="/instagram/images/i4.png" class="icon4" alt=""> <span
			class="wb2">태그됨</span>

	</div>

</div>

</html>