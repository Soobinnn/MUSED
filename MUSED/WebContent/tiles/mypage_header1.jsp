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

ȸ�� �̹���<br>
���̵�:<s:property value="%{id}"/><br>
���:<s:property value="%{grade}"/>
(<s:property value="%{paramClass.score}"/>)<br>


</body>
</html>