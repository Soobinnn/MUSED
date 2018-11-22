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

<!-- 이 페이지에서만 style적용하는 것. 절대 style.css로 합치지 말것. -->
<style>
.in { /*input tag 공통 스타일*/
	width: 100px;
	height: 30px;
	border-radius: 10px;
	font-weight: 600;
	border-color: transparent;
	font-size: 12px;
	background: black;
	color: #fff;
	cursor: pointer;
}

.upload {
	width: 100px;
	height: 30px;
	border-radius: 10px;
	font-weight: 600;
	border-color: transparent;
	font-size: 12px;
	background: black;
	color: #fff;
	cursor: pointer;
	opacity: 0; /*input type="file" tag 투명하게 처리*/
	position: relative;
}

.replace { /*button tag 에 원하는 스타일 적용*/
	position: absolute;
	width: 100px;
	height: 30px;
	border-radius: 10px;
	font-weight: 600;
	border-color: transparent;
	font-size: 12px;
	background: hotpink;
	color: #fff;
	cursor: pointer;
}

.circle {
	border-radius: 1200px !important;
	overflow: hidden;
	width: 128px;
	height: 128px;
	border: 8px solid rgba(255, 255, 255, 0.7);
	position: relative;
	top: 0px;
}

.border {
	border-radius: 50%;
}
</style>
<!-- 이 페이지에서만 style적용하는 것. 절대 style.css로 합치지 말것. -->

</head>
<body>
	<div id="heading" >
			<h1>마이페이지</h1>
	</div>
	<form method="post" enctype="multipart/form-data"
		action="updateProfile.action">
		<div>
			<!-- 이미지위에 이미지 올리기 -->
			<div style="position: absolute;">
				<div style="position: relative; top: 20px; left: 100px;">
					<table width="100%">
						<tr height="100px">
							<td width="20%" align="center">


								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;프로필 사진 <br> <img
								class="circle" id="blah"
								src="/MUSED/mypage/image/file_<s:property value="%{#session.ID}"/>.jpg"

								width="150" height="150" /><br>
								<button class="replace">이미지 업로드</button> <input type="file"
								class="upload" id="imgInp" name="upload" accept="/MUSED/mypage/image/*"><input

								type="submit" class="in" value="확인">
							</td>
							<td width="10%"></td>
							<td width="35%" align="left">아이디: <s:property
									value="%{#session.ID}" /> <br>등급: <s:if
									test="#session.ACCESS_NUM == 1">
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
								</s:else>(<s:property value="%{paramClass.score}" />) <img
								class="border" src="/MUSED/tiles/image/grade.png"
								width="15" height="15" />
								<p class="arrow_box">
									<img class="border" src="/MUSED/tiles/image/bronze.png"
										width="15" height="15" />BRONZE : ~99<br> <img
										class="border" src="/MUSED/tiles/image/silver.png"
										width="15" height="15" />SILVER : ~149<br> <img
										class="border" src="/MUSED/tiles/image/gold.png"
										width="15" height="15" />GOLD : ~199<br> <img
										class="border" src="/MUSED/tiles/image/vip.png"
										width="15" height="15" />VIP : ~499<br> <img
										class="border" src="/MUSED/tiles/image/supervisor.jpg"
										width="15" height="15" />관리자<br>
								</p> <br> 가입일: <s:property value="%{#session.JOINDATE}" />
							</td>
							<td width="35%" align="left">등록된 상품:<s:a href="javascript:location.href='myProduct.action'"><s:property value="%{countPro}" /></s:a><br>
														  등록된 재능:<s:a href="javascript:location.href='myTalent.action'"><s:property value="%{countTal}" /></s:a><br>
														  찜 목록:<s:property value="%{zzimCount}"/><br>
														  판매 내역:<s:property value="%{sum}" /><br>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<!-- 배경이 될 이미지 -->
			<img src="/MUSED/tiles/images/background3.jpg" width="1500px" height="230px"
				align="center"></img>
		</div>
	</form>
</body>
</html>