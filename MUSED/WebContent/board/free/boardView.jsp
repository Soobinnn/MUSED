<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
.size{border:solid 0px; position:absolute; float:left; overflow:hidden; width:824; height:1800;
top:500; left:410;}

.border {
	border-radius: 50%;
}
</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>자유 게시판</title>
<link rel="stylesheet" href="/StrutsBoard/board/common/css/css.css" type="text/css">

<script type="text/javascript">
  function open_win_noresizable(url, name){
          var oWin = window.open(url, name, "scrollbars=no, status=no, resizable=no, width=300, height=150");
                                           }
</script>
</head>

<%-- jsp파일에서의 주석은 웬만하면 %를 이용하도록 한다. --%>


<body>
	<s:hidden name="currentPage" value="%{currentPage}" />
	<table width="950" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td align="center"><h2>자유 게시판</h2></td>
		</tr>
	</table>

	<table width="950" border="0" cellspacing="0" cellpadding="5">
		<tr bgcolor="#777777">
			<td colspan="8" height="1"></td>
		</tr>

		<tr>
			<%-- <td width="100">번호</td>
			<td width="500"><s:property value="resultClass.no" /></td> --%>
		</tr>

		<tr>
			<td width="70">제목</td>	<td colspan="3" width="450"><s:property value="resultClass.subject" /></td>
		    <td width="100">이름</td><td width="100"><s:property value="resultClass.name" /></td>
		    <td width="100">조회수</td><td width="50"><s:property value="resultClass.readhit"/></td>
       </tr>


		       <tr>
		　　　<td colspan="8" align="right"><s:property value="resultClass.regdate"/></td>
		</tr>
		<tr>
			<td width="70" height="250">내용</td>
			<td colspan ="7" width="1000"><pre>${resultClass.content}</pre></td>
		
		
		
		

		<tr>
			<td width="70">첨부파일</td>
			<td colspan="7" width="1000">&nbsp;&nbsp; <s:url id="download"
					action="fileDownloadAction">
					<s:param name="no">
						<s:property value="no" />
					</s:param>
				</s:url> <s:a href="%{download}">
					<s:property value="resultClass.file_orgname" />
				</s:a>
			</td>
		</tr>

		<tr bgcolor="#777777">
			<td colspan="8" height="1"></td>
		</tr>

		<tr>
			<td colspan="8" height="10"></td>
		</tr>

		
		<%-- 댓글달기 폼 추가 --%>
		<tr>
			<td colspan="8" height="10">
				<form action="writeCommentAction.action" method="post">
					<table>
						<tr>
							<td width="170">이 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름 
							
							<font color="#3B0B0B"><s:property value="%{#session.ID}" /></font>
		                    <input type="hidden" name="name" value="<s:property value='%{#session.ID}' />"/> <%-- DB 입력을 위해 name값을 hidden으로 보낸다. --%>
							
							
						<s:hidden name="originno" value="%{resultClass.no}" /> <%-- 게시글 글 번호 전송 --%>
							
							<%-- 댓글 관련 글번호 전송 --%>
							<s:hidden name="no" value="%{resultClass.no}" /> <%-- 글 번호 전송 --%>
							<s:hidden name="currentPage" value="%{currentPage}" /> <%-- 현재 페이지 전송 --%>

							<%-- 댓글 내용 영역 --%>
							<td align="left"><s:textarea name="content" theme="simple"
							                       		value="" cols="100" rows="3" /></td>
						</tr>

						<tr>
							<s:if test="#session.ID != null">
						   <td colspan="8" align="right"><input name="submit"
								type="submit" value="작성완료" class="inputb"></td>
						    </s:if>
						    <s:else>
						    :)
						    </s:else>
						
						</tr>
					</table>
				</form>
			</td>
		</tr>

		<tr bgcolor="#777777">
			<td colspan="8" height="1"></td>
		</tr>

		<s:iterator value="commentlist" status="stat">

			<tr>
				<td height="10" width="130" align="center">
				<img class="border" id="blah" src="/MUSED/mypage/image/thum_<s:property value="name"/>.jpg"  width="50px" height="50px"/><br>
				<s:property
						value="name" /><br> <s:property value="regdate" /><br>
				<br></td>

				<td>
					<%-- !!!!!!!!!!!!!!!!코멘트 삭제!!!!!!!!!!!!!!!! --%>
					
					
					<s:property value="content" />
				
			    <s:if test="#session.ID == name || #session.ACCESS_NUM == 1">
        <%--원래 삭제 버튼인 x 주석처리--%>
        <%-- <a href='deleteAction2.action?no=<s:property value="no" />&originno=<s:property value="originno" />&currentPage=<s:property value="currentPage" />'>x</a> --%>
			
		
		<input type="button" value="삭제" onClick="javascript:window.open('checkForm2.action?no=<s:property value="no" />&originno=<s:property value="originno" />&currentPage=<s:property value="currentPage" />','cdelete','width=450, height=100')">
		        </s:if>
		   <s:else>             
		<%--작성자본인이나 관리자가 아니면 삭제버튼이 보이지 않게 한다. --%>
       	  </s:else>
			  </td>
			</tr>

			<tr bgcolor="#777777">
				<td colspan="8" height="1"></td>
			</tr>

		</s:iterator>

		<tr>
			<td colspan="8" height="10">
			   <s:if test="commentlist.size() <=0"> 댓글없음
      </s:if>
      </td>
		</tr>
		</table>
<table width="950" border="0" cellspacing="0" cellpadding="5">
		<tr bgcolor="#777777">
			<td colspan="8" height="1"></td>
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
				
				
				
				<%-- id세션 값이 같거나 관리자에게만  답글, 수정, 삭제 버튼이 보이도록 수정한다. --%>
				
				<s:if test="#session.ID == resultClass.name || #session.ACCESS_NUM == 1">			
				<input name="list" type="button" value="답변달기" class="inputb" onClick="javascript:location.href='replyAction.action?no=<s:property value="no" />&currentPage=<s:property value="currentPage" />','reply'">
				
				<input name="list" type="button" value="수정" class="inputb" onClick="javascript:location.href='modifyForm.action?no=<s:property value="no" />&currentPage=<s:property value="currentPage"/>'">
	 
                <input type="button" value="삭제" onClick="javascript:window.open('checkForm.action?no=<s:property value="resultClass.no" />&currentPage=<s:property value="currentPage" />','delete','width=450, height=100')">

                <%--    window.open("파일명", "윈도우이름","창속성"); 또는 "javascript:window.open('파일명 및 경로', '윈도우 이름', '창 속성')" 이렇게 쓸 수도 있다.--%>
</s:if>
		<s:else>             
			       	  </s:else>
			
            	
	<input name="list" type="button" value="목록" class="inputb" onClick="javascript:location.href='listAction.action?currentPage=<s:property value="currentPage" />'">
 
			</td>
		</tr>
	</table>
</body>
</html>