<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>instagram Clone Coding</title>
	<link rel="stylesheet" type="text/css" href="/instagram/common/css/instagram_updateboard.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<script type="text/javascript" src="/instagram/common/js/instagram_updateboard.js"></script>
	
</head>
<body>
	<div class="popup-wrap" id="updatepopup">
		<div class="updatepopup">
			<form class="updateboard" id="updateboard" action="/instagram/board/update.do" method="POST">
				<div class="updatepopup-head">
					<div class="back_space_img" id="updatebackspace">
						<img alt="no_img" src="/instagram/images/back_space.png"/>
					</div>
					<span class="update_board_title">게시물 변경하기</span>
					<input type="submit" value ="공유하기" class="updateboard_share" id="board_share">	
				</div>
				<div class="update_board_content">
					<div class="update_board_img" id="update_board_img">
						
					</div>
					<div class="update_board_content_area">
						<div class="update_profile-area">
							<div class="update_profile-img">
								<img src="/instagram/images/profile-pic.png" alt="">
							</div>
							<div class="update-profile-info" id="update-popup-name">modern_web_channel</div>
						</div>
						<textarea class="updatetext_area" id="updatetext_area" name="boardContent" placeholder= "문구 입력..."></textarea>
						<div class="updatetext_area_bottom">
							<div class="update-emoticon">
								<img src="/instagram/images/smile.png" class="icon" alt=""/>
							</div>
							<div class="updatetext_length">
								<span class="textCount">0</span>
  	 							<span class="textTotal">/2200</span>
							</div>
						</div>
						<hr/>
						<input type="text" name="boardId" id="updatetext_id" value=""/>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>