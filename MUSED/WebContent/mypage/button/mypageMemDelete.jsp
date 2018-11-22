<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link rel="stylesheet" href="/MUSED/css/mypage.css"/>

<script language="javascript">

function outCheck() {
	
	var out = confirm("정말 탈퇴하시겠습니까?");
	
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

<div class="main">
<center>

<form action="memberDeleteAction.action" method="post" name="delete_form" >
<h1>회원탈퇴 신청</h1><br>
<h2>그동안 MUSED를 이용해 주셔서 감사합니다.</h2><br><br><br>

<h1>탈퇴 아이디 확인</h1><br>

<table border="0" width="60" height="30" cellpadding="0" cellspacing="0">
<tr>
	<td>아이디</td>
	<td>&nbsp;<input type="text" name="id" theme="simple" value="<s:property value="%{resultClass.id}"/>" readonly="true" style="border:0;"/></td>
</tr>
<tr>
	<td>이름</td>

	<td>&nbsp;<input type="text" name="name" theme="simple" value="<s:property value="%{resultClass.name}"/>" readonly="true" style="border:0;"/></td>
</tr>
<tr>
	<td><input type="submit" value="탈퇴확인" onclick="return outCheck();"/></td>
	<td><input type="button" value="탈퇴취소"/></td>
</tr>
</table>
</form>
</center>
</div>

</body>
</html>