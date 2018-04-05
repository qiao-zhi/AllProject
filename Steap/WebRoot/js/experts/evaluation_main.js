$(function() {
	
	if(PDFObject.supportsPDFs) {
		console.log("Yay, this browser supports inline PDFs.");
		PDFObject.embed("", $("#pdfViewer"));
	} else {
		console.log("Boo, inline PDFs are not supported by this browser");
	}
	
	$("#specialistId").val($("#expertId").val());
	
	/* 加载当前项目专家评审意见*/
	$.ajax({
		url: "findEvaluationInfoAction.action",
		type: "post",
		data: {
			projectId: $("#projectId").val(),
			specialistId: $("#specialistId").val()
		},
		dataType: "json",
		success: function(result) {
			console.log("Finding evaluation info is ok!");
			var rsAndState = result.rsAndState;
			if(rsAndState != null) {
				$(".jqte_editor").html(rsAndState.reviewSuggestion);
				if(rsAndState.remark == "1") {
					$(".jqte_editor").attr("contenteditable", "false");
					$(".save_review").attr("disabled", "disabled");
					$(".only_save_review").attr("disabled", "disabled");
				}
			}
		},
		error: function() {
			console.log("Finding evaluation info is error!");
		}
	});
	
	/* 根据不同的链接加载不同的PDF文档*/
	$("a.filePath").click(function() {
		var pdfName = $(this).attr("data_title");
		PDFObject.embed(pdfName, $("#pdfViewer")); 
		$("#fullScreenContainer").css("display", "block");
	});
	
	/* 保存当前项目的专家评审意见*/
	$(".only_save_review").click(function() {
		var editor = $(".jqte_editor");
		var content = editor.html();
		if(content == null || content == "") {
			alert("请填写项目评审意见!");
			return false;
		}
		setSignature(editor, "保存");
	});
	
	/* 提交当前项目的专家评审意见*/
	$(".save_review").click(function() {
		var editor = $(".jqte_editor");
		var content = editor.html();
		if(content=="" || content == null) {
			alert("请填写项目评审意见!");
			return false;
		}
		
		/**
		 * @modifier yachao
		 * @time 2016/02/01
		 * @eescription 为了减少不必要的误操作，在专家提交个人意见时，
		 * 				弹出对话框提醒用户“个人意见一旦提交不能修改，
		 * 				请仔细核查，谨慎提交！”，点击对话框的确定按钮后，才提交。
		 */
		if(confirm("个人意见一旦提交不能修改，是否确定提交?")) {
			setSignature(editor, "提交");
		}
	});
	
	function setSignature(editor, operationType) {
		var opinionContent = editor.html();
		console.log("opinionContent: " + opinionContent);
		$("#opinion").val(opinionContent);
		
		$.post("getSignatureAction.action", {
			"specialistId" : $("#specialistId").val()
		}, function(result) {
			if(operationType == "提交") {
				var signature = result.signature;
				if(result.signature && signature != null) {
					console.log("signature: " + signature);
					var img = "<div class='div-container' style='display:block;float:right;'><br/><br/></br><img src='" + signature + "' style='float:left; width:370px; height: 120px;'/></div>";
					var img_container = $(img);
					img_container.find("img").css({
						"width" : "200px",
						"height" : "80px",
						"float" : "right"
					});
					img_container.css({
						"width" : "200px",
						"height": "80px" 
					}).appendTo(editor);
					
				}				
			}
			entryEvaluationInfo(editor, operationType);
		});
	}
	
	function entryEvaluationInfo(editor, operationType) {
		$("#operationType").val(operationType);
		
		var content = editor.html();
		console.log("content: " + content);
		$("#reviewSuggestion").val(content);
		$("#reviewInfo").ajaxSubmit({
			success : function(result) {
				var insert = result.insert;
				if(result.insert && insert) {
					alert(operationType + "成功!");
					$("#operationType").val("");
					
					if(operationType == "提交") {
						$(".jqte_editor").attr("contenteditable", "false");
						$(".save_review").attr("disabled", "disabled");
						$(".only_save_review").attr("disabled", "disabled");
					}
				}
			}
		});
	}
		
	/* --------------------------------------------------*/
	/*			全屏显示PDF by yachao						 */
//    var isFull = false;
    
    $("#fullScreenView").click(function() {
//    	if(screenfull.enabled) {
//    		screenfull.toggle($("#pdf")[0]);
//    		isFull = !isFull;
//    		if(isFull) {
//    			$("#pdf").css({
//    				"transform" : "scale(1)",
//    				"width" : "100%",
//    				"height": "100%"
//    			});
//    			$("#plugin").css("text-align", "center");
//    			$("#fullScreenView").html("<i class='glyphicon glyphicon-resize-small'></i>退出全屏");
//    		} else {
//    			$("#pdf").css({
//    				"transform" : "scale(1)",
//    				"width" : "909px",
//    				"height" : "630px"
//    			});
//    			$("#fullScreenView").html("<i class='glyphicon glyphicon-resize-full'></i>全屏查看");
//    		}
//    	}
    	fullScreen();
    }); 
    
    function fullScreen () {
        var invokeFieldOrMethod = function(element, method) {
          var usablePrefixMethod;
          ["webkit", "moz", "ms", "o", ""].forEach(function(prefix) {
           if (usablePrefixMethod) return;
           if (prefix === "") {
               // 无前缀，方法首字母小写
               method = method.slice(0,1).toLowerCase() + method.slice(1);
           }
           var typePrefixMethod = typeof element[prefix + method];
           if (typePrefixMethod + "" !== "undefined") {
               if (typePrefixMethod === "function") {
                   usablePrefixMethod = element[prefix + method]();
               } else {
                   usablePrefixMethod = element[prefix + method];
               }
           }
       });
         return usablePrefixMethod;
       };

       //進入全屏
       function launchFullscreen(element) {
          //此方法不可以在異步任務中執行，否則火狐無法全屏
           if(element.requestFullscreen) {
             element.requestFullscreen();
           } else if(element.mozRequestFullScreen) {
             element.mozRequestFullScreen();
           } else if(element.msRequestFullscreen){
             element.msRequestFullscreen();
           } else if(element.oRequestFullscreen){
              element.oRequestFullscreen();
          }
          else if(element.webkitRequestFullscreen)
           {
             element.webkitRequestFullScreen();
           }else{

              var docHtml  = document.documentElement;
              var docBody  = document.body;
              var videobox  = document.getElementById('pdfViewer');
              var  cssText = 'width:100%;height:100%;overflow:hidden;';
              docHtml.style.cssText = cssText;
              docBody.style.cssText = cssText;
              videobox.style.cssText = cssText+';'+'margin:0px;padding:0px;';
              document.IsFullScreen = true;

            }
         }
          //退出全屏
         function exitFullscreen() {
             if (document.exitFullscreen) {
                document.exitFullscreen();
             } else if (document.msExitFullscreen) {
                document.msExitFullscreen();
             } else if (document.mozCancelFullScreen) {
                document.mozCancelFullScreen();
             } else if(document.oRequestFullscreen){
                document.oCancelFullScreen();
              }else if (document.webkitExitFullscreen){
                document.webkitExitFullscreen();
             }else{
                var docHtml  = document.documentElement;
                var docBody  = document.body;
                var videobox  = document.getElementById('pdfViewer');
                docHtml.style.cssText = "";
                docBody.style.cssText = "";
                videobox.style.cssText = "";
                document.IsFullScreen = false;
             }
        }
        // document.getElementById('fullScreenBtn').addEventListener('click',function(){
            launchFullscreen(document.getElementById('pdfViewer'));
            // window.setTimeout(function exit(){
                if(invokeFieldOrMethod(document,'FullScreen')
                    || invokeFieldOrMethod(document,'IsFullScreen')
                    || document.IsFullScreen) {
                      exitFullscreen();
                }
            // },5*1000);
        // },false);
    }
});