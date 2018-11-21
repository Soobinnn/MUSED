<%@ page import="util.CookieBox"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>
table.ex1 {width:10%; margin:0 auto; text-align:right; border-collapse:collapse}
.ex1 th, .ex1 td {padding:5px 10px}
.ex1 caption {font-weight:700; font-size:20px; padding:5px; color:#1BA6B2; text-align:left; margin-bottom:5px}
.ex1 thead th {background:#ABC668; font-size:13px; color:#fff; text-align:center; border-right:1px solid #fff}
.ex1 tbody th {text-align:center; width:12%}
.ex1 tbody td.date1 {text-align:center; width:8%}
.ex1 tbody td.desc {text-align:center; width:35%}
.ex1 tbody tr.odd {background:#f9f9f9}
.ex1 tbody tr.odd th {background:#f2f2f2}
.ex1 tbody tr:hover {background:#F3F5BB}
.ex1 tbody tr:hover th {background:#F2F684; color:#1BA6B2}
.ex1 tfoot tr {border-top:6px solid #E9F7F6; color:#1BA6B2}
.ex1 tfoot th {text-align:left; padding-left:10px}
</style>
</head>
<body>
	<%
		CookieBox cookieBox = new CookieBox(request);
		Cookie[] cookies = request.getCookies();
		
		//시간 남으면 쿠키 큐에 담아서 정렬해보자
		/* for(int i=0;i<cookies.length;i++) {
		System.out.println(cookies[i].getName().indexOf("0"));
		} */
	%>

	<table class="ex1">
		
		<thead>
			<tr>
		<th scope="row" height="35px"><b>최근본상품</b></th>
		</tr>
		</thead>
		
		<%
			for (int i = 0; i < 5; i++) {
		%>
		<s:url id="DetailURL" action="productDetail">
			<s:param name="product_no">
				<%=cookieBox.getValue("PNO" + i)%>
			</s:param>
			<s:param name="currentPage">
				<%=cookieBox.getValue("PAGE" + i)%>
			</s:param>
		</s:url>
		<tbody>
		<tr class="odd">
			<th scope="row"><s:a href="%{DetailURL}">
					<%
						if (cookieBox.exists("IMAGE" + i)) {
					%>
					<img src="<%=cookieBox.getValue("IMAGE" + i)%>"
						style="height: 80px; width: 80px; display: block;" />
					<%
						}
					%>
				</s:a> <%if (cookieBox.exists("CID" + i)) {%> 
						<%=cookieBox.getValue("CID" + i)%>
 					<%}%></th>
		</tr>
		<%
				}
		%>
		</tbody>
	</table>
</body>
</html>
