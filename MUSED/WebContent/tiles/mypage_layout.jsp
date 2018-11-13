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

#contents {
	width: 700px;
	height: 400px;
	float: left;
}

#footer {
	position : relative;
	/* 중앙 정렬 */
	width: 100%;
	margin: 0 auto;
	margin-bottom: 10px;
	
	/* 테두리 */
	box-sizing : border-box;
	padding: 10px;
	border: 1px solid black;
	top:400px;
	bottom : 0px;
	/* 글자 정렬 */
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
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>