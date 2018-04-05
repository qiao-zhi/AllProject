$(function(){
	$(".experts_list table tbody tr").click(function(){
		$(this)
			.addClass("chos_active")
			.siblings().removeClass("chos_active")
			.end().find(':radio').prop('checked',true);
	})
//	$(".experts_list table tbody tr").hasClass("chos_active").children(':radio').attr('checked',true);
	$(".experts_list table tbody tr :radio:checked").parents("tr").addClass('chos_active');
	
	
	$(".waiting_review_porject table tbody tr").click(function(){
		$(this)
			.addClass("tba_chos")
			.siblings().removeClass("tba_chos")
			.end().find(':radio').prop('checked',true);
	})
//	$(".experts_list table tbody tr").hasClass("chos_active").children(':radio').attr('checked',true);
	$(".waiting_review_porject table tbody tr :radio:checked").parents("tr").addClass('tba_chos');
})