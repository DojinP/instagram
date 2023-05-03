$(document).ready(function() {
	$(document).mouseup(function(e) {
		if ($(".con-popup-wrap").has(e.target).length === 0) {
			$(".con-popup-wrap").fadeOut();
		}
	});
	$(function() {
		$(".con-modal-open").click(function() {
			console.log("click");
			//팝업을 flex속성으로 바꿔준 후 hide()로 숨기고 다시 fadeIn()으로 효과
			$(".con-popup-wrap").css('display', 'flex').hide().fadeIn();
			var id = $(this).find('input:eq(0)').val();
			console.log(id);
		});
	});
});