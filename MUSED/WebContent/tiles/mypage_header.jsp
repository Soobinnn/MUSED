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
			<!-- �̹������� �̹��� �ø��� -->
			<div style="position: absolute;">
				<div style="position: relative; top: 20px; left: 100px;">
					<table width="100%">
						<tr height="100px">
							<td width="20%" align="center">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;������ ���� <br> <img
								class="circle" id="blah"
								src="C:\Java\upload\file_<s:property value="%{#session.ID}"/>.jpg"
								width="150" height="150" /><br>
							<input type="file" id="imgInp" name="upload" size=2><input
								type="submit" value="�ٲٱ�">
							</td>
							<td width="10%"></td>
							<td width="35%" align="left">���̵�: <s:property
									value="%{#session.ID}" /> <br> ���:<s:property value="%{grade}"/>(<s:property value="%{paramClass.score}"/>) <br>
								VVIP <br> VIP <br> GOLD <br> SILVER <br>
								BRONZE .....s <br>������: <s:property
									value="%{#session.JOINDATE}" />
							</td>
							<td width="35%" align="left">��ϵ� ��ǰ:<s:property value="%{countPro}"/><br> ��ϵ� ���:<s:property value="%{countTal}"/><br>
								���� ��ǰ:2<br> �Ǹ� ����:<s:property value="%{sum}"/><br>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<!-- ����� �� �̹��� -->
			<img src="images/background.jpg" width="1500px" height="230px" align="center"></img>
		</div>
	</form>
</body>
</html>