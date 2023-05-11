<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">

	<title>签约及结束时间</title>

	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>

	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 70px;
		}
	</style>

	<style type="text/css">
		h2 {
			text-align: center;
			margin-top: 20px;
			color: mediumpurple;
		}
	</style>
</head>

<body>

<div id="header">
	<img class="logo_img" alt="" src="../doctor/static/img/logo.gif" >
	<span class="wel_word">签约时间&合同结束时间</span>

	<%--静态包含，登录 成功之后的菜单 --%>
	<%@ include file="/pages/common/login_success_menu.jsp"%>



</div>

<div id="main">
		<body>
		<h1>签约时间</h1>
		<h2 id="displayDateTime"></h2>
		</body>
		<span style="color: mediumpurple">
		<script type="text/javascript">
			var today = new Date();
			var day = today.getDay();
			var daylist = ["Sunday","Monday","Tuesday","Wednesday ","Thursday","Friday","Saturday"];
			var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
			var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
			var dateTime = date+' '+time;
			document.getElementById("displayDateTime").innerHTML = dateTime + ' <br> Day :- ' + daylist[day];
		</script>
	</span>
		<body>
		<h1>合同到期时间</h1>
		<h2 id="displayDateTimeplus"></h2>
		</body>
		<span style="color: mediumpurple">
		<script type="text/javascript">
			var today = new Date();
			today.setDate(today.getDate()+5);
			var day = today.getDay();
			var daylist = ["Sunday","Monday","Tuesday","Wednesday ","Thursday","Friday","Saturday"];
			var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
			var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
			var dateTime = date+' '+time;
			document.getElementById("displayDateTimeplus").innerHTML = dateTime + ' <br> Day :- ' + daylist[day];
		</script>
	</span>

</div>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp"%>

</body>
</html>

</html>