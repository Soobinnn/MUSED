<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<title>마이페이지헤더</title>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#imgInp").on('change', function() {
			readURL(this);
		});
	});

	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#blah').attr('src', e.target.result);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}
</script>

<link rel="stylesheet" href="/MUSED/css/testtest.css"/>
</head>
<body>
	<div id="heading" >
			<h1>마이페이지</h1>
	</div>
	<form method="post" enctype="multipart/form-data"
		action="updateProfile.action">
		<div id="myheading">
			<!-- 이미지위에 이미지 올리기 -->
			<div style="position: absolute;">
				<div style="position: relative; top: 20px; left: 100px;">
					<table width="100%">
						<tr height="100px">
							<td width="20%" align="center">

								<font class="profileimg">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;프로필 사진</font> <br/> <img
								class="circle" id="blah"
								src="/MUSED/mypage/image/file_<s:property value="%{#session.ID}"/>.jpg"
									width="150" height="150" /><br/><br/>
								<button class="replace" id="imgIn">이미지 업로드</button> <input type="file"
								class="upload" id="imgInp" name="upload" accept="/MUSED/mypage/image/*"> &nbsp;<input
								type="submit" class="in" value="확인">
							</td>
							
							<td width="20%"></td>
							<td width="40%" align="left"><font class="profileimg">ID : </font><s:property
									value="%{#session.ID}" /> <br><font class="profileimg">등급: </font>
								<s:if test="#session.ACCESS_NUM == 1">
									<img class="border"
										src="/MUSED/tiles/image/supervisor.jpg" width="15"
										height="15" />
								</s:if> <s:if
									test="#session.ACCESS_NUM != 1 && paramClass.score >= 0 && paramClass.score < 100">
									<img class="border" src="/MUSED/tiles/image/bronze.png"
										width="15" height="15" />
								</s:if> <s:if
									test="#session.ACCESS_NUM != 1 && paramClass.score >= 100 && paramClass.score < 150">
									<img class="border" src="/MUSED/tiles/image/silver.png"
										width="15" height="15" />
								</s:if> <s:if
									test="#session.ACCESS_NUM != 1 && paramClass.score >= 150 && paramClass.score < 200">
									<img class="border" src="/MUSED/tiles/image/gold.png"
										width="15" height="15" />
								</s:if> <s:if
									test="#session.ACCESS_NUM != 1 && paramClass.score >= 200 && paramClass.score < 500">
									<img class="border" src="/MUSED/tiles/image/vip.png"
										width="15" height="15" />
								</s:if> <s:if test="%{#session.ACCESS_NUM == 1}">관리자</s:if> <s:else>
									<s:property value="%{grade}" />
								</s:else>(<s:property value="%{paramClass.score}" />) 
						
							
								<img id="light"
								class="border" src="/MUSED/tiles/image/grade.png"
								width="15" height="15" />
								<p id="arrow_box">
									<img class="border" src="/MUSED/tiles/image/bronze.png"
										width="15" height="15" />&nbsp;BRONZE : ~99<br> <img
										class="border" src="/MUSED/tiles/image/silver.png"
										width="15" height="15" />&nbsp;SILVER : ~149<br> <img
										class="border" src="/MUSED/tiles/image/gold.png"
										width="15" height="15" />&nbsp;GOLD : ~199<br> <img
										class="border" src="/MUSED/tiles/image/vip.png"
										width="15" height="15" />&nbsp;VIP : ~499<br> <img
										class="border" src="/MUSED/tiles/image/supervisor.jpg"
										width="15" height="15" />&nbsp;관리자<br>
								</p>  <font class="profileimg">가입일:</font> <s:property value="%{#session.JOINDATE}" />
							</td>
							<td width="20%" align="left" id="list"><br/>
														<font class="profileimg">등록된 상품 : </font><s:a href="javascript:location.href='myProduct.action'"><s:property value="%{countPro}" /></s:a><br>
														  <font class="profileimg">등록된 재능 : </font><s:a href="javascript:location.href='myTalent.action'"><s:property value="%{countTal}" /></s:a><br>
														 <font class="profileimg"> 찜 목록 &nbsp; &nbsp;&nbsp;&nbsp;: </font><s:property value="%{zzimCount}"/><br>
														<font class="profileimg">  판매 내역&nbsp; &nbsp;: </font><s:property value="%{sum}" /><br>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<!-- 배경이 될 이미지 -->
			<img src="/MUSED/tiles/images/background3.jpg" width="1500" height="270px"
				align="center"></img>
		</div>
	</form>
</body>
</html>