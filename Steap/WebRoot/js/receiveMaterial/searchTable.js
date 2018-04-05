$(document).ready(function() {
	function dosearch(){
		alert("我是登记界面");
	}
	
	$('#searchButton').click(function() {
		/* 查询处当前页面中表格的值，并写入 */
		$.ajax({
			type : "post",
			datatype : "json",
			url : "searchProject.action",
			data : {
				"condition.projectName" : $("#projectName").val(),
				"condition.applicant" : $("#applicant").val(),
				"condition.domain" : $("#selectDomain  option:selected").text(),
				"condition.recordDate" : $("#recordDate  option:selected").text(),
				"condition.recordPerson" : "老王",
				currentPage : $("#currentPage").val(),
			},
			success : function (projects){
				/* 设置当前分页的总页数 */
				$.ajax({
					type : "post",
					datatype : "json",
					url : "getPages.action",
					data : null,
					success : function(pageNums){
						$("#totalPage").val(pageNums);
					}
				});
				
				/* 在表格中添加数据 */
				$("#projectTable  tr:not(:first)").html(""); 
				
				/* 循环添加每一行 */
				for (var i = 0; i < projects.length; i++) {
					var a = i + 1;
					$("#projectTable").append(
							"<tr> <td>" + a + "</td><td> "
							+ projects[i].projectName
							+ " </td><td> "
							+ projects[i].projectId
							+ " </td><td> "
							+ projects[i].applicant
							+ " </td><td> "
							+ projects[i].domain
							+ " </td><td> "
							+ "登记日期"
							+ " </td><td> "
							+ "负责部门"
							+ " </td><td> "
							+ "负责人"
							+ " </td><td> "
							+ projects[i].contactPerson
							+ " </td><td> "
							+ projects[i].telephone
							+ " </td><td> "
							+ "操作"
							+ " </td></tr>");
				}
				
			}, error : function (){
				alert("查询失败,请重试");
			}
			
		});
	});

});