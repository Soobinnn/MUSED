<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/MUSED/css/productList.css"/>
</head>
<body align="center">
<br/><br/><br/><br/>
상품 등록이 완료되었습니다.
<br/><br/>
<input name="product_list" type="button" value="상품 목록보기" class="inputb" onClick="javascript:location.href='productList.action?currentPage=1&sort=0'"/>
<input name="product_list" type="button" value="메인 화면으로" class="inputb" onClick="javascript:location.href='main.action'"/>
</body>
</html>