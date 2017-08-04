<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript">

</script>
<title>登录界面</title>
</head>
<body>
	<p>登录界面</p><br/>
	<form action="<%=request.getContextPath()%>/loginController/login.do" method="post">
		姓名：<input name="name" type="text"><br/>
		密码：<input name="password" type="password"><br/>
		<input type="submit" value="提交">
	</form>
</body>
</html>