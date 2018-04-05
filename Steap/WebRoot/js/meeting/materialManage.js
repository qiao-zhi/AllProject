$(document).ready(function () { 
	
	//选择项目名称，将项目信息进行更新
	var sel=document.getElementById("selectPro");
  
	 sel.onchange=function(){

         
			$.ajax({
				type : "post",
				dataType : "json",
				url : "searchProjectInfo.action",
				data:{
					"projectId":sel.options[sel.selectedIndex].value,
				},
		    	success:function(mapInfo){
		    		
		    		 $("label[name='applicant']").html(mapInfo.projectAccept.applicant);
		    		 $("label[name='projectName']").html(mapInfo.projectAccept.projectName);
		    		 $("label[name='chargePerson']").html(mapInfo.projectAccept.projectCharge.chargePerson);
		    		 $("label[name='projectFunds']").html(mapInfo.projectAccept.projectFunds);
		    		
		    		 $("#fileTable  tr:not(:first)").html("");
		    		 for(var i=0;i<mapInfo.materialList.length;i++){
		    			 $("#fileTable").append(
		    					 "<tr>"+
		 						"<td>"+(i+1)+"</td>"+

		 						"<td>"+mapInfo.materialList[i].fileType+"<input name='materialId' type='hidden' value='"+mapInfo.materialList[i].fileId+"' /></td>"+
		 							
		 						"<td>"+mapInfo.materialList[i].originalName+"</td>"+
		 						"<td>"+mapInfo.materialList[i].uploadTime+"</td>"+
		 						"<td>"+mapInfo.materialList[i].fileSize+"</td>"+

		 						"<td>"+
		 						     "<input type='hidden' value='"+mapInfo.materialList[i].currentName +"' name='pdfPath'/>"+
		 							"<a href='"+mapInfo.materialList[i].currentName+" '  target='_blank' class='operation_icon' data-toggle='tooltip' data-placement='bottom' title='查看'>" +
		 							"<i class='glyphicon glyphicon-search'></i>" +
		 							"</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class='delFile' href='javaScript:void(0)' class='operation_icon' data-toggle='tooltip' data-placement='bottom' title='删除'><i class='glyphicon glyphicon-trash'></i></a>"+
		 							
		 							"</td>"+
		 					"</tr>" 
		    		    		 
			    		 );
		    		 }
		    		
		    	}
		   	    	
			});
			
	    	
	    }
	 
	
	  
	     //删除文件
	  /*   $("a[name='delFile']").click(function(){
			 
			  var num = $(this).parent().siblings("td:eq(0)").text();		     
		      var materialId =$(this).parent().siblings("td:eq(1)").find("input[name='materialId']").val();
		      
						  $.ajax({
								 
								 type:"post",
								 datype:"json",
								 data:{
									 "fileId":materialId,															
									},
								 url:"deleteFile.action",
								 success:function(status){
									 if(status){
										 $("#fileTable tr").eq(num).remove();
										 var len = $('#fileTable tr').length;
										   for(var i = 1;i<len;i++){
											$('#fileTable tr:eq('+i+') td:first').html(i);
										  }
										   
									     alert("删除成功");
									  //   location.reload();
										
										 
									 }
																	
								 }
							 });
		 });*/
	     
	     
	     
	     //上传资料
	    
        $("#uploadMaterial").click(function () {
       
         	 var sel=document.getElementById("selectPro");
         	var sel2=document.getElementById("myfileType");
         	var fileName=$("#material").val();
         	
         	var num=parseFloat($("#fileTable tr:last").find("td:first").text());
         	
         	/*最后一个文件的引索*/
         	var lastNum = $("#fileTable tr").length - 1;
         	
         	if(num>=7){
         		alert("资料种类已经齐全，不能重复提交");
         		return false;
         	}else{
         		//判断是否已经上传过此类型文件，如果有则不能重复上传
         		var str="";
         		
             	
             	for(var i=0;i<num;i++){
             	
             		str=str+$("#fileTable tr").eq(lastNum - i).find("td").eq(1).text()+",";
             		
             	}
             	var str2=str.split(",");
             	for(var i=0;i<str2.length;i++){
             		
             		if(str2[i]==sel2.options[sel2.selectedIndex].value){
             			alert("该类型文件已经上传过，不能重复提交");
             			return false;
             		}
             	}
         		
             	//判断文件类型是否正确
             	var s=fileName.split(".");
             	
             	/* 
             	 * @modifier yachao
             	 * @time 2016/02/01
             	 * 全部上传文件格式修改为pdf
             	 * 
             	 * */
//             	if(s[s.length-1]=="doc"||s[s.length-1]=="docx"){
             	if(s[s.length - 1].toLowerCase() == 'pdf') {
             		 $.ajaxFileUpload({
                         
                         url: "saveMaterialFile.action",                     
                         type:"post",
                         fileElementId: "material",
                         data:{
                         	"projectId":sel.options[sel.selectedIndex].value,
                         	"fileType":sel2.options[sel2.selectedIndex].value,
//                         	"fileName":fileName,
                         },
                         dataType: "text", 
                         success:function(status){
                         	  
                         	  if(status){                        		                        		
                                
                            	
                                $.ajax({
                    				type : "post",
                    				dataType : "json",
                    				url : "searchMaterialForAjax.action",
                    				data:{
                    					"projectId":sel.options[sel.selectedIndex].value,
                    				},
                    		    	success:function(materialList){
                    		    		
                    		           
                    		            $("#fileTable  tr:not(:first)").html("");
                                        for(var i=0;i<materialList.length;i++){
                                        	$("#fileTable").append(
                                             		
                                         			"<tr>"+
                            						"<td>"+(i+1)+"</td>"+

                            						"<td>"+materialList[i].fileType+"<input name='materialId' type='hidden' value='"+materialList[i].fileId+"'/></td>"+
                            							
                            						"<td>"+materialList[i].originalName+"</td>"+
                            						"<td>"+materialList[i].uploadTime+"</td>"+
                            						"<td>"+materialList[i].fileSize+"</td>"+

                            						"<td>"+
                            						     "<input type='hidden' value='"+materialList[i].currentName +"' name='pdfPath'/>"+
                            							"<a href='"+materialList[i].currentName+"'  target='_blank' class='operation_icon' data-toggle='tooltip' data-placement='bottom' title='查看'><i class='glyphicon glyphicon-search'></i></a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                            									"<a class='delFile' href='javaScript:void(0)' class='operation_icon' data-toggle='tooltip' data-placement='bottom' title='删除'><i class='glyphicon glyphicon-trash'></i></a>"+
                            							
                            							"</td></tr>"
                            					
                                         			
                                         	);
                                        }
                                        alert("上传成功");
//                                        location.reload();
                    		    	}
                    				});
                    		    }
                     
                             	
                             	  
                            },    
                         	
                           error:function(){
                          	alert("出错了");
                          }
                        
                         
                       
                     });
             		
             	}else{
//             		alert("请选择以doc或者docx为后缀名的文档进行上传");
             		alert("请选择文件名格式为*.pdf的文件进行上传!");
             	}
         		
         		
         	
             
         	}
         	
               
         });
        
        
        //删除文件
        $("#fileTable").on("click",".delFile", function(){
        	
        	 var num = $(this).parent().siblings("td:eq(0)").text();		     
		      var materialId =$(this).parent().siblings("td:eq(1)").find("input[name='materialId']").val();
		     
						  $.ajax({
								 
								 type:"post",
								 datype:"json",
								 data:{
									 "fileId":materialId,
									 "path":$(this).parent().find("input[name='pdfPath']").val(),
									},
								 url:"deleteFile.action",
								 success:function(status){
									 if(status){
										 
										 $("#fileTable tr").eq(num).remove();
										 var len = $('#fileTable tr').length;
										   for(var i = 1;i<len;i++){
											$('#fileTable tr:eq('+i+') td:first').html(i);
										  }
										   
									     alert("删除成功");
									     location.reload();
										
										 
									 }
																	
								 }
							 });
        	
        });
        
      
	     
	  

});

	