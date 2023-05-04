<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container-fluid">
			<div class="col-lg-2">
				<jsp:include page="/WEB-INF/layout/instagram_sidebar.jsp" />
			</div>
			<div class="w-75 m-auto d-flex justify-content-center">
				<div class="col-lg-3 my-3">
					<h3>설정</h3>
				</div>
				
				<div class="col-lg-5 border border-primary mt-5">

					<div class="row pl-5 pt-5">
						<h4>프로필 편집</h4>
					</div>
					<div class="row px-5 pt-3">
						<div class="container">
							<form action="/instagram/member/update.do" method="POST">
							<div class="form-group">
								<label for="name">이름:</label> <input type="text"
									class="form-control" name="name">
							</div>
							<div class="form-group">
								<label for="pass">패스워드:</label> <input type="password"
									class="form-control" name="pass">
							</div>
							<div class="form-group">
								<label for="nickname">닉네임:</label> <input type="text"
									class="form-control" name="nickname">
							</div>
							<div class="form-group">
								<label for="gender">성별:</label> <input type="text"
									class="form-control" name="gender" placeholder="밝히고 싶지 않음">
							</div>
							<div class="form-group">
								<label for="birthday">생년월일:</label> <input type="text"
									class="form-control" name="birthday">
							</div>
							<div class="form-group">
								<label for="email">이메일:</label> <input type="text"
									class="form-control" name="email">
							</div>
							<div class="form-group">
								<label for="tel">전화번호:</label> <input type="text"
									class="form-control" name="tel">
							</div>
							<div class="form-group">
								<label for="website">웹사이트:</label> <input type="text"
									class="form-control" name="website">
							</div>
							<div class="form-group">
								<label for="introduction">소개:</label>
								<textarea class="form-control" rows="5" name="introduction"></textarea>
							</div>
							<div class="d-flex mt-5 justify-content-center">
								<button type="submit" class="btn btn-primary">수정</button>
							</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>