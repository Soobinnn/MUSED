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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="main.js"></script>
<link rel="stylesheet" href="style.css">

<title>MUSED_Main</title>
</head>
<body>	
	<!-- Article부분 -->
	<article id="main_article">
	<div class="slide">
<ul class="slide_ul">
<li><a href="#"><img src="images/a1.jpg" width="1500px" height="350px" alt="dane"></a></li>
<li><a href="#"><img src="images/a2.jpg" width="1500px" height="350px" alt="dane"></a></li>
<li><a href="#"><img src="images/a3.jpg" width="1500px" height="350px" alt="dane"></a></li>
<li><a href="#"><img src="images/a4.jpg" width="1500px" height="350px" alt="dane"></a></li>
<li><a href="#"><img src="images/a5.jpg" width="1500px" height="350px" alt="dane"></a></li>
<li><a href="#"><img src="images/a6.jpg" width="1500px" height="350px" alt="dane"></a></li>
</ul>
</div>
	<div id = "content">
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
			<div id ="notice_">
				<h1>공지사항</h1>
				<img src="http://placehold.it/350x250" width="350" height="250"/>
			</div>
			<div id ="free_">
				<h1>자유게시판</h1>
				<img src="http://placehold.it/350x250" width="350" height="250"/>
			</div>
			<div id ="suggestion_">
				<h1>건의사항</h1>
				<img src="http://placehold.it/350x250" width="350" height="250"/>
			</div>
		</section>
	</div>
	</article>	
	

</body>
</html>