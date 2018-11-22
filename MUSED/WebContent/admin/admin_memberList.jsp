<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="/MUSED/css/testtest.css"/>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
	<title>회원목록</title>
</head>
<body>
	<div id="heading" >
			<h1>회원관리</h1>
	</div>
	
	<div id="main">
	<div class="container">
		<section class="admin admin_body">

		<table width="600" border="0" cellspacing="0" cellpadding="2">
			<tr>
				<td align="center"><h2>회원관리</h2></td>
			</tr>
			<tr>
				<td height="20"></td>
			</tr>
		</table>
		<form name="frm2" action="/MUSED/admin_processAction.action" method="post"
			enctype="multipart/form-data">
			<table width="820" border="0" cellspacing="0" cellpadding="2">
				<tr align="center" bgcolor="#F3F3F3">
					<td width="50"><strong>구분</strong></td>
					<td width="100"><strong>ID</strong></td>
					<td width="100"><strong>이름</strong></td>
					<td width="100"><strong>등급(점수)</strong></td>
					<td width="150"><strong>이메일</strong></td>
					<td width="100"><strong>가입날짜</strong></td>
					<td width="100"><strong>접근권한</strong></td>
				</tr>
				<tr bgcolor="#777777">
					<td height="1" colspan="8"></td>
				</tr>

				<s:iterator value="list" status="stat">
					<s:url id="viewURL" action="viewAction">
						<s:param name="id">
							<s:property value="id" />
						</s:param>
						<s:param name="currentPage">
							<s:property value="currentPage" />
						</s:param>
					</s:url>


					<tr id="admin_membertr"bgcolor="#FFFFFF" align="center">
						<td><input type="checkbox" name="check" value="<s:property value='id'/>" /></td>
						<td><s:property value="id" /></td>
						<td><s:property value="name" /></td>
						<td><s:property value="score" /></td>
						<td align="center"><s:property value="email" /></td>
						<td align="center"><s:property value="joindate" /></td>
						<td align="center"><s:property value="access_num" /></td>
					</tr>

					<tr bgcolor="#777777">
						<td height="1" colspan="8"></td>
					</tr>
				</s:iterator>

				<s:if test="list.size() <= 0">

					<tr bgcolor="#FFFFFF" align="center">
						<td colspan="5">등록된 회원이 없습니다.</td>
					</tr>
					<tr bgcolor="#777777">
						<td height="1" colspan="5"></td>
					</tr>

				</s:if>

				<tr align="center">
					<td colspan="5"><s:property value="pagingHtml" escape="false" /></td>
				</tr>

				<tr align="right">
					<td colspan="6"><input type="hidden" name="access_num" value="2" /></td> 
					<td><input type="submit" value="블랙" class="inputb" /></td>
				</tr>
				<tr>
				<td colspan="5">
					<!-- 검색 폼 추가 -->
					<form>
						<select name="searchNum">
							<option value="0">아이디</option>
							<option value="1">이름</option>
						</select>
						<s:textfield name="searchKeyword" theme="simple" value="" cssStyle="width:120px" maxlength="20" />
						<input name="submit" type="submit" value="검색" class="inputb" />
					</form>
				</td>
				</tr>
			</table>
		</form>

		</section>
		</div>
		</div>
</body>
</html>