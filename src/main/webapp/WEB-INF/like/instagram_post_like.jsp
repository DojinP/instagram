<%@page import="com.multi.instagram.member.MemberDTO"%>
<%@page import="com.multi.instagram.board.BoardFileDTO"%>
<%@page import="com.multi.instagram.board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.multi.instagram.like.LikeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Instargram</title>
<link rel="stylesheet" type="text/css"
	href="/instagram/common/css/instargram_post_like.css" />

</head>
<body>
	<jsp:include page="../layout/instagram_sidebar.jsp" />
	
	<%
	ArrayList<LikeDTO> likelist = (ArrayList<LikeDTO>) request.getAttribute("likelist");
	
	%>
	<!--  ArrayList<BoardFileDTO> boardfilelist = (ArrayList<BoardFileDTO>) request.getAttribute("boardfilelist");
	ArrayList<MemberDTO> memberlist = (ArrayList<MemberDTO>) request.getAttribute("memberlist");
	MemberDTO loginUser = (MemberDTO) session.getAttribute("loginUser");-->
	
	
	
	<div class="bigbox">
		<div class="leftbox">
			<div id="topbox">&nbsp&nbsp내가 좋아요를 누른 게시물</div>
			<div class="boximg0">
				<div>
					<div class="writebox">
						<div class="write">반응</div>
						<div class="write2">좋아요, 댓글 및 회원님의 기타 반응을 검토하고 삭제합니다.</div>
					</div>
					<img src="/instagram/images/image11.png" class="icon2" alt="">

				</div>
				 <div>
					<div class="writebox">
						<div class="write">사진 및 동영상</div>
						<div class="write2">공유한 사진과 동영상을 보거나 보관하거나 삭제합니다.</div>
					</div>
					<img src="/instagram/images/image12.png" class="icon2" alt="">

				</div>
				<div>
					<div class="writebox">
						<div class="write">계정 내역</div>
						<div class="write2">계정을 만든 이후 적용한 변경 사항을 검토해보세요.</div>
					</div>
					<img src="/instagram/images/image13.png" class="icon2" alt="">

				</div>
				<div>
					<div class="writebox">
						<div class="write">내 정보 다운로드</div>
						<div class="write2">instagram에 공유한 정보의 사본을 다운로드합니다.</div>
					</div>
					<img src="/instagram/images/image14.png" class="icon2" alt="">

				</div>

			</div>
		</div>
		<div>

		<div class="div0">
			<div class="boximg1">
				<div class="rightbox">
					
						<img src="/instagram/images/image15.png" class="icon3" alt=""> 
						<span class="wb2">좋아요</span> 
						<img src="/instagram/images/image16.png"	class="icon3" alt=""> 
						<span class="wb2">댓글</span> 
						<img src="/instagram/images/image17.png" class="icon3" alt=""> 
						<span class="wb2">스토리 답장</span> 
						<img src="/instagram/images/image18.png" class="icon3" alt=""> 
						<span class="wb2">리뷰</span> 

				</div>
				
			</div>

		<div class="div1">
			<div class="middlebox">
				<div class="midwrite">
					<div>최신순</div> 
					<div><input type="button"
						value="정렬 및 필터" id="fil"></div>
					<div id="select">선택</div>
				</div>
			</div>
			
			<div class="midimg1">
		
				<%
				int likelistsize = likelist.size()-1;
				for(int i=likelistsize; i>=0; i--){
				%>
				
				<img src="/instagram/upload/<%=likelist.get(i).getStoreFilename()%>"
						class="midimg2" alt="" >
				<%} %>
			</div>
		</div>
		
	</div>
	<footer id="footer">
		<span class="footwt">Meta</span>
		<span class="footwt">소개</span>
		<span class="footwt">블로그</span>
		<span class="footwt">채용 정보</span>
		<span class="footwt">도움말</span>
		<span class="footwt">API</span>
		<span class="footwt">개인정보처리방침</span>
		<span class="footwt">약관</span>
		<span class="footwt">인기 계정</span>
		<span class="footwt">위치</span>
		<span class="footwt">Instagram Lite</span>
		<span class="footwt">연락처 업로드 & 비사용자</span>
		<span class="footwt">Meta Verified</span>
		<div class="footwt2">
			<span class="footwt">
				<select name="lang">
					<option value="kor">한국어
					<option value="jap">일본어
					<option value="ch">중국어
					<option value="en">영어
					<option value="rus">러시아어
					<option value="ar">아랍어
					
				</select>
			</span>
			<span class="footwt">©2023 Instagram from Meta</span>
		</div>
	</footer>

	</div>

</body>
</html>