<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>악기 입력 폼</title>
</head>
<body>


	<s:if test="resultClass == NULL">
			<form action="productWrite.action" method="post" enctype="multipart/form-data" onsubmit="return validation();">
		</s:if>
		
<%-- 		<s:else>
		  <form action="modifyAction.action" method="post" enctype="multipart/form-data">
		  <s:hidden name="no" value="%{resultClass.no}" />
		  <s:hidden name="currentPage" value="%{currentPage}" />
		  <s:hidden name="old_file" value="%{resultClass.file_savname}" />
		</s:else> --%>
		

       <table width="800" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><font color="#FF0000">*</font>는 필수 입력사항입니다.</td>
          <td bgcolor="#FFFFFF">
            <s:textfield name="product_id" theme="simple" value="%{resultClass.product_id}" cssStyle="width:100px" maxlength="50"/>
          </td>
          
        </tr>
        
        <tr bgcolor="#777777">
          <td height="1" colspan="2"></td>
        </tr>
        <tr>
          <td bgcolor="#F4F4F4"><font color="#FF0000">*</font>  판매 상태</td>
          <td bgcolor="#FFFFFF">
          <!-- 나중에 checkbox 선택 시 저장.. 이런거 다시 구현 -->
			<input type="radio" checked="checked" name="product_state" value="현">판매중</input>
			<input type="radio" name="product_state" value="완">판매 완료</input>
          </td>
        </tr>
        <tr bgcolor="#777777">
          <td height="1" colspan="2"></td>	
        </tr>
				
        <tr>
          <td width="200" bgcolor="#F4F4F4"><font color="#FF0000">*</font>   카테고리</td>
          <td>
          
          <!-- 나중에 category 선택 시 저장.. 이런거 다시 구현 -->
       			<select name="product_category">
					<option value="classic">클래식(관악기/현악기)</option>
					<option value="guiter">기타</option>
					<option value="drum">드럼/타악기</option>
					<option value="piano">건반악기</option>
					<option value="sound">음향악기</option>
					<option value="etc">그 외 악기</option>
					
				</select>
		
       	</td>
       </tr>							
        <tr bgcolor="#777777">
          <td height="1" colspan="2"></td>
        </tr>
        
        <tr>
          <td bgcolor="#F4F4F4"><font color="#FF0000">*</font>  상품 판매 형식</td>
          <td bgcolor="#FFFFFF">
          <!-- 나중에 checkbox 선택 시 저장.. 이런거 다시 구현 -->
			<input type="checkbox" name="product_type" value="직">일반형(비배송형)</input>
			<input type="checkbox" name="product_type" value="포">배송형(택배 비 포함)</input>
			<input type="checkbox" name="product_type" value="미">배송형(택배 비 미포함)</input>
          </td>
        </tr>
        <tr bgcolor="#777777">
          <td height="1" colspan="2"></td>	
        </tr>
 
    	<tr>
          <td bgcolor="#F4F4F4"><font color="#FF0000">*</font>  제목</td>
          <td bgcolor="#FFFFFF">
            <s:textfield name="product_subject" theme="simple" value="%{resultClass.product_subject}" cssStyle="width:100px" maxlength="50"/>
          </td>
        </tr>
        <tr bgcolor="#777777">
          <td height="1" colspan="2"></td>	
        </tr>
     
        <tr>
          <td bgcolor="#F4F4F4"><font color="#FF0000">*</font>  상품명</td>
          <td bgcolor="#FFFFFF">
            <s:textfield name="product_name" theme="simple" value="%{resultClass.product_name}" cssStyle="width:100px" maxlength="50"/>
          </td>
        </tr>
        <tr bgcolor="#777777">
          <td height="1" colspan="2"></td>	
        </tr>
        	
        <tr>
          <td bgcolor="#F4F4F4">  브랜드 및 모델명</td>
          <td bgcolor="#FFFFFF">
            <s:textfield name="product_brand" theme="simple" value="%{resultClass.product_brand}" cssStyle="width:100px" maxlength="50"/>
          </td>
        </tr>
        <tr bgcolor="#777777">
          <td height="1" colspan="2"></td>	
        </tr>
        	
        <tr>
          <td bgcolor="#F4F4F4"><font color="#FF0000">*</font>  가격</td>
          <td bgcolor="#FFFFFF">
            <s:textfield name="product_price" theme="simple" value="%{resultClass.product_price}" cssStyle="width:100px" maxlength="20"/>원
          </td>
        </tr>
        <tr bgcolor="#777777">
          <td height="1" colspan="2"></td>	
        </tr>
        
        
        <tr>
          <td bgcolor="#F4F4F4">  거래 시 연락처</td>		<!-- 연락처 그냥 한줄로 받을지,,, 아니면 010-0000-0000 3개로 받아서 합치거나 그냥 출력해줄지... -->
          <td bgcolor="#FFFFFF">
            <s:textfield name="product_phone" theme="simple" value="%{resultClass.product_phone}" cssStyle="width:100px" maxlength="11"/>
          </td>
        </tr>
        <tr bgcolor="#777777">
          <td height="1" colspan="2"></td>	
        </tr>
        <tr>
          <td bgcolor="#F4F4F4">  거래 선호 지역</td>  <!-- 시도, 구군, 동 으로 나누는 방법 생각해보기 -->
          <td bgcolor="#FFFFFF">
            <s:textfield name="product_sido" theme="simple" value="%{resultClass.product_sido}" cssStyle="width:100px" maxlength="7"/>
            <s:textfield name="product_gogon" theme="simple" value="%{resultClass.product_gogon}" cssStyle="width:100px" maxlength="10"/>
          </td>
        </tr>
       
        <tr bgcolor="#777777">
          <td height="1" colspan="2"></td>	
        </tr> 

        <tr>
          <td bgcolor="#F4F4F4">  메인 사진 등록</td>  <!-- 시도, 구군, 동 으로 나누는 방법 생각해보기 -->
          <td bgcolor="#FFFFFF">
             <s:file name="upload"/>   	      
          </td>
        </tr>
        <tr>
          <td bgcolor="#F4F4F4">  추가 사진 등록</td>  <!-- 시도, 구군, 동 으로 나누는 방법 생각해보기 -->
          <td bgcolor="#FFFFFF">
             <s:file name="upload"/>  
             <s:file name="upload"/>  
             <s:file name="upload"/>  
             <s:file name="upload"/>   	      
          </td>
        </tr>
        
         
		<tr>
          <td bgcolor="#F4F4F4"><font color="#FF0000">*</font>  상품 상세 설명 </td>
          <td bgcolor="#FFFFFF">
            <s:textarea name="product_content" theme="simple" value="%{resultClass.product_content}" cols="50" rows="10" />
          </td>
        </tr>
        <tr bgcolor="#777777">
          <td height="1" colspan="2"></td>
        </tr>
        
        
        <tr>
          <td align="right" colspan="2">
          	<input name="submit" type="submit" value="작성완료" class="inputb">
            <input name="list" type="button" value="목록" class="inputb" onClick="javascript:location.href='listAction.action?currentPage=<s:property value="currentPage" />'">
          </td>
        </tr>

    </table>
    </form>


</body>
</html>