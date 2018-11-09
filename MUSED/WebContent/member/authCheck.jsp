<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>본인인증 폼</title>

<script type="text/javascript">
	
	function authCheck() {

		var phone = auth_form.phone.value;

		if(auth_form.authNum.value != "" && auth_form.authNum.value == "${authNum}") {
			
			alert("인증되었습니다.");
			
			opener.document.join_form.phone.value = phone;		
			self.close();
		} else{
			alert("인증번호가 틀립니다.");
			return false;
		}
		
	}
</script>

</head>

<center>
	<body>
		<h3>본인인증</h3>
		<br><br>
				<form name="auth_form" action="authCheckAction.action" method="post">
					<table>
						<tr>
							<td>Phone&nbsp;<input type="text" name="phone" value="<s:property value="phone"/>"></input></td>
							<td><input type="submit" value="본인인증" /></td>
						</tr>
						<tr>
							<td>인증번호&nbsp;<input type="text" id="authNum" name="authNum"
								maxlength="6"></input></td>
							<td><input type="button" name="authOk" value="확인" onclick="authCheck()"/></td>
						</tr>
					</table>

				</form>
	</body>
</center>
</html>