<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="java.util.HashMap" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<link rel="stylesheet" href="/MUSED/css/css.css" type="text/css">
<head>
<title>악기 게시판</title>
	<style>
		h2{color:gray}
	</style>
</head>

<body>
<table width="600" border="0" cellspacing="0" cellspadding="2">
	<input type="button" value="판매 등록 폼" onClick="javascript:location.href='/MUSED/product/productWriteForm.action'"/>
	<tr>
		<td align="center"><h2>악기 리스트</h2></td>
	</tr>
	<tr>
		<td height="20"></td>
	</tr>
</table>
 
      				
<table width="600" border="0" cellspacing="0" cellspadding="2">

	<tr align="center">
		<td colspan="5">
			<form>
				<s:textfield name="searchKeyword" theme="simple" value="" cssStyle="width:120px" maxlength="20"/>
				<input name="submit" type="submit" value="검색" class="inputb">
				</form>
		</td>
	</tr>
	<tr align="center">
		<td colspan="5"><!-- 우편... -->
				<select name="sido">
					<option value="0">서울</option>
					<option value="1">강원</option>
					<option value="2">경기</option>
				</select>
				<!-- 칸 띄기 -->
				<select name="gogon">
					<option value="0">1</option>
					<option value="1">2</option>
					<option value="2">3</option>
				</select>			
			</form>
		</td>
	</tr>
	<tr align="center">
	<!-- 버튼 말고 check같은 거로 해야됨 -->
		<td colspan="5">
			<input type="button" name="c" value="클래식(관악기/현악기)"/>
			<input type="button" name="g" value="기타"/>
			<input type="button" name="d" value="드럼/타악기"/>
			<input type="button" name="gb" value="건반악기"/>
			<input type="button" name="um" value="음향장비"/>
			<input type="button" name="etc" value="그 외 악기"/>
		</td>
	</tr>
	<tr align="left">
		<td colspan="5">
		-----------------------------------------------------------<br>
		(최신순) (최저가순) (최고가순)
				<select name="aa">
					<option value="0">최신순</option>
					<option value="1">최저가순</option>
					<option value="2">최고가순</option>
				</select>	
				<br>
		</td>
	</tr>
		      <tr bgcolor="#777777">
        		<td height="1" colspan="5"></td>
      	      </tr>
<%-- 				<tr>
      	      			<s:iterator value="first" status="stat">
            	    		<td>
            	      			<img src="<s:property />" style="height: 100px; width: 100px; display: block;"/>
							</td>
						</s:iterator>
						      	        
				</tr> --%>
				
				<tr>
	   	  	      	<s:iterator value="list" status="stat">
	   	  	      		      	<s:url id="DetailURL" action="productDetail">
									<s:param name="product_no">
										<s:property value="product_no"/>
									</s:param>
								</s:url>
      	      	      <td>	 
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
			<td colspan="5">등록된 게시물이 없습니다.</td>
		</tr>
	</s:if>
	
    <tr align="center">
    		<td colspan="5"><s:property value="pagingHtml"  escape="false" /></td>
    </tr>

</table>
</body>
</html>