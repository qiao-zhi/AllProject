
	
	$(document).ready(function () {
		//资料编制

	    $("#bianzhiZL").click(function(){
	    
	    	var val=$('input:radio[name="oneChoose"]:checked').val();
	    	if(val==null){
				alert("请先选择一个会议，才能进入功能区");
				
			}else{
				 window.location="toMaterialManagePage.action?meeting.meetingId="+
				 val+"&meeting.meetingTime="+$('input:radio[name="oneChoose"]:checked').parent().siblings("td:eq(1)").text()+
				 "&meeting.meetingPlace="+$('input:radio[name="oneChoose"]:checked').parent().siblings("td:eq(2)").text();
			}
			
			
			 
	    	
	    });
	    
	    //召开会议
	    $("#zhaoKaiMeeting").click(function(){
	    	var val=$('input:radio[name="oneChoose"]:checked').val();
	    	if(val==null){
				alert("请先选择一个会议，才能进入功能区");
				
			}else{
				
				$.ajax({
					type : "post",
					dataType : "json",
					url : "conveneMeeting.action",
					data:{
						"meetingId":val
					},
					success:function(listMap){
						
						if(listMap.length>0){
							alert(listMap);
							location.reload();
						}
					}
					
				});
				
				
			}
	    });
	    
	    //通知企业
	    $("#informQY").click(function(){
	    	
	    	var val=$('input:radio[name="oneChoose"]:checked').val();
	    	if(val==null){
				alert("请先选择一个会议，才能进入功能区");
				
			}else{
				 window.location="enterNotify.action?meeting.meetingId="+
				 val+"&meeting.meetingTime="+$('input:radio[name="oneChoose"]:checked').parent().siblings("td:eq(1)").text()+
				 "&meeting.meetingPlace="+$('input:radio[name="oneChoose"]:checked').parent().siblings("td:eq(2)").text()+
				 "&meeting.meetingName="+$('input:radio[name="oneChoose"]:checked').parent().siblings("td:eq(0)").text();
			}
			
			
			
	    	
	    	
	    });
	    
	    //企业准备资料上传
	    $("#uploadZL").click(function(){
	    	
	    	var val=$('input:radio[name="oneChoose"]:checked').val();
	    	if(val==null){
				alert("请先选择一个会议，才能进入功能区");
				
			}else{
				 window.location="enterPreMaterial.action?meeting.meetingId="+
				 val+"&meeting.meetingTime="+$('input:radio[name="oneChoose"]:checked').parent().siblings("td:eq(1)").text()+
				 "&meeting.meetingPlace="+$('input:radio[name="oneChoose"]:checked').parent().siblings("td:eq(2)").text();
			}
			
			
	    	
	    	
	    });
	    
	    var tab=document.getElementById("commitTab");
		for(var i=0;i<tab.tBodies[0].rows.length;i++){
			var status=tab.tBodies[0].rows[i].getElementsByTagName('td')[4].innerHTML;
			
			var box=tab.tBodies[0].rows[i].getElementsByTagName("input")[0];
			var qianbi=tab.tBodies[0].rows[i].getElementsByTagName("a")[1];
			if(status=="准备中"){
				
				tab.tBodies[0].rows[i].disabled=false;
				box.disabled=false;
			}
			else{
				tab.tBodies[0].rows[i].disabled=true;
				box.disabled=true;
//				qianbi.href="";
			}
		}
		
		
		 //点击修改会议信息按钮
//		
			 
		 $("a[name='updateMeetingInfo2']").click(function(){
		
			 $("#meetingBox").find("input[name='meetingId4']").remove();
	    	 var meetingId = $(this).parent().siblings("td:eq(1)").find("input[name='meetingId2']").val();
	    	
	    	$("#meetingBox").append(
	    			"<input type='hidden' value='"+meetingId+"' name='meetingId4'/>"
	    	);
	       		  
	    	
	    	$.ajax({
	    		type : "post",
				dataType : "json",
				url : "getMeetingInfoById.action",
				data:{
					"meetingId":meetingId
				},
				success:function(map){
					
					$("input[name='meeting.hostId']").val(map["hostId"]);
					var count=$("#select_id").get(0).options.length;
					for(var i=0;i<count;i++){
					if($("#select_id").get(0).options[i].text == map["meetingStatus"])  
					{
					$("#select_id").get(0).options[i].selected = true;          
					break;  
					}  
					}
					//$("select[name='meeting.meetingStatus']").val(map["meetingStatus"]);
					$("input[name='meeting.meetingTime']").val(map["meetingTime"]);
					$("input[name='meeting.meetingPlace']").val(map["meetingPlace"]);
					$("input[name='meeting.meetingName']").val(map["meetingName"]);
					$("textarea[name='meeting.remark']").val(map["remark"]);
					
					
				}
	    		
	    		
	    	});
	    	
	    });
	  
		 
	    //保存修改后的会议信息
	   $("#updateMeetingInfo").click(function(){
		  
		   if(      $("input[name='meeting.hostId']").val()=="" 
			       
	    			|| $("input[name='meeting.meetingTime']").val()==""
	    			|| $("input[name='meeting.meetingPlace']").val()==""
	    			|| $("input[name='meeting.meetingName']").val()==""
	    			|| $("textarea[name='meeting.remark']").val()==""){
	    		alert("请填写完整修改信息");
	    	   		
	    	}else{
	    		
	  	      $.ajax({
	  	    		
	  	    		type : "post",
	  				dataType : "json",
	  				url : "updateMeetingInfo.action",
	  				data:{
	  					
	  					"meeting.meetingId":$("input[name='meetingId4']").val(),
	  					"meeting.hostId":$("input[name='meeting.hostId']").val(),
	  					"meeting.meetingStatus":$("select[name='meeting.meetingStatus']").val(),
	  					"meeting.meetingTime":$("input[name='meeting.meetingTime']").val(),
	  					"meeting.meetingPlace":$("input[name='meeting.meetingPlace']").val(),
	  					"meeting.meetingName":$("input[name='meeting.meetingName']").val(),
	  					"meeting.remark":$("textarea[name='meeting.remark']").val(),
	  				},
	  	            success:function(status){
	  	            	
	  	            	  alert("修改成功");
	  	            	 $("input[name='meeting.hostId']").val("");
		           	       
	          			 $("input[name='meeting.meetingTime']").val("");
	          			 $("input[name='meeting.meetingPlace']").val("");
	          			 $("input[name='meeting.meetingName']").val("");
	          			 $("textarea[name='meeting.remark']").val("");
	  	            	location.reload();
	  	            	}
	  	            });
	    	
	    	}
	    	
	    });
		
	   
	   //导出报表
	   function getParams() {
			var params = {};
			/*var meetingStatus = $("select[name='meetingCondition.meetingStatus']").val();
			if(meetingStatus != null && meetingStatus !="") {
				params.meetingStatus = meetingStatus;
			}
			
			var meetingTime = $("select[name='meetingCondition.meetingTime']").val();
			
			if(meetingTime != null && meetingTime != "") {
				params.meetingTime =meetingTime;
			}*/
			params.meetingStatus = "全部";
			params.meetingTime ="全部";	
			return params;
		}
		
		$("#export").click(function() {
			
//			var params = getParams();
//			window.location.href = "admin/meeting/printMeetingManage.jsp?" + params;
			window.location.href = "admin/meeting/printMeetingManage.jsp?meetingStatus="
			+$("#meetingStatuSearch").val()+"&meetingTime="+$("#meetingTimeSearch").val();
		});
	  
	   
		//分页
		 $(function() {
		     $("#demo1").myPagination({
		          currPage: $("#currentPages").val(),
		          pageCount: $("#totalPage").val(),
		          ajax: {
		              on: false,
		             
		              onClick: function(page) {
		            	
		            	 $("#currentPages").val(page);
		            	 	//$("#submitSearch").trigger("click"); 
		            	 	window.location="searchMeetingForPage.action?currentPages="+page;
		              }
		            }
		        });


		   }); 
	   
		
		
	});
	
	
