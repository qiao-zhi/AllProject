$(document).ready(function () {
	
	
	//“创建会议”按钮事件
	$("#create").click(function(){
		
		window.location = "toChooseProjectPage.action";
	});
	
	
	
	//通知相关人员按鈕
	$("#tongzhi").click(function(){
		
		var val=$('input:radio[name="oneChoose"]:checked').val();
		if(val==null){
			alert("请先选择一个会议，才能进入功能区");
			
		}else{
			 window.location="institutionNotify.action?meetingId="+
			 val+"&meeting.meetingTime="+$('input:radio[name="oneChoose"]:checked').parent().siblings("td:eq(1)").text()+
			 "&meeting.meetingPlace="+$('input:radio[name="oneChoose"]:checked').parent().siblings("td:eq(2)").text()+
			 "&meeting.remark="+$('input:radio[name="oneChoose"]:checked').parent().siblings("td:eq(2)").find("input[name='meetingRemark']").val();
		}
	
		
		
		
	});
	
	
	
	 //确定验收专家按钮
$("#engineer").click(
		function() {

		

		var val=$('input:radio[name="oneChoose"]:checked').val();
		
		if(val==null){
			alert("请先选择一个会议，才能进入功能区");
		}else{
			 window.location="toChooseSpecialistPage.action?meeting.meetingId="+
			 val+"&meeting.meetingTime="+$('input:radio[name="oneChoose"]:checked').parent().siblings("td:eq(1)").text()+
			 "&meeting.meetingPlace="+$('input:radio[name="oneChoose"]:checked').parent().siblings("td:eq(2)").text()+
			 "&meeting.remark="+$('input:radio[name="oneChoose"]:checked').parent().siblings("td:eq(2)").find("input[name='meetingRemark']").val();
		}
		
		
		});
		 
		
	
    
    //起草会议通知
    $("#write").click(function(){
   
    	var val=$('input:radio[name="oneChoose"]:checked').val();
    	if(val==null){
			alert("请先选择一个会议，才能进入功能区");
			
		}else{
			var params = "ReportServer?reportlet=meetingAgenda.cpt&meetingId=" + val;
			window.location.href = params;
			/* window.location="toCreateNotifyPage.action?meeting.meetingId="+
			 val+"&meeting.meetingTime="+$('input:radio[name="oneChoose"]:checked').parent().siblings("td:eq(1)").text()+
			 "&meeting.meetingPlace="+$('input:radio[name="oneChoose"]:checked').parent().siblings("td:eq(2)").text()+
			 "&meeting.remark="+$('input:radio[name="oneChoose"]:checked').parent().siblings("td:eq(2)").find("input[name='meetingRemark']").val();*/
		}
		
		 
    	
    })
    
    
    /**
     * @modifier yachao
     * @time 2016/02/01
     * @description 修改会议信息时，应该将原有信息加载。
     * 
     */
    //点击修改会议信息按钮
    $("a[name='updateMeetingInfo2']").click(function(){
    
    	$("#meetingBox").find("input[name='meetingId3']").remove();
    	 var meetingId = $(this).parent().siblings("td:eq(1)").find("input[name='meetingId2']").val();
    	 console.log("meetingId:", meetingId);
    	
    	$("#meetingBox").append(
    			"<input type='hidden' value='"+meetingId+"' name='meetingId3'/>"
    	);
    	
    	$.ajax({
    		type : "post",
			dataType : "json",
			url : "getMeetingInfoById.action",
			data:{
				"meetingId":meetingId
			},
			success:function(map){
			
				
				
				
				//会议主持人二级联动
				 $.ajax({
		  				type : "post",
		  				dataType : "json",
		  				url : "getAllUsers.action",
		  				success : function(result){
		  					testJson = $.parseJSON(result);
							json = testJson[0];
							
							getUserList(json);
							
							
							var str="";
							//判断 并显示已经创建的会议主持人
				  			for(var key in json){
				  				
				  			   var array=json[key];
				  			
				  			   for(var i=0;i<array.length;i++){
				  				 
				  				
				  				   if(array[i].name==map["hostId"]){
				  					
				  					 $("#unitSele").val(key);
				  					var user = document.getElementById("userSele");
						  				
						  				
						  				//0 每次添加市之前,清空市的下拉选
						  				//1. 获得用户选择的省
						  				var pronvinceKey =  $("#unitSele").val();
						  				//2. 根据选择的省去json中取得对应 市数组
						  				var cities = json[pronvinceKey];
						  				//3. 遍历数组中的所有市,封装到option对象中
						  				for(var i=0; i<cities.length; i++){
						  					var option2 = document.createElement("option");
						  					var option = user.appendChild(option2);
						  					option.innerHTML = cities[i].name;
						  					option.value = cities[i].userId;
						  				}
						  				
						  				
						  				
						  				  					
				  					    $("#userSele option:selected").text(map["hostId"]);
				  					 
				  				   }
				  			   }
				  				
							}
				  			
				  			
				  			
                             
							
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
			  					option.value = key;
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
		  			
		  	
				
				
				/**
				 * @modifier yachao
				 * @time 2016/02/01
				 * @description 鉴于项目负责人不可更改会议状态，故去掉会议状态的选择框设置
				 */
//				var count = ($("#select_id"))[0].options.length;
//				for(var i = 0; i < count; i++){
//					if($("#select_id").get(0).options[i].text == map["meetingStatus"]) {
//						$("#select_id").get(0).options[i].selected = true;          
//						break;  
//					}  
//				}
		  			
//				$("select[name='meeting.meetingStatus']").val();
				$("input[name='meeting.meetingTime']").val(map["meetingTime"]);
				$("input[name='meeting.meetingPlace']").val(map["meetingPlace"]);
				$("input[name='meeting.meetingName']").val(map["meetingName"]);
				$("textarea[name='meeting.remark']").val(map["remark"]);
				
				
			}
    		
    		
    	});
       		    	
    	
    });
	 
	 
    //保存修改后的会议信息
   $("#updateMeetingInfo").click(function(){
	   
	   if( $("#userSele  option:selected").text()=="" 
			|| $("input[name='meeting.meetingTime']").val()==""
			|| $("input[name='meeting.meetingPlace']").val()==""
			|| $("input[name='meeting.meetingName']").val()==""){
		alert("请填写完整修改信息");
	   		
	}else{
		
		  $.ajax({
	    		
	    		type : "post",
				dataType : "json",
				url : "updateMeetingInfo.action",
				data:{
					
					"meeting.meetingId":$("input[name='meetingId3']").val(),
					"meeting.hostId":$("#userSele  option:selected").text(),
					"meeting.meetingStatus":$("select[name='meeting.meetingStatus']").val(),
					"meeting.meetingTime":$("input[name='meeting.meetingTime']").val(),
					"meeting.meetingPlace":$("input[name='meeting.meetingPlace']").val(),
					"meeting.meetingName":$("input[name='meeting.meetingName']").val(),
					"meeting.remark":$("textarea[name='meeting.remark']").val(),
				},
	            success:function(status){
	            	  alert("修改成功");
	            	  
	            	  //$("select[name='meeting.meetingStatus']").val("");
	           	          $("#unitSele").empty();
	           	          $("#userSele").empty();
	          			 $("input[name='meeting.meetingTime']").val("");
	          			 $("input[name='meeting.meetingPlace']").val("");
	          			 $("input[name='meeting.meetingName']").val("");
	          			 $("textarea[name='meeting.remark']").val("");
	            	  
	            	  location.reload();
	            	}
	            });
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
			qianbi.href="";
		}
	}
	
   //导出报表
   function getParams() {
		var params = {};
	
		params.meetingStatus = $("#meetingStatuSearch").val();
		params.meetingTime =$("#meetingTimeSearch").val();
		return params;
	}
	
	$("#export").click(function() {
		
//		var params = getParams();
		console.log("admin/meeting/printMeetingManage.jsp?meetingStatus="
				+$("#meetingStatuSearch").val()+"&meetingTime="+$("#meetingTimeSearch").val());
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
            	 	window.location="searchMeetingForPage2.action?currentPages="+page;
              }
            }
        });


      }); 
	
	
 
		
});