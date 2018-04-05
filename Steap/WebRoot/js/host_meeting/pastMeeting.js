$(function() {
	
	$.ajax({
		url: "findPresidedMeetingAction.action",
		type: "post",
		data: {
			"hostId" : $("#userId").val(),
		},
		dataType: "json",
		success: function(result) {
			var meetings = result.meetings;
			
			if(meetings != null) {
				console.log("Finding presided meeting is ok!");
				var size = meetings.length;
				
				var t_body = $("#t_meeting");
				for(var i = 0; i < size; i++) {
					var _tr = "<tr><td>" + (i + 1) + "</td>";
					_tr += "<td>" + meetings[i].meetingName + "</td>";
					_tr += "<td>" + meetings[i].meetingTime + "</td>";
					_tr += "<td>" + meetings[i].meetingPlace + "</td></tr>";
					$(_tr).appendTo(t_body);
				}
			}
			
		},
		error: function() {
			console.log("Finding presided meeting is error!");
		}
	});
});