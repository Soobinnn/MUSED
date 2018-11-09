<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>신고 목록</title>
</head>

</head>
<body>
  	<table width="600" border="0" cellspacing="0" cellpadding="2">
  	<tr>
  		<td align="center"><h2>신고목록</h2></td>
  	</tr>
  	<tr>
  		<td height="20"></td>
  	</tr>
  	</table>
  	
  	<table width="750" border="0" cellspacing="0" cellpadding="2">
		<tr align="center" bgcolor="#F3F3F3">
      		<td width="50"><strong>번호</strong></td> <td width="100"> <strong>신고자</strong></td> <td width="80"><strong>카테고리</strong></td> <td width="350"><strong>신고내용</strong></td><td width="100"><strong>작성자</strong></td><td width="100"><strong>날짜</strong></td> <td width="80"><strong>처리</strong></td>
      	</tr>
      	 <tr bgcolor="#777777">
        	<td height="1" colspan="7"></td>
      	 </tr>
  	
	<s:iterator value="list" status="stat">
  		
  		<tr bgcolor="#FFFFFF"  align="center">
        	<td><s:property value="report_no" /></td> <td align="left"> &nbsp;<s:property value="report_reportid" /></td> <td align="center"><s:property value="report_category" /></td> <td align="center"><s:property value="report_content" /></td> <td><s:property value="report_memid" /></td><td><s:property value="report_regdate" /></td>
      	</tr>
      	<tr bgcolor="#777777">
        	<td height="1" colspan="7"></td>
      	</tr>
      	
 	</s:iterator>
  		
  		<s:if test="list.size() <= 0">
  		
  		<tr bgcolor="#FFFFFF"  align="center">
			<td colspan="5">등록된 게시물이 없습니다.</td>
		</tr>						
	    <tr bgcolor="#777777">
      		<td height="1" colspan="5"></td>
    	</tr>
    	
  		</s:if>
  		
  		<tr align="center">
    		<td colspan="5"><s:property value="pagingHtml"  escape="false" /></td>
    	</tr>
    	
    	<tr align="right">
    		<td colspan="6">
    			<input type="button" value="저장" class="inputb" onClick="javascript:location.href='writeForm.action?currentPage=<s:property value="currentPage" />';">
			</td>
			<td>
    			<input type="button" value="취소" class="inputb" onClick="javascript:location.href='writeForm.action?currentPage=<s:property value="currentPage" />';">
			</td>
    	</tr>
	</table>	
</body>
</html>