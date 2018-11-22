<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix = "s" uri = "/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Msg_writeForm</title>
<link rel="stylesheet" href="/MUSED/css/testtest.css"/>
<meta charset="utf-8">
	<script type="text/javascript">
		function check(){
			
			var content = Msg_Wrt.Msg_Content.value;
			var recive = Msg_Wrt.Rec_ID.value;
			
			if (content.length == 0) {
				alert("내용을 입력하세요.");
				Msg_Wrt.Msg_Content.focus();
				return false;
			}
			if (recive.length == 0) {

				alert("받는사람을 입력하세요.");

				Msg_Wrt.Rec_ID.focus();
				return false;
			}
		}
	</script>
</head>
<body>
<div id="myMessage" align="center">
	<table width="100%" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td height="90">
			
			</td>
		</tr>
		
		<tr>
			<td align="center">
				<h1 id="head">메시지 보내기</h1>
			</td>
		</tr>
	</table>
	
		

	<form action="sendMessage.action" method="post" enctype="multipart/form-data" onsubmit="return validation();" name="Msg_Wrt" onsubmit="return check()">
		
	<table width="60%" align="center" border="0" cellspacing="0" cellpadding="0">
			<tr>
			<td height="60">
			
			</td>
		</tr>
		<tr bgcolor="#777777">
			<td height="1" colspan="2">
			</td>
		</tr>
		<tr>
		</tr>
		<tr bgcolor="#777777">
			<td height="2" colspan="2">
			</td>
		</tr>
		<tr height="30">
			<td class="line" width="30%" bgcolor="#F4F4F4">
				&nbsp;보내는 사람</font>
			</td>
			<td width="70%" bgcolor="#FFFFFF">
				<s:property value="%{#session.ID}"/>
			 <input type="hidden" name="msg_wrt_id" value="<s:property value='%{#session.ID}'/>"/>  
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
			<td class="line" bgcolor="#F4F4F4">
				<font color="#FF0000">*</font>내용
			</td>
			<td bgcolor="#FFFFFF">
				<s:textarea name="msg_content" theme="simple"  cols="70" rows="9"  />
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
		<tr height="30">
			<td class="line" bgcolor="#F4F4F4">
				&nbsp;받는 사람
			</td>
			<td bgcolor="#FFFFFF">
			
			<input id="rcv_id" type="text" name="msg_rec_id"  />

			</td>
		</tr>
		<tr bgcolor="#777777">
			<td height="1" colspan="2">
			</td>
		</tr>
		<tr bgcolor="#777777">
			<td height="2" colspan="2">
			</td>
		</tr>
		<tr>
			<td height="60" colspan="2">
			</td>
		</tr>
		
		<tr>
			<td align="right" colspan="2">
				<input name="submit" type="submit" value="보내기" class="inputb">
			    <input name="list" type="button" value="취소" class="inputb" onClick="self.close();" />
			</td>
		</tr>
	</table>
	</form>	
</div>
</body>
</html>
