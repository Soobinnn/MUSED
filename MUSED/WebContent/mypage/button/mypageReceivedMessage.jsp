<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<link rel="stylesheet" href="/MUSED/css/testtest.css"/>
<title>Message</title>
<meta charset="utf-8">
 <script language="javascript">
/* function openMessage() {
	var url = "sendMessageForm.action"
	window.open(
			url,
			"쪽지 보내기",
			"toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no, width=620, height=450");
} */
function open_win_noresizable(url, name){
	console.log(url);
	console.log(name);
	var oWin = window.open(url,name,"toolbar=no, location=no, status=no, menubar=no, scrollbars=yes, resizable=no, width=620, height=450" );
	
}
</script> 

</head>

<body>
	<center>
	<div id="myMessage" align="center">
	<table width="90%" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td colspan="5" align="center">
				<br/><h1 style="font-weight:bold;">받은 쪽지 함</h1><br/>
			</td>
		</tr> 
		<tr>
			<td height="20">   
			</td>
		</tr>	
	
		<tr align="center" height="40" bgcolor="#f3f3f3">
			<td width="9%"><br/>
				<strong>번호</strong>
			</td>
			<td width="12%"><br/>
				<strong>보낸 사람</strong>
			</td>
			<td width="61%"><br/>
				<strong>내용</strong>
			</td>

			<td width="13%"><br/>
				<strong>날짜</strong>
			</td>
			
			<td width="4%"><br/>
				<strong>삭제</strong>
			</td>
			
		</tr>
		<tr bgcolor="#777777">
			<td height="1" colspan="5"></td>
		</tr>
		
		<s:iterator value="list" status="stat">
		
			
			
			<tr height="30" align="center">
				<td class="line">
					<s:property value="msg_no"/>
				</td>
				<td class="line" align="center">
					<s:property value="msg_wrt_id"/>
				</td>
				<td class="line" align="left">&nbsp;
					<a href="#" onClick="javascript:open_win_noresizable('MsgviewAction.action?msg_no=<s:property value="msg_no" />&check=0')">
						<s:property value="msg_content"/>
					</a>
				</td>
				<td class="line" align="center">
					<s:property value="msg_regdate"/>
				</td>
				<td class="line"><s:url id="DeleteURL" action="deleteRead">
						<s:param name="msg_no">
							<s:property value="msg_no" />
						</s:param>
						<s:param name="msg_rec_id">
							<s:property value="%{#session.ID}" />
						</s:param>
						<s:param name="currentPage">
							<s:property value="currentPage" />
						</s:param>
					</s:url> <s:a href="%{DeleteURL}">X</s:a></td>
			</tr>
		</s:iterator>
		
			<tr bgcolor="#777777">
				<td height="1" colspan="5">
				</td>
			</tr>
		
		<s:if test="list.size()<=0">
		
			<tr align="center" height="30">
				<td colspan="5"  class="line">받은 쪽지가 없습니다.
				</td>
			</tr>
			<tr bgcolor="#777777">
				<td height="1" colspan="5">
				</td>
			</tr>
			
		</s:if>
			  <s:hidden name="currentPage" value="%{currentPage}" />
			<tr align="center">
				<td colspan="5">
					<s:property value="pagingHtml" escape="false"/>
				</td>
			</tr>
			

			<tr align="right">
				<td colspan="5">
					<!-- <input type="button" value="쪽지 보내기" onClick="return openMessage()" /> -->
					<%-- <input type="hidden" name="wrt_ID" value="${#session.ID }" /> --%>
				</td>
			</tr>
			
			<tr align="center">
				<td colspan="5">
					<form>
						<select id="MsearchA" name="searchNum">
							<option value="0">보낸 사람</option>
							<option value="2">내용</option>
							<option value="3">날짜</option>
						</select>
						<s:textfield id="MsearchB" name="searchKeyword" theme="simple"  maxlength="20"/>
						<input id="MsearchC" name="submit" type="submit" value="검색" class="inputb">
					</form>
				</td>
			</tr>
	</table>
	</div>
	</center>
</body>
</html>