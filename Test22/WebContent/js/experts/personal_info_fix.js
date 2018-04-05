$(function(){
//	function showChange(){
//		$("#old_img").hide();
//		$("#tip_label").hide();
//	}
//	$("#inputFile").click(function(){
//		$("#old_img").hide();
//		$("#tip_label").hide();
//	})

	var $columns = $(".column");
	var $columns2 = $(".column2");
	var $columns3 = $(".column3");
	var $columns4 = $(".column4");
	var $height = 0;
	var $height2 = 0;
	var $height3 = 0;
	var $height4 = 0;
	$columns.each(function(){
		if($(this).height() > $height){
			$height = $(this).height();
		}
	})
	$columns.height($height);
	$columns2.each(function(){
		if($(this).height() > $height2){
			$height2 = $(this).height();
		}
	})
	$columns2.height($height2);
	$columns3.each(function(){
		if($(this).height() > $height3){
			$height3 = $(this).height();
		}
	})
	$columns3.height($height3);
	$columns4.each(function(){
		if($(this).height() > $height4){
			$height4 = $(this).height();
		}
	})
	$columns4.height($height4);
	
	//修改密码提交
/*	$("#send_password").click(function(){
		//success
		//在模态框隐藏之前返回到主调函数中 （也就是，在触发 hidden.bs.modal 事件之前）。  有影响不？
		$("#fix_password_modal").modal('hide');
	})*/
//	隐藏的时候清空modal
	$('#fix_password_modal').on('hidden.bs.modal', function (e) {
 		$('#fix_password_modal input').val("");
	})
	
})

function setImagePreview(avalue) {
	var docObj;
	var imgObjPreview;
	var localImagObj;
	if(avalue==1){
		docObj=document.getElementById("headPortrait");
		imgObjPreview=document.getElementById("preview");
		localImagObj = document.getElementById("old_img");
	}
	if(avalue==2){
		docObj=document.getElementById("updheadPortrait");
		imgObjPreview=document.getElementById("updpreview");
		localImagObj = document.getElementById("updlocalImag");
	}
	if(docObj.files &&docObj.files[0]){
		//火狐下，直接设img属性
		imgObjPreview.style.display = 'block';
		imgObjPreview.style.width = '370px';
		imgObjPreview.style.height = '170px';
		//imgObjPreview.src = docObj.files[0].getAsDataURL();
		 
		//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
		imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
	}else{
		//IE下，使用滤镜
		docObj.select();
		var imgSrc = document.selection.createRange().text;
		var localImagId = localImagObj;
		//必须设置初始大小
		localImagId.style.width = "370px";
		localImagId.style.height = "170px";
		//图片异常的捕捉，防止用户修改后缀来伪造图片
		try{
			localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
			localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
		}catch(e){
			alert("您上传的图片格式不正确，请重新选择!");
			return false;
		}
		imgObjPreview.style.display = 'none';
		document.selection.empty();
	}
	return true;
}
function validatePic(flag){
	var filename = "";
	if(flag==1){
		filename = document.getElementById("headPortrait").value;
	}else{
		filename = document.getElementById("updheadPortrait").value;
	}
	if(filename!=""&filename!=null){
		var index1=filename.lastIndexOf(".");
		var index2=filename.length;
		var filetype=filename.substring(index1,index2);//后缀名
		if(filetype!=".bmp"&filetype!=".pcx"&filetype!=".tiff"&filetype!=".gif"&
			filetype!=".jpeg"&filetype!=".jpg"&filetype!=".png"){
			return 1;
		}else{
			return 2;
		}
	}else{
		return 3;
	}	
}