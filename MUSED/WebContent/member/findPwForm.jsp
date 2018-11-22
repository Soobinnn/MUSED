<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="/MUSED/css/testtest.css"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>비밀번호 찾기 폼</title>

<style type="text/css">
.my-box 
{
	border: 1px solid;
	padding: 10px;
}
</style>

<script language="javascript">
	function check() {

		var frm = document.findPw_form;

		if (frm.id.value == "") {
			alert("아이디를 입력해주십시오.");
			frm.id.focus();
			return false;
		}
		if (frm.name.value == "") {
			alert("이름을 입력해주십시오.");
			frm.name.focus();
			return false;
		}
		if (frm.jumin1.value == "") {
			alert("주민번호 앞자리를 입력해주십시오.");
			frm.jumin1.focus();
			return false;
		}
		if (frm.jumin2.value == "") {
			alert("주민번호 뒷자리를 입력해주십시오.");
			frm.jumin2.focus();
			return false;
		}
		if (frm.phone.value == "") {
			alert("핸드폰 번호를 입력해주십시오.");
			frm.phone.focus();
			return false;
		}
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

</head>
<center>
	<body>
	<div id="heading" >
	<h1>비밀번호 찾기</h1>
	</div>
	<div id="main">
		<h1>비밀번호 찾기</h1>
		<div class="my-box">
			<form name="findPw_form" action="findPwAction.action" method="post" onsubmit="return check()">
				<table id="findpwdtable0">
					<tr>
						<td><h1 id="findpwdtable1">ID&nbsp;</h1><input id="findpwdtable2" type="text" name="id"> &nbsp;<a
							id="findpwdtable3" href="findIdForm.action"><h1 >ID가 기억이 안나시나요?</h1></a>
						</td>
					<tr>
						<td><h5 id="findpwdtable4">회원정보에 등록한 휴대전화 번호와 같아야 합니다.</h5></td>
					</tr>
					<tr>
						<td><h1 id="findpwdtable5">Name&nbsp;</h1><input id="findpwdtable6" type="text" name="name" /></td>
					</tr>
					<tr>
						<td><h1 id="findpwdtable7">Jumin&nbsp;</h1><input id="findpwdtable8" type="text" name="jumin1" maxlength="6" size="7" />
						<h1 id="findpwdtable9"> -</h1><input id="findpwdtable10" type="password" name="jumin2" maxlength="7" size="7" />
						</td>
					</tr>
					<tr>
						<td><h1 id="findpwdtable11">Phone&nbsp;</h1><input id="findpwdtable12"type="text" name="phone" /></td>
				</table>
		</div>
		<input id="findsuccess_1" type="submit" value="Next" />&nbsp;
		<input id="findsuccess_2" type="button" value="Cancle"
			onclick="location.href='loginForm.action'" />
		</form>
		</div>
	</body>
</center>	
</html>