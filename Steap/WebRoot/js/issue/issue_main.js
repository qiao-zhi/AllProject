$(function() {
	
	$.ajax({
		url: "findIssueProjectInfoAction.action",
		type: "post",
		data: {
			"projectId" : $("#projectId").val()
		},
		dataType: "json",
		success: function(result) {
			var project = result.project;
			if(project != null) {
				console.log("Finding issue project info is ok!");
				
				$("#projectName").text(project.projectName);
				$("#applicant").text(project.applicant);
				$("#chargePerson").text(project.chargePerson);
				$("#projectFunds").text(project.projectFunds);
				$("#meetingTime").text(project.meetingTime);
				$("#meetingPlace").text(project.meetingPlace);
			}
		},
		error: function() {
			console.log("Finding issue project info is error!");
		}
	});
	
	$.ajax({
		url: "findVerifyInfoAction.action",
		type: "post",
		data: {
			"projectId": $("#projectId").val()
		},
		dataType: "json",
		success: function(result) {
			var v = result.verifyInfo;
			if(v != null) {
				console.log("Finding verify info is ok!");
				
				$("#verifyPerson").text(v.verifyPerson);
				$("#verifyDate").text(v.verifyDate);
				$("#verifyResult").html(v.verifyResult);
			}
		},
		error: function() {
			console.log("Finding verify info is error!");
		}
	});
	
	/* 选择证书发放人的二级联动效果*/
	$.ajax({
		url : "getAllUsers.action",
		type: "post",
		dataType: "json",
		success: function(result) {
			console.log("Getting all users is ok!");
			
			var unit_users = $.parseJSON(result)[0];
			
			setUsersToSelect(unit_users);
		},
		error: function() {
			console.log("Getting all users is error!");
		}
	});
	
	function setUsersToSelect(unit_users) {
		var sel_unit = $("#unit");
		var sel_user = $("#issuePerson");
		
		for(var unitName in unit_users) {
			var option = document.createElement("option");
			option.innerHTML = unitName;
			sel_unit.append($(option));
		}
		
		sel_unit.bind("change", function() {
			sel_user[0].length = 1;
			
			var users = unit_users[$(this).val()];
			$(users).each(function(index, user) {
				var option = document.createElement("option");
				option.innerHTML = user['name'];
				option.value = user['userId'];
				sel_user.append($(option));
			});
		});
		
		setDefaultUser();
	}
	
	function setDefaultUser() {
		$.ajax({
			url: 'findUserInfoAction.action',
			type: 'post',
			data: {
				'userId': $("#userId").val()
			},
			dataType: 'json',
			success: function(result) {
				console.log("Finding user info is ok!");
				if (result.success == true) {
					var user = result.user;
					
					$("#unit option").each(function(index, option) {
						if (option.innerHTML == user.unitName) {
							option.selected = true;
						}
					});
					$("#unit").trigger('change');
					$("#issuePerson").find("option[value='" + user.userId + "']").attr('selected', true);
					
//					$("#issuePerson").text();
				}
			},
			error: function(result) {
				console.log("Finding user info is error!");
			}
		});
	}
});