$(function() {
	
	/* 查询当前专家待评审项目数*/
	$.ajax({
		url: "findEvaluatedCountAction.action",
		type: "post",
		data: {
			specialistId : $("#expertId").val()
		},
		dataType: "json",
		success: function(count) {
			console.log("Finding evaluated count is ok!" + count);
			$(".badge").text(count);
		},
		error: function() {
			console.log("Finding evaluated count is error!");
		}
	});
});