<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/instagram/common/css/instagram_login.css" />
<title>Instagram clone - login</title>
</head>
<body>
	<main class="flex align-items-center justify-content-center">
		<section id="mobile" class="flex"></section>
		<section id="auth" class="flex direction-column">
			<div class="panel login flex direction-column">
				<h1 title="Instagram" class="flex justify-content-center">
					<img src="/instagram/images/instagram-logo.png"
						alt="Instagram logo" title="Instagram logo" />
				</h1>
				<form action="/instagram/login.do" method="POST">
					<input name="email" placeholder="이메일" /> 
					<label for="email" class="sr-only">전화번호, 사용자 이름 또는 이메일 </label> 
					<input name="pass" type="password" placeholder="비밀번호" /> 
					<label for="pass" class="sr-only">비밀번호</label>

					<!-- <button type="button" onclick="location.href='instargram_main_page.jsp'">로그인</button> -->
					<button type="submit" >로그인</button>
				</form>
				<div class="flex separator align-items-center">
					<span></span>
					<div class="or">또는</div>
					<span></span>
				</div>
				<!-- <div class="login-with-fb flex direction-column align-items-center"> -->
				<button class="login-with-fb flex direction-row align-items-center justify-content-center">
					<span class="facebook-icon"></span> <span>Facebook으로 로그인</span>
				</button>

				<a href="#">비밀번호를 잊으셨나요?</a>
				<!-- </div> -->
			</div>
			<div class="panel register flex justify-content-center">
				<p>계정이 없으신가요?</p>
				<a href="/instagram/view/signup">가입하기</a>
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
		<p class="copyright">© 2023 Instagram from Meta</p>
	</footer>
</body>
</html>