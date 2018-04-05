$(document).ready(function () {
		
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
						url : "searchPerfectPA.action",
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
						success : function(projects) {
							
							/* 在表格中添加数据 */
							$("#projectTable  tr:not(:first)")
									.html("");

							var t_body = $("#projectTable");
							/* 循环添加每一行 */
							for (var i = 0; i < projects.length; i++) {
								
								var _tr = "<tr>";
								
								if ("已审核" == dic[projects[i].status]) {
									_tr += "<td><input disabled='disabled' type='radio' name='project_radio_to_perfect' /></td>";
								} else {
									_tr += "<td><input type='radio' name='project_radio_to_perfect' /></td>";
								}
								
								_tr += "<td>" + projects[i].projectName + "</td>";
								_tr += "<td>" + projects[i].projectId + "</td>";
								_tr += "<td>" + projects[i].applicant + "</td>";
								_tr += "<td>" + projects[i].domain + "</td>";
								_tr += "<td>" + projects[i].applicationDate + "</td>";
								_tr += "<td>" + projects[i].projectFunds + "</td>";
								_tr += "<td>" + projects[i].telephone + "</td>";
								_tr += "<td title='"+  projects[i].status + "'>" + dic[projects[i].status] + "</td>";
								_tr += "<td><a href='javaScript:void(0)' class='search_project'"
									+"data-toggle='tooltip' data-placement='bottom' title='查看'>"
									+"<i class='glyphicon glyphicon-search'></i></a></td></tr>";
								
								var $tr = $(_tr);
								$tr.appendTo(t_body);
							}

						},
						error : function() {
							alert("查询失败,请重试");
						}

					});
		
		}
		
		/*查询所有的领域*/
		$.ajax({
				type : "post",
				dataType : "json",
				url : "findDomainL.action",
				success : function(domains){
					var domain1 = document.getElementById("DomainSearch");
					for(var i=0; i<domains.length; i++){
						var option = document.createElement("option");
  					option.innerHTML = domains[i];
  					option.value = domains[i];
  					domain1.appendChild(option);
					}
				}
			});
		
		/* 设置当前分页的总页数 */
		function searchTotalPage(){
			$.ajax({
				type : "post",
				datatype : "json",
				url : "searchPerfectPageNums.action",
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
		
		/*点击查询按钮*/
		$('#searchButton').click(function() {
							$("#currentPages").val("");
							paging();
							searchTotalPage();
						});
		
		$("#perferMa").click(function(){
			var projectId = $("input[name='project_radio_to_perfect']:checked").parent().siblings("td:eq(1)").text();
			if($("input[name='project_radio_to_perfect']:checked").is(':checked')){
				window.location="perfectProjectM.action?projectId="+projectId+"";
			} else {
				alert("请先选择一个项目");
			}
		});
		
		/*清空输入框*/
			$("#clearButton").click(function(){
				$("#projectNameSearch").val("");
				$("#applicantSearch").val("");
				$("#DomainSearch").val("");
				$("#recordDateSearch").val("");
			});
		
		$("#projectTable").on("click",".search_project",function(){
			var projectId = $(this).parent().siblings("td:eq(2)").text();
			window.location = "searchProjectDetail.action?projectId="+projectId+"";
		});
		/* $(".search_project").click(function(){
			var projectId = $(this).parent().siblings("td:eq(2)").text();
			window.location = "searchProjectDetail.action?projectId="+projectId+"";
		}); */
		
		/* form表单条件查询 */
		$("#searchButton").click(function() {
			$("#currentPages").val("1");
			$("#submitSearch").trigger("click");
		});
		
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
			window.location.href = "admin/perfectMaterial/printPerfect.jsp?projectName="
				+$("#projectNameSearch").val()+"&applicant="+$("#applicantSearch").val()
				+"&domain="+$("#DomainSearch  option:selected").val()
				+"&recordDate="+$("#recordDateSearch  option:selected").val()
				+"&chargePerson="+$("#userId").val();
		});
		
		
		$("#exportOpinion").click(function() {
			var selInput = $("input:radio:checked"),
				projectId;

			if (selInput.length == 0) {
				alert("导出专家意见需要先选择一个项目!");
				return ;
			}
			
			projectId = selInput.parent("td").parent("tr").children("td:eq(2)").text();
			
			if (projectId) {
				var params = "ReportServer?reportlet=opinions.cpt";
				params += "&projectId=" + projectId;
				
				window.location.href = params;
				console.log("Export specialist opinion is ok!");
			}
			
		});
	});
