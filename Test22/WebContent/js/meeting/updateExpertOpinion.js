$(document).ready(function() {
	$("#saveVerify").click(function() {


		var num = parseFloat($("#box tr:last").find("td:first").text());
		if (isNaN(num)) {
			num = 0;
		}
		if ($("input[name='projectVerify.verifyId']").val() == "") {
			$("input[name='projectVerify.verifyId']").val("0");
		}


		var fileInputList = document.getElementsByName("fileId");
		var fileIds = "";
		for (var i = 0; i < fileInputList.length; i++) {
			fileIds += (fileInputList[i].value + ",");
		}
		fileIds = fileIds.substring(0, fileIds.length - 1);

		$.ajax({
			type : "post",
			dataType : "json",
			url : "AddVerify.action",
			data : {
				//"fileNum":num,
				"projectVerify.verifyId" : $("input[name='projectVerify.verifyId']").val(),
				"projectId" : $("input[name='projectId']").val(),
				"updateStatus" : $("#updateStatus  option:selected").text(),
				"projectVerify.verifyPerson" : $("input[name='projectVerify.verifyPerson']").val(),
				"projectVerify.verifyDate" : $("input[name='projectVerify.verifyDate']").val(),
				"projectVerify.verifyResult" : $("textarea[name='projectVerify.verifyResult']").val(),
				"projectVerify.verifyPerson" : $("#userSele  option:selected").val(),
				"fileIds" : fileIds
			},
			success : function(status) {
				if (status) {
					alert("保存成功");
					window.location = "/Steap/admin/meeting/ProjectSearch.jsp";
				}
			}
		});
	});

	//删除完善资料
	$("#box").on("click", ".delFile", function() {
		var num = $(this).parent().siblings("td:eq(0)").text();
		alert($("#box tr").eq(num).find("input[name='filId']").val());
		$.ajax({
			url : "delateMaterial.action",
			type : "post",
			dateType : "json",
			data : {
				"fileId" : $("#box tr").eq(num).find("input[name='filId']").val()
			},
			success : function(delateStatus) {
				if (delateStatus) {
					$("#box tr").eq(num).remove();
					alert("删除成功");
				}

			},
			error : function() {
				alert("出错啦");
			}
		});
	})



	//审核人二级联动
	$.ajax({
		type : "post",
		dataType : "json",
		url : "getAllUsers.action",
		success : function(result) {
			testJson = $.parseJSON(result);
			json = testJson[0];

			getUserList(json);


			var str = "";
			//判断 并显示已经创建的会议主持人
			for (var key in json) {

				var array = json[key];

				for (var i = 0; i < array.length; i++) {


					if (array[i].name == $("#verifyPerson").val()) {

						$("#unitSele").val(key);
						var user = document.getElementById("userSele");


						//0 每次添加市之前,清空市的下拉选
						//1. 获得用户选择的省
						var pronvinceKey = $("#unitSele").val();
						//2. 根据选择的省去json中取得对应 市数组
						var cities = json[pronvinceKey];
						//3. 遍历数组中的所有市,封装到option对象中
						for (var i = 0; i < cities.length; i++) {
							var option2 = document.createElement("option");
							var option = user.appendChild(option2);
							option.innerHTML = cities[i].name;
							option.value = cities[i].userId;
						}




						$("#userSele option:selected").text($("#verifyPerson").val());

					}
				}

			}

			setDefaultUser();



		}
	});
	function getUserList(json) {
		var unit = document.getElementById("unitSele");
		var user = document.getElementById("userSele");
		//1 遍历json中的所有key
		for (var key in json) {
			//2 key封装到option对象中
			var option = document.createElement("option");
			option.innerHTML = key;
			option.value = key;
			//3 添加
			unit.appendChild(option);
		}

		//为unit添加onchange事件
		unit.onchange = function() {


			//0 每次添加市之前,清空市的下拉选
			user.length = 1;
			//1. 获得用户选择的省
			var pronvinceKey = this.options[this.selectedIndex].innerHTML;
			//2. 根据选择的省去json中取得对应 市数组
			var cities = json[pronvinceKey];
			//3. 遍历数组中的所有市,封装到option对象中
			for (var i = 0; i < cities.length; i++) {
				var option2 = document.createElement("option");
				var option = user.appendChild(option2);
				option.innerHTML = cities[i].name;
				option.value = cities[i].userId;
			}


		};
	}

	function setDefaultUser() {
		$.ajax({
			url : 'findUserInfoAction.action',
			type : 'post',
			data : {
				'userId' : $("#userId").val()
			},
			dataType : 'json',
			success : function(result) {
				console.log("Finding user info is ok!");
				if (result.success == true) {
					var user = result.user;

					$("#unitSele option").each(function(index, option) {
						if (option.innerHTML == user.unitName) {
							option.selected = true;
						}
					});
					$("#unitSele").trigger('change');
					$("#userSele").find("option[value='" + user.userId + "']").attr('selected', true);
				}
			},
			error : function(result) {
				console.log("Finding user info is error!");
			}
		});
	}
});