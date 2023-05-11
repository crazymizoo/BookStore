<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>您的医生</title>

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
			<span class="wel_word">您的医生</span>

		<%--静态包含，登录 成功之后的菜单 --%>
		<%@ include file="/pages/common/login_success_menu.jsp"%>


	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>签约时间</td>
				<td>合同结束时间</td>
				<td>挂号费</td>
				<td>状态</td>
				<td>详情</td>
			</tr>		
			<tr>
				<td>2022.12.04</td>
				<td>2022.12.09</td>
				<td>10.00</td>
				<td>就诊中</td>
				<td><a href="#">查看详情</a></td>
			</tr>	
			
			<tr>
				<td>2022.12.04</td>
				<td>2022.12.09</td>
				<td>20.00</td>
				<td>等待中</td>
				<td><a href="#">查看详情</a></td>
			</tr>	
			
			<tr>
				<td>2022.12.04</td>
				<td>2022.12.09</td>
				<td>15.00</td>
				<td>已完成</td>
				<td><a href="#">查看详情</a></td>
			</tr>		
		</table>
		
	
	</div>


	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>


</body>
</html>