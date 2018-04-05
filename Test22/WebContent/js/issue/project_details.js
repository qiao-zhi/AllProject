$(function() {
	$("a[data-toggle='tab']").click(function(e) {
		e.preventDefault();
		$(this).tab("show");
		
		if(!$(this).attr("data_flag")) {
			console.log("flag: " + $(this).attr("data_flag"));
			eval($(this).attr("data_load"));
		}
		
	});
	
	var search_flag = false;
	
	getBIProject();
	
	function getBIProject() {
		$.ajax({
			url: "findBIProjectAction.action",
			type: "post",
			data: {
				"projectId": $("#projectId").val()
			},
			dataType: "json",
			success: function(result) {
				$("a[data_title='project']").attr("data_flag", true);
				
				var project = result.project;
				if(result.project && project != null) {
					console.log("Finding project base info is ok!");
					
					$("#projectName").text(project.projectName);
					$("#applicant").text(project.applicant);
					$("#domain").text(project.domain);
					$("#applicationDate").text(project.applicationDate);
					
					$("#recordPerson").text(project.recordPerson);
					$("#recordDate").text(project.recordDate);
					
					$("#chargeUnit").text(project.chargeUnit);
					$("#chargePerson").text(project.chargePerson);
					
					$("#receivePerson").text(project.receivePerson);
					$("#receiveDate").text(project.receiveDate);
					
					$("#censorPerson").text(project.censorPerson);
					$("#censorDate").text(project.censorDate);
					
					var reg = new RegExp("<br>","g");
					var censorResult = project.censorResult.replace(reg, "\n");
					$("#censorResult").html(censorResult);
					
					getBIEInspect();
					
				}
			},
			error: function() {
				console.log("Finding project base info is error!");
			}
		});		
	}
	
	function getBIEInspect() {
		$.ajax({
			url: "findBIEInspectAction.action",
			type: "post",
			data: {
				"projectId": $("#projectId").val()
			},
			dataType: "json",
			success: function(result) {
				console.log("Finding enterprise info is ok!");
				$("a[data_title='inspect']").attr("data_flag", true);
				
				var inspect = result.inspect;
				if(result.inspect && inspect != null) {
					$("#inspectPerson").text(inspect.inspectPerson);
					$("#inspectDate").text(inspect.inspectDate);
					
					var reg = new RegExp("<br>", "g");
					var inspectResult = inspect.inspectResult.replace(reg, "\n");
					$("#inspectResult").html(inspectResult);
				}
				
				var specialists = result.specialists;
				if(result.specialists && specialists != null) {
					var size = specialists.length;
					var t_body = $("#t_specialist");
					
					for(var i = 0; i < size; i++) {
						var _tr = "<tr><td>" + (i + 1) + "</td>"; 
						_tr += "<td>" + specialists[i].name + "</td>";
						_tr += "<td>" + specialists[i].workUnit + "</td>";
						_tr += "<td>" + specialists[i].engageDomain + "</td>";
						_tr += "<td>" + specialists[i].duty + "</td>";
						_tr += "<td>" + specialists[i].title + "</td>";
						_tr += "<td>" + specialists[i].telephone + "</td></tr>";
						$(_tr).appendTo(t_body);
					}
				}
				
				var audit = result.audit;
				if(result.audit && audit != null) {
					$("#financeUnit").text(audit.financeUnit);
					$("#auditDate").text(audit.auditDate);
				}
				getPictureSet(1);
				
				getBIProjectNotify();
			},
			error: function() {
				console.log("Finding enterprise info is error!");
			}
		});
	}
	
	function getPictureSet(flag) {
		$.post("getPictureSetAction.action", {
			"projectId" : $("#projectId").val(),
			"flag": flag
		}, function(result) {
			console.log("Finding picture set is ok!");
			
			var iPic = result.inspectPictures;
			if(result.inspectPictures && iPic != null) {
				$(".ip").attr("href", iPic[0].currentName).children("img").attr("src", iPic[0].currentName).attr("alt", iPic[0].originalName);
				
				var size = iPic.length;
				var ipDiv = $(".inspectPicture");
				for(var i = 1; i < size; i++) {
					$(".ip:first").clone(true).appendTo(ipDiv);
					$(".ip:last").attr("href", iPic[i].currentName).children("img").attr("src", iPic[i].currentName).attr("alt", iPic[i].originalName);
				}
			}
			
			var aPic = result.auditPictures;
			if(result.auditPictures && aPic != null) {
				$(".ap").attr("href", aPic[0].currentName).children("img").attr("src", aPic[0].currentName).attr("alt", aPic[0].originalName);
				
				var size = aPic.length;
				var apDiv = $(".auditPicture");
				for(var i = 1; i < size; i++) {
					$(".ap:first").clone(true).appendTo(apDiv);
					$(".ap:last").attr("href", aPic[i].currentName).children("img").attr("src", aPic[i].currentName).attr("alt", aPic[i].originalName);
				}
			}
		});
	}
	
	function getBIProjectNotify() {
		$.post("findBIProjectMeetingAction.action", {
			"projectId" : $("#projectId").val()
		}, function(result) {
			console.log("Finding project meeting base info is ok!");
			$("a[data_title='notify']").attr("data_flag", true);
			
			var notifyInfo = result.notifyInfo;
			if(result.notifyInfo && notifyInfo != null) {
				$("#notifyDate").text(notifyInfo.notifyDate);
				$("#notifyMethod").text(notifyInfo.notifyMethod);
			}
			
			$(".jqte_editor").eq(0).html("");
			var material = result.material;
			if(result.material && material != null) {
				$(".jqte_editor").eq(0).html(result.material.opinionContent);
			}
			
			var pictures = result.pictures;
			if(result.pictures && pictures != null) {
				var size = pictures.length;
				
				if(size > 0) {
					$(".rp").attr("href", pictures[0].currentName).children("img").attr("src", pictures[0].currentName).attr("alt", pictures[0].originalName);
				}
				
				var realDiv = $(".realPicture");
				for(var i = 1; i < size; i++) {
					$(".rp:first").clone(true).appendTo(realDiv);
					$(".rp:last").attr("href", picture.currentName).children("img").attr("src", picture.currentName).attr("alt", picture.originalName);
				}
			}
			
			getBIProjectMaterial();
		});
	}

	function getBIProjectMaterial() {
		$.post("findBIProjectMaterialAction.action", {
			"projectId" : $("#projectId").val()
		}, function(result) {
			console.log("Finding project material base info is ok!");
			$("a[data_title='material']").attr("data_flag", true);
			
			var project = result.project;
			if(result.project && project != null) {
				$("#c_projectName").text(project.projectName);
				$("#c_applicant").text(project.applicant);
				$("#c_chargePerson").text(project.name);
				$("#c_projectFunds").text(project.projectFunds);
			}
			
			var materials = result.materials;
			if(result.materials && materials != null) {
				var size = materials.length;
				var t_body = $("#t_material");
				
				for(var i = 0; i < size; i++) {
					var _tr = "<tr><td>" + (i + 1) + "</td>";
					_tr += "<td>" + materials[i].fileType + "</td>";
					_tr += "<td>" + materials[i].originalName + "</td>";
					_tr += "<td>" + materials[i].uploadTime + "</td>";
					_tr += "<td>" + materials[i].fileSize + "</td>";
					_tr += "<td><a href='" + materials[i].currentName  + "' target='_blank' class='operation_icon' data-toggle='tooltip' data-placement='bottom' title='查看'><i class='glyphicon glyphicon-search'></i></a></td>";
					$(_tr).appendTo(t_body);
				}
			}
			getBIProjectCheck();
			getBIProjectComplete();
		});
		
	}
	
	function getBIProjectCheck() {
		$.post("findBIProjectCheckAction.action", {
			"projectId" : $("#projectId").val()
		}, function(result) {
			console.log("Finding project check base info is ok!");
			$("a[data_title='meeting']").attr("data_flag", true);
			
			var meeting = result.meeting;
			if(result.meeting && meeting != null) {
				$("#meetingTime").text(meeting.meetingTime);
				$("#meetingPlace").text(meeting.meetingPlace);
			}
			
			var specialists = result.specialists;
			if(result.specialists && specialists != null) {
				var size = specialists.length;
				var t_body = $("#t_specialistGroup");
				
				for(var i = 0; i < size; i++) {
					var _tr = "<tr><td>" + (i + 1) + "</td>";
					_tr += "<td>" + specialists[i].name + "</td>";
					_tr += "<td>" + specialists[i].workUnit + "</td>";
					_tr += "<td>" + specialists[i].engageDomain + "</td>";
					_tr += "<td>" + specialists[i].duty + "</td>";
					_tr += "<td>" + specialists[i].title + "</td>";
					_tr += "<td>" + specialists[i].telephone + "</td>";
					_tr += "<td>" + specialists[i].signTime + "</td>";
					_tr += "<td><a href='javascript:void(0);' class='operation_icon' data_title='" + specialists[i].specialistId + "' data-toggle='modal' data-target='#project_take_in_check' data-placement='bottom' title='查看'><i class='glyphicon glyphicon glyphicon-search'></i></a></td></tr>";					
					$(_tr).appendTo(t_body);
				}
				addClickToA();
			}
			
			var evaluateResult = result.evaluateResult;
			if(result.evaluateResult && evaluateResult != null) {
				$(".jqte_editor").eq(1).html(evaluateResult);
			}
		});
	}
	
	function getBIProjectComplete() {
		$.ajax({
			url: "findBIProjectCompleteAction.action",
			type: "post",
			data: {
				"projectId" : $("#projectId").val()
			},
			dataType: "json",
			success: function(result) {
				console.log("Finding project complete materials is ok!");
				
				var verifyInfo = result.verifyInfo;
				if(result.verifyInfo && verifyInfo != null) {
					$("#verifyPerson").text(verifyInfo.verifyPerson);
					$("#verifyDate").text(verifyInfo.verifyDate);
					
					var reg = new RegExp("<br>", "g");
					var content = verifyInfo.verifyResult.replace(reg, "\n");
					$("#verifyResult").html(content);
					
					if (verifyInfo.completeDescription) {
						var description = verifyInfo.completeDescription.replace(reg, "\n");
						$("#completeDescription").html(description);
					}
				}
				
				var materials = result.materials;
				if(result.materials && materials != null) {
					var size = materials.length;
					var t_body = $("#t_complete");
					
					for(var i = 0; i < size; i++) {
						var _tr = "<tr><td>" + (i + 1) + "</td>";
						_tr += "<td>" + materials[i].fileType + "</td>";
						_tr += "<td>" + materials[i].originalName + "</td>";
						_tr += "<td>" + materials[i].uploadTime + "</td>";
						_tr += "<td>" + materials[i].fileSize + "</td>";
						_tr += "<td><a href='" + materials[i].currentName + "' target='_blank' class='operation_icon' data-toggle='tooltip' data-placement='bottom' title='查看'><i class='glyphicon glyphicon-search'></i></a></td></tr>";
						$(_tr).appendTo(t_body);
					}
				}
				
			},
			error: function() {
				console.log("Finding project complete materials is error!");
			}
		});
		
		getBIIssueInfo();
	}
	
	/* Start最新查看项目审核信息的方法*/
	function getBICompleteVerify() {
		
	}
	
	/* Finish最新查看项目审核信息的方法*/
	
	function addClickToA() {
		$("#t_specialistGroup tr td a[data-toggle='modal']").click(function() {
			var params = {
					"projectId" : $("#projectId").val(),
					"specialistId" : $(this).attr("data_title") 
			};
			
			$.ajax({
				url: "findEvaluationInfoAction.action",
				type: "post",
				data: params, 
				dataType: "json",
				success: function(result) {
					console.log("Finding evaluation info is ok!");
					var rsAndState = result.rsAndState;
					if(rsAndState != null) {
						$("#sProjectName").text($("#projectName").text());
						$("#sApplicant").text($("#applicant").text());
						
						$(".jqte_editor:last").html(rsAndState.reviewSuggestion);
					}
				},
				error: function() {
					console.log("Finding evaluation info is error!");
				}
			});
		});		
	}
	
	function getBIIssueInfo() {
		$.ajax({
			url: "findBIIssueInfoAction.action",
			type: "post",
			data: {
				"projectId": $("#projectId").val()
			},
			dataType: "json",
			success: function(result) {
				console.log("Finding issue certificate is ok!");
				
				var issue = result.issue;
				if(issue != null) {
					$("#issuePerson").text(issue.issuePerson);
					$("#issueDate").text(issue.issueDate);
					$("#holder").text(issue.holder);
					$("#holdDate").text(issue.holdDate);
					
					if (issue.remark == '' || issue.remark == null) {
						$("#remark").text('无');
					} else {
						$("#remark").text(issue.remark);
					}
				}
			},
			error: function() {
				console.log("Finding issue certificate is error!");
			}
		});
	}
});