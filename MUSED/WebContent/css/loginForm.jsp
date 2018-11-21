<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<link rel="stylesheet" href="/MUSED/css/testtest.css"/>

<html>
<head>
<title>로그인 폼</title>

</head>
<center>
	<body>
		<div id="main">
		<form name="loginForm" action="loginAction.action" method="post">		
			
		<div id="login_id">
					&nbsp;<h1>MUSED</h1>
	
					ID
				<input type="text" name="id" size="17" placeholder="아이디" width="100px">
	
					<input type="checkbox" id="saveId" name="saveId" value="1" />
					<label for="saveId">SAVE ID</label>
		</div>
		<div id="login_pwd">
					PWD
					<input type="password" name="password" size="17" placeholder="비밀번호">
		</div>
		<div id="login_submit">
				
					<input type="submit" value="LOGIN">
		</div>		
		<div id="login_opt">
					<a href="joinConfirm.action">Join Us</a>
					<a href="findIdForm.action">Find ID</a>
					<a href="findPwForm.action">Find PWD</a>
		</div>


		</form>
		</div>
	</body>
</center>
</html>