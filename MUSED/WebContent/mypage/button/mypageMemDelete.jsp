<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<script language="javascript">

function outCheck() {
	
	var out = confirm("���� Ż���Ͻðڽ��ϱ�?");
	
	if(out == true) {
		document.delete_form.submit();
		return true;
	} else {
		return false;
	}

}
</script>
</head>

<body>

<center>
<form action="memberDeleteAction.action" method="post" name="delete_form" >
<h1>ȸ��Ż�� ��û</h1><br>
<h2>�׵��� MUSED�� �̿��� �ּż� �����մϴ�.</h2><br><br><br>

<h1>Ż�� ���̵� Ȯ��</h1><br>

<table border="0" width="60" height="30" cellpadding="0" cellspacing="0">
<tr>
	<td>���̵�</td>
	<td>&nbsp;<input type="text" name="id" theme="simple" value="<s:property value="%{resultClass.id}"/>" readonly="true" style="border:0;"/></td>
</tr>
<tr>
	<td>�̸�</td>

	<td>&nbsp;<input type="text" name="name" theme="simple" value="<s:property value="%{resultClass.name}"/>" readonly="true" style="border:0;"/></td>
</tr>
<tr>
	<td><input type="submit" value="Ż��Ȯ��" onclick="return outCheck();"/></td>
	<td><input type="button" value="Ż�����"/></td>
</tr>
</table>
</form>
</center>

</body>
</html>