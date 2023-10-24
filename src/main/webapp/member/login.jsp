<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Login</title>
<link type="text/css"
	href="<%=request.getContextPath()%>/css/form.css" rel="stylesheet">

</head>
<body>
  <div class="wrapper fadeInDown">
        <div id="formContent">
            <!-- Tabs Titles -->
            <h2 class="active">會員登入</h2>
            <a href="<%=request.getContextPath()%>/member/addmember.jsp">
            <h2 class="inactive underlineHover">註冊
            </h2>
            </a>
			<br><c:if test="${not empty errorMsgs}">
				<font style="color: red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>

			<FORM METHOD="post" ACTION="MemberServlet">
                <input type="text" id="login" class="fadeIn second" name="memberAccount" id="account"
                    placeholder="login">
                <input type="password" id="password" class="fadeIn third" name="memberPassword" id="password"
                    placeholder="password">
                <input type="hidden" name="action" value="Login"> <input type="submit" value="送出" onclick="login()">
            </FORM>

        </div>
    </div>

</body>
</html>