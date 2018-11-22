<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="util.CookieBox"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="/MUSED/css/testtest.css"/>
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
		<div id="heading" >
			<h1>로그인</h1>
		</div>
	
	
		<div id="main">
		<img id="login_logo" src="/MUSED/css/main_logo.png" >
		<form name="loginForm" action="loginAction.action" method="post">
			<table id="logintable">
				<tr>
					<td id="logintable1" align="center">ID</td>
					<%
						String sid = request.getParameter("selectedId");
					%>
					<%
						if (sid == null && cookieBox.exists("ID")) {
					%>
					<td align="center"><input type="text" name="id" size="17"
						value="<%=cookieBox.getValue("ID")%>"></td>
					<%
						} else if(sid != null){
					%>
					<td align="center"><input type="text" name="id" size="17"
						value="<%=sid%>"></td>
					<%
						} else { %>		
						<td align="center"><input type="text" name="id" size="17"
						value=""></td>
					<%} %>
					<td>&nbsp;</td>
					<td id="logintable2" align="left">
						<input type="checkbox" id="saveId" name="saveId" value="1" />
						<label for="saveId">SAVE ID</label>
					</td>
				</tr>
				<tr>
					<td id="logintable3" align="center">PWD</td>
					<td align="right"><input type="password" name="password"
						size="17"></td>
				</tr>
				<tr align="center">
					<td></td>
					<td align="center"><input id="login" type="submit" value="LOGIN" ></td>
				</tr>
				<tr>
				</tr>
				<tr align="center">
					<td class="login_bottom"><a href="joinConfirm.action">Join Us</a></td>
					<td class="login_bottom"><a href="findIdForm.action">Find ID</a></td>
					<td class="login_bottom"><a href="findPwForm.action">Find PWD</a></td>
				</tr>
			</table>
			

		</form>
		</div>
	</body>
</center>
</html>