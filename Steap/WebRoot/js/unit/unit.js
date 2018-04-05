$(document).ready(function() {
	
	searchUnitTree();
	defaultSearch();
	
	function defaultSearch () {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchUnitByCondition.action",
			data : {
				unitId :   $("#unit_id").val(),
				unitName : $("#unit_name").val()
			},
			success : showTable
		});
	}
	/**
	 * 请求树信息
	 */
	function searchUnitTree(){
		$.ajax({
			type : "post",
			target : "#treeDemo",
			dataType : "json",
			url : "searchTreeAction2.action",
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

		//添加 树节点的 点击事件；
		var log, className = "dark";
		function onClick(event, treeId, treeNode, clickFlag) {
			clickOnTree(event, treeId, treeNode, clickFlag);
		}
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);

		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");  
		treeObj.expandAll(true);
	}
	
	/**
	 * 点击树节点的同时，将该部门信息对应的部门编号，部门名称，上级部门编号，上级部门名称保存下来
	 */
	function clickOnTree(event, treeId, treeNode, clickFlag){
		//得到该节点的部门编号和部门名字
		document.getElementById("bt_unitId").value = treeNode.unitId;
		document.getElementById("bt_unitName").value = treeNode.unitName;
		/*alert(treeNode.unitId);
		alert(treeNode.unitName);*/
		if (treeNode.unitId == "10") {
			//如果本节点是根节点，那么就不能执行更新和删除操作
			$("#unit_change,#unit_delete").attr("disabled","disabled");
		} else {
			//如果本节点不是根节点，就可以执行更新和删除操作
			$("#unit_change,#unit_delete").removeAttr("disabled");
			//父节点
			var fatherNode=treeNode.getParentNode();
			/*alert(fatherNode.unitId);
			alert(fatherNode.unitName);*/
			//得到父节点的部门编号和部门名称
			document.getElementById("bt_upUnitId").value = fatherNode.unitId;
			document.getElementById("bt_upUnitName").value = fatherNode.unitName;
		}
		searchUnit();
	}

	/**
	 *  点击一下树节点表格输出下级节点的部门信息
	 */
	function searchUnit() {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchUnitByUpId.action",
			data : {
				upUnitId : $("#bt_unitId").val(),
			},
			success : showTable
		});
	}
	
		/**
		 * 点击查询按钮，按条件查询部门信息
		 */
		$("#condition_sub").click(function(){
			defaultSearch();
		});

		/**
		 * 显示表格
		 */
		function showTable(result) {
			var unitList = eval("(" + result + ")");
			// 清空表格  
			$("#unitTable  tr:not(:first)").html("");
			// 在表格中添加数据
			for (var i = 0; i < unitList.length; i++) {
				var index = i + 1;
				$("#unitTable").append(
						"<tr><td>" + index+"</td><td>"
						+ unitList[i].unitId + "</td><td>"
						+ unitList[i].unitName+ "</td><td>"
						+ unitList[i].upUnitId+ "</td><td>"
						+ unitList[i].description+ "</td></tr>"
				);
			}
		}
		
		/**
		 * 实现部门信息的删除 
		 */
		$("#unit_delete").click(function() {
			deleteUnit();
		});

		/**
		 * 点击删除按钮后需要 删除表+删除数据库
		 */
		function deleteUnit(){
			var choose = isChoosed();
			if(!choose){
				alert("选择部门后才能删除");
			}else{
				if(confirm("是否确定删除当前部门？")){

					//找到删除的是第几行
					var index = getRowInTable(); 
					//简单的删除,要删除的表中的部门信息
					$("#unitTable tr").eq(index).remove();
					//删除数据库中的部门信息
					$.ajax({
						type : "post",
						dataType : "json",
						url : "deleteUnitAction.action",
						data : {
							unitId : $("#bt_unitId").val(),
						},
						success : function() {
							alert("删除成功");
							searchUnitTree();
						},
						error:function(){
							alert("请确认该部门是否存在员工！");
						}
					});
				}
			}
		}
		
		/**
		 * 判断是否选中树节点、表中数据
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
		 * 根据部门编号判断树对应部门与该部门对应的信息在表的哪一行
		 */
		function getRowInTable(){
			var index; 
			$("#unitTable tr:gt(0)").each(function(i){
				if($(this).children("td").eq(1).text()==$('#bt_unitId').val()){
					index = i;
				}
			});
			return index = index + 1;
		}
		
		/**
		 *  此处是为了识别 按钮事件是保存还是修改 
		 */
		var isAdd = false;
		var isChange = false;
		/**
		 *  实现点击保存按钮的监听事件 
		 */
		$('#unit_add').click(function() {
			var choose = isChoosed();
			if(!choose){
				alert("选择上级部门后才能添加");
				//隐藏模态框
				$("#unit_add").attr("data-target","");
			}else{
				//alert("我是添加");
				setModalOfAdd();
			}
		});
		
		/**
		 * 设置添加的弹出框 (上级部门编号，上级部门名称，要添加部门编号)
		 */
		function setModalOfAdd(){
			//alert("我是添加"),
			//设置模态框是属于增加还是更新
			isAdd = true;
			isChange = false;
			//弹出模态框
			$("#unit_add").attr("data-target","#add_modal");
			
			//填充上级级部门的值 （即当前点击的树节点,对于添加而言）
			/*var unitName = document.getElementById("tdap_add_name");
			unitName.innerHTML = $('#bt_unitName').val();
			var unitId = document.getElementById("tdap_add_id");
			unitId.innerHTML = $('#bt_unitId').val();*/
			
			/*  Start by yachao 2016/8/11 9:20 */
			var bt_uname = $("#bt_unitName").val();
			$("#tdap_add_name").val(bt_uname);
			
			var bt_uId = $("#bt_unitId").val();
			$("#tdap_add_id").val(bt_uId);
			
			/*  End by yachao 2016/8/11 9:20 */
			
			/*alert($('#bt_unitName').val());
			alert($('#bt_unitId').val());*/
			//请求下一个添加的部门的编号Id
			$.ajax({
				type : "post",
				datatype : "json",
				url : "searchNextUnitId.action",
				data : {
					upUnitId: $('#bt_unitId').val(),
				},
				success : function(nextId) {
					//alert(nextId);
					//得到下一个添加的部门的编号Id
					$("#unit__id").val(nextId);
				}
			});	
			//alert("aaa");
		}
		
		/**
		 *  实现点击修改按钮的时候，弹出框的处理
		 */
		$("#unit_change").click(function() {
			var choose = isChoosed();
			if(choose){
				//从数据库查找数据添加到修改界面中
				setModalOfChange();
			}else{
				alert("选择上级部门后才能修改");
				$("#unit_change").attr("data-target","");//隐藏模态框
			}
		});

		/**
		 * 设置修改的弹出框 (上级部门编号，上级部门名称，要修改的部门的原始信息)
		 */
		function setModalOfChange(){
			isChange = true;
			isAdd = false;
			//弹出模态框
			$("#unit_change").attr("data-target","#department_fix_modal");
			//请求要修改的字典的原始信息
			$.ajax({
				type : "post",
				datatype : "json",
				url : "getUpdateUnit.action",
				data : {
					unitId : $('#bt_unitId').val(),
				},
				success : getInfoForChangeModal
			});
		}
		
		/**
		 * 得到需要修改的部门的原始信息
		 */
		function getInfoForChangeModal(result){
			//填充上级部门的信息
			/*var upUnitId = document.getElementById("xdap_add_id");
			upUnitId.innerHTML = $('#bt_upUnitId').val();
			var upUnitName = document.getElementById("xdap_add_name");
			upUnitName.innerHTML = $('#bt_upUnitName').val();*/
			
			var upUnitName = $("#bt_upUnitName").val();
			$("#xdap_add_name").val(upUnitName);
			var upUnitId = $("#bt_upUnitId").val();
			$("#xdap_add_id").val(upUnitId);
			
			//填充要修改的部门的信息
			$('#unit___id').val(result.unitId);
			$('#unit___name').val(result.unitName);
			$('#unit__description').val(result.description);
			
			/*alert($('#bt_upUnitId').val());
			alert($('#bt_upUnitName').val());*/
			
		}

		/**
		 *  实现保存部门和修改部门 
		 */
		$('#tdapartm_add_save').click(function() {
			if (isAdd) {
				//在表的末尾追加新增的部门信息
				saveAddOfTable();
				//将新增的部门信息保存到数据库中
				saveAddOfDatabase();
			} 
		});
		$('#xdapartm_add_save').click(function() {
			if(isChange){
				//alert("我是修改");
				//将表中对应的那条修改的信息内容进行更新
				saveChangeOfDatabase();
				//将更新的信息保存到数据库中
				saveChangeOfTable();
			}
		});

		/**
		 * 如果是添加的保存的话，在表的末尾追加新增的部门信息
		 */
		function saveAddOfTable(){
			//找到要添加的部门信息在表中的序号
			var index=parseFloat($("#unitTable tr:last").find("td:first").text());
			//追加到表的末尾
			$("#unitTable").append(
					"<tr><td>"+(++index)+"</td><td>"
					+ $('#unit__id').val()+"</td><td>"
					+ $('#unit__name').val()+"</td><td>"
					+ $('#bt_unitId').val()+"</td><td>"
					+ $('#unit_description').val()+"</td></tr>"
			);
		}

		/**
		 * 将新增的部门信息保存到数据库中
		 */
		function saveAddOfDatabase(){
			$.ajax({
				type : "post",
				dataType : "json",
				url : "addUnitAction.action",
				data : {
					unitName : $('#unit__name').val(),
					upUnitId : $('#bt_unitId').val(),
					description : $('#unit_description').val(),
				},
				success : function(addResult) {
					alert("保存成功");
					$("#unit__name").val("");
					$("#unit_description").val("");
					$(".modal").modal("hide");
					$("input[type=reset]").trigger("click");
					searchUnitTree();
				},
				error : function(addResult) {
					alert("保存失败");
					$("#unit__name").val("");
					$("#unit_description").val("");
					$("input[type=reset]").trigger("click");
				}
			});
		}
		
		/**
		 * 将更新的信息保存到数据库中
		 */
		function saveChangeOfDatabase(){
			//alert("aaa");
			$.ajax({
				type : "post",
				dataType : "json",
				url : "updateUnit.action",
				data : {
					"baseUnitInfo.unitId":$('#unit___id').val(),
					"baseUnitInfo.unitName":$('#unit___name').val(),
					"baseUnitInfo.description":$('#unit__description').val(),
				},
				success : function(updateResult) {
					alert("修改成功");
					searchUnitTree();
					$("input[type=reset]").trigger("click");
					$(".modal").modal("hide");
				}
			});
			//alert("aaaa");
		}
		
		/**
		 * 将表中对应的那条修改的信息内容进行更新
		 */
		function saveChangeOfTable(){
			//找到修改的是第几行
			var index = getRowInTable(); 
			$("#unitTable tr").eq(index).find("td").eq(2).text($('#unit___name').val()); 
			$("#unitTable tr").eq(index).find("td").eq(4).text($('#unit__description').val());
		}
})