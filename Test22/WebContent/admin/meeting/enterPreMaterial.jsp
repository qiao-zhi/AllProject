<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<base href="<%=basePath %>">
	<title>企业准备资料上传</title>
	<script type="text/javascript" src="js/jquery.js" ></script>
	<script type="text/javascript" src="js/bootstrap.js" ></script>
	<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="css/public/main2.css" />
	<link rel="stylesheet" href="css/role1/modal.css" />
	 <link rel="stylesheet" href="css/role2/shangchuanziliao.css" /> 
	<link rel="stylesheet" href="css/public/fileinput.css" />
	<script type="text/javascript" src="js/public/fileinput.js" ></script>
	<script type="text/javascript" src="controls/fileUpload/ajaxfileupload.js"></script>
	<link rel="stylesheet" href="css/public/lightbox.css" />	
	<!-- <link rel="stylesheet" href="css/role2/ziliaobianzhi.css" /> -->
	<script type="text/javascript" src="js/public/main.js"></script>
	<link rel="stylesheet" href="controls/jQuery_TE/jquery-te-1.4.0.css" />
	<script type="text/javascript" src="controls/jQuery_TE/jquery-te-1.4.0.js" ></script>
	<script type="text/javascript" src="js/jquery-form.js"></script>
	<style type="text/css">
		#Modal1 .modal-dialog, #Modal2 .modal-dialog {
			width: 85%;
		}
		
		.jqte {
			border: 1px solid #CCC;
			outline: none;
			margin-left: 6%;
			margin-top: 0px;
			-webkit-box-shadow: none;
			-moz-box-shadow: none;
			-o-box-shadow: none;
			box-shadow: none;
		}
		.jqte_editor {
			height: 400px;
			resize: none;
		}
	</style>
</head>
<body>

	<jsp:include page="/admin/home/header.jsp"/>
	<a href="javaScript:void(0)" id="sidebar_btn_show" class="">
		<i class="glyphicon glyphicon-forward"></i>
	</a>
	<a href="javaScript:void(0)" id="sidebar_btn_hide">
		<i class="glyphicon glyphicon-backward"></i>
	</a>
	
	<div class="html_middle">
		<div class="menu_modal">		
			<jsp:include page="/admin/home/menu.jsp" />
		</div>
	
		<div class="main_body">
	<div class="bread">
		<ol class="breadcrumb">
		  <li class="active">验收会前准备</li>
		   <li><a href="toMeetingManagePage2.action">验收会议管理</a></li>
		  <li class="active">企业上传资料</a></li>
		</ol>	
	</div>
	<div class="outside_box table_box">
		<div class="strong">
			<label for="">会议信息</label>
		</div>
		<div class="hang">
			<div class="block">
				<label class="label_left none_border_radius">会议时间</label>
				<label class="label_right none_border_radius">${meeting.meetingTime}</label>
				<div class="clear"></div>
			</div>
		</div>
		<div class="hang">
			<div class="block">
				<label class="label_left none_border_radius pub_border_none">会议地点</label>
				<label class="label_right none_border_radius pub_border_none">${meeting.meetingPlace}</label>
				<div class="clear"></div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div class="outside_box table_box">
		<div class="strong">
			<label for="">项目信息</label>
		</div>
		
		<script type="text/javascript">
			$(document).ready(function(){
				/* 在点击查看验收意见初稿时的事件 */
				$(".operation_icon").click(function(){
					
					$("#enterpriseNameL").text($(this).parents("tr").children("td:eq(2)").text());
					$("#projectNameL").text($(this).parents("tr").children("td:eq(1)").text());
					
					$("#enterpriseNameL2").text($(this).parents("tr").children("td:eq(2)").text());
					$("#projectNameL2").text($(this).parents("tr").children("td:eq(1)").text());
					
					$("#enterpriseNameL3").text($(this).parents("tr").children("td:eq(2)").text());
					$("#projectNameL3").text($(this).parents("tr").children("td:eq(1)").text());
					
					$("#enterpriseNameL4").text($(this).parents("tr").children("td:eq(2)").text());
					$("#projectNameL4").text($(this).parents("tr").children("td:eq(1)").text());
					
					$("#enterpriseNameL5").text($(this).parents("tr").children("td:eq(2)").text());
					$("#projectNameL5").text($(this).parents("tr").children("td:eq(1)").text());
					
				});
				
				//查看真实性承诺书
				$("a[name='search3']").click(function(){
					/* 得到隐藏列中的当前项目Id */
					var $projectId_th = $("#projectId_th").index();
					var project_id = $(this).parents("tr").children().eq($projectId_th).text();
					getPicture(project_id);
				
				});
				
				//上传真实性承诺书
				$("a[name='upload2']").click(function(){
					
					var $projectId_th = $("#projectId_th").index();
					var project_id = $(this).parents("tr").children().eq($projectId_th).text();
					
					$("#promise").append(
				     "<input type='hidden' name='projectId' value='"+project_id+"'/>"		
					);
					
			     	
					
				});
				
				//上传验收意见初稿按钮
				/* $("#uploadMaterial").click(function(){
				
                     var fileName=$("#material").val();
			     	  
                 	var s=fileName.split(".");
                 	
                 	if(s[s.length-1]=="doc"||s[s.length-1]=="docx"){
                 		$.ajaxFileUpload({
			                
		                    url: "saveOpinionFile.action",                     
		                    type:"post",
		                    fileElementId: "material",
		                    data:{
		                    	"projectId":$("input[name='projectId']").val(),
		                    	"fileType":"验收意见初稿",
		                    	//"fileName":fileName,
		                    },
		                    dataType: "text", 
		                    success: function (saveResult){
		                    	                    	
		                    	if(saveResult){
		                    		var project_id = $("input[name='projectId']").val(); 	
		                    		getMateria2(project_id);
			                        alert("上传成功");
		                    	}
		           		                             
		                    	
		                    } ,
		                    error:function(){
		                    	alert("出错啦!");
		                    }		                  
		                });
                 	}else{
                 		alert("请选择正确的文件类型");
                 	}
                     
			         
			            
					
				}); */
				
				//上传真实性承诺书按钮
				$("#uploadMaterial2").click(function(){
				
                     var fileName=$("#material2").val();
                     var s=fileName.split(".");
                  	
                  	if(s[s.length-1]=="jpg"||s[s.length-1]=="png"||s[s.length-1]=="gif"
                  			||s[s.length-1]=="jpeg"||s[s.length-1]=="pcx"||s[s.length-1]=="pic"||s[s.length-1]=="png"){
                  		 $.ajaxFileUpload({
 			                
			                    url: "saveCommitment.action",                     
			                    type:"post",
			                    fileElementId: "material2",
			                    data:{
			                    	"projectId":$("input[name='projectId']").val(),
			                    	"fileType":"真实性承诺书",
			                    	//"fileName":fileName,
			                    },
			                    dataType: "text", 
			                    success: function (saveResult){
			                    	 
	                    			
			                        	  alert("上传成功");
			                             
			                    	
			                    }  
			                  
			                });
                  	}else{
                  		alert("请选择正确的图片类型");
                  	}
			         	
			           
					
				});
				
				
				//用户初选文件后的查询文件信息
				function getMateria2(project_id){
					
					$.ajax({
						type : "post",
						datatype : "json",
						url : "getMaterials.action",
						data : {
							projectId : project_id
						}, 
						success : function(material){
							
							$("#upFile  tr:not(:first)").empty("");
							
							if(material != null){

								$("#upFile").append(
									"<tr> <td>"
									+"<input type='hidden' name='filId' value='"+material.fileId+"'/>"
									+"<input type='hidden' name='projectId' value='"+project_id+"'/>"+material.originalName
									+ " </td><td> "
									+ material.uploadTime
									+ " </td><td> "
									+ material.fileSize
									+ " </td><td> "
									+ "<input id='path2' type='hidden' value='"+material.currentName+"'/>"
									+ "<a href='"+material.currentName+"'  class='operation_view' data-toggle='modal' data-placement='bottom' title='下载'><i class='glyphicon glyphicon-download'></i></a>&nbsp;&nbsp"
					    			+ "<a class='delFile2' href='javaScript:void(0)' class='operation_dele'  title='删除'><i class='glyphicon glyphicon-trash'></i></a>"
									+ " </td></tr>"		
							);
								
							};
					
							
						},
						error:function(){
							alert("出错啦");
						}
						
					});
				}
				
				/* ajax得到初审意见 */
				function getMateria(project_id){
					
				$.ajax({
					type : "post",
					datatype : "json",
					url : "getMaterials.action",
					data : {
						projectId : project_id
					}, 
					success : function(material){
						
						$("#watch  tr:not(:first)").empty("");
						
						if(material != null){

							$("#watch").append(
								"<tr> <td>"
								+"<input type='hidden' name='filId' value='"+material.fileId+"'/>"
								+"<input type='hidden' name='projectId' value='"+project_id+"'/>"+material.originalName
								+ " </td><td> "
								+ material.uploadTime
								+ " </td><td> "
								+ material.fileSize
								+ " </td><td> "
								+ "<input id='path' type='hidden' value='"+material.currentName+"'/>"
								+ "<a href='"+material.currentName+"'  class='operation_view' data-toggle='modal' data-placement='bottom' title='下载'><i class='glyphicon glyphicon-download'></i></a>&nbsp;&nbsp"
				    			+ "<a class='delFile' href='javaScript:void(0)' class='operation_dele'  title='删除'><i class='glyphicon glyphicon-trash'></i></a>"
								+ " </td></tr>"		
						);
							
						};
				
						
					},
					error:function(){
						alert("出错啦");
					}
					
				});
				}	
				
				//删除意见初稿
		/* 		$("#watch").on("click",".delFile",function(){
					
					$.ajax({
						url:"delateMaterial.action",
						type:"post",
						dateType:"json",
						data:{
							"fileId":$("#watch").find("input[name='filId']").val(),
							"path":$("#path").val()
							
							},
						success:function(delateStatus){
							if(delateStatus){
								$("#watch tr").eq(1).remove();
								alert("删除成功");
							}
							
						}
						
					});
				}) */
				
				//上传完意见初稿模态框中的删除
	/* 			$("#upFile").on("click",".delFile2",function(){
					
					$.ajax({
						url:"delateMaterial.action",
						type:"post",
						dateType:"json",
						data:{
							"fileId":$("#upFile").find("input[name='filId']").val(),
							"path":$("#path2").val()
							
							},
						success:function(delateStatus){
							if(delateStatus){
								$("#upFile tr").eq(1).remove();
								alert("删除成功");
							}
							
						}
						
					});
				}) */
				
				
					
			
				
				/* ajax得到真实性承诺书 */
				function getPicture(project_id){
					
					$.ajax({
						type : "post",
						datatype : "json",
						url : "getPictures.action",
						data : {
							projectId : project_id
						}, 
						success : function(pictureListMap){
							
						$("#pictureBox").empty();
						var divBox=$("#pictureBox");
						
					    for(var i=0;i<pictureListMap.length;i++){
					    	
							divBox.append(
									"<div class='delete-icon'>"+
									
									"<a id='"+project_id+","+pictureListMap[i].currentName+"' class='delPic' href='javaScript:void(0)' ><i class='glyphicon glyphicon-remove' title='删除'  ></i></a>"+
								    "</div>"+
							 "<a href='"+pictureListMap[i].currentName+"' data-lightbox = 'yaowei' class='box_siz' data-title='"+pictureListMap[i].originalName+"'>"+
					 		"<img src='"+pictureListMap[i].currentName+"' />"+
					 		/* "<span class='pic_info'>"+pictureListMap[i].originalName+"</span>"+ */
				 		    "</a>" 
				 		    
					 		/* "<a href='fileLibrary/originalFile/promiseFile/629e5b63-7773-45c7-bffe-96654a865850.jpg' data-lightbox = 'yaowei' class='box_siz' data-title='second pic'>"+
					 		"<img src='fileLibrary/originalFile/promiseFile/629e5b63-7773-45c7-bffe-96654a865850.jpg' />"+
					 		"<span class='pic_info'>"+pictureListMap[i].originalName+"</span>"+
				 		    "</a>" */
				 		);
									
							
								
					   };
					   //location.reload();	
					}
				});
			}	
				
			
				$("#pictureBox").on("click",".delPic",function(){
			       var currentName= $(this).attr("id");
			       
					var arry=currentName.split(",");
					
					var deletePictureName = $(this).parent().parent().children("a");
					var deletePictureName2 = $(this).parent().parent().children("div");
					
					
					
					$.ajax({
						type : "post",
						datatype : "json",
						url : "deletePictures.action",
						data : {
							"projectId2": arry[0],
							"currentName":arry[1]
						}, 
						success : function(status){
							
							if(status=="1"){
								alert("删除成功");
								deletePictureName.remove();
								deletePictureName2.remove();
							}else{
								alert("删除失败");
							}
							
						}
					});
				});
				
					
				$("button[name='close']").click(function(){
				  location.reload();
				});
			});
		
		</script>
		
		<table id="tab" class="table table-bordered table-hover mytable" style="margin-left:6%">
			<thead>
				<tr>
					<th>序号</th>
					<th>项目名称</th>
					<th>申请验收单位</th>
					<th>所属领域</th>
					<th>经费(万元)</th>
					<th id="projectId_th" class="hidden">项目编号</th>
					<th>验收意见初稿</th>
					<th>真实性承诺</th>
				</tr>
			</thead>
			<tbody class="word_center">
			<c:forEach var="projectPreMaterialInfo" varStatus="status"
					items="${projectPreMaterialInfo}">
					<tr>
					     <td><c:out value="${status.index+1}" /></td>	

						<td >${projectPreMaterialInfo['projectName']}</td>
						<td>${projectPreMaterialInfo['applicant']}</td>
						<td>${projectPreMaterialInfo['domain']}</td>
						<td>${projectPreMaterialInfo['projectFunds']}</td>
						<td name="xiangmuId" class="hidden">${projectPreMaterialInfo['projectId']}</td>
						
						<!------------c：if判断------------>						
						<td>
						<input type="hidden" value="${projectPreMaterialInfo.checkOpinion}"/>
						<c:if test="${projectPreMaterialInfo.checkOpinion eq false}">
							<a name="upload" href="#Modal2" class="operation_icon" data-toggle="modal" data-placement="bottom" title="上传"><i class="glyphicon glyphicon-upload"></i></a>							
						</c:if>
						<c:if test="${projectPreMaterialInfo.checkOpinion ne false}">
							<a name="search" href="#Modal1" class="operation_icon" data-toggle="modal" data-placement="bottom" title="查看"><i class="glyphicon glyphicon-search"></i></a>
						</c:if>
						</td>
						<!---------真实性承诺书----------------------->
						<td>
						<c:if test="${projectPreMaterialInfo.promise eq false}">
							<a name="upload2" href="#Modal4" class="operation_icon" data-toggle="modal" data-placement="bottom" title="上传"><i class="glyphicon glyphicon-upload"></i></a>							
						</c:if>
						<c:if test="${projectPreMaterialInfo.promise ne false}">
							<a name="search3" href="#Modal3" class="operation_icon" data-toggle="modal" data-placement="bottom" title="查看"><i class="glyphicon glyphicon-search"></i></a>
						</c:if>
						</td>
						<!------------c：if判断------------>
						
					   <!--  <td><a href="#Modal2" class="operation_icon" data-toggle="modal" data-placement="bottom" title="上传"><i class="glyphicon glyphicon-upload"></i></a></td> -->


					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div style="display: none;">
			<input type="text" id="projectId" />
		</div>
	</div>
	</div>
		<div class="clear"></div>
	</div>
	
	
	<jsp:include page="/admin/home/footer.jsp"></jsp:include>
	
	<!-- 查看意见初稿 -->
 	<div class="modal fade" id="Modal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 		 <div class="modal-dialog">
	   	 <div class="modal-content">
		      <div class="modal-header word_center">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">企业验收意见初稿查看</h4>
		      </div>
		      <div class="modal-body">
				 	<div class="outside_box table_box">
						<div class="strong">
							<label for="">会议信息</label>
						</div>
						<div class="hang">
							<div class="block">
								<label class="label_left none_border_radius zuoce">会议时间</label>
								<label class="label_right none_border_radius youce">${meeting.meetingTime}</label>
								<div class="clear"></div>
							</div>
						</div>
						<div class="hang">
							<div class="block">
								<label class="label_left none_border_radius pub_border_none zuoce">会议地点</label>
								<label class="label_right none_border_radius pub_border_none youce">${meeting.meetingPlace}</label>
								<div class="clear"></div>
							</div>
						</div>
					</div>
					<div class="outside_box table_box">
						<div class="strong">
							<label for="">企业信息</label>
						</div>
						<div class="hang">
							<div class="block">
								<label class="label_left zuoce">企业名称</label>
								<label class="label_right youce" id="enterpriseNameL"></label>
								<div class="clear"></div>
							</div>
						</div>
						<div class="hang">
							<div class="block">
								<label class="label_left one_border_radius pub_border_none zuoce">验收项目</label>
								<label class="label_right one_border_radius pub_border_none youce" id="projectNameL"></label>
								<div class="clear"></div>
							</div>
						</div>
					</div>
		     		<div class="outside_box table_box">
						<div class="strong">
							<label for="">验收意见初稿</label>
						</div>
						<textarea id="jqte_name2" placeholder="请把验收意见初稿的原件内容录入当前文本区域，并调整好格式..." style="width:94%; resize:none; margin-left:6%; outline:none; height:400px; border-radius:5px; border: 1px solid #CCC;" readonly ></textarea>		
						<div class="clear"></div>
					</div>	        
		      </div>
		      <div class="modal-footer">
		      	<button type="button" class="btn btn-primary modal_btn" id="clearOpinionContent">清除初稿</button>
		        <button name="close" type="button" class="btn btn-default modal_btn" data-dismiss="modal">退出</button>
		      </div>
	    </div>
	  	</div>
	</div>
	
	
	<!-- 查看真实性承诺书 -->
	<div class="modal fade" id="Modal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 		 <div class="modal-dialog">
	   	 <div class="modal-content">
		      <div class="modal-header word_center">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">企业真实性承诺书查看</h4>
		      </div>
		      <div class="modal-body">
				 	<div class="outside_box table_box">
						<div class="strong">
							<label for="">会议信息</label>
						</div>
						<div class="hang">
							<div class="block">
								<label class="label_left none_border_radius zuoce">会议时间</label>
								<label class="label_right none_border_radius youce">${meeting.meetingTime}</label>
								<div class="clear"></div>
							</div>
						</div>
						<div class="hang">
							<div class="block">
								<label class="label_left none_border_radius pub_border_none zuoce">会议地点</label>
								<label class="label_right none_border_radius pub_border_none youce">${meeting.meetingPlace}</label>
								<div class="clear"></div>
							</div>
						</div>
						<%-- <div class="hang">
							<div class="block">
								<label class="label_left none_border_radius pub_border_none zuoce">会议备注</label>
								<label class="label_right none_border_radius pub_border_none youce">${meeting.remark} </label>
								<div class="clear"></div>
							</div>
						</div> --%>
					</div>
					<div class="outside_box table_box">
						<div class="strong">
							<label for="">企业信息</label>
						</div>
						<div class="hang">
							<div class="block">
								<label class="label_left none_border_radius zuoce">企业名称</label>
								<label class="label_right none_border_radius youce" id="enterpriseNameL3"></label>
								<div class="clear"></div>
							</div>
						</div>
						<div class="hang">
							<div class="block">
								<label class="label_left none_border_radius pub_border_none zuoce">验收项目</label>
								<label class="label_right none_border_radius pub_border_none youce" id="projectNameL3"></label>
								<div class="clear"></div>
							</div>
						</div>
					</div>
					<div class="table_box outside_box">
					    <div class="strong">
							<label for="">真实性承诺书</label>
						</div>
					 
					    <div id="pictureBox" class="ligth_book"></div>
		      </div>
		      <div class="modal-footer">
		        <button name="close" type="button" class="btn btn-primary modal_btn" data-dismiss="modal">退出</button>
		      </div>
	    </div>
	  	</div>
	</div>
	</div>
	
	
	<!-- 上传验收资料界面-->
	<div class="modal fade" id="Modal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 		 <div class="modal-dialog">
	   	 <div class="modal-content">
		      <div class="modal-header word_center">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">验收意见初稿上传</h4>
		      </div>
		      <div class="modal-body">
	      		<div class="outside_box table_box">
					<div class="strong">
						<label for="">会议信息</label>
					</div>
					<div class="hang">
						<div class="block">
							<label class="label_left none_border_radius zuoce">会议时间</label>
							<label class="label_right none_border_radius youce">${meeting.meetingTime}</label>
							<div class="clear"></div>
						</div>
					</div>
					<div class="hang">
						<div class="block">
							<label class="label_left none_border_radius zuoce">会议地点</label>
							<label class="label_right none_border_radius youce">${meeting.meetingPlace}</label>
							<div class="clear"></div>
						</div>
					</div>
					<div class="hang">
						<div class="block">
							<label class="label_left none_border_radius zuoce">会议备注</label>
							<label class="label_right none_border_radius youce" style="min-height:36px;">${meeting.remark}</label>
							<div class="clear"></div>
						</div>
					</div>
				</div>
				<div class="outside_box table_box">
					<div class="strong">
						<label for="">企业信息</label>
					</div>
					<div class="hang">
						<div class="block">
							<label class="label_left none_border_radius zuoce">企业名称</label>
							<label class="label_right none_border_radius youce" id="enterpriseNameL2"></label>
							<div class="clear"></div>
						</div>
					</div>
					<div class="hang">
						<div class="block">
							<label class="label_left none_border_radius zuoce">验收项目</label>
							<label class="label_right none_border_radius youce" id="projectNameL2"></label>
							<div class="clear"></div>
						</div>
					</div>
				</div>		 	
	     		<div class="outside_box table_box">
					<div class="strong">
						<label for="">验收意见初稿</label>
					</div>
					<textarea id="jqte_name" placeholder="请把验收意见初稿的原件内容录入当前文本区域，并调整好格式..." style="width:94%; resize:none; margin-left:6%; outline:none; height:400px; border-radius:5px; border: 1px solid #CCC;" readonly ></textarea>
					<div class="clear"></div>
				</div>	        
		       <div class="modal-footer">
				<button type="button" class="btn btn-primary modal_btn" id="saveOpinionContent">保存</button>		       
		        <button name="close" type="button" class="btn btn-default modal_btn" data-dismiss="modal">退出</button>
		      </div> 
	    </div>
	  	</div>
	</div>
	</div>
	
	<!--上传 真实性承诺书界面-->
		<div class="modal fade" id="Modal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 		 <div class="modal-dialog">
	   	 <div class="modal-content">
		      <div class="modal-header word_center">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">真实性承诺书上传</h4>
		      </div>
		      <div class="modal-body">
		      		<div class="outside_box table_box">
						<div class="strong">
							<label for="">会议信息</label>
						</div>
						<div class="hang">
							<div class="block">
								<label class="label_left none_border_radius zuoce">会议时间</label>
								<label class="label_right none_border_radius youce">${meeting.meetingTime}</label>
								<div class="clear"></div>
							</div>
						</div>
						<div class="hang">
							<div class="block">
								<label class="label_left none_border_radius zuoce">会议地点</label>
								<label class="label_right none_border_radius youce">${meeting.meetingPlace}</label>
								<div class="clear"></div>
							</div>
						</div>
						<div class="hang">
							<div class="block">
								<label class="label_left none_border_radius zuoce">会议备注</label>
								<label class="label_right none_border_radius youce">${meeting.remark}</label>
								<div class="clear"></div>
							</div>
						</div>
					</div>
					<div class="outside_box table_box">
						<div class="strong">
							<label for="">企业信息</label>
						</div>
						<div class="hang">
							<div class="block">
								<label class="label_left none_border_radius zuoce">企业名称</label>
								<label class="label_right none_border_radius youce" id="enterpriseNameL5"></label>
								<div class="clear"></div>
							</div>
						</div>
						<div class="hang">
							<div class="block">
								<label class="label_left none_border_radius zuoce">验收项目</label>
								<label class="label_right none_border_radius youce" id="projectNameL5"></label>
								<div class="clear"></div>
							</div>
						</div>
					</div>		 	
					 <div class="table_box outside_box">
					    <div id="promise" class="strong">
							<label for="">真实性承诺书</label>
							 <span style="font-size:12px;color:red">(文件格式为jpg,png,gif,jpeg,pcx,pic)</span>	
						</div>
						<input class="" id="material2" type="file" name="materialFile2" style="margin-left:30px;float:left;height:36px;line-height:36px;border:1px solid #CCCCCC;"/>
					    <input class="btn btn-primary" id="uploadMaterial2" type="button" value="上传" style="height:36px;border-radius:0"/>
					    <div class="clear">
					    </div>   
		     		</div> 	        
		      <div class="modal-footer">
		        <button name="close" type="button" class="btn btn-default modal_btn" data-dismiss="modal">退出</button>
		       <!--  <button type="button" class="btn btn-primary modal_btn" data-dismiss="modal">保存</button> -->
		      </div>
	    </div>
	  	</div>
	</div>
	</div>
	<script type="text/javascript" src="js/public/lightbox.js" ></script>
	<script>
		$('#jqte_name').jqte();
		$('#jqte_name2').jqte();
		$(".jqte_toolbar:first").remove();
		$(".jqte_editor:first").attr("contenteditable", false);
		
			$('a[name=upload]').click(function() {
				var $projectId_th = $("#projectId_th").index();
				var project_id = $(this).parents("tr").children().eq($projectId_th).text();
				$("#projectId").val(project_id);
			});
		
			$("#saveOpinionContent").click(function() {
				var opinionContent = $(".jqte_editor:last").html();
				if (opinionContent == null || opinionContent == "") {
					alert("请先录入验收意见初稿，再进行保存!");
					return ;
				}
				
				var projectId = $("#projectId").val();
				
				$.ajax({
					url: 'insertOpinionContentAction.action',
					type: 'post',
					dataType: 'json',
					data: {
						'projectId': projectId,
						'material.opinionContent': opinionContent
					},
					success: function(result) {
						console.log("Inserting opinion content is ok!");
						
						if (result.success) {
							$(".jqte_editor:last").attr("contenteditable", false);
							alert("保存成功!点击退出按钮可退出当前模态框!");
							
							$("#saveOpinionContent").prop("disabled", "disabled");
							$("#projectId").val("");
						}
					},
					error: function(result) {
						console.log("Inserting opinion content is error!");
					}
				});
			});
			
			// 查看验收意见初稿
			$("a[name='search']").click(function(){
				
				var $projectId_th = $("#projectId_th").index();
				var project_id = $(this).parents("tr").children().eq($projectId_th).text();
				$("#projectId").val(project_id);
				
				$.ajax({
					url: 'findCheckOpinionContent.action',
					type: 'post',
					data: {
						'projectId': project_id 
					},
					dataType: 'json',
					success: function(result) {
						console.log("Finding check opinion content is ok!");
						if (result.success) {
							var material = result.material;
							if (material && material != null) {
								$(".jqte_editor:first").html(material.opinionContent);
							}
						}
					},
					error: function(result) {
						console.log("Finding check opinion content is error!");
					}
				});
			});
			
			// 清除验收意见初稿
			$("#clearOpinionContent").click(function() {
				if (confirm("确定清除验收意见初稿吗？一旦清除，不可恢复，\n需要点击退出后重新上传!")) {
					var projectId = $("#projectId").val();
					$.ajax({
						url: 'deleteCheckOpinionContent.action',
						type: 'post',
						data: {
							'projectId': projectId
						},
						dataType: 'json',
						success: function(result) {
							console.log("Deleting check opinion content is ok!");
							if (result.success) {
								$(".jqte_editor").html("");
								$("#saveOpinionContent").removeAttr("disabled");
								alert("验收意见初稿已经清除，如需上传，请点击\n退出按钮退出后再进行操作!");
							}
						},
						error: function(result) {
							console.log("Deleting check opinion content is error!");
						}
					});
				}
			});
	</script>
</body>
</html>
