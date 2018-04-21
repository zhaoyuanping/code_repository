<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link rel="stylesheet" type="text/css" href="../js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../js/easyui/themes/icon.css">
<link href="../ueditor/utf8-jsp/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">

<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/common.js"></script>

<script type="text/javascript" charset="utf-8" src="../ueditor/utf8-jsp/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="../ueditor/utf8-jsp/umeditor.min.js"></script>
<script type="text/javascript" src="../ueditor/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
	<div id="win" style="width:880px;height:570px;display: none;" >
		 <div class="easyui-layout" data-options="fit:true">   
	        <div data-options="region:'north',split:true,border:false" style="height:480px">
	       		<form id="ff" method="post" enctype="multipart/form-data">   
	       			<input name="id" type="hidden">
				    <div style="margin-top: 10px;padding-left: 10px;">   
				        <label for="name" >公告标题:</label>   
				        <input id="title" class="easyui-validatebox" type="text" name="title" data-options="required:true" />   
				    </div>   
				    <div style="margin-top: 10px;padding-left: 10px;" id="upbackimg">   
				        <label for="file">展示图片:</label>   
				        <input id="file" class="easyui-filebox" name="file" style="width:300px">
				    </div>   
				    <div style="margin-top: 10px;padding-left: 10px;">   
				        <label for="content">公告内容:</label>   
			<!-- 		<div id="frolal" class="fr-view" style="width: 850px;"></div> -->
						 <script id="container" type="text/plain">
      						 
    					 </script>
				    </div> 
				    <div style="margin-top: 10px;padding-left: 10px;">   
				        <label for="status">是否顶置:</label>   
				        <select id="n-status" class="easyui-combobox" name="status" style="width:200px;">   
						    <option value="0">否</option>   
						    <option value="1">是</option>
						</select> 
				    </div> 
				</form>  
	        </div>   
	        <div data-options="region:'center'">   
           		<div style="padding-top: 10px;text-align: center;">
           			<a id="submit" href="#" class="easyui-linkbutton" data-options="">提交</a>  
           			<a id="cancel" href="#" class="easyui-linkbutton" data-options="" style="margin-left: 50px;">取消</a>  
           		</div>
	        </div>   
	    </div>   
	</div>  
	<div class="easyui-panel" data-options="border:false;">
		<table id="dg" style="height:500px"></table> 
	</div>
	<div id="imgwin" style="display: none;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'north',split:true,border:false" style="height:480px">
				<form id="iff"  method="post" enctype="multipart/form-data">
					<img id="bgimg" width="400" height="250">
					<span>
						<input id="_id" type="hidden" name="id">
						<input id="upimgs" name="file" type="file" style="display: none;">
						<a href="javascript:$('#upimgs').click();$('#upimgs').change(function(){$('#bgimg').attr('src',window.URL.createObjectURL(this.files[0]));$('#imgsubbut_').show();});">重新选择</a>
					</span>
					<span><a id="imgsubbut_" href="javascript:;" style="display: none;">提交</a></span>
				</form>
	        </div>  
		</div>
	</div>
</body>
<script type="text/javascript" src="../js/jsp/notice.js"></script>
<script type="text/javascript">
	$(function(){
		
		
		/* $('#frolal').froalaEditor({
			heightMin:250, 
		    heightMax:250,
			language:'zh_cn',
			toolbarButtons: ['fullscreen', 'bold', 'italic', 'underline', 'strikeThrough', 'subscript', 'superscript', '|', 'fontFamily', 'fontSize', 'color', 'inlineStyle', 'paragraphStyle', '|', 'paragraphFormat', 'align', 'formatOL', 'formatUL', 'outdent', 'indent', 'quote', '-', 'insertLink', 'insertImage', 'insertFile', 'insertTable', '|', 'emoticons', 'specialCharacters', 'insertHR', 'selectAll', 'clearFormatting', '|', 'print', 'html', '|', 'undo', 'redo'],      
			imageUploadURL:'../notice/fileUpload.do', //设置图片上传地址。
	       // imageManagerDeleteURL ：'/ delete_image' //设置图片删除地址。
		});
		$('#frolal').froalaEditor('image.align' , 'left' );  */
	});
</script>
</html>