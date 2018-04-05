$(function(){
	//左边菜单要获取右边页面的长度  等高
/*	var $height = $(".main_body").height();
	if ($hei > 700) {
		$(".menu_modal").height($height);				
	} else{
		$hei = $(".menu_modal").height();
		$(".main_body").attr("min-height","$hei");
	}*/
	
	//菜单盒子展开和关闭
	$("#sidebar_btn_hide").click(function(){
		
		

		$(".menu_modal").animate({
			left:"-10%",
		},800);
		$(".main_body").animate({
			width:"100%"
		},800);
		$("#sidebar_btn_hide").hide();
		$("#sidebar_btn_show").show();
		
	})
	$("#sidebar_btn_show").click(function(){
		$(".main_body").animate({
			width:"90%",
		},1000);
		$(".menu_modal").animate({
			left:"0",
		},1000);

		$("#sidebar_btn_show").hide();
		$("#sidebar_btn_hide").show();
		
	})
	
})

/*$(document).ready(function(){
	withHeight($(".menu_modal"),$(".main_body"),0);
})
*/
/*菜单 主体 左右同高函数，输入需要同高的两个模块*/
function withHeight(hleft,hright,offset){
	//console.log(hright.height());
	if ( hleft.height() > hright.height() ) {
		hright.height(hleft.height());
	} else{
		var $all = hright.height() + offset + "px";
		console.log($all);
		hleft.height($all);
		console.log(hleft.height());
	}
}