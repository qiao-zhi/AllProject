$(function() {
	
	/*查询要录入评审结果的项目部分信息*/
	$.ajax({
		url: "findProjectPartInfoAction.action",
		type: "post",
		data: {
			"projectId" : $("#projectId").val()
		},
		dataType: "json",
		success: function(result) {
			console.log("Finding project part info is ok!");
			
			var project = result.project;
			if(project != null) {
				$("#projectName").text(project.projectName);
				$("#applicant").text(project.applicant);
				$("#name").text(project.name);
				$("#projectFunds").text(project.projectFunds);
			}
		}
	});
	
	/*查询项目评估结果*/
	$.ajax({
		url: "findEvaluationResultAction.action",
		type: "post",
		data: {
			projectId: $("#projectId").val()
		},
		dataType: "json",
		success: function(result) {
			console.log("Finding evaluation result is ok!");
			if(result.success == true && result.erAndState) {
				var erAndState = result.erAndState;
				$(".jqte_editor").html(erAndState.evaluateResult);
				
				if(erAndState.remark == "1") {
					$(".jqte_editor").attr("contenteditable", "false");
					$(".saveResult").attr("disabled", "disabled");
					$(".onlySaveResult").attr("disabled", "disabled");
				}
			} else if (result.success == true && result.content) {
				$(".jqte_editor").html(result.content);
			}
		},
		error: function() {
			alert("Generating an error!")
			console.log("Finding evaluation result is error!");
		}
	});
	
	$(".onlySaveResult").click(function() {
		var content = $(".jqte_editor").html();
		if(content == "") {
			alert("请填写评审结果!");
			return false;
		}
		$("#evaluation_result").val(content);
		$("#operationType").val("保存");
		$("form#resultInfo")[0].submit();
	});
	
	$(".saveResult").click(function() {
		var content = $(".jqte_editor").html();
		if(content=="") {
			alert("请填写评审结果!");
			return false;
		}
		
		$("#evaluation_result").val(content);
		$("#operationType").val("提交");
		$("#resultInfo").submit();
	});
});