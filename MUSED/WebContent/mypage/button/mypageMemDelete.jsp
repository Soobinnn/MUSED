<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>

<center>
<form action="memberDeleteAction" method="post" name="delete_form" >
<h1>ȸ��Ż�� ��û</h1><br>
<h2>�׵��� MUSED�� �̿��� �ּż� �����մϴ�.</h2><br><br><br>

<h1>Ż�� ���̵� Ȯ��</h1><br>
<table border="1" width="60" height="30" cellpadding="0" cellspacing="0">
<tr>
	<td>���̵�</td>
	<td>&nbsp;<s:textfield name="id" theme="simple" value="%{resultClass.id}" readonly="true"/></td>
</tr>
<tr>
	<td>�̸�</td>
	<td>&nbsp;<s:textfield name="name" theme="simple" value="%{resultClass.name}" readonly="true"/></td>
</tr>
<tr>
	<td><input type="button" value="Ż��Ȯ��" onclick="javascript:location.href='memberDeleteAction.action'"/></td>
	<td><input type="button" value="Ż�����"/></td>
</tr>
</table>
</form>
</center>

</body>
</html>