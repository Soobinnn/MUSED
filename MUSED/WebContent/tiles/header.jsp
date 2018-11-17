<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- 웹 폰트 적용  -->
<!-- css 적용 -->
<link href="https://fonts.googleapis.com/css?family=Henny+Penny"
	rel="stylesheet" />

<link rel="stylesheet" href="/MUSED/tiles/style.css">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>MUSED_Header</title>

<style type="text/css">
.border {
	border-radius: 50%;
}
</style>

</head>
<body>
	<!-- Header부분 -->
	<header id="main_header">
		<div class="head">
			<h1 id="logo">


				<a href="/MUSED/tiles/main.action"><img src="/MUSED/tiles/image/logo2.png" width="150" height="150"></a>
			

			</h1>
			<hgroup id="title">
				<h2>MUSED</h2>
			</hgroup>
			<div class="search_bar">
				<form class="searchform" name="search" action="mainSearch.action">
					<input type="hidden" name="searchNum" value="0" /> <input
						type="text" placeholder="검색어 입력" id="search_text"
						name="searchKeyword"> <input name="submit" type="submit"
						value="검색" id="search_button">
				</form>
			</div>
			<nav id="main_tnb">
				<ul>
					<s:if test='%{#session.ID == null}'>
						<li><div>
								<a href="loginForm.action"><img id="mouseover2" width="45"
									height="45" /></a><br>Login
							</div></li>
						<li><div>
								<a href="joinConfirm.action"><img
									src="/MUSED/tiles/image/join.png" width="45" height="45" /></a><br>Join
								Us
							</div></li>
					</s:if>
					<s:else>
						<li><div>
								<a href="logout.action"><img id="mouseover" width="50"
									height="50" /></a>
							</div>
							<div>Logout</div></li>
						<li><div>
								<a href="mypage.action"> <s:if
										test="%{resultClass.file_savname == null}">
										<img class="border" src="/MUSED/tiles/image/myPage.png"
											width="45" height="45" />
									</s:if> <s:else>
										<img class="border"
											src="C:/Java/upload/thum_<s:property value="%{#session.ID}"/>.jpg"
											width="45" height="45" />
									</s:else> <s:if test="%{#session.ACCESS_NUM == 1}">
										<p class="arrow_box">관리자 계정</p>
									</s:if>
									<p class="arrow_box">
										MUSED 계정 :
										<s:property value="%{#session.ID}" />
										<br> (
										<s:property value="%{#session.EMAIL}" />
										)
									</p>
								</a>
							</div></li>
						<s:if test="%{#session.ACCESS_NUM == 1}">
							<li><div>
									<a href="/MUSED/tiles/admin/admin_main.action"><img src="/MUSED/tiles/image/admin.png"
										width="45" height="45" /></a> <br>Admin
								</div></li>
						</s:if>
						<br>
						<br>

					</s:else>
				</ul>
				<br> <br>
			</nav>


		</div>
		<div class="nav">
			<nav id="main_gnb">
				<ul class="left">

					<li id="menubar"><a href="productList.action?currentPage=1&sort=0">중고악기거래</a></li>

					<li id="menubar"><a href="talentList.action?currentPage=1&sort=0">재능거래</a></li>
					<li id="menubar"><a href="/MUSED/tiles/free/listAction.action?currentPage=1">커뮤니티</a></li>

				</ul>
				<ul class="right">

					<s:if test='%{#session.ID != null}'>
						<li id="menubar"><a href="productWriteForm.action">악기판매</a></li>
						<li id="menubar"><a href="talentWriteForm.action">재능판매</a></li>
					</s:if>
				</ul>
			</nav>
		</div>
	</header>
</body>
</html>