$(function(){
	$(".choose_tree > ul > li > a").click(function(){
		
		var $icon = $(this).children(".i_right_icon");
		if($icon.hasClass("glyphicon glyphicon-plus")){
			$icon.removeClass("glyphicon glyphicon-plus").addClass("glyphicon glyphicon-minus");
			$(this).next().show(500);
		}
		else{
			$icon.removeClass("glyphicon glyphicon-minus").addClass(" glyphicon glyphicon-plus");
			$(this).next().hide(500);
		}
		
//		$(this).next().toggle(500);
	})
})