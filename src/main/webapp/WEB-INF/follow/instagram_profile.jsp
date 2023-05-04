<%@page import="com.multi.instagram.follow.FollowDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.multi.instagram.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	MemberDTO member = (MemberDTO) session.getAttribute("member");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/instagram/common/css/instagram_my_profile.css">
<link rel="stylesheet" type="text/css"
	href="/instagram/common/css/instagram_follow_popup.css">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js "></script>
	
<script
  src="https://code.jquery.com/jquery-3.6.4.js"
  integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
  crossorigin="anonymous"></script>
</head>

<body>

	<jsp:include page="../layout/instagram_sidebar.jsp" />
	<jsp:include page="../layout/instagram_profile_top.jsp">
		<jsp:param name="followingCount" value='<%=request.getAttribute("followingCount") %>'></jsp:param>
		<jsp:param name="followerCount" value='<%=request.getAttribute("followerCount") %>'></jsp:param>
	</jsp:include>
	
	<script type="text/javascript">
	function fnOpenPopup (popupType) {
		var url = "";
		if (popupType == 'follower') {
			url = "/instagram/open_follower_popup.do?member_id=" + "<%= member.getId()%>";
			url += "&pageType=" + "<%= request.getAttribute("pageType")%>";
			$("#followerModal").load(url);
		} else {
			url = "/instagram/open_follow_popup.do?member_id=" + "<%= member.getId()%>";
			url += "&pageType=" + "<%= request.getAttribute("pageType")%>";
			$("#followModal").load(url);
		}
	}
	</script>
	
	<div id="target_follower_modal" class="modal">
		<div id="followerModal" class="modal-size modal-dialog modal-dialog-scrollable">
		</div>
	</div>
	<div id="target_follow_modal" class="modal">
		<div id="followModal" class="modal-size modal-dialog modal-dialog-scrollable">
		</div>
	</div>
		
</body>
</html>