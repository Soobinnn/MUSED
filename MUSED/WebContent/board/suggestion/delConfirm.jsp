<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>삭제 확인</title>

<link rel="stylesheet" href="/MUSED/css/board.css"/>
<script language="javascript">
<!-- 버튼클릭시 javascript 호출합니다. -->
function javascript(){
    self.close();  
}
</script>

</head>
  
  <body>
  
  	<h1 align="center">게시글 삭제 확인</h1><br></br>
 <table align="center" width="100%">
   <form action="checkAction.action" method="post">
          <tr>
          <td align="center">
       자유게시판 게시글을 삭제하시겠습니까?
   		</td>
		</tr>
  <tr>
    <td align="center">
     <s:hidden name="no" value="%{no}"/>  <!-- 글 번호 전송 -->
     <s:hidden name="currentPage" value="%{currentPage}"/> <!-- 수정 후 리스트로 넘어가지 않도록 -->
     <br>
    <input name="submit" type="submit" value="확인" class="inputb">

  &nbsp; 
  <input type='button' onclick='javascript()' value='취소'/>  <!-- 두 번째 버튼(취소) 작성 -->   
   </input>
 </td></tr>
</form>
</table>
  </body>
  </html>