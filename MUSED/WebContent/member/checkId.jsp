<%@ page contentType="text/html; charset=euc-kr"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<?xml version="1.0" encoding="euc-kr" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<script type="text/javascript">
function windowclose() {
	opener.document.join_form.id.value="${id}";
	
	self.close();
}

</script>

</head>
<body bgcolor="#f5f5f5">
<s:if test="chkNo==1">
	<form name="checkId" action="checkIdAction.action" method="post" enctype="multipart/form-data">
		<table width="400" border="0" cellspacing="0" cellpadding="5">
			<tr align="center">
				<td height="30">
					<font><b>${id}</b>��(��)<br>
					�̹� ��� ���� ���̵� �Դϴ�.</font>
				</td>
			</tr>
		</table><br/>
		<table width="400" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">
					<font>�ٸ� ���̵� �Է����ּ���.</font><br/>
					<input type="text" size="10" maxlength="20" name="id"/>
					<input type="submit" value="�ߺ�Ȯ��"/>
				</td>
			</tr>
		</table>
	</form>
</s:if>
<s:else>
	<table width="400" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td align="center">
				<br><br>
				<font>�Է��Ͻ� <b>${id}</b> ��(��) <br>
				����Ͻ� �� �ִ� ���̵��Դϴ�.</font>
				<br><br>
				<input type="button" value="Close" onclick="windowclose()"/>
			</td>
		</tr>
	</table>
</s:else>
</body>
</html>