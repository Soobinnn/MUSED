<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/MUSED/css/testtest.css"/>
<head>
<meta charset="utf-8">
</head>
<body>
	<section class="admin_nav">
	<ul>
		<li id="admin_navth">관리목록</li>
		<hr/>
			<li><a class="admin_navlist" href="/MUSED/admin_memberlist.action?currentPage=1">회원관리</a></li>
			<li><a class="admin_navlist" href="/MUSED/tiles/notice/admin_notice.action?currentPage=1">공지사항</a></li>
			<li><a class="admin_navlist" href='/MUSED/tiles/admin/listAction.action?currentPage=1'>신고목록</a></li>
	</ul>
	</section>
</body>
</html>