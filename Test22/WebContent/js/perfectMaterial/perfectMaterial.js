/**
 * @author Zychaowill
 * @date 2017/3/16 
 * @description 默认查询
 */

$(function() {
	fundCurrentMaterial();
	
	function fundCurrentMaterial(){
		$.ajax({
			url: 'findPastMaterialAction.action',
			type: 'post',
			data: {
				'projectId': $("#un_general_projectId").val()
			},
			dataType: 'json',
			success: function(result) {
				if (result.success == true) {
					var materials = result.materials;
					
					var m_tbody = $("#m_tbody");
					m_tbody.html("");
					for (var i = 0; i < materials.length; i++) {
						var remark = materials[i].remark;
						var _tr = "<tr>";
						_tr += "<td>" + (i + 1) + "</td>";
						_tr += "<td>" + materials[i].originalName + "</td>";
						_tr += "<td>" + materials[i].fileType + "</td>";
						_tr += "<td>" + materials[i].uploadTime + "</td>";
						
						if (remark == 1) {
							_tr += "<td class='hidden'></td>";
						} else {
							_tr += "<td class='hidden'>" + materials[i].fileId + "</td>";
						}
						
						_tr += "<td>" + materials[i].fileSize + "</td>";
						
						if (remark == 1) {
							_tr += "<td>-</td></tr>";
						} else {
							_tr += "<td><a href='javaScript:void(0)' class='operation_icon' data-toggle='tooltip' data-placement='bottom' title='删除'>"
								+ "<i class='glyphicon glyphicon-trash'></i>" 
								+ "</a>&nbsp&nbsp<a href='" + materials[i].currentName + "' target='_blank'class='operation_icon2' data-toggle='tooltip'data-placement='bottom' title='查看'><i class='glyphicon glyphicon-search'></i></a></td></tr>";
						}
						$(_tr).appendTo(m_tbody);
					}
				}
			},
			error: function(result) {
				console.log("Finding past material is error!");
			}
		});
	}
	
	

		//上传资料
    $("#uploadMaterial").click(function () {
    		var thisName = $("#material").val();
    		var s = thisName.substring(thisName.lastIndexOf(".")+1);
    		
    		/* 判断是否重复上传 */
//    		var str="";
//    		var num=parseFloat($("#materialTable tr:last").find("td:first").text());
//    		for(var i=0;i<num;i++){
//         		str=str+$("#materialTable tr").eq(i+1).find("td").eq(2).text()+",";
//         	}
//    		var str2=str.split(",");
//         	for(var i=0;i<str2.length;i++){
//         		if(str2[i]== $("#fileType  option:selected").text()){
//         			alert("该类型文件已经上传过，不能重复提交");
//         			return false;
//         		}
//         	}
    		
    		
    		if(s=="pdf" || s=="PDF"){
    			$.ajaxFileUpload({
                    
                    url: "savePerfectFile.action",                     
                    type:"post",
                    fileElementId: "material",
                    data:{
                    	"projectId" : $("#un_general_projectId").val(),
                    	"fileTypes" : $("#fileType  option:selected").val()
                    },
                    dataType: "text/html", 
                    success: function (result){
                    	/* alert(result); */
                    	var a = result.replace("\"","").replace("\"","");
                    	
                    	var comList = $("#completeIdList").val();
                    	if(comList == ""){
                        	$("#completeIdList").val(a);
                    	} 
                    	if(comList != "") {
                    		/* alert(comList); */
                    		/* comList.append(a); */
                    		comList = comList + "," + a;
                    		$("#completeIdList").val(comList);
                    	}
                    	
                    	fundCurrentMaterial();
                    } , error : function(){
                    	alert("失败了");
                    } 
                  
                });
    		} else {
    			alert("请选择以pdf或者PDF为后缀名的文档进行上传");
    		}
    	
            
            
     });
		
		
		$("#materialTable").on("click",".operation_icon",function(){
			var $file_th = $("#file_th").index();
			var  fileId= $(this).parent().parent().children().eq($file_th).text().trim();
			
			var comList2 = $("#completeIdList").val();
			var comList3 = "";
			var com=comList2.split(",");
			for(var i=0;i<com.length;i++){
				/* alert(com[i].substring(com[i].lastIndexOf(".")+1) + "=====" + fileId); */
				 /* alert(com[i].substring(com[i].lastIndexOf(".")+1)); */
				if(com[i].substring(com[i].lastIndexOf(".")+1) == fileId){
					/* alert(fileId);
					alert("有这个元祖"); */
					com[i] = ","; 
				}
			comList3 = comList3 + "," + com[i].trim();
			}
			$("#completeIdList").val(comList3);
			
			 $.ajax({
			type : "post",
			datatype : "json",
			url : "deletePerfectFile.action",
			data : {
				"fileId" : fileId
			}, success : function(deleteResult){
				alert("删除成功");
				fundCurrentMaterial();
			}
			});
		});
	
});