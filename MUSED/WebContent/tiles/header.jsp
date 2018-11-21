<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="testtest.css"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- 웹 폰트 적용  -->
<!-- css 적용 -->

<link rel="stylesheet" href="/MUSED/css/testtest.css"/>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>MUSED_Header</title>

<style type="text/css">
.border {
	border-radius: 50%;
}
</style>

</head>
<body class="is-preload">
	<!-- Header부분 -->
	<!-- <a href="/MUSED/tiles/main.action"><img src="/MUSED/tiles/image/logo2.png" width="150" height="150"></a> -->
	<header id="main_header">
		<div class="head">
				<a class="logo" href="/MUSED/tiles/main.action">MUSED</a>
				<nav id ="main_tnb">
					<form class="searchform" name="search" action="mainSearch.action">
						<input type="hidden" name="searchNum" value="0" /> 
						<input type="text" placeholder="검색어 입력" id="search_text" name="searchKeyword"> 
						<input name="submit" type="submit"value="검색" id="search_button">
					</form> 
				<s:if test='%{#session.ID == null}'>
					<a href="loginForm.action">Login</a>
					<a href="joinConfirm.action">Join</a>
				</s:if>
				<s:else>
						<a href="logout.action">Logout</a>
						<a href="#menu">Mypage</a>
						<s:if test="%{#session.ACCESS_NUM == 1}">
						<a href="/MUSED/tiles/admin/admin_main.action">Admin</a> 
						</s:if>
				</s:else>
			</nav>
			</div>
		</header>
		
		<nav id="menu">
			<ul class="links">
					<li>	
					<a href="mypage.action"><s:if test="%{resultClass.file_savname == null}">
					<img class="border" src="/MUSED/tiles/image/myPage.png"width="130px" height="130px" />
					</s:if>
					<s:else>
					<img class="border"src="/MUSED/mypage/image/thum_<s:property value="%{#session.ID}"/>.jpg" width="130px" height="130px" /> 
					</s:else>
					<s:if test="%{#session.ACCESS_NUM == 1}"><p class="arrow_box">관리자 계정</p>
					</s:if>
					<p class="arrow_box">
					MUSED 계정 :
					<s:property value="%{#session.ID}" />
					<br> (<s:property value="%{#session.EMAIL}" />)
					</p>
					</li>
					<li><a href="productWriteForm.action">악기판매</a></li>
					<li><a href="talentWriteForm.action">재능판매</a></li>
			</ul>
		</nav> 
		
		
			
				
		
		<script src="/MUSED/css/js/jquery.min.js"></script>
		<script src="/MUSED/css/js/browser.min.js"></script>
		<script src="/MUSED/css/js/breakpoints.min.js"></script>
		<script src="/MUSED/css/js/util.js"></script>
		<script src="/MUSED/css/js/main.js"></script>
</body>
</html>