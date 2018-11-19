<%@ page import="util.CookieBox"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


</head>
<body>
	<%
		CookieBox cookieBox = new CookieBox(request);

		int num = 5;
	%>
	오늘본 상품 목록
	
		<table>
			<s:url id="DetailURL" action="productDetail">
				<s:param name="product_no">	
					<s:property value="product_no" />
				</s:param>
				<s:param name="currentPage">
					<s:property value="currentPage" />
				</s:param>
			</s:url>
	
			<%
				for (int i = 0; i < num; i++) {
			%>
			<tr>
				<td align="center"><s:a href="%{DetailURL}">
						<img src="<%=cookieBox.getValue("IMAGE" + i) %>"
							style="height: 100px; width: 100px; display: block;" />
					</s:a><%=cookieBox.getValue("CID" + i)%></td>
			</tr>
			<%
				}
			%>
		</table>

</body>
</html>


