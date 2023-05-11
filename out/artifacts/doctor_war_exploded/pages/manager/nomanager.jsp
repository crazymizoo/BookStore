<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>权限受限！！</title>

	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>


	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../doctor/static/img/logo.gif" >
			<span class="wel_word">禁止进入！！</span>

		<%-- 静态包含 manager管理模块的菜单  --%>
		<%@include file="/pages/common/nomanager_menu.jsp"%>


	</div>
	
	<div id="main">
		<h1>抱歉~您不符合管理员要求，没有权限访问呢~</h1>
	</div>


	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>


</body>
</html>