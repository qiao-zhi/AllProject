$(function(){
//	var $h = $(document).height();
	
	$("#personal_name_btn").click(function(){
		if($(this).text() === "编辑"){
			$("#personal_name").attr("readonly",false);
			$("#personal_textarea").removeClass("textarea_bef").attr("readonly",false);
			$(this).text("保存");
		}else{
			$("#personal_name").attr("readonly","readonly");
			$("#personal_textarea").addClass("textarea_bef").attr("readonly","readonly");
			$(this).text("编辑");
		}
		
	})
	
	$(".editor").click(function(){
		if ($(this).text() === "编辑") {
			$(this).parent().parent().siblings().children().children(".box_margin_right").children().attr("readonly",false);
			$(this).text("保存");
		} else{
			$(this).parent().parent().siblings().children().children(".box_margin_right").children().attr("readonly","readonly");
			$(this).text("编辑");
		}

//	    var $right = $(this).parent().parent().siblings().children(".box_margin_right").children().attr("readonly",false);

	})
	
})