<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>签约信息管理</title>

	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			// 给删除的a标签绑定单击事件，用于删除的确认提示操作
			$("a.deleteClass").click(function () {
				// 在事件的function函数中，有一个this对象。这个this对象，是当前正在响应事件的dom对象。
				/**
				 * confirm是确认提示框函数
				 * 参数是它的提示内容
				 * 它有两个按钮，一个确认，一个是取消。
				 * 返回true表示点击了，确认，返回false表示点击取消。
				 */
				return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】?");
				// return false// 阻止元素的默认行为===不提交请求
			});
		});
	</script>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../doctor/static/img/logo.gif" >
			<span class="wel_word">签约信息管理系统</span>

		<%-- 静态包含 manager管理模块的菜单  --%>
		<%@include file="/pages/common/manager_menu.jsp"%>


	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>院名及专科</td>
				<td>挂号费用</td>
				<td>医生姓名</td>
				<td>资历（年）</td>
				<td>剩余号源</td>
				<td colspan="2">操作</td>
			</tr>		
<!--var表示当前遍历的每个对象都是book对象-->
			<c:forEach items="${requestScope.page.items}"  var="doctor">
				<tr>
					<td>${doctor.name}</td>
					<td>${doctor.price}</td>
					<td>${doctor.author}</td>
					<td>${doctor.sales}</td>
					<td>${doctor.stock}</td>
					<td><a href="manager/bookServlet?action=getBook&id=${doctor.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
					<td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${doctor.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/doctor_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加签约信息</a></td>
			</tr>	
		</table>


		<%--静态包含分页条--%>
		<%@include file="/pages/common/page_nav.jsp"%>




	</div>


	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>


</body>
</html>