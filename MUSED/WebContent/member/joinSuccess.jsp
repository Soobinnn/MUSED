<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>가입 완료</title>
</head>
<center>
<body>
	<h1>Welcome!!</h1>
	<form action="loginForm.action" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>환영합니다.<b><s:property value="id"/></b>님</td>
		</tr>
		<tr>
			<td><input type="submit" value="Login"/>
			&nbsp;<input type="button" value="Main"/></td>
		</tr>
	</table>
	</form>
</body>
</center>

</html>