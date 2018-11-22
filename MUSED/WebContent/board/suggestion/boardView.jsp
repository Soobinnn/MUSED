<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="/MUSED/css/board.css"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>건 의 사 항</title>

<script type="text/javascript">
  function open_win_noresizable(url, name){
          var oWin = window.open(url, name, "scrollbars=no, status=no, resizable=no, width=300, height=150");
                                           }
</script>
</head>

<%-- jsp파일에서의 주석은 웬만하면 %를 이용하도록 한다. --%>


<body>
<div id="board" align="center">
	<table width="95%" border="0" cellspacing="0" cellpadding="2">
			<tr><td><br/><br/><br/></td></tr>
		<tr>
			<td align="center"><h2>건 의 사 항</h2></td>
		</tr>
				<tr><td><br/><br/><br/></td></tr>
	</table>

	<table width="85%" border="0" cellspacing="0" cellpadding="5">
		<tr bgcolor="#777777">
			<td colspan="8" height="2"></td>
		</tr>

		<tr>
			<%-- <td width="100">번호</td>
			<td width="500"><s:property value="resultClass.no" /></td> --%>
		</tr>

	<tr height="30">
			<td  class="free" width="70">제목</td><td  class="free" colspan="3" width="450"><s:property value="resultClass.subject" /></td>
		    <td width="100"  class="free">이름</td><td width="100"  class="free"><s:property value="resultClass.name" /></td>
		    <td width="100"  class="free">조회수</td><td width="50"  class="free"><s:property value="resultClass.readhit"/></td>
       </tr>


		<%-- <tr>
			<td width="70">이름</td>
			<td width="1000"><s:property value="resultClass.name" /></td>
		</tr> --%>
        <tr>
		　　　<td colspan="8" align="right"><s:property value="resultClass.regdate"/></td>
		</tr>
		<tr>
			<td width="70" height="250">내용</td>
			<td colspan ="7" width="100"><pre>${resultClass.content}</pre></td>
		
		
		
	

		<%-- <tr>
			<td width="70">조회수</td>
			<td width="1000"><s:property value="resultClass.readhit" /></td>
		</tr> --%>

		<%-- <tr>
			<td width="70">등록날짜</td>
			<td width="1000"><s:property value="resultClass.regdate" /></td>
		</tr>  얘를 어디로 보내지?--%>
<tr>
			<td colspan="8" height="4"></td>
		</tr>
		

		<tr bgcolor="#777777">
			<td colspan="8" height="2"></td>
		</tr>

		<tr>
			<td colspan="8" height="10"></td>
		</tr>

	

		<tr>
			<td colspan="8" align="right">
			<s:url id="modifyURL" action="modifyForm">
					<s:param name="no">
						<s:property value="no" />
					</s:param>
				</s:url> 
				  <s:url id="deleteURL" action="deleteAction">
					<s:param name="no">
						<s:property value="no" />
					</s:param>
				</s:url> 
				
				
		<s:if test="#session.ID == resultClass.name || #session.ACCESS_NUM == 1">			
				<input name="list" type="button" value="답변달기" class="inputb" onClick="javascript:location.href='replyForm.action?no=<s:property value="no" />&currentPage=<s:property value="currentPage" />','reply'">
				
				<input name="list" type="button" value="수정" class="inputb" onClick="javascript:location.href='modifyForm.action?no=<s:property value="no" />&currentPage=<s:property value="currentPage"/>'">
			    <input type="button" value="삭제" onClick="javascript:window.open('checkForm.action?no=<s:property value="resultClass.no" />&currentPage=<s:property value="currentPage" />','delete','width=450, height=100')">
		</s:if>
		<s:else>             
			       	  </s:else>
			    
			    
        <input name="list" type="button" value="목록" class="inputb" onClick="javascript:location.href='listAction.action?currentPage=<s:property value="currentPage" />'">
 
			</td>
		</tr>
		
<tr><td><br><br></td></tr>
	</table>
	</div>
</body>
</html>