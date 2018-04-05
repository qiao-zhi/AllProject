$(function() {
	/* 查询项目领域信息*/
	$.ajax({
		url : "findDomainSetAction.action",
		type : "post",
		dataType : "json",
		success : function(result) {
			console.log("Finding domain set is ok!");
			var domains = result.domains;
			if(domain != null) {
				var size = domains.length;
				var s_domain = $("#domain");
				
				for(var i = 0; i < size; i++) {
					var _option = "<option>" + domains[i] + "</option>";
					$(_option).appendTo(s_domain);
				}
			}
		},
		error : function() {
			console.log("Finding domain set is error!");
		}
	});
	
	/* 无条件查询项目信息*/
	findProjectSet({
//		"chargePerson" : $("#userId").val(),
		"pageBegin" : 0,
		"pageSize" : $("#pageSize").val()
	});
	
	/* 条件组合查询项目信息*/
	$("#searchButton").click(function() {
		var params = getParams();
		
		$(".page_info").val("");
		
		var pageSize = $("#pageSize").val();
		var currentPage = $("#currentPage").val();
		if(currentPage == null || currentPage == "") {
			currentPage = 0;
			params.pageBegin = 0;
		} else {
			params.pageBegin = (currentPage - 1) * pageSize;
		}
		params.pageSize = pageSize;
		console.log("currentPage: " + currentPage + ", pageSize: " + pageSize);
		findProjectSet(params);
	});
	
	/* 分页查询项目信息*/
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
						
						var params = getParams();
						var pageSize = $("#pageSize").val();
						params.pageBegin = (page - 1) * pageSize;
						params.pageSize = pageSize;
						
						findProjectSet(params);
					}
				}
			});			
		});
	}
	
	function findProjectSet(params) {
		$.ajax({
			url: "findProjectSetAction.action",
			type: "post",
			data: params,
			dataType: "json",
			success: function(result) {
				console.log("Finding project set is ok!");
				
				var projects = result.projects;
				var t_body = $("#t_project");
				t_body.html("");
				
				if(projects != null && projects.length != 0) {
					
					var size = projects.length;
					var detail_href = "admin/issue/project_details.jsp";
					for(var i = 0; i < size; i++) {
						var _tr = "<tr>";
						if ('已发放' == dic[projects[i].projectStatus]) {
							_tr += "<td><input disabled='disabled' type='radio' value=" + projects[i].projectId + " name='send' /></td>";
						} else {
							_tr += "<td><input type='radio' value=" + projects[i].projectId + " name='send' /></td>";
						}
						_tr += "<td>" + projects[i].projectName + "</td>";
						_tr += "<td>" + projects[i].projectId + "</td>";
						_tr += "<td>" + projects[i].applicant + "</td>";
						_tr += "<td>" + projects[i].domain + "</td>";
						_tr += "<td>" + projects[i].recordDate + "</td>";
						_tr += "<td>" + projects[i].checkDate + "</td>";
						_tr += "<td>" + projects[i].name + "</td>";
						_tr += "<td class='certificate'>" + projects[i].certificate + "</td>";
						_tr += "<td title='" + projects[i].projectStatus + "'>" + dic[projects[i].projectStatus] + "</td>";
						_tr += "<td><a href='" + detail_href + "?projectId=" + projects[i].projectId + "' title='查看项目详情'><i class='glyphicon glyphicon-search'></i></a></td></tr>"; 
						$(_tr).appendTo(t_body);
					}
					
					var currentPage = result.currentPage;
					var pageCount = result.pageCount;
					if(currentPage != null && typeof currentPage != "undefined") {
						$("#currentPage").val(currentPage);
						$("#pageCount").val(pageCount);
						
						var totalPage = result.pageCount;
						if(totalPage != null && typeof totalPage != "undefined") {
							pagingSearch(totalPage);
						}
					}
				} else if (projects != null && projects.length == 0 ) {
					alert("没有符合的项目记录!");
				}
			},
			error: function() {
				console.log("Finding project set is error!");
			}
		});
	}
	
	function getParams() {
		var params = {};
		var projectName = $("#projectName").val();
		if(projectName != null && projectName !="") {
			params.projectName = projectName;
		}
		
		var applicant = $("#applicant").val();
		if(applicant != null && applicant != "") {
			params.applicant = applicant;
		}
		
		var domain = $("#domain option:selected").text();
		if(domain != null && domain != "" && domain != "-领域-") {
			params.domain = domain;
		}
		
		var projectStandard = $("#projectStandard option:selected").val();
		params.projectStandard = projectStandard;
		
//		var userId = $("#userId").val();
//		params.chargePerson = userId;
		
		return params;
	}	
	
	$("#clearButton").click(function() {
		$("#projectName").val("");
		$("#applicant").val("");
		
		$("#domain").val('-领域-');
		$("#projectStandard").val(0);
	});
	
	/* 发放证书*/
	$("#issueCertificate").click(function() {
		var content = $("input[name='send']:checked").parent("td").parent("tr").find("td.certificate").text();
		
		if(content == "是") {
			alert("请选择未发放证书项目!");
			return false;
		}
		
		var projectId = $("input[type='radio'][name='send']:checked").val();
		if(typeof(projectId) == undefined || projectId == null) {
			alert("请选择项目!");
			return false;
		}
		var local_href = $(this).attr("data_title");
		window.location.href = local_href + "?projectId=" + projectId;
	});
	
	/* 导出报表*/
	$("#export").click(function() {
		var params = getParams();
		
		window.location.href = "admin/issue/printIssueProject.jsp?" + params;
	});
});