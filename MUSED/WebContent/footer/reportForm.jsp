<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
        			<option value="ct">사기</option>
        			<option value="sw">욕설</option>
        			<option value="ad">광고</option>
        		</select>
           	</td>
        </tr>
        <tr>
         	<td width="100" bgcolor="#F4F4F4"><font color="#FF0000">*</font>  본인 아이디</td>
        	<td width="500" bgcolor="#FFFFFF">
            	<s:textfield name="report_memid" theme="simple" value="%{resultClass.report_memid}" cssStyle="width:370px" maxlength="50"/>
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
        	<td bgcolor="#F4F4F4"><font color="#FF0000">*</font> 신고 게시판번호 </td>
        	<td bgcolor="#FFFFFF">
        	<s:textfield name="report_contno" theme="simple" value="%{resultClass.report_contno}" cssStyle="width:100px" maxlength="20"/>
          	</td>
        </tr>
        <tr bgcolor="#777777">
        	<td height="1" colspan="2"></td>	
        </tr>
        <tr>
        	<td bgcolor="#F4F4F4"><font color="#FF0000">*</font>  내용 </td>
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
        
        <tr>
          <td height="10" colspan="2"></td>
        </tr>

        <tr>
          <td align="right" colspan="2">    
          	<input name="submit" type="submit" value="작성" class="inputb">
            <input name="list" type="button" value="취소" class="inputb" >
          </td>
        </tr>

    </table>
    </form>
</body>
</html>