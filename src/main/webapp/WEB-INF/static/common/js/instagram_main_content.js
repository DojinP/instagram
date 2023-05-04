$(document).ready(function() {
	myid="";
	contentId="";
	userId = "";

	$(document).mouseup(function(e) {
		if ($(".con-popup-wrap").has(e.target).length === 0) {
			$(".con-popup-wrap").fadeOut();
		}
	});
	$(".con-modal-open").each(function() {
		$(this).click(function() {
			myid = $(this).attr("id");
			myname = $(this).attr("name");
			userId = $(this).attr("value");
			contentId = myid.substring(3);
			$("#popup_board_id").val(contentId);
			$("#popup_user_id").val(userId);
			var querydata1 = {"board_id":contentId, "writer_id":myname};
			$("#contentbox_comment").html("");
			$.ajax({
                url:"/instagram/board/read.do",
                type:"get",
                data:querydata1,
                success:function(data){
                	$("#nickname").text(data.memberNickname);
                	$("#board_img").html("<img src= '/instagram/upload/"+data.storeFilename+"'/>");
                	$("#contentbox_writer_content").text(data.boardContent);
                		
                },
                error:function(){
                	alert("오류메시지1=>"+obj+","+msg+","+statusmsg);
                }

            });
            
            var querydata2 = {"board_id":contentId};
            $.ajax({
            	url:"/instagram/comment/list.do",
                type:"get",
                data:querydata2,
                success:function(data){
                	$.each(data, function(index, item){
                		var querydata3 = {"member_id":item.user_id};
                		$.ajax({
                			url:"/instagram/member/nickname.do",
                			type:"get",
                			data:querydata3,
                			success:function(data){
                				//alert(data);
                				$("#contentbox_comment").prepend("<div class='comment_insert'><div class='comment_box'><span class='comment_user'>"+data+"</span> "+item.content
                												+"</div><div class='delete_button' id='"+item.comment_id+"'><img class='comment_delete_img' src='/instagram/images/delete_icon.png'></div></div>");
                				
                			},
                			error:function(obj, msg, statusmsg){
                				alert("오류메시지2=>"+obj+","+msg+","+statusmsg);
               				}

           				})                		
                	});
                },
                error:function(){
                	alert("오류메시지3=>"+obj+","+msg+","+statusmsg);
                }
            });
            
	        $(".delete_button").each(function() {
				$(this).click(function() {
					deleteid = $(this).attr("id");
					var querydata4 = {"content_id":deleteid};
					$.ajax({
		                url:"/instagram/comment/delete.do",
		                type:"get",
		                data:querydata4,
		                success:function(data){
		                	location.href="/instagram/main.do";
		                		
		                },
		                error:function(obj, msg, statusmsg){
		                	alert("오류메시지4=>"+obj+","+msg+","+statusmsg);
		                }
		
		            });
				});
			});
            
			$(".con-popup-wrap").css('display', 'flex').hide().fadeIn();
		});
	});
	
});