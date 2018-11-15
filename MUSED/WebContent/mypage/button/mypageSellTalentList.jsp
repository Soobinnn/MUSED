<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import ="java.util.HashMap" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>재능 판매 내역</title>
</head>
<body>

<table width="600" border="0" cellspacing="0" cellspadding="2">
<tr bgcolor="#777777">
    	<td height="1" colspan="5"></td>
   	</tr>
    
	<tr>
     	<s:iterator value="list" status="stat">
  	      <td>	 
	      	<s:url id="DetailURL" action="talentDetail">
				<s:param name="talent_no">
					<s:property value="talent_no"/>
				</s:param>
			</s:url>
   			&nbsp;<s:a href="%{DetailURL}">
   	      			<img src="/MUSED/talent/img/<s:property value="main_img"/>" style="height: 100px; width: 100px; display: block;"></img>
					<br><s:property value="talent_subject" />
				  </s:a>
			<br>판매자 : <s:property value="talent_id"/>	
	     </td>
	       	<s:if test="#stat.count%5==0">
        		<tr></tr>
			</s:if>	  
		</s:iterator>
	</tr>

	<s:if test="list.size()<=0">
		<tr bgcolor="#FFFFFF" align="center">
			<td colspan="5">판매된 재능이 없습니다.</td>
		</tr>
	</s:if>
	
    <tr align="center">
  		<td colspan="5"><s:property value="pagingHtml"  escape="false" /></td>
    </tr>
</table>
</body>
</html>