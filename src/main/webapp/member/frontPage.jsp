<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>front page</title>
<style >
form,li,a {
	width: 800px;
/* 	background-color: #79798c; */
	margin-top: 5px;
	margin-bottom: 5px;
	margin-left: 34%;
	
	
}

</style>

</head>
<body>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>


			<FORM METHOD="post" ACTION="MemberServlet">
				<b>查詢會員資料 :</b> <input type="text" name="memberNo"> <input
					type="hidden" name="action" value="getOne_For_Display"> <input
					type="submit" value="送出">
			</FORM>
			<FORM METHOD="post" ACTION="MemberServlet">
				<b>修改會員資料 :</b> <input type="text" name="memberNo"> <input
					type="hidden" name="action" value="getOne_For_Update"> <input
					type="submit" value="送出">
			</FORM>
			<FORM METHOD="post" ACTION="addmember.jsp">
				<b><br>新增會員 :</b>  <input
					type="submit" value="新增">
			</FORM>
		
		<a href='listAllMember.jsp'>List</a> all Mems.  <br><br>
	
</body>
</html>