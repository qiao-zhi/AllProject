//$(document).ready(function() {
$(function() {
	
	
	//加载完页面之后显示树
	showTree();

	getFirstPageByCondition();	
//	setInterval(showTree, 30000);
//	setInterval(searchDictionary, 30000);
	/**
	 * 显示树
	 */
	function showTree(){
		
		$.ajax({
			type : "post",
			target : "#treeDemo",
			dataType : "json",
			url : "searchTreeAction.action",
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
						enable : true,						//使用简单 Array 格式的数据
						idKey: "dictionaryOptionId",		//id
						pIdKey: "upDictionaryOptionId",		//pid
						rootPId : "1",						//root
					},
					key : {
						name : "dictionaryOptionName",		//name
					}
				},
				
				edit: {
					enable: true,						//设置 zTree 进入编辑状态
					showRemoveBtn: showRemoveBtn,
					showRenameBtn: showRenameBtn,
					//showRemoveBtn: true,
					removeTitle: "删除节点",
					//showRenameBtn: true,
					renameTitle: "编辑节点名称",
				},
				view: {
					addHoverDom: addHoverDom,			//用于当鼠标移动到节点上时，显示用户自定义控件，显示隐藏状态同 zTree 内部的编辑、删除按钮		
					removeHoverDom: removeHoverDom,	    //设置鼠标移到节点上，在后面显示一个按钮
					selectedMulti: false,				// 禁止多点同时选中的功能
					fontCss: setFontCss_ztree, 			//启用字体颜色
				},
				callback : {
					onClick : onClick,
					beforeRemove: beforeRemove,		//用于捕获节点被删除之前的事件回调函数，并且根据返回值确定是否允许删除操作
					beforeEditName: beforeEditName,
					//beforeRename: beforeRename	//用于捕获节点编辑名称结束（Input失去焦点 或 按下 Enter键）之后，更新节点名称数据之前的事件回调函数，并且根据返回值确定是否允许更改名称的操作
				},
				
		};
		var zNodes = treeList3;
		var log, className = "dark";
		
		//添加 树节点的 点击事件；
		function onClick(event, treeId, treeNode, clickFlag) {
			clickOnTree(event, treeId, treeNode, clickFlag);
		}
		//初始化树
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		
		//设置树的根节点是open展开的
		setOpen("1");
		
	}
	
	/**
	 * 根据节点id控制节点是否展开
	 */
	function setOpen(dictionaryOptionId){
	
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");  
		var node = treeObj.getNodeByParam("dictionaryOptionId",dictionaryOptionId);
		//仅仅本节点展开，子孙节点不展开
		treeObj.expandNode(node, true, false, true,true);
	}
	
	/**
	 * 决定删除按钮/图标是否显示，这里的根节点决定不显示
	 */
	function showRemoveBtn(treeId, treeNode) {
		if(treeNode.dictionaryOptionId=="1"){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 决定重命名按钮/图标是否显示，这里的根节点决定不显示
	 */
	
	function showRenameBtn(treeId, treeNode) {
		if(treeNode.dictionaryOptionId=="1"){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 点击树节点的同时，将该字典信息对应的字典编号，字典名称，上级字典编号，上级字典名称保存下来
	 */
	function clickOnTree(event, treeId, treeNode, clickFlag){
		//设置节点为选中
		setChoose(treeNode);
		//点击一下树节点表格输出本节点以及下级节点的字典信息
		searchDictionary();
	}
	
	/**
	 * 设置树节点为选中
	 */
	function setChoose(treeNode){
		//得到该节点的字典编号和字典名字
		document.getElementById("bt_dictionaryId").value = treeNode.dictionaryOptionId;
		document.getElementById("bt_dictionaryName").value = treeNode.dictionaryOptionName;
		
		if(treeNode.isParent) {
			$("#leaf").val(true);
		} else {
			$("#leaf").val(false);
		}
		
		if (treeNode.dictionaryOptionId == "1") {
			//如果本节点是根节点，那么就不能执行更新和删除操作
			//$("#dictionary_change,#dictionary_delete").attr("disabled","disabled");
		} else {
			//如果本节点不是根节点，就可以执行更新和删除操作
			$("#dictionary_change,#dictionary_delete").removeAttr("disabled");
			//父节点
			var fatherNode=treeNode.getParentNode();
			//得到父节点的字典编号和字典名称
			document.getElementById("bt_upDictionaryId").value = fatherNode.dictionaryOptionId;
			document.getElementById("bt_upDictionaryName").value = fatherNode.dictionaryOptionName;
		}
	}
	
	/**
	 * 删除树节点信息
	 */
    function beforeRemove(treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        zTree.selectNode(treeNode);
        if (confirm("确认删除 节点 -- " + treeNode.dictionaryOptionName + " 吗？")) {
            var treeInfo = treeNode.dictionaryOptionId;
            $.ajax({
           		type : "post",
           		dataType : "json",
           		url : "deleteDictionaryAction.action",
				data : {
					dictionaryOptionIds : treeInfo,
				},
				success : function() {
					alert("删除成功");
					//找到删除的是第几行
					var index = getRowInTable(treeNode.dictionaryOptionId); 
					//简单的删除要删除的表中的字典信息
					$("#dictionaryTable tr").eq(index).remove();
					alterNoOfTable();
					//showTree();
					//window.location.reload();
				},
				error : function() {
					alert("删除失败");
					//window.location.reload();
				}
			});
        } else {
        	return false;
        }
    }
    
    /**
     * 添加新的节点
     */
	function addHoverDom(treeId, treeNode) {
		var sObj = $("#" + treeNode.tId + "_span");
		if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
		var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
			+ "' title='add node' onfocus='this.blur();'></span>";
		sObj.after(addStr);
		var btn = $("#addBtn_"+treeNode.tId);
		if (btn) btn.bind("click", function(){
            //if (confirm("确认为 " + treeNode.dictionaryOptionName + " 添加子节点吗？")) {
            	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                zTree.selectNode(treeNode);
                setChoose(treeNode);
                //在树的节点上添加节点  需要完善，暂时使用的是树的刷新
            	//var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				//zTree.addNodes(treeNode, {dictionaryOptionId:(100 + 2), upDictionaryOptionId:treeNode.dictionaryOptionId, dictionaryOptionName:"new node" + 1});
				//return false;
    			document.getElementById("dictionary_add").click();
           // }
        });
    }
	
    /**
     * 设置鼠标移到节点上，在后面显示一个按钮
     */
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_"+treeNode.tId).unbind().remove();
	};
	
	
	/**
	 * 修改节点信息
	 */
	function beforeEditName(treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.selectNode(treeNode);
		setChoose(treeNode);
		//zTree.setting.callback.onClick = clickOnTree(null, treeId, treeNode, 1); //自定义激发点击树节点事件
		//var row = getRowInTable(treeNode.dictionaryOptionId); 
		//alert(row);
		//alert(document.getElementById("dictionaryTable").rows[row]);
		//alterRow=document.getElementById("dictionaryTable").rows[row].id;
		document.getElementById("dictionary_change").click();

	}
	
	/**
	 * 重新加载树 （这一部分待完善）
	 */
	function doReload() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.reAsyncChildNodes(null, "refresh");
		//zTree.refresh();
	}

	/**
	 *  点击一下树节点表格输出本节点以及下级节点的字典信息
	 */
	function searchDictionary() {
		
		getFirstPageByUpId();
	}
	
	function getFirstPageByUpId(){
		page = 1;
		getPageCountByUpDicId();
		showDictionaryByUpId(page);
	}
	
	
	/**
	 * 点击查询按钮，按条件查询字典信息
	 */
	$("#condition_sub").click(function(){
		getFirstPageByCondition();
	});
	
	function getFirstPageByCondition(){
		page = 1;
		getPageCountByCondition();
		showDictionaryByCondition(page);
	}
	
	function getPageCountByCondition(){
		$.ajax({
			url : "searchDicCountByCondition.action",
			type : "post",
			dataType : "json",
			data : {
				dictionaryOptionId :   $("#dic_id").val(),
				dictionaryOptionName : $("#dic_name").val()
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
		        	showDictionaryByCondition(page);
		        }
		    }
	    });
	}
	function showDictionaryByCondition(page){
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchDictionaryByCondition.action",
			data : {
				dictionaryOptionId :   $("#dic_id").val(),
				dictionaryOptionName : $("#dic_name").val(),
				//upDictionaryOptionId : $("#bt_dictionaryId").val(),
				currentPage:page
			},
			success : showTable
		});
	}
	function getPageCountByUpDicId(){
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchDicCountByCondition.action",
			data : {
				upDictionaryOptionId : $("#bt_dictionaryId").val(),
			},
			success : addPageingByUpId
		});
	}
	
	function addPageingByUpId(totalPage){
		$("#page").myPagination({
			pageCount:totalPage,
			pageNumber:totalPage,
			ajax: {
		        on: false,
		        onClick: function(page) {
		        	showDictionaryByUpId(page);
		        }
		    }
	    });
	}
	
	
	function showDictionaryByUpId(page){
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchDictionaryByCondition.action",
			data : {
				upDictionaryOptionId : $("#bt_dictionaryId").val(),
				currentPage:page
			},
			success : showTable
		});
	}
	/**
	 * 显示表格
	 */
	function showTable(result) {
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		var dictionaryList = eval("(" + result + ")");
		
		$("#dictionaryTable  tr:not(:first)").remove();
		
		if(dictionaryList.length != 0) {
			// 在表格中添加数据
			var index = 0;
			for (var i = 0; i < dictionaryList.length; i++) {
				index++;
				if(dictionaryList[i].dictionaryOptionId=="1"){
					index = index -1;
					continue;
				}
				var isUse;
				if(dictionaryList[i].use==true){
					isUse="启用";
				}else{
					isUse="禁用";
				}
				var fatherNode = treeObj.getNodeByParam("dictionaryOptionId",dictionaryList[i].upDictionaryOptionId,null);
				//这部分没有必要了，不会显示根节点的信息
				//var upDictionaryName=""
				//if(fatherNode!=null && fatherNode.dictionaryOptionName!=null){
				//	upDictionaryName=fatherNode.dictionaryOptionName ;
				//}
				$("#dictionaryTable").append(
						"<tr id='tr_"+ index +"'> <td><input type='checkbox' name='allcheckbox' class='beCheck' /></td><td>"
						+ index                                  + "</td><td >"
						+ dictionaryList[i].dictionaryOptionName + "</td><td >"
						+ dictionaryList[i].dictionaryOptionId	 + "</td><td class='hide'>"
						+ dictionaryList[i].upDictionaryOptionId + "</td><td class='hide'>"
						+ fatherNode.dictionaryOptionName		 + "</td><td >"
						+ isUse                                  + "</td><td >"
						+ dictionaryList[i].description	         + "</td><td class='hide'>"
						+ dictionaryList[i].sortNo	             + "</td><td class='hide'>"
						+ dictionaryList[i].flag                 + "</td><td class='hide'>" 
						+ dictionaryList[i].englishName	         + "</td><td >"
						+ dictionaryList[i].dataType             + "</td><td class='hide'>"
						+ dictionaryList[i].remark1	       	     + "</td><td class='hide'>"
						+ dictionaryList[i].remark2              + "</td><td >"
						+ "<a href='javascript:void(0)' data-toggle='modal' onclick='alt_tr("+index+")' class='operation_icon tb_alter' data-toggle='tooltip' data-placement='bottom' data-target='#dictionary_fix_modal' title='修改'><i class='glyphicon glyphicon-pencil'></i></a>    "
						+ "<a href='javascript:void(0)' onclick='del_tr("+index+")' class='operation_icon tb_delete' data-toggle='tooltip' data-placement='bottom' title='删除'><i class='glyphicon glyphicon-remove'></i></a></td></tr>"
				);
			}
		}
	}
	
	/**
	 * 实现字典信息的删除 
	 */
	$("#dictionary_delete").click(function() {
		deleteDictionary();
	});

	/**
	 * 点击删除按钮后需要 删除表+删除数据库
	 */
	function deleteDictionary(){
		
		var isChoosed = $("input[name='allcheckbox']:checked").length > 0;  //批量删除之前判断是否已经选中字典
			
		if(!isChoosed){
			
			alert("选择字典记录后才能删除，请选择!");
			
		}else{
			//alert("开始删除");
			//得到要删除的字典的编号
			var dictionaryIds = getDictionaryIdsChoosed();
			
			if(confirm("确定删除该字典集合吗？")) {
				deleteDictionaryOfDatabase(dictionaryIds);//删除数据库中对应的字典的信息
			}
		}
		
	}


	/**
	 * 得到要删除的字典的编号（复选框选中的）
	 */
	function getDictionaryIdsChoosed(){
		var deleteIds = "";
		// 遍历选中的checkbox
		$("input[name='allcheckbox']:checked").each(function() { 
			//得到删除的字典的编号
			deleteIds += $(this).parents("tr").find("td:eq(3)").text()+",";
			
			console.log("deleteIds: " + deleteIds);
		});
		
		deleteIds = deleteIds.substring(0, deleteIds.length-1);
		
		return deleteIds;
		
	}
	
	/**
	 * 删除数据库中的字典信息
	 */
	function deleteDictionaryOfDatabase(dictionaryIds){
		$.ajax({
			type : "post",
			dataType : "json",
			url : "deleteDictionaryAction.action",
			data : {
				dictionaryOptionIds : dictionaryIds,
			},
			success : function(result) {
				
				if(result) {
					alert("删除成功");
					deleteDictionarysOfTable();
					showTree();
				} else {
					alert("服务内部错误,删除失败!");
				}
			},
			error:function(){
				alert("删除失败");
			}
		});
	}
	
	/**
	 * 批量删除表中选中的行
	 */
	function deleteDictionarysOfTable(){
		// 遍历选中的checkbox
		$("input[name='allcheckbox']:checked").each(function() { 
			// 获取checkbox所在行的顺序
			index = $(this).parents("tr").index()+1;
			//删除表中选中的信息
			$("table#dictionaryTable").find("tr:eq("+index+")").remove();
		});
		alterNoOfTable();
	}
	
	/**
	 * 判断是否选中树节点、表中数据
	 */
	function isChoosed(){
		var choose = $("#bt_dictionaryId").val();
		if(""==choose || choose==null|| "null"==choose){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 根据字典编号判断树对应字典与该字典对应的信息在表的哪一行
	 */
	function getRowInTable(dictionaryOptionId){
		var index; 
		$("#dictionaryTable tr:gt(0)").each(function(i){
			if($(this).children("td").eq(3).text()==dictionaryOptionId){
				index = i;
			}
		});
		return index = index + 1;
	}
	
	/**
	 *  实现点击保存按钮的监听事件 
	 */
	$('#dictionary_add').click(function() {
		var choose = isChoosed();
		if(!choose){
			alert("选择上级字典后才能添加，请选择");
			$("#dictionary_add").attr("data-target","");//隐藏模态框
		}else{
			//设置模态框是属于 增加 还是 更新
			isAdd = true;
			isChange = false;
			setModalOfAdd();
		}
	});
	
	/**
	 * 设置添加的弹出框 (上级字典编号，上级字典名称，要添加的字典编号)
	 */
	function setModalOfAdd(){
		
		$("#dictionary_add").attr("data-target","#dictionary_add_modal");  //弹出弹出框
		$(".addFormReset").trigger("click");						   //清空弹出框的内容
		//填充上级级字典的值 （即当前点击的树节点,对于添加而言）
		$("#dap_add_name").val($('#bt_dictionaryName').val());
		$("#dap_add_id").val($('#bt_dictionaryId').val());
		//请求下一个添加的字典的编号Id
		$.ajax({
			type : "post",
			datatype : "json",
			url : "searchDicNextId.action",
			data : {
				upDictionaryOptionId: $('#bt_dictionaryId').val(),
			},
			success : function(nextId) {
				//得到下一个添加的字典的编号Id
				$('#dictionary_id').val(nextId);
			}
		});	
	}
	
	/**
	 *  实现点击修改按钮的时候，弹出框的处理（修改按钮被隐藏）
	 */
	$("#dictionary_change").click(function() {
		var choose = isChoosed();
		if(choose){
			//从数据库查找数据添加到修改界面中
			setModalOfChange();
		}else{
			alert("选择上级字典后才能添加，请选择");
			$("#dictionary_change").attr("data-target","");//隐藏模态框
		}
	});

	/**
	 * 树形列表中的修改事件 (上级字典编号，上级字典名称，要修改的字典的原始信息)
	 */
	function setModalOfChange(){
		isChange = true;
		isAdd = false;
		//弹出模态框
		$("#dictionary_change").attr("data-target","#dictionary_fix_modal");
		$(".updateFormReset").trigger("click"); // 清空修改弹出框
		//请求要修改的字典的原始信息
		$.ajax({
			type : "post",
			datatype : "json",
			url : "getUpdateDictionary.action",
			data : {
				"systemDictionary.dictionaryOptionId" : $('#bt_dictionaryId').val(),
			},
			success : getInfoForChangeModal
		});
	}
	
	/**
	 * 得到需要修改的字典的原始信息
	 */
	function getInfoForChangeModal(result){
		//设置启用和禁用
		if(result.use){
			$(".dic_isUse:first").attr("checked", true);
		}else{
			$(".dic_isUse:last").attr("checked", true);
		}
		//填充上级字典的信息
		$("#upDicId").val($('#bt_upDictionaryId').val());
		$("#upDicName").val($('#bt_upDictionaryName').val());
		//填充要修改的字典的信息
		$('#dict_id').val(result.dictionaryOptionId);
		$('#dict_name').val(result.dictionaryOptionName); 
		$('#dic_description').val(result.description); 
		$('#dic_sortNo').val(result.sortNo);
		$('#dic_flag').val(result.flag);
		$('#dic_englishName').val(result.englishName);
		$('#dic_dataType').attr("value", result.dataType);
		$('#dic_remark1').val(result.remark1);
		$('#dic_remark2').val(result.remark2);
	}

	$(".submitToDB").click(function() {
		if (isAdd) {
			saveAddOfDatabase();//将新增的字典信息保存到数据库中
			
			$("#bt_dictionaryId").val("");
			$("#bt_dictionaryName").val("");
			$("#bt_upDictionaryId").val("");
			$("#bt_upDictionaryName").val("");
			$("#table_row").val("");
		}
	});
	
	/**
	 * 如果是添加的保存的话，在表的末尾追加新增的字典信息
	 */
	function saveAddOfTable(){
		//找到要添加的字典信息在表中的序号
		var index=parseFloat($("#dictionaryTable tr:last").find("td:eq(1)").text())+1;
		
		if(!$("#leaf").val()) {
			//追加到表的末尾
//			$("#tabody").append(
			var _tr = "<tr id='tr_"+ index +"'><td><input type='checkbox' name='allcheckbox' class='beCheck' /></td>";
				_tr	+= "<td>" + index + "</td>";
				_tr	+= "<td>" + $("#dictionary_name").val() + "</td>";
				_tr	+= "<td>" + $("#dictionary_id").val() + "</td>";
				_tr	+= "<td class='hide'>" + $("#dap_add_id").val() + "</td>"; 
				_tr	+= "<td class='hide'>" + $("#dap_add_name").val() + "</td>";
				_tr	+= "<td>" + $("input[type='radio'][class='dictionary_isUse']:checked").val()+ "</td>";
				_tr	+= "<td>" + $("#dictionary_description").val() + "</td>";
				_tr	+= "<td class='hide'>" + $("#dictionary_sortNo").val() + "</td>";
				_tr	+= "<td class='hide'>" + $("#dictionary_flag").val() + "</td>"; 
				_tr	+= "<td class='hide'>" + $("#dictionary_englishName").val() + "</td>";
				_tr	+= "<td>" + $("#dictionary_dataType").val() + "</td>";
				_tr	+= "<td class='hide'>" + $("#dictionary_remark1").val() + "</td>";
				_tr	+= "<td class='hide'>" + $("#dictionary_remark2").val() + "</td>";
				_tr	+= "<td><a href='javascript:void(0)' data-toggle='modal' onclick='alt_tr("+index+")' class='operation_icon tb_alter' data-toggle='tooltip' data-placement='bottom' data-target='#dictionary_fix_modal' title='修改'><i class='glyphicon glyphicon-pencil'></i></a>    "
					+ "<a href='javascript:void(0)' onclick='del_tr("+index+")' class='operation_icon tb_delete' data-toggle='tooltip' data-placement='bottom' title='删除'><i class='glyphicon glyphicon-remove'></i></a></td></tr>";
				
				$(_tr).appendTo($("#tabody"));
//			);
		}
	} 
	
	/**
	 * 将新增的字典信息保存到数据库中
	 */
	function saveAddOfDatabase(){
		$.ajax({
			type : "post",
			dataType : "json",
			url : "addDictionaryAction.action",
			data : {
				"systemDictionary.dictionaryOptionId":   $('#dictionary_id').val(),
				"systemDictionary.upDictionaryOptionId": $("#dap_add_id").val(),
				"systemDictionary.dictionaryOptionName": $('#dictionary_name').val(),
				"systemDictionary.isUse":                $("input[type='radio'][class='dictionary_isUse']:checked").val()=="启用",
				"systemDictionary.description":          $('#dictionary_description').val(),
				"systemDictionary.sortNo":               $('#dictionary_sortNo').val(),
				"systemDictionary.flag":                 $('#dictionary_flag').val(),
				"systemDictionary.englishName":          $('#dictionary_englishName').val(),
				"systemDictionary.dataType":             $('#dictionary_dataType').val(),
				"systemDictionary.remark1":              $('#dictionary_remark1').val(),
				"systemDictionary.remark2":              $('#dictionary_remark2').val(),
			},
			success : function(addResult) {
				alert("保存成功");
				$(".addFormReset").trigger("click");
				$("#dictionary_add_modal").modal("hide");
				saveAddOfTable();//在表的末尾追加新增的字典信息
				showTree();
			},
			error : function(addResult) {
				alert("保存失败 ");
				$(".addFormReset").trigger("click");
				$("#dictionary_add_modal").modal("hide");
			}
		});
	} 
	
	/**
	 *  实现保存字典和修改字典 
	 */
	$(".updateToDB").click(function() {
		if(isChange) {
			saveChangeOfDatabase();
		}
	});

	/**
	 * 将表中对应的那条修改的信息内容进行更新
	 */
	function saveChangeOfTable(dictionaryOptionId,upDictionaryOptionId,upDictionaryOptionName,isUse,dictionaryOptionName,description,sortNo,flag,englishName,dataType,remark1,remark2){
		//找到修改的是第几行
		var index  = alterRow;
		//var isUse = getIsDicFromModal();
		$("#"+index).find("td").eq(2).text(dictionaryOptionName); 
		$("#"+index).find("td").eq(3).text(dictionaryOptionId); 
		$("#"+index).find("td").eq(4).text(upDictionaryOptionId); 
		$("#"+index).find("td").eq(5).text(upDictionaryOptionName); 
		$("#"+index).find("td").eq(6).text(isUse); 
		$("#"+index).find("td").eq(7).text(description);
		$("#"+index).find("td").eq(8).text(sortNo);
		$("#"+index).find("td").eq(9).text(flag);
		$("#"+index).find("td").eq(10).text(englishName);
		$("#"+index).find("td").eq(11).text(dataType);
		$("#"+index).find("td").eq(12).text(remark1);
		$("#"+index).find("td").eq(13).text(remark2);
		if(isUse=="禁用"){
			var len = $("#dictionaryTable tr").length;
			for (var i = 1; i < len; i++) {
				row = "tr_" + i;
				var condition = "启用"==($("#"+row).find("td").eq(6).text()) && ($("#"+row).find("td").eq(4).text()==dictionaryOptionId||$("#"+row).find("td").eq(3).text()==dictionaryOptionId);
				
				if(condition){
					
					$("#"+row).find("td").eq(6).text(isUse);
				}
			}
		}
	}
	
	/**
	 * 将更新的信息保存到数据库中
	 */
	function saveChangeOfDatabase(){
		var dictionaryOptionId   = $('#dict_id').val();
		var upDictionaryOptionId = $("#upDicId").val();
		var upDictionaryOptionName = $("#upDicName").val();
		var dictionaryOptionName = $('#dict_name').val();
		var isUse 				 = $(":radio[name='dic_isUse'][class='dic_isUse']:checked").val();
		var description 		 = $('#dic_description').val();
		var sortNo 				 = $('#dic_sortNo').val();
		var flag 				 = $('#dic_flag').val();
		var englishName 		 = $('#dic_englishName').val();
		var dataType			 = $('#dic_dataType').val();
		var remark1				 = $('#dic_remark1').val();
		var remark2				 = $('#dic_remark2').val();
		$.ajax({
			type : "post",
			dataType : "json",
			url : "updateDictionaryAction.action",
			data : {
				"systemDictionary.dictionaryOptionId":	    dictionaryOptionId,
				"systemDictionary.upDictionaryOptionId":	upDictionaryOptionId,
				"systemDictionary.dictionaryOptionName": 	dictionaryOptionName,
				"systemDictionary.isUse":  					(isUse=="启用"),
				"systemDictionary.description":  			description,
				"systemDictionary.sortNo": 					sortNo,
				"systemDictionary.flag":					flag,
				"systemDictionary.englishName":				englishName,
				"systemDictionary.dataType":				dataType,
				"systemDictionary.remark1": 				remark1,
				"systemDictionary.remark2":					remark2
			},
			success : function(updateResult) {
				alert("修改成功");
				$(".updateFormReset").trigger("click");
				$("#dictionary_fix_modal").modal("hide");
				saveChangeOfTable(dictionaryOptionId,upDictionaryOptionId,upDictionaryOptionName,isUse,dictionaryOptionName,description,sortNo,flag,englishName,dataType,remark1,remark2);
				showTree();
			}
		});
	}	
	
	$("#autoRefreshTree").click(function() {
		showTree();
	});
	
	//全选
    $("#all").click(function(){
			if(this.checked){				 //如果当前点击的多选框被选中
				 $('input[type=checkbox][name=allcheckbox]').prop("checked", true );
			}else{								
			     $('input[type=checkbox][name=allcheckbox]').prop("checked", false );
			}
	 });
     //全选状态判断  
    $("#tabody").on("click",".beCheck",function(){
    	console.log("click me~!");
    	//定义一个临时变量，避免重复使用同一个选择器选择页面中的元素，提升程序效率。
		var $tmp=$('[name=allcheckbox]:checkbox');
		//用filter方法筛选出选中的复选框。并直接给CheckedAll赋值。
		$('#all').attr('checked',$tmp.length==$tmp.filter(':checked').length);
    })
});