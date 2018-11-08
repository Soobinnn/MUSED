<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>아이디찾기폼</title>

<script language="javascript">
	function display_jumin(box) {
		jumin_1.style.display = 'block';
		jumin_2.style.display = 'block';
		jumin_3.style.display = 'block';
		jumin_4.style.display = 'block';
		email_1.style.display = 'none';
		email_2.style.display = 'none';
		email_3.style.display = 'none';
		email_4.style.display = 'none';
	}

	function display_email(box) {
		jumin_1.style.display = 'none';
		jumin_2.style.display = 'none';
		jumin_3.style.display = 'none';
		jumin_4.style.display = 'none';
		email_1.style.display = 'block';
		email_2.style.display = 'block';
		email_3.style.display = 'block';
		email_4.style.display = 'block';
	}
</script>
</head>

<center>
	<body>
		<h1>아이디 찾기</h1>
		<form action="findIdAction.action" method="post">		
			<table width="100%" border="0" cellspacing="0" cellpadding="3">
				<tr align="center">
					<td><input type="radio" name="auth" onClick="display_jumin()"
						value="J" checked />&nbsp;이름/주민번호로 찾기</td>
				</tr>
				<tr id="jumin_1" align="center">
					<td>회원정보에 등록한 이름/주민번호와 같아야 합니다.</td>
				</tr>
				<tr id="jumin_2" align="center">
					<td>Name &nbsp;<input type="text" name="name" /></td>
				</tr>
				<tr id="jumin_3" align="center">
					<td>Jumin &nbsp;<input type="text" name="jumin1" size="5"
						maxlength="6" />&nbsp;-&nbsp; <input type="password" name="jumin2"
						size="5" maxlength="7" /></td>
				</tr>
				<tr id="jumin_4" align="center">
					<td><input type="submit" value="Search" /></td>
				</tr>
			</table>
			<br>
			<br>
			<table>
				<tr align="center">
					<td><input type="radio" name="auth" onClick="display_email()"
						value="E" />&nbsp;전화번호/이메일로 찾기</td>
				</tr>
				<tr id="email_1" align="center" style="display: none">
					<td>회원정보에 등록한 전화번호/이메일 주소와 같아야 합니다.</td>
				</tr>
				<tr id="email_2" align="center" style="display: none">
					<td>Phone &nbsp;<input type="text" name="phone" /></td>
				</tr>
				<tr id="email_3" align="center" style="display: none">
					<td>Email &nbsp;<input type="text" name="email" /></td>
				</tr>
				<tr id="email_4" align="center" style="display: none">
					<td><input type="submit" value="Search" /></td>
				</tr>
			</table>
		</form>
	</body>
</center>
</html>