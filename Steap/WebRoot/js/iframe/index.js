$(function(){
	$("#sidebar_btn_hide").click(function(){
		$(".section_left ul").hide(500);
		$(".section_left").animate({
			width:"0%"
		},800);
		$(".section_right").animate({
			width:"100%"
		},800);
		$("#sidebar_btn_hide").hide();
		$("#sidebar_btn_show").show();
		
	})
	$("#sidebar_btn_show").click(function(){
		$(".section_right").animate({
			width:"90%"
		},1000);
		$(".section_left").animate({
			width:"10%"
		},1000);
		$(".section_left ul").show(500);
		$("#sidebar_btn_show").hide();
		$("#sidebar_btn_hide").show();
		
	})
})

function iframeClick(a){
	var $href = a.href;
	$("#first_iframe").attr("src",$href);
}