<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

회원 이미지<br>
아이디:<s:property value="%{id}"/><br>
등급:<s:property value="%{grade}"/>
(<s:property value="%{paramClass.score}"/>)<br>


</body>
</html>