<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/MUSED_MUSED/tiles/style.css">
<meta charset="EUC-KR">
<title>Insert title here</title>

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

<style>
.circle {
	border-radius: 1200px !important;
	overflow: hidden;
	width: 128px;
	height: 128px;
	border: 8px solid rgba(255, 255, 255, 0.7);
	position: relative;
	top: 0px;
}
</style>

</head>
<body>
	<form method="post" enctype="multipart/form-data"
		action="updateProfile.action">
		<div>
			<!-- 이미지위에 이미지 올리기 -->
			<div style="position: absolute;">
				<div style="position: relative; top: 20px; left: 100px;">
					<table width="100%">
						<tr height="100px">
							<td width="20%" align="center">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;프로필 사진 <br> 
								<img class="circle" id="blah"
								src="C:\Java\upload\file_<s:property value="%{#session.ID}"/>.jpg"
								width="150" height="150" /><br>
							<input type="file" id="imgInp" name="upload" size=2><input
								type="submit" value="바꾸기">
							</td>
							<td width="10%"></td>
							<td width="35%" align="left">아이디: <s:property
									value="%{#session.ID}" /> <br> 등급:<s:property value="%{grade}"/>(<s:property value="%{paramClass.score}"/>) <br>
								VVIP <br> VIP <br> GOLD <br> SILVER <br>
								BRONZE .....s <br>가입일: <s:property
									value="%{#session.JOINDATE}" />
							</td>
							<td width="35%" align="left">등록된 상품:<s:property value="%{countPro}"/><br> 등록된 재능:<s:property value="%{countTal}"/><br>
								찜한 상품:2<br> 판매 내역:<s:property value="%{sum}"/><br>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<!-- 배경이 될 이미지 -->
			<img src="images/background.jpg" width="1500px" height="230px" align="center"></img>
		</div>
	</form>
</body>
</html>