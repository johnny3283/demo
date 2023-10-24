<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mem.model.*"%>

<%
MemService memSvc = new MemService();
MemberVO MemberVO = (MemberVO) request.getAttribute("MemberVO");
%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-color: lightgray;
}

span {
	color: blue;
	display: inline;
	margin-left: 43%;
}
</style>


<title>listOneMember</title>
</head>
<body>
<span id="show"></span>
<script>
　　var t=5;
　　setInterval("refer()",1000); 
　　function refer(){
　　　　if(t==0){
　　　　　　window.location =  "../index.jsp"; 
　　　　}
　　　　document.getElementById('show').innerHTML="權限不足將在"+t+"秒後跳轉到首頁"; 
　　　　t--; 

　　}
</script>

</body>
</html>