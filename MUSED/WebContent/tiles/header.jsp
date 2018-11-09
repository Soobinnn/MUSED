<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- 웹 폰트 적용  -->
<!-- css 적용 -->
<link href="https://fonts.googleapis.com/css?family=Henny+Penny"
	rel="stylesheet" />

<link rel="stylesheet" href="/MUSED/tiles/Mused_main.css">

<link rel="stylesheet" href="style.css">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>MUSED_Header</title>



</head>
<body>
	<!-- Header부분 -->

	<header id="main_header">
		<div class="head">
			<h1 id="logo">

				<a href="#"><img src="/MUSED/tiles/logo2.png" width="150" height="150"></a>
				<a href="#"><img src="./image/logo2.png" width="150"
					height="150"></a>

			</h1>
			<hgroup id="title">
				<h2>MUSED</h2>
			</hgroup>

			<nav id="main_tnb">
				<ul>
					<s:if test='%{#session.ID == null}'>
						<li><div>
								<a href="loginForm.action"><img id="mouseover2" width="45"
									height="45" /></a>
							</div>
							<div>Login</div></li>
						<li><div>
								<a href="joinConfirm.action"><img src="./image/join.png"
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
								<a href="mypage.action"><img src="./image/myPage.png" width="45"
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
<<<<<<< HEAD
					<li><a href="productList.action">중고악기거래</a></li>
					<li><a href="talentList.action">재능거래</a></li>
					<li><a href="#">커뮤니티</a></li>
=======
					<li id="menubar"><a href="#">중고악기거래</a></li>
					<li id="menubar"><a href="#">재능거래</a></li>
					<li id="menubar"><a href="#">커뮤니티</a></li>
>>>>>>> branch 'master' of https://github.com/Soobinnn/MUSED.git
				</ul>
				<ul class="right">
<<<<<<< HEAD
					<li><a href="productWriteForm.action">악기판매</a></li>
					<li><a href="talentWriteForm.action">재능판매</a></li>
=======
					<li id="menubar"><a href="#">악기판매</a></li>
					<li id="menubar"><a href="#">재능판매</a></li>
>>>>>>> branch 'master' of https://github.com/Soobinnn/MUSED.git
				</ul>
			</nav>
		</div>
	</header>
</body>
</html>