<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>instagram Clone Coding</title>
		<link rel="stylesheet" type="text/css" href="/instagram/common/css/instagram_createBoard_images.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<script type="text/javascript" src="/instagram/common/js/instagram_createBoard_images.js"></script>
	</head>
	<body>
		<div class="popup-wrap" id="createboardpopup">
			<div class="createboardpopup">
				<div class="createboardpopup-head">
					<span class="board_title">새 게시물 만들기</span>
				</div>
				<form class="img_insert_form">
					<div class="board_content">
						<div class="board_img">
							<img alt="no_img" src="/instagram/images/instar_img1.png" />
						</div>
						<div class="board_text">사진과 동영상을 여기에 끌어다 놓으세요</div> 
						<label class="img_insert_lable" for="imginsert_file">
							<div class="img_insert_button" id="createBoardNext">컴퓨터에서 선택</div>
						</label> 
						<input type="file" name="insertImage" id="imginsert_file"
							onchange="document.getElementById('insertImage').src = window.URL.createObjectURL(this.files[0])"
                            accept="image/*">
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
