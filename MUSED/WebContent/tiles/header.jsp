<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>

<!-- 초기화 -->
<!-- http://meyerweb.com/eric/tools/css/reset/ 
   v2.0 | 20110126
   License: none (public domain) -->

<style>
html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p,
	blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn,
	em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var,
	b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend,
	table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas,
	details, embed, figure, figcaption, footer, header, hgroup, menu, nav,
	output, ruby, section, summary, time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}
/* HTML5 display-role reset for older browsers */
article, aside, details, figcaption, figure, footer, header, hgroup,
	menu, nav, section {
	display: block;
}

body {
	line-height: 1;
}

ol, ul {
	list-style: none;
}

blockquote, q {
	quotes: none;
}

blockquote:before, blockquote:after, q:before, q:after {
	content: '';
	content: none;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

.a {
	width: 58px;
	margin: 10px auto;
	padding: 0px 0px;
	background-color: #2196F3;
	border-radius: 50%;
	text-align: center;
	color: #BBDEFB;
}

.a i {
	font-size: 60px;
}
</style>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- 웹 폰트 적용  -->
<!-- css 적용 -->
<link href="https://fonts.googleapis.com/css?family=Henny+Penny"
	rel="stylesheet" />
<link rel="stylesheet" href="Mused_main.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>MUSED_Header</title>
</head>
<body>
	<!-- Header부분 -->

	<header id="main_header">
		<div class="head">
			<h1 id="logo">
				<a href="#"><img src="logo2.png" width="150" height="150"></a>
			</h1>
			<hgroup id="title">
				<h2>MUSED</h2>
			</hgroup>

			<nav id="main_tnb">
				<ul>
					<s:if test='%{#session.ID == null}'>
						<li><a href="loginForm.action">로그인</a></li>
						<li><a href="joinConfirm.action">회원가입</a></li>
					</s:if>
					<s:else>
						<li><a href="logout.action">로그아웃</a></li>
						<li><a href="mypage.action">마이페이지</a></li>
						<div class="a">
							<a href="loginForm.action"><i class="material-icons md-48">
									account_circle </i></a>
							<s:property value="%{#session.ID}" />
						</div>
					</s:else>
				</ul>
				<br> <br>


			</nav>

		</div>
		<div class="nav">
			<nav id="main_gnb">
				<ul class="left">
					<li><a href="#">중고악기거래</a></li>
					<li><a href="#">재능거래</a></li>
					<li><a href="#">커뮤니티</a></li>
				</ul>
				<ul class="right">
					<li><a href="#">악기판매</a></li>
					<li><a href="#">재능판매</a></li>
				</ul>
			</nav>
		</div>
	</header>
</body>
</html>