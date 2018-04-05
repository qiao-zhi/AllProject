$(function(){
	$(".experts_list table tbody tr").click(function(){
		$(this)
			.addClass("chos_active")
			.siblings().prop('checked',false).removeClass("chos_active")
			.end().find(':radio').prop('checked',true);
	})
//	$(".experts_list table tbody tr").hasClass("chos_active").children(':radio').attr('checked',true);
	$(".experts_list table tbody tr :radio:checked").parents("tr").addClass('chos_active');
	
	/** ---------------------------------------------  **/
	/*   by yachao at 2016/7/30 21:09 
	 *  ---------------------------------------------  **/
	
	/*查询待主持会议*/
	$.ajax({
		url: "findMeetingInfoAction.action",
		type: "post",
		data: {
			"hostId" : $("#userId").val(),
		},
		dataType: "json",
		success: function(result) {
			var meeting = result.meeting;
			if(meeting != null) {
				console.log("Finding meeting info is ok!");
				$("#meetingId").val(meeting.meetingId);
				$("#meetingName").text(meeting.meetingName);
				$("#meetingTime").text(meeting.meetingTime);
				$("#meetingPlace").text(meeting.meetingPlace);
				
				$("button").removeAttr("disabled");
			} else {
				$("#meetingId").val("");
				
				// 会议信息为空，禁用全部页面按钮
				$("button").attr("disabled", "disabled").css("color", "#5E6D74");
				$(".updateLoginPass").removeAttr("disabled").css("color", "#FFF");
				$(".cacelUpdateLoginPass").removeAttr("disabled");
				$(".close span").removeAttr("disabled").css("color", "#5E6D74");
			}
			getSpecialistGroupList();
		},
		error: function() {
			console.log("Finding meeting info is error!");
		} 
	});
	
	/*查询专家组名单*/
	function getSpecialistGroupList() {
		$.ajax({
			url: "findSpecialistGroupAction.action",
			type: "post",
			data: {
				"meetingId" : $("#meetingId").val()
			},
			dataType: "json",
			success: function(result) {
				var specialists = result.specialists;
				if(specialists != null) {
					var size = specialists.length;
					var t_body = $("#t_specialist");
					
					for(var i = 0; i < size; i++) {
						if(specialists[i].leader == "组长") {
							var _tr = "<tr class='chos_active'><td><input type='radio' class='main_leader' name='leader' value='" + specialists[i].specialistId + "' /></td>";
						} else if(specialists[i].leader == "副组长"){
							var _tr = "<tr class='chos_active'><td><input type='radio' class='sub_leader' name='leader' value='" + specialists[i].specialistId + "' /></td>";
						} else {
							var _tr = "<tr><td><input type='radio' name='leader' value='" + specialists[i].specialistId + "' /></td>";
						}
						_tr += "<td>" + (i + 1) + "</td>";
						_tr += "<td>" + specialists[i].name + "</td>";
						_tr += "<td>" + specialists[i].workUnit + "</td>";
						_tr += "<td>" + specialists[i].engageDomain + "</td>";
						_tr += "<td>" + specialists[i].title + "</td>";
						_tr += "<td>" + specialists[i].signTime + "</td>";
						if(typeof specialists[i].leader == "undefined" || specialists[i].leader == null) {
							_tr += "<td></td></tr>";
						} else {
							_tr += "<td>" + specialists[i].leader + "</td></tr>";
						}
						var $tr = $(_tr);
						$tr.appendTo(t_body);
/*						if(specialists[i].source != "专家库") {
							console.log("Set class attribute!");
							$tr.find("td:first input[type='radio'][name='leader']").addClass("rs");
						}*/
					}
					
					getEvaluatedProjectList();
				}
			}
		});
	}
	
	function getEvaluatedProjectList() {
		$.ajax({
			url: "findEvaluatedProjectAction.action",
			type: "post",
			data: {
				"meetingId" : $("#meetingId").val()
			},
			dataType: "json",
			success: function(result) {
				var projects = result.projects;
				
				if(projects != null) {
					console.log("Finding evaluated projects is ok!");
					var size = projects.length;
					var t_body = $("#t_project");
					
					for(var i = 0; i < size; i++) {
						var _tr = "<tr><td><input type='radio' name='project' value='" + projects[i].projectId + "'/></td>";
						_tr += "<td>" + (i + 1) + "</td>";
						_tr += "<td>" + projects[i].projectName + "</td>";
						_tr += "<td>" + projects[i].applicant + "</td>";
						_tr += "<td>" + projects[i].name + "</td>";
						_tr += "<td>" + projects[i].domain + "</td>";
						_tr += "<td>" + projects[i].projectFunds + "</td>";
						_tr += "<td title='" + projects[i].projectStatus + "'>" + dic[projects[i].projectStatus] + "</td></tr>";
						$(_tr).appendTo(t_body);
					}
				}
			},
			error: function() {
				console.log("Finding evaluated projects is error!");
			}
		});		
	}
	
	$("#printSignInfo").click(function() {
		var params = "ReportServer?reportlet=specialistGroupSignIn.cpt";
		var meetingId = $("#meetingId").val();
		params += "&meetingId=" + meetingId;
		
		var meetingName = $("#meetingName").text();
		params += "&meetingName=" + meetingName;
		
		var meetingTime = $("#meetingTime").text();
		params += "&meetingTime=" + meetingTime;
		
		var meetingPlace = $("#meetingPlace").text();
		params += "&meetingPlace=" + meetingPlace;
		
		window.location.href = params;
	});
	
	function cjkEncode(text) {                                                                            
	      if (text == null) {         
	        return "";         
	      }         
	      var newText = "";         
	      for (var i = 0; i < text.length; i++) {         
	        var code = text.charCodeAt (i);          
	        if (code >= 128 || code == 91 || code == 93) {  //91 is "[", 93 is "]".         
	          newText += "[" + code.toString(16) + "]";         
	        } else {         
	          newText += text.charAt(i);         
	        }         
	      }         
	      return newText;         
	    }     	
	
	$("#set_headman").click(function() {
		var specialistId = $("input[name='leader'][type='radio']:checked").val();
		if(checkIsNull(specialistId)) {
			alert("请选择要设为组长的专家!");
			$("#set_specialist_leader").attr("data-target", "");
			return false;
		}
		$(this).attr("data-target", "#set_specialist_leader");
	});

	/* -------设置会议组长职务------*/
	$(".set_meeting_leader").click(function() {
		var meetingId = $("#meetingId").val();
		console.log("meetingId: " + meetingId);
		
		var newSpecialistLeader = getNewLeaderId();
		console.log("id: " + newSpecialistLeader[0] + ", leader: " + newSpecialistLeader[1]);
		if(newSpecialistLeader[1] == "组长") {
			var oldSpecialistLeader = getOldMainLeaderId();
			submitToServer(meetingId, newSpecialistLeader, oldSpecialistLeader, true);
		} else if(newSpecialistLeader[1] == "副组长"){
			var oldSpecialistLeader = getOldSubLeaderId();
			submitToServer(meetingId, newSpecialistLeader, oldSpecialistLeader, false);
		}
	});
	
	function submitToServer(meetingId, newSpecialistLeader, oldSpecialistLeader, flag) {
		$(".s_meetingId").val(meetingId);
		$(".s_newSpecialistId").val(newSpecialistLeader[0]);
		$(".s_oldSpecialistId").val(oldSpecialistLeader[0]);
		
		var options = {
			url: "setLeaderAction.action",
			type: "post",
			success: function(result) {
				console.log("updateResult: " + result.updateResult);
				var updateResult = result.updateResult;
				if(updateResult) {
					// 去除原来的专家组长信息
					var op_tr = oldSpecialistLeader[1].parent("td").parent("tr");
					if(oldSpecialistLeader != null) {
						op_tr.find("td:last").text("");
					}
					// 添加新的专家组长信息
					var np_tr = newSpecialistLeader[2].parent("td").parent("tr");
					np_tr.find("td:last").text(newSpecialistLeader[1]);
					
					op_tr.removeClass("chos_active");
					np_tr.addClass("chos_active");
					if(flag) {
						oldSpecialistLeader[1].removeClass("main_leader");
						newSpecialistLeader[2].removeClass("main_leader").removeClass("sub_leader");
						newSpecialistLeader[2].addClass("main_leader");
					} else {
						oldSpecialistLeader[1].removeClass("sub_leader");
						newSpecialistLeader[2].removeClass("main_leader").removeClass("sub_leader");
						newSpecialistLeader[2].addClass("sub_leader");
					}
					
					$("#set_specialist_leader").modal("hide");
					$(".s_leader:first").prop("checked", "checked");
					newSpecialistLeader[2].attr("checked", false);
				}				
			}
		};
		
		$("#s_leader_form").ajaxSubmit(options);
	}
	
	function getNewLeaderId() {
		var newLeader = $("input[name='leader'][type='radio']:checked");
		var specialistId = newLeader.val();
		var leader = $("input[type='radio'].s_leader:checked").val();
		console.log("new specialistId: " + specialistId + ", leader: " + leader);
		return [specialistId, leader, newLeader];
	}
	
	function getOldMainLeaderId() {
		var old_main_leader = $(".chos_active .main_leader");
		var old_main_specialistId = "";
		
		old_main_leader.each(function() {
			old_main_specialistId += $(this).val() + ",";
		});
		old_main_specialistId = old_main_specialistId.substring(0, old_main_specialistId.length - 1);
		
		console.log("old_main_specialistId: " + old_main_specialistId);
		
		return [old_main_specialistId, old_main_leader];
	}
	
	function getOldSubLeaderId() {
		var old_sub_leader = $(".chos_active .sub_leader");
		var old_sub_specialistId = "";
		
		old_sub_leader.each(function() {
			old_sub_specialistId += $(this).val() + ",";
		});
		old_sub_specialistId = old_sub_specialistId.substring(0, old_sub_specialistId.length - 1);
		
		console.log("old_sub_specialistId: " + old_sub_specialistId);
		
		return [old_sub_specialistId, old_sub_leader];
	}
	
	$(".set_leader_close").click(function() {
		$("#set_specialist_leader").modal('hide');
		$(".s_leader:first").prop("checked", "checked");
		$("input[name='leader'][type='radio']:checked").attr("checked", false);
	});
	/* ------End 设置会议组长职务------*/
	
	/* 结束会议（修改会议状态为已完成）*/
	$("#finishMeeting").click(function() {
		getAndSetFinishMeetingInfos();
	});
	
	
	function getAndSetFinishMeetingInfos() {
		var meetingId = $("#meetingId").val();
		var projectIds = "";
		$("input[name='project']:radio").each(function() {
			projectIds += $(this).val() + ",";
		});
		projectIds = projectIds.substring(0, projectIds.length - 1);
		
		setFinishMeeting(meetingId, projectIds);
	}
	
	function setFinishMeeting(meetingId, projectIds) {
		$.ajax({
			url: "finishMeetingAction.action",
			type: "post",
			data: {
				"meetingId" : meetingId,
				"projectIds" : projectIds
			},
			dataType: "json",
			success: function(result) {
				var updateResult = result.updateResult;
				if(typeof(result.updateResult) != "undefined" && updateResult != null && updateResult) {
					alert("结束会议设置成功!");
					
					$("#meetingId").val("");
//					window.location.reload();
					$("#finishMeeting, #printSignInfo, #set_headman, #export_specialist_account").attr('disabled', 'disabled').css('color', '#5E6D74');
				} else {
					alert("项目评审尚未完成，不能结束会议!");
				}
			},
			error: function() {
				console.log("结束会议设置失败!请重新设置!");
			}
		}); 
	} 
	
	/* 导出专家账户信息*/
	$("#export_specialist_account").click(function() {
		var params = "ReportServer?reportlet=ACCOUNT_INFO.cpt";
		
		var meetingId = $("#meetingId").val();
		params += "&meetingId=" + meetingId;
		
		window.location.href = params;
	});
	
	/* 查看项目的专家评审意见*/
	$(".viewOpinionInfo").click(function() {
		var url = $("#viewOpinion").attr("data_title");
		var projectId = $("input[name='project']:checked").val();
		if(checkIsNull(projectId)) {
			alert("请选择项目!");
			return false;
		}
		var local_href = url + "?projectId=" + projectId; 
		window.location.href = local_href;
	});
	
	/*录入最终评审结果*/
	$(".entryResultInfo").click(function() {
		var url = $("#entryResult").attr("data_title");
		var projectId = $("input[name='project']:checked").val();
		if(checkIsNull(projectId)) {
			alert("请选择项目!");
			return false;
		}
		
		checkIfFinishEvaluation(projectId, url);
		
	});
	
	/*检测当前项目的专家评审已经全部结束*/
	function checkIfFinishEvaluation(projectId, url) {
		$.post("findProjectCurrentStatusAction.action", {
			"projectId" : projectId
		}, function(result) {
			console.log("Finding project current status is ok!");
			var projectStatus = result.projectStatus;
			
			if(projectStatus != null && projectStatus != "") {
				if(projectStatus == "已评审" || projectStatus == "已评估") {
					var hostId = $("#userId").val();
					var local_href = url + "?projectId=" + projectId + "&hostId=" + hostId;
					window.location.href = local_href;
				} else {
					alert("当前项目尚未完成专家评审或已结束评估，\n不能进行查看最终评审结果!");
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
});