$(document).ready(function() {
	
	/*进入页面就进行查询*/
	$("#currentPages").val("1");
	paging();
	searchTotalPage();
	
	/*条件查询记录*/
	function paging(){
		/* 查询处当前页面中表格的值，并写入 */
		$.ajax({
					type : "post",
					datatype : "json",
					url : "searchProject3A.action",
					data : {
						"condition.projectName" : $(
								"#projectNameSearch")
								.val(),
						"condition.applicant" : $(
								"#applicantSearch")
								.val(),
						"condition.domain" : $(
								"#DomainSearch  option:selected")
								.val(),
						"condition.recordDate" : $(
								"#recordDateSearch  option:selected")
								.val(),
						"condition.chargePerson" : $("#userId").val(),
						"currentPages" : $(
								"#currentPages")
								.val(),
					},
					success : function(result) {
						
						/* 在表格中添加数据 */
						$("#projectTable  tr:not(:first)")
								.html("");

						var t_body = $("#projectTable");
						/* 循环添加每一行 */
						for (var i = 0; i < result.length; i++) {
							var a = i - (-1);
							var _tr = "<tr><td>" + a + "</td>";
							_tr += "<td>" + result[i].projectName + "</td>";
							_tr += "<td>" + result[i].projectId + "</td>";
							_tr += "<td>" + result[i].applicant + "</td>";
							_tr += "<td>" + result[i].domain + "</td>";
							_tr += "<td>" + result[i].projectRecord.recordDate + "</td>";
							_tr += "<td>" + result[i].projectCharge.destributionDate + "</td>";
//							_tr += "<td>" + result[i].status + "</td>";
							_tr += "<td title="+ result[i].status +">" + dic[result[i].status] + "</td>";
							if(result[i].projectRecord.remark1=='查看') {
								_tr += "<td><a href='javaScript:void(0)' class='projectStatus' title='查看'>"
										+"<i class='glyphicon glyphicon-search'></i></a></td></tr>";
							} else if(result[i].projectRecord.remark1=='录入企业考察信息'){
								_tr += "<td><a href='javaScript:void(0)' class='projectStatus' title='录入企业考察信息'>"
										+"<i class='glyphicon glyphicon-pencil'></i></a></td></tr>";
							} else if(result[i].projectRecord.remark1=='当前不能操作'){
								_tr += "<td><a href='javaScript:void(0)' class='projectStatus' title='当前不能操作'>"
										+"<i class='glyphicon glyphicon-ban-circle'></i></a></td></tr>";
						}  
							
							var $tr = $(_tr);
							$tr.appendTo(t_body);
						}

					},
					error : function() {
//						alert("查询失败,请重试");
					}

				});
	
	}
	
	/*查询所有的领域*/
	$.ajax({
			type : "post",
			dataType : "json",
			url : "findDomainL.action",
			success : function(domains){
				var domain = document.getElementById("DomainSearch");
				for(var i=0; i<domains.length; i++){
					var option = document.createElement("option");
					option.innerHTML = domains[i];
					option.value = domains[i];
					domain.appendChild(option);
				}
				
			}
		});
	
	/* 设置当前分页的总页数 */
	function searchTotalPage(){
		$.ajax({
			type : "post",
			datatype : "json",
			url : "searchPaging.action",
			data : {
		"condition.projectName" : $(
				"#projectNameSearch")
				.val(),
		"condition.applicant" : $(
				"#applicantSearch")
				.val(),
		"condition.domain" : $(
				"#DomainSearch  option:selected")
				.val(),
		"condition.recordDate" : $(
				"#recordDateSearch  option:selected")
				.val(),
		"condition.chargePerson" : $("#userId").val(),
			},
			success : function(totalPage) {
				$("#totalPage").val(totalPage);
				myPaging(totalPage);
			}
		});
	}
	
	/* 点击查询按钮 */
	$("#searchButton").click(function(){
		$("#currentPages").val("1");
		paging();
		searchTotalPage();
	});
	
	$("#projectTable").on("click",".projectStatus",function(){
		var operation = $(this).attr('title');
		var id = $(this).parent().siblings("td:eq(2)").text();
		if (operation == "录入企业考察信息") {
			location = "viewInvestigate.action?projectId=" + id + "";
		} else if(operation == "查看"){
			location = "LookProjectInfo.action?projectId=" + id + "";
		} else if(operation == "当前不能操作"){
			alert("请先完成前几步的操作");
		}
	})
//	$(".projectStatus").click(function() {
//		var operation = $(this).attr('title');
//		var id = $(this).parent().siblings("td:eq(2)").text();
//		if (operation == "录入企业考察信息") {
//			location = "viewInvestigate.action?projectId=" + id + "";
//		} else if(operation == "查看"){
//			location = "LookProjectInfo.action?projectId=" + id + "";
//		} else if(operation == "当前不能操作"){
//			alert("请先完成前几步的操作");
//		}
//	});

	/* form表单条件查询 */
//	$("#searchButton").click(function() {
//		$("#currentPages").val("1");
//		$("#submitSearch").trigger("click");
//	});
	
	/*
	 * 分页
	 **/
	function myPaging(totalPage){
		$(function() {
			$("#demo1").myPagination({
				currPage: 1,
				pageCount: totalPage,
				ajax: {
					on: false,
					onClick: function(page) {
						$("#currentPages").val(page);
						paging();
					}
				}
			});
		});
	}
	
	/*
	 * 导出
	 **/
	$("#printOut").click(function() {
		window.location.href = "admin/receiveMaterial/printEnterprise.jsp?projectName="
			+$("#projectNameSearch").val()+"&applicant="+$("#applicantSearch").val()
			+"&domain="+$("#DomainSearch  option:selected").val()
			+"&recordDate="+$("#recordDateSearch  option:selected").val()
			+"&chargePerson="+$("#userId").val();
	});
	
	/*清空输入框*/
		$("#clearButton").click(function(){
			$("#projectNameSearch").val("");
			$("#applicantSearch").val("");
			$("#DomainSearch").val("");
			$("#recordDateSearch").val("");
		});
	
});