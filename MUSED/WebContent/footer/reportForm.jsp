<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<link rel="stylesheet" href="/MUSED/css/testtest.css"/>
<head>
<title>신고하기</title>
</head>
<body>
  	<table width="600" border="0" cellspacing="0" cellpadding="2">
  		<tr>
  			<td align="center"><h2>신고하기</h2></td>
  		</tr>
  	</table>
  	
  	
  	<s:if test="resultClass == NULL">
		<form action="reportAction.action" method="post" enctype="multipart/form-data" onsubmit="return validation();">
	</s:if> 
	
	
    <table width="600" border="0" cellspacing="0" cellpadding="0">
        <tr>
        	<td align="right" colspan="2"><font color="#FF0000"></td>
        </tr> 
        <tr bgcolor="#777777">
        	<td height="1" colspan="2"></td>
        </tr>
        <tr>
         	<td width="100" bgcolor="#F4F4F4"><font color="#FF0000">*</font>카테고리</td>
        	<td width="500" bgcolor="#FFFFFF">
        		<select name="report_category"> 
        			<option value="사기">사기</option>
        			<option value="욕설">욕설</option>
        			<option value="광고">광고</option>
        		</select>
           	</td>
        </tr>
        <tr>
         	<td width="100" bgcolor="#F4F4F4"><font color="#FF0000">*</font>  본인 아이디</td>
        	<td width="500" bgcolor="#FFFFFF">
        	<s:if test='%{#session.ID == null}'> <%--ID세션값이 없으면 ID란을 공란으로 한다. --%>
            	<%-- <s:textfield name="report_memid" theme="simple" value="%{resultClass.report_memid}" cssStyle="width:370px" maxlength="50"/> --%>
          	</s:if>
          	<s:else> <%--ID세션값이 있으면(로그인한 상태이면) --%>
          		<s:property value="%{#session.ID}"/>
          		<input type="hidden" name="name" value="<s:property value='%{#session.ID}' />"/>
          		<input type="hidden" name="report_memid" theme="simple" value="%{#session.ID}" cssStyle="width:370px" maxlength="50"/>
        	</s:else>			
          	</td>
        </tr>
        
        		
        <tr>
         	<td width="100" bgcolor="#F4F4F4"><font color="#FF0000">*</font>  제목</td>
        	<td width="500" bgcolor="#FFFFFF">
            	<s:textfield name="report_subject" theme="simple" value="%{resultClass.report_subject}" cssStyle="width:370px" maxlength="50"/>
          	</td>
        </tr>							
        <tr bgcolor="#777777">
         	<td height="1" colspan="2"></td>
        </tr>
        
        <tr>
         	<td bgcolor="#F4F4F4"><font color="#FF0000">*</font>신고할 아이디 </td>
         	<td bgcolor="#FFFFFF">
            	<s:textfield name="report_reportid" theme="simple" value="%{resultClass.report_reportid}" cssStyle="width:100px" maxlength="20"/>
         	</td>
        </tr>
        <tr bgcolor="#777777">
        	<td height="1" colspan="2"></td>	
        </tr>
        <tr>
        	<td bgcolor="#F4F4F4"><font color="#FF0000">*</font> 신고 게시글번호 </td>
        	<td bgcolor="#FFFFFF">
        	<s:textfield name="report_contno" theme="simple" value="%{resultClass.report_contno}" cssStyle="width:100px" maxlength="20"/>
          	</td>
        </tr>
        <tr bgcolor="#777777">
        	<td height="1" colspan="2"></td>	
        </tr>
        <tr>
        	<td bgcolor="#F4F4F4"><font color="#FF0000">*</font> 내용 </td>
        	<td bgcolor="#FFFFFF">
            <s:textarea name="report_content" theme="simple" value="%{resultClass.report_content}" cols="50" rows="10" />
          	</td>
        </tr> 
        <tr bgcolor="#777777">
         	<td height="1" colspan="2"></td>
        </tr>
        <tr>
        	<td bgcolor="#F4F4F4">  첨부사진 </td>
        	<td bgcolor="#FFFFFF">
            <s:file name="upload" theme="simple"/>
            <s:if test="resultClass.file_orgname != NULL">
		&nbsp; * <s:property value="resultClass.file_orgname" /> 파일이 등록되어 있습니다. 다시 업로드하면 기존의 파일은 삭제됩니다.
			</s:if>			
          </td>
        </tr>
        <tr bgcolor="#777777">
          <td height="1" colspan="2"></td>	
        </tr>
        	<input type="hidden" name="report_state" value="처리중"></input>
        <tr>
          <td height="10" colspan="2"></td>
        </tr>

        <tr>
          <td align="right" colspan="2">    
          	
          	<%--로그인한 사람과 관리자에게만 작성 버튼이 보이도록 수정 --%>
          	<s:if test="#session.ACCESS_NUM ==0 || #session.ACCESS_NUM ==1">
          	<input name="submit" type="submit" value="작성" class="inputb">
            </s:if>
               <s:else>
                  </s:else>
            <input name="list" type="button" value="취소" class="inputb" onclick="window.parent.close();">
          </td>
        </tr>

    </table>
    </form>
</body>
</html>