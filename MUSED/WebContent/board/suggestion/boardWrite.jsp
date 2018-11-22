<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>건 의 사 항</title>
<link rel="stylesheet" href="/MUSED/css/board.css"/>
<script type="text/javascript">
	function validation() {
		var frm = document.writef;

		if (frm.subject.value == "") {
			alert("제목을 입력해주세요.");
			return false;
		}

		else if (frm.name.value == "") {
			alert("이름을 입력해주세요");
			return false;
		
		}  else if (frm.content.value == "") {
			alert("내용을 입력해주세요.");
			return false;
		}
		 
	   return true;
	}
	$(document).ready(function(){
		     $("#content").cleditor();
	});
</script>
</head>


<body>
<div id="board" align="center">
	<table width="95%" border="0" cellspacing="0" cellpadding="2">
			<tr>
	<td><br></br></td>
	</tr>
		<tr>
			<td align="center"><h2>건 의 사 항</h2></td>
		</tr>
	</table>
	
	<s:if test="reply">
	   <form name="writef" action="replyAction.action" method="post" enctype="multipart/form-data" onsubmit="return validation();">
	     <s:hidden name="ref" value="%{resultClass.ref}" /> <%-- html hidden field 태그를 이용해서 자동으로 값을 전송한다. --%>
	     <s:hidden name="re_level" value="%{resultClass.re_level}" />
	     <s:hidden name="re_step" value="%{resultClass.re_step}" />
	</s:if>
	
	<s:elseif test="resultClass == NULL">
		<%-- resultClass가 없으면 첫 입력으로 인식 --%>
		<form name="writef" action="/MUSED/tiles/sug/writeAction.action" method="post"
			enctype="multipart/form-data" onsubmit="return validation();">
	</s:elseif>

	<s:else>
		<%-- resultClass가 있으면 수정으로 인식 --%>
		<form name="writef" action="modifyAction.action" method="post"
			enctype="multipart/form-data" onsubmit="return validation();">
			<s:hidden name="no" value="%{resultClass.no}" />
			<s:hidden name="currentPage" value="%{currentPage}" />
			<s:hidden name="old_file" value="%{resultClass.file_savname}" />
	</s:else>

	<table width="80%" height="100%" border="0" cellspacing="0" cellpadding="0">
		<tr height="30">
			<td align="right" colspan="2">&nbsp;<font size="2p" color="#FF0000">* 는 필수
				입력사항입니다.</font></td>
		</tr>

		<tr>
			<td height="2" colspan="2"></td>
		</tr>
		

		<tr height="30">
			<td width="20%" bgcolor="#F4F4F4" class="freewrite"> &nbsp;<font color="#FF0000">*</font>
				제 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;목</td>
			<td width="80%" bgcolor="#FFFFFF" class="freewrite">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<s:textfield name="subject"
				 theme="simple" value="%{resultClass.subject}"
				 maxlength="50" /></td>
		</tr>

		<tr>
			<td height="2" colspan="2"></td>
		</tr>

		<tr height="30">
			<td bgcolor="#F4F4F4" class="freewrite"><font color="#FF0000">  &nbsp;*  &nbsp;</font>이  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;름</td>
			<td bgcolor="#FFFFFF" class="freewrite">
			   <%--수정된 로직 시작 --%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="#3B0B0B"><s:property value="%{#session.ID}" /></font>
		      <input type="hidden" name="name" value="<s:property value='%{#session.ID}' />"/>
			
		    <%--수정된 로직 종료, html태그로 받는데 value값 안에 s:property value를 써서 받는다. --%>
			</td>
		</tr>

		<tr>
			<td height="2" colspan="2"></td>
		</tr>



		<tr height="350">
			<td bgcolor="#F4F4F4" class="freewrite"><font color="#FF0000">*</font>내용</td>
			<td bgcolor="#FFFFFF" class="freeup"><s:textarea name="content" theme="simple"
					value="%{resultClass.content}" cols="90%" rows="20" /><pre></pre></td>
		</tr>

		<tr>
			<td height="2" colspan="2"></td>
		</tr>
		<tr>
			<td height="10" colspan="2"></td>
		</tr>


		<tr>
			<td align="right" colspan="2">
			  <input name="submit" type="submit" value="작성완료" class="inputb"/>
			   <input name="list" type="button" value="목록" class="inputb"
					onClick="javascript:location.href='listAction.action?currentPage=<s:property value="currentPage"/>'"/></td>
		</tr>
	</table>
</div>
</body>
</html>