<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>instagram Clone Coding</title>
		<link rel="stylesheet" type="text/css" href="/instagram/common/css/instagram_board_popup.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<script type="text/javascript" src="/instagram/common/js/instagram_board_popup.js"></script>
	</head>
	<body>
		<div class="container">
			<div class="popup-wrap" id="popup">
				<div class="popup">
					<div class="popup-head">
						<span class="head-title"></span>
					</div>
					<div class="popup-body">
						<div class="body-content">
							<div class="body-contentbox">
								<span class="update_delete_butten">update</span>
							</div>
							<hr/>
							<div class="body-contentbox">
								<span class="update_delete_butten">delete</span>
							</div>
							<hr/>
							<div class="body-contentbox" id="close">
								<span class="update_delete_butten">cancel</span>
							</div>
						</div>
					</div>
					<div class="popup-foot">
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
