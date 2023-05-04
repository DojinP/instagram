$(document).ready(function(){
	$(document).mouseup(function (e){
		if($("#maintextpopup").has(e.target).length === 0){
			$("#maintextpopup").fadeOut();
		}
	});	
	
  $("#createBoard").click(function(){        
      $("#maintextpopup").css('display','flex').hide().fadeIn();
      
  });
  $("#board_share").click(function(){
      modalClose(); //모달 닫기 함수 호출
  });
  
  $("#createbackspace").click(function(){
      modalClose(); //모달 닫기 함수 호출
  });
  
  function modalClose(){
      $("#maintextpopup").fadeOut(); //페이드아웃 효과
  }
  
});