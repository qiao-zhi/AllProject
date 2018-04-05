$(document).ready(function() {
	
	/*进入页面就进行查询*/
	$("#currentPages").val("1");
	paging();
	searchTotalPage();
	var currentUserId = $("#userId").val();
	
	/*条件查询记录*/
	function paging(){
		/* 查询处当前页面中表格的值，并写入 */
		$.ajax({
					type : "post",
					datatype : "json",
					url : "searchProject2A.action",
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
							_tr += "<td class='hidden'>" + result[i].projectFunds + "</td>";
							_tr += "<td>" + result[i].domain + "</td>";
							_tr += "<td>" + result[i].projectRecord.recordDate + "</td>";
							_tr += "<td class='hidden'>" + result[i].projectRecord.recordPerson + "</td>";
							_tr += "<td>" + result[i].projectCharge.destributionDate + "</td>";
							_tr += "<td class='hidden'>" + result[i].projectCharge.chargeUnit + "</td>";
							_tr += "<td class='hidden'>" + result[i].projectCharge.chargePerson + "</td>";
							_tr += "<td class='hidden'>" + result[i].projectReceive.receivePerson + "</td>";
							_tr += "<td>" + result[i].projectReceive.receiveDate + "</td>";
							_tr += "<td class='hidden'>" + result[i].projectReceive.receiveResult + "</td>";
							_tr += "<td class='hidden'>" + result[i].projectCensor.censorPerson + "</td>";
							_tr += "<td>" + result[i].projectCensor.censorDate + "</td>";
							_tr += "<td class='hidden'>" + result[i].projectCensor.censorResult + "</td>";
							_tr += "<td class='hidden'>" + result[i].projectRecord.remark1 + "</td>";
//							_tr += "<td>" + result[i].status + "</td>";
							_tr += "<td title="+ result[i].status +">" + dic[result[i].status] + "</td>";
							_tr += "<td><a href='#check_modal' data-toggle='modal'"
									+"class='operation_icon' data-toggle='tooltip'"
									+"data-placement='bottom' title='查看'>"
									+"<i class='glyphicon glyphicon-search'></i></a></td></tr>";
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
	
		/* 点击保存提交form表单  */
		$("#saveGetMaterial").click(function () {
			$("#submitGetMateria").trigger("click");
		});
		
		$("#saveInvestigate").click(function () {
			$("#submitInvestigate").trigger("click");
		});
		
		/*form表单条件查询 */
//		$("#searchButton").click(function () {
//			$("#currentPages").val("1");
//			$("#submitSearch").trigger("click");
//		});
		
		/* 设置搜索框的值 */
		/* $("#projectNameSearch").val("${session.sProjectName}");
		$("#applicantSearch").val("${session.sApplicant}");
		$("#DomainSearch").val("${session.sDomain}");
		$("#recordDateSearch").val("${session.sRecordDate}"); */
		  
		  
		  $("#buttonThis").click(function () {
			  $("#viewButton").trigger("click");
		  });
		  
		  
		  $("#view_btn").click(function () {
			  $(".viewOption").trigger("click");
		  });
		  
		  
			
		$("#receive_btn").click(function(){
			$("#projectNameD").html($(".light_height").siblings("td:eq(1)").text());
			$("#projectIdD").html($(this).parents("tr").children().eq().text());
		})
		$("#censor_btn").click(function(){
			
		})
		
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
			window.location.href = "admin/receiveMaterial/printGetMaterial.jsp?projectName="
				+$("#projectNameSearch").val()+"&applicant="+$("#applicantSearch").val()
				+"&domain="+$("#DomainSearch  option:selected").val()
				+"&recordDate="+$("#recordDateSearch  option:selected").val()
				+"&chargePerson="+$("#userId").val();
		
		});

		
		/*输入验证*/
		$(function(){				
			
			$("#receive_form").validate({
			
                rules: { 
                	'projectReceive.receivePerson':{required: true,}, //领取验收资料人
                	'projectReceive.receiveDate':{required: true,}, //领取验收资料时间
                	'projectReceive.receiveResult':{required: true,}, //资料领取情况 
      	
                },
                messages: {
                    'projectReceive.receivePerson':{required: '不能为空' ,}, //领取验收资料人
                	'projectReceive.receiveDate':{required: '不能为空',}, //领取验收资料时间
                	'projectReceive.receiveResult':{required: '不能为空',}, //资料领取情况 

                },
                errorClass: "error",
                success: 'valid',
                unhighlight: function (element, errorClass, validClass) { //验证通过
                    $(element).tooltip('destroy').removeClass(errorClass);
                },
                errorPlacement: function (label, element) {
                    $(element).tooltip('destroy'); /*必需*/
                    $(element).attr('title', $(label).text()).attr("data-placement","bottom").tooltip('show'); 
                },
                submitHandler: function (form) {
                	$(form).ajaxSubmit({
                		async:false,
						success : function(result){
							alert("保存成功");
							$("#receive_btn").attr("disabled","disabled");
							$("#censor_btn").attr("disabled","disabled");
							$("#resetMe").trigger("click");
							$("#hiddenModel").trigger("click");
							showCurrentUser1();
							$("#calendar_reivce").val(getCurrentDate());
							paging();
						}, error : function(){
							alert("保存失败，请重新输入");
							$("#receive_btn").attr("disabled","disabled");
							$("#censor_btn").attr("disabled","disabled");
							$("#resetMe").trigger("click");
							$("#hiddenModel").trigger("click");
							paging();
						}	                   	
                    });
                }
        	});
			
			$("#censor_form").validate({
			
                rules: { 
                	'projectCensor.censorPerson':{required: true,}, //审查人
                	'projectCensor.censorDate':{required: true,}, //审查时间
                	'projectCensor.censorResult':{required: true,}, //审查结果 
      	
                },
                messages: {
                    'projectCensor.censorPerson':{required: '不能为空',}, //审查人
                	'projectCensor.censorDate':{required: '不能为空',}, //审查时间
                	'projectCensor.censorResult':{required: '不能为空',}, //审查结果 

                },
                errorClass: "error",
                success: 'valid',
                unhighlight: function (element, errorClass, validClass) { //验证通过
                    $(element).tooltip('destroy').removeClass(errorClass);
                },
                errorPlacement: function (label, element) {
                    $(element).tooltip('destroy'); /*必需*/
                    $(element).attr('title', $(label).text()).attr("data-placement","right").tooltip('show');                
                },
                submitHandler: function (form) {
                	$(form).ajaxSubmit({
                		async:false,
						success : function(result){
							alert("保存成功");
							$("#receive_btn").attr("disabled","disabled");
							$("#censor_btn").attr("disabled","disabled");
							$("#resetMe2").trigger("click");
							$("#hiddenModel2").trigger("click");
							showCurrentUser2();
							$("#calendar2").val(getCurrentDate());
							paging();
						}, error : function(){
							alert("保存失败，请重新输入");
							$("#receive_btn").attr("disabled","disabled");
							$("#censor_btn").attr("disabled","disabled");
							$("#resetMe2").trigger("click");
							$("#hiddenModel2").trigger("click");
							paging();
						}	                    	
                    });
                }
        	});
		});
		
		/*设置当前时间*/
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
		
		 /*查询得出所有的员工  用于二级联动*/
        $.ajax({
				type : "post",
				dataType : "json",
				url : "getAllUsers.action",
				success : function(result){
					testJson = $.parseJSON(result);
				json = testJson[0];
				getUserList(json);
				getUserList2(json);
				showCurrentUser1();
				showCurrentUser2();
				
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
			function getUserList2(json){
				var unit = document.getElementById("unitSele2");
  			var user = document.getElementById("userSele2");
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
			function showCurrentUser1(){
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
			
			/*默认显示当前用户*/
			function showCurrentUser2(){
				for(var key in json){
					var array=json[key];
		  			 for(var i=0;i<array.length;i++){
		  				   if(array[i].userId==currentUserId){
			  					 $("#unitSele2").val(key);
			  					var user = document.getElementById("userSele2");
					  				var pronvinceKey =  $("#unitSele2").val();
					  				var cities = json[pronvinceKey];
					  				user.length = 1;
					  				for(var i=0; i<cities.length; i++){
					  					var option2 = document.createElement("option");
					  					var option = user.appendChild(option2);
					  					option.innerHTML = cities[i].name;
					  					option.value = cities[i].userId;
					  				}
					  				$("#userSele2").val(currentUserId);
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