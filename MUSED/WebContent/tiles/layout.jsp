<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<link rel="stylesheet" href="Mused_main.css"
	type="text/css">
<html>
<head>
	<title><tiles:getAsString name="title" /></title>
</head>
<body>
<table width="100%" height="950" border="0" cellpadding="0" cellspacing="0">
<tr colspan="1" height="10%" align="center" bgcolor="#FFFFFF">
<td><tiles:insertAttribute name="header"/></td>
</tr>
<tr height="20"></tr>
<tr>
	<td valign="top" align="center" bgcolor="#FFFFFF"><tiles:insertAttribute name="body" /></td>
</tr>
<tr height="40">
</tr>
<tr>
	
	<td colspan="1" height="10%" align="center" bgcolor="FFFFFF">
	<tiles:insertAttribute name="footer" />
	</td>
	
</tr>
</table>
</body>
</html>