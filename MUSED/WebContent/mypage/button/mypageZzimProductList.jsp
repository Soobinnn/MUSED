<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import ="java.util.HashMap" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>내가 찜한 상품</title>
<link rel="stylesheet" href="/MUSED/css/testtest.css"/>
</head>
<body>

<div id="myPage"><center>
<table width="90%" align="center" border="0" cellspacing="0" cellspadding="2">
<tr>
<td colspan="5">
<h1><br/><center>내가 찜한 상품</center></h1><br/></td>
</tr>

<tr bgcolor="#777777">
    <td height="2" colspan="5"></td>
</tr>
<tr align="center">
    <s:iterator value="list" status="stat">
    	<td width="20%" height="30%">
	     <s:url id="DetailURL" action="productDetail">
			<s:param name="product_no">
				<s:property value="product_no"/>
			</s:param>
			<s:param name="currentPage">
				<s:property value="currentPage"/>
			</s:param>
		</s:url>
   	 
          &nbsp;<s:a href="%{DetailURL}">
      			<img src="/MUSED/product/img/<s:property value="main_img"/>" style="height: 100px; width: 100px; display: block;"/>
				<br><s:property value="product_subject" />
				</br></s:a>
				<br>판매자 : <s:property value="product_id"/>	
	  </td>
	  	     	<s:if test="#stat.count%5==0">
  					<tr></tr>
				</s:if>	  
		</s:iterator>  		
</tr>
   	  <s:if test="list.size()<=0">
			<tr bgcolor="#FFFFFF" align="center">
				<td colspan="5">등록된 상품 찜이 없습니다.</td>
			</tr>
	 </s:if>
	
<tr align="center">
     <td colspan="5"><s:property value="pagingHtml"  escape="false" /></td>
</tr>
</table>
</center>
</div>
</body>
</html>