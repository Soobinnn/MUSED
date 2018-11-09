<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>재능 상세보기</title>


<script type="text/javascript">

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
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1} 
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none"; 
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block"; 
  dots[slideIndex-1].className += " active";
}

</script>
<style>

* {box-sizing:border-box}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

/* Hide the images by default */
.mySlides {
   display: none;
}

/* Next & previous buttons */
 .prev, .next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  margin-top: -22px;
  padding: 16px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
}

/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
  background-color: rgba(0,0,0,0.8);
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  cursor: pointer;
  height: 50px;
  width: 50px;
  margin: 0 2px;
  background-color: #808080;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

 .active, .dot:hover {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}
</style>

</script>
</head>
<body>
	제목 :	&nbsp;&nbsp;	<s:property value="resultClass.talent_subject"/>
<br>
		
<table width="100%" height="400" border="0">
<tr>
<td width="60%" align="middle">
<div class="slideshow-container">
		<s:iterator value="image" status="stat">
		  <!-- Full-width images with number and caption text -->
		  <div class="mySlides fade">
		    <img src="<s:property/>" style="width:300px; height:300px"/>
		  </div>
		</s:iterator>
	</div>
</td>

<td width="40%" height="250">
상품 카테고리 : <s:property value="resultClass.talent_category"/><br>
제목 : <s:property value="resultClass.talent_subject"/><br>
제품명 : <s:property value="resultClass.talent_name"/><br>
가격 : <s:property value="resultClass.talent_price"/><br>
</td>
</tr>
<tr>
<td width="60%">
<table width="130px" height="100%" border="1" align="center">
 <tr>
 <s:subset source="image" count="4">
	<s:iterator status="stat">	
	<td >
		<img src='<s:property/>' style="height: 100px; width: 100px; display: block;" onclick="currentSlide(<s:property value='#stat.index+1'/>)"/>
	</td>
	</s:iterator>
	</s:subset>
</tr>
</table>
</td>
<td width="40%">
판매자 정보<br>
판매자 : <s:property value="resultClass.talent_id"/><br>
이메일 : <br>
판매자 연락처 : <s:property value="resultClass.talent_phone"/><br>
거래 선호 지역 : <s:property value="resultClass.talent_sido"/>&nbsp;
			<s:property value="resultClass.talent_gogon"/>
<br>
</td>
</tr>
<tr>
<td colspan="2">
<hr style="color:gray"/>
</td>
</tr>

<tr>
<td colspan="2">
<s:property value="resultClass.talent_content"/>

</td>
</tr>

<tr>
<td colspan="2">
<hr style="color:gray"/>
</td>
</tr>

<tr>
<td colspan="2">
댓글 추가..
</td>
</tr>

<tr>
<td colspan="2">
<table width="60%" height="150" border="1" align="center">

	 <tr>

<!-- 리스트로 출력 말고 no 값 받아서 그 뒤에 5개의 main_image 가져와서 출력시키기! -->
 	   	<s:iterator value="list" status="stat">
	   	  	      		      	<s:url id="DetailURL" action="talentDetail">
									<s:param name="talent_no">
										<s:property value="talent_no"/>
									</s:param>
								</s:url>
      	      	      <td>	 
      	      	      &nbsp;<s:a href="%{DetailURL}">
      	      			<img src="/MUSED/talent/img/<s:property value="main_img"/>" style="height: 100px; width: 100px; display: block;"/></s:a>
				</td>
						</s:iterator> 


	</tr>
</table>
</td>
</tr>


<tr>
<td colspan="2">
		<input name="list" type="button" value="목록" class="inputb" onClick="javascript:location.href='talent/talentList.action'"/>
		<input name="update" type="button" value="수정하기" class="inputb" onClick="javascript:location.href='talentUpdateForm.action?talent_no=<s:property value="talent_no"/>&currentPage=<s:property value="currentPage"/>'"/>
		<input name="delete" type="button" value="삭제하기" class="inputb" onClick="javascript:location.href='talentDelete.action?talent_no=<s:property value="talent_no"/>&currentPage=<s:property value="currentPage"/>'"/>

</td>
</tr>

</table>
</body>
</html>