<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<link rel="stylesheet" href="/MUSED/css/testtest.css"/>
<html>
<head> 
	<title><tiles:getAsString name="title" /></title>
</head>
<body>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="body" />
<tiles:insertAttribute name="footer"/>
</body>
</html>