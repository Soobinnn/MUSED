<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>재능 상세보기</title>

<script type="text/javascript">
function open_win_noresizable(url,name){
	var oWin = window.open(url, name, "scrollbars=no,status=no, resizable=no, width=300, height=150");
}
function image(img){
	var src=img.src;
	window.open(src);
}
</script>
</head>
<body>
	제목 :	&nbsp;&nbsp;	<s:property value="resultClass.talent_subject"/>
<br>
		
<table width="100%" height="400" border="0">
<tr>
<td width="60%" align="middle">
		<img src='<s:property value="resultClass.main_img"/>' style="height: 300px; width: 300px; display: block;"/>
</td>
<td width="40%" height="250">
상품 카테고리 : <s:property value="resultClass.talent_category"/><br>
택배 비 포함 : <s:property value="resultClass.talent_type"/><br>
제목 : <s:property value="resultClass.talent_subject"/><br>
제품명 : <s:property value="resultClass.talent_name"/><br>
가격 : <s:property value="resultClass.talent_price"/><br>
</td>
</tr>
<tr>
<td width="60%">
<table width="130px" height="100%" border="1" align="center">
 <tr>
 
	<s:iterator value="image" status="stat">	
	
	<td>
		<%-- <s:a href="#" id="img"> --%><img src='<s:property/>' style="height: 100px; width: 100px; display: block;" onclick="image(this)"/>
	</td>
	</s:iterator>
</tr>
</table>
</td>
<td width="40%">
판매자 정보<br>
판매자 : <s:property value="resultClass.talent_id"/><br>
이메일 : <br>
판매자 연락처 : <s:property value="resultClass.talent_phone"/><br>
거래 선호 지역 : <s:property value="resultClass.talent_sido"/>&nbsp;
			<s:property value="resultClass.talent_gogon"/>
<br>
</td>
</tr>
<tr>
<td colspan="2">
<hr style="color:gray"/>
</td>
</tr>

<tr>
<td colspan="2">
<s:property value="resultClass.talent_content"/>

</td>
</tr>

<tr>
<td colspan="2">
<hr style="color:gray"/>
</td>
</tr>

<tr>
<td colspan="2">
댓글 추가..
</td>
</tr>

<tr>
<td colspan="2">
<table width="60%" height="150" border="1" align="center">

	 <tr>

<!-- 리스트로 출력 말고 no 값 받아서 그 뒤에 5개의 main_image 가져와서 출력시키기! -->
 	   	<s:iterator value="list" status="stat">
	   	  	      		      	<s:url id="DetailURL" action="talentDetail">
									<s:param name="talent_no">
										<s:property value="talent_no"/>
									</s:param>
								</s:url>
      	      	      <td>	 
      	      	      &nbsp;<s:a href="%{DetailURL}">
      	      			<img src="/MUSED/talent/img/<s:property value="main_img"/>" style="height: 100px; width: 100px; display: block;"/></s:a>
				</td>
						</s:iterator> 


	</tr>
</table>
</td>
</tr>


<tr>
<td colspan="2">
		<input name="list" type="button" value="목록" class="inputb" onClick="javascript:location.href='talent/talentList.action'"/>
</td>
</tr>

</table>

</body>
</html>