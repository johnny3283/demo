<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.mem.model.*" %>

<%
    MemberVO MemberVO = (MemberVO) request.getAttribute("memberVO");
%>

<html>
<head>

    <title>sign up</title>
    <link type="text/css"
          href="<%=request.getContextPath()%>/css/form.css" rel="stylesheet">
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->
        <h3 class="active"> 會員註冊 </h3><br>


        <%-- 錯誤表列 --%>
        <c:if test="${not empty errorMsgs}">
            <font style="color: red">請修正以下錯誤:</font>
            <ul>
                <c:forEach var="message" items="${errorMsgs}">
                    <li style="color: red">${message}</li>
                </c:forEach>
            </ul>
        </c:if>

        <FORM METHOD="post" ACTION="MemberServlet" name="form1">
            <input type="TEXT" name="memberAccount" size="45"
                   class="fadeIn second" placeholder="account"
                   value="<%=(MemberVO == null) ? "" : MemberVO.getMemberAccount()%>"/>

            <input type="password" name="memberPassword" size="45"
                   class="fadeIn second" placeholder="password"
                   value="<%=(MemberVO == null) ? "" : MemberVO.getMemberPassword()%>"/>

            <input type="TEXT" name="memberName" size="45"
                   class="fadeIn second" placeholder="name"
                   value="<%=(MemberVO == null) ? "" : MemberVO.getMemberName()%>"/>

            <input type="TEXT" name="memberPhone" size="45"
                   class="fadeIn second" placeholder="phone"
                   value="<%=(MemberVO == null) ? "" : MemberVO.getMemberPhone()%>"/>


            <input type="TEXT" name="memberNickname" size="45"
                   class="fadeIn second" placeholder="nickname"
                   value="<%=(MemberVO == null) ? "" : MemberVO.getMemberNickname()%>"/>


            <input type="TEXT" name="memberAddress" size="45"
                   class="fadeIn second" placeholder="address"
                   value="<%=(MemberVO == null) ? "" : MemberVO.getMemberAddress()%>"/>


            <input type="TEXT" name="memberEmail" size="45"
                   class="fadeIn second" placeholder="email"
                   value="<%=(MemberVO == null) ? "" : MemberVO.getMemberEmail()%>"/>

            <input type="hidden" name="action" value="insert">
            <input type="submit" value="註冊" id="submit">


        </FORM>
    </div>
</div>
</body>
<script>

</script>
</html>