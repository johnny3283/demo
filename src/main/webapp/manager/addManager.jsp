<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.manager.model.*" %>

<%
    ManagerVO mgrVO = (ManagerVO) request.getAttribute("ManagerVO");
%>

<html>
<head>

    <title>sign up</title>
    <style>
        #content {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }

        #form {
            display: flex;
            justify-content: center;
            flex-direction: column;
            border-radius: 0.6rem;
            border: 3px solid #ccc;
            width: 600px;
            height: 300px;
            border-style: outset;
        }
    </style>

</head>
<body>
<%@ include file="../navbar.file" %>
<br>
<c:if test="${not empty errorMsgs}">
    <font style="color: red">請修正以下錯誤:</font>
    <ul>
        <c:forEach var="message" items="${errorMsgs}">
            <li style="color: red">${message}</li>
        </c:forEach>
    </ul>
</c:if>
<div id="content">

    <FORM METHOD="post" ACTION="ManagerServlet" name="form1">
        <div id="form">
            <h2 class="active">新增管理員:</h2>
            <div style="margin: 0px auto;">員工帳號:
                <input type="TEXT" name="managerAccount" size="45"
                       value="<%=(mgrVO == null) ? "" : mgrVO.getManagerAccount()%>"/></div>
            <div style="margin: 0px auto;">員工密碼:
                <input type="password" name="managerPassword" size="45"
                       value="<%=(mgrVO == null) ? "" : mgrVO.getManagerPassword()%>"/></div>
            <div style="margin: 0px auto;">員工姓名:
                <input type="TEXT" name="managerName" size="45"
                       value="<%=(mgrVO == null) ? "" : mgrVO.getManagerName()%>"/></div>
            <div style="margin: 0px auto;">員工IP:
                <input type="TEXT" name="managerIp" size="45"
                       value="<%=(mgrVO == null) ? "" : mgrVO.getManagerIp()%>"/></div>
            <div style="margin: 0px auto;">
                <input type="hidden" name="action" value="insert">
                <input type="submit" value="新增" id="submit" style="border-radius:1rem; border: 1px solid #ccc;">
            </div>
        </div>
    </FORM>
</div>
</body>

</html>