$(function() {
	
//	$("input[id='meetingId']").prop(function() {
		/* 查询会议基本信息*/
		$.ajax({
			url: "findEvaluationMeetingInfoAction.action",
			type: "post",
			data: {
				"specialistId" : $("#expertId").val()
			},
			dataType: "json",
			success: function(result) {
				console.log("Finding evaluation meeting info is ok!");
				
				var meeting = result.meeting;
				if(meeting != null) {
					$("#view_meeting_agenda").removeAttr("disabled");
					$("#specialist_opinion_review").removeAttr("disabled");
					
					$("#meetingId").val(meeting.meetingId);
					$("#meetingTime").text(meeting.meetingTime);
					$("#meetingPlace").text(meeting.meetingPlace);
					
					getSpecialistList();
				} else {
					$("#view_meeting_agenda").attr("disabled", "disabled").css("color", "#5E6D74");
					$("#specialist_opinion_review").attr("disabled", "disabled").css("color", "#5E6D74");
				}
				// 不论会议信息是否为空，禁用页面签订承诺书按钮
				$("#signCommitment").attr("disabled", "disabled").css("color", "#5E6D74");
			},
			error: function() {
				console.log("Finding evalution meeting info is error!");
			}
		});
		
		/* 获取专家组名单*/
		function getSpecialistList() {
			$.ajax({
				url: "findSpecialistListAction.action",
				type: "post",
				data: {
					"meetingId": $("#meetingId").val(),
					"specialistId": $("#expertId").val()
				},
				dataType: "json",
				success: function(result) {
					var specialists = result.specialists;
					if(result.specialists && specialists != null) {
						console.log("Finding specialist list is ok!");
						
						var size = specialists.length;
						var t_body = $("#t_specialist");
						var expertId = $("#expertId").val();
						
						for(var i = 0; i < size; i++) {
							var _tr = "<tr><td>" + (i + 1) + "</td>";
							_tr += "<td>" + specialists[i].name + "</td>";
							_tr += "<td>" + specialists[i].workUnit + "</td>";
							_tr += "<td>" + specialists[i].engageDomain + "</td>";
							_tr += "<td>" + specialists[i].title + "</td>";
							if(typeof specialists[i].leader == "undefined" || specialists[i].leader == null) {
								_tr += "<td></td></tr>";
							} else {
								if (specialists[i].leader == '组长' && specialists[i].specialistId == expertId) {
									var entryButton = document.createElement('button');
									entryButton.id = 'entryFinalOpinion';
									entryButton.className = 'btn btn-default sign_btn';
									entryButton.innerHTML = '录入评审结果';
									entryButton.onclick = function () {
										$("#triggerCheck").trigger("click");
									};
									
									$("#group_leader_new_element").append($(entryButton));
								}
								_tr += "<td>" + specialists[i].leader + "</td></tr>";
							}
							$(_tr).appendTo(t_body);
						}
					}
					if(result.signResult) {
						$("#signCommitment").attr("disabled", "disabled").css("color", "#5E6D74");
						getEvaluatedProjects();
					} else {
						$("#signCommitment").css("color", "#FFFFFF");
						$("#signCommitment").removeAttr("disabled");
					}
				},
				error: function() {
					console.log("Finding specialist list is error!");
				}
			});
			
		}
		
		/* 查询待评审项目*/
		function getEvaluatedProjects() {
			var meetingId = $("#meetingId").val();
			$.ajax({
				url: "findEvaluatedProjectAction.action",
				type: "post",
				data: {
					"meetingId": meetingId
				},
				dataType: "json",
				success: function(result) {
					console.log("Finding evaluated project is ok!");
					
					var projects = result.projects;
					if(projects != null) {
						var size = projects.length;
						var t_body = $("#t_project");
						for(var i = 0; i < size; i++) {
							var _tr = "<tr><td><input type='radio' value='" + projects[i].projectId + "' class='singleProject' name='singleProject' /></td>";
							_tr += "<td>" + (i + 1) + "</td>";
							_tr += "<td>" + projects[i].projectName + "</td>";
							_tr += "<td>" + projects[i].applicant + "</td>";
							_tr += "<td>" + projects[i].name + "</td>";
							_tr += "<td>" + projects[i].domain + "</td>";
							_tr += "<td>" + projects[i].projectFunds + "</td>";
							_tr += "<td><a href='findProjectMaterialAction.action?projectId=" + projects[i].projectId + "&meetingId=" + meetingId + "' class='reviewAndEvaluate' title='查看&评审'><i class='glyphicon glyphicon-search'></i> & <i class='glyphicon glyphicon-pencil'></i></a></td></tr>";
							$(_tr).appendTo(t_body);
						}
					}
				},
				error: function() {
					console.log("Finding evaluated project is error!");
				}
			});
		}
//	});
	
	/*查看会议议程*/
	$("#view_meeting_agenda").click(function() {
		console.log("Starting to go to meeting agenda page!");
		
		var params = "ReportServer?reportlet=meetingAgenda.cpt";
		
		var meetingId = $("#meetingId").val();
		
		params += "&meetingId=" + meetingId;
		
		window.location.href = params;
	});
		
	/*签订承诺书*/
	$("#signCommitment").click(function() {
		var meetingId = $("#meetingId").val();
		var specialistId = $("#expertId").val();
		var local_href = $(this).attr("data_title");
		
		checkIfExistSignature(local_href, meetingId, specialistId);
		
	});
	
	/*检测专家是否已经上传个人签名并设置了签名密码，没有个人签名且没有设置签名密码的话，不能进行签订承诺书*/
	function checkIfExistSignature(url, meetingId, specialistId) {
		$.post("checkIfExistSignatureAction.action", {
			"specialistId" : specialistId
		}, function(result) {
			if(result.exist) {
				if(typeof result.signaturePass != "undefined" && result.signaturePass != null && result.signaturePass != "") {
					window.location.href = url + "?meetingId=" + meetingId +"&specialistId=" + specialistId;
				} else {
					alert("请先设置签名密码，\n再签订承诺书!");
					window.location.href = "admin/evaluation/specialistInfo.jsp";
				}
			} else {
				alert("请先上传个人签名，\n再签订承诺书!");
				window.location.href = "admin/evaluation/specialistInfo.jsp";
			}
		});
	}
	
	/*检测当前项目的专家评审已经全部结束*/
	function checkIfFinishEvaluation(projectId, url) {
		$.post("findProjectCurrentStatusAction.action", {
			"projectId" : projectId
		}, function(result) {
			console.log("Finding project current status is ok!");
			var projectStatus = result.projectStatus;
			
			if(projectStatus != null && projectStatus != "") {
				if(projectStatus == "已评审" || projectStatus == "已评估") {
					var expertId = $("#expertId").val();
					var local_href = url + "?projectId=" + projectId + "&expertId=" + expertId;
					window.location.href = local_href;
				} else {
					alert("当前项目尚未完成专家评审或已结束评估，\n不能录入最终评审结果!");
				}
			} 
		});
	}
	
	function checkIsNull(info) {
		if(info == "" || typeof(info) == "undefined" || info == null) {
			return true;
		} else {
			return false;
		}
	}
	
	/*录入最终评审结果*/
	$("#triggerCheck").click(function() {
		var url = 'admin/evaluation/entry_final.jsp';
		var projectId = $("input[name='singleProject']:checked").val();
		console.log("projectId: " + projectId);
		if(checkIsNull(projectId)) {
			alert("请选择一个项目!");
			return false;
		}
		
		checkIfFinishEvaluation(projectId, url);
		
	});
	
	/*查看专家评审意见*/
	$("#specialist_opinion_review").click(function() {
		var url = 'admin/evaluation/opinion_review.jsp?';
		var projectId = $("input[name='singleProject']:checked").val();
		console.log("projectId: " + projectId);
		
		if(checkIsNull(projectId)) {
			alert("请选择一个项目!");
			return false;
		}
		
		window.location.href = url + "projectId=" + projectId;
	});
});
