<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>재능 상세보기</title>

<link rel="stylesheet" href="/MUSED/css/productList.css"/>

<script type="text/javascript">


function btn(currentPage, no){
	if(confirm("경고! 수정 버튼을 누르면 원본 파일은 사라집니다.")){
		location.href="talentUpdateForm.action?talent_no="+no+"&currentPage="+currentPage;
	}else{
		return false;
	}
	}

 function open_win_noresizable(url,name){
	var oWin = window.open(url, name, "scrollbars=no,status=no, resizable=no, width=300, height=150");
}

var slideIndex = 1;
showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
  showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
	
  showSlides(slideIndex = n);

  
}
function showSlides(n) {
	document.getElementById("img").style.display ='none';
	
  var i;
  var slides = document.getElementsByClassName("mySlides")
  if (n > slides.length) {slideIndex = 1} 
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none"; 
  }
  slides[slideIndex-1].style.display = "block"; 
}

function zzim_hagi(){
	alert("찜하기가 완료되었습니다.");
}
</script>
</head>
<body>
<div id="main" align="center">
    <table width="80%" height="70" border="0">
<s:hidden name="currentPage" value="%{currentPage}" />
<tr><td colspan="2"> <br></br></td></tr>
<tr>
<td align="right" width="30%">
<s:if test='resultClass.talent_state=="현"'>
		<img src="/MUSED/product/ui_img/현재진행중.png" style="width:50px;height:50px"/>
	</s:if>
		<s:if test='resultClass.talent_state=="완"'>
		<img src="/MUSED/product/ui_img/판매완료.png" style="width:50px;height:50px"/>
	</s:if>
		</td>
	<td align="left" width="70%">
	<h3 class="DetailSubject">
	&nbsp;&nbsp;;
	<s:property value="resultClass.talent_subject"/></h3>
</td>
</tr>
<tr>
	<td colspan="2" align="right">
	조회수 : &nbsp; &nbsp;<s:property value="resultClass.readhit"/>
	&nbsp;&nbsp;<input name="list" type="button" value="찜하기" class="inputb" onclick="zzim_hagi();javascript:location.href='talentZzim.action?zzim_contno=<s:property value="talent_no"/>&zzim_indexno=2'">
	</td>
</tr>
</table>
<table width="80%" height="400" border="10">
<tr>
				<td width="50%" align="center" height="250">
				
 <img id="img"src="<s:property value="resultClass.main_img"/>" style="width:350px; height:350px"/> 


<div class="slideshow-container">
		<s:subset source="image" count="4">
			<s:iterator status="stat">
		  <!-- Full-width images with number and caption text -->
		  <div class="mySlides fade">
		    <img id="imgs" src='<s:property/>' style="width:350px; height:350px"/>
		  </div>
		</s:iterator>
		</s:subset>
	</div>
	<br/>
<table width="100px" border="1" align="center">
 <tr>
 <s:subset source="image" count="4">
	<s:iterator status="stat">	
	<td >
		<img src='<s:property/>' style="height: 100px; width: 100px; display: block;" onclick="currentSlide(<s:property value='#stat.index+1'/>)"/>
	</td><td>&nbsp;</td>
	</s:iterator>
	</s:subset>
</tr>
</table>
	
</td>

<td width="50%" height="250">
<div class="detail">
				<s:iterator value="type" status="stat">
							<img src='<s:property/>' style="width:40px; height:40px"/>
							<!-- image로 출력하기 -->
						</s:iterator><br>
					<input type="checkbox" id="cateLabel">
   			 	<label for="cateLabel"><s:property value="resultClass.talent_category" /></label></input>
   			<br><br>
					&nbsp;&nbsp;<h3 class="DetailSubject">	<s:property value="resultClass.talent_subject" /><br/></h3>
						<br/><br/>
						&nbsp;&nbsp; 제품명 : <s:property value="resultClass.talent_name" /><br/><br/>
						&nbsp;&nbsp; 브랜드 : <s:property value="resultClass.talent_brand" /><br/><br/>
						&nbsp;&nbsp; 가격 : <s:property value="resultClass.talent_price" />원<br/><br/><br/><br/>
						&nbsp;판매자 정보<br/><br/> 
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img class="circle" id="blah"
						src="C:\Java\upload\file_<s:property value="resultClass.talent_id"/>.jpg"
						width="150" height="150" /><br><br/> 
						&nbsp;&nbsp; 판매자 : <s:property
								value="resultClass.talent_id" /><br><br/>
						&nbsp;&nbsp; 판매자 연락처 : <s:property value="resultClass.talent_phone" /><br><br/>
										&nbsp;&nbsp; 거래 선호 지역 : <s:property value="resultClass.talent_sido" />&nbsp;
										<s:property value="resultClass.talent_gogon" /> <br>
				</div>
</td>
</tr>

			<tr>
				<td colspan="3">
				<br></br>
				</td>
			</tr>
			<tr bgcolor="#777777">
				<td colspan="3" height="3">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<br></br>
				</td>
			</tr>
			<tr><td>상품 설명 :</td></tr>
			<tr>
				<td id="Pcontent" colspan="2">
				<br/>
				<s:property 
						value="resultClass.talent_content" /></td>
			</tr>
			<tr>
				<td colspan="3">
				<br></br>
				</td>
			</tr>
			<tr bgcolor="#777777">
				<td colspan="2" height="2">
				</td>
			</tr>
<!-- 댓글 입력 -->
<tr>
<td colspan="2" height="10">

<form action="TwriteCommentAction.action" method="post">
			<table align="center">
				<tr>
					<td width="170">
						<br/>&nbsp; 아이디 : <s:property value="%{#session.ID}"/>
					</td>
					<s:hidden name="c_contnum" value="%{resultClass.talent_no}" />
					<s:hidden name="talent_no" value="%{resultClass.talent_no}" />
					<s:hidden name="currentPage" value="%{currentPage}"/>
					<td align="left">
						<s:textarea name="c_content" value="" id="p_comment"/>
					</td>
					<td colspan="2" align="right">
						<input name="submit" type="submit" value="작성완료" class="inputb" style="width:120px"><br/><br/>
					</td>
				</tr>
					<tr bgcolor="#777777">
								<td colspan="2" height="2"></td>
							</tr>
<!-- 댓글 리스트 -->
		<table width="100%">
<s:iterator value="TcommentList" status="stat">
	<tr>
			<td width="20%" align="center"><br/>
			<img class="circle"	id="blah" src="C:\Java\upload\file_<s:property value="c_id"/>.jpg" width="50" height="50" /><br> 
			<s:property value="c_id"/><br>
			<s:property value="c_regdate"/><br><br>
		</td>
		<td width="70%" align="center"><br/><br/><br/><br/>
			<s:property value="c_content"/></td>
			<td width="70%" align="center"><br/><br/><br/><br/>
				<s:url id="DeleteURL" action="deleteTComment">
					<s:param name="c_no">
						<s:property value="c_no"/>
					</s:param>
					<s:param name="c_id">
						<s:property value="%{#session.ID}"/>
					</s:param>
					<s:param name="talent_no">
						<s:property value="talent_no"/>
					</s:param>
					<s:param name="currentPage">
						<s:property value="currentPage"/>
					</s:param>
				</s:url>
			<s:a href="%{DeleteURL}">X</s:a></td>

		</td>
	</tr>
	<tr bgcolor="#777777">
		<td colspan="3" height="1"></td>
	</tr>	
	</s:iterator>
	<tr>
		<td colspan="2" height="10">
			<s:if test="TcommentList.size() <= 0">
			댓글 없음
			</s:if>
		</td>
	</tr>

<!-- 댓글 -->

<tr>
<td align="center" colspan="2">
<table width="60%" height="150" border="1" align="center">

		 <tr>
 <s:subset source="Mainlist">
	<s:iterator status="stat">	
	   	  	      		      	<s:url id="DetailURL" action="talentDetail">
									<s:param name="talent_no">
										<s:property value="talent_no"/>
									</s:param>
								</s:url>
      	      	      <td>	 
      	      	      &nbsp;<s:a href="%{DetailURL}">
      	      			<img src="/MUSED/talent/img/<s:property value="main_img"/>" style="height: 100px; width: 100px; display: block;"/></s:a>
			</td><td>&nbsp;&nbsp;</td>
						</s:iterator>
						</s:subset>
	</tr>
</table>
</td>
</tr>


<tr align="right">
<td colspan="2">
      <s:if test="%{#session.ID==resultClass.talent_id}">
		<input type="button" value="수정하기" class="inputb" onclick='btn(<s:property value="currentPage"/>,<s:property value="talent_no"/>)'/>
		<input name="delete" type="button" value="삭제하기" class="inputb" onClick="javascript:location.href='talentDelete.action?talent_no=<s:property value="talent_no"/>&currentPage=<s:property value="currentPage"/>'"/>
	</s:if>
		<input name="list" type="button" value="목록" class="inputb" onClick="javascript:location.href='talent/talentList.action'"/>
</td>
</tr>			<tr><td colspan="2"><br></br></td></tr>

</table>
</div>
</body>
</html>