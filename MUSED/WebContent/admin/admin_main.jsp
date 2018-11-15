<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<link rel="stylesheet" href="test.css">
<head>
<meta charset="utf-8">
<title>관리자 페이지</title>
</head>
<body>
		<div class ="container">
		<section class="admin admin_nav">
			<ul>
				<li>관리목록</li>
				<hr/>
				<li><a href="#">회원관리</a></li>
				<li><a href="#">공지사항</a></li>
				<li><a href='/MUSED/tiles/admin/listAction.action'>신고목록</a></li>
			</ul>
		</section>
		<section class="admin admin_body">
			<h1><s:property value="%{#session.NAME}"/> 관리자님, 안녕하세요.</h1>
			<a href="#"><img src="member.png" width="200" height="200"/></a>
			<a href="#"><img src="notice.png" width="200" height="200"/></a>			
			<a href='/MUSED/admin/listAction.action'><img src="report.jpg" width="200" height="200"/></a>
			<br/>
			<table width="600" border="1" cellspacing="0" cellpadding="0" >
				<tr>
				<td align="center">회원관리</td> <td align="center">공지사항</td> <td align="center">신고목록</td>
				</tr>
			</table>
		</section>
		</div>
</body>
</html>