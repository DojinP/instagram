<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>instagram Clone Coding</title>
<link rel="stylesheet" type="text/css"
	href="/instagram/common/css/instagram_board_popup.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript">
	myid = "";
	
	$(document).ready(function() {
		$(document).mouseup(function(e) {
			if ($("#boardpopup").has(e.target).length === 0) {
				$("#boardpopup").fadeOut();
			}
		});
		$(".options").each(function() {
			$(this).click(function() {
				boardid = $(this).attr("id");
				boardwriter = $(this).attr("name");
				boardwritername = boardwriter.substring(11);
				$("#boardpopup").css('display', 'flex').hide().fadeIn();
			});
		});

		$("#popupclose").click(function() {
			modalClose(); //모달 닫기 함수 호출
		});
		function modalClose() {
			$("#boardpopup").fadeOut(); //페이드아웃 효과
		}
		
		$("#update_button").click(function() {
			modalClose(); //모달 닫기 함수 호출
			var querydata = {"board_id":boardid, "writer_id":boardwritername};
			$.ajax({
                url:"/instagram/board/read.do",
                type:"get",
                data:querydata,
                success:function(data){
                	$("#update-popup-name").text(data.memberNickname);
                	$("#update_board_img").html("<img class='updateboard_custom_img' src='/instagram/upload/"+data.storeFilename+"' />");
                	$("#updatetext_area").text(data.boardContent);
                	$("#updatetext_id").attr('value', data.boardId);
                	//alert($("#updatetext_id").val())
                },
                error:function(){
                	alert("오류메시지=>"+obj+","+msg+","+statusmsg);
                }

            });
		});
		
		$("#delete_button").click(function(){
			alert("삭제");
			location.href="/instagram/board/delete.do?board_id="+boardid;
		});
	});
</script>
</head>
<body>
	<div class="popup-wrap" id="boardpopup">
		<div class="popup">
			<div class="popup-head">
				<span class="head-title"></span>
			</div>
			<form>
				<div class="popup-body">
					<div class="body-content">
						<div class="body-contentbox">
							<span class="update_delete_butten" id="update_button">update</span>
						</div>
						<hr />
						<div class="body-contentbox">
							<span class="update_delete_butten" id="delete_button">delete</span>
						</div>
						<hr />
						<div class="body-contentbox" id="popupclose">
							<span class="update_delete_butten">cancel</span>
						</div>
					</div>
				</div>
			</form>
			<div class="popup-foot"></div>
		</div>
	</div>
</body>
</html>
