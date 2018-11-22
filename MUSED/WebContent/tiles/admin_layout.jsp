<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head> 
	<title><tiles:getAsString name="admin_title" /></title>
</head>
<body>


<tiles:insertAttribute name="admin_header"/>

<tiles:insertAttribute name="admin_body" />
<tiles:insertAttribute name="admin_nav"/>
</body>
</html>