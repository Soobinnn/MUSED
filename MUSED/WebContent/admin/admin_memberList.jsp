<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<title>회원목록</title>
</head>
<body>
<div class ="container">
	<section class="admin admin_body">
	<table width="600" border="0" cellspacing="0" cellpadding="2">
	<tr>
  		<td align="center"><h2>회원목록</h2></td>
  	</tr>
  	<tr>
  		<td height="20"></td>
  	</tr>
	</table>
	<table width="820" border="0" cellspacing="0" cellpadding="2">
		<tr align="center" bgcolor="#F3F3F3">
      		<td width="50"><strong>구분</strong></td> <td width="100"><strong>ID</strong></td> <td width="100"><strong>이름</strong></td> <td width="100"><strong>등급</strong></td> <td width="150"><strong>이메일</strong></td> <td width="100"><strong>가입날짜</strong></td> <td width="100"><strong>접근권한</strong></td> <td width="80"><strong>처리</strong></td>
      	</tr>
      	 <tr bgcolor="#777777">
        	<td height="1" colspan="8"></td>
      	 </tr>
    
    <s:iterator value="list" status="stat">
    	<s:url id="viewURL" action="viewAction" >
				<s:param name="report_no">
					<s:property value="report_no" />
				</s:param>
				<s:param name="currentPage">
					<s:property value="currentPage" />
				</s:param>
			</s:url>
		
		
  		<tr bgcolor="#FFFFFF"  align="center">
        	<td><input type="checkbox" name="check" value="#"/></td><td><s:property value="id"/></td><td><s:property value="name" /></td> <td align="left"> &nbsp;<s:property value="score" /></td> <td align="center"><s:property value="email" /></td> <td align="center"><s:property value="joindate" /></td> <td align="center"><s:a href="%{viewURL}"><s:property value="access_num" /></s:a></td> <td><a href='#'>처리완료</a></td>
      		
      	</tr>
      	<tr bgcolor="#777777">
        	<td height="1" colspan="8"></td>
      	</tr>	
	</s:iterator>
	
	<s:if test="list.size() <= 0">
  		
  		<tr bgcolor="#FFFFFF"  align="center">
			<td colspan="5">등록된 회원이 없습니다.</td>
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
    		<form>
    			<input type="button" value="저장" class="inputb" onClick='test_checkbox()'>
    		</form>
			</td>
			
			<td>
    			<input type="button" value="취소" class="inputb" onClick="javascript:location.href='writeForm.action?currentPage=<s:property value="currentPage" />';">
			</td>
    	</tr>		
     </table>
		
	
	</section>
</body>
</html>