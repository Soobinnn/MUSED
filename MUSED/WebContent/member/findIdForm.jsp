<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>���̵�ã����</title>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

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
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>

<center>
	<body>
		<h1>���̵� ã��</h1>
		<form action="findIdAction.action" method="post" enctype="multipart/form-data">		
			<table width="100%" border="0" cellspacing="0" cellpadding="3">
				<tr align="center">
					<td><input type="radio" name="auth" onClick="display_jumin()"
						value="J" checked />&nbsp;�̸�/�ֹι�ȣ�� ã��</td>
				</tr>
				<tr id="jumin_1" align="center">
					<td>ȸ�������� ����� �̸�/�ֹι�ȣ�� ���ƾ� �մϴ�.</td>
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
						value="E" />&nbsp;��ȭ��ȣ/�̸��Ϸ� ã��</td>
				</tr>
				<tr id="email_1" align="center" style="display: none">
					<td>ȸ�������� ����� ��ȭ��ȣ/�̸��� �ּҿ� ���ƾ� �մϴ�.</td>
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