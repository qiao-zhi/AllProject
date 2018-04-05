$(function(){
	//获取这一列相对整行的位置
	var $project_name = $("#project_name_th").index();		//项目名称
	var $project_num_th = $("#project_num_th").index();		//项目编号
	var $apply_unit_th = $("#apply_unit_th").index();		//申请单位
	var $apply_data_th = $("#apply_data_th").index();		//申请时间
	var $field_belong_th = $("#field_belong_th").index();		//所属领域
	var $register_data_th = $("#register_data_th").index();		//登记日期
	var $register_man_th = $("#register_man_th").index();		//登记人
	var $destribution = $("#destribution_date_th").index();		//确定日期
	var $responsible_department_th = $("#responsible_department_th").index();		//确定部门
	var $responsible_man_th = $("#responsible_man_th").index();			//负责人
	var $receive_man_th = $("#receive_man_th").index();		//接收领取人
	var $receive = $("#receive_date_th").index();		//领取时间
	var $censor_man_th = $("#censor_man_th").index();		//审查人
	var $censor = $("#censor_date_th").index();		//审查日期
	var $censor_Result = $("#censor_result_th").index(); //审查结果
	var $project_status = $("#project_status_th").index();
	
	$("#projectTable").on("click","tbody>tr",function(){
		var $html_receive = $(this).children().eq($receive).text();
		var $html_censor = $(this).children().eq($censor).text();
		var $html_status = $(this).children().eq($project_status).text();
		
//		if($html_receive == ""){
//			$("#receive_btn").attr("disabled",false);
//			$("#censor_btn").attr("disabled",true);
//		} else{
//			$("#censor_btn").attr("disabled",false);
//			$("#receive_btn").attr("disabled",false);
//			/*判断是否为更新*/
//			if($html_censor != ""){
//				$("#isUpdate").val("是");
//			}else {
//				$("#isUpdate").val("否");
//			}
//		}
		
		if($html_status == "仅查看"){
			$("#receive_btn").attr("disabled",true);
			$("#censor_btn").attr("disabled",true);
		} else{
			if($html_receive == ""){
				$("#receive_btn").attr("disabled",false);
				$("#censor_btn").attr("disabled",true);
			} else{
				$("#censor_btn").attr("disabled",false);
				$("#receive_btn").attr("disabled",false);
				/*判断是否为更新*/
				if($html_censor != ""){
					$("#isUpdate").val("是");
				}else {
					$("#isUpdate").val("否");
				}
			}
		}
		
		if ($(this).hasClass("light_height")) {
//			$(this).removeClass("light_height");	
		} else{
			$(this).addClass("light_height").siblings(".light_height").removeClass("light_height");				
		}
	})
	
	$(".box_middle tbody>tr").each(function(){
		$(this).click(function(){
			var $html_destribution = $(this).children().eq($destribution).text();
			var $html_receive = $(this).children().eq($receive).text();
			var $html_censor = $(this).children().eq($censor).text();
			
//			$("#destribution_btn").attr("disabled","disabled");
			$("#receive_btn").attr("disabled","disabled");
			$("#censor_btn").attr("disabled","disabled");
			
//			if($html_destribution == ""){$("#destribution_btn").attr("disabled",false);}
			if($html_receive == ""){$("#receive_btn").attr("disabled",false);}
			else if($html_censor == ""){$("#censor_btn").attr("disabled",false);}
			
//			没加任何判断直接这样写代码健壮?
			
//			在没有任何行被选择的时候应该重置按钮属性
			
			if ($(this).hasClass("light_height")) {
				$(this).removeClass("light_height");	
			} else{
				$(this).addClass("light_height").siblings(".light_height").removeClass("light_height");				
			}	
		})
	})


	/* 点击查看按钮 */
	$("#projectTable").on("click",".operation_icon",function(){

//		这个绑定感觉不是很必要,难道还要清理了属性绑定?
//		$(this).attr("href","#check_modal").attr("data-toggle","modal");
//		var $row = $(this).parents("tr").children().eq(1).text();
		$("#project_name").html($(this).parents("tr").children().eq($project_name).text());
//		$("#project_num").html($(this).parents("tr").children().eq($project_num_th).text());
		$("#apply_unit").html($(this).parents("tr").children().eq($apply_unit_th).text());
		$("#apply_data").html($(this).parents("tr").children().eq($apply_data_th).text());
		$("#field_belong").html($(this).parents("tr").children().eq($field_belong_th).text());
		$("#register_data").html($(this).parents("tr").children().eq($register_data_th).text());
		$("#register_man").html($(this).parents("tr").children().eq($register_man_th).text());
		$("#").html($(this).parents("tr").children().eq($destribution).text());  			//????????????????
		$("#responsible_department").html($(this).parents("tr").children().eq($responsible_department_th).text());
		$("#responsible_man").html($(this).parents("tr").children().eq($responsible_man_th).text());
		$("#receive_man").html($(this).parents("tr").children().eq($receive_man_th).text());
		$("#receive_date").html($(this).parents("tr").children().eq($receive).text());
		$("#censor_man").html($(this).parents("tr").children().eq($censor_man_th).text());
		$("#censor_date").html($(this).parents("tr").children().eq($censor).text());
		$("#censor_result2").val($(this).parents("tr").children().eq($censor_Result).text());
	});
	
//	查看
//	$(".box_middle tbody > tr > td > a").click(function(){
////		这个绑定感觉不是很必要,难道还要清理了属性绑定?
////		$(this).attr("href","#check_modal").attr("data-toggle","modal");
////		var $row = $(this).parents("tr").children().eq(1).text();
//		$("#project_name").html($(this).parents("tr").children().eq($project_name).text());
////		$("#project_num").html($(this).parents("tr").children().eq($project_num_th).text());
//		$("#apply_unit").html($(this).parents("tr").children().eq($apply_unit_th).text());
//		$("#apply_data").html($(this).parents("tr").children().eq($apply_data_th).text());
//		$("#field_belong").html($(this).parents("tr").children().eq($field_belong_th).text());
//		$("#register_data").html($(this).parents("tr").children().eq($register_data_th).text());
//		$("#register_man").html($(this).parents("tr").children().eq($register_man_th).text());
//		$("#").html($(this).parents("tr").children().eq($destribution).text());  			//????????????????
//		$("#responsible_department").html($(this).parents("tr").children().eq($responsible_department_th).text());
//		$("#responsible_man").html($(this).parents("tr").children().eq($responsible_man_th).text());
//		$("#receive_man").html($(this).parents("tr").children().eq($receive_man_th).text());
//		$("#receive_date").html($(this).parents("tr").children().eq($receive).text());
//		$("#censor_man").html($(this).parents("tr").children().eq($censor_man_th).text());
//		$("#censor_date").html($(this).parents("tr").children().eq($censor).text());
//		$("#censor_result2").val($(this).parents("tr").children().eq($censor_Result).text());
//		
//	})
	
	$("#receive_btn").click(function(){
		$("#projectNameD").html($(".light_height").children().eq($project_name).text());
		$("#projectIdD").html($(".light_height").children().eq($project_num_th).text());
		$("#projectIdS").val($(".light_height").children().eq($project_num_th).text());
	})
	$("#censor_btn").click(function(){
		$("#projectNameLa2").html($(".light_height").children().eq($project_name).text());
		$("#projectIdLa2").html($(".light_height").children().eq($project_num_th).text());
		$("#projectIdI").val($(".light_height").children().eq($project_num_th).text());
	})
	
})