<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<?xml version="1.0" encoding="utf-8" ?>
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
	<form name="checkId" action="checkIdAction.action" method="post">
		<table width="400" border="0" cellspacing="0" cellpadding="5">
			<tr align="center">
				<td height="30">
					<font><b>${id}</b>은(는)<br>
					이미 사용 중인 아이디 입니다.</font>
				</td>
			</tr>
		</table><br/>
		<table width="400" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">
					<font>다른 아이디를 입력해주세요.</font><br/>
					<input type="text" size="10" maxlength="20" name="id"/>
					<input type="submit" value="중복확인"/>
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
				<font>입력하신 <b>${id}</b> 은(는) <br>
				사용하실 수 있는 아이디입니다.</font>
				<br><br>
				<input type="button" value="Close" onclick="windowclose()"/>
			</td>
		</tr>
	</table>
</s:else>
</body>
</html>