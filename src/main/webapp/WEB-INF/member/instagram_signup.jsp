<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/instagram/common/css/instagram_signup.css" />
<title>Instagram clone - signup</title>
</head>
<body>
	<main class="flex align-items-center justify-content-center">
		<section id="mobile" class="flex"></section>
		<section id="auth" class="flex direction-column">
			<div class="panel login flex direction-column">
				<div class="logo-in-panel flex justify-content-center">
					<i style="background-image: url(https://static.cdninstagram.com/rsrc.php/v3/yS/r/ajlEU-wEDyo.png); 
						background-position: 0px -52px;
    					background-size: auto;
    					width: 175px;
					    height: 51px;
					    background-repeat: no-repeat;
					    display: inline-block;">
					</i>
				</div>
				<form class="form" action="/instagram/signup.do" method="POST">
					<h2>친구들의 사진과 동영상을 보려면 가입하세요.</h2>
					<div class="facebook-button-div">
						<button class="login-with-fb flex direction-row align-items-center justify-content-center">
							<span class="facebook-icon"></span> Facebook으로 로그인
						</button>
					</div>
					<div class="separator-div">
						<div class="flex separator align-items-center">
							<span></span>
							<div class="or">또는</div>
							<span></span>
						</div>
					</div>
					<div class="input-div">
						<input name="email" type="text" placeholder="이메일 주소" /> 
						<label for="email" class="sr-only">휴대폰 번호 또는 이메일 주소</label>
					</div>
					<div class="input-div">
						<input name="name" type="text" placeholder="성명" /> 
						<label for="name" class="sr-only">성명</label>
					</div>
					<div class="input-div">
						<input name="nickname" type="text" placeholder="사용자 이름" /> 
						<label for="nickname" class="sr-only">사용자 이름</label>
					</div>
					<div class="input-div">
						<input name="pass" type="password" placeholder="비밀번호" /> 
						<label for="pass" class="sr-only">비밀번호</label>
					</div>
					
					<div class="facebook-button-div">
						<button type="submit" class="login-with-fb flex direction-row align-items-center justify-content-center">가입</button>
					</div>
				</form>
			</div>
			<div class="panel register flex justify-content-center">
				<p>계정이 있으신가요?</p>
				<a href="/instagram/view/login">로그인</a>
			</div>
			
			<div class="app-download flex direction-column align-items-center">
				<p>앱을 다운로드하세요.</p>
				<div class="flex justify-content-center">
					<img src="/instagram/images/apple-button.png"
						alt="Imagem com a logo da Apple Store"
						title="Imagem com a logo da Apple Store" /> <img
						src="/instagram/images/googleplay-button.png"
						alt="Imagem com a logo da Google Play"
						title="Imagem com a logo da Google Play" />
				</div>
			</div>
		</section>
	</main>
	<footer>
		<div class="footer_main_div">
			<div class="link_list_div">
				<ul class="flex flex-wrap justify-content-center">
					<li><a href="#">Meta</a></li>
					<li><a href="#">소개</a></li>
					<li><a href="#">블로그</a></li>
					<li><a href="#">채용정보</a></li>
					<li><a href="#">도움말</a></li>
					<li><a href="#">API</a></li>
					<li><a href="#">개인정보처리방침</a></li>
					<li><a href="#">약관</a></li>
					<li><a href="#">인기계정</a></li>
					<li><a href="#">위치</a></li>
					<li><a href="#">Instagram Lite</a></li>
					<li><a href="#">연락처 업로드 & 비사용자</a></li>
					<li><a href="#">Meta Verified</a></li>
				</ul>
			</div>
			<div class="copyright_div">
				<p class="copyright">© 2023 Instagram from Meta</p>
			</div>
		</div>
	</footer>
</body>
</html>