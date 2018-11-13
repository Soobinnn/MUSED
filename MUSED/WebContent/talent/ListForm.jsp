<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import ="java.util.HashMap" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>재능 게시판</title>
</head>
<body>
<table width="600" border="0" cellspacing="0" cellspadding="2">
  <s:hidden name="currentPage" value="%{currentPage}" />
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
    
	<tr>
	<!-- 로그인 했을 때 상세보기 들어가짐 -->
	<s:if test='%{#session.ID != null}'>
     	<s:iterator value="list" status="stat">
  	      <td>	 
	      	<s:url id="DetailURL" action="talentDetail">
				<s:param name="talent_no">
					<s:property value="talent_no"/>
				</s:param>
				<s:param name="currentPage">
					<s:property value="currentPage"/>
				</s:param>
			</s:url>
   			&nbsp;<s:a href="%{DetailURL}">
   	      			<img src="/MUSED/talent/img/<s:property value="main_img"/>" style="height: 100px; width: 100px; display: block;"/>
					<br><s:property value="talent_subject" />
				  </s:a>
			<br>판매자 : <s:property value="talent_id"/>	
	     </td>
	       	<s:if test="#stat.count%5==0">
        		<tr></tr>
			</s:if>	  
		</s:iterator>
		</s:if>
		
		<!-- 로그인 안했을 때 로그인 폼으로 -->
	 <s:if test='%{#session.ID == null}'>
	 <s:iterator value="list" status="stat">
      <td>	 
          &nbsp;<s:a href="loginForm.action">
      			<img src="/MUSED/talent/img/<s:property value="main_img"/>" style="height: 100px; width: 100px; display: block;"/>
				<br><s:property value="talent_subject" />
				</s:a>
			<br>판매자 : <s:property value="talent_id"/>	
	     </td>
	       	<s:if test="#stat.count%5==0">
        		<tr></tr>
			</s:if>	  
		</s:iterator>  		
	 </s:if>
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