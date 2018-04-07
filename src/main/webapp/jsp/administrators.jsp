<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link rel="stylesheet" type="text/css" href="../js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../js/easyui/themes/icon.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
</head>
<body>
	<table id="tt" style="height:500px"></table>  
	<div id="winpwd" style="width:880px;height:570px;display: none;" >
		 <div class="easyui-layout" data-options="fit:true">   
	        <div data-options="region:'north',split:true,border:false" style="height:130px">
	       		<form id="pwdff" method="post" style="margin-left: 15px;" >
					<div style="margin-top: 8px;">   
				        <label for="password">&nbsp;新&nbsp;密&nbsp;码:</label>   
				        <input id="password" class="easyui-passwordbox" type="text" name="password"  data-options="required:true" missingMessage="密码不能空"/>   
				    </div>   
				    <div style="margin-top: 8px;">   
				        <label for="passwords">再次确认:</label>   
				        <input class="easyui-passwordbox" type="text" name="passwords" required="required" validType="equals['#password']" missingMessage="密码不能空"/>   
				    </div>  
				</form>
	        </div>   
	        <div data-options="region:'center'">   
           		<div style="padding-top: 10px;text-align: center;">
           			<a id="uppwdsubmit" href="#" class="easyui-linkbutton" >提交</a>  
           			<a id="uppwdcancel" href="#" class="easyui-linkbutton" style="margin-left: 50px;">取消</a>  
           		</div>
	        </div>   
	    </div>   
	</div>  
	<div id="win" style="width:880px;height:570px;display: none;" >
		 <div class="easyui-layout" data-options="fit:true">   
	        <div data-options="region:'north',split:true,border:false" style="height:130px">
	       		<form id="upff" method="post" style="margin-left: 15px;" >
	       			<input id="" class="easyui-textbox" type="hidden" name="id" style="display: none;"/>   
					<div style="margin-top: 8px;">   
				        <label for="phone">联系电话:</label>   
				        <input id="" class="easyui-textbox" type="text" name="phone"  />   
				    </div>   
				    <div style="margin-top: 8px;">   
				        <label for="email">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</label>   
				        <input class="easyui-textbox" type="text" name="email" />   
				    </div>  
				    <div style="margin-top: 8px;">   
				        <label for="status">是否禁用:</label>   
				        <select id="cc" class="easyui-combobox" name="status" style="width:200px;">   
						    <option value="1">启用</option>   
						    <option value="0">禁用</option>   
						</select>  
				    </div>   
				</form>
	        </div>   
	        <div data-options="region:'center'">   
           		<div style="padding-top: 10px;text-align: center;">
           			<a id="upsubmit" href="#" class="easyui-linkbutton" >提交</a>  
           			<a id="upcancel" href="#" class="easyui-linkbutton"  style="margin-left: 50px;">取消</a>  
           		</div>
	        </div>   
	    </div>   
	</div>  
	
	<div id="addwin" style="width:880px;height:570px;display: none;" >
		 <div class="easyui-layout" data-options="fit:true">   
	        <div data-options="region:'north',split:true,border:false" style="height:180px">
	       		<form id="addff" method="post" style="margin-left: 15px;">
	       			<div style="margin-top: 8px;">   
				        <label for="username">用&nbsp;户&nbsp;名:</label>   
				        <input id="username" maxlength="12" class="easyui-validatebox" type="text" name="username" 
				        data-options="required:true" missingMessage="用户名不能空"/>   
				    </div>  
				    <div style="margin-top: 8px;">   
				        <label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label>   
				        <input id="" class="easyui-passwordbox" type="text" name="password" data-options="required:true"  missingMessage="密码不能空"/>   
				    </div>  
					<div style="margin-top: 8px;">   
				        <label for="phone">联系电话:</label>   
				        <input id="" class="easyui-validatebox" type="text" name="phone" data-options="validType:'phoneNum'"/>   
				    </div>   
				    <div style="margin-top: 8px;">   
				        <label for="email">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</label>   
				        <input class="easyui-textbox" type="text" name="email" data-options="validType:'email'" invalidMessage="请输入正确的邮箱" missingMessage="请输入正确的邮箱"/>   
				    </div>  
				    <div style="margin-top: 8px;">   
				        <label for="status">是否禁用:</label>   
				        <select id="cc" class="easyui-combobox" name="status" style="width:200px;">   
						    <option value="1">启用</option>   
						    <option value="0">禁用</option>   
						</select>  
				    </div>   
				</form>
	        </div>   
	        <div data-options="region:'center'">   
           		<div style="padding-top: 10px;text-align: center;">
           			<a id="addsubmit" href="#" class="easyui-linkbutton" >提交</a>  
           			<a id="addcancel" href="#" class="easyui-linkbutton" style="margin-left: 50px;">取消</a>  
           		</div>
	        </div>   
	    </div>   
	</div>  
</body>	
<script type="text/javascript" src="../js/jsp/administrators.js"></script>
</html>