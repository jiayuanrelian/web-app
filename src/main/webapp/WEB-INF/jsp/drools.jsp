<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>华腾软件</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<!-- 导入easyui类库 -->
<link id="easyuiTheme" rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/default.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<!-- 导入ztree类库 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css"
	type="text/css" />
<script
	src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<script type="text/javascript">
	// 初始化ztree菜单
	$(function() {
		 var setting = {  
		            view: {  
		                selectedMulti: false        //禁止多点选中  
		            },  
		            data: { 
		                simpleData: {  
		                    enable:true,  
		                    idKey: "id",  
		                    pIdKey: "pid",  
		                    rootPId: ""  
		                }  
		            },  
		            callback: {
		            	onClick: zTreeOnClick
		            } 
		        };
		//分类菜单加载
		$.ajax({
			//ajax请求方式
		   type: "GET",
		   //ajax请求路径
		   url: '${pageContext.request.contextPath}/menuController/selectAllAccordionMenus.do',
		   //ajax请求预期返回数据格式
		   dataType:'JSON',
		   //ajax请求成功
		   success: function(data){
			   $.each(data, function(i, n){
				    var con ='<div style="padding:10px"><ul id="treeMenu'+i+'" class="ztree"></ul></div>';
					$('#accordion_menu').accordion('add', {
						title: n.name,
						content:'<div style="padding:10px"><ul id="treeMenu'+i+'" class="ztree"></ul></div>',
						iconCls:'icon-mini-add'
					});
					//ajax请求面板树节点数据
					$.ajax({
						url : '${pageContext.request.contextPath}/menuController/selectChildMenus.do',
						type : 'POST',
						data:{name:n.name},
						dataType : 'text',
						success : function(data) {
							var zNodes = eval("(" + data + ")");
							var treeNode = $("#treeMenu"+i);
							$.fn.zTree.init(treeNode, setting, zNodes);
						},
						error : function(msg) {
							alert('菜单加载异常!');
						}
					});
				});
		   },
		   //ajax请求失败
		   error:function(data){
			   $.messager.alert('警告','菜单加载失败！','error');
		   },
		});
		
	});
	<!--ztree树节点的点击事件-->
	function zTreeOnClick(event, treeId, treeNode, clickFlag){
		if (treeNode.click != false) {
			open(treeNode.name,treeNode.page);
		}
	}
	<!--添加tabs-->
	function open(text,url){
		if ($("#tabs").tabs('exists', text)) {
			$('#tabs').tabs('select', text);
		} else {
			var content = '<div style="width:100%;height:100%;overflow:hidden;">'
					+ '<iframe src="${pageContext.request.contextPath}/'
					+ url
					+ '" scrolling="auto" style="width:100%;height:100%;border:0;" ></iframe></div>';
			$('#tabs').tabs('add', {
				title : text,
				content : content,
				//href : url,
				closable : true
			});
		}
	};
	

 </script>
</head>
<body class="easyui-layout">

	<div data-options="region:'north',border:false"
		style="height:80px;padding:10px;background:url(${pageContext.request.contextPath }/images/header_bg.png);background-size:100%">
		<div id="sessionInfoDiv"
			style="position: absolute; right: 5px; top: 10px;">
			[<strong>${user.username }</strong>]，欢迎你！您使用[<strong>${pageContext.request.remoteAddr }</strong>]IP登录！
		</div>
		<div style="position: absolute; right: 5px; bottom: 10px;">
			<a href="javascript:void(0);" class="easyui-menubutton"
				data-options="menu:'#layout_north_pfMenu',iconCls:'icon-ok'">更换皮肤</a>
			<a href="javascript:void(0);" class="easyui-menubutton"
				data-options="menu:'#layout_north_kzmbMenu',iconCls:'icon-help'">控制面板</a>
		</div>
		<div id="layout_north_pfMenu" style="width: 120px; display: none;">
			<div onclick="changeTheme('default');">default</div>
			<div onclick="changeTheme('gray');">gray</div>
			<div onclick="changeTheme('black');">black</div>
			<div onclick="changeTheme('bootstrap');">bootstrap</div>
			<div onclick="changeTheme('metro');">metro</div>
		</div>
		<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
			<div onclick="editPassword();">修改密码</div>
			<div onclick="showAbout();">联系管理员</div>
			<div class="menu-sep"></div>
			<div onclick="logoutFun();">退出系统</div>
		</div>
	</div>
	<div data-options="region:'west',split:true,title:'菜单导航'"
		style="width: 200px">
		<div class="easyui-accordion" fit="true" border="false"
			id="accordion_menu">
			<!-- <div title="基本功能" data-options="iconCls:'icon-mini-add'" style="overflow:auto">
				<ul id="treeMenu" class="ztree"></ul>
			</div>
			<div title="系统管理" data-options="iconCls:'icon-mini-add'" style="overflow:auto">  
				<ul id="adminMenu" class="ztree"></ul>
			</div> -->
		</div>
	</div>
	<div data-options="region:'center'">
		<div id="tabs" fit="true" class="easyui-tabs" border="false">
			<div title="消息中心" id="subWarp"
				style="width: 100%; height: 100%; overflow: hidden">
				<iframe
					src="${pageContext.request.contextPath}/loginController/goWelcome.do"
					style="width: 100%; height: 100%; border: 0;"></iframe>
				<%--				这里显示公告栏、预警信息和代办事宜--%>
			</div>
		</div>
	</div>
	<!-- 
	<div data-options="region:'south',border:false"
		style="height:50px;padding:10px;background:url('./images/header_bg.png') no-repeat right;">
		<table style="width: 100%;">
			<tbody>
				<tr>
					<td style="width: 300px;">
						<div style="color: #999; font-size: 8pt;">
							华腾软件 | Powered by <a href="http://www.huateng.cn/">huateng.cn</a>
						</div>
					</td>
					<td style="width: *;" class="co1"><span id="online"
						style="background: url(${pageContext.request.contextPath }/images/online.png) no-repeat left;padding-left:18px;margin-left:3px;font-size:8pt;color:#005590;">在线人数:1</span>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	 -->
	<!--修改密码窗口-->
	<div id="editPwdWindow" class="easyui-window" title="修改密码"
		collapsible="false" minimizable="false" modal="true" closed="true"
		resizable="false" maximizable="false" icon="icon-save"
		style="width: 300px; height: 160px; padding: 5px; background: #fafafa">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<table cellpadding=3>
					<tr>
						<td>新密码：</td>
						<td><input id="txtNewPass" type="Password" class="txt01" /></td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td><input id="txtRePass" type="Password" class="txt01" /></td>
					</tr>
				</table>
			</div>
			<div region="south" border="false"
				style="text-align: right; height: 30px; line-height: 30px;">
				<a id="btnEp" class="easyui-linkbutton" icon="icon-ok"
					href="javascript:void(0)">确定</a> <a id="btnCancel"
					class="easyui-linkbutton" icon="icon-cancel"
					href="javascript:void(0)">取消</a>
			</div>
		</div>
	</div>
</body>
</html>