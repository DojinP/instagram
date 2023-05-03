<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/instagram/common/css/instagram_main_content.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<script type="text/javascript" src="/instagram/common/js/instagram_main_content.js"></script>
</head>
<body>
	<div class="popup-container">
		<!-- //컨테이너 -->
		<div class="con-popup-wrap" id="popup">
			<!-- //모달을 감쌀 박스 -->
			<div class="con-popup">
				<!-- //실질적 모달팝업 -->
				<div class="con-popup-body">
					<!-- //컨텐츠 영역 -->
					<div class="con-body-content">
						<div class="con-body-contentbox-left">
							<div class="con-body-content-img">
								<img src="/instagram/images/f10.jpg" />
							</div>
						</div>
						<div class="con-body-contentbox-right">
							<div class="con-body-contentbox-user-profile">
								<div class="con-maintext_profile-img">
									<img src="/instagram/images/profile-pic.png" alt="">
								</div>
								<div class="con-creatbox-profile-info">modern_web_channel</div>
							</div>
							<div class="con-body-contentbox-content">
								<%  %>
							</div>
							<div class="con-body-contentbox-displaybox">
								<section></section>
								<section></section>
							</div>
							<div class="con-body-contentbox-commentbox">
								<form action="" class="con-body-contentbox-commentbox-form">
									<div class="commentbox-form-div">
										<div class="commentbox-form-div-icon">
											<img src="/instagram/images/smile.png" class="icon" alt="" />
										</div>
										<div class="commentbox-form-div-textarea">
											<textarea aria-label="댓글 달기..." placeholder="댓글 달기..." autocorrect="off"></textarea>
										</div>
										<div class="submit"><input type="submit" value="게시" class="submit_btn"></div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>