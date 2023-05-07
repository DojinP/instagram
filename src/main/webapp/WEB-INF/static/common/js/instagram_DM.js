$(document).ready(function() {
		$('#add-user').click(function() {
			$('#exampleModal').modal('show');
		});
});

$(document).ready(function() {
  // Search button 클릭 시 이벤트 처리
  $('.btn-primary').click(function() {
    // 검색어 가져오기
    var searchKeyword = $('#modal_search').val();
    // AJAX로 list.do에 요청을 보내서 user list 가져오기
    $.ajax({
      url: 'list.do',
      type: 'GET',
      data: { member_id: searchKeyword },
      success: function(data) {
        // 받아온 user 정보를 가지고 필요한 DOM element 생성
       var userDiv = $('<div>').attr('id', 'userlist');
        
        for (var i = 0; i < data.length; i++) {
          var picDiv = $('<span>').attr('id', 'pic-div');
          var img = $('<img>').attr('id', 'pic').attr('src', "https://i.pinimg.com/564x/af/d1/12/afd1126225d818c7c5058e11b4b260c3.jpg"); //data[i].pic_url
          var nameDiv = $('<div>').attr('id', 'chat-username');
          var nameSpan = $('<span>').attr('id', data[i].id).data('id', data[i].id).text(data[i].name);
          
          // 생성한 element들을 모달 팝업 내부에 추가
          picDiv.append(img);
          nameDiv.append(nameSpan);
          userDiv.append($('<div>').append(picDiv).append(nameDiv));
        }
        
        $('#modal_result').empty().append(userDiv.children());
      },
      error: function(jqXHR, textStatus, errorThrown) {
        alert('Error!');
      }
    });
  });
});

$(document).on('click', '#modal_result div', function() {
 var id = $(this).find('span').attr('id');
  alert(id);
  var loginUser = "${sessionScope.loginUser.id}";
  $.ajax({
    url: 'createboard.do',
    data: {
      opponent: id
      //session: loginUser
    },
    success: function(response) {
      // AJAX 요청이 성공했을 때 실행할 코드
    },
    error: function(xhr, status, error) {
      // AJAX 요청이 실패했을 때 실행할 코드
    }
  });
});


$(document).on('click','#addeduser', function() {
  var DMId = $(this).data('dm-id');
  $.ajax({
    url: 'chatlist.do',
    method: 'GET',
    data: { dmId: DMId },  //,session: '${sessionScope.loginUser.id}'
    success: function(response) {
      var chatroom = $('.chatroom');
      chatroom.attr('data-dm-id', DMId); // chatroom 요소에 data-dm-id attribute 추가
      chatroom.empty();
      console.log(chatroom.attr('data-dm-id'));
      console.log(chatroom.data('dm-id'));
      for (var i = 0; i < response.length; i++) {
        var chatroomId = response[i].dm_id;
        var senderId = response[i].sender_id;
        var message = response[i].message_content;

        if (senderId === "1") {
          var receiver = $('<div>').addClass('receiver').text(message);
          chatroom.append(receiver);
        } else {
          var sender = $('<div>').addClass('sender').text(message);
          chatroom.append(sender);
        }
      }
    },
    error: function(xhr, status, error) {
      console.log(error);
    }
  });
});
 
$(function() {
  // i tag click event
  $('.fa-paper-plane').on('click', function() {
    sendMessage();
  });

  // Enter key press event
  $('#send-input').keypress(function(e) {
    if (e.which == 13) {
      sendMessage();
    }
  });
  
 // 로그인한 사용자의 아이디 session: '${sessionScope.loginUser.id}'
$.ajax({
    url: 'boardlist.do',
    type: 'GET',
    data: { },
    success: function(response) {
        // boardlist.do로부터 받아온 데이터를 처리해서 새로운 요소를 생성합니다.
        // 예를 들어, 받아온 데이터가 JSON 형태라면 다음과 같이 처리할 수 있습니다.
        $.each(response, function(index, item) {
            var user = $('<div>').attr('id', 'addeduser').attr('data-dm-id', item.dm_id);
            var picDiv = $('<span>').attr('id', 'pic-div');
            var pic = $('<img>').attr('id', 'pic').attr('src',  "https://i.pinimg.com/564x/af/d1/12/afd1126225d818c7c5058e11b4b260c3.jpg");
            var chatUsername = $('<div>').attr('id', 'chat-username');
            var name = $('<span>').attr('id', 'name').text("Chatroom"+ ' (' + item.dm_id + ')');
            
            picDiv.append(pic);
            chatUsername.append(name);
            user.append(picDiv).append(chatUsername);
            
            $('.previewselect').append(user);
        });
    },
    error: function(xhr, status, error) {
        // AJAX 요청이 실패했을 때 실행할 코드
    }
});
  function sendMessage() {
    var message = $('#send-input').val().trim();
    var chatroomId = $('.chatroom').data('dm-id');
    if (message !== '') {
      $.ajax({
        type: "POST",
        url: "chatinsert.do",
        data: { message_content: message, dmId : chatroomId 
        //,session: '${sessionScope.loginUser.id}' 
        },
        success: function() {
     var chatroom = $(".chatroom");
    var messageHtml = $('<div>').attr('id', 'receiver').text(message);
    chatroom.append(messageHtml);
    $("#send-input").val(""); // 입력창 초기화
        },
        error: function(xhr, status, error) {
          console.log("Error: " + error);
        }
      });
      $('#send-input').val('');
    }
  }
});