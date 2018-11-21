<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head> 
	<title><tiles:getAsString name="title" /></title>
</head>
<body>

<table width="80%" height="800" border="0" cellpadding="0" cellspacing="0">
<tr colspan="1" height="30%" bgcolor="#FFFFFF">
<td><tiles:insertAttribute name="header"/></td>
</tr>
<tr height="0"></tr>
<tr>
<td><tiles:insertAttribute name="body1"/></td>
</tr>

<tr>
	<td valign="top" align="center" bgcolor="#FFFFFF"><tiles:insertAttribute name="footer" /></td>
</tr>
</table>
</body>
</html>