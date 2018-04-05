$(document).ready(function() {
	//获取专家领域
	getdomainCon();

	//显示专家信息
	page = 1;
	getPageCount();
	showSpecialists(page);
	
	//点击查询按钮，根据条件显示专家信息 id="selectInfo"
	$("#clearButton").click(function() {
		$("#nameCon").val("");
		$("#domainCon").val("请选择");
		$("#workUnitCon").val("");
		$("#dutyCon").val("");
		$("#titleCon").val("");
	});
	
	//点击查询按钮，根据条件显示专家信息 id="selectInfo"
	$("#searchButton").click(function() {
		page = 1;
		showSpecialists(page);
		var name = $("#nameCon").val();
//		var reg= /^[A-Za-z]*$/;
//		if (reg.test(name)) //判断是否符合正则表达式
//		{
//			$("#page").hide();
//		}else{
//			$("#page").show();
			getPageCount();		
//		}
	});
	
	// 点击添加专家信息，将choose置为1，用于判断是正在进行的操作是添加
	$("#create").click(function(){
		$(":text[name]").val("");
		$("#engageDomain").val("请选择");
		choose = 1;
	});
	
	//批量删除 id="deleteInfo"
	$("#deleteInfo").click(function(){
		var checkedNodes = $(":checkbox:not(#allCheckbox):checked");
		if(checkedNodes.length>0){
			if (window.confirm("您确认要删除吗?")) {
				for(var i=0;i<checkedNodes.length;i++){
					var specialistId = ($(checkedNodes[i]).parent().attr("id"));
					deleteInfos(specialistId);
				}
				alert("删除专家信息成功!");
				page = 1;
				getPageCount();
				showSpecialists(page);
			}
		}else{
			alert("请至少选择一位专家");
		}
	});
	
	 $("#account_add").click(function(){
			var isChoosed =  $(":checkbox:not(#allCheckbox):checked").length;
			if(isChoosed<1){
				alert("选择专家后才能创建账号，请选择");
				$(this).attr("data-target", "");
			}else if(isChoosed>=2){
				alert("只能选中单个专家创建账户");
				$(this).attr("data-target", "");
			}else{
				var specialistId = ($(":checkbox:not(#allCheckbox):checked").parent().attr("id"));
				$("#accountId").val(specialistId);
				$(this).attr("data-target", "#create_account");
			}
		});
	
	 $("#save_account").click(function(){
	    	var s_id = $("#accountId").val();
	    	$.ajax({
				url : "selectSpecAccountById.action",
				type : "post",
				data : {
					"specialistId" : s_id,
				},
				dataType : "json",
				success : function(){
						saveAccount(s_id);
				},
				error:function(){
					alert("该专家已分配账号");
					$(".modal").modal("hide");
					$("input._acc").val(""); 
					$(":checkbox:checked").attr("checked",false);
				}
			});
	    });
	 
	 $("#cancel_save_account").click(function() {
			$("input._acc").val("");
			$(":checkbox:checked").attr("checked",false);
	    });
	//备份专家签名 id="backupSignature"
	$("#backupSignature").click(function(){
		backupSignature();
	});
	
	//批量设置初始密码
	$("#setPassword").click(function(){
		$("#setPassword").attr("data-toggle","").attr("data-target","");
		$("input[name='setPassword']").val("");
	    var checkedNodes = $(":checkbox:not(#allCheckbox):checked");
	    if(checkedNodes.length>0){
	    	$("#setPassword").attr("data-toggle","modal").attr("data-target","#password_info");
	    	isInitial = 1;
	    }else{
			alert("请至少选择一位专家");
		}
	});
	
	//批量重置密码
	$("#resetPassword").click(function(){
		$("#setPassword").attr("data-toggle","").attr("data-target","");
		$("input[name='setPassword']").val("");
	    var checkedNodes = $(":checkbox:not(#allCheckbox):checked");
	    if(checkedNodes.length>0){
	    	$("#resetPassword").attr("data-toggle","modal").attr("data-target","#password_info");
	    	isInitial = 2;
	    }else{
			alert("请至少选择一位专家");
		}
	});
	
	//关闭弹出框
	$("#close").click(function(){
		$(":text[name]").val("");
	});
	
	//关闭弹出框
	$("#closePass").click(function(){
		$("input[name='setPassword']").val("");
	});
	
});

function saveAccount(s_id){	
    $.ajax({
		url : "addAccountForSpec.action",
		type : "post",
		data : 	{
			"accountInfo.specialistId" : $("#accountId").val(),
			"accountInfo.account" : $("#account").val(),
			"accountInfo.password" : $("#key").val()
		},
		dataType : "json",
		success: function(){
			alert("创建成功!");
			$(".modal").modal("hide");
			$("input._acc").val("");
			$(":checkbox:checked").attr("checked",false);
		}, 
		error : function(){
			alert("创建失败!");
		}
	});
}
/**
 * 获取专家的所有领域
 * 显示到下拉列表中
 */
function getdomainCon(){
	$.ajax({
		url : "getdomain.action",
		type : "post",
		success : function(domains){
				$.each(domains, function(i, value) {
				var $option = $("<option/>").text(value);
				$("select[name*='engageDomain']").append($option);
				})
			}
	});
}

function isSetInitialPass(specialistId,password){
	var temp;
	$.ajax({
		url : "isSetInitialPass.action",
		async: false,
		type : "post",
		dataType : "json",
		data : {
			"specialistId":specialistId,
		},
		success:function(result){
			temp = result;
		}
	});
	return temp;
}

function setPass(){
	var checkedNodes = $(":checkbox:not(#allCheckbox):checked");
	var password = $("input[name='setPassword']").val();
	var result;
	var count = 0;
	for(var i=0;i<checkedNodes.length;i++){
		var specialistId = ($(checkedNodes[i]).parent().attr("id"));
		result = isSetInitialPass(specialistId,password);
		if(isInitial == 1){
			if(result){
				count = count+1;
				$(checkedNodes[i]).parent().parent().css('background',"#D6D6D6");
			}else{
				setPassword(specialistId,password);
			}
		}else if(isInitial == 2){
			if(result){
				setPassword(specialistId,password);
			}else{
				$(checkedNodes[i]).parent().parent().css('background',"#D6D6D6");
				count = count+1;
			}
		}
	}
	if(count>0){
		if(isInitial == 1){
			alert(count+"位专家已设置初始密码！");
		}else{
			alert(count+"位专家还未设置初始密码，请先设置初始密码！");
		}
		
	}else{
		alert("密码修改设置成！");
	}
	$(":checkbox:checked").attr("checked",false);
	$("#closePass").trigger("click");
}

/**
 * 在进入界面和点击查询按钮时，
 * 显示专家信息
 */
function showSpecialists(page){
	$.ajax({
		url : "showSpecialist.action",
		type : "post",
		dataType : "json",
		data : {
			"specialistCon.name" : $("#nameCon").val(),  
			"specialistCon.engageDomain" : $("#domainCon").find("option:selected").text(),
			"specialistCon.workUnit" : $("#workUnitCon").val(),
			"specialistCon.duty" : $("#dutyCon").val(),
			"specialistCon.title" : $("#titleCon").val(),
			"specialistCon.currentPage" :page
		},
		success : show
	});
}

/**
 * 查询成功以后，在表格中显示专家信息
 * @param specialistList action传回的专家信息（List）
 */
function show(specialistList) {
	$("#showSpecialist  tr:not(:first)").html("");
	$.each(specialistList, function(i, value) {
		var $checkbox = $("<input/>").attr("type","checkbox");
		var $checkboxTD = $("<td/>").attr("id",value.specialistId).append($checkbox);
		/*var $noTD = $("<td/>").text(i + 1);*/
		var $nameTD = $("<td/>").text(value.name);
		var $sexTD = $("<td/>").text(value.sex).attr("class","hidden");
		var $birthdayTD = $("<td/>").text(value.birthday).attr("class","hidden");
		var $workUnitTD = $("<td/>").text(value.workUnit);
		var $engageDomainTD = $("<td/>").text(value.engageDomain);
		var $dutyTD = $("<td/>").text(value.duty);
		var $titleTD = $("<td/>").text(value.title);
		var $telephoneTD = $("<td/>").text(value.telephone);
		var $emailTD = $("<td/>").text(value.email).attr("class","hidden");
		var $majorTD = $("<td/>").text(value.major).attr("class","hidden");
		
		var href = "admin/evaluation/pastProject.jsp?specialistId="+ value.specialistId;
		//添加单行查看操作，将选中的专家信息复制到弹出框内
		var $selectA = $("<a/>").attr("href",href).attr("title","查看历史评审项目").addClass("operation_icon");
		var $selectI = $("<i/>").attr("class","glyphicon glyphicon-search");
		$selectA.append($selectI);
		
		$selectA.css("cursor","pointer");

		//添加单行修改操作，将选中的专家信息复制到弹出框内
		var $updateA = $("<a/>").attr("href","#experts_info").attr("data-toggle","modal").attr("title","编辑").addClass("operation_icon");
		var $updateI = $("<i/>").attr("class","glyphicon glyphicon-pencil");
		$updateA.append($updateI);
		
		$updateA.css("cursor","pointer");
		$updateA.click(function(){
			infoToInput(this);
			choose = 2;
		});
		//添加单行删除操作
		var $deleteA = $("<a/>").attr("class","operation_icon")
		.attr("data-toggle","tooltip").attr("data-placement","bottom").attr("title","删除");
		var $deleteI = $("<i/>").attr("class","glyphicon glyphicon-trash");
		$deleteA.append($deleteI);
		
		$deleteA.css("cursor","pointer");
		$deleteA.click(function(){
			deleteSpecialist(this);
		});
		
		var $delAccA = $("<a/>").attr("class","operation_icon")
		.attr("data-toggle","tooltip").attr("data-placement","bottom").attr("title","删除账户");
		var $delAccI = $("<i/>").attr("class","glyphicon glyphicon-remove");
		$delAccA.append($delAccI);
		
		$delAccA.css("cursor","pointer");
		$delAccA.click(function(){
			deleteAccount(this);
		});
		var $operateTD = $("<td/>").append($selectA).append("     ").append($updateA).append("    ").append($deleteA).append("    ").append($delAccA);
		
		var $tr = $("<tr/>")
		.append($checkboxTD).append($nameTD)
		.append($sexTD).append($birthdayTD).append($workUnitTD)
		.append($engageDomainTD).append($dutyTD).append($titleTD)
		.append($telephoneTD).append($emailTD).append($majorTD).append($operateTD);

		$("#showSpecialist tbody").append($tr);
		
		
	});
}

function getPageCount(){
	$.ajax({
		url : "searchPageCount.action",
		type : "post",
		dataType : "json",
		data : {
			"specialistCon.name" : $("#nameCon").val(),  
			"specialistCon.engageDomain" : $("#domainCon").find("option:selected").text(),
			"specialistCon.workUnit" : $("#workUnitCon").val(),
			"specialistCon.duty" : $("#dutyCon").val(),
			"specialistCon.title" : $("#titleCon").val()
		},
		success : addPageing
	});
}
function addPageing(pageCount){

	$("#page").myPagination({
		pageCount:pageCount,
		currPage: 1,
//		pageNumber:pageCount,
		ajax: {
	        on: false,
	        onClick: function(page) {
	        	showSpecialists(page);
	        }
	    }
    });
}

function isLibrarySpecialist(){
	var params = $("input[name]").serialize();
	params = params+ "&"+$("#engageDomain").serialize();
	$.ajax({
		url : "isLibrarySpecialist.action",
		type : "post",
		dataType : "json",
		data : params,
		success : addSpecialist,
		error:function(){
			alert($("#name").val()+"已经存在!");
		}
	});
}
/**
 * 将添加专家信息弹出框内的数据保存到数据库，进行ajax请求
 */
function addSpecialist(){
	var params = $("input[name]").serialize();
	params = params+ "&"+$("#engageDomain").serialize();
	$.ajax({
		url : "addSpecialist.action",
		type : "post",
		dataType : "json",
		data : params,
		success : add,
		error:function(){
			alert("添加专家信息失败，请重新尝试!");
		}
	});
}

/**
 * 添加专家信息成功后的回调函数，将弹出框内的专家信息显示到表格的第一行
 * @param result 成功返回专家编号
 */
function add(specialistId) {
	alert("添加专家信息成功");
	page = 1;
	getPageCount();
	showSpecialists(page);
	$("#close").trigger("click");
}

/**
 * 修改专家信息，将专家信息复制到弹出框内
 * @param click 点击的专家信息的修改超链接
 */
function infoToInput(click){
	var a = $(click);
	$("#id").val(a.parent().siblings("td:eq(0)").attr("id"));
	$("#name").val(a.parent().siblings("td:eq(1)").text());
	if (a.parent().siblings("td:eq(2)").text() == "男") {
		$("input[name='specialist.sex'][value=男]").attr("checked", true);
	} else {
		$("input[name='specialist.sex'][value=女]").attr("checked", true);
	}
	$("#birthday").val(a.parent().siblings("td:eq(3)").text());
	$("#workUnit").val(a.parent().siblings("td:eq(4)").text());
	$("#engageDomain").val(a.parent().siblings("td:eq(5)").text());
	$("#duty").val(a.parent().siblings("td:eq(6)").text());
	$("#title").val(a.parent().siblings("td:eq(7)").text());
	$("#telephone").val(a.parent().siblings("td:eq(8)").text());
	$("#email").val(a.parent().siblings("td:eq(9)").text());
	$("#major").val(a.parent().siblings("td:eq(10)").text())
}

/**
 * 将修改的专家信息保存到数据库中，进行ajax请求
 */
function updateSpecialist(){
	var params = $("input[name]").serialize();
	params = params+ "&"+$("#engageDomain").serialize();
	$.ajax({
		url : "updateSpecialist.action",
		type : "post",
		dataType : "json",
		data : params,
		success : update,
		error:function(){
			alert("修改专家信息失败，请重新尝试!");
		}
	});
}

/**
 * 修改专家信息成功后的回调函数
 * 将弹出框内的专家信息替换原来的信息
 */
function update(){
	var id = $("#id").val();
	$("#"+id).siblings("td:eq(0)").text($("#name").val());
	$("#"+id).siblings("td:eq(1)").text($("#sex").val());
	$("#"+id).siblings("td:eq(2)").text($("#birthday").val());
	$("#"+id).siblings("td:eq(3)").text($("#workUnit").val());
	$("#"+id).siblings("td:eq(4)").text($("#engageDomain").val());
	$("#"+id).siblings("td:eq(5)").text($("#duty").val());
	$("#"+id).siblings("td:eq(6)").text($("#title").val());
	$("#"+id).siblings("td:eq(7)").text($("#telephone").val());
	$("#"+id).siblings("td:eq(8)").text($("#email").val());
	$(":text[name]").val("");
	$("#close").trigger("click");
	alert("修改专家信息成功");
}

/**
 * 点击某一行的删除超链接，删除专家信息
 * @param click
 */
function deleteSpecialist(click){
	if (window.confirm("您确认要删除吗?")) {
		var a = $(click);
		var specialistId = a.parent().siblings("td:first").attr("id");
		$.ajax({
			url : "deleteSpecialist.action",
			type : "post",
			dataType : "json",
			data : {
				"specialistId":specialistId
			},
			success : function(){
				alert("删除专家信息成功!");
				a.parent().parent().remove();
			},
			error:function(){
				alert("删除专家信息失败，请重新尝试!");
			}
		});
	}
}

function deleteAccount(click){
	if (window.confirm("您确认要删除当前账户吗?")) {
		var a = $(click);
		var specialistId = a.parent().siblings("td:first").attr("id");
		$.ajax({
			url : "selectSpecAccountById.action",
			type : "post",
			data : {
				"specialistId" : specialistId,
			},
			dataType : "json",
			success : function(){
				alert("该用户未分配账号");
			},
			error:function(){
				$.ajax({
					url : "deleteAccountForSpec.action",
					type : "post",
					dataType : "json",
					data : {
						"specialistId":specialistId
					},
					success : function(){
						alert("删除专家账户成功!");
					},
					error:function(){
						alert("删除专家账号失败，请重新尝试!");
					}
				});
			}
		});
	}
}

/**
 * 批量删除专家信息时调用的删除操作
 * @param specialistId
 */
function deleteInfos(specialistId){
		$.ajax({
			url : "deleteSpecialist.action",
			type : "post",
			dataType : "json",
			data : {
				"specialistId":specialistId
			},
			success : function(){
				$("#"+specialistId).parent().remove();
			},
			error:function(){
				alert("删除专家信息失败，请重新尝试!");
			}
		});
}

/**
 * 备份专家签名，进行ajax请求，将所有的专家签名转储到另一个固定的地方
 */
function backupSignature(){
	$.ajax({
		url : "backupSignature.action",
		type : "post",
		success:function(signatureCount){
			if(signatureCount > 0){
				alert("专家签名备份成功!"+"\n"+"已备份"+signatureCount+"位专家的签名。");				
			}
			if(signatureCount == 0){
				alert("没有专家上传签名!");
			}
		}
	});
}

/**
 * 设置专家密码 
 * @param specialistId 专家编号
 * @param password 密码
 */
function setPassword(specialistId,password){
	alert("修改密码------");
	$.ajax({
		url : "setPassword.action",
		type : "post",
		dataType : "json",
		data : {
			"spepassword.specialistId":specialistId,
			"spepassword.password":password
		},
		error:function(){
			var name = $("#"+specialistId).siblings("td:eq(0)").text();
			alert(name+"：修改密码失败!");
		}
	});
}
