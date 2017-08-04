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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/default.css">
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
	$(function(){
		// 先将body隐藏，再显示，不会出现页面刷新效果
		$("body").css({visibility:"visible"});
		var cloumns=[[    
		               {field:'id',title:'实体编号',width:100,checkbox:true},    
		               {field:'name',title:'实体名称',width:100,align:'center'},    
		               {field:'identify',title:'实体标示',width:100,align:'center'},    
		               {field:'packageC',title:'实体包名',width:100,align:'center'},    
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
		               {field:'oprate',title:'操作',width:100,align:'center',formatter: function(value,rowData,index){
		            		    return '<a href="javascript:addProperty('+index+')" id="oprate" ></a>';  
		               }},    
		           ]];
		var toolbar=['     ',{
						iconCls: 'icon-add',
						text: '添加实体',
						handler: openAddEntity
					},'-',{
						iconCls: 'icon-remove',
						text: '删除实体',
						handler: deleteByBath
					}];
		$('#grid').datagrid({    
		    url:'${pageContext.request.contextPath}/gzEnityController/selectByPage.do',    
		    columns:cloumns,
		    toolbar:toolbar,
		    pagination:true,
		    pageList:[10,20,30],
		    fit:true,
		    fitColumns:true,
		    rownumbers:true,
		    loadMsg:'正在加载数据，请稍后....',
		    onLoadSuccess:function(data){
		        $('a[id="oprate"]').linkbutton({text:'添加属性',plain:true});
		    }
		});
		// 初始化添加实体窗口
		$('#addEntity').window({
            title: '添加实体',
            width: 400,
            modal: true,
            collapsible:false,
            maximizable:false,
            minimizable:false,
            shadow: true,
            closed: true,
            closable:false,
            height: 400,
            inline:true,
            resizable:true
        });
		//打开添加实体窗口
		function openAddEntity(){
			$('#enityForm').form('reset');
			$('#addEntity').window('open');
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
			        //alert('确认删除');
			        top.jQuery.messager.progress({
			    		text:'正在处理，请稍后...'
			    	});
			        $.ajax({
			        	type: "POST",
			        	url: "${pageContext.request.contextPath}/gzEnityController/deleteByBath.do",
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
       /*  $('#enityForm').form('submit',{
        	url:'${pageContext.request.contextPath }/gzEnityController/saveEntity.do',
            onSubmit:function(){
            	var isValid = $(this).form('validate');
        		if (!isValid){
        			$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
        			$.messager.alert('警告','提交表单包含非法数据，检查后重新提交！','warning');
        		}
        		return isValid;	// 返回false终止表单提交
            },
            success: function(data){
            	var data = eval('(' + data + ')');
            	//alert(data.success);
				$.messager.progress('close');	// 如果提交成功则隐藏进度条
				if (data.success) {
					$('#addEntity').window('close');
					$.messager.alert('消息',data.message,'info',function(){
						$('#grid').datagrid('load');
					});
				} else {
					$.messager.alert('消息',data.message,'error');
				}
			} 
        }); */
    	$.ajax({
    		   type: "POST",
    		   url: "${pageContext.request.contextPath }/gzEnityController/saveEntity.do",
    		   data: $("#enityForm").serialize(),
    		   beforeSend:function(XMLHttpRequest){
    			   var isValid = $("#enityForm").form('validate');
	           		if (!isValid){
	           			top.jQuery.messager.progress('close');	// 如果表单是无效的则隐藏进度条
	           			top.jQuery.messager.alert('警告','提交表单包含非法数据，检查后重新提交！','warning');
	           		}
	           		return isValid;	// 返回false终止表单提交
    		   },
    		   success: function(data){
    			    //var data = eval('(' + msg + ')');
	   				top.jQuery.messager.progress('close');	// 如果提交成功则隐藏进度条
	   				if (data.success) {
	   					$('#addEntity').window('close');
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
        $('#enityForm').form('clear');
        $('#addEntity').window('close');
    }
  //添加属性
	function addProperty(index){
	  	var rowdata = $('#grid').datagrid('getData').rows[index];
	  	//alert(rowdata.id+'--'+rowdata.name);
	  	$('#grid').datagrid('uncheckRow',index); 
		var jq = top.jQuery;    
        if (jq("#tabs").tabs('exists', rowdata.name+'属性管理')){    
            jq("#tabs").tabs('select', rowdata.name+'属性管理');
            var current_tab = jq("#tabs").tabs('getSelected');
			jq("#tabs").tabs('update',{
			     tab:current_tab,
			     options : {
			          content : '<iframe scrolling="auto" frameborder="0"  src="${pageContext.request.contextPath}/gzEntityItemController/goGzEnityItem.do?id='+rowdata.id+'" style="width:100%;height:100%;"></iframe>',
			     }
			});    
        } else {  
              var content = '<iframe scrolling="auto" frameborder="0"  src="${pageContext.request.contextPath}/gzEntityItemController/goGzEnityItem.do?id='+rowdata.id+'" style="width:100%;height:100%;"></iframe>';     
               jq("#tabs").tabs('add',{    
                                  title:rowdata.name+'属性管理',    
                                  content:content,    
                                  closable:true
                                });    
         }    
	}
</script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
    <form id="delForm" method="post">
	    <div region="center" border="false">
	    		<table id="grid"></table>
		</div>
    </form>
    <div class="easyui-window" style="top:20px" id="addEntity" >
        <div style="padding:10px 60px 20px 60px">
        <form id="enityForm" class="easyui-form" method="post">
            <table cellpadding="5">
                <tr>
                    <td>实体名称:</td>
                    <td><input class="easyui-validatebox" type="text" name="name" data-options="required:true,prompt:'请输入实体名称'"></input></td>
                </tr>
                <tr>
                    <td>实体标识名:</td>
                    <td><input class="easyui-validatebox" type="text" name="identify" data-options="required:true"></input></td>
                </tr>
                <tr>
                    <td>实体包全名:</td>
                    <td><input class="easyui-validatebox" type="text" name="packageC" data-options="required:true"></input></td>
                </tr>
                <tr>
                    <td>描述:</td>
                    <td><input class="easyui-validatebox" name="description" data-options="multiline:true" style="height:60px"></input></td>
                </tr>
            </table>
        </form>
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">取消</a>
        </div>
        </div>
    </div>
</body>
</html>