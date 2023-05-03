$(document).ready(function(){
  $("#confirm").click(function(){
      modalClose(); 
      
  });
  $("#update_delete").click(function(){        
      $("#popup").css('display','flex').hide().fadeIn();
      
  });
  $("#close").click(function(){
      modalClose(); //모달 닫기 함수 호출
  });
  function modalClose(){
      $("#popup").fadeOut(); //페이드아웃 효과
  }
});