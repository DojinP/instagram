$(document).ready(function(){
	$(document).mouseup(function (e){
		if($("#createboardpopup").has(e.target).length === 0){
			$("#createboardpopup").fadeOut();
		}
	});	

	$("#createBoard").click(function(){
		$("#createboardpopup").css('display','flex').hide().fadeIn();
	});
	
	$("#createbackspace").click(function(){
      	$("#createboardpopup").css('display','flex').hide().fadeIn();
  	});
	
	$("#createBoardNext").click(function(){
		modalClose(); //모달 닫기 함수 호출
	});
	
  	function modalClose(){
		$("#createboardpopup").fadeOut(); //페이드아웃 효과
	}
});