<%@page import="com.multi.instagram.member.MemberDTO"%>
<%@page import="com.multi.instagram.like.LikeDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.multi.instagram.board.BoardFileDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.multi.instagram.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>instagram Clone Coding</title>
        <link rel="stylesheet" type="text/css" href="/instagram/common/css/instagram_main_page_style.css"/>
	</head>
	<body>
		<%
			ArrayList<BoardDTO> boardlist = (ArrayList<BoardDTO>) request.getAttribute("boardlist");
			ArrayList<BoardFileDTO> boardfilelist = (ArrayList<BoardFileDTO>) request.getAttribute("boardfilelist");
			ArrayList<MemberDTO> memberlist = (ArrayList<MemberDTO>) request.getAttribute("memberlist");
			MemberDTO loginUser = (MemberDTO)session.getAttribute("loginUser");
		%>
		<jsp:include page="../layout/instagram_sidebar.jsp"/>
        <section class="main">
            <div class="wrapper">
                <div class="leftleft-col"></div>
                <div class="left-col">
                    <div class="status-wrapper">
                        <div class="status-card">
                            <div class="profile-pic"><img src="/instagram/images/cover 1.png" alt=""></div>
                            <p class="username">user_name_1</p>
                        </div>
                        <div class="status-card">
                            <div class="profile-pic"><img src="/instagram/images/cover 2.png" alt=""></div>
                            <p class="username">user_name_2</p>
                        </div>
                        <div class="status-card">
                            <div class="profile-pic"><img src="/instagram/images/cover 3.png" alt=""></div>
                            <p class="username">user_name_3</p>
                        </div>
                    </div>
                    <%	int boardlistsize = boardlist.size() - 1;
						for(int i=boardlistsize; i>=0; i--){
							BoardDTO board = boardlist.get(i); %>
                    <div class="post">
                        <div class="info">
                            <div class="user">
                                <div class="profile-pic"><img src="/instagram/images/cover 1.png" alt=""></div>
                                <%	int memberlistsize = memberlist.size() - 1;
                                	for(int m=memberlistsize; m>=0; m--){
                                		MemberDTO member = memberlist.get(m);
                                		if(member.getId().equals(board.getWriterId())){
                                %>
                                		<p class="username"><%=member.getNickname() %></p>
                                <% 
                                		}
                                	}
                                %>
                            </div>
                            <div>
                            	<img src="/instagram/images/option.png" class="options" id="<%=board.getBoardId()%>" name="boardwriter<%=board.getWriterId()%>" alt="">
                            </div>
                        </div>
                        <%
                        	int boardfilelistsize = boardfilelist.size() - 1;
                        	for(int j=boardfilelistsize; j>=0; j--) {
                        		BoardFileDTO boardfile = boardfilelist.get(j);
                        		if(boardfile.getBoardId() == board.getBoardId()){
                        %>
                      			<img src="/instagram/upload/<%=boardfile.getStoreFilename() %>" class="post-image" alt="">
                        <% 		
                        		}
                        	}
                        %>
                        <div class="post-content">
                            <div class="reaction-wrapper">
                                <a href="/instagram/like_insert.do?boardId=<%=board.getBoardId()%>&userId=<%=loginUser.getId() %>">
                                	<%
								List<LikeDTO> count = board.getLikeList();
								String imgName = "like";
								if (count != null) {
									imgName = count.size() > 0 ? "like2" : "like";
								} 
								%> <img src="/instagram/images/<%=imgName%>.png" class="icon"
								id="likeHeart" alt="">
                                </a>
                                <img src="/instagram/images/comment.png" class="con-modal-open" id="con<%=board.getBoardId()%>" name="<%=board.getWriterId() %>" value="<%=loginUser.getId() %>" alt="">
                                <img src="/instagram/images/send.png" class="icon" alt="">
                                <img src="/instagram/images/save.png" class="save icon" alt="">
                            </div>
                            <p class="likes"><%=board.getLike_count() %>likes</p>
                            <p class="description">
                            	<span>
                            		<%
                                		for(int m=memberlistsize; m>=0; m--){
                                			MemberDTO member = memberlist.get(m);
                                			if(member.getId().equals(board.getWriterId())){
                                	%>
                                			<%=member.getNickname() %>
                                	<% 
                                		}
                                	}
                                	%> 
                            	
                            	</span> <%=board.getBoardContent() %></p>
                            <p class="post-time"><%=board.getBoardTimestamp() %></p>
                            <p class="comment">
                            	<span>
                            		댓글
                            	</span>
                            	더보기
                            </p>
                        </div>
                        <div class="comment-wrapper">
                            <img src="/instagram/images/smile.png" class="icon" alt="">
                            <form action="/instagram/comment/insert.do" method="get"
                            	class="comment-box-form">
                            	<input type="text" class="comment-box" name="content" placeholder="Add a comment">
                            	<input type="hidden" name="board_id" value="<%=board.getBoardId() %>">
                            	<input type="hidden" name="user_id" value="<%=loginUser.getId() %>">
                            	<button type="submit" class="comment-btn">post</button>
                            </form>
                        </div>
                    </div>
                    <%} %>
                </div>
                <div class="right-col">
                    <div class="profile-card">
                        <div class="profile-pic">
                            <img src="/instagram/images/profile-pic.png" alt="">
                        </div>
                        <div class="profile-info">
                            <p class="username" id="connect-user-nick"><%=loginUser.getNickname() %></p>
                            <p class="sub-text">kunaal kumar</p>
                        </div>
                        <button class="action-btn">switch</button>
                    </div>
                    <p class="suggestion-text">Suggestions for you</p>
                    <%	
                    	int memberlistsize = memberlist.size() - 1;
                        for(int m = memberlistsize; m >= 0; m--){
                        	MemberDTO member = memberlist.get(m);
                        	if(!member.getId().equals(loginUser.getId())){
                    %>
	   					<div class="profile-card">
	                        <div class="profile-pic">
	                            <img src="/instagram/images/cover 9.png" alt="">
	                        </div>
	                        <div class="profile-info">
	                            <p class="username"><%=member.getNickname() %></p>
	                            <p class="sub-text">followed by user</p>
	                        </div>
	                        <button class="action-btn">follow</button>
	                    </div>
                    <% 
                        	}
                    	}
                    %>
                </div>
            </div>
        </section>
        <%-- <jsp:include page="instagram_createBoard_images.jsp"/> --%>
        <jsp:include page="instagram_createBoard_maintext.jsp"/>
        <jsp:include page="../layout/instagram_board_popup.jsp"/>
        <jsp:include page="instagram_main_content.jsp"/>
        <jsp:include page="instagram_updateboard.jsp"/>
	</body>
</html>
