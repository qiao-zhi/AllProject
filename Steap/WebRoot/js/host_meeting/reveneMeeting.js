$(function() {
	findMeetingSet({
		"hostId" : $("#userId").val(),
		"pageBegin" : 0,
		"pageSize" : $("#pageSize").val()
	});
	
	function pagingSearch(totalPage) {
		$(function() {
			$("#paging").myPagination({
				currPage : $("#currentPage").val(),
				pageCount : totalPage,
				pageSize : $("#pageSize").val(),
				ajax : {
					on : false,
					onClick : function(page) {
						$("#currentPage").val(page);
						
						var params = {};
						var pageSize = $("#pageSize").val();
						params.pageBegin = (page - 1) * pageSize;
						params.pageSize = pageSize;
						
						findMeetingSet(params);
					}
				}
			});
		});
	}
	
	function findMeetingSet(params) {
		$.ajax({
			url : "reveneMeetingListAction.action",
			type : "post",
			data : params,
			dataType : "json",
			success : function(result) {
				console.log("Finding meeting set is ok!");
				
				$("#tip_num").css({
					'display': 'none'
				});
				
				var meetings = result.meetings;
				var t_body = $("#t_meeting");
				t_body.html("");
				
				if(meetings != null && meetings.length != 0) {
					var size = meetings.length;
					
					for(var i = 0; i < size; i++) {
						var _tr = "<tr><td><input type='radio' name='meeting' value='" + meetings[i].meetingId + "' /></td>";
						_tr += "<td>" + meetings[i].meetingName + "</td>";
						_tr += "<td>" + meetings[i].meetingTime + "</td>";
						_tr += "<td>" + meetings[i].meetingPlace + "</td>";
						_tr += "<td>" + meetings[i].meetingStatus + "</td></tr>";
						
						$(_tr).appendTo(t_body);
					}
					
					var currentPage = result.currentPage;
					var pageCount = result.pageCount;
					if(currentPage != null && typeof currentPage != "undefined") {
						$("#currentPage").val(currentPage);
						$("#pageCount").val(pageCount);
						
						var totalPage = result.totalPage;
						if(totalPage != null && typeof currentPage != "undefined") {
							pagingSearch(totalPage);
						}
					}
				} else if(meetings != null && meetings.length == 0) {
//					alert("无待召开会议信息!");
					$("#tip_num").css({
						'display': 'inline'
					});
				}
			},
			error : function() {
				console.log("Finding meetings is error!");
			}
		});
	}
	
	$("#convene_meeting").click(function() {
		var selectedMeeting = $("input[type='radio'][name='meeting']:checked");
		var meetingId = selectedMeeting.val();
		
		if(meetingId != null && meetingId != "") {
			if (confirm("您确定要召开当前选中的会议吗？")) {
				checkReveneMeetingCountAction(meetingId);
			} else {
				return false;
			}
		} else {
			alert("请先选择一个要召开的会议!");
		}
	});
	
	function checkReveneMeetingCountAction(meetingId) {
		$.ajax({
			url : "checkReveneMeetingCountAction.action",
			type : "post",
			data : {
				"hostId" : $("#userId").val(),
			},
			dataType : "json",
			success : function(result) {
				console.log("Check revene meeting count is success!");
					
				if(result.meetingCount == 0) {
					$.ajax({
						url : "reveneMeetingAction.action",
						type : "post",
						data : {
							"meetingId" : meetingId
						},
						dataType : "json",
						success : function(result) {
							console.log("Convene meeting is ok!");
							
							if (result.meetingDoc || result.projectDoc) {
								if(result.meetingDoc.length !== 0 || result.projectDoc.length !== 0) {
									$("#revene_meeting_modal").modal('show');
									var meetingDoc = result.meetingDoc,
										projectDoc = result.projectDoc;
									
									var m_tbody = $("#t_meeting_unfinished");
									m_tbody.html("");
									for (var i = 0; i < meetingDoc.length; i++) {
										var _tr = "<tr>";
										_tr += "<td>" + (i + 1) + "</td>";
										_tr += "<td>" + meetingDoc[i].no + "</td>";
										_tr += "<td>" + meetingDoc[i].name + "</td>";
										_tr += "<td>" + meetingDoc[i].unfinished + "</td></tr>";
										$(_tr).appendTo(m_tbody);
	 								}
									
									var p_tbody = $("#t_material_unfinished");
									p_tbody.html("");
									for (var i = 0; i < projectDoc.length; i++) {
										var _tr = "<tr>";
										_tr += "<td>" + (i + 1) + "</td>";
										_tr += "<td>" + projectDoc[i].no + "</td>";
										_tr += "<td>" + projectDoc[i].name + "</td>";
										_tr += "<td>" + projectDoc[i].unfinished + "</td></tr>";
										$(_tr).appendTo(p_tbody);
									}
									
									$("input[type='radio'][name='meeting']:checked").removeAttr("checked");
								} else if(result.update == true) {
									var update = result.update;
									if(result.update && update) {
										$("input[type='radio'][name='meeting']:checked").parent("td").parent("tr").find("td:last").text("召开中");
										if(confirm("选中会议成功召开，是否现在前往主持会议?!")) {
											window.location.href = "admin/host/hostedMeeting.jsp";
										} else {
											$("input[type='radio'][name='meeting']:checked").removeAttr("checked");
										}
									}
								}
							}
						},
						error : function() {
							console.log("Convene meeting is error!");
						}
					});		
				} else if(result.meetingCount > 0) {
					alert("同一会议主持人同一时刻\n只能召开一个会议!");
					$("input[type='radio'][name='meeting']:checked").removeAttr("checked");
				}
			},
			error : function() {
				console.log("Check revene meeting count is error!");
			}
		});
	}
	
	function reveneCurrentMeeting(meetingId) {
	}
});