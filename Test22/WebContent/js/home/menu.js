$(function(){	
	$("").click(function(){
		var $ul = $(this).next("ul");
		$ul.slideToggle(500);
		var $i = $(this).children("i");
		if ($i.hasClass("glyphicon-plus")) {
			$i.removeClass("glyphicon-plus").addClass("glyphicon-minus");
		} else{
			$i.removeClass("glyphicon-minus").addClass("glyphicon-plus");
		}
	})
})

/*.menuLevel_one > a*/