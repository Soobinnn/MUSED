<%@ page contentType="text/html; charset=euc-kr"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<?xml version="1.0" encoding="euc-kr" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>�������� ��</title>

<script type="text/javascript">
	
	function authCheck() {

		var phone = auth_form.phone.value;

		if(auth_form.authNum.value != "" && auth_form.authNum.value == "${authNum}") {
			
			alert("�����Ǿ����ϴ�.");
			
			opener.document.join_form.phone.value = phone;		
			self.close();
		} else{
			alert("������ȣ�� Ʋ���ϴ�.");
			return false;
		}
		
	}
</script>

</head>

<center>
	<body>
		<h3>��������</h3>
		<br><br>
				<form name="auth_form" action="authCheckAction.action" method="post"
					enctype="multipart/form-data">
					<table>
						<tr>
							<td>Phone&nbsp;<input type="text" name="phone" value="<s:property value="phone"/>"></input></td>
							<td><input type="submit" value="��������" /></td>
						</tr>
						<tr>
							<td>������ȣ&nbsp;<input type="text" id="authNum" name="authNum"
								maxlength="6"></input></td>
							<td><input type="button" name="authOk" value="Ȯ��" onclick="authCheck()"/></td>
						</tr>
					</table>

				</form>
	</body>
</center>
</html>