<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Msg_viewlist</title>
<meta charset="utf-8">

<script type="text/javascript">
function openMessage() {
	var url = "ReMessageForm.action"
	window.open(
			url,
			"메시지 보내기",
			"toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no, width=620, height=450");
}
</script> 
</head>
<body>

	<table width="100%" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td align="center">
				<h2>메시지 보기</h2>
			</td>
		</tr>
	</table>
	

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
		</tr>
		<tr bgcolor="#777777">
			<td height="1" colspan="2">
			</td>
		</tr>
		<tr>
		</tr>
		<tr bgcolor="#777777">
			<td height="1" colspan="2">
			</td>
		</tr>
		<tr>
			<td bgcolor="#F4F4F4">
				&nbsp;<font size="2">보내는 사람</font>
			</td>
			<td bgcolor="#FFFFFF">
			
			<s:property value="resultClass.msg_wrt_id" /> 
			</td>
		</tr>
		<tr bgcolor="#777777">
			<td height="1" colspan="2">
			</td>
		</tr>
		
		<tr bgcolor="#777777">
			<td height="1" colspan="2">
			</td>
		</tr>
		
		<tr>
			<td bgcolor="#F4F4F4">
				<font color="#FF0000">*</font>내용
			</td>
			<td bgcolor="#FFFFFF">
				<%-- <s:textarea readonly="true" name="msg_content" theme="simple" value="%{resultClass.msg_content}" cols="50" rows="10"  /> --%>
				<s:property value="%{resultClass.msg_content}" />	
			</td>
		</tr>
				<tr bgcolor="#777777">
			<td height="1" colspan="2">
			</td>
		</tr>
		
		<tr bgcolor="#777777">
			<td height="1" colspan="2">
			</td>
		</tr>
		<tr>
			<td bgcolor="#F4F4F4">
				&nbsp;<font size="2">받는 사람</font>
			</td>
			<td bgcolor="#FFFFFF">
			
			<s:property value="resultClass.msg_rec_id" />

			</td>
		</tr>
		<tr bgcolor="#777777">
			<td height="1" colspan="2">
			</td>
		</tr>
		<tr bgcolor="#777777">
			<td height="1" colspan="2">
			</td>
		</tr>
		<tr>
			<td height="10" colspan="2">
			</td>
		</tr>
		
		<tr>
			<td align="right" colspan="2">
				<s:if test="check==0">
					<input name="submit" type="submit" value="답장" onclick="openMessage()" />
				</s:if>
			
			    <input name="list" type="button" value="창 닫기" onClick="self.close();" />
			</td>
		</tr>
	</table>
</body>
</html>