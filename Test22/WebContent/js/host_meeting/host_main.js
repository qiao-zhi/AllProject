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
			var erAndState = result.erAndState;
			
			$(".jqte_editor").html(erAndState.evaluateResult);
			
			$(".jqte_editor").attr("contenteditable", "false");
			$(".saveResult").attr("disabled", "disabled");
			$(".onlySaveResult").attr("disabled", "disabled");
		},
		error: function() {
			alert("Generating an error!")
			console.log("Finding evaluation result is error!");
		}
	});
	
	$(".printResult").click(function() {
		console.log("Starting print!");
		var params = "ReportServer?reportlet=EVALUATION_RESULT.cpt";
		
		var projectId = $("#projectId").val();
		params += "&projectId=" + projectId;
		
		window.location.href = params;
		
		console.log("Finishing print!");
	});
});