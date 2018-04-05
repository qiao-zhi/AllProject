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
									url : "searchProjectA.action",
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
										/*
										 * "condition.recordPerson" :
										 * "老王",
										 */
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
											var a = i - (-1);
											var _tr = "<tr><td>" + a + "</td>";
											_tr += "<td>" + projects[i].projectName + "</td>";
											_tr += "<td>" + projects[i].projectId + "</td>";
											_tr += "<td>" + projects[i].applicant + "</td>";
											_tr += "<td>" + projects[i].domain + "</td>";
											_tr += "<td>" + projects[i].applicationDate + "</td>";
											_tr += "<td>" + projects[i].contactPerson + "</td>";
											_tr += "<td>" + projects[i].telephone + "</td>";
											_tr += "<td class='hidden'>" + projects[i].recordPerson + "</td>";
											_tr += "<td class='hidden'>" + projects[i].status + "</td>";
//											_tr += "<td>" + projects[i].status + "</td>";
											_tr += "<td title="+ projects[i].status +">" + dic[projects[i].status] + "</td>";
//											if(projects[i].status == "查看" || projects[i].status == "已确定") {
//												_tr += "<td><a href='.bs-example-modal-lg' data-toggle='modal'"
//													+"class='operation_view' data-toggle='tooltip'"
//													+"data-placement='bottom' title='查看项目信息'>"
//													+"<i class='glyphicon glyphicon-search'></i></a>" 
//													+ " <a href='javaScritp:void(0)'"
//													+"class='delete_view' data-toggle='tooltip'"
//													+"data-placement='bottom' title='删除当前项目'>"
//													+"<i class='glyphicon glyphicon-trash'></i></a>"
//													+"</td></tr>";
//											} else if(projects[i].status == "确定负责部门"){
//												_tr += "<td><a href='#destribution_modal' data-toggle='modal'"
//														+"class='operation_icon' data-toggle='tooltip'"
//														+"data-placement='bottom' title='确定项目验收负责人'>"
//														+"<i class='glyphicon glyphicon-pencil'></i></a>"
//														+ "<a href='javaScritp:void(0)'"
//														+"class='delete_view' data-toggle='tooltip'"
//														+"data-placement='bottom' title='删除当前项目'>"
//														+"<i class='glyphicon glyphicon-trash'></i></a>"
//														+"</td></tr>";
//											}	else 
												if(projects[i].remark == "只查看"){
												_tr += "<td><a href='javaScript:void(0)' data-toggle='modal'"
													+"class='operation_view' data-toggle='tooltip'"
													+"data-placement='bottom' title='当前不能操作'>"
													+"<i class='glyphicon glyphicon-ban-circle'></i></a>" 
													+"</td></tr>";
											}  else {
												_tr += "<td><a href='.bs-example-modal-lg' data-toggle='modal'"
													+"class='delete_view' data-toggle='tooltip'"
													+"data-placement='bottom' title='删除当前项目'>"
													+"<i class='glyphicon glyphicon-trash'></i></a>"
													+"</td></tr>";
											}
											var $tr = $(_tr);
											$tr.appendTo(t_body);
										}

									},
									error : function() {
//										alert("查询失败,请重试");
									}

								});
					
					}
					
					/*删除项目，通过项目Id*/
					$("#projectTable").on("click",".delete_view",function(){
						var projectId = $(this).parents("tr").children().eq("2").text();
						var $line = $(this);
						if(confirm("是否删除该项目")){
							$.ajax({
				  				type : "post",
				  				dataType : "json",
				  				 async:false, 
				  				url : "deleteCurrentP.action",
				  				data : {
				  					"projectId" : projectId
				  				},
				  				success : function(result){
				  					alert("删除成功");
				  					$line.parent().parent().remove();
				  				}, error : function(){
				  					alert("删除失败，请重试");
				  				}
				  			});
							return false;
						}
						return false;
					})
					
					/*查询所有的领域*/
					$.ajax({
		  				type : "post",
		  				dataType : "json",
		  				url : "findDomainL.action",
		  				success : function(domains){
		  					var domain1 = document.getElementById("DomainSearch");
		  					var domain2 = document.getElementById("domainF");
		  					for(var i=0; i<domains.length; i++){
		  						var option = document.createElement("option");
			  					option.innerHTML = domains[i];
			  					option.value = domains[i];
			  					domain2.appendChild(option);
		  					}
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
						/*
						 * "condition.recordPerson" :
						 * "老王",
						 */
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
					
					/* 保存负责部门 */
					$("#saveDepartment").click(function() {
						$("#submitDepart").trigger("click");
					});

					/* 保存验收资料 */
					$("#saveRegist").click(function() {
						$("#submitRegist").trigger("click");
					});
					

					/* 将选中的值放入label中 */
					$(".choosePerson").click(function() {
						var b = $(this).parent().siblings("td:eq(1)").text();
						$("#getPerson").text(b);
						$("#getPerson2").val(b);
					});

//					$(".confirmDepart").click(function() {
//						var operation = $(this).text();
//
//						var a = $(this).parent().siblings("td:eq(1)").text();
//						var b = $(this).parent().siblings("td:eq(2)").text();
//						var c = $(this).parent().siblings("td:eq(3)").text();
//						var d = $(this).parent().siblings("td:eq(4)").text();
//
//						/* 将表格中数据填入确定负责部门框中 */
//						if (operation == "确定负责部门") {
//							$("#projectNameL").text(a);
//							$("#getProjectId").val(b);
//							$("#applicantL").text(c);
//							$("#domainL").text(d);
//
//							$("#confirmLable").trigger("click");
//
//							/* 将表格中数据填入查看框中 */
//						} else if (operation == "查看") {
//
//							$("#projectNameS").text(a);
//							$("#projectIdS").text(b);
//							$("#applicantS").text(c);
//							$("#domainS").text(d);
//
//							$("#viewLabel").trigger("click");
//							searchCharge();
//						}
//					});
					
					/* 将表格中数据填入查看框中 */
					/* 点击查看框时，同时将数据放入到确定负责部门的框中 */
					$("#projectTable").on("click",".operation_view",function(){
						var a = $(this).parent().siblings("td:eq(1)").text();
						var b = $(this).parent().siblings("td:eq(2)").text();
						var c = $(this).parent().siblings("td:eq(3)").text();
						var d = $(this).parent().siblings("td:eq(4)").text();
						var e = $(this).parent().siblings("td:eq(5)").text();
						var f = $(this).parent().siblings("td:eq(6)").text();
						var g = $(this).parent().siblings("td:eq(7)").text();
						var h = $(this).parent().siblings("td:eq(8)").text();
						var i = $(this).parent().siblings("td:eq(9)").text();
						
						$("#modifyConfirmB").attr("disabled",false);
						
						if(i == "查看" || i == "只查看"){
							$("#modifyConfirmB").attr("disabled",true);
						}
						
						$("#projectIdS").val(b);
						$("#projectNameS").text(a);
						$("#applicantS").text(c);
						$("#domainS").text(d);
						$("#recordPersonS").text(h);
						$("#recordDateS").text(e);
						$("#contactPersonS").text(g);
						/*$("#chargeUnitS").text();
						$("#chargePersonS").text();
						$("#destributionDateS").text();*/
						
						$("#projectNameL").text(a);
						$("#applicantL").text(c);
						$("#domainL").text(d);
						$("#getProjectId").val(b);
						
						
						searchCharge();
						
					
					});
					
					$("#modifyConfirmB").click(function(){
						closeBasicModal.click();
						$("#openConfirmM").click();
					})
					
					/* 将表格中数据添加到确定负责部门的框中 */
					$("#projectTable").on("click",".operation_icon",function(){
						var indexLine = $(this).closest('tr').index();
//						var cc = $(this).closest("tr").find("td").eq(8).html();
//						alert(cc);
						
						var a = $(this).parent().siblings("td:eq(1)").text();
						var b = $(this).parent().siblings("td:eq(2)").text();
						var c = $(this).parent().siblings("td:eq(3)").text();
						var d = $(this).parent().siblings("td:eq(4)").text();
						
						$("#projectNameL").text(a);
						$("#applicantL").text(c);
						$("#domainL").text(d);
						$("#getProjectId").val(b);
						
					});
					

					/*清空查询出来的，负责部门信息*/
					$("#closeBasicView").click(function(){
						$("#chargeUnitS").text("");
						$("#chargePersonS").text("");
						$("#destributionDateS").text("");
					})
					
					/* form表单条件查询 */
					$("#searchButton").click(function() {
						$("#currentPages").val("1");
						$("#submitSearch").trigger("click");
					});

					function searchCharge() {
						$.ajax({
							type : "post",
							datatype : "json",
							url : "searchCharge.action",
							data : {
								"projectCharge.projectId" : $("#projectIdS").val(),
							},
							success : function(result) {
								if(result==null){
									$("#chargeUnitS").text("");
									$("#chargePersonS").text("");
									$("#destributionDateS").text("");
								} else {
								$("#chargeUnitS").text(result.chargeUnit);
								$("#chargePersonS").text(result.chargePerson);
								$("#destributionDateS").text(
										result.destributionDate);
								}
							}
						});
					}

					/* 返回ztree的ajax */
					/* 这是在页面添加树状结构的js代码 */
					$
							.ajax({
								type : "post",
								target : "#treeDemo",
								dataType : "json",
								url : "searchDepartTree.action",
								success : function(unitInfos) {
									/* alert(treeList3); */
									var setting = {
										data : {
											simpleData : {
												enable : true,
												idKey : "unitId",
												pIdKey : "upUnitId",
												rootPId : "0",
											},
											key : {
												name : "unitName",
											}
										},
										callback : {
											onClick : onClick
										}
									};
									var zNodes = unitInfos;

									/*
									 * 添加 树节点的 点击事件；
									 */
									var log, className = "dark";
									function onClick(event, treeId, treeNode,
											clickFlag) {
										var name = treeNode.unitName;
										$("#getProjectUnit").val(name);
										$("#getProjectUnit2").text(name);
										$("#getPerson3").text("");
										$("#getPerson2").val("");
										getPerson(name);
									}

									$.fn.zTree.init($("#treeDemo"), setting,
											zNodes);

								}
							});
					/* 通过部门名称查询所有的员工 */
					function getPerson(name) {

						$
								.ajax({
									type : "post",
									dataType : "json",
									data : {
										unitName : name
									},
									url : "searchUsers.action",
									success : function(userList) {
										
										/* 清空表格 */
										$("#departmentTable  tr:not(:first)").html("");
										
										for (var i = 0; i < userList.length; i++) {
											var a = i + 1;
											$("#departmentTable")
													.append(
															"<tr> <td>"
																	+ a
																	+ " </td><td> "
																	+ userList[i].name
																	+ " </td><td>"
																	+ userList[i].duty
																	+ " </td><td class='hidden'>"
																	+ userList[i].userId
																	+ " </td><td><a href='javaScript:void(0)' class='choosePerson'>"
																	+ "选择"
																	+ " </td></tr>");

										}
									},
									error : function() {
										alert("我是失败了");
									}
								});

					}
					
					$("#departmentTable").on("click",".choosePerson", function(){
						var a = $(this).parent().siblings("td:eq(1)").text();
						$("#getPerson3").text(a);
						
						var $userId = $("#user_id").index();		//审查日期
						var c = $(this).parents("tr").children().eq($userId).text();
						$("#getPerson2").val(c);
						
					})

					/* 点击保存按钮，保存确定负责部门的信息 */
					$("#saveDepartB").click(function () {
						if($("#getPerson3").text() == ""){
							alert("请先确定负责人");
						} else {
							$("#submitDepart").trigger("click");
						}
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
					 * 验证projectId是否重复
					 */
					function isRepeatId(form){
						$.ajax({
							type : "post",
							dataType : "json",
							data : {
								"projectId" : $("#projectIdF").val()
							},
							url : "isRepeats.action",
							success : function(isRepeat) {
//								alert(isRepeat);
								if(isRepeat == "可登记"){
									submitForm(form);
								} else {
									alert("项目编号重复，请核对后输入");
								}
							},
						});
					}
					
					function getCurrentDate(){
					    var date = new Date();
					    var year = date.getFullYear();
					    var month = date.getMonth() + 1;
					    var strDate = date.getDate();
					    if (month >= 1 && month <= 9) {
					        month = "0" + month;
					    }
					    if (strDate >= 0 && strDate <= 9) {
					        strDate = "0" + strDate;
					    }
					    var currentdate = year + "-" + month + "-" + strDate;
					    return currentdate;
					}
					
					function submitForm(form){
						 $(form).ajaxSubmit({
		                    	async: false,
								success : function(result){
									alert("保存成功");
//									addNewLine();
									paging();
									$("#resetMe").trigger("click");
									$("#hiddenModel").trigger("click");
									showCurrentUser();
									$("#calendar_register").val(getCurrentDate());
									
								}, error : function(){
									alert("保存失败，请重新输入");
								}                    	
		                    });
					}
					
					/*
					 * 导出
					 **/
					$("#printOut").click(function() {
						window.location.href = "admin/receiveMaterial/printRegister.jsp?projectName="
							+$("#projectNameSearch").val()+"&applicant="+$("#applicantSearch").val()
							+"&domain="+$("#DomainSearch  option:selected").val()
							+"&recordDate="+$("#recordDateSearch  option:selected").val();
					});
				
					/* 输入验证 */
					$(function(){				
						$("#register_form").validate({
						
			                rules: { 
			                	'project.projectName':{required: true,}, //项目名称
			                	'project.projectId':{required: true,},   //项目编号
			                	'project.applicationDate':{required: true,}, //申请日期
			                	'projectRecord.recordDate':{required: true,}, //登记时间  
			                	'project.applicant':{required: true,},     //申请验收单位
			                	'project.projectFunds':{required: true,maxlength:7,number:true,},   //经费
				              	'project.domain':{required: true,},         //所属领域 
			                	'project.contactPerson':{required: true,},  //联系人
			                	'project.telephone':{required: true,minlength:6,maxlength:13},      //联系电话
			                	'projectRecord.recordPerson':{required: true,},  //登记人    	
			                },
			                messages: {
			                   	'project.projectName':{required: '不能为空',}, //项目名称
			                	'project.projectId':{required: '不能为空',},   //项目编号
			                	'project.applicationDate':{required: '不能为空',}, //申请日期
			                	'projectRecord.recordDate':{required: '不能为空',}, //登记时间  
			                	'project.applicant':{required: '不能为空',},     //申请验收单位
			                	'project.projectFunds':{required: '不能为空',maxlength:'最长为7位小数',number:'请输入数字或小数',},   //经费
				              	'project.domain':{required: '不能为空',},         //所属领域 
			                	'project.contactPerson':{required: '不能为空',},  //联系人
			                	'project.telephone':{required: '不能为空',minlength:'号码最短6位',maxlength:'号码最长13位'},      //联系电话
			                	'projectRecord.recordPerson':{required: '不能为空',},  //登记人  
			                },
			                errorClass: "error",
			                success: 'valid',
			                unhighlight: function (element, errorClass, validClass) { //验证通过
			                    $(element).tooltip('destroy').removeClass(errorClass);
			                },
			                errorPlacement: function (label, element) {	                	
			                    $(element).tooltip('destroy'); /*必需*/
			                    $(element).attr('title', $(label).text()).attr("data-placement","bottom").tooltip('show'); 
			                    /* $(element).addClass("validate_error"); */
			                },
			                submitHandler: function (form) {
			                	isRepeatId(form);
			                   /* $(form).ajaxSubmit({
			                    	async: false,
									success : function(result){
										alert("保存成功");
//										addNewLine();
										paging();
										$("#resetMe").trigger("click");
										$("#hiddenModel").trigger("click");
									}, error : function(){
										alert("保存失败，请重新输入");
									}                    	
			                    });*/
			                }
		            	});
					});
					
					
					
				/* 在表格最后一行添加，新登记的数据 */
				function addNewLine(){
					var nums = $('#projectTable tr:last').find('td').eq(0).html();
					var a = nums - (-1);
					
					var _tr = "<tr><td>" + a + "</td>";
					_tr += "<td>" + $("#projectNameF").val() + "</td>";
					_tr += "<td>" + $("#projectIdF").val() + "</td>";
					_tr += "<td>" + $("#applicantF").val() + "</td>";
					_tr += "<td>" + $("#domainF  option:selected").html() + "</td>";
					_tr += "<td>" + $("#calendar_register2").val() + "</td>";
					_tr += "<td>" + $("#contactPersonF").val() + "</td>";
					_tr += "<td>" + $("#telephoneF").val() + "</td>";
					_tr += "<td><a href='#destribution_modal' data-toggle='modal'"
						+"class='operation_icon' data-toggle='tooltip'"
						+"data-placement='bottom' title='编辑'>"
						+"<i class='glyphicon glyphicon-pencil'></i></a></td></tr>";
					
					var $tr = $(_tr);
					var t_body = $("#projectTable");
					$tr.appendTo(t_body);
				}

					
					/* 确定负责部门成功后的操作 */
					var options = {
							async:false,
					        success: function (save) {
					        	alert("保存成功");
					        	$("#closeConfirmDepart").trigger("click");
					        		/* 清空表格 */
									$("#departmentTable  tr:not(:first)").html("");
									$("#getPerson3").text("");
									$("#closeConfirmDepart").trigger("click");
									paging();
					        }
					    };
					 
					        // ajaxForm
					        $("#saveDepart").ajaxForm(options);
					        
					        
					        /*查询得出所有的员工*/
					        $.ajax({
				  				type : "post",
				  				dataType : "json",
				  				url : "getAllUsers.action",
				  				success : function(result){
				  					testJson = $.parseJSON(result);
									json = testJson[0];
									getUserList(json);
									
									showCurrentUser();
				  				}
				  			});
				  			function getUserList(json){
				  				var unit = document.getElementById("unitSele");
					  			var user = document.getElementById("userSele");
					  			//1 遍历json中的所有key
					  			for(var key in json){
					  			//2 key封装到option对象中
					  					var option = document.createElement("option");
					  					option.innerHTML = key;
					  			//3 添加
					  					unit.appendChild(option);
					  				}

					  			//为unit添加onchange事件
					  			unit.onchange=function(){
					  				//0 每次添加市之前,清空市的下拉选
					  					user.length=1;
					  				//1. 获得用户选择的省
					  				var pronvinceKey = this.options[this.selectedIndex].innerHTML;
					  				//2. 根据选择的省去json中取得对应 市数组
					  				var cities = json[pronvinceKey];
					  				//3. 遍历数组中的所有市,封装到option对象中
					  				for(var i=0; i<cities.length; i++){
					  					var option2 = document.createElement("option");
					  					var option = user.appendChild(option2);
					  					option.innerHTML = cities[i].name;
					  					option.value = cities[i].userId;
					  				}
					  				
					  				
					  			};
				  			}
				  			
				  			/*默认显示当前用户*/
				  			function showCurrentUser(){
								var currentUserId = $("#userId").val();
								for(var key in json){
									var array=json[key];
						  			 for(var i=0;i<array.length;i++){
						  				   if(array[i].userId==currentUserId){
							  					 $("#unitSele").val(key);
							  					var user = document.getElementById("userSele");
									  				var pronvinceKey =  $("#unitSele").val();
									  				var cities = json[pronvinceKey];
									  				user.length = 1;
									  				for(var i=0; i<cities.length; i++){
									  					var option2 = document.createElement("option");
									  					var option = user.appendChild(option2);
									  					option.innerHTML = cities[i].name;
									  					option.value = cities[i].userId;
									  				}
									  				$("#userSele").val(currentUserId);
							  				   }
						  			 }
								}
				  			}
					        
				  			/*清空输入框*/
				  			$("#clearButton").click(function(){
				  				$("#projectNameSearch").val("");
				  				$("#applicantSearch").val("");
				  				$("#DomainSearch").val("");
				  				$("#recordDateSearch").val("");
				  			});
				  			
				});