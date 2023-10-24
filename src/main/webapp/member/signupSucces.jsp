<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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


<title>signupSucces</title>
</head>
<body>
<span id="show"></span>
<script>
　　var t=5;
　　setInterval("refer()",1000); 
　　function refer(){
　　　　if(t==0){
　　　　　　window.location =  "${pageContext.request.contextPath}/member/login.jsp";
　　　　}
　　　　document.getElementById('show').innerHTML="修改成功"+t+"秒後跳轉到登入頁面";
　　　　t--; 
　　}
</script>

</body>
</html>