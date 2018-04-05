$(function() {

	/* 查询评审专家个人基本信息*/
	$.ajax({
		url: "findSpecialistInfoAction.action",
		type: "post",
		data: {
			"specialistId" : $("#expertId").val()
		},
		dataType: "json",
		success: function(result) {
			var specialist = result.specialist;
			if(specialist != null) {
				console.log("Finding specialist info is ok!");
				
				$("#name").val(specialist.name);
				if(specialist.sex == "男") {
					$(".s_sex:first").attr("checked", true);
				} else {
					$(".s_sex:last").attr("checked", true);
				}
				$("#birthday").val(specialist.birthday);
				$("#workUnit").val(specialist.workUnit);
				$("#engageDomain").val(specialist.engageDomain);
				$("#duty").val(specialist.duty);
				$("#title").val(specialist.title);
				$("#telephone").val(specialist.telephone);
				$("#email").val(specialist.email);
				$("#specialistId").val(specialist.specialistId);

				var signature = specialist.signature; 
				if(signature != null && signature != "") {
					$("img#preview").attr("src", signature);
					$("#oldSignatureIndex").val(signature);
				}
			} else {
				console.log("Finding specialist info is ok!But specialist info is null!");
			}
		},
		error: function() {
			console.log("Finding specialist info is error!");
		}
	});

	/*该tip用于记录专家个人信息是够修改成功!（通过form提交形式达到ajax提交形式的效果）*/
	var newResultTip = $("#newResultTip").val();
	var oldResultTip = $("#oldResultTip").val();
	if(newResultTip!="" && oldResultTip!="" && newResultTip!=oldResultTip) {
		var resultInfo = newResultTip.split("&");
		alert(resultInfo[0]);
	}
	
	/* 修改专家个人签名密码*/
	$(".updatePass").click(function() {
		var oldPass = $("#oldPass").val();
		var newPass = $("#newPass").val();
		var reNewPass = $("#reNewPass").val();
		var exist = checkIfExistSignaturePass();
		
		if(!exist) {
			if(newPass=="" || reNewPass=="") {
				$("#reNewPassTip").text("密码不能为空!");
				return false;
			}
		} else {
			if(oldPass=="" || newPass=="" || reNewPass=="") {
				$("#reNewPassTip").text("密码不能为空!");
				return false;
			}
		}
		
		// 修改专家签名密码
		updateSignaturePass();
	});
	
	/*检测是否存在签名密码*/
	function checkIfExistSignaturePass() {
		var exist = false;
		$.post("checkIfExistSignPassAction.action", {
			"specialistId" : $("#expertId").val()
		}, function(result) {
			var res_signPass = result.exist;
			if(res_signPass) {
				exist = res_signPass;
			}
		});
		return exist;
	}
	
	/*修改签名密码*/
	function updateSignaturePass() {
		var params = {
				"specialistId"  : $("#expertId").val(),
				"signaturePass" : $("#newPass").val()
		};
		
		var oldPass = $("#oldPass").val();
		if(oldPass && oldPass.length == 0) {
			params.oldPass = null;
		} else {
			params.oldPass = oldPass;
		}
		
		$.ajax({
			url: "updateSignaturePassAction.action",
			type: "post",
			data: params,
			dataType: "json",
			success: function(result) {
				if(result) {
					console.log("Updating signature password is ok!");
					alert("密码修改成功!");
					$("#fix_password_modal").modal('hide');
					$("input[type='password']").val("");
				} else {
					alert("旧密码错误,修改失败!");
					$("#fix_password_modal").modal('hide');
					$("input[type='password']").val("");
				}
			},
			error: function() {
				console.log("Updating signature password is error!");
				alert("密码修改失败!");
			}
		});		
	}
	
	/*取消修改签名密码时，关闭模态框并清空模态框中数据*/
	$(".cacelUpdatePass").click(function() {
		$(".modal-body input[type='password']").val("");
		$("#reNewPassTip").text("");
	});
	
	/*上传专家个人签名*/
	$("#fix_pic").click(function() {
		var upload_file = $("#headPortrait").val();
		console.log("upload_file: " + upload_file);
		
		if(upload_file == null || upload_file == "") {
			alert("未选择文件,请上传新的签名图片!");
			return false;
		}
		
		$.ajaxFileUpload({
			url: "updateSignatureAction.action",
			type: "post",
			fileElementId: "headPortrait",
			data: {
				"specialistId": $("#expertId").val(),
				"oldSignatureIndex": $("#oldSignatureIndex").val()
			},
			dataType: "json",
			success: function(result) {
				var oldSignatureIndex = result.oldSignatureIndex;
				console.log("oldSignatureIndex: " + oldSignatureIndex);
				
				if(oldSignatureIndex != "undefined" && oldSignatureIndex != null && oldSignatureIndex != "") {
					alert("签名图片修改成功!");
					$("#headPortrait").val("");
					
					$("#oldSignatureIndex").val(oldSignatureIndex);
					
					console.log("Updating signatue is ok!");
				} else {
					alert("签名图片修改失败!");
				}
			},
			error: function() {
				console.log("Updating signature is error!");
			}
		});
	});
	
	/*修改签名密码时的监听事件（保证新密码和重复密码输入值一致）*/
	$("#reNewPass").bind("input propertychange", function() {
		var newPass = $("#newPass").val();
		var reNewPass = $(this).val();
		if(reNewPass != newPass) {
			$("#reNewPassTip").text("与新密码不一致!");
		} else {
			$("#reNewPassTip").text("");
		}
	});
	
	$("#newPass").bind("input propertychange", function() {
		var newPass = $(this).val();
		var reNewPass = $("#reNewPass").val();
		if(reNewPass!="" && reNewPass != newPass) {
			$("#reNewPassTip").text("与新密码不一致!");
		} else {
			$("#reNewPassTip").text("");
		}
	});
});