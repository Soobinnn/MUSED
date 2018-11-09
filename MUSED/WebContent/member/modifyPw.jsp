<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>비밀번호 찾기 성공</title>

<style type="text/css">
.my-box {
	border: 1px solid;
	padding: 10px;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

</head>

<center>
	<body>
		<h1>비밀번호 재설정</h1>
		<br><h5>비밀번호를 재설정 해주세요.</h5>
		<br><br>
		<div class="my-box">
			<form action="ModifyPwAction.action" method="post"
				enctype="multipart/form-data">
				<table>
					<tr>
						<td>ID&nbsp;<input type="text" name="id" value="<s:property value="id"/>"></td>
					</tr>
					<tr>
						<td>PWD&nbsp;<input type="password" name="password"/></td>
					</tr>
					<tr>
						<td>Confirm&nbsp;<input type="password" name="confirm"/></td>
					</tr>
				</table>
		</div><br><br>
				<input type="submit" value="Complete" />
		</form>
		
	</body>
</center>
</html>