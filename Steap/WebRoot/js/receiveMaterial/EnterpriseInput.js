$(document).ready(function () {
	
	var tableRows = -1;
	/* 点击删除表格中的专家信息 */
	$("#specialistTable").on("click", ".specialist", function() {
		alert("我被删了");
		var specialistId = $(this).parent().siblings("td:eq(11)").text();
		if(specialistId != ""){
			$.ajax({
				type : "post",
				datatype : "json",
				url : "deleteSpecialistRe.action",
				data : {
					"specialistId" : specialistId
				}, success : function(result){
					if(result == "未删除当前记录"){
						alert(result);
						return false;
					}
					alert("删除成功");
				}
				
			});
		}
		
		
		$(this).parent().parent().remove();
		tableRows = tableRows - 1;
	});
	
	
//	$("#specialist").click(function() {
//		alert("我被删了aaa ");
//	});

	/* 点击保存表格中表格信息 */
	$("#saveSpecial").click(function(){
		$("#submitSpecialist").trigger("click");				
		});
	
	
	function addTable() {
		/* $("#specialistTable").appent(); */
		var name = $("#sName").val();
		var sex = $(
				"input[name='sex']:checked")
				.val();
		var birthday = $("#sBirthday")
				.val();
		var workUnit = $("#sWorkUnit")
				.val();
		var engageDomain = $(
				"#sEngageDomain").val();
		var duty = $("#sDuty").val();
		var title = $("#sTitle").val();
		var telephone = $("#sTelephone")
				.val();
		var email = $("#sEmail").val();
		/* alert(name +sex +birthday +workUnit +engageDomain+ duty +title + telephone+email ); */

		tableRows = tableRows + 1;
		/* 添加表格数据 */
		$("#specialistTable")
				.append(
						"<tr> <td>"
								+ (tableRows - (-1))
								+ "</td><td><input type='hidden' name='specialists["+tableRows+"].name' value='"+name+"'>"
								+ name
								+ "</td><td class='hidden'><input type='hidden' name='specialists["+tableRows+"].sex' value='"+sex+"'>"
								+ sex
								+ "</td><td class='hidden'><input type='hidden' name='specialists["+tableRows+"].birthday' value='"+birthday+"'>"
								+ birthday
								+ "</td><td><input type='hidden' name='specialists["+tableRows+"].workUnit' value='"+workUnit+"'>"
								+ workUnit
								+ "</td><td><input type='hidden' name='specialists["+tableRows+"].engageDomain' value='"+engageDomain+"'>"
								+ engageDomain
								+ "</td><td><input type='hidden' name='specialists["+tableRows+"].duty' value='"+duty+"'>"
								+ duty
								+ "</td><td><input type='hidden' name='specialists["+tableRows+"].title' value='"+title+"'>"
								+ title
								+ "</td><td><input type='hidden' name='specialists["+tableRows+"].telephone' value='"+telephone+"'>"
								+ telephone
								+ "</td><td class='hidden'> <input type='hidden' name='specialists["+tableRows+"].email' value='"+email+"'>"
								+ email
								+ "</td><td><a href='javaScript:void(0)' class='specialist'>"
								+ "删除"
								+ "</a></td><td><a href='javaScript:void(0)' class='addSpecialistLibrary'>录入专家库"
								+ "</a></td></tr>");

		$("#cancelButton").trigger("click");

		/* 删除弹出框中的值 */
//		$("#sName").val("");
//		$("#sBirthday").val("");
//		$("#sWorkUnit").val("");
//		$("#sEngageDomain").val("");
//		$("#sDuty").val("");
//		$("#sTitle").val("");
//		$("#sTelephone").val("");
//		$("#sEmail").val("");
		$("#resetMe").trigger("click");

		/*关闭模态框*/
		$("#closeSpecialist").trigger("click");
	}

	/* 保存所有文字信息 */
	/* $("saveSpecial").click(function() {
		$("#submitAll").trigger("click");
	});

	$("#saveAllInfo").click(function() {
		alert("我是包括审计的");
	}); */

	/* 判断是否需要显示审计内容 */
	var projectFunds = $("#projectFund").text();
	if (projectFunds >= 50) {
		$(".audit_report").show();
		$("#saveMostInfo").hide();
		$("#submitMostInfo").hide();
		$("#cancelMostInfo").hide();
	} else {
		$(".audit_report").empty();
//		$("#clearDiv").empty();
	}

	/* 给保存，提交按钮添加事件，区分这两个按钮  */
	$("#saveMostInfo").click(function() {
		$("#isSubmit").val("save");
		if(isEmpty() == "成功"){
			$("#submitAll").trigger("click");
		}
	});
	$("#submitMostInfo").click(function() {
		$("#isSubmit").val("submit");
		if(isEmpty() == "成功"){
			$("#submitAll").trigger("click");
		}
	});
	$("#saveAllInfo").click(function() {
		$("#isSubmit").val("save");
		if(isEmpty() == "成功"){
			$("#submitAll").trigger("click");
		}
	});
	$("#submitAllInfo").click(function() {
		$("#isSubmit").val("submit");
		if(isEmpty() == "成功"){
			$("#submitAll").trigger("click");
		}
	});
	
	function isEmpty(){
		if(projectFunds > 50){
			if($("#userSele").val()=="" || $("#calendar_send").val()==""){
				alert("请先完善考察信息");
				return "失败";
			}
			if($("#financeUnit").val()=="" || $("#auditingPerson").val()=="" || $("#calendar_logging_time").val()==""){
				alert("请先完善审计信息");
				return "失败";
			}
				return "成功";
		/*没有审计信息*/
		} else {
			if($("#userSele").val()=="" || $("#calendar_send").val()==""){
				alert("请先完善考察信息");
				return "失败";
			}
				return "成功";
		}
	}
	
	$("#cancelMostInfo")
			.click(
					function() {
						window.location = "admin/receiveMaterial/EnterpriseInvestigate.jsp";
					});
	$("#cancelAllInfo")
			.click(
					function() {
						window.location = "admin/receiveMaterial/EnterpriseInvestigate.jsp";
					});
	
	$(function(){
//		$("#enterpriseInvestigate_form").validate({
//			
//            rules: { 
//            	'enterpriseInspect.inspectPerson':{required: true,},//考察人
//            	'enterpriseInspect.inspectPerson.censorPerson':{required: true,}, //审查人    
//            	if($("#projectFund").val() > 50){
//            		'auditInfo.financeUnit':{required: true,},//审计单位
//            		'auditInfo.auditingPerson':{required: true,},//审计人
//            		'auditInfo.auditDate':{required: true,},//审计时间
//            	}
//            },
//            messages: {
//            	'enterpriseInspect.inspectPerson':{required: '不能为空',},//考察人
//                'enterpriseInspect.inspectPerson.censorPerson':{required: 'bukeyikong?',}, //审查人
//                if($("#projectFund").val() > 50){
//                	'auditInfo.financeUnit':{required: '不能为空',},//审计单位
//                	'auditInfo.auditingPerson':{required: '不能为空',},//审计人
//                	'auditInfo.auditDate':{required: '不能为空',},//审计时间
//            	}
//            },
//            errorClass: "validate_error",
//            success: 'valid',
//            unhighlight: function (element, errorClass, validClass) { //验证通过
//                $(element).tooltip('destroy').removeClass(errorClass);
//            },
//            errorPlacement: function (label, element) {
//               $(element).addClass(errorClass);     
//            },
//            submitHandler: function (form) {
//               form.submit();
//            }
//    	})
    	
    	/* add modal */
    	$("#add_modal_form").validate({
		
            rules: { 
            	'sName':{required: true,}, //name
            	'sBirthday':{required: true,}, //sBirthday
            	'sWorkUnit':{required: true,}, //sWorkUnit
            	'sEngageDomain':{required: true,}, //sEngageDomain
            	'sDuty':{required: true,}, //sDuty
            	'sTitle':{required: true,}, //sTitle
            	'sTelephone':{required: true,minlength:6,maxlength:13}, //sTelephone
            	'sEmail':{required: true,}, //sEmail
            },
            messages: {
            	'sName':{required: '不能为空',}, //name
            	'sBirthday':{required: '选择日期',}, //sBirthday
            	'sWorkUnit':{required: '不能为空',}, //sWorkUnit
            	'sEngageDomain':{required: '不能为空',}, //sEngageDomain
            	'sDuty':{required: '不能为空',}, //sDuty
            	'sTitle':{required: '不能为空',}, //sTitle
            	'sTelephone':{required: '不能为空',minlength:'请大于6位',maxlength:'请小于13位'}, //sTelephone
            	'sEmail':{required: '不能为空',}, //sEmail
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
            	addTable();
            }
    	})
    	
    	$("#specialist_form")
					.validate(
							{

								rules : {
									'specialist.name' : {
										required : true,
									}, //	specialist.name
									'specialist.birthday' : {
										required : true,
									}, //	specialist.name
									'specialist.workUnit' : {
										required : true,
									}, //	specialist.workUnit
									'specialist.engageDomain' : {
										required : true,
									}, //	specialist.engageDomain
									'specialist.duty' : {
										required : true,
									}, //	specialist.name
									'specialist.title' : {
										required : true,
									}, //	specialist.title
									'specialist.telephone' : {
										required : true,
										
										minlength : 6,
										maxlength : 13
									}, //	specialist.name
									'specialist.email' : {
										required : true,
										email : true
									}, //specialist.email
								},
								messages : {
									'specialist.name' : {
										required : '不能为空',
									}, //	specialist.name
									'specialist.birthday' : {
										required : '请选择',
									}, //	specialist.name
									'specialist.workUnit' : {
										required : '不能为空',
									}, //	specialist.workUnit
									'specialist.engageDomain' : {
										required : '不能为空',
									}, //	specialist.engageDomain
									'specialist.duty' : {
										required : '不能为空',
									}, //	specialist.name
									'specialist.title' : {
										required : '不能为空',
									}, //	specialist.title
									'specialist.telephone' : {
										required : '不能为空',
										
										minlength : '长度为6-13位',
										maxlength : '长度为6-13位'
									}, //	specialist.name
									'specialist.email' : {
										required : '不能为空',
										email : '请输入正确的email格式'
									}, //specialist.email
								},
								errorClass : "error",
								success : 'valid',
								unhighlight : function(element, errorClass,
										validClass) { //
									$(element).tooltip('destroy').removeClass(
											errorClass);
								},
								errorPlacement : function(label, element) {
									$(element).tooltip('destroy'); /*必需*/
									$(element).attr('title', $(label).text())
											.attr("data-placement", "right")
											.tooltip('show');
								},
								submitHandler : function(form) {
									async:false,
				                	$(form).ajaxSubmit({
										success : function(result){
											alert(result);
											$("#resetMe2").trigger("click");
											$("#hiddenModel2").trigger("click");
										}, error : function(){
											alert("保存失败，请重新输入");
											$("#resetMe2").trigger("click");
											$("#hiddenModel2").trigger("click");
										}	                    	
				                    });
				                }
							})
    	
	})
	
	/**
	 * 获取专家的所有领域
	 * 显示到下拉列表中
	 */
	function getdomainCon(){
		$.ajax({
			url : "getdomain",
			success : function(domains){
					$.each(domains, function(i, value) {
					var $option = $("<option/>").text(value);
					$("select[name*='engageDomain']").append($option);
					})
				}
		});
	}
	
	/*点击加入专家库的按钮之后，进行的操作*/
	$("#specialistTable").on("click",".addSpecialistLibrary",function(){
		var a = $(this).parent().siblings("td:eq(1)").text();
		var b = $(this).parent().siblings("td:eq(2)").text();
		var c = $(this).parent().siblings("td:eq(3)").text();
		var d = $(this).parent().siblings("td:eq(4)").text();
		var e = $(this).parent().siblings("td:eq(5)").text();
		var f = $(this).parent().siblings("td:eq(6)").text();
		var g = $(this).parent().siblings("td:eq(7)").text();
		var h = $(this).parent().siblings("td:eq(8)").text();
		var i = $(this).parent().siblings("td:eq(9)").text();
		
		$("#nameq").val(a);
		if(b == "男"){
			$(".sexq:first").attr("checked", true);
			$(".sexq:last").attr("checked", false);
		} else {
			$(".sexq:last").attr("checked", true);
			$(".sexq:first").attr("checked", false);
		}
//		$("#").val();
		$("#birthdayq").val(c);
		$("#workUnitq").val(d);
		$("#engageDomainq").val(e);
		$("#dutyq").val(f);
		$("#titleq").val(g);
		$("#telephoneq").val(h);
		$("#emailq").val(i);
		
		
		$("#createModel").trigger("click");
	})
	
	 /*查询得出所有的员工*/
    /*$.ajax({
			type : "post",
			dataType : "json",
			url : "getAllUsers.action",
			success : function(result){
				testJson = $.parseJSON(result);
			json = testJson[0];
			getUserList(json);
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
					
					 var array=json[key];
					
					   for(var i=0;i<array.length;i++){
			  				 
			  				
		  				   if(array[i].name==$("#inspectPer").val()){
		  					
		  					 $("#unitSele").val(key);
		  					var user = document.getElementById("userSele");
		  					
		  					$("#userSele option:selected").text($("#inspectPer").val()).val(array[i].userId);
		  					
		  				   }
					   }
					
				}

			//为unit添加onchange事件
			unit.onchange=function changeUnit(){
				//0 每次添加市之前,清空市的下拉选
					user.length=1;
					$("#userSele option:selected").text("--请选择员工--");
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
		}*/
		
		/*点击删除图片*/
		$(".delete-icon").on("click",function(){
			var deletePictureName = $(this).parent().children("a").attr("href");
			var $picture = $(this);
			
			$.ajax({
				type : "post",
				dataType : "json",
				data : {
					"projectId" : $("#EnProjectId").val(),
					"deletePictureName" : deletePictureName,
				},
				url : "deletePicture.action",
				success : function(){
					$picture.parent().remove();
				}, error : function(){
					alert("删除失败，请重新删除");
				}
			})
		});
		
		
		/*查询所有的领域*/
		$.ajax({
				type : "post",
				dataType : "json",
				url : "findDomainL.action",
				success : function(domains){
					var domain1 = document.getElementById("engageDomainq");
					var domain2 = document.getElementById("sEngageDomain");
					for(var i=0; i<domains.length; i++){
						var option = document.createElement("option");
  					option.innerHTML = domains[i];
  					option.value = domains[i];
  					domain1.appendChild(option);
					}
					for(var i=0; i<domains.length; i++){
						var option = document.createElement("option");
  					option.innerHTML = domains[i];
  					option.value = domains[i];
  					domain2.appendChild(option);
					}
					
				}
			});
		
});