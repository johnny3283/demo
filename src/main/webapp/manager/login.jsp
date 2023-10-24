<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>front page</title>
<link type="text/css"
	href="<%=request.getContextPath()%>/css/form.css" rel="stylesheet">

</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->
			<h2 class="active">管理員登入</h2>
			<br>
			<c:if test="${not empty errorMsgs}">
				<font style="color: red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>


			<FORM METHOD="post" ACTION="ManagerServlet">

				<input type="text" name="managerAccount" id="login"
					class="fadeIn second"> <input type="password"
					name="managerPassword" id="password" class="fadeIn third">
				<input type="hidden" name="action" value="Login"> <input
					type="submit" value="送出">
			</FORM>

		</div>
	</div>



</body>
</html>