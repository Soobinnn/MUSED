<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

<!-- 초기화 -->
<!-- http://meyerweb.com/eric/tools/css/reset/ 
   v2.0 | 20110126
   License: none (public domain) -->

<style>
html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed, 
figure, figcaption, footer, header, hgroup, 
menu, nav, output, ruby, section, summary,
time, mark, audio, video 
{
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}
/* HTML5 display-role reset for older browsers */
article, aside, details, figcaption, figure, 
footer, header, hgroup, menu, nav, section 
{
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
blockquote:before, blockquote:after,
q:before, q:after {
	content: '';
	content: none;
}
table 
{
	border-collapse: collapse;
	border-spacing: 0;
}
</style>

<html>
<head>
<!-- 웹 폰트 적용  -->
<!-- css 적용 -->
<link href="https://fonts.googleapis.com/css?family=Henny+Penny" rel="stylesheet"/>
<link rel="stylesheet" href="Mused_main.css">
<title>MUSED_Main</title>
</head>
<body>

	<!-- Header부분 -->
	
	<header id="main_header">
		<div class ="head">	
			<h1 id="logo">
				<a href="#"><img src="logo2.png" width="150" height="150"></a>
			</h1>			
			<hgroup id = "title">
				<h2>MUSED</h2>
			</hgroup>
		
			<nav id = "main_tnb">
				<ul>
					<li><a href="#">로그인</a></li>
					<li><a href="#">회원가입</a></li>
					<li><a href="#">마이페이지</a></li>
				</ul>
			</nav>
		</div>
		<div class="nav">
			<nav id = "main_gnb">
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
	
	<!-- Article부분 -->
	<article id="main_article">
	<div id = "content">
		<section id ="picture">
			<img src="http://placehold.it/1530x300" width="1530" height="300"/>
		</section>
		<section id ="product_section">
			<h1>중고악기거래</h1>
			<p>
				<img src="http://placehold.it/250x250" width="250" height="250"/>
				<img src="http://placehold.it/250x250" width="250" height="250"/>
				<img src="http://placehold.it/250x250" width="250" height="250"/>
				<img src="http://placehold.it/250x250" width="250" height="250"/>
				<img src="http://placehold.it/250x250" width="250" height="250"/>	
			<p>		
		</section>
		<section id ="talent_section">
			<h1>재능거래</h1>
				<img src="http://placehold.it/250x250" width="250" height="250"/>
				<img src="http://placehold.it/250x250" width="250" height="250"/>
				<img src="http://placehold.it/250x250" width="250" height="250"/>
				<img src="http://placehold.it/250x250" width="250" height="250"/>
				<img src="http://placehold.it/250x250" width="250" height="250"/>
		</section>
				
		<section id ="board_section">
			<h1>공지사항</h1>
			<img src="http://placehold.it/350x250" width="350" height="250"/>
			
			<h1>자유게시판</h1>
			<img src="http://placehold.it/350x250" width="350" height="250"/>
			
			<h1>건의사항</h1>
			<img src="http://placehold.it/350x250" width="350" height="250"/>
		</section>
	</div>
	</article>	
	
	<!-- Footer부분 -->
	<footer id="main_footer">
		<nav id =footer_nav>
			<ul>
				<li><a href="#">개인정보처리방침</a></li>
				<li><a href="#">이용약관</a></li>
				<li><a href="reportForm.action">신고하기</a></li>
			</ul>
		</nav>
 		<h3>html5_css3</h3>
 		<address>website Layout basic</address>
 	</footer>
</body>
</html>