<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

등록된 상품:<s:property value="%{countPro}"/><br>
등록된 재능:<s:property value="%{countTal}"/><br>
찜한 상품:<br>
판매 내역:<s:property value="%{sum}"/><br>


</body>
</html>