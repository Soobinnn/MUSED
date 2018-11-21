<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- jsp에서 스트럿츠2 태그 라이브러리를 사용하려면 아랫줄 설정 정보를 추가한다. --%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="login.LoginAction" %>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>자유 게시판</title>
<link rel="stylesheet" href="/MUSED/css/board.css"/>

</head>

<body>

	<div>

		<a href='/MUSED/tiles/notice/listAction.action'>공지사항</a>&nbsp;&nbsp; <a href='/MUSED/tiles/free/listAction.action'>자유게시판</a> &nbsp;&nbsp; <a href='/MUSED/tiles/sug/listAction.action'>건의게시판</a>

	<br/><br/><br/><br/><br/><br/><br/>	
	</div>
<div id="board" align="center">
	<table width="600" border="0" cellspacing="0" cellpadding="2">
		<tr><td><br></br><br></br></td></tr>
		<tr>
			<td align="center"><h2>자유 게시판</h2></td>
		</tr>

		<tr>
			<td height="20"></td>
		</tr>
	</table>

	<table width="90%" border="0" cellspacing="0" cellpadding="2">
		<tr height="40" align="center" bgcolor="#F2F2F2">
			<td class="free" width="50"><strong>번호</strong></td>
			<td class="free" width="350"><strong>제목</strong></td>
			<td class="free" width="70"><strong>글쓴이</strong></td>
			<td class="free" width="80"><strong>날짜</strong></td>
			<td class="free" width="50"><strong>조회</strong></td>
		</tr>

		<tr bgcolor="#777777">
			<td height="1" colspan="5"></td>

		</tr>

			
		
		<%-- 자바빈에 있는 메소드를 get메소드를 쓴 효과로 가져온다. --%>
		<s:iterator value="list" status="stat">

			<%-- <s:url id="viewURL" action="viewAction"> --%>
			<s:url id="viewURL" action="viewAction">
				<s:param name="no">
					<s:property value="no"/> <%-- viewAction.java에서 정의한 값을 s:property value를 사용하여 가져온다. --%>
				 
			</s:param>

				<s:param name="currentPage">
					<s:property value="currentPage"/>
				</s:param>
			</s:url>
			
			<tr height="30">
			   <td class="free" align="center"><s:property value="no" /></td>
			   <td class="free" align="left">
			      <s:if test="re_level != 0">
			          <c:forEach var = "i" begin ="${re_level}" end = "0">&nbsp;</c:forEach>→
			      </s:if>
			       <s:a href="%{viewURL}"><s:property value="subject" /></s:a>

				   <s:if test="commentcnt > 0">
			       (<s:property value="commentcnt"/>)
			       </s:if>
			       <s:if test="readhit >= 20">
			       	<img src="./image/hot.gif"/> 
			       </s:if>
			   </td>
			  <td class="free" align="center"> <s:property value="name" /></td>
			 <td class="free" align="center"> <s:property value="regdate" /></td>
			 <td class="free" align="center"><s:property value="readhit" /></td>
             </tr>
             
			<tr bgcolor="#777777">
			     <td height="1" colspan="5"></td>
			</tr>
	</s:iterator>
			

		<s:if test="list.size() <=0">

			<%-- <tr bgcolor="#FFFFFF" align="center"> --%>
			<tr align="center">	
				<td colspan="5">등록된 게시물이 없습니다.</td>
			</tr>
         </s:if>
		<%-- 	<tr bgcolor="#777777">
				<td height="1" colspan="5"></td>
			</tr>

		</s:if> --%>
<tr><td><br></br></td></tr>
		<tr align="center">
			<td colspan="5"><s:property value="pagingHtml" escape="false" /></td>
		</tr>

		<tr align="right">
		
			
		<%--스트럿츠 태그를 사용해서 로그인아이디값을 받아온다. --%>
			<s:if test="#session.ID != null">
			<tr align="right">
				<td colspan="5">                        <%-- 세션아이디값이 있다면(로그인한 상태이면) writeForm으로 이동하도록 한다. --%>
					<input type="button" value="글쓰기" class="inputb" 
					onclick="javascript:location.href='writeForm.action?currentPage=<s:property value="currentPage"/>';"/>
				</td>
			</tr>
			</s:if>
		<s:else>
		  	<tr align="right">
						<td colspan="5">                 <%-- 세션아이디값이 없으면(로그인한 상태가 아니면) 로그인 유도 페이지로 이동하게 한다. --%>
<input type="button" value="글쓰기" class="inputb" onclick="javascript:location.href='/MUSED/tiles/loginForm.action';" />				

						<%-- <input type="button" value="글쓰기" class="inputb">  --%>	
							<%-- onClick="javascript:location.href='/MUSED/tiles/loginForm.action';"/> --%>
						
						</td>
						</tr>
	  </s:else>
			
		<%-- 원래 글쓰기 버튼 주석처리 --%>				
		<%-- 	<td colspan="5"><input type="button" value="글쓰기" class="inputb"
				onClick="javascript:location.href='writeForm.action?currentPage=<s:property value="currentPage"/>';"/>
				</td>
		</tr> --%>
	 

<%--원래 글쓰기 버튼 종료 --%>


	        <%-- 검색 폼 추가 --%>
	 <tr align="center">
	   <td colspan="5">
	 
	 
	 
	        <form>
	               <select name="searchNum">
	                 <option value="0">작성자</option>
	                 <option value="1">제목</option>
	                 <option value="2">내용</option>
	               </select>
	               <s:textfield name="searchKeyword" theme="simple" value="" cssStyle="width:120px" maxlength="20"/>
	               <input name="submit" type="submit" value="검색" class="inputb">
	        </form>
	    </td>
	  </tr>
	  <tr><td><br></br></td></tr>
</table>
</div>
</body>
</html>




