<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>비밀번호 찾기 성공</title>

<style type="text/css">
.my-box {
	border: 1px solid;
	padding: 10px;
}
</style>

<script language="javascript">

function checkPw(){
	var frm = document.modifyPw;
	var check = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{6,12}$/;
		
	if (frm.password.value == "") {
		alert("비밀번호를 입력해주십시오.");
		frm.password.focus();
		return false;
	}
	if(frm.password.value.length < 6 || frm.password.value.length > 12) {
		alert("암호를 6 ~ 12자 이하로 설정해주세요.");
		return false;
	}
	if(!check.test(frm.password.value)) {
		alert("영문, 숫자, 특수문자 조합으로 입력해주세요.");
		return false;
	}
	if (frm.password.value != frm.password2.value) {
		alert("비밀번호가 다릅니다.");
		frm.password2.select();
		return false;
	}
	
	return true;
}
</script>
</head>

<center>
	<body>
		<h1>비밀번호 재설정</h1>
		<br>
		<h5>비밀번호를 재설정 해주세요.</h5>
		<br>
		<br>
		<div class="my-box">
			<form name="modifyPw" action="ModifyPwAction.action" method="post" onsubmit="return checkPw()">
				<table>
					<tr>
						<td>ID&nbsp;<input type="text" name="id"
							value="<s:property value="id"/>"></td>
					</tr>
					<tr>
						<td>PWD&nbsp;<input type="password" name="password" /></td>
					</tr>
					<tr>
						<td>Confirm&nbsp;<input type="password" name="password2" /></td>
					</tr>
				</table>
				<input type="submit" value="Complete" />
			</form>
		</div>
		<br>
		<br>
		
		

	</body>
</center>
</html>