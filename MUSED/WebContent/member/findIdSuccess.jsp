<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>���̵� ã�� ����</title>

<style type="text/css">
.my-box {
	border: 1px solid;
	padding: 10px;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

</head>

<center>
	<body>
		<h1>���̵� ã��</h1>
		<br>������ ������ ��ġ�ϴ� ���̵� ����Դϴ�.
		<br>
		<div class="my-box">
			<form action="loginForm.action" method="post"
				enctype="multipart/form-data">
				<table>
				<s:iterator value="%{list}" status="stat">
					<tr>
						<td><input type="radio" name="selectedId" value="<s:property value="list.get(#stat.index).id"/>">
							&nbsp; <s:property value="list.get(#stat.index).id"/></td>
					</tr>
				</s:iterator>
				</table>
		</div><br><br>
				<input type="submit" value="Login" /> &nbsp; <input
							type="button" value="Find PWD" onclick="javascript:location.href='findPwForm.action'"/>
		</form>
		
	</body>
</center>
</html>