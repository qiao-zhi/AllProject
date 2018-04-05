$(function() {
	
	$.ajax({
		url: "findPastProjectAction.action",
		type: "post",
		data: {
			"specialistId" : $("#expertId").val()
		},
		dataType: "json",
		success: function(result) {
			var projects = result.projects;
			
			if(projects != null) {
				console.log("Finding past projects is ok!");
				var size = projects.length;
				var t_body = $("#t_project");
				
				for(var i = 0; i < size; i++) {
					var _tr = "<tr><td>" + (i + 1) + "</td>";
					_tr += "<td>" + projects[i].projectName + "</td>";
					_tr += "<td>" + projects[i].applicant + "</td>";
					_tr += "<td>" + projects[i].domain + "</td>";
//					_tr += "<td><a href='javascript:void(0);' data_title='" + projects[i].projectId + "'>查看</a></td></tr>";
					_tr += "</tr>";
					$(_tr).appendTo(t_body);
				}
			}
		},
		error: function() {
			console.log("Finding past projects is error!");
		}
	});
});