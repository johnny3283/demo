<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="com.mem.model.*" %>

<%
    MemService memSvc = new MemService();
    MemberVO MemberVO = (MemberVO) request.getAttribute("MemberVO");
%>
<!DOCTYPE html>
<html>
<head>

    <title>listOneMember</title>
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
        width: 400px;
        height: 300px;
        border-style: outset;
    }
</style>
</head>
<body>

<%@ include file="../navbar.file" %>
<br>
<div id="content">
    <FORM METHOD="post" ACTION="member/MemberServlet">
        <div id="form">
            <div style="margin: 0px auto;">會員編號:
                <label>${MemberVO.memberNo}</label></div>


            <div style="margin: 0px auto;">會員姓名:
                <label>${MemberVO.memberName}</label></div>


            <div style="margin: 0px auto;">會員電話:
                <label>${MemberVO.memberPhone}</label></div>


            <div style="margin: 0px auto;">會員暱稱:
                <label>${MemberVO.memberNickname}</label></div>


            <div style="margin: 0px auto;">會員地址:
                <lable>${MemberVO.memberAddress}</lable>
            </div>

            <div style="margin: 0px auto;">會員e-mail:
                <label>${MemberVO.memberEmail}</label></div>
            <div style="margin: 0px auto;">
                <input type="hidden" name="memberNo" value="${member.memberNo}">
                <input type="hidden" name="action" value="getOne_For_Update">
                <input type="submit" value="修改" style="border-radius:1rem; border: 1px solid #ccc;">

            </div>
        </div>
    </FORM>
</div>
<br>
<br>

</body>
</html>