<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import ="java.util.HashMap" %>
<?xml version="1.0" encoding="UTF-8" ?>
<link rel="stylesheet" href="/MUSED/css/testtest.css"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>MUSED</title>
</head>
<body>
<div id="heading" >
<h1>검색 결과</h1>
</div>
<section id="body_nav">	
		     <nav id="main_gnb">
				<ul class="left">
					<li><a href="productList.action?currentPage=1&sort=0">중고악기거래</a></li>
					<li><a href="talentList.action?currentPage=1&sort=0">재능거래</a></li>
					<li><a href="/MUSED/tiles/free/listAction.action?currentPage=1">커뮤니티</a></li>

				</ul>
				<ul class="right">
					<s:if test='%{#session.ID != null}'>
						<li id="menubar"><a href="productWriteForm.action">악기판매</a></li>
						<li id="menubar"><a href="talentWriteForm.action">재능판매</a></li>
					</s:if>
				</ul>
			</nav>
	</section>
<div id = "main">
		<section id ="product_section">
		<h1>중고악기거래</h1>
<table width="600" border="0" cellspacing="0" cellspadding="2">
		  <s:hidden name="currentPage" value="%{currentPage}" />

	<tr bgcolor="#777777">
    	<td height="1" colspan="5"></td>
    </tr>
    <tr>
      	<s:iterator value="list_p" status="stat">
	      	<s:url id="DetailURL" action="productDetail">
				<s:param name="product_no">
					<s:property value="product_no"/>
				</s:param>
				<s:param name="currentPage">
					<s:property value="currentPage"/>
				</s:param>
			</s:url>
		<td>	 
          &nbsp;<s:a href="%{DetailURL}">
      			<img src="/MUSED/product/img/<s:property value="main_img"/>" style="height: 200px; width: 200px; display: block;"/>
				<br><s:property value="product_subject" />
				</br></s:a>
				<br>판매자 : <s:property value="product_id"/>	
	  </td>
	  	     	<s:if test="#stat.count%5==0">
  					<tr></tr>
				</s:if>	  
		</s:iterator>
	</tr>
		<s:if test="list_p.size()<=0">
			<tr bgcolor="#FFFFFF" align="center">
				<td colspan="5">등록된 게시물이 없습니다.</td>
			</tr>
		</s:if>	
	 <tr align="center">
    	<td colspan="5"><s:property value="pagingHtml"  escape="false" /></td>
    </tr>
	</table>
	</section>

	<br/>

	<section id ="talent_section">
	<h1>재능거래</h1>
	<table width="600" border="0" cellspacing="0" cellspadding="2">

	



	<tr bgcolor="#777777">
    	<td height="1" colspan="5"></td>
   	</tr>
    
	<tr>
	<s:iterator value="list_t" status="stat">
  	      <td>	 
	      	<s:url id="DetailURL" action="talentDetail">
				<s:param name="talent_no">
					<s:property value="talent_no"/>
				</s:param>
			</s:url>
			&nbsp;<s:a href="%{DetailURL}">
   	      			<img src="/MUSED/talent/img/<s:property value="main_img"/>" style="height: 200px; width: 200px; display: block;"/>
					<br><s:property value="talent_subject" />
				  </s:a>
			<br>판매자 : <s:property value="talent_id"/>	
	     </td>
	       	<s:if test="#stat.count%5==0">
        		<tr></tr>
			</s:if>	  
	</s:iterator>
	</tr>

	<s:if test="list_t.size()<=0">
		<tr bgcolor="#FFFFFF" align="center">
			<td colspan="5">등록된 게시물이 없습니다.</td>
		</tr>
	</s:if>	
	  <tr align="center">
  		<td colspan="5"><s:property value="pagingHtml"  escape="false" /></td>
    </tr>
</table>
</section>
	<section id ="board_section">
		<div id ="notice_">
		<h1>공지사항</h1>
				&nbsp;<a href='#'>전체보기</a>
				<!-- <img src="http://placehold.it/350x250" width="350" height="250"/> -->
				
				<table width="350" border="0" cellspacing="0" cellpadding="2">
					<tr>
						<td width="150"><strong>제목</strong></td>
						<td width="50"><strong>글쓴이</strong></td>
						<td width="100"><strong>날짜</strong></td>
						<td width="50"><strong>조회</strong></td>
					</tr>
					<tr bgcolor="#777777">
						<td height="1" colspan="5"></td>
					</tr>
					<s:iterator value="list_n" status="stat">
						<s:url id="viewURL" action="/tiles/notice/viewAction">
						<s:param name="no">
						<s:property value="no"/> 
						</s:param>
						</s:url>
					<tr>
						 <td align="left">
			      			<s:if test="re_level != 0">
			          			<c:forEach var = "i" begin ="${re_level}" end = "0">&nbsp;</c:forEach>→
			      			</s:if>		
						 	<s:a href="%{viewURL}"><s:property value="subject" /></s:a>
						 </td>
						 <td> <s:property value="name" /></td>
						 <td> <s:property value="regdate" /></td>
			 			<td><s:property value="readhit" /></td>
			 		<tr bgcolor="#777777">
			     		<td height="1" colspan="5"></td>
					</tr>		
					</s:iterator>
				</table>
		</div>
		<div id ="free_">
		<h1>자유게시판</h1>
				&nbsp;<a href='#'>전체보기</a>
				<!-- <img src="http://placehold.it/350x250" width="350" height="250"/> -->
				<table width="350" border="0" cellspacing="0" cellpadding="2">
					<tr>
						<td width="150"><strong>제목</strong></td>
						<td width="50"><strong>글쓴이</strong></td>
						<td width="100"><strong>날짜</strong></td>
						<td width="50"><strong>조회</strong></td>
					</tr>
					<tr bgcolor="#777777">
						<td height="1" colspan="5"></td>
					</tr>
					<s:iterator value="list_f" status="stat">
						<s:url id="viewURL" action="/tiles/free/viewAction">
						<s:param name="no">
						<s:property value="no"/> 
						</s:param>
						</s:url>
					<tr>
						 <td align="left">
			      			<s:if test="re_level != 0">
			          			<c:forEach var = "i" begin ="${re_level}" end = "0">&nbsp;</c:forEach>→
			      			</s:if>		
						 	<s:a href="%{viewURL}"><s:property value="subject" /></s:a>
						 </td>
						 <td> <s:property value="name" /></td>
						 <td> <s:property value="regdate" /></td>
			 			<td><s:property value="readhit" /></td>
			 		<tr bgcolor="#777777">
			     		<td height="1" colspan="5"></td>
					</tr>		
					</s:iterator>
				</table>
		</div>
		<div id ="suggestion_">
		<h1>건의사항</h1>
				&nbsp;<a href='#'>전체보기</a>
				<!-- <img src="http://placehold.it/350x250" width="350" height="250"/> -->
					<table width="350" border="0" cellspacing="0" cellpadding="2">
					<tr>
						<td width="150"><strong>제목</strong></td>
						<td width="50"><strong>글쓴이</strong></td>
						<td width="100"><strong>날짜</strong></td>
						<td width="50"><strong>조회</strong></td>
					</tr>
					<tr bgcolor="#777777">
						<td height="1" colspan="5"></td>
					</tr>
					<s:iterator value="list_s" status="stat">
						<s:url id="viewURL" action="/tiles/sug/viewAction">
						<s:param name="no">
						<s:property value="no"/> 
						</s:param>
						</s:url>
					<tr>
						 <td align="left">
			      			<s:if test="re_level != 0">
			          			<c:forEach var = "i" begin ="${re_level}" end = "0">&nbsp;</c:forEach>→
			      			</s:if>		
						 	<s:a href="%{viewURL}"><s:property value="subject" /></s:a>
						 </td>
						 <td> <s:property value="name" /></td>
						 <td> <s:property value="regdate" /></td>
			 			<td><s:property value="readhit" /></td>
			 		<tr bgcolor="#777777">
			     		<td height="1" colspan="5"></td>
					</tr>		
					</s:iterator>
				</table>
		</div>
	</section>
</div>	
</body>
</html>