<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.User" %>

<header>
    <nav>
        <a href="${pageContext.request.contextPath}/index.jsp">Home</a>
        <%
            User user = (User) session.getAttribute("user");
            if (user == null) {
        %>
        <a href="${pageContext.request.contextPath}/login.jsp">Login</a>
        <a href="${pageContext.request.contextPath}/signup.jsp">Sign Up</a>
        <%
        } else {
            if ("admin".equals(user.getRole())) {
        %>
        <a href="${pageContext.request.contextPath}/admin/admin_dashboard.jsp">Dashboard</a>
        <%
            }
        %>
        <a href="${pageContext.request.contextPath}/blood.jsp">Blood Availability</a>
        <a href="${pageContext.request.contextPath}/testcost.jsp">Test Costs</a>
        <a href="${pageContext.request.contextPath}/surgeons.jsp">Surgeons</a>
        <a href="${pageContext.request.contextPath}/organ.jsp">Organ Donation</a>
        <a href="${pageContext.request.contextPath}/assessment.jsp">Assessment</a>
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
        <%
            }
        %>
    </nav>
</header>
