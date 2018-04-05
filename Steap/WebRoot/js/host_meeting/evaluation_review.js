$(function() {
	
	/*获取项目的部门显示信息*/
	$.ajax({
		url: "findProjectPartInfoAction.action",
		type: "post",
		data: {
			"projectId": $("#projectId").val()
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
				
				getEvaluationInfoList();
			}
		},
		error: function() {
			console.log("Finding project part info is error!");
		}
	});
	
	/*获取所选项目的全部专家评审意见*/
	function getEvaluationInfoList() {
		$.ajax({
			url: "findProjectEvaluationInfoAction.action",
			type: "post",
			data: {
				"projectId": $("#projectId").val()
			},
			dataType: "json",
			success: function(result) {
				console.log("Finding project evalution info is ok!");
				
				var evaluationInfos = result.evaluationInfos;
				
				if(evaluationInfos != null) {
					var size = evaluationInfos.length;
					if(size > 0 ) {
						$(".name").text(evaluationInfos[0].name);
						$(".workUnit").text(evaluationInfos[0].workUnit);
						
						var content = evaluationInfos[0].reviewSuggestion;
						console.log("evaluationInfos[0]: " + content);
						if(content != null) {
							$(".jqte_editor").html(content);
						} else {
							$(".jqte_editor").html("");
						}
					}
					
					var personal_idea = $(".personal_idea"); 
					for(var i = 1; i < size; i++) {
						$(".experts_personal:first").clone(true).appendTo(personal_idea);
						$(".name:last").text(evaluationInfos[i].name);
						$(".workUnit:last").text(evaluationInfos[i].workUnit);
						
						var _content = evaluationInfos[i].reviewSuggestion; 
						console.log("evaluationInfos[" + i + "]: " + _content);
						if(_content != null) {
							$(".jqte_editor:last").html(_content);
						} else {
							console.log("false");
							$(".jqte_editor:last").html("");
						}
					}
				}
			},
			error: function() {
				console.log("Finding project evaluation info is error!");
			}
		});		
	}
});