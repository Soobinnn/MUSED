<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

회원 이미지<br>
아이디:<s:property value="%{id}"/><br>
등급:<s:property value="%{grade}"/>
(<s:property value="%{paramClass.score}"/>)<br>


</body>
</html>