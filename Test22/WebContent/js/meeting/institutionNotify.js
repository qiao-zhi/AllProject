$(document).ready(function() {
	//获得焦点的时候
	$.ajax({
		url : "getInstitutionList.action",
		type : "post",
		dataType : "json",
		data : {
			"institution" : $("#mingcheng").val(),
		},
		success : function(institutionList) {
			$.each(institutionList, function(i, value) {
				var $option = $("<option/>").text(value);
				$("#mingchengSelect").append($option);
			})
		}
	});
	//保存通知到页面
	$("#saveNoticeToFace").click(function() {

		var content = "";
		$("input:checkbox[name='tongxin']:checked").each(function() {
			content += $(this).val() + "/";
		});

		var aTime = $("#calendar_no_name").val();
		if (aTime == "") {
			alert("请先输入考察时间");
			return false;
		}
		if ($("#mingcheng").val() == "") {
			alert("请先输入部门名称");
			return false;
		}
		if ($("#userSele").val() == "a") {
			alert("请先选择通知人");
			return false;
		}
		if ($("#conectPerson").val() == "") {
			alert("请先输入企业联系人");
			return false;
		}
		if ($("#result").val() == "") {
			alert("请先输入通知结果");
			return false;
		}
		if (content == "") {
			alert("请先选择通知方式");
			return false;
		}

		//		var content = "";
		//		var obj = document.getElementsByName("tongxin");
		//		for (var i = 0; i < obj.length; i++) {
		//			if (obj[i].checked) {
		//				content = obj[i].value;
		//				continue;
		//			}
		//		}


		content = content.substr(0, content.length - 1);

		var num = parseFloat($("#person tr:last").find(
			"td:first").text());
		if (isNaN(num)) {
			num = 0;
		}

		$("#person").append(
			"<tr> " + "<td>" + (num + 1) + "</td>"

			+ "<td>"
			+ $("#mingcheng").val()
			+ "<input type='hidden' name='info' value='" + "" + ","
			+ $("#mingcheng").val() + ","

			+ $("#userSele  option:selected").val() + "," +
			$("#conectPerson").val() + "," +
			$("#calendar_no_name").val() + "," +
			content + "," +
			$("#result").val() +

			"'/>"
			+ " </td>"
			+ "<td>" + $("#userSele  option:selected").text()
			+ " </td>"
			+ "<td>"
			+ $("#conectPerson").val()

			+ "</td>"

			+ "<td>"
			+ $("#calendar_no_name").val()
			+ " </td>"
			+ "<td>"
			+ content
			+ " </td>"
			+ "<td>"
			+ $("#result").val()
			+ "</td>"

			+ "<td><a href='javaScript:void(0)' class='deleteNotifyPage'  title='删除该条记录'><i class='glyphicon glyphicon-trash'></i></a>"
			+ "</td>" +

			//						+ "<td>"
			//						/*+ "<a href='javaScript:void(0)'  class='seeNotic' data-toggle='modal'  data-target='#chakan'>查看</a>"*/
			//						+"<a href='#' class='seeNotice' class='operation_icon' data-toggle='modal' data-target='#chakan' data-placement='bottom' title='查看'><i class='glyphicon glyphicon-search'></i></a>"
			//						+ " </td>" +

			"</tr>"

		);

		$("#mingcheng").val("");
		//$("#userSele").text();	
		$("#conectPerson").val("");
		$("#notifier").empty();
		$("#result").val("");
		$("#calendar_no_name").val("");


	});


	// 未保存的通知相关人员 信息删除
	$("#person").on("click", ".deleteNotifyPage", function() {
		$(this).parent().parent().remove();
	});

	// 已经保存的通知相关人员信息删除
	$(".deleteNotifydata").click(function() {
		var $touched = $(this);
		var deleteNotifyId = $touched.parent().siblings("td:eq(1)").text();

		$.ajax({
			url : "deleteNotify.action",
			type : "post",
			dataType : "json",
			data : {
				"deleteNotifyId" : deleteNotifyId,
			},
			success : function() {
				$touched.parent().parent().remove();
				alert("删除成功");
			}
		});

	});


	//添加模态框中的取消
	$("#cancel").click(function() {
		$("#mingcheng").val("");
		$("#notifier").empty();
		$("#conectPerson").val("");
		$("#result").val("");
		$("#calendar_no_name").val("");


	});

	//查看通知信息
	$("#person").on("click", ".seeNotice", function() {




		$("#oneNotice  tr:not(:first)").html("");

		$("#oneNotice").append(

			"<tr> "
			+ "<td>"
			+ $(this).parent().siblings("td:eq(1)")
				.text()
			+ "</td>"
			+ "<td>"
			+ $(this).parent().siblings("td:eq(2)")
				.text()
			+ " </td>"
			+ "<td>"
			+ $(this).parent().siblings("td:eq(3)")
				.text()
			+ "</td>"
			+ "<td>"
			+ $(this).parent().siblings("td:eq(4)")
				.text() + "</td>" +
			"<td>" + $(this).parent().siblings("td:eq(5)")
				.text() + "</td>"
			+ "</tr>");



	})
	// 将前台的对象封装成数组传到后台

	$("#bc").click(
		function() {


			var info = "";
			$("[name='info']").each(function() {
				info += $(this).val().replace(/(^s*)|(s*$)/g, "") + ",";
			});


			// 传递数据到后台
			$.ajax({
				type : "post",
				dataType : "json",
				data : {
					"meetingId" : $("#metId").val(),
					"info" : info,
				},

				url : "saveNotice2.action",
				success : function(status) {
					$("#bc").attr("disabled", true);
					$("#add").attr("disabled", true);
					alert("保存成功");

				}
			});

		});



	//会议主持人二级联动
	$.ajax({
		type : "post",
		dataType : "json",
		url : "getAllUsers.action",
		success : function(result) {
			testJson = $.parseJSON(result);
			json = testJson[0];
			getUserList(json);
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

	/*默认显示当前用户*/
	function showCurrentUser() {
		var currentUserId = $("#userId").val();
		for (var key in json) {
			var array = json[key];
			for (var i = 0; i < array.length; i++) {
				if (array[i].userId == currentUserId) {
					$("#unitSele").val(key);
					var user = document.getElementById("userSele");
					var pronvinceKey = $("#unitSele").val();
					var cities = json[pronvinceKey];
					user.length = 1;
					for (var i = 0; i < cities.length; i++) {
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


	$("#add").click(function() {
		showCurrentUser();
		$("#calendar_no_name").val(getCurrentDate());
	});


})