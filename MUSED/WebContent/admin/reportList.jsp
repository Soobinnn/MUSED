<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>신고 목록</title>
</head>
<body>
	<div id="heading" >
			<h1>신고목록</h1>
	</div>
	
	<div id="main">
	<div class ="container">
		<section class="admin admin_body">
  	<table width="600" border="0" cellspacing="0" cellpadding="2">
  	<tr>
  		<td align="center"><h2>신고목록</h2></td>
  	</tr>
  	<tr>
  		<td height="20"></td>
  	</tr>
  	</table>
  	<form name="frm1" action="/MUSED/tiles/admin/processAction.action" method="post" enctype="multipart/form-data" >
  	
  	<table width="820" border="0" cellspacing="0" cellpadding="2">
		<tr align="center" bgcolor="#F3F3F3">
      		<td width="50"><strong>구분</strong></td><td width="50"><strong>번호</strong></td> <td width="100"> <strong>신고자</strong></td> <td width="100"><strong>카테고리</strong></td> <td width="350"><strong>제목</strong></td> </td><td width="100"><strong>작성자</strong></td><td width="100"><strong>날짜</strong></td> <td width="150"><strong>처리</strong></td>
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
        	<td><input type="checkbox" name="check" value="<s:property value="report_no"/>"/></td><td><s:property value="report_no" /></td> <td align="left"> &nbsp;<s:property value="report_reportid" /></td> <td align="center"><s:property value="report_category" /></td> <td align="center"><s:a href="%{viewURL}"><s:property value="report_subject" /></s:a></td><td><s:property value="report_memid" /></td><td><s:property value="report_regdate" /></td><td><s:property value="report_state" /></td>
      	</tr>
      	<tr bgcolor="#777777">
        	<td height="1" colspan="8"></td>
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
    			<input type="hidden" name="report_state" value="처리완료"/>
    			<input type="submit" value="처리" class="inputb" />	
			</td>
    	</tr>
    		 <tr align="center">
	   <td colspan="5">
	        <!-- 검색 폼 추가 -->
	        <form>
	               <select name="searchNum">
	                 <option value="0">신고자</option>
	                 <option value="1">카테고리</option>
	                 <option value="2">제목</option>
	               </select>
	               <s:textfield name="searchKeyword" theme="simple" value="" cssStyle="width:120px" maxlength="20"/>
	               <input name="submit" type="submit" value="검색" class="inputb"/>
	        </form>
	    </td>
	  </tr>
	</table>
	</form>
	</section>
	</div>	
	</div>
</body>
</html>