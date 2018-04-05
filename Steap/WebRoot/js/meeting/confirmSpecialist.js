 
$(document).ready(function () {
//查看单个项目专家信息
	$("a[name='lookSpecialist']").click(function(){
        
		var useProjectId=$(this).parent().parent().find("td:eq(5)").find("input").val();
		
		// var useProjectId = $(this).parent().siblings("td:eq(5)").find("input[name='useProjectId']").val();
	   // alert(useProjectId);
		$.ajax({
			type : "post",
			dataType : "json",
			url : "lookSpecialist.action",
			data:{
				"myProjectId":useProjectId,
			},
			success:function(listSpecialist){
				
				
				
				   
				   var otab=document.getElementById("chakan");
				otab.tBodies[0].innerHTML="";
					for(var i=0;i<listSpecialist.length;i++){
						
					
						var _row=document.createElement("tr");
						
						
						var _td=document.createElement("td");
						_td.innerHTML=(i+1);
						_row.appendChild(_td);
						
						var _td=document.createElement("td");
						_td.innerHTML=listSpecialist[i].name;
						_row.appendChild(_td);
						
						var _td=document.createElement("td");
						_td.innerHTML=listSpecialist[i].workUnit;
						_row.appendChild(_td);
						
						var _td=document.createElement("td");
						_td.innerHTML=listSpecialist[i].engageDomain;
						_row.appendChild(_td);
						
						var _td=document.createElement("td");
						_td.innerHTML=listSpecialist[i].duty;
						_row.appendChild(_td);
						
						var _td=document.createElement("td");
						_td.innerHTML=listSpecialist[i].title;
						_row.appendChild(_td);
						
						var _td=document.createElement("td");
						_td.innerHTML=listSpecialist[i].telephone;
						_row.appendChild(_td);
						
						var _td=document.createElement("td");
						_td.innerHTML=listSpecialist[i].source;
						_row.appendChild(_td);
						
						
						otab.tBodies[0].appendChild(_row);						 
											
					} 
											
			}							
			
		});
			
		
	});
	
	
	//查看企业推荐专家
	
	 $("#tuijian").click(function(){
				
		 
		 //已存在的专家
		 var specialistID="";
			$("[name='specialistId']").each(function(){
				specialistID+=$(this).val()+",";//循环得到name为chk的值，至于是不是checkbox也无所谓。
			});
		 var tempID=specialistID.split(",");
		 
		 //推荐表里的专家
		 var specialistID2="";
			$("[name='specialist.specialistId']").each(function(){
				specialistID2+=$(this).val()+",";//循环得到name为chk的值，至于是不是checkbox也无所谓。
			});
		 var tempID2=specialistID2.split(",");
		
		
		 //如果专家已经在名单中，则不能再次选择
		 for(var i=0;i<tempID.length;i++){
			 for(var j=0;j<tempID2.length;j++){
				 if(tempID[i]==tempID2[j]){
					 
					document.getElementById(tempID2[j]).disabled=true;
					 
					 
				 }
				 
			 }
			 
		 }
		 
		 
		 
			
});
	
	 
	
	

	 
	 
	 
	 
	 
	
		//选择企业推荐专家时候的 “确定” 按钮事件
		$("#queding").click(function(){
			
			var num=parseFloat($("#yanshou tr:last").find("td:eq(0)").text());
			if(isNaN(num)){
				num=0;
			}
			
			var obj=document.getElementsByName("checkId"); 
			var s=''; 
			
			
			for(var i=0; i<obj.length; i++){ 
				
			if(obj[i].checked){
			      var s=obj[i].value; //如果选中，将value添加到变量s中 
			      var a= s.split(",");
			    //  var s=$("#yanshou").find("td:last").eq(1).html();
		        	 $("#yanshou").append(
		        			 "<tr> "+"<td>" + (++num)
		        			 + "</td>"
		        		
		        			 +"<td>" + a[1] +"<input type='hidden' name='source'"+ "value='"+a[7]+"'/>"+
		        			 "<input type='hidden' name='specialistId'"+"value='"+a[0]+"'/>"+  " </td>"
		        			 +"<td>" + a[2] +  " </td>"
		        			 +"<td>" + a[3] +  " </td>"
		        			 +"<td>" + a[4] +  " </td>"
		        			 +"<td>" + a[5] +  " </td>"
		        			 +"<td>" + a[6] +  " </td>"
		        			 +"<td>" + a[7] +  " </td>"
		        			// +<td> +  a[8] +  " </td>"
		        			 +"<td>" + 
		        			 /*"<a href='javaScript:void(0)' name='delYanShou' >删除</a>"*/
		        			 "<a href='javaScript:void(0)'  class='delYanShou' class='operation_icon' data-toggle='tooltip' data-placement='bottom' title='删除'><i class='glyphicon glyphicon-trash'></i></a>"
		        			 + " </td>"+
		        			
		        			 "</tr>"  
		        	 );
		        	s='';	
		        	
		         	obj[i].checked=false;
		        	//当用户选择完后，不能重复选择，因此将复选框设置为不可选
		        	obj[i].disabled=true;
			
			
			}
			}
			
			
			
			
			
		});
	 
	 
	 
	 
	 
	 
	 
	 
	//抽取专家 时的查询
	$("#searSpec").click(function(){
		
		var sel=document.getElementById("domainList");
		
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchSpecialist.action",
			data:{
				"name":$("input[name='name']").val(),
				"domain":sel.options[sel.selectedIndex].value,
				"currentPages": $("#currentPages").val(),
			},
			success:function(infoMap){
				fenye(infoMap["totalPage"]);
			  $("#specialist2  tr:not(:first)").html("");
			  var listSpecialist=infoMap["listSpecialist"];
			  
				for(var i=0;i<listSpecialist.length;i++){
					
					$("#specialist2").append(
							"<tr> "+
		        			 "<td>"  + "<input id='"+listSpecialist[i].specialistId+"' type='checkbox' name='checkId2'"+
		        			 " value='"+listSpecialist[i].specialistId+","
		        			 +listSpecialist[i].name+","
		        			 +listSpecialist[i].workUnit+","
		        			 +listSpecialist[i].engageDomain+","
		        			 +listSpecialist[i].duty+","
		        			 +listSpecialist[i].title+","
		        			 +listSpecialist[i].telephone+","
		        			 +listSpecialist[i].source+"'/>" 
		        			 + " </td>"
		        			 
		        			 +"<td>" + (i+1)+ "<input type='hidden' name='ChooseSpecialistId'"+"value='"+listSpecialist[i].specialistId+"'/>"
							  +"<input type='hidden' name='specialistId2'"+"value='"+listSpecialist[i].specialistId+"'/>"+"</td>"+
		        			 "<td>" + listSpecialist[i].name +  " </td>"+
		        			 "<td>" +listSpecialist[i].workUnit +  " </td>"+
		        			 "<td>" + listSpecialist[i].engageDomain +  " </td>"+
		        			 "<td>" +listSpecialist[i].duty+   " </td>"+
		        			 "<td>" + listSpecialist[i].title+  " </td>"+
		        			 "<td>" + listSpecialist[i].telephone +" </td>"+
		        			  
		        				
		        				
		        			/*"<td>"+"<a href='javaScript:void(0)' class='delStore' name='delKuZhong'>删除</a>"+"</td>"+*/
		        			
		        			
		        			 +"</tr>"  
					
					
					);
				} 
				$("#specialist2").append(
						"<tr style='display:none'><td>"+
						"<input type='text' value='"+infoMap['totalPage']+"'  id='totalPage'/>"+
        				"<input type='text' value='"+infoMap['currentPages']+"' id='currentPages'/>"+
        				"</td></tr>"
						
				);

				
				
				//如果查询出来的专家和已验收庄家名单里的一样，则不可选
				
				 //已存在的专家
				 var specialistID="";
					$("[name='specialistId']").each(function(){
						specialistID+=$(this).val()+",";
					});
				 var tempID=specialistID.split(",");
				
				 //从庄家库中得到的专家
				 var specialistID2="";
					$("[name='ChooseSpecialistId']").each(function(){
						specialistID2+=$(this).val()+",";
					});
					
				 var tempID2=specialistID2.split(",");
				
				 for(var i=0;i<tempID.length;i++){
					 for(var j=0;j<tempID2.length;j++){
						 if(tempID[i]==tempID2[j]){
							 
							document.getElementById(tempID2[j]).disabled=true;
							 
							 
						 }
						 
					 }
					 
				 }
				
				
			}
			
		});
		
		
		
		
		
		
	});

	

	
	
	
	
	
	//保存专家信息
	$("#baocun").click(function(){
		 
		
		var source="";
		$("[name='source']").each(function(){
			source+=$(this).val()+",";//循环得到name为chk的值，至于是不是checkbox也无所谓。
		});
       var array1=source.split(",");
       
     
       var specialistId="";
		$("[name='specialistId']").each(function(){
			specialistId+=$(this).val()+",";//循环得到name为chk的值，至于是不是checkbox也无所谓。
		});
       var array2=specialistId.split(",");
		
     

     
		$.ajax({
			type : "post",
			dataType : "json",
			url : "saveSpecialistRoster.action",
			data:{
				"meetingID":$("input[name='meetingId']").val(),
				"tempSource":source,
				"tempSpecialistId":specialistId,
				
			},
			success:function(status){
				if(status){
					alert("保存成功");
				}
			}
			
		
		});
		
	});
	 
	
	
	//点击抽取专家按钮
	$("#chouqu").click(function(){

var sel=document.getElementById("domainList");
		
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchSpecialist.action",
			data:{
				"name":$("input[name='name']").val(),
				"domain":sel.options[sel.selectedIndex].value,
				"currentPages": $("#currentPages").val(),
			},
			success:function(infoMap){
				fenye(infoMap["totalPage"]);
			  $("#specialist2  tr:not(:first)").html("");
			  var listSpecialist=infoMap["listSpecialist"];
			  
				for(var i=0;i<listSpecialist.length;i++){
					
					$("#specialist2").append(
							"<tr> "+
		        			 "<td>"  + "<input id='"+listSpecialist[i].specialistId+"' type='checkbox' name='checkId2'"+
		        			 " value='"+listSpecialist[i].specialistId+","
		        			 +listSpecialist[i].name+","
		        			 +listSpecialist[i].workUnit+","
		        			 +listSpecialist[i].engageDomain+","
		        			 +listSpecialist[i].duty+","
		        			 +listSpecialist[i].title+","
		        			 +listSpecialist[i].telephone+","
		        			 +listSpecialist[i].source+"'/>" 
		        			 + " </td>"
		        			 
		        			 +"<td>" + (i+1)+ "<input type='hidden' name='ChooseSpecialistId'"+"value='"+listSpecialist[i].specialistId+"'/>"
							  +"<input type='hidden' name='specialistId2'"+"value='"+listSpecialist[i].specialistId+"'/>"+"</td>"+
		        			 "<td>" + listSpecialist[i].name +  " </td>"+
		        			 "<td>" +listSpecialist[i].workUnit +  " </td>"+
		        			 "<td>" + listSpecialist[i].engageDomain +  " </td>"+
		        			 "<td>" +listSpecialist[i].duty+   " </td>"+
		        			 "<td>" + listSpecialist[i].title+  " </td>"+
		        			 "<td>" + listSpecialist[i].telephone +" </td>"+
		        			  
		        				
		        				
		        			/*"<td>"+"<a href='javaScript:void(0)' class='delStore' name='delKuZhong'>删除</a>"+"</td>"+*/
		        			
		        			
		        			 +"</tr>"  
					
					
					);
				} 
				$("#specialist2").append(
						"<tr style='display:none'><td>"+
						"<input type='text' value='"+infoMap['totalPage']+"'  id='totalPage'/>"+
        				"<input type='text' value='"+infoMap['currentPages']+"' id='currentPages'/>"+
        				"</td></tr>"
						
				);

				
				
				//如果查询出来的专家和已验收庄家名单里的一样，则不可选
				
				 //已存在的专家
				 var specialistID="";
					$("[name='specialistId']").each(function(){
						specialistID+=$(this).val()+",";
					});
				 var tempID=specialistID.split(",");
				
				 //从庄家库中得到的专家
				 var specialistID2="";
					$("[name='ChooseSpecialistId']").each(function(){
						specialistID2+=$(this).val()+",";
					});
					
				 var tempID2=specialistID2.split(",");
				
				 for(var i=0;i<tempID.length;i++){
					 for(var j=0;j<tempID2.length;j++){
						 if(tempID[i]==tempID2[j]){
							 
							document.getElementById(tempID2[j]).disabled=true;
							 
							 
						 }
						 
					 }
					 
				 }
				
				
			}
			
		});
		
	});
	
	
	
	 //抽取专家时的确定
	$("#save").click(function(){
       
	
		var obj=document.getElementsByName("checkId2"); 
		var s=''; 
		 
		var num=parseFloat($("#yanshou tr:last").find("td:first").text());
		if(isNaN(num)){
			num=0;
		}
		
		for(var i=0; i<obj.length; i++){ 
			
		if(obj[i].checked){
		      var s=obj[i].value; //如果选中，将value添加到变量s中 
		      var a= s.split(",");
		    
	        	 $("#yanshou").append(
	        			 
	        			
	        			 "<tr> "+"<td>" + (++num)
	        			  +"</td>"
	        		
	        			 +"<td>" + a[1] + "<input type='hidden' name='source'"+ "value='"+a[7]+"'/>"+
	        			 "<input type='hidden' name='specialistId'"+"value='"+a[0]+ "'/>"+" </td>"
	        			 +"<td>" + a[2] +  " </td>"
	        			 +"<td>" + a[3] +  " </td>"
	        			 +"<td>" + a[4] +  " </td>"
	        			 +"<td>" + a[5] +  " </td>"
	        			 +"<td>" + a[6] +  " </td>"
	        			/* +"<td>" + a[7] +  " </td>"*/
	        			// +<td> +  a[8] +  " </td>"
	        			 +"<td>" 
	        			 + 
	        			 "<a href='javaScript:void(0)' class='delYanShou' class='operation_icon' data-toggle='tooltip' data-placement='bottom' title='删除'><i class='glyphicon glyphicon-trash'></i></a>"
	        			/* "<a href='javaScript:void(0)' name='delYanShou' >删除</a>"*/
	        			 +  " </td>"+  
	        			 
	        			 "</tr>" 
	        	 );
	        	s='';	
	        	
	         	obj[i].checked=false;
	        	//当用户选择完后，不能重复选择，因此将复选框设置为不可选
	        	obj[i].disabled=true;
		
		
		}
		}
		
		
		
	}); 
	
	// 当页面刷新后，重新将企业推荐框中的复选框设置为可选状态
	 window.onunload = function upload(){
		
		var obj=document.getElementsByName("checkId"); 
		for(var i=0; i<obj.length; i++){ 
			if(!obj[i].checked){
				
				obj[i].disabled=false;
				
			}
		}
	};
	
	
	
	
	//删除会议确定的验收专家
	
	$("#yanshou").on("click",".delYanShou", function(){
		// $("a[name='delYanShou2']").click(function(){
			
			  var num = $(this).parent().siblings("td:eq(0)").text();
		       
		  
		       // var specialistID=document.getElementsByName("specialistId").item(num-1).value;
		       var specialistID = $(this).parent().siblings("td:eq(1)").find("input[name='specialistId']").val();
						
		        $.ajax({
								 
								 type:"post",
								 datype:"json",
								 data:{"meetingID":$("input[name='meetingId']").val(),
									
									"oneSpecialistId":specialistID,
									},
								 url:"delSpecialist.action",
								 success:function(status){
									 $("#yanshou tr").eq(num).remove();
									 var len = $('#yanshou tr').length;
									   for(var i = 1;i<len;i++){
										$('#yanshou tr:eq('+i+') td:first').html(i);
									  }
									alert("删除成功");
									
									
								 }
					});
		});
				
      
				
		

//企业推荐专家的删除
//$("#specTable").on("click",".delSpec", function(){
	 /*  $("a[name='delTuiJian']").click(function(){
		  
		   var num = $(this).parent().siblings("td:eq(0)").text();      
		   alert(num);   
		   $("input[name='specialist.specialistId']").each(function(){
			   alert($(this).val());
			   
		   });
		  // alert(document.getElementsByName("specialist.specialistId"));
	        var specialistID=document.getElementsByName("specialist.specialistId").item(num-1).value;
	    //   var specialistID = $(this).parent().siblings("td:eq(0)").find("input[name='specialist.specialistId']").val();
	       
	      alert("id: " + specialistID)
			  $.ajax({
					 
					 type:"post",
					 datype:"json",
					 data:{
						
						"oneSpecialistId":specialistID,
						},
					 url:"deleteRecommendSpecialist.action",
					 success:function(){
						 
							alert("删除成功");
							
							
							  						 
					 }
				 });
	    
			  $("#specTable tr").eq(num).remove();
				 var len = $('#specTable tr').length;
				   for(var i = 1;i<len;i++){
					$('#specTable tr:eq('+i+') td:first').html(i);
				  }
				  
			   
			
	   
	   });*/
	 		
      
				
		
				  
       
	   
	//});


//库中专家的删除
//$("#specialist2").on("click",".delStore", function(){
		
	/*$("a[name='delKuZhong']").click(function(){
		 var num = $(this).parent().siblings("td:eq(0)").text();
		 alert(num);
		 $("#specialist2 tr").eq(num).remove();
		 var len = $('#specialist2 tr').length;
		   for(var i = 1;i<len;i++){
			$('#specialist2 tr:eq('+i+') td:first').html(i);
		  }
		   var num = $(this).parent().siblings("td:eq(0)").text();
		    alert(num);
	        var a=num-1;
	       
	        var specialistID=document.getElementsByName("specialistId2").item(a).value;
	     
	     
		  $.ajax({
					 
					 type:"post",
					 datype:"json",
					 data:{
						
						"oneSpecialistId":specialistID,
						},
					 url:"deleteLibrarySpecialist.action",
					 success:function(){
						
						alert("删除成功");
					 }
				 });

	       
			
     });*/
	  
       
	   
	//});

		
	
	//取消按钮
	$("#quxiao").click(function(){
		 location.href="/Steap/toMeetingManagePage.action";
		
		
	});
	
	//分页
	function fenye( tp){
		
		$(function() {
		     $("#demo1").myPagination({
		          currPage: $("#currentPages").val(),
		          pageCount: tp,
		          ajax: {
		              on: false,
		             
		              onClick: function(page) {
		            	
		            	 $("#currentPages").val(page);
		            	 	$("#searSpec").trigger("click"); 
		            	 	//window.location="searchSpecForPage.action?currentPages="+page;
		              },
		             
		            }
		        });


		      }); 
			
	}
	
});
	