$(document).ready(function(){
	$(document).mouseup(function (e){
		if($("#updatepopup").has(e.target).length === 0){
			$("#updatepopup").fadeOut();
		}
	});	
	
	
  $("#update_button").click(function(){        
      $("#updatepopup").css('display','flex').hide().fadeIn();
      
  });
  
  $("#updatebackspace").click(function(){
      modalClose();
  });
  
  function modalClose(){
      $("#updatepopup").fadeOut(); //페이드아웃 효과
  }
  
});