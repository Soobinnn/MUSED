<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>��й�ȣ ã�� ��</title>

<style type="text/css">
.my-box {
	border: 1px solid;
	padding: 10px;
}
</style>

<script language="javascript">
	function check() {

		var frm = document.findPw_form;

		if (frm.id.value == "") {
			alert("���̵� �Է����ֽʽÿ�.");
			frm.id.focus();
			return false;
		}
		if (frm.name.value == "") {
			alert("�̸��� �Է����ֽʽÿ�.");
			frm.name.focus();
			return false;
		}
		if (frm.jumin1.value == "") {
			alert("�ֹι�ȣ ���ڸ��� �Է����ֽʽÿ�.");
			frm.jumin1.focus();
			return false;
		}
		if (frm.jumin2.value == "") {
			alert("�ֹι�ȣ ���ڸ��� �Է����ֽʽÿ�.");
			frm.jumin2.focus();
			return false;
		}
		if (frm.phone.value == "") {
			alert("�ڵ��� ��ȣ�� �Է����ֽʽÿ�.");
			frm.phone.focus();
			return false;
		}
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

</head>

<center>
	<body>
		<h1>��й�ȣ ã��</h1>
		<div class="my-box">
			<form name="findPw_form" action="findPwAction.action" method="post"
				enctype="multipart/form-data" onsubmit="return check()">
				<table>
					<tr>
						<td>ID&nbsp;<input type="text" name="id"> &nbsp;<a
							href="findIdForm.action">ID�� ����� �ȳ��ó���?</a>
						</td>
					<tr>
						<td><h5>ȸ�������� ����� �޴���ȭ ��ȣ�� ���ƾ� �մϴ�.</h5></td>
					</tr>
					<tr>
						<td>Name&nbsp;<input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>Jumin&nbsp;<input type="text" name="jumin1" maxlength="6"
							size="7" /> -<input type="password" name="jumin2" maxlength="7"
							size="7" />
						</td>
					</tr>
					<tr>
						<td>Phone&nbsp;<input type="text" name="phone" /></td>
				</table>
		</div>
		<br>
		<br>
		<input type="submit" value="Next" />&nbsp;
		<input type="button" value="Cancle"
			onclick="location.href='loginForm.action'" />
		</form>
	</body>
</center>
</html>