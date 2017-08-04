<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>区域设置</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<!-- 导入easyui类库 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
<script
	src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<!-- 导入一键上传 js -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/ocupload/jquery.ocupload-1.1.2.js"></script>
<!-- 日期格式化 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/dataFormater/DataFormater.js"></script>
<script type="text/javascript">
	<!--写js代码-->
	var entityId = '';
	$(function(){
		if (entityId=='') {
			entityId = <%=request.getAttribute("id")%>;
			$("#typeId").val(entityId);
		}
		// 先将body隐藏，再显示，不会出现页面刷新效果
		$("body").css({visibility:"visible"});
		var cloumns=[[    
		               {field:'id',title:'实体属性编号',width:100,checkbox:true},    
		               {field:'name',title:'实体属性名称',width:100,align:'center'},    
		               {field:'field',title:'实体属性标示',width:100,align:'center'},    
		               {field:'entity',title:'实体名称',width:100,align:'center',formatter: function(value,row,index){
		            	   if (value) {
		            	   		return value.name;
							} else {
								return '';
							}
		               }},    
		               {field:'dateCreated',title:'创建时间',width:100,align:'center',formatter: function(value,row,index){
		            	   if (value) {
		            	   		return new Date(value).pattern("yyyy-MM-dd HH:mm:ss");
							} else {
								return '';
							}
		               }},    
		               {field:'dateUpdated',title:'修改时间',width:100,align:'center',formatter: function(value,row,index){
		            	   if (value) {
		            	   		return new Date(value).pattern("yyyy-MM-dd HH:mm:ss");
							} else {
								return '';
							}
		               }}, 
		           ]];
		var toolbar=['     ',{
						iconCls: 'icon-add',
						text: '添加实体属性',
						handler: openAddEntityItem
					},'-',{
						iconCls: 'icon-remove',
						text: '删除实体属性',
						handler: deleteByBath
					}];
		$('#grid').datagrid({    
		    url:'${pageContext.request.contextPath}/gzEntityItemController/selectByPage.do',    
		    columns:cloumns,
		    toolbar:toolbar,
		    pagination:true,
		    pageList:[10,20,30],
		    fit:true,
		    fitColumns:true,
		    rownumbers:true,
		    loadMsg:'正在加载数据，请稍后....',
		    queryParams: {entityId:entityId}
		});
		// 初始化添加实体窗口
		$('#addEntityItem').window({
            title: '添加实体属性',
            width: 400,
            modal: true,
            collapsible:false,
            maximizable:false,
            minimizable:false,
            shadow: true,
            closed: true,
            closable:true,
            height: 400,
            resizable:true
        });
		//打开添加实体窗口
		function openAddEntityItem(){
			$('#enityItemForm').form('reset');
			$('#addEntityItem').window('open');
		}
		//批量删除
		function deleteByBath(){
			var getSelections = $('#grid').datagrid('getSelections');
			if (getSelections.length == 0) {
				top.jQuery.messager.alert('消息','至少选中一条数据！','warning');
				return;
			}
			var ids = new Array();
			for (var int = 0; int < getSelections.length; int++) {
				ids.push(getSelections[int].id);
			}
			top.jQuery.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
			    if (r){    
			        top.jQuery.messager.progress({
			    		text:'正在处理，请稍后...'
			    	});
			        $.ajax({
			        	type: "POST",
			        	url: "${pageContext.request.contextPath}/gzEntityItemController/deleteEntityItem.do",
			        	data: {'ids':ids.join(',')},
			        	success: function(result) {
			        		top.jQuery.messager.progress('close');	// 如果提交成功则隐藏进度条
							if (result.success) {
								top.jQuery.messager.alert('消息',result.message,'info',function(){
									var pageopt = $('#grid').datagrid('getPager').data("pagination").options;
									var pageNumber = pageopt.pageNumber;
									var pageSize = pageopt.pageSize;
									$('#grid').datagrid('reload',{
										page:pageNumber,
										rows:pageSize
									});
								});
							} else {
								top.jQuery.messager.alert('消息',result.message,'error');
							}
			        	}
			        }); 
			    }    
			});  
		}
	});
	function submitForm(){
		top.jQuery.messager.progress({
    		text:'正在处理，请稍后...'
    	});
    	$.ajax({
 		   type: "POST",
 		   url: "${pageContext.request.contextPath }/gzEntityItemController/saveEntityItem.do",
 		   data: $("#enityItemForm").serialize(),
 		   beforeSend:function(XMLHttpRequest){
 			   		var isValid = $("#enityItemForm").form('validate');
	           		if (!isValid){
	           			top.jQuery.messager.progress('close');	// 如果表单是无效的则隐藏进度条
	           			top.jQuery.messager.alert('警告','提交表单包含非法数据，检查后重新提交！','warning');
	           		}
	           		return isValid;	// 返回false终止表单提交
 		   },
 		   success: function(data){
	   				top.jQuery.messager.progress('close');	// 如果提交成功则隐藏进度条
	   				if (data.success) {
	   					$('#addEntityItem').window('close');
	   					top.jQuery.messager.alert('消息',data.message,'info',function(){
	   						$('#grid').datagrid('reload');
	   					});
	   				} else {
	   					top.jQuery.messager.alert('消息',data.message,'error');
	   				}
 		   }
 		});
    }
	function clearForm(){
        $('#enityItemForm').form('clear');
    }
</script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
    <form id="delForm" method="post">
	    <div region="center" border="false">
	    		<table id="grid"></table>
		</div>
    </form>
     <div class="easyui-window" style="top:20px" id="addEntityItem" >
        <div style="padding:10px 60px 20px 60px">
        <form id="enityItemForm" class="easyui-form" method="post">
            <table cellpadding="5">
                <tr>
                    <td>实体属性名称:</td>
                    <td><input class="easyui-validatebox" type="text" name="name" data-options="required:true,prompt:'请输入实体名称'"></input>
                    	<input type="hidden" name="typeId" id="typeId">
                    	<input type="hidden" name="id" id="id">
                    </td>
                </tr>
                <tr>
                    <td>实体属性标识名:</td>
                    <td><input class="easyui-validatebox" type="text" name="field" data-options="required:true"></input></td>
                </tr>
                <tr>
                    <td>描述:</td>
                    <td><input class="easyui-validatebox" name="description" data-options="multiline:true" style="height:60px"></input></td>
                </tr>
            </table>
        </form>
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
        </div>
        </div>
    </div>
</body>
</html>