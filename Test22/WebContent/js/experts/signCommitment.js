$(function() {
	
	$.ajax({
		url : "getProjectNamesAction.action",
		type: "post",
		data: {
			"meetingId" : $("#meetingId").val()
		},
		dataType: "json",
		success: function(result) {
			console.log("Getting project names is ok!");
			var names = result.names;
			if(names != null) {
				$("#projectNames").text(names);
				$("#projectNameSet").text(names);
			}
		},
		error: function() {
			console.log("Getting project names is error!");
		}
	});
	
	function setRealSignaturePass() {
		console.log("Starting setting real signature pass!");
		
		$.post("getSignaturePass.action", {
			"specialistId" : $("#specialistId").val()
		}, function(result) {
			var signaturePass = result.signaturePass;
			if(signaturePass !=null) {
				$("#real_signature_pass").val(signaturePass);
			}
		});
		console.log("Finishing setting real signature pass!");
	}
	
	/*签订专家廉洁、回避承诺书*/
	$(".saveSign").click(function() {
		$("#input_signature_pass").modal();
		
		setRealSignaturePass();
	});
	
	/* 输入签名密码后，点击确定时*/
	$(".check_signature_pass").click(function() {
		var enter_signature_pass = $("#enter_signature_pass").val();
		
		if(enter_signature_pass == null || enter_signature_pass == "") {
			alert("签名密码不能为空!");
			return false;
		}
		
		var real_signature_pass = $("#real_signature_pass").val();
		if(enter_signature_pass == real_signature_pass) {
			$("#input_signature_pass").modal("hide");
			$(".clear_content").val("");
			
			/*保存签订记录*/
			var promise = $("input[type='radio'][name='promise']").val();
			$("#promise").val(promise);
			
			$("#signForm").ajaxSubmit({
				success: function(result) {
					var update = result.update;
					if(result.update && update) { // 签订成功
						console.log("Signing commitment is ok!");
						var signature = result.signature;
						if(signature != null && signature != "") {
							$(".hidden-info").css({
								"display" : "none"
							});
							$(".margin-info").css({
								"margin-top" : "20px"
							});
							$(".saveSign").attr("disabled", "disabled");
							$("#autonomy-signature").attr("src", signature);
							$("#promise-signature").attr("src", signature);
						}
					} else { // 签订失败
						console.log("Signing commiement is error!");
						alert("承诺书签订失败!\n请重新签订!");
					}
				}
			});
			
//			$("#signForm").submit();
		} else {
			alert("签名密码错误!\n请重新输入!");
			$("#enter_signature_pass").val("");
			return false;
		}
	});
	
	/* 点击模态框关闭按钮时*/
	$(".signature_pass_close").click(function() {
		$("#input_signature_pass").modal("hide");
		$("#enter_signature_pass").val("");
	});
	
	$(".backToLast").click(function() {
		window.history.go(-1);
	});
	
	$("input:radio").click(function() {
		if (document.getElementById('agreement_sign_ok1').checked && document.getElementById('agreement_sign_ok2').checked) {
			$("#sign_commit_ok").removeAttr("disabled");
		} else {
			$("#sign_commit_ok").attr("disabled", "disabled");
		}
	});
});