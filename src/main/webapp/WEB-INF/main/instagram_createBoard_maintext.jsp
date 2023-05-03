<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>instagram Clone Coding</title>
	<link rel="stylesheet" type="text/css" href="/instagram/common/css/instagram_createBoard_maintext.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<script type="text/javascript" src="/instagram/common/js/instagram_createBoard_maintext.js"></script>
	
</head>
<body>
	<div class="popup-wrap" id="maintextpopup">
		<div class="maintextpopup">
			<form class="newboard_share" action="/instagram/board/content/insert.do" method="GET">
				<div class="maintextpopup-head">
					<div class="back_space_img" id="createbackspace">
						<img alt="no_img" src="/instagram/images/back_space.png"/>
					</div>
					<span class="maintext_board_title">새 게시물 만들기</span>
					<input type="submit" action="/instagram/board/content/insert.do" 
								value ="공유하기" class="board_share" id="board_share">	
				</div>
				<div class="maintext_board_content">
					<div class="maintext_board_img">
						<img class="board_custom_img" id="insertImage" src="/instagram/images/cover 2.png" alt="">
					</div>
					<div class="maintext_board_content_area">
						<div class="maintext_profile-area">
							<div class="maintext_profile-img">
								<img src="/instagram/images/profile-pic.png" alt="">
							</div>
							<div class="creatbox-profile-info">modern_web_channel</div>
						</div>
						<textarea class="text_area" name="boardcontext" placeholder= "문구 입력..."></textarea>
						<div class="text_area_bottom">
							<div class="createbox-emoticon">
								<img src="/instagram/images/smile.png" class="icon" alt=""/>
							</div>
							<div class="text_length">
								<span class="textCount">0</span>
  	 							<span class="textTotal">/2200</span>
							</div>
						</div>
						<hr/>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>