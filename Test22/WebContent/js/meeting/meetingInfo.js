$(document).ready(function () {
		
	/*判断是否需要显示审计信息*/
	if($("#financeUnitS").html() != "" && $("#financeUnitS").html() != "-"){
		$("#autitDiv").attr("style", "display");
	}
	
		
		$("button[name='xiangmu']").click(function(){
			
			$.ajax({
				type:"post",
				dataType:"json",
				data:{
					"projectID":$(this).val(),
				},
				url:"lookMeetingProjectInfo.action",
				success:function(mapInfo){
					 $("span[name='projectName']").html(mapInfo["project"].projectName);
				
					$("span[name='applicant']").html(mapInfo["project"].applicant);
					$("span[name='domain']").html(mapInfo["project"].domain);
					$("span[name='applicationDate']").html(mapInfo["project"].applicationDate);
					$("span[name='recordPerson']").html(mapInfo["project"].projectRecord.recordPerson);
					$("span[name='recordDate']").html(mapInfo["project"].projectRecord.recordDate);
					
					//验收意见初稿
					$(".jqte_editor").html("");
					if (mapInfo['material']) {
						$(".jqte_editor").html(mapInfo['material'].opinionContent);
					}
					
					$("#inspectPersonS").text(mapInfo["project"].enterpriseInspect.inspectPerson);
					$("#inspectDateS").text(mapInfo["project"].enterpriseInspect.inspectDate);
					$("#inspectResultS").val(mapInfo["project"].enterpriseInspect.inspectResult);
					
					if(mapInfo["project"].auditInfo != null){
						$("#financeUnitS").text(mapInfo["project"].auditInfo.financeUnit);
						$("#auditDateS").text(mapInfo["project"].auditInfo.auditDate);
					} else {
						$("#financeUnitS").text("-");
						$("#auditDateS").text("-");
					}
					
					/*清空图片的div*/
					$("#enterpriseInspectDiv").empty();
					$("#auditInfoDiv").empty();
					$("#realPromiDiv").empty();
					
					
					/*企业考察图片*/
					if(mapInfo["picture2"] != null){
						for(var i = 0; i < mapInfo["picture2"].length; i ++){
							$("#enterpriseInspectDiv").append(
									"<a href=" + mapInfo['picture2'][i].currentName + " data-lightbox = 'yaowei' class='box_size thumbnail col-xs-6 col-md-3'" +
									" data-title='second pic'><img src=" + mapInfo['picture2'][i].currentName + " /><span class='pic_info'></span></a>");
						}
					}
					
					/*审计图片*/
					if(mapInfo["picture3"] != null){
						for(var i = 0; i < mapInfo["picture3"].length; i ++){
						$("#auditInfoDiv").append(
							"<a href=" + mapInfo['picture3'][i].currentName + " data-lightbox = 'yaowei' class='box_size thumbnail col-xs-6 col-md-3'" +
					 		" data-title='second pic'><img src=" + mapInfo['picture3'][i].currentName + " /><span class='pic_info'></span></a>");
						}
					}
					
					/*真实性承诺书*/
					if(mapInfo["picture"] != null){
						for(var i = 0; i < mapInfo["picture"].length; i ++){
						$("#realPromiDiv").append(
								"<a href=" + mapInfo['picture'][i].currentName + " data-lightbox = 'yaowei' class='box_size thumbnail col-xs-6 col-md-3'" +
						 		" data-title='second pic'><img src=" + mapInfo['picture'][i].currentName + " /><span class='pic_info'></span></a>");
						}
					}
					
					if(mapInfo["project"].auditInfo != null){
						$("#autitDiv").attr("style", "display");
					} else {
						$("#autitDiv").attr("style", "display:none");
					}
					
				}	
			});
			
			
		});
	});
	 
