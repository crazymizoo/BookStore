
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>欢迎光临家庭医院</span>
    <a href="manager/bookServlet?action=page">签约信息管理</a>
    <a href="/doctor/pages/manager/order_manager.jsp">就诊管理</a>
<%--    <a href="index.jsp">家庭医生服务首页</a>--%>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
</div>