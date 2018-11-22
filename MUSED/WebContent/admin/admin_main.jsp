<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<link rel="stylesheet" href="/MUSED/css/testtest.css"/>
<head>
<meta charset="utf-8">
<title>관리자 페이지</title>
</head>
<body>
		<div id="heading" >
			<h1>관리자 페이지</h1>
		</div>
		<h1 id="admin_text"><s:property value="%{#session.NAME}"/> 관리자님, 안녕하세요.</h1>
		<div class="admin_testimonials">
		
		<section>
				<div class="content">
				<a href="/MUSED/admin_memberlist.action?currentPage=1"><img src="/MUSED/css/member.png" width="200" height="200"/></a>
				<p>회원관리</p>
				</div>
		</section>
		<section>
				<div class="content">
				<a href="/MUSED/tiles/notice/admin_notice.action?currentPage=1"><img src="/MUSED/css/notice.png" width="200" height="200"/></a>
				<p>공지사항</p>
				</div>
		</section>
		<section>
				<div class="content">
				<a href='/MUSED/tiles/admin/listAction.action?currentPage=1'><img src="/MUSED/css/report1.png" width="200" height="200"/></a>	
				<p>신고목록</p>
				</div>
		</section>
		</div>
		
		
		


</body>
</html>