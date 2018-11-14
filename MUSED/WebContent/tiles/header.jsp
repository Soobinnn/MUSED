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
</head>
<body>
	<!-- Header부분 -->

	<header id="main_header">
		<div class="head">
			<h1 id="logo">
				<s:if test='%{#session.ID == null}'>
					<a href="/MUSED/tiles/member.jsp"><img src="/MUSED/tiles/image/logo2.png" width="150" height="150"></a>
				</s:if>
				<s:else>
					<a href="/MUSED/tiles/loginAction.action"><img src="/MUSED/tiles/image/logo2.png" width="150" height="150"></a>
				</s:else>
			</h1>
			<hgroup id="title">
				<h2>MUSED</h2>
			</hgroup>
			<div class="search_bar">
				<form class="searchform" name="search" action="mainSearch.action">
					<input type="hidden" name="searchNum" value="0"/>
					<input type="text" placeholder="검색어 입력" id="search_text" name="searchKeyword">	
					<input name="submit" type="submit" value="검색" id="search_button">
				</form>	
			</div>
			<nav id="main_tnb">
				<ul>
					<s:if test='%{#session.ID == null}'>
						<li><div>
								<a href="loginForm.action"><img id="mouseover2" width="45"
									height="45" /></a>
							</div>
							<div>Login</div></li>
						<li><div>
								<a href="joinConfirm.action"><img src="/MUSED/tiles/image/join.png"
									width="45" height="45" /></a>
							</div>
							<div>Join Us</div></li>
					</s:if>
					<s:else>
						<li><div>
								<a href="logout.action"><img id="mouseover" width="50"
									height="50" /></a>
							</div>
							<div>Logout</div></li>
						<li><div>						
								<a href="mypage.action"><img src="/MUSED/tiles/image/myPage.png" width="45"
									height="45"/>
									<p class="arrow_box">MUSED 계정 : <s:property value="%{#session.ID}" /><br>
									(<s:property value="%{resultClass.email}"/>)
									</p>
								</a>
								
								
							</div>
						</li>	
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

					<li id="menubar"><a href="productList.action">중고악기거래</a></li>
					<li id="menubar"><a href="talentList.action">재능거래</a></li>
					<li id="menubar"><a href="#">커뮤니티</a></li>

				</ul>
				<ul class="right">

					<li id="menubar"><a href="productWriteForm.action">악기판매</a></li>
					<li id="menubar"><a href="talentWriteForm.action">재능판매</a></li>

				</ul>
			</nav>
		</div>
	</header>
</body>
</html>