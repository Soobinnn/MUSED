<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>악기 상세보기</title>

<script type="text/javascript">
function open_win_noresizable(url,name){
	var oWin = window.open(url, name, "scrollbars=no,status=no, resizable=no, width=300, height=150");
}
</script>
</head>
<body>

	제목 :	&nbsp;&nbsp;(<s:property value="resultClass.product_state"/>)
	<s:property value="resultClass.product_subject"/>
<br>
		
<table width="100%" height="150" border="0">
<tr>
<td width="200">
		<img src='<s:property value="resultClass.main_img"/>' style="height: 250px; width: 250px; display: block;"/>
</td>
<td>
상품 카테고리 : <s:property value="resultClass.product_category"/><br>
택배 : 
<s:iterator value="type" status="stat">
 	<s:property />		<!-- image로 출력하기 -->
</s:iterator>
<br>
제목 : <s:property value="resultClass.product_subject"/><br>
제품명 : <s:property value="resultClass.product_name"/><br>
브랜드 : <s:property value="resultClass.product_brand"/><br>
가격 : <s:property value="resultClass.product_price"/><br>
</td>
</tr>
<tr>
<td>
<table width="100%" height="150" border="1">
 <tr>
	<s:iterator value="image" status="stat">	
	
	<td >
		<img src='<s:property/>' style="height: 100px; width: 100px; display: block;"/>
	</td>
	</s:iterator>
</tr>
</table>
</td>
<td>
판매자 정보<br>
판매자 : <s:property value="resultClass.product_id"/><br>
이메일 : <br>
판매자 연락처 : <s:property value="resultClass.product_phone"/><br>
거래 선호 지역 : <s:property value="resultClass.product_sido"/>&nbsp;
			<s:property value="resultClass.product_gogon"/>
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
상품 설명 : <s:property value="resultClass.product_content"/>
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
댓글 추가..
</td>
</tr>

<tr>
<td colspan="2">
<table width="100%" height="150" border="1">

	 <tr>

	   	<s:iterator value="list" status="stat">
	   	  	      		      	<s:url id="DetailURL" action="productDetail">
									<s:param name="product_no">
										<s:property value="product_no"/>
									</s:param>
								</s:url>
      	      	      <td>	 
      	      	      &nbsp;<s:a href="%{DetailURL}">
      	      			<img src="/MUSED/product/img/<s:property value="main_img"/>" style="height: 100px; width: 100px; display: block;"/></s:a>
				</td>
						</s:iterator>
	</tr>
</table>
</td>
</tr>
<tr>
<td colspan="2">
		<input name="list" type="button" value="목록" class="inputb" onClick="javascript:location.href='product/productList.action'"/>
</td>
</tr>

</table>

</body>
</html>