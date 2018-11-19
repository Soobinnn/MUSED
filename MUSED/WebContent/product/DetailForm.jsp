<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URI"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<?xml version="1.0" encoding="UTF-8" ?>




<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>악기 상세보기</title>


<script type="text/javascript">

function btn(){
    alert("경고! 수정 버튼을 누르면 원본 파일은 사라집니다.");
}

 function open_win_noresizable(url,name){
	var oWin = window.open(url, name, "scrollbars=no,status=no, resizable=no, width=300, height=150");
 }

var slideIndex = 1;
showSlides(slideIndex);


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
<style>
* {
	box-sizing: border-box
}

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
	background-color: rgba(0, 0, 0, 0.8);
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

@
-webkit-keyframes fade {
	from {opacity: .4
}

to {
	opacity: 1
}

}
@
keyframes fade {
	from {opacity: .4
}

to {
	opacity: 1
}

}
.circle {
	border-radius: 1200px !important;
	overflow: hidden;
	width: 80px;
	height: 80px;
	border: 8px solid rgba(255, 255, 255, 0.7);
	position: relative;
	top: 0px;
}
</style>

</head>
<body>

	<s:hidden name="currentPage" value="%{currentPage}" />

	제목 : &nbsp;&nbsp;(
	<s:property value="resultClass.product_state" />
	)
	<s:property value="resultClass.product_subject" />
	<br> 조회수 : &nbsp; &nbsp;<s:property value="resultClass.readhit" />

		
	<input name="list" type="button" value="찜하기" class="inputb" onclick="zzim_hagi();javascript:location.href='productZzim.action?zzim_contno=<s:property value="product_no"/>&zzim_indexno=1'">



		<table width="100%" height="400" border="1">

			<tr>
				<td width="60%" align="middle"><img id="img"
					src="<s:property value="resultClass.main_img"/>"
					style="width: 350px; height: 350px" />

					<div class="slideshow-container">
						<s:subset source="image" count="4">
							<s:iterator status="stat">

								<!-- Full-width images with number and caption text -->
								<div class="mySlides fade">
									<img src="<s:property/>" style="width: 350px; height: 350px" />

								</div>
							</s:iterator>
						</s:subset>
					</div></td>

				<td width="40%" height="250">상품 카테고리 : <s:property
						value="resultClass.product_category" /><br> 택배 : <s:iterator
							value="type" status="stat">
							<s:property />
							<!-- image로 출력하기 -->
						</s:iterator> <br> 제목 : <s:property value="resultClass.product_subject" /><br>
								제품명 : <s:property value="resultClass.product_name" /><br>
									브랜드 : <s:property value="resultClass.product_brand" /><br>
										가격 : <s:property value="resultClass.product_price" /><br></td>
			</tr>
			<tr>
				<td width="60%">
					<table width="130px" height="100%" border="1" align="center">
						<tr>
							<s:subset source="image" count="4">
								<s:iterator status="stat">
									<td><img src='<s:property/>'
										style="height:100px; width:100px; display:block;"
										onclick="currentSlide(<s:property value='#stat.index+1'/>)" />
									</td>
								</s:iterator>
							</s:subset>
						</tr>
					</table>
				</td>
				<td width="40%">판매자 정보<br> <img class="circle" id="blah"
						src="C:\Java\upload\file_<s:property value="resultClass.product_id"/>.jpg"
						width="150" height="150" /><br> 판매자 : <s:property
								value="resultClass.product_id" /><br> 이메일 : <br> 판매자
									연락처 : <s:property value="resultClass.product_phone" /><br>
										거래 선호 지역 : <s:property value="resultClass.product_sido" />&nbsp;
										<s:property value="resultClass.product_gogon" /> <br></td>
			</tr>
			<tr>
				<td colspan="2">
					<hr style="color: gray" />
				</td>
			</tr>

			<tr>
				<td colspan="2">상품 설명 : <s:property
						value="resultClass.product_content" /> <br></td>
			</tr>

			<tr>
				<td colspan="2">
					<hr style="color: gray" />
				</td>
			</tr>
			<!-- 댓글 입력 -->
			<tr>
				<td colspan="2" height="10">

					<form action="writeCommentAction.action" method="post">
						<table align="center">
							<tr>
								<td width="170">아이디 : <s:property value="%{#session.ID}" />
								</td>
								<s:hidden name="c_contnum" value="%{resultClass.product_no}" />
								<s:hidden name="product_no" value="%{resultClass.product_no}" />
								<s:hidden name="currentPage" value="%{currentPage}" />
								<td align="left"><s:textarea name="c_content"
										theme="simple" value="" cols="60" rows="3" /></td>
							</tr>
							<tr>
								<td colspan="2" align="right"><input name="submit"
									type="submit" value="작성완료" class="inputb"></td>
							</tr>
							<tr bgcolor="#777777">
								<td colspan="2" height="1"></td>
							</tr>
							<s:iterator value="commentList" status="stat">
								<tr>
									<td width="170" align="center"><img class="circle"
										id="blah"
										src="C:\Java\upload\file_<s:property value="c_id"/>.jpg"
										width="50" height="50" /><br> <s:property value="c_id" /><br>
												<s:property value="c_regdate" /><br><br></td>
									<td><s:property value="c_content" /> <s:url
											id="DeleteURL" action="deletePComment">
											<s:param name="c_no">
												<s:property value="c_no" />
											</s:param>
											<s:param name="c_id">
												<s:property value="%{#session.ID}" />
											</s:param>
											<s:param name="product_no">
												<s:property value="product_no" />
											</s:param>
											<s:param name="currentPage">
												<s:property value="currentPage" />
											</s:param>
										</s:url> <s:a href="%{DeleteURL}">X</s:a></td>
								</tr>
								<tr bgcolor="#777777">
									<td colspan="2" height="1"></td>
								</tr>
							</s:iterator>
							<tr>
								<td colspan="2" height="10"><s:if
										test="commentList.size() <= 0">
			댓글 없음
			</s:if></td>
							</tr>
						</table>
					</form>

				</td>
			</tr>

			<tr bgcolor="#777777">
				<td colspan="2" height="1"></td>
			</tr>

			<tr>
				<td colspan="2">
					<table width="60%" height="150" border="1" align="center">

						<tr>
							<s:subset source="Mainlist">
								<s:iterator status="stat">
									<s:url id="DetailURL" action="productDetail">
										<s:param name="product_no">
											<s:property value="product_no" />
										</s:param>
									</s:url>
									<td>&nbsp;<s:a href="%{DetailURL}">
											<img src="/MUSED/product/img/<s:property value="main_img"/>"
												style="height: 100px; width: 100px; display: block;" />
										</s:a>
									</td>
								</s:iterator>
							</s:subset>
						</tr>
					</table>
				</td>
			</tr>

			<tr>
				<td colspan="2"><input name="list" type="button" value="목록"
					class="inputb"
					onClick="javascript:location.href='product/productList.action?currentPage=<s:property value="currentPage"/>'" />
					<s:if test="%{#session.ID==resultClass.product_id}">
						<input name="update" type="button" value="수정하기" class="inputb"
							onClick="javascript:location.href='productUpdateForm.action?product_no=<s:property value="product_no"/>&currentPage=<s:property value="currentPage"/>'" />
						<input name="delete" type="button" value="삭제하기" class="inputb"
							onClick="javascript:location.href='productDelete.action?product_no=<s:property value="product_no"/>&currentPage=<s:property value="currentPage"/>'" />
					</s:if></td>
			</tr>
		</table>
</body>
</html>