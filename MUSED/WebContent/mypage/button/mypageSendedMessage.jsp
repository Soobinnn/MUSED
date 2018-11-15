<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Message</title>
 <script language="javascript">
/* function openMessage() {
	var url = "sendMessageForm.action"
	window.open(
			url,
			"쪽지 보내기",
			"toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no, width=620, height=450");
}*/
function open_win_noresizable(url, name){
	console.log(url);
	console.log(name);
	var oWin = window.open(url,name,"toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no, width=620, height=450" );

}
</script>

</head>

<body>
	<center>
	<table width="80%" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td align="center">
				<h2>보낸 쪽지 함</h2>
			</td>
		</tr> 
		<tr>
			<td height="20">   
			</td>
		</tr>	
	</table>
	
	<table width="80%" border="0" cellspacing="0" cellpadding="2">
		<tr align="center" bgcolor="#f3f3f3">
			<td width="9%">
				<strong>번호</strong>
			</td>
			<td width="12%">
				<strong>받은 사람</strong>
			</td>
			<td width="66%">
				<strong>내용</strong>
			</td>

			<td width="13%">
				<strong>날짜</strong>
			</td>
			
		</tr>
		<tr bgcolor="#777777">
			<td height="1" colspan="4"></td>
		</tr>
		
		<s:iterator value="list" status="stat">
		
			
			
			<tr bgcolor="#FFFFFF" align="center">
				<td>
					<s:property value="msg_no"/>
				</td>
				<td align="center">
					<s:property value="msg_rec_id"/>
				</td>
				<td align="left">&nbsp;
					<a href="#" onClick="javascript:open_win_noresizable('MsgviewAction.action?msg_no=<s:property value="msg_no" />&check=1')">
						<s:property value="msg_content"/>
					</a>
				</td>
				<td align="center">
					<s:property value="msg_regdate"/>
				</td>
			</tr>
			<tr bgcolor="#777777">
				<td height="1" colspan="4">
				</td>
			</tr>
		</s:iterator>
		
		<s:if test="list.size()<=0">
		
			<tr bgcolor="#FFFFFF" align="center">
				<td colspan="4">보낸 쪽지가 없습니다.
				</td>
			</tr>
			<tr bgcolor="#777777">
				<td height="1" colspan="4">
				</td>
			</tr>
			
		</s:if>
			
			<tr align="center">
				<td colspan="4">
					<s:property value="pagingHtml" escape="false"/>
				</td>
			</tr>
			

			<tr align="right">
				<td colspan="4">
				<!-- 	<input type="button" value="쪽지 보내기" onClick="return openMessage()" /> -->
					<input type="hidden" name="wrt_ID" value="${session_ID }" />
				</td>
			</tr>
			
			<tr align="center">
				<td colspan="4">
					<form>
						<select name="searchNum">
							<option value="1">받은 사람</option>
							<option value="2">내용</option>
							<option value="3">날짜</option>
						</select>
						<s:textfield name="searchKeyword" theme="simple"  maxlength="20"/>
						<input name="submit" type="submit" value="검색" class="inputb">
					</form>
				</td>
			</tr>
	</table>
	</center>
</body>
</html>
