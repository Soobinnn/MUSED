<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><tiles:getAsString name="title" /></title>

<style type="text/css">
body {
	margin: 0;
	padding: 0;
	height: 100%
}

#wrapper {
	position: relative;
	min-height: 100%
}

div#left {
	width: 200px;
	height: 400px;
	float: left;
}

#right {
	width:130px;
	height:400px;
	float:right;
}

#contents {
	width: 1100px;
	height: 400px;
	float: left;
}

#footer {
	position : relative;
	/* �߾� ���� */
	width: 100%;
	margin: 0 auto;
	margin-bottom: 10px;
	
	/* �׵θ� */
	box-sizing : border-box;
	padding: 10px;
	border: 1px solid black;
	top:400px;
	bottom : 0px;
	/* ���� ���� */
	text-align: center;
}
</style>

</head>
<body>
	<div>
	<tiles:insertAttribute name="header" />
	</div>
	<div>
	<tiles:insertAttribute name="mypage_header" />
	</div>
	<div id="wrapper">
		<div id="left">
			<tiles:insertAttribute name="mypage_left" />
		</div>
		<div id="contents">
			<tiles:insertAttribute name="mypage_body" />
		</div>
		<div id="right">
			<tiles:insertAttribute name="mypage_right"/>
		</div>
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>