$(document).ready(function() {
		$('#searchButton').click(function() {
			/* 查询处当前页面中表格的值，并写入 */
			$.ajax({
				type : "post",
				datatype : "json",
				url : "searchProject2.action",
				data : {
					"condition.projectName" : $("#projectName").val(),
					"condition.applicant" : $("#applicant").val(),
					"condition.domain" : $("#selectDomain  option:selected").text(),
					"condition.recordDate" : $("#recordDate  option:selected").text(),
					"condition.chargePerson" : "老王",
					currentPage : $("#currentPage").val(),
				},
				success : function (result){
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
					for (var i = 0; i < result.length; i++) {
						var a = i + 1;
						$("#projectTable").append(
								"<tr> <td>" + a + "</td><td> "
										+ result[i].projectName
										+ " </td><td> "
										+ result[i].projectId
										+ " </td><td> "
										+ result[i].applicant
										+ " </td><td> "
										+ "申请日期"
										+ " </td><td> "
										+ result[i].domain
										+ " </td><td> "
										+ result[i].projectRecord.recordDate
										+ " </td><td> "
										+ result[i].projectRecord.recordPerson
										+ " </td><td> "
										+ result[i].projectCharge.destributionDate
										+ " </td><td> "
										+ result[i].projectCharge.chargeUnit
										+ " </td><td> "
										+ result[i].projectCharge.chargePerson
										+ " </td><td> "
										+ result[i].projectReceive.receivePerson
										+ " </td><td> "
										+ result[i].projectReceive.receiveDate
										+ " </td><td> "
										+ result[i].projectCensor.censorPerson
										+ " </td><td> "
										+ result[i].projectCensor.censorDate
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