<%@ page contentType="text/html; charset=utf-8" %>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript">
		function locationURL() 
		{
			window.opener.parent.location.href='/MUSED/tiles/main.action';
			alert("신고가 접수되었습니다.");
			window.close();
		}
	</script>
</head>
  
<body>
  	<script>locationURL()</script>
</body>
</html>