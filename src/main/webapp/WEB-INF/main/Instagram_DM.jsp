<%@page import="java.util.List"%>
<%@page import="com.multi.instagram.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/instagram/common/css/instagram_DM.css">

<script type="text/javascript"
	src="/instagram/common/js/instagram_DM.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
</head>
<jsp:include page="/WEB-INF/layout/instagram_sidebar.jsp" />
<body>
	<%
	MemberDTO member = (MemberDTO) session.getAttribute("loginUser");

	List<MemberDTO> userlist = (List<MemberDTO>) request.getAttribute("userList");
	%>
	<main>
		<div class="preview">
			<div id="user-name"><%=member.getName()%></div>
			<div class="previewselect">
				<div id="add-user">
					<span id="pic-div"> <img id="pic"
						src="/instagram/images/add.png">
					</span>
					<div >
						<span id="name">Add New Chat 😉</span>
					</div>
				</div>
			</div>
		</div>
		<div class="chats">
			<div class="chat-banner">
				<span id="chat-pic"> <img id="pic"
					src="https://i.pinimg.com/564x/10/8b/0a/108b0a398d44292efb2fa4b755fdbf33.jpg" />
				</span>
				<div id="sender_name">
					<h5>rn2rg22sdj</h5>
				</div>
				<div class="dropdown">
					<i class='fas fa-info'></i>
				</div>
			</div>
			<div class="chatroom">
			</div>
			<div class="input-msg">
				<input type="text" id="send-input" placeholder="type something"
					onfocus="this.value=''" maxlength="250" /> <i
					class='far fa-paper-plane'></i>
			</div>
		</div>
	</main>
	<!-- 모달 팝업 -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Add New Chat 😉</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form>
						<input type="text" id="modal_search" placeholder="Add New Chat 😉"
							onfocus="this.value=''" />
					</form>
				</div>
				<div id="modal_result">
					<div >
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Search!</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>