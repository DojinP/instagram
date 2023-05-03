<%@page import="com.multi.instagram.board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>instagram Clone Coding</title>
<link rel="stylesheet" type="text/css"
	href="/instagram/common/css/instagram_main_page_style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
	<%
	ArrayList<BoardDTO> boardlist = (ArrayList<BoardDTO>) request.getAttribute("boardlist");
	%>
	<jsp:include page="/WEB-INF/layout/instagram_sidebar.jsp" />
	<section class="main">
		<div class="wrapper">
			<div class="leftleft-col"></div>
			<div class="left-col">
				<div class="status-wrapper">
					<div class="status-card">
						<div class="profile-pic">
							<img src="/instagram/images/cover 1.png" alt="">
						</div>
						<p class="username">user_name_1</p>
					</div>
					<div class="status-card">
						<div class="profile-pic">
							<img src="/instagram/images/cover 2.png" alt="">
						</div>
						<p class="username">user_name_2</p>
					</div>
					<div class="status-card">
						<div class="profile-pic">
							<img src="/instagram/images/cover 3.png" alt="">
						</div>
						<p class="username">user_name_3</p>
					</div>
				</div>
				<%
				int size = boardlist.size();
				for (int i = 0; i < size; i++) {
					BoardDTO board = boardlist.get(i);
				%>
				<div class="post">
					<div class="info">
						<div class="user">
							<div class="profile-pic">
								<img src="/instagram/images/cover 1.png" alt="">
							</div>
							<p class="username">modern_web_channel</p>
						</div>
						<img src="/instagram/images/option.png" class="options"
							id="update_delete" alt="">
					</div>
					<img src="/instagram/images/cover 1.png" class="post-image" alt="">
					<div class="post-content">
						<div class="reaction-wrapper">
							<img src="/instagram/images/like.png" class="icon" alt="">
							<a class="con-modal-open"> 
								<img src="/instagram/images/comment.png" class="icon" alt="">
								<input type="hidden" name="deptno" value="<%= board.getBoardId() %>"/>
							</a> 
							<img src="/instagram/images/send.png" class="icon" alt="">
							<img src="/instagram/images/save.png" class="save icon" alt="">
						</div>
						<p class="likes">1,012 likes</p>
						<p class="description">
							<span> username </span>
							<%=board.getBoardContent()%>
						</p>
						<p class="post-time"><%=board.getBoardTimestamp()%></p>
					</div>
					<div class="comment-wrapper">
						<img src="/instagram/images/smile.png" class="icon" alt="">
						<input type="text" class="comment-box" placeholder="Add a comment">
						<button class="comment-btn">post</button>
					</div>
				</div>
				<%
				}
				%>
			</div>
			<div class="right-col">
				<div class="profile-card">
					<div class="profile-pic">
						<img src="/instagram/images/profile-pic.png" alt="">
					</div>
					<div class="profile-info">
						<p class="username">modern_web_channel</p>
						<p class="sub-text">kunaal kumar</p>
					</div>
					<button class="action-btn">switch</button>
				</div>
				<p class="suggestion-text">Suggestions for you</p>
				<div class="profile-card">
					<div class="profile-pic">
						<img src="/instagram/images/cover 9.png" alt="">
					</div>
					<div class="profile-info">
						<p class="username">modern_web_channel</p>
						<p class="sub-text">followed bu user</p>
					</div>
					<button class="action-btn">follow</button>
				</div>
				<div class="profile-card">
					<div class="profile-pic">
						<img src="/instagram/images/cover 10.png" alt="">
					</div>
					<div class="profile-info">
						<p class="username">modern_web_channel</p>
						<p class="sub-text">followed bu user</p>
					</div>
					<button class="action-btn">follow</button>
				</div>
				<div class="profile-card">
					<div class="profile-pic">
						<img src="/instagram/images/cover 11.png" alt="">
					</div>
					<div class="profile-info">
						<p class="username">modern_web_channel</p>
						<p class="sub-text">followed bu user</p>
					</div>
					<button class="action-btn">follow</button>
				</div>
				<div class="profile-card">
					<div class="profile-pic">
						<img src="/instagram/images/cover 12.png" alt="">
					</div>
					<div class="profile-info">
						<p class="username">modern_web_channel</p>
						<p class="sub-text">followed bu user</p>
					</div>
					<button class="action-btn">follow</button>
				</div>
				<div class="profile-card">
					<div class="profile-pic">
						<img src="/instagram/images/cover 13.png" alt="">
					</div>
					<div class="profile-info">
						<p class="username">modern_web_channel</p>
						<p class="sub-text">followed bu user</p>
					</div>
					<button class="action-btn">follow</button>
				</div>
			</div>
		</div>
	</section>
	
	<jsp:include page="instagram_main_content.jsp" />
	<jsp:include page="instagram_createBoard_images.jsp" />
	<jsp:include page="instagram_createBoard_maintext.jsp" />
	<jsp:include page="/WEB-INF/layout/instagram_board_popup.jsp" />
</body>
</html>
