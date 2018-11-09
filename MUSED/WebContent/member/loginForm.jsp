<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="util.CookieBox"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>로그인 폼</title>

<script language="javascript">
	function begin() {
		document.loginForm.id.focus();
	}

	function checkIt() {
		if (!document.loginForm.id.value) {
			alert("이름을 입력하지 않으셨습니다.");
			document.myform.id.focus();
			return false;
		}
		if (!document.loginForm.password.value) {
			alert("비밀번호를 입력하지 않으셨습니다.");
			document.myform.passwd.focus();
			return false;
		}
	}
</script>
</head>
<center>
	<body onLoad="begin()">
		<%
			CookieBox cookieBox = new CookieBox(request);
		%>
		<b><h1>MUSED</h1></b>
		<form name="loginForm" action="loginAction.action" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td align="center">ID</td>
					<%
						String sid = request.getParameter("selectedId");
					%>
					<%
						if (cookieBox.exists("ID")) {
					%>
					<td align="center"><input type="text" name="id" size="17"
						value="<%=cookieBox.getValue("ID")%>"></td>
					<%
						} else if (sid == null) {
					%>
					<td align="center"><input type="text" name="id" size="17"
						value="<%=sid%>"></td>
					<%
						} else {
					%>
					<td align="center"><input type="text" name="id" size="17"
						value=""></td>
					<%
						}
					%>
					<td><input type="checkbox" name="saveId" value="1" />Save Id</td>
				</tr>
				<tr>
					<td align="center">PWD</td>
					<td align="center"><input type="password" name="password"
						size="17"></td>
				</tr>
				<tr align="center">
					<td></td>
					<td><input type="submit" value="LOGIN"></td>
				</tr>
				<tr align="center">
					<td><a href="joinConfirm.action">Join Us</a></td>
					<td><a href="findIdForm.action">Find ID</a></td>
					<td><a href="findPwForm.action">Find PWD</a></td>
				</tr>
			</table>


		</form>
	</body>
</center>
</html>