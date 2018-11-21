<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

  <html xmlns="http://www.w3.org/1999/xhtml">
 
 <head>
   <title>게시판 오류 발생</title>
  <link rel="stylesheet" href="/MUSED/css/board.css"/>
 </head>
 
 <body>
<div id="board" align="center">
  <h2 >게시판 오류 발생</h2>
     <table width="600" align="center" border="0" cellspacing="0" cellpadding="0">
   
   <tr>
     <td align="center"><br></br>게시판에 오류가 발생했습니다. 관리자에게 문의바랍니다.</td>
   </tr>
   
   <tr>
     <td>&nbsp;</td>
   </tr>
   
   <tr>
     <td align="center">
     <input name="free_list" type="button" value="자유 게시판 목록으로" class="inputb" onClick="javascript:location.href='listAction.action'"/>
   </td>
   </tr>
   
   </table>
     </div>
     </body>
 </html>