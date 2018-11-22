<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>

<!-- 웹 폰트 적용  -->
<!-- css 적용 -->
<link href="https://fonts.googleapis.com/css?family=Henny+Penny" rel="stylesheet"/>
<link rel="stylesheet" href="/MUSED/css/testtest.css"/>


<title>MUSED_Main</title>
</head>
<body class="is-preload">

	<section id="banner">
				<div class="inner">
					<h1>MUSED</h1>
					
					<p>Just Music It</p>
					<p> Where there's music there can be no cheat.</p>
				</div>
				<video autoplay loop muted playsinline src="/MUSED/css/lost_star.mp4"></video>
	</section>
		
	<section id="body_nav">	
		     <nav id="main_gnb">
				<ul class="left">
					<li><a href="productList.action?currentPage=1&sort=0">중고악기거래</a></li>
					<li><a href="talentList.action?currentPage=1&sort=0">재능거래</a></li>
					<li><a href="/MUSED/tiles/free/listAction.action?currentPage=1">커뮤니티</a></li>

				</ul>
				<ul class="right">
					<s:if test='%{#session.ID != null}'>
						<li><a href="productWriteForm.action">악기판매</a></li>
						<li><a href="talentWriteForm.action">재능판매</a></li>
					</s:if>
				</ul>
			</nav>
	</section>		
	<!-- Article부분 -->
	<article id="main_article">

	<div id = "main">
		<section id ="product_section">
			<h1 id="bodyfont2">중고악기거래</h1>
			&nbsp;<a id="bodyfull" href="productList.action?currentPage=1&sort=0">+</a>
			<table width="95%" border="0" cellspacing="0" cellspadding="2">
			<tr>
				<s:if test='%{#session.ID != null}'>
      				<s:iterator value="list_p" status="stat">
	      			<s:url id="DetailURL" action="productDetail">
					<s:param name="product_no">
					<s:property value="product_no"/>
					</s:param>
					</s:url>
      			<td>	 
          			&nbsp;<s:a id="bodyfont3" href="%{DetailURL}">
      				<img src="/MUSED/product/img/<s:property value="main_img"/>" style="height: 200px; width: 200px; display: block;"/>
					<br/>
					<s:property value="product_subject" /></s:a>
					<br/>
					판매자 : <s:property value="product_id"/>	
	  			<br/>
					<s:property value="product_price"/>원
	  			</td>
	  	     		<s:if test="#stat.count%5==0">
  					<tr></tr>
					</s:if>	  
					</s:iterator>  		
				</s:if>
		
				<!-- 로그인 안했을 때 로그인 폼으로 -->
	 			<s:if test='%{#session.ID == null}'>
	 			<s:iterator value="list_p" status="stat">
      			<td>	 
         			 &nbsp;<s:a id="bodyfont3" href="loginForm.action">
      					<img src="/MUSED/product/img/<s:property value='main_img'/>" style="height: 200px; width: 200px; display: block;"/>
					<br/>
					<s:property value="product_subject"/></s:a>
					<br/>
					판매자 : <s:property value="product_id"/>	
					<br/>
					<s:property value="product_price"/>원
	  			</td>
	  	     		<s:if test="#stat.count%5==0">
  					<tr></tr>
					</s:if>	  
					</s:iterator>  		
	 			</s:if>
			</tr>
			</table>
		</section>
		
		<section id ="talent_section">
			<h1 id="bodyfont2">재능거래</h1>
			&nbsp;<a id="bodyfull" href="talentList.action?currentPage=1&sort=0">+</a>
			<table width="95%" border="0" cellspacing="0" cellspadding="2">
			<tr>
				<!-- 로그인 했을 때 상세보기 들어가짐 -->
				<s:if test='%{#session.ID != null}'>
     				<s:iterator value="list_t" status="stat">
  	      			<td>	 
	      				<s:url id="DetailURL" action="talentDetail">
						<s:param name="talent_no">
						<s:property value="talent_no"/>
						</s:param>
						</s:url>
   						&nbsp;<s:a id="bodyfont3" href="%{DetailURL}">
   	      				<img src="/MUSED/talent/img/<s:property value="main_img"/>" style="height: 200px; width: 200px; display: block;"/>
						<br>
						<s:property value="talent_subject" /></s:a>
						<br>
						판매자 : <s:property value="talent_id"/>	
						<br/>
						<s:property value="talent_price"/>원
	  			
	    			</td>
	       				<s:if test="#stat.count%5==0">
        				<tr></tr>
						</s:if>	  
					</s:iterator>
				</s:if>
		
				<!-- 로그인 안했을 때 로그인 폼으로 -->
	 			<s:if test='%{#session.ID == null}'>
	 				<s:iterator value="list_t" status="stat">
      				<td>	 
          				&nbsp;<s:a id="bodyfont3" href="loginForm.action">
      					<img src="/MUSED/talent/img/<s:property value="main_img"/>" style="height: 200px; width: 200px; display: block;"/>
						<br>
						<s:property value="talent_subject" /></s:a>
						<br>
						판매자 : <s:property value="talent_id"/>
						<br/>
					<s:property value="talent_price"/>원
	  				
	     			</td>
	       				<s:if test="#stat.count%5==0">
        				<tr></tr>
						</s:if>	  
						</s:iterator>  		
	 				</s:if>
			</tr>
			</table>
		</section>
		</div>
		<section class="wrapper">
				<div class="inner">
					<header class="special">
						<h2>Communication</h2>
						<p>Listen to the words of the talking partner and look at the person's eyes, you can know the character of the person. People can not hide their personality as much as they say it, no matter how they use it.</p>
					</header>
		</section>
		<div class="testimonials">
		<section>
							<div class="content">
								<h1 id="bodyfont2">공지사항</h1>
				&nbsp;<a id="bodyfull" href='/MUSED/tiles/notice/listAction.action?currentPage=1'>+</a>
				<!-- <img src="http://placehold.it/350x250" width="350" height="250"/> -->
				
				<table width="300" border="1" cellspacing="0" cellpadding="2">
					<thead>
					<tr>
						<td width="130" align="center"><strong id="bodyfont">제목</strong></td>
						<td width="60" align="center"><strong id="bodyfont">날짜</strong></td>
						<td width="50" align="center"><strong id="bodyfont">조회</strong></td>
					</tr>
					</thead>
					<tr bgcolor="#777777">
						<td height="1" colspan="5"></td>
					</tr>
					<s:iterator value="list_n" status="stat">
						<s:url id="viewURL" action="/tiles/notice/viewAction">
						<s:param name="no">
						<s:property value="no"/> 
						</s:param>
					<s:param name="currentPage">
					<s:property value="currentPage"/>
				</s:param>	
						</s:url>
					<tbody>
					<tr>
						 <td class="boardtd" align="left">
			      			<s:if test="re_level != 0">
			          			<c:forEach var = "i" begin ="${re_level}" end = "0">&nbsp;</c:forEach>→
			      			</s:if>		
						 	<s:a href="%{viewURL}"><s:property value="subject" /></s:a>
						 </td>
						 <td align="center"> <s:property value="regdate" /></td>
			 			<td align="center"><s:property value="readhit" /></td>
			 		<tr bgcolor="#777777">
			     		<td height="1" colspan="5"></td>
					</tr>
					</tbody>		
					</s:iterator>
				</table>
							</div>
							
		</section>
		<section>
							<div class="content">
								<h1 id="bodyfont2">자유게시판</h1>
				&nbsp;<a id="bodyfull" href='/MUSED/tiles/free/listAction.action?currentPage=1'>+</a>
				<!-- <img src="http://placehold.it/350x250" width="350" height="250"/> -->
				<table width="300" border="0" cellspacing="0" cellpadding="2">
					<thead>
					<tr>
						<td width="130" align="center"><strong id="bodyfont">제목</strong></td>
						<td width="60" align="center"><strong id="bodyfont">ID</strong></td>
						<td width="50" align="center"><strong id="bodyfont">조회</strong></td>
					</tr>
					</thead>
					<tr bgcolor="#777777">
						<td height="1" colspan="5"></td>
					</tr>
					<s:iterator value="list_f" status="stat">
						<s:url id="viewURL" action="/tiles/free/viewAction">
						<s:param name="no">
						<s:property value="no"/> 
						</s:param>
						<s:param name="currentPage">
					<s:property value="currentPage"/>
						</s:param>
						
						</s:url>
					<tbody>
					<tr>
						 <td class="boardtd" align="left">
			      			<s:if test="re_level != 0">
			          			<c:forEach var = "i" begin ="${re_level}" end = "0">&nbsp;</c:forEach>→
			      			</s:if>		
						 	<s:a href="%{viewURL}"><s:property value="subject" /></s:a>
						 </td>
						 <td align="center"> <s:property value="name" /></td>
			 			<td align="center"><s:property value="readhit" /></td>
			 		<tr bgcolor="#777777">
			     		<td height="1" colspan="5"></td>
					</tr>
					</tbody>		
					</s:iterator>
				</table>
							</div>
		</section>		
			<section>
							<div class="content">
								<h1 id="bodyfont2">건의사항</h1>
				&nbsp;<a id="bodyfull" href='/MUSED/tiles/sug/listAction.action?currentPage=1'>+</a>
				<!-- <img src="http://placehold.it/350x250" width="350" height="250"/> -->
					<table width="300" border="0" cellspacing="0" cellpadding="2">
					<thead>
					<tr>
						<td width="150" align="center"><strong id="bodyfont">제목</strong></td>
						<td width="60" align="center"><strong id="bodyfont">ID</strong></td>
						<td width="50" align="center"><strong id="bodyfont">조회</strong></td>
					</tr>
					</thead>
					<tr bgcolor="#777777">
						<td height="1" colspan="5"></td>
					</tr>
					<s:iterator value="list_s" status="stat">
						<s:url id="viewURL" action="/tiles/sug/viewAction">
						<s:param name="no">
						<s:property value="no"/> 
						</s:param>
						<s:param name="currentPage">
					<s:property value="currentPage"/>
				</s:param>
						
						</s:url>
					<tbody>
					<tr>
						 <td class="boardtd" align="left">
			      			<s:if test="re_level != 0">
			          			<c:forEach var = "i" begin ="${re_level}" end = "0">&nbsp;</c:forEach>→
			      			</s:if>		
						 	<s:a href="%{viewURL}"><s:property value="subject" /></s:a>
						 </td>
						 <td align="center"> <s:property value="name" /></td>
			 			<td align="center"><s:property value="readhit" /></td>
			 		<tr bgcolor="#777777">
			     		<td height="1" colspan="5"></td>
					</tr>	
					</tbody>	
					</s:iterator>
				</table>
			</div>
		</section>

	</article>	
		
	

</body>
</html>