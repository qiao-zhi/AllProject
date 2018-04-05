$(document).ready(function() {
	
	/**
	 * 显示部门树
	 */
	showTree();
	/**
	 * 得到首页
	 */
	getFirstPageByCondition();	
	/**
	 * 请求树信息
	 */
	function showTree(){
		$.ajax({
			url : "searchUnitTree.action",
			type : "post",
			target : "#treeDemo",
			dataType : "json",
			success : getTree
		});
		
	}
	
	/**
	 * 生成树
	 */
	function getTree(treeList2){
		var treeList3 = eval("(" + treeList2 + ")");
		var setting = {
				data : {
					simpleData : {
						enable : true,
						idKey: "unitId",
						pIdKey: "upUnitId",
						rootPId : "10",
					},
					key : {
						name : "unitName",
					}
				},
				callback : {
					onClick : onClick
				}
		};
		var zNodes = treeList3;

		var log, className = "dark";
		
		//添加 树节点的 点击事件；
		function onClick(event, treeId, treeNode, clickFlag) {
			
			clickOnTree(event, treeId, treeNode, clickFlag);
		}
		//初始化树
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		
		//设置初始节点为展开
		setOpen("10");
	}
	
	/**
	 * 控制节点是否展开
	 */
	function setOpen(unitId){
	
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");  
		var node = treeObj.getNodeByParam("unitId",unitId);
		//仅仅本节点展开，子孙节点不展开
		treeObj.expandNode(node, true, false, true,true);
	}
	
	/**
	 * 给树添加点击事件
	 * 点击树节点的同时，将该用户信息对应的用户编号，用户名称，上级用户编号，上级用户名称保存下来
	 */
	function clickOnTree(event, treeId, treeNode, clickFlag){
		//得到该节点的用户编号和用户名字
		document.getElementById("bt_unitId").value = treeNode.unitId;     //得到上级部门编号
		document.getElementById("bt_unitName").value = treeNode.unitName; //得到上级部门名称

		if (treeNode.unitId == "10") {
			//如果本节点是根节点，那么就不能执行添加操作
			$("#user_add").attr("disabled","disabled");
		} else {
			//如果本节点不是根节点，就可以执行更新和删除操作
			$("#user_add").removeAttr("disabled");
		}
		//点击一下树节点表格输出本节点以及下级节点的用户信息
		searchUserByUnitId();
	}

	/**
	 * 重新加载树 （这一部分待完善）
	 */
	function doReload() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.reAsyncChildNodes(null, "refresh");
	}

	/**
	 * 点击一下树节点，表格输出本部门内部的用户信息
	 */
	function searchUserByUnitId() {
		getFirstPageByUnitId();
	}
	
	function getFirstPageByUnitId(){
		page = 1;
		getPageCountByUnitId();
		showUserByUnitId(page);
	}
	function getPageCountByUnitId(){
		$.ajax({
			url : "getUserCountByCondition.action",
			type : "post",
			dataType : "json",
			data : {
				unitId : $("#bt_unitId").val(),
			},
			success : addPageingByUnitId
		});
	}
	function addPageingByUnitId(totalPage){
		$("#page").myPagination({
			pageCount:totalPage,
			pageNumber:totalPage,
			ajax: {
		        on: false,
		        onClick: function(page) {
		        	showUserByUnitId(page);
		        }
		    }
	    });
	}
	
	function showUserByUnitId(page){
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchUserByUnitId.action",
			data : {
				unitId : $("#bt_unitId").val(),
				currentPage:page
			},
			success : showTable
		});
	}
	
	/**
	 * 点击查询按钮，按条件查询用户信息
	 */
	$("#condition_sub").click(function(){
		getFirstPageByCondition();
	});

	
	function getFirstPageByCondition(){
		page = 1;
		getPageCountByCondition();
		showUserByCondition(page);
	}
	function getPageCountByCondition(){
		$.ajax({
			url : "getUserCountByCondition.action",
			type : "post",
			dataType : "json",
			data : {
				name : $("#user_name_condition").val(),
				duty : $("#user_duty_condition").val()
			},
			success : addPageingByCondition
		});
	}
	function addPageingByCondition(totalPage){
		$("#page").myPagination({
			pageCount:totalPage,
			pageNumber:totalPage,
			ajax: {
		        on: false,
		        onClick: function(page) {
		        	showUserByCondition(page);
		        }
		    }
	    });
	}
	function showUserByCondition(page){
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchUserByCondition.action",
			data : {
				name : $("#user_name_condition").val(),
				duty : $("#user_duty_condition").val(),
				currentPage:page
			},
			success : showTable
		});
	}
	
	/**
	 * 在表格中显示用户信息
	 */
	function showTable(result) {
		var userList = eval("(" + result + ")");
		// 删除表格(除了表头)
		$("#userTable  tr").remove();
		// 在表格中添加数据
		for (var i = 0; i < userList.length; i++) {
			var index = i + 1;
			var roleNames=userList[i].roleNames.replace(/,+/g," & ");   //显示用户分配到的角色
			$("#userTable").append(
					"<tr id='tr_"+index+"'> <td><input type='checkbox' name='allcheckbox' class='beCheck' /></td><td> "
					+ index                 + "</td><td class='hide'>"
					+ userList[i].userId    + "</td><td>"
					+ userList[i].name      + "</td><td class='hide'>"
					+ userList[i].unitId    + "</td><td>"
					+ userList[i].sex	    + "</td><td>"
					+ userList[i].unitName	+ "</td><td>"
					+ userList[i].duty	    + "</td><td>"
					+ userList[i].telephone + "</td><td>"
					+ roleNames             + "</td><td>"
					+ "<a href='javascript:void(0);' onclick='del_account(" + index + ")' class='operation_icon tb_delete del_account' data-placement='bottom' title='删除账户'><i class='glyphicon glyphicon-trash'></i></a>"
					+ "<a href='javascript:void(0);' onclick='alt_tr(" + index + ")' data-toggle='modal' class='operation_icon tb_alter' data-toggle='tooltip' data-toggle='modal' data-placement='bottom' data-target='#user_fix_modal' title='修改'><i class='glyphicon glyphicon-pencil'></i></a>"
					+ "<a href='javascript:void(0);' onclick='role_tr(" + index + ")' data-toggle='modal' class='operation_icon tb_role' data-toggle='tooltip' data-toggle='modal' data-target='#user_roles_manage' data-placement='bottom' title='角色管理'><i class='glyphicon glyphicon-user'></i></a>"
					+ "<a href='javascript:void(0);' onclick='del_tr(" + index + ")' class='operation_icon tb_delete' data-toggle='tooltip' data-placement='bottom' title='删除'><i class='glyphicon glyphicon-remove'></i></a></td></tr>"
					
			);
			
		}
	}
	
	/**
	 * 实现用户信息的批量删除 
	 */
	$("#user_delete").click(function() {

		deleteUsers();

	});

	/**
	 * 点击删除按钮后需要 删除表+删除数据库
	 */
	function deleteUsers(){
		
		//批量删除之前判断是否已经选中用户
		var isChoosed = $("input[name='allcheckbox']:checked").length > 0;
			
		if(!isChoosed){
			
			alert("选择用户后才能删除，请选择");
			
		}else{
			
			//alert("开始删除");
			//得到要删除的用户的编号
			var userIds = getUserIdsChoosed();		//得到选择要删除的用户的编号
			//删除数据库中对应的用户的信息
			deleteUsersOfDatabase(userIds);			//在数据库中删除要删除的用户
		}
	}
	
	/**
	 * 得到要删除的用户的编号（复选框选中的）
	 */
	function getUserIdsChoosed(){
		
		var deleteIds = "";
		
		// 遍历选中的checkbox
		$("input[name='allcheckbox']:checked").each(function() { 
			//得到删除的用户的编号
			deleteIds += $(this).parents("tr").find("td:eq(2)").text()+",";
			
		});
		
		return deleteIds;
	}
	
	
	/**
	 * 批量删除Table中选中的行
	 */
	function deleteUsersOfTable(){
		
		// 遍历选中的checkbox
		$("input[name='allcheckbox']:checked").each(function() { 
			// 获取checkbox所在行的顺序
			index = $(this).parents("tr").index();
			//删除表中选中的一行
			$("#userTable").find("tr:eq("+index+")").remove();
		});
		alterNoOfTable();
	}
	
	/**
	 * 删除数据库中的用户信息
	 */
	function deleteUsersOfDatabase(userIds){
		$.ajax({
			type : "post",
			dataType : "json",
			url : "deleteUserById.action",
			data : {
				deleteIds : userIds,
			},
			success : function() {
				alert("删除成功");
				deleteUsersOfTable();
			},
			error:function(){
				alert("删除失败");
			}
		});
	}
	
	/**
	 * 判断是否选中部门
	 */
	function isChoosed(){
		var choose = $("#bt_unitId").val();
		if(""==choose || choose==null|| "null"==choose){
			return false;
		}else{
			return true;
		}
	}

	/**
	 *  实现点击添加按钮的监听事件 
	 */
	$('#user_add').click(function() {
		var choose = isChoosed();
		if(!choose){
			alert("选择部门后才能添加，请选择");
			$("#user_add").attr("data-target","");  //隐藏模态框
		}else{
			
			isAdd=true;
			isChange=false;		//设置当前是要添加还是修改
			setModalOfAdd();
		}
	});
	
	
	/**
	 * 设置添加的弹出框 (上级用户编号，上级用户名称，要添加的用户编号)
	 */
	function setModalOfAdd(){
		
		//$("#user_add").attr("data-target","#user_add_modal");  //弹出弹出框
		$("#btn_add_reset").trigger("click");			   //将弹出框置空
		//填充上级级用户的值 （即当前点击的树节点,对于添加而言）
		$("#dap_add_name").val($('#bt_unitName').val());
		$("#dap_add_id").val($('#bt_unitId').val());
		//document.getElementById("user_telephone").readOnly=false;   //电话信息可以修改9
	}
	
	/**
	 * 用户是否存在，如果存在的话，新增失败（根据电话信息判断）
	 */
	function existUser(){
		var telephone=$('#user_telephone').val();
//		telephone=telephone.replace(/^\s+|\s+$/g, "");
		telephone = trim(telephone); // 去除手机号中的空格
//		alert("telephone:[" + telephone + "]");
		$.ajax({
			type : "post",
			dataType : "json",
//			url : "searchUserByTelephone",
			url : "ifExistsUserAction.action",
			data : {
				"telephone" : telephone,
			},
			success : function(result) {
				if(!result.exist) {
					saveAddToDatabase(trim($("#user_telephone").val()));
				} else {
					alert("手机号码已经存在，添加失败，请重新添加");
				}
			},
			error:function(){
//				alert("手机号码已经存在，添加失败，请重新添加");
				console.log("Add user info is error!");
			}
		});
		
	}
	
	/**
	 *  实现保存用户和修改用户 
	 */
	$('.submitToDB').click(function() {
		if (isAdd) {
			//alert("我是保存");
			//将新增的用户信息保存到数据库中
			existUser();
		} 
	});
	
	/**
	 * 实现修改用户信息的保存功能
	 */
	$(".updateUserInfoToDB").click(function() {
		if(isChange) {
			console.log("Updating user info is starting!");
			
			saveChangeOfDatabase();
		}
	});
	
	/**
	 * 如果是添加的保存的话，在表的末尾追加新增的用户信息
	 */
	function saveAddToTable(userId){
		//找到要添加的用户信息在表中的序号
		var index=parseFloat($("#userTable tr:last").find("td:eq(1)").text())+1;
		//追加到表的末尾
		$("#userTable").append(
				"<tr id='tr_"+index+"'> <td><input type='checkbox' name='allcheckbox'/></td><td>"
				+ index        	           						+ "</td><td class='hide'>"
				+ userId   										+ "</td><td class='hide'>"
				+ $('#bt_unitId').val()  	  					+ "</td><td>"
				+ $('#user_name').val()    	 					+ "</td><td>"
				+ $(":radio[name='user_sex']:checked").val()	+ "</td><td>"
				+ $('#bt_unitName').val()						+ "</td><td>"
				+ $('#user_duty').val()							+ "</td><td>"
				+ $('#user_telephone').val()  					+ "</td><td>"
				+ "</td><td>"
				+ "<a href='javascript:void(0);' onclick='alt_tr(" + index + ")' data-toggle='modal' class='operation_icon tb_alter' data-toggle='tooltip' data-toggle='modal' data-placement='bottom' data-target='#user_fix_modal' title='修改'><i class='glyphicon glyphicon-pencil'></i></a>"
				+ "<a href='javascript:void(0);' onclick='role_tr(" + index + ")' data-toggle='modal' class='operation_icon tb_role' data-toggle='tooltip' data-toggle='modal' data-target='#user_roles_manage' data-placement='bottom' title='角色管理'><i class='glyphicon glyphicon-user'></i></a>"
				+ "<a href='javascript:void(0);' onclick='del_tr(" + index + ")' class='operation_icon tb_delete' data-toggle='tooltip' data-placement='bottom' title='删除'><i class='glyphicon glyphicon-remove'></i></a></td></tr>"
		);
		return true;
	}

	/**
	 * 将新增的用户信息保存到数据库中
	 */
	function saveAddToDatabase(telephone){
		$.ajax({
			type : "post",
			dataType : "json",
			url : "addUser.action",
			data : {
				"user.unitId" : $('#bt_unitId').val(),
				"user.unitName" : $('#bt_unitName').val(),
				"user.name" : $('#user_name').val(),
				"user.sex" :  $(":radio[name='user_sex']:checked").val(),
				"user.duty" : $('#user_duty').val(),
				"user.telephone" : telephone
			},
			success : saveAddToDbSuccess,
			error : function(userId) {
				alert("保存失败!");
				$("#btn_add_reset").trigger("click");
			}
		});
	}
	
	/**
	 * 新增的用户信息成功的保存到数据库中
	 */
	function saveAddToDbSuccess(userId){
		alert("保存成功");
		var result = saveAddToTable(userId);  //修改页面上的表，追加新添加的用户信息
		
		if(result) {
			$("#btn_add_reset").trigger("click"); 
			$("#user_add_modal").modal("hide");
		}
	}

	/**
	 * 将更新的信息保存到数据库中
	 */
	function saveChangeOfDatabase(){
		var unitId = $('#u_unitId').val();
		var userId =$("#u_id").val();
		var unitName = $('#u_unitName').val();
		var name = $('#u_name').val();
		var sex =  $("input[name='u_sex']:checked").val();
		var duty = $('#u_duty').val();
		var telephone = trim($('#u_telephone').val()); // 去除手机号中的空格
		$.ajax({
			type : "post",
			dataType : "json",
			url : "updateUserInfo.action",
			data : {
				"user.unitId" : unitId,
				"user.userId" : userId,
				"user.unitName" : unitName,
				"user.name" : name,
				"user.sex" :  sex,
				"user.duty" : duty,
				"user.telephone" : telephone
			},
			success : function(updateResult) {
				if(updateResult != 0) {
					alert("修改成功");
					$("#btn_update_reset").trigger("click");
					$("#user_fix_modal").modal("hide");
					//将表中对应的那条修改的信息内容进行更新
					saveChangeOfTable(unitId,userId,unitName,name,sex,duty,telephone);
				}
			},
			error:function(){
				alert("修改失败");
				$("#btn_update_reset").trigger("click");
				$("#user_fix_modal").modal("hide");
			}
		});
	}	
	
	/**
	 * 将表中对应的那条修改的信息内容进行更新
	 */
	function saveChangeOfTable(unitId,userId,unitName,name,sex,duty,telephone){
		//找到修改的是第几行
		var index = alterRow;
		$("#"+index).find("td").eq(2).text(userId);
		$("#"+index).find("td").eq(3).text(name);
		$("#"+index).find("td").eq(4).text(unitId);
		$("#"+index).find("td").eq(5).text(sex);
		$("#"+index).find("td").eq(6).text(unitName);
		$("#"+index).find("td").eq(7).text(duty);
		$("#"+index).find("td").eq(8).text(telephone);
	}
	
	/**
	 * 监听重置密码按钮
	 */
	$("#reset_password").click(function(){
		//批量重置密码之前判断是否已经选中用户
		var isChoosed = $("input[name='allcheckbox']:checked").length>0;
		if(!isChoosed){
			alert("选择用户后才能重置密码，请选择");
		}else{
			$("#user_reset_pasw").modal("show");
		}
	});
	
	$(".savePass").click(function() {
		var userIds = getUserIdsChoosed(); //得到要重置密码的用户的编号
		resetPassword(userIds);			   //重置密码
	});
	
	/**
	 * 重置密码
	 */
	function resetPassword(userIds){
		var password = $("#rePass").val();
//		var password=prompt("请输入新的密码");

		if (password!=null && password != ""){

			resetPasswordInDataBase(userIds,password); //保存重置密码到数据库
			
		}else{
			
			alert("密码不能为空，请输入密码!");
		}
	}
	
	
	/**
	 * 保存重置密码到数据库
	 */
	function resetPasswordInDataBase(userIds,password){
		$.ajax({
			type : "post",
			dataType : "json",
			url : "updateUserPassword.action",
			data : {
				userIds : userIds,
				password: password
			},
			success : function() {
				alert("密码重置成功");
				$("#all").removeAttr("checked");
				// 遍历选中的checkbox
				$("input[name='allcheckbox']:checked").each(function() { 
					//去掉选中的痕迹
					$(this).removeAttr('checked');
				});
				
				$("#user_reset_pasw").modal("hide");
				$("#rePass").val("");
			},
			error:function(){
				alert("密码重置失败");
			}
		});
	}
	
	/* 全选和反选*/
	$(".allchecked").click(function() {
		/* 先去除禁用状态*/
		$("input[type='checkbox'][name='role']").attr("disabled", false);
		
		$("#form_role input:checkbox").each(function(index) {
			$(this).prop("checked", true);
		});
	});
	$(".nochecked").click(function() {
		/* 先去除禁用状态*/
		$("input[type='checkbox'][name='role']").attr("disabled", false);
		
		$("#form_role input:checkbox").each(function(index) {
			this.checked = !this.checked;
		});
	});
	
	/*$("#all").click(function() {
		if($("#all").prop("checked")) {
			console.log("Set all checked!");
			$("input[name='allcheckbox'][type='checkbox']").each(function() {
				$(this).prop("checked", true);
			});			
		} else {
			console.log("Set no checked!");
			$("input[name='allcheckbox'][type='checkbox']").each(function() {
				$(this).prop("checked", false);
			});			
		}
	});*/
	//全选
    $("#all").click(function(){
			if(this.checked){				 //如果当前点击的多选框被选中
				 $('input[type=checkbox][name=allcheckbox]').prop("checked", true );
			}else{								
			     $('input[type=checkbox][name=allcheckbox]').prop("checked", false );
			}
	 });
     //全选状态判断  
    $("#userTable").on("click",".beCheck",function(){
    	console.log("click me~!");
    	//定义一个临时变量，避免重复使用同一个选择器选择页面中的元素，提升程序效率。
		var $tmp=$('[name=allcheckbox]:checkbox');
		//用filter方法筛选出选中的复选框。并直接给CheckedAll赋值。
		$('#all').attr('checked',$tmp.length==$tmp.filter(':checked').length);
    });
    
    /* by heyongqing 2016.8.27 at 16:22*/
//    $("#form_role").on("click","input:checkbox",function(){
//    	console.log("id: " + $(this).val());
//    	var content = $(this).parent("div").find("label").text();
//    	
//    	if(this.checked && (content == "专家" || content == "会议主持人")){
//    		$("input[type='checkbox'][name='role']").each(function(){
//    			if(!this.checked){
//    				$(this).prop("disabled", "disabled");
//    			}
//    		});
//    	} else if(!this.checked && (content == "专家" || content == "会议主持人")){
//    		$("input[type='checkbox'][name='role']").each(function(){
//    				$(this).attr("disabled", false);
//    		});
//    	}
//    				
//    });
    
    $("#account_add").click(function(){
		var isChoosed = $("input[name='allcheckbox']:checked").length;
		if(isChoosed<1){
			alert("选择用户后才能创建账号，请选择");
			$(this).attr("data-target", "");
		}else if(isChoosed>=2){
			alert("只能选中单个用户创建账户");
			$(this).attr("data-target", "");
		}else{
			getId();
			$(this).attr("data-target", "#create_account");
		}
	});


    function getId(){
    	var deleteId=$("input[type='checkbox'][name='allcheckbox']:checked").parents("td").parents("tr").find("td:eq(2)").text();
    	$("#user_id").val(deleteId);
    }
    
    $("#save_account").click(function(){
    	var u_id = $("#user_id").val();
    	$.ajax({
			url : "selectAccountById.action",
			type : "post",
			data : {
				"u_id" : u_id,
			},
			dataType : "json",
			success : function(result){
				if(!result.exist){
					save_account(u_id);
				}else{
					alert("该用户已分配账号");
					$(".modal").modal("hide");
					$("input._acc").val(""); 
					$("input[type='checkbox'][name='allcheckbox']:checked").removeAttr("checked");
				}
				
			}
		});
    });
    
    function save_account(u_id){	
	    $.ajax({
			url : "createAccount.action",
			type : "post",
			data : 	{
				"useracc.u_id" : $("#user_id").val(),
				"useracc.userName" : $("#account").val(),
				"useracc.password" : $("#key").val()
			},
			dataType : "json",
			success: function(result){
				var res = result.insertRows;
				if(res && res == 1){
					alert("创建成功");
				}else if(res == null){
					alert("账号已存在，请重新设置账号");
				}
				$(".modal").modal("hide");
				$("input._acc").val("");
				$("input[type='checkbox'][name='allcheckbox']:checked").removeAttr("checked");
			}, 
			error : function(){
				console.log("账号创建失败");
			}
		});
    }
    
    $("#cancel_save_account, #close_account_view").click(function() {
		$("input._acc").val("");
    	$("input[type='checkbox'][name='allcheckbox']:checked").removeAttr("checked");
    });

    $("#view_account").click(function() {
    	var userIdList = $("input[type='checkbox'][name='allcheckbox']:checked");
    	
    	if (userIdList.length == 0) {
    		alert("请选择一个用户!");
    		return false;
    	} else if (userIdList.length > 1) {
    		alert("账户查看只支持查看单个用户, 请勿多选!");
    		return false;
    	}
    	
    	var userId = userIdList.parent("td").siblings("td:eq(1)").text();
    	var name = userIdList.parent("td").siblings("td:eq(2)").text();
    	
    	$("#u_account_userId").val(userId);
    	$("#u_account_name").val(name);
    	
    	$("#u_password").attr("type", "password");
    	
    	$("#view_account_modal").modal('show');
    	
    	if (userId != '') {
    		$.ajax({
        		url: 'selectAccountById.action',
        		type: 'post',
        		data: {
        			'userId': userId
        		},
        		success: function(result) {
        			console.log("Finding user info is ok!", result.user.account, result.user.password);
        			
        			if (result.success) {
        				var user = result.user;
        				$("#u_account").val(user.account);
        				$("#u_password").val(user.password);
        			}
        		},
        		error: function(result) {
        			console.log("Finding user info is error!");
        		}
        	});
    	}
    });
    
    $("#close_account_view").click(function() {
    	$("#u_account_userId").val("");
    	$("#u_account_name").val("");
    	$("#u_account").val("");
		$("#u_password").val("");
    });
    
    $("#view_account_password").click(function() {
    	var type = $("#u_password").attr('type');
    	if (type == 'password') {
    		$("#u_password").attr("type", "text");
    	} else if(type == 'text') {
    		$("#u_password").attr("type", "password");
    	}
    });
});



