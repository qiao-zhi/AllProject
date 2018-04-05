
$(document).ready(function () { 
	

	
	
	
	
	//查询
	$("#searchProject").click(function(){
		
		 $.ajax({
				type : "post",
				dataType : "json",
				url : "searchProjectInfo2.action",
				data:{
					"projectCondition.projectName":$("input[name='projectCondition.projectName']").val(),
					"projectCondition.applicant":$("input[name='projectCondition.applicant']").val(),
					"projectCondition.domain":$("select[name='projectCondition.domain']").val(),
					"projectCondition.projectFunds":$("select[name='projectCondition.projectFunds']").val(),
				},
				success : function(map){
					
					
			
					   var pageNum= $("#totalPage").val();
						$("#totalPage")[0].value=map.totalPage;
						
//						 $("#demo1").myPagination({
//					          currPage: $("#currentPages").val(),
//					          pageCount: $("#totalPage").val(),
//					         
//					        });
						$("#currentPages").val("1");
						myPaging();
						 
						 $("#totalPage").val(pageNum);
						
					var projectInfoResultList=map.projectInfoResultList;
					 $("#huiyiTab  tr:not(:first)").html("");
					for(var i=0;i<projectInfoResultList.length;i++){
						 $("#huiyiTab").append(
		 							"<tr>"+
									
									"<td>"+"<input type='checkbox'"+
										"value='"+projectInfoResultList[i].projectId+","+projectInfoResultList[i].projectName+","+projectInfoResultList[i].applicant+","+projectInfoResultList[i].domain+","+projectInfoResultList[i].projectFunds+
										"' name='chooseBox' /></td>"+
									"<td>"+(i+1)+"</td>"+
									"<td>"+projectInfoResultList[i].projectName+"</td>"+
		 						"<td>"+projectInfoResultList[i].projectId+"</td>"+
		 						"<td>"+projectInfoResultList[i].applicant+"</td>"+
		 						"<td>"+projectInfoResultList[i].domain+"</td>"+
									"<td>"+projectInfoResultList[i].recordDate+"</td>"+
		 						"<td>"+projectInfoResultList[i].projectFunds+"</td>"+
									"<td>"+projectInfoResultList[i].inspectDate+"</td>"+
									"<td>"+"已考察"+"</td>"+
									
		 						"<td>"+"<a data-placement='bottom' title='查看' class='operation_icon' data-toggle='tooltip' href='LookProjectInfo.action?projectId="+projectInfoResultList[i].projectId+"' >"+
		    								
		     							"<i class='glyphicon glyphicon-search'></i></a>"+"</td>"+
		 						"</tr>"
		 						            				 
		 				 );
					}
					
				}
			});
		
	});
		
	
	
	
	
	//选择完项目后的，“创建会议”
	$("#create2").click(function () {
	   
		
		   
			
		   var obj=document.getElementsByName("chooseBox"); 		   
		   var num=0;
			for(var i=0; i<obj.length; i++){ 
			  if(obj[i].checked){
				  num+=1;//用于判断是否选中项目
			  }
			  
			}
			
			if(num==0){
				alert("请先选择项目，然后进入功能区");
				return false;
			}else{
				$("#myModal").modal("show");
				var s=""; 
				
				var count=parseFloat($("#mytable tr:last").find("td:first").text());
				count=count+1;
				if(isNaN(count)){
					count=1;
					
				}
				//var count=1;
				
				for(var i=0; i<obj.length; i++){ 
				if(obj[i].checked){
					
				
				 s=obj[i].value; //如果选中，将value添加到变量s中 
				var a= s.split(",");
				 
		          
	        	 $("#mytable").append(
	        			 "<tr> "+"<td>" + count+" </td>"
	        			 +"<td>" + a[1] +  " </td>"+
	        			 "<td>" + a[2] +  " </td>"+
	        			 "<td>" + a[3] +  " </td>"+
	        			 "<td>" + a[4] +  " </td>"+
	        			 "<td>" + "<a href='javaScript:void(0)' class='delPro' class='operation_icon'  data-toggle='tooltip' data-placement='bottom'   titles='删除'><i class='glyphicon glyphicon-trash'></i></a>"+"</td>"+
	        			/* "<td>" + "<a href='javaScript:void(0)' class='del'>删除</a>"+"</td>"+*/
	        			 "<input type='hidden' name='projectIdList' value='"+a[0]+"'/>"+
	        			 "</tr>"  
	        	
	        			 
	        	 
	        	 );
		        	s="";	
		        	++count;
		         	obj[i].checked=false;
		        	//当用户选择完后，不能重复选择，因此将复选框设置为不可选
		        	obj[i].disabled=true;
		        	
		        	
		        	
				}
				
				}
				
				
				//会议主持人二级联动
				 $.ajax({
		  				type : "post",
		  				dataType : "json",
		  				url : "getAllUsers.action",
		  				success : function(result){
		  					testJson = $.parseJSON(result);
							json = testJson[0];
							getUserList(json);
		  				}
		  			});
		  			function getUserList(json){
		  				var unit = document.getElementById("unitSele");
			  			var user = document.getElementById("userSele");
			  			//1 遍历json中的所有key
			  			for(var key in json){
			  			//2 key封装到option对象中
			  					var option = document.createElement("option");
			  					option.innerHTML = key;
			  			//3 添加
			  					unit.appendChild(option);
			  				}

			  			//为unit添加onchange事件
			  			unit.onchange=function(){
			  				//0 每次添加市之前,清空市的下拉选
			  					user.length=1;
			  				//1. 获得用户选择的省
			  				var pronvinceKey = this.options[this.selectedIndex].innerHTML;
			  				//2. 根据选择的省去json中取得对应 市数组
			  				var cities = json[pronvinceKey];
			  				//3. 遍历数组中的所有市,封装到option对象中
			  				for(var i=0; i<cities.length; i++){
			  					var option2 = document.createElement("option");
			  					var option = user.appendChild(option2);
			  					option.innerHTML = cities[i].name;
			  					option.value = cities[i].userId;
			  				}
			  				
			  				
			  			};
		  			}
				
				
			}
			
			
			
			
		
		
	
		
		
		
		
		
	
    } );
		
			
	// 当页面刷新后，重新将复选框设置为可选状态
	 window.onunload = function upload(){
		
		var obj=document.getElementsByName("chooseBox"); 
		for(var i=0; i<obj.length; i++){ 
			if(!obj[i].checked){
				
				obj[i].disabled=false;
				
			}
		}
	};
	
	
	
	//保存会议
    $("#save").click(function(){
    	
    	if($("input[name='meeting.meetingTime']").val()==""
    		||$("input[name='meeting.meetingPlace']").val()==""
    			||$("input[name='meeting.meetingName']").val()==""
    				||$("#userSele  option:selected").text()==""){
    		
    		alert("请填写完整会议信息");
    	}else{
    		//$("#myModal").display="none";
        	var projectId="";
            $("[name='projectIdList']").each(function(){
               projectId+=$(this).val()+",";//循环得到name为chk的值，至于是不是checkbox也无所谓。
            });
        	$.ajax({
        		
        		type : "post",
    			dataType : "json",
    			url : "saveMeeting.action",
    			data:{
    				
    				"id":projectId,
    				
    				"meeting.meetingTime":$("input[name='meeting.meetingTime']").val(),
    				"meeting.meetingPlace":$("input[name='meeting.meetingPlace']").val(),
    				"meeting.meetingName":$("input[name='meeting.meetingName']").val(),
    				"meeting.hostId":$("#userSele  option:selected").text(),
    				"meeting.remark":$("textarea[name='meeting.remark']").val(),
    			     },
    			success :function(status){
    				if(status){
    					alert("保存成功");
    					window.location.href="/Steap/toMeetingManagePage.action";
    					//$("#myModal").attr("data-dismiss","modal");
    				
    					
    				}
    				
    				//window.location="chooseProject.jsp";
    				
    			}
        		
        		
        	});
    	}
    	
    	
    	
    	
    });
    
    
  //取消按钮
	$("#quxiao").click(function(){
		
		 location.reload();
		//document.execCommand("Refresh");
		
	});
	
	
	//删除
	$("#mytable").on("click",".delPro", function(){
		
		var num = $(this).parent().siblings("td:eq(0)").text();
		
		 
		 $("#mytable tr").eq(num).remove();
		 var len = $('#mytable tr').length;
		   for(var i = 1;i<len;i++){
			$('#mytable tr:eq('+i+') td:first').html(i);
		  }
		
	});
	
	
	//导出报表
		$("#export").click(function() {
			
//			"projectCondition.projectName":$("input[name='projectCondition.projectName']").val(),
//			"projectCondition.applicant":$("input[name='projectCondition.applicant']").val(),
//			"projectCondition.domain":$("select[name='projectCondition.domain']").val(),
//			"projectCondition.projectFunds":$("select[name='projectCondition.projectFunds']").val(),
			
			//var params = getParams();
			
			window.location.href = "admin/meeting/printProjectInfo.jsp?projectName="
				+$("input[name='projectCondition.projectName']").val()+
				"&applicant="+$("input[name='projectCondition.applicant']").val()+
				"&domain="+$("select[name='projectCondition.domain']").val()+
				"&projectFunds="+$("select[name='projectCondition.projectFunds']").val();
		});
	  
		
	function fenYe( page){
		 $.ajax({
    		 type:"post",
    		 url:"searchProjectForPage.action",
    		 data:{
    			 "projectCondition.projectName":$("input[name='projectCondition.projectName']").val(),
			     "projectCondition.applicant":$("input[name='projectCondition.applicant']").val(),
				 "projectCondition.domain":$("select[name='projectCondition.domain']").val(),
				 "projectCondition.projectFunds":$("select[name='projectCondition.projectFunds']").val(),
				 "currentPages":page
    		 },
    		 dataType:"json",
    		 success:function(projectInfoResultList){
    		    $("#huiyiTab  tr:not(:first)").html("");
    			 for(var i=0;i<projectInfoResultList.length;i++){
    				 $("#huiyiTab").append(
    							"<tr>"+
   							
   							"<td>"+"<input type='checkbox'"+
   								"value='"+projectInfoResultList[i].projectId+","+projectInfoResultList[i].projectName+","+projectInfoResultList[i].applicant+","+projectInfoResultList[i].domain+","+projectInfoResultList[i].projectFunds+
   								"' name='chooseBox' /></td>"+
   							"<td>"+(i+1)+"</td>"+
   							"<td>"+projectInfoResultList[i].projectName+"</td>"+
    						"<td>"+projectInfoResultList[i].projectId+"</td>"+
    						"<td>"+projectInfoResultList[i].applicant+"</td>"+
    						"<td>"+projectInfoResultList[i].domain+"</td>"+
   							"<td>"+projectInfoResultList[i].recordDate+"</td>"+
    						"<td>"+projectInfoResultList[i].projectFunds+"</td>"+
   							"<td>"+projectInfoResultList[i].inspectDate+"</td>"+
   							"<td title='已现场考察'>"+"已考察"+"</td>"+
   							
    						"<td>"+"<a data-placement='bottom' title='查看' class='operation_icon' data-toggle='tooltip' href='LookProjectInfo.action?projectId="+projectInfoResultList[i].projectId+"' >"+
       								
        							"<i class='glyphicon glyphicon-search'></i></a>"+"</td>"+
    						"</tr>"
    						            				 
    				 );
    				 
    			 }
    		 }
    	 });		
	
	}
		
    //分页
	 myPaging();
	 
	 function myPaging(){
		 $("#demo1").myPagination({
	          currPage: $("#currentPages").val(),
	          pageCount: $("#totalPage").val(),
	          pageSize: 8,
	          ajax: {
	              on: false,
	              onClick: function(page) {
	            	 $("#currentPages").val(page);
	            	 fenYe(page);
	              }
	            }
	        });
		 
		}
		
    
	
});
