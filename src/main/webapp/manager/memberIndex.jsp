<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mem.model.*"%>

<%
MemService memSvc = new MemService();
List<MemberVO> list = memSvc.getAll();
pageContext.setAttribute("list", list);
%>

<html>
<head>

<title>listAllMember</title>
<link type="text/css" href="../css/jihaoshi.css" rel="stylesheet">
<style>
#pageHead {
	width: 100%;
	height: 30%;
}

a {
	font-size: 20px;
}

#info {
	background: transparent;
	border: 0;
	font-size: 13px;
}

table, th, td {
	border: solid 1px lightgray;
}
</style>



</head>
<body>

	<img src="../images/JihaoshiPageHead.jpg" id="pageHead">
	<div class="block_N" style="margin: 0px auto;">
		<!--搜尋欄開始-->
		<div class="Nm"
			style="display: flex; justify-content: center; align-items: center;">
			<ul class="searchfield">
				<li><input id="keyword" type="text" class="text ac_input"
					placeholder="請輸入關鍵字" autocomplete="off"></li>
				<li><input id="btn_search" type="button" class="button"
					value="找菜單"></li>
			</ul>
		</div>
		<!--搜尋欄結束-->
	</div>
	<div id="WRAPPER" class="ecsite-layout style_shopping ecsite-search">
		<div id="CONTENT" class="layout-wrapper">
			<div class="layout-center" style="text-align: center">
				<!--側邊欄區塊開始-->
				<dl class="block_W">
					<dd id="CategoryContainer">
						<ul class="treeview">
							<li>管理員:<font color=red> ${ManagerAcc} </font><br> <font>權限編號:
									${AuthorityNo} </font>
							</li>
							<li><a href='../index.jsp'>到首頁</a></li>
							<li id="cate_D" class="expanded"><H1>會員管理</H1>
								<ul class="main">
									<li class="drop"><a href="../member/listAllMember.jsp">所有會員</a>
										<ul class="submenu">
											<li class="submenu-item"><a href="#">訂單查詢</a></li>
										</ul></li>
									
								</ul>
						</ul>
					</dd>
				</dl>
				<!--側邊欄區塊結束-->
				<div class="block_C s_list">
					<div class="Cm">
						<div id="ItemContainer" class="Cm_C">
							<dl class="col3f" id="DRAA0A-A900BUT82">

							</dl>

						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

</body>
</html>