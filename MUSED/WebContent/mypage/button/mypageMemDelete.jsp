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
<table width="60" height="30" cellpadding="0" cellspacing="0">
<tr>
	<td>���̵�</td>
	<td>&nbsp;<input type="text" name="id" theme="simple" value="<s:property value="%{resultClass.id}"/>" readonly="true" style="border:0px;"/></td>
</tr>
<tr>
	<td>�̸�</td>
	<td>&nbsp;<input type="text" name="name" theme="simple" value="<s:property value="%{resultClass.name}"/>" readonly="true" style="border:0px;"/></td>
</tr>
<tr>
	<td><input type="button" value="Ż��Ȯ��" onclick="javascript:location.href='memberDeleteAction.action'"/></td>
	<td><input type="button" value="Ż�����" onclick="javascript:location.href='mypage.action'"/></td>
</tr>
</table>
</form>
</center>

</body>
</html>