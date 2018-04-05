$(document).ready(function() {
	// 显示角色信息
	showRoles();
	getModuleTree();
	//点击查询按钮，根据条件显示专家信息 id="selectInfo"
	$("#selectInfo").click(function() {
		showRoles();
	});

	// 点击添加角色信息，将choose置为1，用于判断是正在进行的操作是添加
	$("#create").click(function() {
		$(":text[name]").val("");
		choose = 1;
		
	});

	// 点击保存按钮，当choose=1时，是添加操作；当choose=2时，是修改操作
	$("#multiple").click(function() {
		if($("#roleName").val() === ""){
			
			$("#roleNameCheck").show();
		}else{
			if (choose == 1) {
				addRole();
			} else if (choose == 2) {
				updateRole();
			}
		}
	});
	// 键盘弹起验证
	$("#roleName").keyup(function(){
		if($("#roleName").val() === ""){}
		else{
			$("#roleNameCheck").hide();
		}
	})
	
	// 批量删除 id="deleteInfo"
	$("#deleteInfo").click(function() {
		var checkedNodes = $(":checkbox:not(#allCheckbox):checked");
		if(checkedNodes.length>0){
			if (window.confirm("您确认要删除吗?")) {
				for (var i = 0; i < checkedNodes.length; i++) {
					var roleId = ($(checkedNodes[i]).parent().attr("id"));
					deleteInfos(roleId);
				}
			}
		}else{
			alert("请选择至少一位角色!");
		}
	});

	$("closeRoleInfo").click(function(){
		$(":text[name]").val("");
	});
	
	$("#saveModule").click(function() {
		saveModule();
	});
	
	$("#closeRoleManage").click(function(){
		var treeObj = $.fn.zTree.getZTreeObj("moduleTree");
		treeObj.checkAllNodes(false);
	});
	
	$("#roleManage").on('hidden.bs.modal', function () {
		var treeObj = $.fn.zTree.getZTreeObj("moduleTree");
		treeObj.checkAllNodes(false);
	});
});

/**
 * 进行ajax请求，返回角色信息(List)
 */
function showRoles() {
	$.ajax({
		url : "showRole.action",
		type : "post",
		dataType : "json",
		data : {
			"roleId" : $("#nameCon").val(),
		},
		success : show
	});
}

/**
 * showRoles()请求成功时的回调函数
 * 对角色信息进行遍历，显示到table中
 * 将角色Id作为每一行开始的checkbox的id属性
 * @param roleInfos
 */
function show(roleInfos) {
	$("#showRole  tr:not(:first)").html("");
	$.each(roleInfos,function(i, value) {
		var $checkbox = $("<input/>").attr("type", "checkbox");  //复选框
		var $checkboxTD = $("<td/>").attr("id", value.roleId).append($checkbox); //复选框td
		var $noTD = $("<td/>").text(i + 1);
		var $roleNameTD = $("<td/>").text(value.roleName); //角色名称td
		if (value.use) { //角色是否启用，数据库中保存的是boolean值
			use = "启用";
		} else {
			use = "禁用";
		}
		var $isUseTD = $("<td/>").text(use);    //是否启用td
		var $descriptionTD = $("<td/>").text(value.description);  //描述td
		var $remarkTD = $("<td/>").text(value.remark); //备注td
		
		//单行修改操作，采用超链接实现，点击超链接，弹出弹出框，将选中这一行的信息复制到弹出框的文本框中
		var $updateA = $("<a/>").attr("href", "#roleInfo").attr("data-toggle", "modal").attr("title","修改").addClass("operation_icon");
		var $updateI = $("<i/>").attr("class","glyphicon glyphicon-pencil");
		$updateA.append($updateI);
		$updateA.css("cursor", "pointer");
		$updateA.click(function() {
			infoToInput(this);
			choose = 2;
		});
		//单行删除操作
		var $deleteA = $("<a/>").attr("class","operation_icon")
		.attr("data-toggle","tooltip").attr("data-placement","bottom").attr("title","删除");
		var $deleteI = $("<i/>").attr("class","glyphicon glyphicon-trash");
		$deleteA.append($deleteI);
		$deleteA.css("cursor", "pointer");
		$deleteA.click(function() {
			deleteRole(this);
		});
		//单行角色管理操作
		var $moduleA = $("<a/>").attr("href", "#roleManage").attr("data-toggle", "modal").attr("title","权限管理").addClass("operation_icon");
		var $moduleI = $("<i/>").attr("class","glyphicon glyphicon-cog");
		$moduleA.append($moduleI);
		$moduleA.css("cursor", "pointer");
		$moduleA.click(function() {
			// 显示菜单树
			getRoleModule(this);
		});
		var $operateTD = $("<td/>").append($updateA).append($deleteA).append($moduleA); //操作td
		var $tr = $("<tr/>").append($checkboxTD).append($noTD).append($roleNameTD).append($isUseTD).
				append($descriptionTD).append($remarkTD).append($operateTD);               //tr
		$("#showRole tbody").append($tr);   //添加到表格尾部
	});
}

/**
 * 当添加角色时，点击保存按钮，进行ajax请求，将角色信息保存到数据库
 */
function addRole() {
	var params = $("input").serialize();
	$.ajax({
		url : "addRole.action",
		type : "post",
		dataType : "json",
		data : params,
		success : add,
		error : function() {
			alert("添加角色失败，请重新尝试!");
		}
	});
}

/**
 * addRole()的回调函数
 * 添加角色信息成功时，将弹出框内的角色信息显示到表格的第一行
 * @param result
 */
function add(roleId) {
	alert("添加角色成功");
	//获得弹出框内的信息
	var id = roleId;
	var roleName = $("#roleName").val();
	var use = $(":radio:checked").val();
	var description = $("#description").val();
	var remark = $("#remark").val();
	//将获得的信息显示到表格第一行
	var $checkbox = $("<input/>").attr("type", "checkbox");
	var $checkboxTD = $("<td/>").attr("id", id).append($checkbox);
	var $roleNameTD = $("<td/>").text(roleName);
	if (use) {
		use = "启用";
	} else {
		use = "禁用";
	}
	var $isUseTD = $("<td/>").text(use);
	var $descriptionTD = $("<td/>").text(description);
	var $remarkTD = $("<td/>").text(remark);
	//单行修改操作，采用超链接实现，点击超链接，弹出弹出框，将选中这一行的信息复制到弹出框的文本框中
	var $updateA = $("<a/>").attr("href", "#roleInfo").attr("data-toggle", "modal").attr("title","修改").addClass("operation_icon");
	var $updateI = $("<i/>").attr("class","glyphicon glyphicon-pencil");
	$updateA.append($updateI);
	$updateA.css("cursor", "pointer");
	$updateA.click(function() {
		infoToInput(this);
		choose = 2;
	});
	//单行删除操作
	var $deleteA = $("<a/>").attr("class","operation_icon")
	.attr("data-toggle","tooltip").attr("data-placement","bottom").attr("title","删除");
	var $deleteI = $("<i/>").attr("class","glyphicon glyphicon-trash");
	$deleteA.append($deleteI);
	$deleteA.css("cursor", "pointer");
	$deleteA.click(function() {
		deleteRole(this);
	});
	//单行角色管理操作
	var $moduleA = $("<a/>").attr("href", "#roleManage").attr("data-toggle", "modal").attr("title","权限管理").addClass("operation_icon");
	var $moduleI = $("<i/>").attr("class","glyphicon glyphicon-cog");
	$moduleA.append($moduleI);
	$moduleA.css("cursor", "pointer");
	$moduleA.click(function() {
		// 显示菜单树
		getRoleModule(this);
	});
	var $operateTD = $("<td/>").append($updateA).append($deleteA).append($moduleA);
	var $tr = $("<tr/>").append($checkboxTD).append($roleNameTD).append($isUseTD)
	.append($descriptionTD).append($remarkTD).append($operateTD);
	$("#showRole tbody").prepend($tr);
	$(":text[name]").val("");
	$("#closeRoleInfo").trigger("click");
}

/**
 * 当修改信息时，将选中的表格中的信息显示到弹出框中
 * @param click
 */
function infoToInput(click) {
	var a = $(click);
	$("#id").val(a.parent().siblings("td:eq(0)").attr("id"));
	$("#roleName").val(a.parent().siblings("td:eq(1)").text());
	if (a.parent().siblings("td:eq(2)").text() == "启用") {
		$("input[name='role.use'][value=true]").attr("checked", true);
	} else {
		$("input[name='role.use'][value=false]").attr("checked", true);
	}
	$("#description").val(a.parent().siblings("td:eq(3)").text());
	$("#remark").val(a.parent().siblings("td:eq(4)").text());
}

/**
 * 当修改角色信息时，点击保存按钮，进行ajax请求，将修改的角色信息保存到数据库
 */
function updateRole() {
	var params = $("input[name]").serialize();
	$.ajax({
		url : "updateRole.action",
		type : "post",
		dataType : "json",
		data : params,
		success : update,
		error: function(){
			alert("修改角色信息失败,请重新尝试!");
		}
	});
}

/**
 * 修改角色信息成功是的回调函数，将弹出框内修改后的信息显示到表格中
 */
function update() {
	alert("修改角色信息成功!");
	var id = $("#id").val();
	$("#" + id).siblings("td:eq(0)").text($("#roleName").val());
	if ($(":radio:checked").val() == "true") {
		use = "启用";
	}
	if($(":radio:checked").val() == "false"){
		use = "禁用";
	}
	$("#" + id).siblings("td:eq(1)").text(use);
	$("#" + id).siblings("td:eq(2)").text($("#description").val());
	$("#" + id).siblings("td:eq(3)").text($("#remark").val());
	$(":text[name]").val("");
	$("#closeRoleInfo").trigger("click");
}

/**
 * 单行删除操作，删除单个角色信息，进行ajax请求，删除数据库中的角色信息
 * @param click
 */
function deleteRole(click) {
	if (window.confirm("您确认要删除吗?")) {
		var a = $(click);
		var roleId = a.parent().siblings("td:first").attr("id");
		$.ajax({
			url : "deleteInfo.action",
			type : "post",
			dataType : "json",
			data : {
				"roleId" : roleId
			},
			success : function() {
				alert("删除成功!");
				a.parent().parent().remove();
			},
			error : function() {
				alert("删除失败,请重新尝试!");
			}
		});
	}
}

/**
 * 批量删除调用的删除操作，进行ajax请求，删除数据库中的角色信息
 * @param roleId 角色Id
 */
function deleteInfos(roleId) {
	$.ajax({
		url : "deleteInfo.action",
		type : "post",
		dataType : "json",
		data : {
			"roleId" : roleId
		},
		success : function() {
			$("#" + roleId).parent().remove();
		},
		error : function() {
			alert("删除失败，请重新尝试!");
		}
	});
}

/**
 * 点击权限管理时，显示菜单树
 * 进行ajax请求，返回菜单Id，上级菜单Id，菜单名称
 * 使用zTree进行显示
 * @param click
 */
function getModuleTree() {
	$.ajax({
		type : "post",
		dataType : "json",
		url : "getTree.action",
		success : function(moduleTree) {
			var setting = {
				check : {
					enable : true,
					chkStyle: "checkbox",
					chkboxType: { "Y" : "ps", "N" : "ps" }
				},
				data : {
					simpleData : {
						enable : true,
						idKey : "moduleId",
						pIdKey : "upModuleId",
						rootPId : "0",
					},
					key : {
						name : "moduleName",
					}
				},
			};
			var zNodes = moduleTree;
			$.fn.zTree.init($("#moduleTree"), setting, zNodes);
			$.fn.zTree.getZTreeObj("moduleTree").expandAll(true);
			// 根据roleId查询角色拥有的菜单，在菜单上进行勾选
		}
	});
}

/**
 * 查询角色所拥有的菜单，进行ajax请求
 * 将角色拥有的菜单在菜单树上进行勾选
 * @param roleId 角色Id
 * @param moduleTreeObj 菜单树对象
 */
function getRoleModule(click) {
	var a = $(click);
	var roleId = a.parent().siblings("td:first").attr("id");
	var moduleTreeObj = $.fn.zTree.getZTreeObj("moduleTree");
	$("#tempRoleId").val(roleId);
	$.ajax({
		url : "getRoleModule.action",
		type : "post",
		dataType : "json",
		data : {
			"roleId" : roleId
		},
		success : function(moduleIds) {
			var nodes = moduleTreeObj.transformToArray(moduleTreeObj.getNodes());
			for (var i = 0; i < nodes.length; i++) {
				for (var j = 0; j < moduleIds.length; j++) {
					if (nodes[i].moduleId == moduleIds[j]) {
						moduleTreeObj.checkNode(nodes[i], true, false);
					}
				}
			}
		}
	});
}

/**
 * 保存修改后的角色权限信息
 * @param roleId 角色Id
 * @param moduleTreeObj 菜单树
 */
function saveModule() {
	var roleId = $("#tempRoleId").val()
	var moduleTreeObj = $.fn.zTree.getZTreeObj("moduleTree");
	//获得菜单树上已被勾选的节点
	var nodes = moduleTreeObj.getCheckedNodes(true);
	var param = {};
	if(nodes.length>0){
		for (var i = 0; i < nodes.length; i++) {
			param["nodes[" + i + "].roleId"] = roleId;
			param["nodes[" + i + "].moduleId"] = nodes[i].moduleId;
		}
	}else{
		param["roleId"] = roleId;
	}
	//将角色Id和菜单Id作为元素封装到数组里
	//alert(JSON.stringify(param));
	$.ajax({
		url : "saveRoleModule.action",
		type : "post",
		async: false,
		dataType : "json",
		data : param,
		success : function() {
			alert("修改权限成功");
			moduleTreeObj.checkAllNodes(false);
		}
	});
	$("#closeRoleManage").trigger("click");
}