<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>就诊管理</title>

	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>


</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../doctor/static/img/logo.gif" >
			<span class="wel_word">就诊管理系统</span>

		<%-- 静态包含 manager管理模块的菜单  --%>
		<%@include file="/pages/common/manager_menu.jsp"%>

	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>签约时间</td>
				<td>合同结束时间</td>
				<td>挂号费</td>
				<td>详情</td>
				<td>状态</td>
				
			</tr>		
			<tr>
				<td>2022/12/04</td>
				<td>2022/12/09</td>
				<td>90.00</td>
				<td><a href="#">查看详情</a></td>
				<td><a href="https://ada.baidu.com/site/qianhu.wejianzhan.com/xyl?imid=ad3d4b2a80101ad5876918ee77d9f2b7&source=05baidu-hy-yb-pc&jh=%7B%E8%A1%8C%E4%B8%9A%7D%E4%B8%80%E8%88%AC%E8%AF%8D&dy=%E5%92%A8%E8%AF%A2&kw=%E9%AA%A8%E7%A7%91%E5%8C%BB%E7%94%9F%E5%92%A8%E8%AF%A2&e_matchtype=2&e_creative=66514465810&e_keywordid=512385450067&bd_vid=nH6srHm1rH0dn101P1b1njnkPjPxnWcdg17xnH0sg1wxPWmdnHfYPWR3nH0#back1669530990606">进入就诊</a></td>
			</tr>	
			
			<tr>
				<td>2022/12/04</td>
				<td>2022/12/09</td>
				<td>20.00</td>
				<td><a href="#">查看详情</a></td>
				<td>就诊结束</td>
			</tr>	
			
			<tr>
				<td>2022/12/04</td>
				<td>2022/12/09</td>
				<td>190.00</td>
				<td><a href="#">查看详情</a></td>
				<td>等待就诊</td>
			</tr>		
		</table>
	</div>


	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>


</body>
</html>