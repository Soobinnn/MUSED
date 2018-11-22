<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<link rel="stylesheet" href="/MUSED/css/testtest.css"/>	
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


	<body>
	<div id="heading" >
	<h1>아이디 찾기</h1>
	</div>
<div id="main">
		<h1>아이디 찾기</h1>
		<form action="findIdAction.action" method="post">
				<div id="find_auth">
				<input id="auth1" type="radio" name="auth" onClick="display_jumin()" value="J" checked />
				<label for="auth1">&nbsp;이름/주민번호로 찾기</label>
				<input id="auth2"type="radio" name="auth" onClick="display_email()"value="E" />
				<label for="auth2">&nbsp;전화번호/이메일로 찾기</label>		
				</div>
				<table id="findtable" width="100%" border="0" cellspacing="0" cellpadding="3">
				<tr align="center">
				</tr>
				<tr id="jumin_1" align="center">
					<td>회원정보에 등록한 이름/주민번호와 같아야 합니다.</td>
				</tr>
				<tr id="jumin_2" align="center">
					<td id="findtable2" ><h1 id="findtable2_2">Name <input id="findtable2_1" type="text" name="name" /></td>
				</tr>
				<tr id="jumin_3" align="center">
					<td id="findtable3" ><h1 id="findtable3_0">Jumin</h1> <input id="findtable3_1" type="text" name="jumin1" size="5"
						maxlength="6" /><h1 id="findtable3_3">&nbsp;-&nbsp;</h1> <input id="findtable3_2" type="password" name="jumin2"
						size="5" maxlength="7" /></td>
				</tr>
				<tr id="jumin_4" align="center">
					<td id="findtable_s"><input type="submit" value="Search" /></td>
				</tr>
			</table>
			<br>
			<br>
			<table id="findtable4">
				<tr id="email_1" align="center" style="display: none">
					<td>회원정보에 등록한 전화번호/이메일 주소와 같아야 합니다.</td>
				</tr>
				<tr id="email_2" align="center" style="display: none">
					<td ><h1 id="findtable4_1">Phone &nbsp;</h1><input id="findtable4_2" type="text" name="phone" /></td>
				</tr>
				<tr id="email_3" align="center" style="display: none">
					<td ><h1 id="findtable4_3">Email &nbsp;</h1><input id="findtable4_4" type="text" name="email" /></td>
				</tr>
				<tr id="email_4" align="center" style="display: none">
					<td id="findtable4_5"><input type="submit" value="Search" /></td>
				</tr>
			</table>
		</form>
		</div>
	</body>
</html>