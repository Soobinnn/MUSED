<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>공 지 사 항</title>
<link rel="stylesheet" href="/MUSED/css/board.css"/>
<script type="text/javascript">
	function validation()
	{
		var frm = document.writef;

		if(frm.subject.value == "")
		{
			alert("제목을 입력해주세요");
			return false;
		}
		else if(frm.name.value == "")
		{
			alert("이름을 입력해주세요");
			return false;
		}
		else if(frm.password.value == "")
		{
			alert("비밀번호를 입력해주세요");
			return false;
		}
		else if(frm.content.value == "")
		{
			alert("내용을 입력해주세요");
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
			<td align="center"><h2>공 지 사 항</h2></td>
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
		<form name="writef" action="/MUSED/tiles/notice/writeAction.action" method="post"
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
			<td align="right" colspan="2"> &nbsp;<font size="2p" color="#FF0000">*는 필수
				입력사항입니다.</font></td>
		</tr>

		<tr height="30">
			<td width="20%" bgcolor="#F4F4F4" class="freewrite">&nbsp;<font color="#FF0000">*</font>
				 &nbsp;제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</td>
			<td width="80%" bgcolor="#FFFFFF" class="freewrite">
			  			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			     <s:textfield name="subject" theme="simple" value="%{resultClass.subject}" cssStyle="width:370px" maxlength="50" />
			</td>
		</tr>

			<tr>
			<td height="2" colspan="2"></td>
		</tr>
		<tr height="30">
			<td bgcolor="#F4F4F4"  class="freewrite">  &nbsp;<font color="#FF0000">*</font>  &nbsp;이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름</td>
			<td bgcolor="#FFFFFF"  class="freewrite">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<%-- 세션에서 ID 가져오기 --%>
			<font color="#3B0B0B"><s:property value="%{#session.ID}" /></font>
		<input type="hidden" name="name" value="<s:property value='%{#session.ID}' />"/>
			 <%-- 종료 --%>
			</td>
		</tr>
		<tr>
			<td height="2" colspan="2"></td>
		</tr>


	<%-- 	<tr>
			<td bgcolor="#F4F4F4"><font color="#FF0000">*</font>비밀번호</td>
			<td bgcolor="#FFFFFF"><s:textfield name="password"
					theme="simple" value="%{resultClass.password}"
					cssStyle="width:20px" maxlength="30" /></td>
		</tr> --%>

		<tr height="350">
			<td bgcolor="#F4F4F4" class="freewrite">&nbsp;<font color="#FF0000">*</font> &nbsp;내&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;용</td>
			<td bgcolor="#FFFFFF" class="freeup">&nbsp;&nbsp;&nbsp;<s:textarea name="content" theme="simple"
					value="%{resultClass.content}" cols="90%" rows="20" /><pre></pre></td>
		</tr>

		<tr>
			<td height="2" colspan="2"></td>
		</tr>
<%-- 

		<tr>
			<td bgcolor="#F4F4F4">첨부파일</td>
			<td bgcolor="#FFFFFF"><s:file name="upload" theme="simple" /> <s:if
					test="resultClass.file_orgname != NULL">
                     &nbsp; * <s:property
						value="resultClass.file_orgname" />파일이 등록되어 있습니다. 다시 업로드하면 기존의 파일은 삭제됩니다.
                 </s:if></td>
		</tr>
		 --%>
				<tr height="30">
			<td bgcolor="#F4F4F4"  class="freewrite">  &nbsp;&nbsp;&nbsp;&nbsp;첨부파일</td>
			<td bgcolor="#FFFFFF"  class="freewrite">			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:file name="upload" theme="simple" />
			 <s:if test="resultClass.file_orgname != NULL">
                     &nbsp; * <s:property value="resultClass.file_orgname" />파일이 등록되어 있습니다. 다시 업로드하면 기존의 파일은 삭제됩니다.
                 </s:if></td>
		</tr>

	<tr>
			<td height="2" colspan="2"></td>
		</tr>


		<tr>
			<td height="10" colspan="2"></td>
		</tr>


		<tr>
			<td align="right" colspan="2">
 			   <input name="submit" type="submit" value="작성완료" class="inputb">
 			   <input name="list" type="button" value="목록" class="inputb"
					onClick="javascript:location.href='listAction.action?currentPage=<s:property value="currentPage"/>'"/></td>
		</tr>
	</table>
	</div>
</body>
</html>