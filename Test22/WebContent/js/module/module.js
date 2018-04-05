$(document).ready(
		function() {

			replaceTree();
			
			// 默认查询，开启只需去掉注释即可
//			defaultSearch();
			
			function defaultSearch() {
				$.ajax({
					type : "post",
					dataType : "json",
					url : "searchModuleByCondition.action",
					data : {
						moduleId : $("#module_id").val(),
						moduleName : $("#module_name").val()
					},
					success : showTable
				});
			}
			/**
			 * 请求树信息
			 */
			function replaceTree(){
				$.ajax({
					type : "post",
					target : "#treeDemo",
					dataType : "json",
					url : "searchTree.action",
					success : getTree
				});
			}

			/**
			 * 生成树
			 */
			function getTree(moduleTree) {
				var setting = {
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
					callback : {
						onClick : onClick
					}
				};
				var zNodes = moduleTree;

				// 添加 树节点的 点击事件；
				var log,className = "dark";
				function onClick(event, treeId, treeNode, clickFlag) {
					clickOnTree(event, treeId, treeNode, clickFlag);
				}
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
				
				openTree("0")
				
			}
			
			function openTree(moduleId) {
				var treeObj = $.fn.zTree.getZTreeObj("treeDemo");  
				var node = treeObj.getNodeByParam("moduleId",moduleId);
				
				treeObj.expandNode(node, true, false, true,true);
			}
			
			/**
			 * 点击树节点的同时，将该菜单信息对应的菜单编号，菜单名称，上级菜单编号，上级菜单名称保存下来
			 */
			function clickOnTree(event, treeId, treeNode, clickFlag){
				//得到该节点的菜单编号和菜单名字
				document.getElementById("bt_moduleId").value = treeNode.moduleId;
				document.getElementById("bt_moduleName").value = treeNode.moduleName;

				$("#module_change,#module_delete").removeAttr("disabled");
				if (treeNode.moduleId == "0") {
					//如果本节点是根节点，那么就不能执行更新和删除操作
					$("#module_change,#module_delete").attr("disabled","disabled");
				} 
					//父节点
					var fatherNode=treeNode.getParentNode();
					/*alert(fatherNode.moduleId);
					alert(fatherNode.moduleName);*/
					//得到父节点的菜单编号和菜单名称
					document.getElementById("bt_upModuleId").value = fatherNode.moduleId;
					document.getElementById("bt_upModuleName").value = fatherNode.moduleName;
				//点击一下树节点表格输出下级节点的信息
				searchModule(treeNode.moduleId);
				$("#currentId").val(treeNode.moduleId);
				$("#currentName").val(treeNode.moduleName);
			}

			/**
			 *  点击一下树节点表格输出下级节点的菜单信息
			 */
			function searchModule(moduleId) {
				$.ajax({
					type : "post",
					dataType : "json",
					url : "searchModuleByModuleId.action",
					data : {
						moduleId : moduleId,
					},
					success : showTable
				});
			}
			
			/**
			 * 点击查询按钮，按条件查询模块信息
			 */
			$("#condition_sub").click(function() {
				// alert("我是查询"),
				defaultSearch();
			});

			/**
			 * 显示表格
			 */
			function showTable(searchResult) {
				var moduleList = eval("(" + searchResult + ")");
				// 清空表格
				$("#moduleTable  tr:not(:first)").html("");
				// 在表格中添加数据
				for (var i = 0; i < moduleList.length; i++) {
					var index = i + 1;
					var inUse;
					if(moduleList[i].inUse==true){
						inUse="启用";
					}else{
						inUse="禁用";
					}
					$("#moduleTable").append(
							"<tr><td>"+"<input type='checkbox' name='allcheckbox'/>"+"</td><td>"
									+ index+ "</td><td>"
									+ moduleList[i].moduleId + "</td><td>"
									+ moduleList[i].moduleName + "</td><td>"
									+ moduleList[i].moduleURL + "</td><td>"
									+ moduleList[i].memo1 + "</td><td class='hidden'>"
									+ moduleList[i].momo2 + "</td><td>"
									+ inUse                +"</td><td class='hidden'>"
									+ moduleList[i].sortNo + "</td><td>"
									+ moduleList[i].menuClass + "</td><td class='hidden'>"
									+ moduleList[i].flag +   "</td><td>"
								  //+ "<a href='#fix_menu_modal' data-toggle='modal' class='operation_editor' data-toggle='#fix_menu_modal' data-placement='bottom' title='编辑'><i class='glyphicon glyphicon-pencil'></i></a>&nbsp;&nbsp;"
									+ "<a href='javaScript:void(0)' class='operation_delete'  title='删除'><i class='glyphicon glyphicon-trash'></i></a>"  
									+"</td></tr>"
					);
				}
			}
			
			/**
			 * 实现菜单信息的删除 
			 */
			$("#module_delete").click(function() {
				deleteModule();
			});

			/**
			 * 点击删除按钮后需要 删除表+删除数据库
			 */
			function deleteModule(){
				var choose = getModuleIdsChoosed();
				if(!choose){
					alert("选择模块后才能删除");
				}else if (window.confirm("您确认要删除吗?")){
					//找到删除的是第几行
					var deleteIds = getModuleIdsChoosed(); 
					
					//简单的删除,要删除的表中的菜单信息
					//删除数据库中的菜单信息
					$.ajax({
						type : "post",
						dataType : "json",
						url : "deleteModule.action",
						data : {
							moduleId : deleteIds,
						},
						success : function() {
							alert("删除成功");
							replaceTree();
							deleteModuleOfTable();
							alterNoOfTable();
						},
						error:function(){
							alert("删除失败");
						}
					});
				}
			}
			
			/**
			 *（删除表中）
			 */
			function deleteModuleOfTable(){
				$("input[name='allcheckbox']:checked").each(function() { 
					// 获取checkbox所在行的顺序
					index = $(this).parents("tr").index()+1;
					//删除表中选中的信息
					$("table#moduleTable").find("tr:eq("+index+")").remove();
				});
			}
			
			/**
			 * 得到要删除的菜单的编号（删除数据库中）
			 */
			function getModuleIdsChoosed(){
				var deleteIds = "";
				// 遍历选中的checkbox
				$("input[name='allcheckbox']:checked").each(function() { 
					//得到删除的菜单的编号
					deleteIds += $(this).parents("tr").find("td:eq(2)").text()+",";
				});
				deleteIds = deleteIds.substring(0, deleteIds.length-1);
				return deleteIds;
			}
			
			/**
			 *修改表显示的序号（注意：如果和复选框在同一列中的话，需要每个前面加上复选框）
			 */
//			function alterNoOfTable() {
//				//删除对应的行后，修改表的序号
//				var len = $("#moduleTable tr").length;
//				for (var i = 1; i < len; i++) {
//					$('#moduleTable tr:eq(' + i + ') td:first').html(
//						"<input type='checkbox' name='allcheckbox'/> " + i);
//				}
//			}

			/**
			 * 判断是否选中树节点、表中数据
			 */
			function isChoosed(){
				var choose = $("#bt_moduleId").val();
				if(""==choose || choose==null|| "null"==choose){
					return false;
				}else{
					return true;
				}
			}
			
			/**
			 * 根据编号判断树对应菜单与该菜单对应的信息在表的哪一行
			 */
			function getRowInTable(){
				var index; 
				$("#moduleTable tr:gt(0)").each(function(i){
					if($(this).children("td").eq(2).text()==$('#bt_moduleId').val()){
						index = i;
					}
				});
				return index = index + 1;
			}
			
			/**
			 *  此处是为了识别 按钮事件是添加还是修改 
			 */
			var isAdd = false;
			var isChange = false;
			
			/**
			 *  实现点击添加按钮的监听事件 
			 */
			$('#module_add').click(function() {
				//alert("我是添加");
				var choose = isChoosed();
				if(!choose){
					alert("选择上级模块后才能添加，请选择");
					//隐藏模态框
					$("#module_add").attr("data-target","");
				}else{
					if($("#bt_moduleId").val()==0){
						setModalOfAdd2();
					}else{
						setModalOfAdd();
					}
				}
			});
			
			/**
			 * 设置添加的弹出框 (上级模块编号，上级模块名称，要添加的模块编号)
			 */
			function setModalOfAdd(){
				//设置模态框是属于 增加 还是 更新
				isAdd = true;
				isChange = false;
				//弹出模态框
				$("#module_add").attr("data-target","#add_menu_modal");
				//填充上级模块的值 （即当前点击的树节点,对于添加而言）
				
				/*document.getElementById("tdap_add_name").innerHTML = $('#bt_moduleName').val();
				document.getElementById("tdap_add_id").innerHTML = $('#bt_moduleId').val();*/
				
				var moduleName = $("#bt_moduleName").val();
				$("#tdap_add_name").val(moduleName);
				var moduleId = $("#bt_moduleId").val();
				$("#tdap_add_id").val(moduleId);
				
				//请求下一个添加模块的编号Id
				$.ajax({
					type : "post",
					dataType : "json",
					url : "searchNextId.action",
					data : {
						moduleId : $("#bt_moduleId").val(),
					},
					success : function(nextId) {
						//alert(nextId);
						$("#module__id").val(nextId);
					},
					error:function(){
						
					}
				});
			}
			
			function setModalOfAdd2(){
				//设置模态框是属于 增加 还是 更新
				isAdd = true;
				isChange = false;
				//弹出模态框
				$("#module_add").attr("data-target","#add_menu_modal");
				//填充上级模块的值 （即当前点击的树节点,对于添加而言）
				/*document.getElementById("tdap_add_name").innerHTML = $('#bt_moduleName').val();
				document.getElementById("tdap_add_id").innerHTML = $('#bt_moduleId').val();*/
				
				var moduleName = $("#bt_moduleName").val();
				$("#tdap_add_name").val(moduleName);
				var moduleId = $("#bt_moduleId").val();
				$("#tdap_add_id").val(moduleId);
				//请求下一个添加模块的编号Id
				$.ajax({
					type : "post",
					dataType : "json",
					url : "searchOneNextId.action",
					success : function(nextId) {
						//alert(nextId);
						$("#module__id").val(nextId);
					},
					error:function(){
						
					}
				});
			}
			
			/**
			 *  实现点击修改按钮的时候，弹出框的处理
			 */
			$("#module_change").click(function() {
				//alert("我是修改");
				var choose = isChoosed();
				$("#currentLine").val("");
				if(choose){
					//从数据库查找数据添加到修改界面中
					setModalOfChange();
				}else{
					alert("选择模块后才能修改，请选择");
					$("#module_change").attr("data-target","");//隐藏模态框
				}
			});

			/**
			 * 设置修改的弹出框 (上级模块编号，上级模块名称，要修改的模块的原始信息)
			 */
			function setModalOfChange(){
				//alert("aaa");
				isChange = true;
				isAdd = false;
				//弹出模态框
				$("#module_change").attr("data-target","#fix_menu_modal");
				//请求要修改模块的原始信息
				$.ajax({
					type : "post",
					dataType : "json",
					url : "getUpdateModule.action",
					data : {
						moduleId : $("#bt_moduleId").val(),
					},
					success : getInfoForChangeModal
				});
				//alert("aaa");
			}
			/**
			 * 得到需要修改的模块的原始信息
			 */
			function getInfoForChangeModal(result){
				
				//alert(result);
				//设置启用和禁用
				if(result.inUse) {
					$(".inUse:first").attr("checked", true);
					$(".inUse:last").attr("checked", false);
				} else {
					$(".inUse:first").attr("checked", false);
					$(".inUse:last").attr("checked", true);
				}
				
				//填充上级菜单的信息
				var upModuleName = $("#bt_upModuleName").val();
				$("#xdap_add_name").val(upModuleName);
				var upModuleId = $("#bt_upModuleId").val();
				$("#xdap_add_id").val(upModuleId);
				
				//填充要修改菜单的信息
				$('#module___id').val(result.moduleId);
				$('#module___name').val(result.moduleName);
				$('#module__URL').val(result.moduleURL);
				$('#module__memo1').val(result.memo1);
				$('#module__memo2').val(result.momo2);
				$('#module__sortNo').val(result.sortNo);
				$('#module__menuClass').val(result.menuClass);
				$('#module__flag').val(result.flag);
			}

			/**
			 *  实现保存部门和修改部门 
			 */
			$('#tdapartm_add_save').click(function() {
				if (isAdd) {
					//将新增的模块信息保存到数据库中
					saveAddOfDatabase();
					
				}
			});
			$('#xdapartm_add_save').click(function() {
				if(isChange){
					//将更新的信息保存到数据库中
					saveChangeOfDatabase();
				}
			});

			/**
			 * 如果是添加的保存的话，在表的末尾追加新增的菜单信息
			 */
			function saveAddOfTable(addResult){
				
				var inUse = getInUseFromModal();
				//找到要添加的字典信息在表中的序号
				var index=parseFloat($("#moduleTable tr:last").find("td").eq(1).text());
				index = index + 1;
				//追加到表的末尾
				$("#moduleTable").append(
						"<tr><td>"+"<input type='checkbox' name='allcheckbox'/>"
						+ "</td><td>"
						+ index+ "</td><td>"
						+ addResult + "</td><td>"
						+ $('#module__name').val() + "</td><td>"
						+ $('#module_URL').val()	+ "</td><td>"
						+ $('#module_memo1').val() + "</td><td class='hidden'>"
						+ $('#module_memo2').val() + "</td><td>"
						+ inUse+ "</td><td class='hidden'>"
						+ $('#module_sortNo').val() + "</td><td>"
						+ $('#module_menuClass').val() + "</td><td class='hidden'>"
						+ $('#module_flag').val() + 
						 "</td><td>"
						+ "<a href='#fix_menu_modal' data-toggle='modal' class='operation_editor' data-toggle='#fix_menu_modal' data-placement='bottom' title='编辑'><i class='glyphicon glyphicon-pencil'></i></a>&nbsp;&nbsp;"
						+ "<a href='javaScript:void(0)' class='operation_delete'  title='删除'><i class='glyphicon glyphicon-trash'></i></a>"  
						+ "</td></tr>"
				);
			}

			/**
			 * 将新增的模块信息保存到数据库中
			 */
			function saveAddOfDatabase(){
				$.ajax({
					type : "post",
					dataType : "json",
					url : "addModule.action",
					data : {
						"module.moduleId":$('#module__id').val(),
						"module.moduleName":$('#module__name').val(),
						"module.moduleURL":$('#module_URL').val(),
						"module.memo1":$('#module_memo1').val(),
						"module.momo2":$('#module_memo2').val(),
						"module.inUse": $(":radio[name='menu_radio']:checked").val(),
						"module.sortNo":$('#module_sortNo').val(),
						"module.menuClass":$('#module_menuClass').val(),
						"module.flag":$('#module_flag').val(),
						"upModuleId":$("#currentId").val()
					},
					success : function(addResult) {
						alert("保存成功");
						
						//在表的末尾追加新增的模块信息
						saveAddOfTable(addResult);
						resetAddModule();
						replaceTree();
						
						$(".modal").modal("hide");
					},
					error : function(addResult) {
						alert("保存失败");
						$("input[type=reset]").trigger("click");
					}
				});
			}
			
			/**
			 * 保存成功后，清空模态框 
			 **/
			function resetAddModule(){
				$('#module__id').val(""),
				$('#module__name').val(""),
				$('#module_URL').val(""),
				$('#module_memo1').val(""),
				$('#module_memo2').val(""),
				$('#module_sortNo').val(""),
				$('#module_menuClass').val(""),
				$('#module_flag').val("")
			}
			
			/**
			 * 将更新的信息保存到数据库中
			 */
			function saveChangeOfDatabase(){
				$.ajax({
					type : "post",
					dataType : "json",
					url : "updateModule.action",
					data : {
						"module.moduleId":$('#module___id').val(),
						"module.moduleName":$('#module___name').val(),
						"module.moduleURL":$('#module__URL').val(),
						"module.memo1":$('#module__memo1').val(),
						"module.momo2":$('#module__memo2').val(),
						"module.inUse": $(":radio[name='menu_radio2']:checked").val(),
						"module.sortNo":$('#module__sortNo').val(),
						"module.menuClass":$('#module__menuClass').val(),
						"module.flag":$('#module__flag').val(),
					},
					success : function(updateResult) {
						alert("修改成功");
						
						//将表中对应的那条修改的信息内容进行更新
						saveChangeOfTable(updateResult);
						
						replaceTree();
						$(".modal").modal("hide");
					}
				});
			}
			
			/**
			 * 将表中对应的那条修改的信息内容进行更新
			 */
			function saveChangeOfTable(updateResult){
				//找到修改的是第几行
				var index = $("#currentLine").val(); 
				//获得弹出框中的禁用启用按钮的值
				var inUse = getInUseFromModal2();
				
//				alert(index);
				
				$("#moduleTable tr").eq(index).find("td").eq(3).text($('#module___name').val());
				$("#moduleTable tr").eq(index).find("td").eq(4).text($('#module__URL').val());
				$("#moduleTable tr").eq(index).find("td").eq(5).text($('#module__memo1').val());
				$("#moduleTable tr").eq(index).find("td").eq(6).text($('#module__memo2').val());
				$("#moduleTable tr").eq(index).find("td").eq(7).text(inUse);
				$("#moduleTable tr").eq(index).find("td").eq(8).text($('#module__sortNo').val());
				$("#moduleTable tr").eq(index).find("td").eq(9).text($('#module__menuClass').val());
				$("#moduleTable tr").eq(index).find("td").eq(10).text($('#module__flag').val());
				
				if(!updateResult && index == ""){
					$("#moduleTable tr:gt(0)").each(function(){
						$(this).children("td").eq(7).text("禁用");
						});
					};
				}
			
			/**
			 * 获得弹出框中的禁用启用按钮的值
			 */
			function getInUseFromModal(){
				var inUse;
				//注意此处必须是字符串的“false”
				if($(":radio[name='menu_radio']:checked").val()=="true"){
					inUse="启用";
				}else{
					inUse="禁用";
				}
				return inUse;
			}
			function getInUseFromModal2(){
				var inUse;
				//注意此处必须是字符串的“false”
				if($(":radio[name='menu_radio2']:checked").val()=="true"){
					inUse="启用";
				}else{
					inUse="禁用";
				}
				return inUse;
			}
			
			/**
			 * 点击表格中的修改按钮进行的操作 
			 **/
			$("#moduleTable").on("click",".operation_editor",function(){
				
				isChange = true;
				
				var ImoduleId = $(this).parent().siblings("td:eq(2)").text();
				var ImuduleName = $(this).parent().siblings("td:eq(3)").text();
				var ImoduleUrl = $(this).parent().siblings("td:eq(4)").text();
				var Imemo1 = $(this).parent().siblings("td:eq(5)").text();
				var Imomo2 = $(this).parent().siblings("td:eq(6)").text();
				var IisUse = $(this).parent().siblings("td:eq(7)").text();
				var IsortNo = $(this).parent().siblings("td:eq(8)").text();
				var ImenuClass = $(this).parent().siblings("td:eq(9)").text();
				var Iflg = $(this).parent().siblings("td:eq(10)").text();
				
				//填充上级菜单的信息
				$("#xdap_add_name").val($("#currentName").val());
				$("#xdap_add_id").val($("#currentId").val());
				
				if(IisUse == "启用"){
					$("#inUse").attr("checked",true);
					$("#unUse").attr("checked",false);
				} else{
					$("#inUse").attr("checked",false);
					$("#unUse").attr("checked",true);
				};
				
				//填充要修改菜单的信息
				$('#module___id').val(ImoduleId);
				$('#module___name').val(ImuduleName);
				$('#module__URL').val(ImoduleUrl);
				$('#module__memo1').val(Imemo1);
				$('#module__memo2').val(Imomo2);
				$('#module__sortNo').val(IsortNo);
				$('#module__menuClass').val(ImenuClass);
				$('#module__flag').val(Iflg);
				
				var currentLine =  $(this).closest('tr').index() - (-1);
				$("#currentLine").val(currentLine);
			});
			
			
			/**
			 * 点击表格中的删除按钮按钮进行的操作，单行删除 
			 **/
			$("#moduleTable").on("click",".operation_delete",function(){
				if(confirm("是否确认删除？")){
					var currentModuleId = $(this).parent().siblings("td:eq(2)").text();
					var $this = this;
					$.ajax({
						type : "post",
						dataType : "json",
						url : "deleteSingleModule.action",
						data : {
							"moduleId" : currentModuleId,
						},
						success : function(deleteSingleResult) {
							alert("删除成功");
							$($this).parent().parent().remove();
							$(".modal").modal("hide");
						}
					});
				
				}
			});
		})