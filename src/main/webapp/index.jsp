<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Oxygen:wght@700&display=swap"
	rel="stylesheet">	
<link rel="stylesheet" href="${ctxPath}/css/styles.css">

<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery.smartmenus/1.1.0/jquery.smartmenus.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery.smartmenus/1.1.0/addons/bootstrap/jquery.smartmenus.bootstrap.min.js'></script>
<title>JiHaoShi</title>
<style>
#inbutton {
    position:relative;
    overflow:hidden;
    width:7rem;
    color:black;
    border:2px solid black;
    background-color:transparent;
    cursor:pointer;
    line-height:2;
    margin:0;
    padding:0;
    border-radius:1.5rem;
    font-size:1.125rem;
    outline:none;
    transition:transform .125s;
}
#outbutton {
    position:relative;
    overflow:hidden;
    width:5rem;
    color:black;
    border:2px solid black;
    background-color:transparent;
    cursor:pointer;
    line-height:2;
    margin:0;
    padding:0;
    border-radius:1.5rem;
    font-size:1.125rem;
    outline:none;
    transition:transform .125s;
}
</style>
</head>

<body>
	<!-- Navbar Start -->
	<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid">
			<!-- LOGO -->
			<a class="navbar-brand" href="${ctxPath}/index.jsp"> 
				<img src="${ctxPath}/css/LOGO.png" alt="Logo" width="80" height="90">
			</a>
			<!-- 螢幕縮小時導覽列會縮小成右上按鈕點開會直向呈現 -->
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<!-- collapse：無論任何螢幕大小，你都不會看到有選單在頂部。 -->
			<!-- nav-collapse：當螢幕變小時，選單會改為直行顯示。 -->
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="${ctxPath}/latest_news/listAllLatest_news.jsp">最新消息</a>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false">好食產品專區</a>
							<ul class="dropdown-menu">
								<li>
                  					<a class="dropdown-item" href="${ctxPath}/meal/mealController?action=listAll">產品清單</a>
               	 				</li>
                				<li>
                 		     		<a class="dropdown-item" href="${ctxPath}/meal/RandomAssign.jsp">隨機配餐</a>
      				            </li>
                				<li>
                  					<a class="dropdown-item" href="${ctxPath}/cart/MealCart.jsp">商品購物車<c:if test="${not empty cartProds}"> (${fn:length(cartProds)})</c:if></a>
               					</li>
							</ul>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown" aria-expanded="false">課程專區</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="${pageContext.request.contextPath}/onlineCourse/ListAllOnlineCourse.jsp">線上課程專區</a></li>
								<li><a class="dropdown-item" href="${ctxPath}/cart/OnlineCourseCart.jsp">線上課程購物車<c:if test="${not empty cartCourses}"> (${fn:length(cartCourses)})</c:if></a></li>
								<li><a class="dropdown-item" href="${pageContext.request.contextPath}/course/ListAllCourse.jsp">實體課程專區</a></li>
							</ul>
					</li>
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/forum_article/forum_article_select_page.jsp">康健新知論壇</a>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="<%=request.getContextPath()%>/faqservlet?action=getAll" role="button" data-bs-toggle="dropdown" aria-expanded="false">FAQ及客服專區</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="<%=request.getContextPath()%>/faqservlet?action=getAll">FAQ</a></li>
								<li><a class="dropdown-item" href="<%=request.getContextPath()%>/customerServiceServlet?action=getConnection">線上客服</a></li>
							</ul>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="" role="button" data-bs-toggle="dropdown" aria-expanded="false">會員專區</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="<%=request.getContextPath()%>/getOneMem">個人資料管理</a></li>
								<li class="dropdown-submenu">
									<a class="dropdown-item">訂單管理&emsp;></a>
									<ul class="dropdown-menu">
										<li><a class="dropdown-item" href="${ctxPath}/order/orderController?action=orderList">商品訂單</a></li>
										<li><a class="dropdown-item" href="${pageContext.request.contextPath}/onlineCourseOrderServlet?action=orderlist">線上課程訂單</a></li>
										<li><a class="dropdown-item" href="${pageContext.request.contextPath}/course/listAllSignUpCou.jsp">已報名實體課程清單</a></li>
									</ul>
								</li>
								<li><a class="dropdown-item">我的課程&emsp;></a>
									<ul class="dropdown-menu">
										<li><a class="dropdown-item" href="${pageContext.request.contextPath}/onlineCourse/ManageCourse.jsp">線上課程</a></li>
										<li><a class="dropdown-item" href="">實體課程</a></li>
									</ul>
								</li>
								<li>
                  					<a class="dropdown-item" href="${ctxPath}/mealCollect/list">我的收藏</a>
                				</li>
                				<li><a class="dropdown-item">我的評價&emsp;></a>
									<ul class="dropdown-menu">
										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/MemberOnlineCourseCommentServlet?action=getMember_For_Display">線上課程</a></li>
										<li><a class="dropdown-item" href="<%=request.getContextPath()%>/phyCourseComment?action=getMember_For_Display">實體課程</a></li>
									</ul>
								</li>
							</ul>
					</li>
					&emsp;
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="${ctxPath}/cart/MealCart.jsp">商品購物車<c:if test="${not empty cartProds}"> (${fn:length(cartProds)})</c:if></a>
					</li>
					&emsp;
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="${ctxPath}/cart/OnlineCourseCart.jsp">線上課程購物車<c:if test="${not empty cartCourses}"> (${fn:length(cartCourses)})</c:if></a>
					</li>
					&emsp;
					<c:if test="${not empty member}">
					<li class="nav-item">
						Hello!
						${member.memberAccount}
						&emsp;
						<button id="outbutton">
							<a href="<%=request.getContextPath()%>/member/MemberServlet?action=Logout" style="display:inline-block; text-decoration:none;color:black;">登出</a>
						</button>
					</li>
					</c:if>
					<c:if test="${empty member}">
					<li class="nav-item">
						&emsp;
						${Guest}
						<button id="inbutton">
							<a href="<%=request.getContextPath()%>/member/login.jsp" style="display:inline-block; text-decoration:none;color:black;"> 登入 | 註冊</a>
						</button>
					</li>
				</c:if>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Navbar End -->

	<!-- Feature Section Start-->
	<div class="mx-auto" id="feature">
		<img class="mx-auto d-block" id="feature-img" src="./css/feature.jpg"
			alt="">
		<div id="feature-text" style="">
			<p class="name">Take the stress<br>out of mealtime</p>
			<br>
			<button id="indexbutton"><a href="${ctxPath}/meal/mealController?action=listAll" style="text-decoration: none ; color:#FFE1CA ;">Get Start!</a></button>
		</div>
	</div>
	<!-- Feature Section End-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js">

	</script>
</body>

</html>