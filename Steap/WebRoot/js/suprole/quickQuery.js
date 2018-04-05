$(document).ready(function() {
	
			/* 清空输入框 */
			$("#clearButton").click(function() {
				clearInput();
			})
			
			/* 默认查询 */
			paging();
			searchTotalPage();
	
			function clearInput() {
				$("#projectNumberSearch").val("");
				$("#projectNameSearch").val("");
				$("#porjectDomainSearch").val("");
				$("#projectStandardSearch").val("0");
				
				
				$("#projectNumberSearch").val("");
				$("#projectNameSearch").val("");
				$("#startTime").val("");
				$("#endTime").val("");
				$("#applicationSearch").val("");
				$("#projectStatusSearch").val("");
				$("#porjectDomainSearch").val("");
				$("#projectStandardSearch").val("0");
				
			}
	
			/*点击查询按钮*/
			$('#searchButton').click(function() {
				$("#currentPages").val("");
				paging();
				searchTotalPage();
			});
	
			/*条件查询记录*/
			function paging() {
				/* 查询处当前页面中表格的值，并写入 */
				$.ajax({
					type : "post",
					datatype : "json",
					url : "searchAllProject.action",
					data : {
						"project.projectId" : $("#projectNumberSearch").val(),
						"project.projectName" : $("#projectNameSearch").val(),
						"project.startDate" : $("#startTime").val(),
						"project.endDate" : $("#endTime").val(),
						"project.applicant" : $("#applicationSearch").val(),
						"project.status" : $("#projectStatusSearch").val(),
						"project.domain" : $("#porjectDomainSearch").val(),
						"project.projectFunds" : $("#projectStandardSearch").val(),
						
						"currentPages" : $("#currentPages").val(),
					},
					success : function(resultList) {
	
						/* 在表格中添加数据 */
						$("#projectTable  tr:not(:first)")
							.html("");
	
						var t_body = $("#projectTable");
						for (var i = 0; i < resultList.length; i++) {
							var a = i - (-1);
							var _tr = "<tr><td>" + a + "</td>";
							_tr += "<td>" + resultList[i].projectName + "</td>";
							_tr += "<td>" + resultList[i].projectId + "</td>";
							_tr += "<td>" + resultList[i].applicant + "</td>";
							_tr += "<td>" + resultList[i].domain + "</td>";
							
							if(resultList[i].chargePerson == "" || resultList[i].chargePerson == null){
								_tr += "<td>" + "-" + "</td>";
							} else {
								_tr += "<td>" + resultList[i].chargePerson + "</td>";
							}
							
							if(resultList[i].hostPerson == "" || resultList[i].hostPerson == null){
								_tr += "<td>" + "-" + "</td>";
							} else {
								_tr += "<td>" + resultList[i].hostPerson + "</td>";
							}
								
							_tr += "<td>" + resultList[i].projectFunds + "</td>";
							_tr += "<td title=" + resultList[i].status + ">" + dic[resultList[i].status] + "</td>";

							_tr += "<td><a href='javaScript:void(0)' data-toggle='modal'"
								+ "class='operation_view' data-toggle='tooltip'"
								+ "data-placement='bottom' title='查看详情'>"
								+ "<i class='glyphicon glyphicon-search'></i></a>"
								+ "</td></tr>";
							
							var $tr = $(_tr);
							$tr.appendTo(t_body);
						}
	
					},
					error : function() {
						//alert("查询失败,请重试");
					}
				});
			}
	
			/* 设置当前分页的总页数 */
			function searchTotalPage() {
				$.ajax({
					type : "post",
					datatype : "json",
					url : "searchAllPageNum.action",
					data : {
						"project.projectId" : $("#projectNumberSearch").val(),
						"project.projectName" : $("#projectNameSearch").val(),
						"project.startDate" : $("#startTime").val(),
						"project.endDate" : $("#endTime").val(),
						"project.applicant" : $("#applicationSearch").val(),
						"project.status" : $("#projectStatusSearch").val(),
						"project.domain" : $("#porjectDomainSearch").val(),
						"project.projectFunds" : $("#projectStandardSearch").val(),
					},
					success : function(totalPage) {
						$("#totalPage").val(totalPage);
						myPaging(totalPage);
					}
				});
			}
	
			/*
					 * 分页
					 **/
			function myPaging(totalPage) {
				$(function() {
					$("#demo1").myPagination({
						currPage : 1,
						pageCount : totalPage,
						ajax : {
							on : false,
							onClick : function(page) {
								$("#currentPages").val(page);
								paging();
							}
						}
					});
				});
			}
			
			/*查询所有的领域*/
					$.ajax({
		  				type : "post",
		  				dataType : "json",
		  				url : "findDomainL.action",
		  				success : function(domains){
		  					var domain1 = document.getElementById("porjectDomainSearch");
		  					for(var i=0; i<domains.length; i++){
		  						var option = document.createElement("option");
			  					option.innerHTML = domains[i];
			  					option.value = domains[i];
			  					domain1.appendChild(option);
		  					}
		  				}
		  			});
					
					/*查询所有的项目状态*/
					$.ajax({
		  				type : "post",
		  				dataType : "json",
		  				url : "getAllStatus.action",
		  				success : function(statusList){
		  					var domain2 = document.getElementById("projectStatusSearch");
		  					for(var i=0; i<statusList.length; i++){
		  						var option = document.createElement("option");
			  					option.innerHTML = statusList[i].dictionaryOptionName;
			  					option.value = statusList[i].dictionaryOptionId;
			  					domain2.appendChild(option);
		  					}
		  				}
		  			});
					
		  			
		  	/* 查看项目详细信息 */
			$("#projectTable").on("click",".operation_view",function(){
				var projectId = $(this).parent().siblings("td:eq(2)").text();
				window.location = "searchProjectDetail.action?projectId="+projectId+"";
			});
				
			
			/*
			 * 导出
			 **/
			$("#printOut").click(function() {
				var params = "";
				
				var projectId = $("#projectNumberSearch").val();
				if (isNotNull(projectId)) {
					params += "projectId=" + projectId + "&";
				}
				
				var projectName = $("#projectNameSearch").val();
				if (isNotNull(projectName)) {
					params += "projectName=" + projectName + "&";
				}
				
				var domain = $("#porjectDomainSearch").val();
				if (isNotNull(domain)) {
					params += "domain=" + domain + "&";
				}
				
				var projectFunds = $("#projectStandardSearch").val()
				if (isNotNull(projectFunds)) {
					params += "projectFunds=" + projectFunds + "&";
				}
				
				var startDate = $("#startTime").val();
				if (isNotNull(startDate)) {
					params += "startDate=" + startDate + "&";
				}
				
				var endDate = $("#endTime").val();
				if (isNotNull(endDate)) {
					params += "endDate=" + endDate + "&";
				}
				
				var applicant = $("#applicationSearch").val();
				if (isNotNull(applicant)) {
					params += "applicant=" + applicant + "&";
				}
				
				var status = $("#projectStatusSearch").val();
				if (isNotNull(status)) {
					params += "status=" + status + "&";
				}

				params = params.substring(0, params.length - 1);
				
				console.log("params: " + params);
				window.location.href = "admin/suprole/printProject.jsp?" + params;
			});
			
			function isNotNull(val) {
				return val !== "" && val !=='undefined' && val !== null && val !== undefined;
			}
		})