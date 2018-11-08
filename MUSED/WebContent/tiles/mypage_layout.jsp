<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><tiles:getAsString name="title"/></title>
</head>
<body>
ㅋㅌㅋㅌ
<table width="100%" height="800" border="1" cellpadding="0" cellspacing="0">
<tr height="20%">
	<td colspan="2"><tiles:insertAttribute name="header"/></td>
</tr>
<tr height="30%">
	<td width="20%"><tiles:insertAttribute name="mypage_header1"/></td>
	<td width="80%"><tiles:insertAttribute name="mypage_header2"/></td>
</tr>
<tr height="50%">
	<td width="20%"><tiles:insertAttribute name="mypage_left"/></td>
	<td width="80%"><tiles:insertAttribute name="mypage_body"/></td>
</tr>
<tr height="10%">
	<td colspan="2"><tiles:insertAttribute name="footer"/></td>
</tr>

</table>

</body>
</html>