<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="/MUSED/css/testtest.css"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>로그인 실패</title>
</head>

<center>
<body>
	<div id="heading" >
			<h1>MUSED</h1>
		</div>
		
	<div id="main">
	<b><h1>로그인 실패</h1></b>
	<br><br>
	일치하는 계정이 없습니다.<br>
	아이디와 비밀번호를 확인해주세요.
	<br><br>
	<input type="button" value="Back" id="login_back" onclick="javascript:history.back(-1)"/>
	
	</div>
</body>
</center>
</html>