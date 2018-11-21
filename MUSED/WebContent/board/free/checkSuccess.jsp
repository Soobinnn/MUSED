<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>확인</title>
<link rel="stylesheet" href="/MUSED/css/board.css"/>	
<script type="text/javascript">
  function locationURL(){
  
     if(window.name =='modify'){ /* 새 창의 이름이 modify라면  modifyForm.action으로 이동한다. */
        window.opener.parent.location.href='modifyForm.action?no=<s:property value="no"
        		/>&currentPage=<s:property value="currentPage"/>';
       
     }else if (window.name =='delete'){
        
        			alert('삭제되었습니다.');
        			window.opener.parent.location.href='deleteAction.action?no=<s:property value="no"
                		/>&currentPage=<s:property value="currentPage"/>';
                		
        }else if(window.name =='cdelete'){
        	  alert('코멘트가 삭제되었습니다.');
        	  window.opener.parent.location.href="deleteAction2.action?no=<s:property value="no" />&originno=<s:property value="originno" />&currentPage=<s:property value="currentPage" />";
        }
        
        window.close();
        }
        </script>
   </head>
  
  <body>
    <script>locationURL()</script>
  </body>
</html>