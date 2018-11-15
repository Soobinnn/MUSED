<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>삭제 확인</title>
	<link rel="stylesheet" href="/StrutsBoard/board/common/css/css.css" type="text/css">

<script language="javascript">
<!-- 버튼클릭시 javascript 호출합니다. -->
function javascript(){
    self.close();   <!-- 자기자신창을 닫습니다. -->
}
</script>

</head>
  
  <body>
  
  	<h2>삭제 확인</h2>
  <table>
   <form action="checkAction.action" method="post">
     <s:hidden name="no" value="%{no}"/>  <!-- 글 번호 전송 -->
     <s:hidden name="currentPage" value="%{currentPage}"/> <!-- 수정 후 리스트로 넘어가지 않도록 -->
     
    <input name="submit" type="submit" value="확인" class="inputb">
   

  &nbsp; 
  <input type='button' onclick='javascript()' value='취소'/>  <!-- 두 번째 버튼(취소) 작성 -->   
   </input>
 
</form>
</table>
  </body>
  </html>